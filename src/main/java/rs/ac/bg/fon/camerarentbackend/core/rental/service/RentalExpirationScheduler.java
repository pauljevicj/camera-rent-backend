package rs.ac.bg.fon.camerarentbackend.core.rental.service;

import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import rs.ac.bg.fon.camerarentbackend.core.rental.entity.Rental;
import rs.ac.bg.fon.camerarentbackend.core.rental.entity.RentalStatus;
import rs.ac.bg.fon.camerarentbackend.core.rental.repository.RentalRepository;
import rs.ac.bg.fon.camerarentbackend.infrastructure.email.EmailService;

import java.time.LocalDate;
import java.util.List;

@Component
@RequiredArgsConstructor
public class RentalExpirationScheduler {

    private final RentalRepository rentalRepository;
    private final EmailService emailService;

    @Scheduled(cron = "0 0 8 * * *")
//    @Scheduled(cron = "*/30 * * * * *")
    public void checkExpiredRentals() {

        List<Rental> expired =
                rentalRepository.findExpired(
                        LocalDate.now()
                );

        for (Rental rental : expired) {

            emailService.sendExpiredRentalMail(
                    rental.getClient().getAccount().getEmail(),
                    rental
            );

            rental.setStatus(RentalStatus.EXPIRED);
        }

        rentalRepository.saveAll(expired);
    }

}
