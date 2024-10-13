package za.ac.cput.factory;

import za.ac.cput.domain.Student;

public class StudentFactory {
    public static Student buildStudent(String firstName, String lastName, String phoneNumber, String password, String email, Long studentNumber, byte[] profilePicture) {
        return Student.builder()
                .firstName(firstName)
                .lastName(lastName)
                .phoneNumber(phoneNumber)
                .password(password)
                .email(email)
                .studentNumber(studentNumber)
                .profilePicture(profilePicture)
                .build();
    }

    public static Student buildStudent(Long id, String firstName, String lastName, String phoneNumber, String password, String email, Long studentNumber, byte[] profilePicture) {
        return Student.builder()
                .id(id)
                .firstName(firstName)
                .lastName(lastName)
                .phoneNumber(phoneNumber)
                .password(password)
                .email(email)
                .studentNumber(studentNumber)
                .profilePicture(profilePicture)
                .build();
    }

}
