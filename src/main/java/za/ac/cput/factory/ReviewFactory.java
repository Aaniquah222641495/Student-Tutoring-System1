package za.ac.cput.factory;

import za.ac.cput.domain.Review;
import za.ac.cput.domain.Student;
import za.ac.cput.domain.Tutor;

public class ReviewFactory {
    public static Review buildReview(Long id, String description, Integer rating, Student author, Tutor tutor){
        return Review.builder()
                .id(id)
                .author(author)
                .tutor(tutor)
                .rating(rating)
                .description(description)
                .build();
    }
    public static Review buildReview(String description, Integer rating, Student author, Tutor tutor){
        return Review.builder()
                .author(author)
                .tutor(tutor)
                .rating(rating)
                .description(description)
                .build();
    }
}
