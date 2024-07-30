package za.ac.cput.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.Objects;
import java.util.Set;

@Entity
@SuperBuilder
@Getter
@NoArgsConstructor
@Table(name="TUTOR")
@PrimaryKeyJoinColumn(name = "tutor_id")
public class Tutor extends User{
}
