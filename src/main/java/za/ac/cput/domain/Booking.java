package za.ac.cput.domain;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Builder
@Getter
@EqualsAndHashCode
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer booking_id;
    public LocalDateTime startTime;
    public LocalDateTime endTime;
    @OneToOne
    @JoinColumn(name = "tutor_id")
    public Tutor tutor;
    @OneToOne
    @JoinColumn(name = "student_id")
    public Student student;
    @OneToOne
    @JoinColumn(name = "subject_id")
    public Subject subject;
    public String topic;

    public Booking() {}

}
