package project.lms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import project.lms.dto.CourseReviewDto;
import project.lms.dto.ResponseDto;
import project.lms.service.CourseReviewService;

import java.util.List;

@RestController
@RequestMapping("/api/course-reviews")
@CrossOrigin(origins="http://localhost:3000",
    methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class CourseReviewController {

    private final CourseReviewService courseReviewService;

    @Autowired
    public CourseReviewController(CourseReviewService courseReviewService) {
        super();
        this.courseReviewService = courseReviewService;
    }
    
    // 모든 리뷰를 조회하여 반환하는 메서드
    @GetMapping("/list")
    public ResponseEntity<ResponseDto<List<CourseReviewDto>>> getAllReviews() {
        ResponseDto<List<CourseReviewDto>> responseDto = new ResponseDto<>("Success", courseReviewService.getAllReviews(), "모든 리뷰 조회 성공");
        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }

    // reviewId를 기반으로 해당 리뷰를 조회하여 반환하는 메서드
    @GetMapping("/{reviewId}")
    public ResponseEntity<ResponseDto<CourseReviewDto>> getCourseReview(@PathVariable Long reviewId) {
        ResponseDto<CourseReviewDto> responseDto = new ResponseDto<>("Success", courseReviewService.getCourseReview(reviewId), "리뷰 조회 성공");
        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }

    // memberId를 기반으로 해당 사용자의 모든 리뷰를 조회하여 반환하는 메서드
    @GetMapping("/list/member/{memberId}")
    public ResponseEntity<ResponseDto<List<CourseReviewDto>>> getReviewsByMemberId(@PathVariable Long memberId) {
        ResponseDto<List<CourseReviewDto>> responseDto = new ResponseDto<>("Success", courseReviewService.getReviewsByMemberId(memberId), "회원의 리뷰 조회 성공");
        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }

    // courseId를 기반으로 해당 강의의 모든 리뷰를 조회하여 반환하는 메서드
    @GetMapping("/list/course/{courseId}")
    public ResponseEntity<ResponseDto<List<CourseReviewDto>>> getReviewsByCourseId(@PathVariable Long courseId) {
        ResponseDto<List<CourseReviewDto>> responseDto = new ResponseDto<>("Success", courseReviewService.getReviewsByCourseId(courseId), "강의의 리뷰 조회 성공");
        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }

    // 리뷰를 생성하고, 저장한 후 반환하는 메서드
    @PostMapping // 이처럼 경로가 정해지지 않은 메서드는 @RequestMapping에서 지정한 기본 경로(/api/course-reviews)가 사용됨
    public ResponseEntity<ResponseDto<CourseReviewDto>> saveCourseReview(@RequestBody CourseReviewDto courseReviewDto) {
        ResponseDto<CourseReviewDto> responseDto = new ResponseDto<>("Success", courseReviewService.saveCourseReview(courseReviewDto), "리뷰 저장 성공");
        return new ResponseEntity<>(responseDto, HttpStatus.CREATED);
    }

    // 리뷰를 업데이트하고, 업데이트된 리뷰를 반환하는 메서드
    @PutMapping("/{reviewId}")
    public ResponseEntity<ResponseDto<CourseReviewDto>> updateCourseReview(@RequestBody CourseReviewDto courseReviewDto) {
        ResponseDto<CourseReviewDto> responseDto = new ResponseDto<>("Success", courseReviewService.updateCourseReview(courseReviewDto), "리뷰 수정 성공");
        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }

    // 리뷰를 삭제하는 메서드
    @DeleteMapping("/{reviewId}")
    public ResponseEntity<Void> deleteCourseReview(@PathVariable Long reviewId) {
        courseReviewService.deleteCourseReview(reviewId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
