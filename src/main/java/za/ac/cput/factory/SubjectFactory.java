package za.ac.cput.factory;

import za.ac.cput.domain.Subject;

public class SubjectFactory {
    public static Subject buildSubject(String subjectCode, String name){
        return Subject.builder()
                .subjectCode(subjectCode)
                .name(name)
                .build();

    }

    public static Subject buildSubject(Long subjectId, String subjectCode, String name){
        return Subject.builder()
                .subjectId(subjectId)
                .subjectCode(subjectCode)
                .name(name)
                .build();

    }
}
