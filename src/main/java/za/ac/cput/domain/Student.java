package za.ac.cput.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;

import java.util.Objects;
import java.util.Set;

@Entity
@Table(name="STUDENT")
@PrimaryKeyJoinColumn(name = "student_id")
public class Student extends User{

    @OneToMany(mappedBy = "student")
    private Set<StudentTutorSubject> enrollments;

    public Student() {
    }

    public Student(Builder builder) {
        this.id = builder.id;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.password = builder.password;
        this.email = builder.email;
        this.enrollments = builder.enrollments;
    }

    public Set<StudentTutorSubject> getEnrollments() {
        return enrollments;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Student student = (Student) o;
        return Objects.equals(enrollments, student.enrollments);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), enrollments);
    }

    public static class Builder{
        private Integer id;
        private String firstName;
        private String lastName;
        private String password;
        private String email;
        private Set<StudentTutorSubject> enrollments;

        public Builder setId(Integer id) {
            this.id = id;
            return this;
        }

        public Builder setFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder setLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder setPassword(String password) {
            this.password = password;
            return this;
        }

        public Builder setEmail(String email) {
            this.email = email;
            return this;
        }

        public Builder setEnrollments(Set<StudentTutorSubject> enrollments) {
            this.enrollments = enrollments;
            return this;
        }

        public Builder copy(Student student){
            this.id = student.id;
            this.firstName = student.firstName;
            this.lastName = student.lastName;
            this.password = student.password;
            this.email = student.email;
            this.enrollments = student.enrollments;
            return this;
        }

        public Student build(){
            return new Student(this);
        }
    }
}
