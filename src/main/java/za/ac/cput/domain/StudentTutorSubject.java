package za.ac.cput.domain;

import jakarta.persistence.*;

import java.util.Objects;

@Deprecated
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

    public StudentTutorSubject() {
    }

    public StudentTutorSubject(Builder builder) {
        this.id = builder.id;
        this.subject = builder.subject;
        this.tutor = builder.tutor;
        this.student = builder.student;
    }

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

    public static class Builder{
        private StudentTutorSubjectID id;
        private Student student;
        private Tutor tutor;
        private Subject subject;

        public Builder setId(StudentTutorSubjectID id) {
            this.id = id;
            return this;
        }

        public Builder setTutor(Tutor tutor) {
            this.tutor = tutor;
            return this;
        }

        public Builder setStudent(Student student) {
            this.student = student;
            return this;
        }

        public Builder setSubject(Subject subject) {
            this.subject = subject;
            return this;
        }

        public Builder copy(StudentTutorSubject studentTutorSubject) {
            this.id = studentTutorSubject.getId();
            this.student = studentTutorSubject.getStudent();
            this.tutor = studentTutorSubject.getTutor();
            this.subject = studentTutorSubject.getSubject();
            return this;
        }

        public StudentTutorSubject build(){
            return new StudentTutorSubject(this);
        }
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
