package za.ac.cput.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
import za.ac.cput.api.BookingApiDelegate;
import za.ac.cput.domain.*;
import za.ac.cput.dto.BookingDTO;
import za.ac.cput.factory.BookingFactory;
import za.ac.cput.service.*;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:5173", maxAge = 3600)
@RestController
public class BookingController implements BookingApiDelegate {

    private BookingService service;
    private LocationService locationService;
    private StudentService studentService;
    private TutorService tutorService;
    private SubjectService subjectService;

    public BookingController(BookingService service, LocationService locationService, StudentService studentService, TutorService tutorService, SubjectService subjectService) {
        this.service = service;
        this.locationService = locationService;
        this.studentService = studentService;
        this.tutorService = tutorService;
        this.subjectService = subjectService;
    }

    @Override
    public ResponseEntity<BookingDTO> createBooking(BookingDTO body) {
        Booking booking = BookingFactory.buildBooking(LocalTime.parse(body.getStartTime()), LocalTime.parse(body.getEndTime()), body.getDate(), tutorService.read(body.getTutorId()),studentService.read(body.getStudentId()), subjectService.read(body.getSubjectId()), locationService.read(body.getLocationId()), body.getTopic());
        body.setBookingId(service.create(booking).getBookingId());
        return ResponseEntity.ok().body(body);
    }

    @Override
    public ResponseEntity<Void> deleteBooking(Long bookingId) {
        service.delete(bookingId);
        return ResponseEntity.ok().body(null);
    }

    @Override
    public ResponseEntity<List<BookingDTO>> getAllBookings() {
        List<BookingDTO> list = new ArrayList<>();
        for(Booking booking: service.getAll()){
            BookingDTO dto = new BookingDTO(booking.getTutor().getId(),booking.getStudent().getId(), booking.getSubject().getSubjectId(), booking.getDate(), booking.getStartTime().toString(),booking.getEndTime().toString(),booking.getLocation().getLocationId(),booking.getTopic());
            dto.setBookingId(booking.getBookingId());
            list.add(dto);
        }
        return ResponseEntity.ok().body(list);
    }

    @Override
    public ResponseEntity<BookingDTO> getBookingById(Long bookingId) {
        Booking booking = service.read(bookingId);
        BookingDTO dto = new BookingDTO(booking.getTutor().getId(),booking.getStudent().getId(), booking.getSubject().getSubjectId(), booking.getDate(), booking.getStartTime().toString(),booking.getEndTime().toString(),booking.getLocation().getLocationId(),booking.getTopic());
        dto.setBookingId(booking.getBookingId());
        return ResponseEntity.ok().body(dto);
    }

    @Override
    public ResponseEntity<BookingDTO> updateBooking(Long bookingId, BookingDTO body) {
        Booking booking = BookingFactory.buildBooking(bookingId,LocalTime.parse(body.getStartTime()), LocalTime.parse(body.getEndTime()), body.getDate(), tutorService.read(body.getTutorId()),studentService.read(body.getStudentId()), subjectService.read(body.getSubjectId()), locationService.read(body.getLocationId()), body.getTopic());
        service.update(booking);
        body.setBookingId(booking.getBookingId());
        return ResponseEntity.ok().body(body);
    }

    @Override
    public ResponseEntity<List<BookingDTO>> getAllBookingsByLocation(Long locationId) {
        List<BookingDTO> list = new ArrayList<>();
        Location location = locationService.read(locationId);
        for(Booking booking: service.findByLocation(location)){
            BookingDTO dto = new BookingDTO(booking.getTutor().getId(),booking.getStudent().getId(), booking.getSubject().getSubjectId(), booking.getDate(), booking.getStartTime().toString(),booking.getEndTime().toString(),booking.getLocation().getLocationId(),booking.getTopic());
            dto.setBookingId(booking.getBookingId());
            list.add(dto);
        }
        return ResponseEntity.ok().body(list);
    }

    @Override
    public ResponseEntity<List<BookingDTO>> getAllBookingsByStudent(Long studentId) {
        List<BookingDTO> list = new ArrayList<>();
        Student student = studentService.read(studentId);
        for(Booking booking: service.findByStudent(student)){
            BookingDTO dto = new BookingDTO(booking.getTutor().getId(),booking.getStudent().getId(), booking.getSubject().getSubjectId(), booking.getDate(), booking.getStartTime().toString(),booking.getEndTime().toString(),booking.getLocation().getLocationId(),booking.getTopic());
            dto.setBookingId(booking.getBookingId());
            list.add(dto);
        }
        return ResponseEntity.ok().body(list);
    }

    @Override
    public ResponseEntity<List<BookingDTO>> getAllBookingsBySubject(Long subjectId) {
        List<BookingDTO> list = new ArrayList<>();
        Subject subject = subjectService.read(subjectId);
        for(Booking booking: service.findBySubject(subject)){
            BookingDTO dto = new BookingDTO(booking.getTutor().getId(),booking.getStudent().getId(), booking.getSubject().getSubjectId(), booking.getDate(), booking.getStartTime().toString(),booking.getEndTime().toString(),booking.getLocation().getLocationId(),booking.getTopic());
            dto.setBookingId(booking.getBookingId());
            list.add(dto);
        }
        return ResponseEntity.ok().body(list);
    }

    @Override
    public ResponseEntity<List<BookingDTO>> getAllBookingsByTutor(Long tutorId) {
        List<BookingDTO> list = new ArrayList<>();
        Tutor tutor = tutorService.read(tutorId);
        for(Booking booking: service.findByTutor(tutor)){
            BookingDTO dto = new BookingDTO(booking.getTutor().getId(),booking.getStudent().getId(), booking.getSubject().getSubjectId(), booking.getDate(), booking.getStartTime().toString(),booking.getEndTime().toString(),booking.getLocation().getLocationId(),booking.getTopic());
            dto.setBookingId(booking.getBookingId());
            list.add(dto);
        }
        return ResponseEntity.ok().body(list);
    }
}
