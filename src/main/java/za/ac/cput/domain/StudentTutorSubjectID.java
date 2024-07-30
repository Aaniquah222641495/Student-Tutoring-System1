package za.ac.cput.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Deprecated
@Embeddable
public class StudentTutorSubjectID implements Serializable {
    @Column(name = "student_id")
    Integer student_id;
    @Column(name = "subject_code")
    String subject_code;
    @Column(name = "tutor_id")
    Integer tutor_id;

    public StudentTutorSubjectID() {
    }

    public StudentTutorSubjectID(Integer student_id, String subject_code, Integer tutor_id) {
        this.student_id = student_id;
        this.subject_code = subject_code;
        this.tutor_id = tutor_id;
    }

    public Integer getStudent_id() {
        return student_id;
    }

    public StudentTutorSubjectID setStudent_id(Integer student_id) {
        this.student_id = student_id;
        return this;
    }

    public Integer getTutor_id() {
        return tutor_id;
    }

    public StudentTutorSubjectID setTutor_id(Integer tutor_id) {
        this.tutor_id = tutor_id;
        return this;
    }

    public String getSubject_code() {
        return subject_code;
    }

    public StudentTutorSubjectID setSubject_code(String subject_code) {
        this.subject_code = subject_code;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentTutorSubjectID that = (StudentTutorSubjectID) o;
        return Objects.equals(student_id, that.student_id) && Objects.equals(subject_code, that.subject_code) && Objects.equals(tutor_id, that.tutor_id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(student_id, subject_code, tutor_id);
    }
}
