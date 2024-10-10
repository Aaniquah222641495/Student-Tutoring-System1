package za.ac.cput.factory;

import za.ac.cput.domain.Admin;
import za.ac.cput.domain.Subject;
import za.ac.cput.domain.Tutor;

import java.util.Set;

public class TutorFactory {
    public static Tutor buildTutor(String firstName, String lastName, String phoneNumber, String password, String email, Set<Subject> assignedSubjects){
        return Tutor.builder()
                .firstName(firstName)
                .lastName(lastName)
                .phoneNumber(phoneNumber)
                .password(password)
                .email(email)
                .assignedSubjects(assignedSubjects)
                .build();

    }
    public static Tutor buildTutor(Long id, String firstName, String lastName, String phoneNumber, String password, String email, Set<Subject> assignedSubjects){
        return Tutor.builder()
                .id(id)
                .firstName(firstName)
                .lastName(lastName)
                .phoneNumber(phoneNumber)
                .password(password)
                .email(email)
                .assignedSubjects(assignedSubjects)
                .build();

    }
}
