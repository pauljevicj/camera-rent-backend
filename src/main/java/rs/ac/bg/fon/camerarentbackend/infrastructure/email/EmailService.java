package rs.ac.bg.fon.camerarentbackend.infrastructure.email;

import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import rs.ac.bg.fon.camerarentbackend.core.rental.entity.Rental;


@Service
@RequiredArgsConstructor
public class EmailService {

    private final JavaMailSender mailSender;

    public void sendExpiredRentalMail(String email, Rental rental) {

        SimpleMailMessage message = new SimpleMailMessage();

        message.setTo(email);
        message.setSubject("Camera rental expired");

        message.setText("""
            Dear customer,

            Your rental has expired.

            Please return the camera as soon as possible.

            Regards,
            Camera Rent
            """);

        mailSender.send(message);
    }

}
