package za.ac.cput.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.Objects;
import java.util.Set;

@Entity
@SuperBuilder
@Getter
@NoArgsConstructor
@Table(name="STUDENT")
@PrimaryKeyJoinColumn(name = "student_id")
public class Student extends User{


}
