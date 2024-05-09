package za.ac.cput.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.Objects;
import java.util.Set;

@Entity
@Table(name="TUTOR")
public class Tutor extends User{

    @OneToMany (mappedBy = "tutor")
    private Set<StudentTutorSubject> enrollments;

    public Tutor() {
    }

    public Tutor(Builder builder){
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
        Tutor tutor = (Tutor) o;
        return Objects.equals(enrollments, tutor.enrollments);
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

        public Builder copy(Tutor tutor){
            this.id = tutor.getId();
            this.firstName = tutor.getFirstName();
            this.lastName = tutor.getLastName();
            this.email = tutor.getEmail();
            this.password = tutor.getPassword();
            this.enrollments = tutor.getEnrollments();
            return this;
        }

        public Tutor build(){
            return new Tutor(this);
        }
    }
}
