package za.ac.cput.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class Student_Tutor_Subject_ID implements Serializable {
    @Column(name = "student_id")
    Integer student_id;
    @Column(name = "subject_code")
    String subject_code;
    @Column(name = "tutor_id")
    Integer tutor_id;

    public Student_Tutor_Subject_ID() {
    }

    public Student_Tutor_Subject_ID(Integer student_id, String subject_code, Integer tutor_id) {
        this.student_id = student_id;
        this.subject_code = subject_code;
        this.tutor_id = tutor_id;
    }

    public Integer getStudent_id() {
        return student_id;
    }

    public Student_Tutor_Subject_ID setStudent_id(Integer student_id) {
        this.student_id = student_id;
        return this;
    }

    public Integer getTutor_id() {
        return tutor_id;
    }

    public Student_Tutor_Subject_ID setTutor_id(Integer tutor_id) {
        this.tutor_id = tutor_id;
        return this;
    }

    public String getSubject_code() {
        return subject_code;
    }

    public Student_Tutor_Subject_ID setSubject_code(String subject_code) {
        this.subject_code = subject_code;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student_Tutor_Subject_ID that = (Student_Tutor_Subject_ID) o;
        return Objects.equals(student_id, that.student_id) && Objects.equals(subject_code, that.subject_code) && Objects.equals(tutor_id, that.tutor_id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(student_id, subject_code, tutor_id);
    }
}
