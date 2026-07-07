package rs.ac.bg.fon.camerarentbackend.core.client.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import rs.ac.bg.fon.camerarentbackend.core.account.entity.Account;
import rs.ac.bg.fon.camerarentbackend.core.city.entity.City;

@Entity
@Getter
@Setter
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String surname;

    private String phoneNumber;

    @Enumerated(EnumType.STRING)
    private ClientType clientType;

    @ManyToOne
    @JoinColumn(name = "city_id", nullable = false)
    private City city;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "account_id", referencedColumnName = "id", nullable = false)
    @NotNull(message = "Account is mandatory")
    private Account account;
}
