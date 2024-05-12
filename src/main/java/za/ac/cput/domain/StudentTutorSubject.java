package za.ac.cput.domain;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class StudentTutorSubject {
    @EmbeddedId
    private StudentTutorSubjectID id;

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

    public StudentTutorSubjectID getId() {
        return id;
    }

    public Student getStudent() {
        return student;
    }

    public Tutor getTutor() {
        return tutor;
    }

    public Subject getSubject() {
        return subject;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentTutorSubject that = (StudentTutorSubject) o;
        return Objects.equals(id, that.id) && Objects.equals(student, that.student) && Objects.equals(tutor, that.tutor) && Objects.equals(subject, that.subject);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, student, tutor, subject);
    }
}
