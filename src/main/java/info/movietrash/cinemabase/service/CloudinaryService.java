package info.movietrash.cinemabase.service;

import com.cloudinary.Cloudinary;
import com.cloudinary.Singleton;
import com.cloudinary.Transformation;
import com.cloudinary.utils.ObjectUtils;
import info.movietrash.cinemabase.model.User;
import info.movietrash.cinemabase.repository.UserRepository;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.net.URL;
import java.util.Map;

    @Service
    public class CloudinaryService {

        private final org.slf4j.Logger logger = LoggerFactory.getLogger(this.getClass());
        private final Cloudinary cloudinary = Singleton.getCloudinary();

        @Autowired
        UserService userService;

        @Autowired
        private UserRepository userRepository;

        public String upload(String authToken, String email, MultipartFile file) {
            logger.trace("Called CloudinaryService.upload with args: " + authToken + ", " + email + " and the multipart file");
            User user = userService.getUser(authToken, email);
            if (user != null) {
                try {
                    Map uploadResult = cloudinary.uploader().upload(file.getBytes(), ObjectUtils.emptyMap());
                    String publicId = uploadResult.get("public_id").toString();
                    logger.info("The user " + email + " successfully uploaded the file: " + publicId);
                    return publicId;
                } catch (Exception ex) {
                    logger.error("The user " + email + " failed to load to Cloudinary the image file: " + file.getName());
                    logger.error(ex.getMessage());
                    return null;
                }
            } else {
                logger.error("Error: a not authenticated user tried to upload a file (email: " + email + ", authToken: " + authToken + ")");
                return null;
            }
        }

        public String uploadAvatar(String authToken, String email, String isAvatarSinglePerson, MultipartFile file) {
            User user = userService.getUser(authToken, email);
            if (user != null) {
                String publicId = upload(authToken, email, file);
                if ("true".equalsIgnoreCase(isAvatarSinglePerson)) {
                    user.setAvatar_SinglePerson_PublicID(publicId);
                } else {
                    user.setAvatar_Collective_PublicID(publicId);
                }
                userRepository.save(user);
                logger.info("Saved the new avatar for the user: " + email);
                return publicId;
            } else {
                logger.warn("Cannot authenticate the user " + email + " to upload him/her avatar");
                return null;
            }
        }

        public ResponseEntity<ByteArrayResource> downloadImg(String publicId, int width, int height, boolean isAvatar) {

            logger.info("Requested to download the image file: " + publicId);

            // Generates the URL
            String format = "jpg";
            Transformation transformation = new Transformation().width(width).height(height).crop("fill");
            if (isAvatar) {
                // transformation = transformation.gravity("face").radius("max");
                transformation = transformation.radius("max");
                format = "png";
            }
            String cloudUrl = cloudinary.url().secure(true).format(format)
                    .transformation(transformation)
                    .publicId(publicId)
                    .generate();

            logger.debug("Generated URL of the image to be downloaded: " + cloudUrl);

            try {
                // Get a ByteArrayResource from the URL
                URL url = new URL(cloudUrl);
                InputStream inputStream = url.openStream();
                byte[] out = org.apache.commons.io.IOUtils.toByteArray(inputStream);
                ByteArrayResource resource = new ByteArrayResource(out);

                // Creates the headers
                HttpHeaders responseHeaders = new HttpHeaders();
                responseHeaders.add("content-disposition", "attachment; filename=image.jpg");
                responseHeaders.add("Content-Type", "image/jpeg");

                return ResponseEntity.ok()
                        .headers(responseHeaders)
                        .contentLength(out.length)
                        .body(resource);

            } catch (Exception ex) {
                logger.error("FAILED to download the file: " + publicId);
                return null;
            }
        }
    }
