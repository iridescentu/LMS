package project.lms.service;

import java.util.List;
import project.lms.dto.CourseReviewDto;

public interface CourseReviewService {

    // 모든 수강평 조회
    List<CourseReviewDto> getAllReviews();
    
    // 수강평Id로 수강평 조회
    CourseReviewDto getCourseReview(Long reviewId);

    // 특정 회원이 작성한 모든 수강평 조회
    List<CourseReviewDto> getReviewsByMemberId(Long memberId);
    
    // 특정 강의에 대한 모든 수강평 조회
    List<CourseReviewDto> getReviewsByCourseId(Long courseId);
    
    // 수강평 저장
    CourseReviewDto saveCourseReview(CourseReviewDto courseReviewDto);
    
    // 수강평 수정
    CourseReviewDto updateCourseReview(CourseReviewDto courseReviewDto);
    
    // 수강평 삭제
    void deleteCourseReview(Long reviewId);
    
}
