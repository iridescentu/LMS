package project.lms.service;

import project.lms.dto.ResponseDto;
import project.lms.model.ExamCalendar;
import java.time.LocalDate;
import java.util.List;

public interface ExamCalendarService {
    
    // 시험 일정을 생성
    ResponseDto<ExamCalendar> createExamCalendar(ExamCalendar examCalendar);
    
    // 시험 일정을 수정
    ResponseDto<ExamCalendar> updateExamCalendar(Long testId, ExamCalendar examCalendar);
    
    // 시험 일정을 삭제
    ResponseDto<Void> deleteExamCalendar(Long testId);
    
    // 특정 시험 일정을 조회
    ResponseDto<ExamCalendar> getExamCalendarById(Long testId);
    
    // 모든 시험 일정을 조회
    ResponseDto<List<ExamCalendar>> getAllExamCalendars();
    
    // 특정 과목의 모든 시험 일정을 조회
    ResponseDto<List<ExamCalendar>> getExamCalendarsBySubject(String subjectName);

    // 특정 날짜의 모든 시험 일정을 조회
    ResponseDto<List<ExamCalendar>> getExamCalendarsByDate(LocalDate date);

    // 등록 마감일이 임박한 시험 일정을 조회
    ResponseDto<List<ExamCalendar>> getExamCalendarsByClosingDate(LocalDate closingDate);
    
    // 아직 등록 가능한 시험 일정을 조회
    ResponseDto<List<ExamCalendar>> getAvailableExamCalendars();

    // 특정 과목의 등록 가능한 시험 일정을 조회
    ResponseDto<List<ExamCalendar>> getAvailableExamCalendarsBySubject(String subjectName);

}
