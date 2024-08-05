package za.ac.cput.factory;

import za.ac.cput.domain.Subject;

public class SubjectFactory {
    public static Subject buildSubject(String subjectCode, String name){
        return Subject.builder()
                .subjectCode(subjectCode)
                .name(name)
                .build();

    }

    public static Subject buildSubject(Long id, String subjectCode, String name){
        return Subject.builder()
                .id(id)
                .subjectCode(subjectCode)
                .name(name)
                .build();

    }
}
