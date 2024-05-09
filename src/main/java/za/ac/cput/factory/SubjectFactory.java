package za.ac.cput.factory;

import za.ac.cput.domain.Subject;

public class SubjectFactory {
    public static Subject buildSubject(String subjectCode, String name){
        return new Subject.Builder()
                .setSubjectCode(subjectCode)
                .setName(name)
                .build();
    }
}
