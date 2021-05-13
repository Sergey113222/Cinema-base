package info.movietrash.cinemabase.сloudinary;

import com.cloudinary.Cloudinary;
import com.cloudinary.SingletonManager;
import com.cloudinary.utils.ObjectUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;


@SpringBootApplication
@EnableScheduling
public class AppApplication {
    private static final Logger logger = LoggerFactory.getLogger(AppApplication.class);

    public static void main(String[] args) {
        logger.info("Application started!");

        Cloudinary cloudinary = new Cloudinary(ObjectUtils.asMap(
                "cloud_name", "movietrash",
                "api_key", "884541213829115",
                "api_secret", "QVdUpPqy-2mTiNcBV2Tit6ZKy-o"));
        SingletonManager manager = new SingletonManager();
        manager.setCloudinary(cloudinary);
        manager.init();

        SpringApplication.run(AppApplication.class, args);
    }
}
