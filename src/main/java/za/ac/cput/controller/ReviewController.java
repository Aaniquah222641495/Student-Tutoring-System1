package za.ac.cput.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
import za.ac.cput.api.ReviewApiDelegate;
import za.ac.cput.domain.Review;
import za.ac.cput.domain.Student;
import za.ac.cput.domain.Tutor;
import za.ac.cput.dto.ReviewDTO;
import za.ac.cput.factory.ReviewFactory;
import za.ac.cput.service.ReviewService;
import za.ac.cput.service.StudentService;
import za.ac.cput.service.TutorService;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:5173", maxAge = 3600)
@RestController
public class ReviewController implements ReviewApiDelegate {

    private ReviewService service;
    private TutorService tutorService;
    private StudentService studentService;

    public ReviewController(ReviewService service, TutorService tutorService, StudentService studentService) {
        this.service = service;
        this.tutorService = tutorService;
        this.studentService = studentService;
    }

    @Override
    public ResponseEntity<ReviewDTO> addReview(ReviewDTO body) {
        Review review = ReviewFactory.buildReview(body.getDescription(), body.getRating(), studentService.read(body.getStudentId()), tutorService.read(body.getTutorId()));
        body.setReviewId(service.create(review).getReviewId());
        return ResponseEntity.ok().body(body);
    }

    @Override
    public ResponseEntity<Void> deleteReview(Long reviewId) {
        service.delete(reviewId);
        return ResponseEntity.ok().body(null);
    }

    @Override
    public ResponseEntity<List<ReviewDTO>> getAllReviews() {
        List<ReviewDTO> list = new ArrayList<>();
        for(Review review: service.getAll()){
            ReviewDTO dto = new ReviewDTO(review.getTutor().getId(), review.getRating(), review.getDescription(), review.getAuthor().getId());
            dto.setReviewId(review.getReviewId());
            list.add(dto);
        }

        return ResponseEntity.ok().body(list);
    }

    @Override
    public ResponseEntity<ReviewDTO> getReview(Long reviewId) {
        Review review = service.read(reviewId);
        ReviewDTO dto = new ReviewDTO(review.getTutor().getId(), review.getRating(), review.getDescription(), review.getAuthor().getId());
        dto.setReviewId(reviewId);
        return ResponseEntity.ok().body(dto);

    }

    @Override
    public ResponseEntity<ReviewDTO> updateReview(Long reviewId, ReviewDTO body) {
        Review review = ReviewFactory.buildReview(reviewId, body.getDescription(), body.getRating(), studentService.read(body.getStudentId()), tutorService.read(body.getTutorId()));
        service.update(review);
        body.setReviewId(reviewId);
        return ResponseEntity.ok().body(body);
    }

    @Override
    public ResponseEntity<List<ReviewDTO>> getAllReviewsByStudent(Long studentId) {
        List<ReviewDTO> list = new ArrayList<>();
        Student student = studentService.read(studentId);
        for(Review review: service.getReviewsByStudent(student)){
            ReviewDTO dto = new ReviewDTO(review.getTutor().getId(), review.getRating(), review.getDescription(), review.getAuthor().getId());
            dto.setReviewId(review.getReviewId());
            list.add(dto);
        }
        return ResponseEntity.ok().body(list);
    }

    @Override
    public ResponseEntity<List<ReviewDTO>> getAllReviewsByTutor(Long tutorId) {
        List<ReviewDTO> list = new ArrayList<>();
        Tutor tutor = tutorService.read(tutorId);
        for(Review review: service.getReviewsByTutor(tutor)){
            ReviewDTO dto = new ReviewDTO(review.getTutor().getId(), review.getRating(), review.getDescription(), review.getAuthor().getId());
            dto.setReviewId(review.getReviewId());
            list.add(dto);
        }
        return ResponseEntity.ok().body(list);
    }
}
