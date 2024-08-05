package za.ac.cput.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Entity
@Getter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Inheritance(strategy = InheritanceType.JOINED)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;
    @NotNull
    protected String firstName;
    @NotNull
    protected String lastName;
    @NotNull
    protected String password;
    @NotNull
    protected String phoneNumber;
    @Column(unique = true)
    @NotNull
    protected String email;


}
