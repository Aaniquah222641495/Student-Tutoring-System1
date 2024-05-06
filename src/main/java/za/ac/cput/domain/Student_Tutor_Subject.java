package za.ac.cput.domain;

import jakarta.persistence.*;

@Entity
public class Student_Tutor_Subject {
    @EmbeddedId
    private Student_Tutor_Subject_ID id;

    @ManyToOne
    @MapsId("student_id")
    @JoinColumn(name = "student_id")
    private Student student;

    @ManyToOne
    @MapsId("tutor_id")
    @JoinColumn(name = "tutor_id")
    private Tutor tutor;

    @ManyToOne
    @MapsId("subject_code")
    @JoinColumn(name = "subject_code")
    private Subject subject;




}
