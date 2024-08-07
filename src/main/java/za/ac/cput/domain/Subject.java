package za.ac.cput.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.Set;


@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@EqualsAndHashCode
@Table(name = "SUBJECT")
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String subjectCode;
    private String name;
    private byte[] subjectGuide;


}
