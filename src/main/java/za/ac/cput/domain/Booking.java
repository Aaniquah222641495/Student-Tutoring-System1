package za.ac.cput.domain;

import jakarta.persistence.*;
import lombok.*;
import za.ac.cput.domain.enums.Status;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@EqualsAndHashCode
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookingId;
    private LocalTime startTime;
    private LocalTime endTime;
    private LocalDate date;
    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "tutor_id", referencedColumnName = "tutor_id")
    private Tutor tutor;
    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "student_id", referencedColumnName = "student_id")
    private Student student;
    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "subject_id", referencedColumnName = "subject_id")
    private Subject subject;
    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "location_id", referencedColumnName = "location_id")
    private Location location;
    private String topic;
    private Status status;


}
