package za.ac.cput.factory;

import za.ac.cput.domain.Admin;
import za.ac.cput.domain.Tutor;

public class TutorFactory {
    public static Tutor buildTutor(String firstName, String lastName, String phoneNumber, String password, String email){
        return Tutor.builder()
                .firstName(firstName)
                .lastName(lastName)
                .phoneNumber(phoneNumber)
                .password(password)
                .email(email)
                .build();

    }
    public static Tutor buildTutor(Long id, String firstName, String lastName, String phoneNumber, String password, String email){
        return Tutor.builder()
                .id(id)
                .firstName(firstName)
                .lastName(lastName)
                .phoneNumber(phoneNumber)
                .password(password)
                .email(email)
                .build();

    }
}
