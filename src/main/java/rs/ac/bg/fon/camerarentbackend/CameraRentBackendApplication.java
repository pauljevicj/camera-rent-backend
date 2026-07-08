package rs.ac.bg.fon.camerarentbackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class CameraRentBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(CameraRentBackendApplication.class, args);
    }

}
