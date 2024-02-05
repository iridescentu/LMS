package project.lms.dto;

import java.time.LocalDateTime;
import project.lms.model.CourseReview;

public class CourseReviewDto {

    private Long reviewId;
    private Long memberId;
    private Long courseId;
    private Integer rating;
    private String comment;
    private LocalDateTime reviewDate;

    public CourseReviewDto() {}

    public CourseReviewDto(Long reviewId, Long memberId, Long courseId, Integer rating, String comment,
                           LocalDateTime reviewDate) {
        this.reviewId = reviewId;
        this.memberId = memberId;
        this.courseId = courseId;
        this.rating = rating;
        this.comment = comment;
        this.reviewDate = reviewDate;
    }

    public static CourseReviewDto from(CourseReview courseReview) {
        CourseReviewDto dto = new CourseReviewDto();
        dto.setReviewId(courseReview.getReviewId());
        dto.setMemberId(courseReview.getMember().getMemberId());
        dto.setCourseId(courseReview.getCourse().getCourseId());
        dto.setRating(courseReview.getRating());
        dto.setComment(courseReview.getComment());
        dto.setReviewDate(courseReview.getReviewDate());
        return dto;
    }

    public Long getReviewId() {
        return reviewId;
    }

    public void setReviewId(Long reviewId) {
        this.reviewId = reviewId;
    }

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public LocalDateTime getReviewDate() {
        return reviewDate;
    }

    public void setReviewDate(LocalDateTime reviewDate) {
        this.reviewDate = reviewDate;
    }
}
