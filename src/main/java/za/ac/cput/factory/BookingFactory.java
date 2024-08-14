package za.ac.cput.factory;

import za.ac.cput.domain.*;
import za.ac.cput.domain.enums.Status;

import java.time.LocalDate;
import java.time.LocalTime;

public class BookingFactory {
    public static Booking buildBooking(Long id, LocalTime startTime, LocalTime endTime, LocalDate date, Tutor tutor, Student student, Subject subject, Location location, String topic){
        return Booking.builder()
                .booking_id(id)
                .startTime(startTime)
                .endTime(endTime)
                .date(date)
                .tutor(tutor)
                .student(student)
                .subject(subject)
                .location(location)
                .topic(topic)
                .build();

    }
    public static Booking buildBooking(LocalTime startTime, LocalTime endTime, LocalDate date, Tutor tutor, Student student, Subject subject, Location location, String topic){
        return Booking.builder()
                .startTime(startTime)
                .endTime(endTime)
                .date(date)
                .tutor(tutor)
                .student(student)
                .subject(subject)
                .location(location)
                .topic(topic)
                .build();

    }
}
