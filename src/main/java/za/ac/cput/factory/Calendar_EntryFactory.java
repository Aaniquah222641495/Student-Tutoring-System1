package za.ac.cput.factory;

import za.ac.cput.domain.Calendar_Entry;
import za.ac.cput.domain.Student;
import za.ac.cput.domain.Tutor;

import java.util.Date;

public class Calendar_EntryFactory {

    public static Calendar_Entry buildCalendarEntry(Integer entry_id, Date date,
                                                    String title, Student student_id,
                                                    Tutor tutor_id, String subject_code,
                                                    String description) {
        return new Calendar_Entry.Builder()
                .setEntry_id(entry_id)
                .setDate(date)
                .setTitle(title)
                .setStudent_id(student_id)
                .setTutor_id(tutor_id)
                .setSubject_code(subject_code)
                .setDescription(description)
                .build();
    }
}