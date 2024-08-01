package za.ac.cput.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Entity
@SuperBuilder
@Getter
@Table(name="STUDENT")
@PrimaryKeyJoinColumn(name = "student_id")
public class Student extends User{
    @Column(unique=true)
    @NotNull
    private Long studentNumber;

    public Student() {
    }
}
