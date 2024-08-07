package za.ac.cput.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@EqualsAndHashCode
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private String description;
    @NotNull
    private Integer rating;
    @JoinColumn(name = "student_id")
    @OneToOne(cascade = CascadeType.ALL)
    @NotNull
    private Student author;
    @JoinColumn(name = "tutor_id")
    @OneToOne(cascade = CascadeType.ALL)
    @NotNull
    private Tutor tutor;
}
