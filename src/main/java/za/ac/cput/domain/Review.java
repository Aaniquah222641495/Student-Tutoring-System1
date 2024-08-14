package za.ac.cput.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@EqualsAndHashCode
@Table(uniqueConstraints = {
        @UniqueConstraint(
                name = "UniqueStudentAndTutor" , columnNames = {"tutor_id" ," student_id"}
        )
})
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private String description;
    @NotNull
    @Min(0)
    @Max(5)
    private Integer rating;
    @JoinColumn(name = "student_id", referencedColumnName = "student_id")
    @ManyToOne(cascade = CascadeType.ALL)
    @NotNull
    private Student author;
    @JoinColumn(name = "tutor_id", referencedColumnName = "tutor_id")
    @ManyToOne(cascade = CascadeType.ALL)
    @NotNull
    private Tutor tutor;
}
