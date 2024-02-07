package project.lms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import project.lms.dto.ResponseDto;
import project.lms.model.ExamCalendar;
import project.lms.service.ExamCalendarService;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/exam-calendar")
@CrossOrigin(origins = "http://localhost:3000", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT })
public class ExamCalendarController {

    private final ExamCalendarService examCalendarService;

    @Autowired
    public ExamCalendarController(ExamCalendarService examCalendarService) {
        this.examCalendarService = examCalendarService;
    }

    // ExamCalendar를 생성
    @PreAuthorize("hasAnyRole('ADMIN')")
    @PostMapping("/save")
    public ResponseEntity<ResponseDto<ExamCalendar>> createExamCalendar(@RequestBody ExamCalendar examCalendar) {
        ResponseDto<ExamCalendar> responseDto = examCalendarService.createExamCalendar(examCalendar);
        return ResponseEntity.status(HttpStatus.OK).body(responseDto);
    }

    // ExamCalendar를 수정
    @PreAuthorize("hasAnyRole('ADMIN')")
    @PutMapping("/update/{testId}")
    public ResponseEntity<ResponseDto<ExamCalendar>> updateExamCalendar(@PathVariable Long testId, @RequestBody ExamCalendar examCalendar) {
        ResponseDto<ExamCalendar> responseDto = examCalendarService.updateExamCalendar(testId, examCalendar);
        return ResponseEntity.status(HttpStatus.OK).body(responseDto);
    }

    // ExamCalendar를 삭제
    @PreAuthorize("hasAnyRole('ADMIN')")
    @DeleteMapping("/delete/{testId}")
    public ResponseEntity<ResponseDto<Void>> deleteExamCalendar(@PathVariable Long testId) {
        ResponseDto<Void> responseDto = examCalendarService.deleteExamCalendar(testId);
        return ResponseEntity.status(HttpStatus.OK).body(responseDto);
    }

    // 특정 시험 일정을 조회
    @GetMapping("/{testId}")
    public ResponseEntity<ResponseDto<ExamCalendar>> getExamCalendarById(@PathVariable Long testId) {
        ResponseDto<ExamCalendar> responseDto = examCalendarService.getExamCalendarById(testId);
        return ResponseEntity.status(HttpStatus.OK).body(responseDto);
    }

    // 모든 시험 일정을 조회
    @GetMapping
    public ResponseEntity<ResponseDto<List<ExamCalendar>>> getAllExamCalendars() {
        ResponseDto<List<ExamCalendar>> responseDto = examCalendarService.getAllExamCalendars();
        return ResponseEntity.status(HttpStatus.OK).body(responseDto);
    }

    // 특정 과목의 모든 시험 일정을 조회
    @GetMapping("/subject/{subjectName}")
    public ResponseEntity<ResponseDto<List<ExamCalendar>>> getExamCalendarsBySubject(@PathVariable String subjectName) {
        ResponseDto<List<ExamCalendar>> responseDto = examCalendarService.getExamCalendarsBySubject(subjectName);
        return ResponseEntity.status(HttpStatus.OK).body(responseDto);
    }

    // 특정 날짜의 모든 시험 일정을 조회
    @GetMapping("/date/{date}")
    public ResponseEntity<ResponseDto<List<ExamCalendar>>> getExamCalendarsByDate(@PathVariable LocalDate date) {
        ResponseDto<List<ExamCalendar>> responseDto = examCalendarService.getExamCalendarsByDate(date);
        return ResponseEntity.status(HttpStatus.OK).body(responseDto);
    }

    // 등록 마감일이 임박한 시험 일정을 조회
    @GetMapping("/closing/{closingDate}")
    public ResponseEntity<ResponseDto<List<ExamCalendar>>> getExamCalendarsByClosingDate(@PathVariable LocalDate closingDate) {
        ResponseDto<List<ExamCalendar>> responseDto = examCalendarService.getExamCalendarsByClosingDate(closingDate);
        return ResponseEntity.status(HttpStatus.OK).body(responseDto);
    }

    // 아직 등록 가능한 시험 일정을 조회
    @GetMapping("/available")
    public ResponseEntity<ResponseDto<List<ExamCalendar>>> getAvailableExamCalendars() {
        ResponseDto<List<ExamCalendar>> responseDto = examCalendarService.getAvailableExamCalendars();
        return ResponseEntity.status(HttpStatus.OK).body(responseDto);
    }

    // 특정 과목의 등록 가능한 시험 일정을 조회
    @GetMapping("/available/subject/{subjectName}")
    public ResponseEntity<ResponseDto<List<ExamCalendar>>> getAvailableExamCalendarsBySubject(@PathVariable String subjectName) {
        ResponseDto<List<ExamCalendar>> responseDto = examCalendarService.getAvailableExamCalendarsBySubject(subjectName);
        return ResponseEntity.status(HttpStatus.OK).body(responseDto);
    }
}
