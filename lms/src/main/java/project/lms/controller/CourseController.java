package project.lms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import project.lms.dto.CourseDto;
import project.lms.dto.ResponseDto;
import project.lms.model.Course;
import project.lms.service.CourseService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins="http://localhost:3000", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT})
public class CourseController {
	
	private final CourseService courseService;

    @Autowired
    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @PostMapping("/course/save")
    public ResponseEntity<ResponseDto<CourseDto>> saveCourseWithThumbnail(@RequestBody CourseDto courseDto) {
        ResponseDto<CourseDto> response = courseService.saveCourseWithThumbnail(courseDto);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/course/{courseId}")
    public ResponseEntity<Course> getCourseWithThumbnail(@PathVariable Long courseId) {
        return courseService.getCourseWithThumbnail(courseId)
                .map(course -> new ResponseEntity<>(course, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/course")
    public ResponseEntity<List<Course>> getAllCourses() {
        List<Course> courses = courseService.getAllCourses();
        return new ResponseEntity<>(courses, HttpStatus.OK);
    }

    @PutMapping("/course/update/{courseId}")
	@PreAuthorize("hasAnyRole('INSTRUCTOR')")
	public ResponseEntity<ResponseDto<CourseDto>> updateCourse(
			@PathVariable Long courseId,
			@RequestBody CourseDto courseDto) {
		ResponseDto<CourseDto> responseDto = courseService.updateCourse(courseId, courseDto);
		return ResponseEntity.status(HttpStatus.OK).body(responseDto);
	}
    
    @DeleteMapping("/course/delete/{courseId}")
	@PreAuthorize("hasAnyRole('INSTRUCTOR')")
	public ResponseEntity<ResponseDto<String>> deleteCourse(@PathVariable Long courseId) {
		ResponseDto<String> reponseDto = courseService.deleteCourse(courseId);
		return ResponseEntity.status(HttpStatus.OK).body(reponseDto);
	}
}