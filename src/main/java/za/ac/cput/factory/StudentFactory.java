package za.ac.cput.factory;

import za.ac.cput.domain.Student;

public class StudentFactory {
    public Student createStudent(String firstName, String lastName,String phoneNumber, String password, String email) {
        return Student.builder()
                .firstName(firstName)
                .lastName(lastName)
                .phoneNumber(phoneNumber)
                .password(password)
                .email(email)
                .build();
    }
}
