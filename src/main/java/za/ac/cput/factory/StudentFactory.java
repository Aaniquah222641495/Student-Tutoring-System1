package za.ac.cput.factory;

import za.ac.cput.domain.Student;

public class StudentFactory {
    public Student createStudent(String firstName, String lastName,String phoneNumber, String password, String email, Long studentNumber) {
        return Student.builder()
                .firstName(firstName)
                .lastName(lastName)
                .phoneNumber(phoneNumber)
                .password(password)
                .email(email)
                .studentNumber(studentNumber)
                .build();
    }

    public Student createStudent(Long id,String firstName, String lastName,String phoneNumber, String password, String email, Long studentNumber) {
        return Student.builder()
                .id(id)
                .firstName(firstName)
                .lastName(lastName)
                .phoneNumber(phoneNumber)
                .password(password)
                .email(email)
                .studentNumber(studentNumber)
                .build();
    }

}
