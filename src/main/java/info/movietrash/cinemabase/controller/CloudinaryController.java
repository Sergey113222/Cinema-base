package info.movietrash.cinemabase.controller;

import info.movietrash.cinemabase.service.CloudinaryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/cloud")
public class CloudinaryController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    CloudinaryService cloudinaryService;

    @PostMapping("/upload")
    public @ResponseBody
    String upload(@RequestHeader(value = "authToken") String authToken, @RequestHeader(value = "email") String email, @RequestParam("file") MultipartFile file) {
        return cloudinaryService.upload(authToken, email, file);
    }

    @PostMapping("/uploadAvatar")
    public @ResponseBody
    String uploadAvatar(@RequestHeader(value = "authToken") String authToken, @RequestHeader(value = "email") String email, @RequestHeader(value="isAvatarSinglePerson") String isAvatarSinglePerson, @RequestParam("file") MultipartFile file) {
        return cloudinaryService.uploadAvatar(authToken, email, isAvatarSinglePerson, file);
    }

    @GetMapping("/downloadImg/{publicId}/{width}/{height}")
    public @ResponseBody
    ResponseEntity<ByteArrayResource> downloadImg(@PathVariable String publicId, @PathVariable int width, @PathVariable int height) {
        return cloudinaryService.downloadImg(publicId, width, height, false);
    }

    @GetMapping("/downloadAvatar/{publicId}/{size}")
    public @ResponseBody
    ResponseEntity<ByteArrayResource> downloadAvatar(@PathVariable String publicId, @PathVariable int size) {
        return cloudinaryService.downloadImg(publicId, size, size, true);
    }
}
