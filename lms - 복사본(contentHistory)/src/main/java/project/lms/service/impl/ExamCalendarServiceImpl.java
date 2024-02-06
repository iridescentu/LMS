package project.lms.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.lms.dto.ResponseDto;
import project.lms.enumstatus.ResultCode;
import project.lms.exception.InvalidRequestException;
import project.lms.model.ExamCalendar;
import project.lms.repository.ExamCalendarRepository;
import project.lms.service.ExamCalendarService;

import java.time.LocalDate;
import java.util.List;

@Service
public class ExamCalendarServiceImpl implements ExamCalendarService {

    private final ExamCalendarRepository examCalendarRepository; // ExamCalendarRepository 객체

    @Autowired
    public ExamCalendarServiceImpl(ExamCalendarRepository examCalendarRepository) {
        this.examCalendarRepository = examCalendarRepository; // 생성자를 통해 ExamCalendarRepository 객체를 주입
    }

    @Transactional
    @Override
    // 시험 일정을 생성
    public ResponseDto<ExamCalendar> createExamCalendar(ExamCalendar examCalendar) {
        ExamCalendar savedExamCalendar = examCalendarRepository.save(examCalendar);
        return new ResponseDto<>(ResultCode.SUCCESS.name(), savedExamCalendar, "시험 일정을 성공적으로 생성하였습니다.");
    }

    @Transactional
    @Override
    // 시험 일정을 수정
    public ResponseDto<ExamCalendar> updateExamCalendar(Long testId, ExamCalendar examCalendar) {
        ExamCalendar existingExamCalendar = examCalendarRepository.findById(testId).orElseThrow(() -> new InvalidRequestException("testId", "해당 시험 일정이 존재하지 않습니다."));
        
        // existingExamCalendar의 필드 값을 직접 변경
        existingExamCalendar.setSubject(examCalendar.getSubject());
        existingExamCalendar.setTestName(examCalendar.getTestName());
        existingExamCalendar.setTestDate(examCalendar.getTestDate());
        existingExamCalendar.setStartTime(examCalendar.getStartTime());
        existingExamCalendar.setEndTime(examCalendar.getEndTime());
        existingExamCalendar.setLocation(examCalendar.getLocation());
        existingExamCalendar.setRegistrationDeadline(examCalendar.getRegistrationDeadline());
        existingExamCalendar.setAdditionalInfo(examCalendar.getAdditionalInfo());
        existingExamCalendar.setPrice(examCalendar.getPrice());
        existingExamCalendar.setMaxApplicants(examCalendar.getMaxApplicants());
        existingExamCalendar.setCurrentApplicants(examCalendar.getCurrentApplicants());
        existingExamCalendar.setIsOnline(examCalendar.getIsOnline());

        examCalendarRepository.save(existingExamCalendar);
        return new ResponseDto<>(ResultCode.SUCCESS.name(), existingExamCalendar, "시험 일정을 성공적으로 수정하였습니다.");
    }


    @Transactional
    @Override
    // 시험 일정을 삭제
    public ResponseDto<Void> deleteExamCalendar(Long testId) {
        examCalendarRepository.deleteById(testId);
        return new ResponseDto<>(ResultCode.SUCCESS.name(), null, "시험 일정을 성공적으로 삭제하였습니다.");
    }

    @Transactional
    @Override
    // 특정 시험 일정을 조회
    public ResponseDto<ExamCalendar> getExamCalendarById(Long testId) {
        ExamCalendar examCalendar = examCalendarRepository.findById(testId).orElseThrow(() -> new InvalidRequestException("testId", "해당 시험 일정이 존재하지 않습니다."));
        return new ResponseDto<>(ResultCode.SUCCESS.name(), examCalendar, "시험 일정을 성공적으로 조회하였습니다.");
    }

    @Transactional
    @Override
    // 모든 시험 일정을 조회하는 메서드 구현
    public ResponseDto<List<ExamCalendar>> getAllExamCalendars() {
        List<ExamCalendar> examCalendars = examCalendarRepository.findAll();
        return new ResponseDto<>(ResultCode.SUCCESS.name(), examCalendars, "모든 시험 일정을 성공적으로 조회하였습니다.");
    }

    @Transactional
    @Override
    // 특정 과목의 모든 시험 일정을 조회
    public ResponseDto<List<ExamCalendar>> getExamCalendarsBySubject(String subjectName) {
        List<ExamCalendar> examCalendars = examCalendarRepository.findBySubjectSubjectName(subjectName);
        return new ResponseDto<>(ResultCode.SUCCESS.name(), examCalendars, "특정 과목의 모든 시험 일정을 성공적으로 조회하였습니다.");
    }

    @Transactional
    @Override
    // 특정 날짜의 모든 시험 일정을 조회하는 메서드 구현
    public ResponseDto<List<ExamCalendar>> getExamCalendarsByDate(LocalDate date) {
        List<ExamCalendar> examCalendars = examCalendarRepository.findByTestDate(date);
        return new ResponseDto<>(ResultCode.SUCCESS.name(), examCalendars, "특정 날짜의 모든 시험 일정을 성공적으로 조회하였습니다.");
    }

    @Transactional
    @Override
    // 등록 마감일이 임박한 시험 일정을 조회
    public ResponseDto<List<ExamCalendar>> getExamCalendarsByClosingDate(LocalDate closingDate) {
        List<ExamCalendar> examCalendars = examCalendarRepository.findByRegistrationDeadlineBefore(closingDate);
        return new ResponseDto<>(ResultCode.SUCCESS.name(), examCalendars, "등록 마감일이 임박한 시험 일정을 성공적으로 조회하였습니다.");
    }

    @Transactional
    @Override
    // 아직 등록 가능한 시험 일정을 조회
    public ResponseDto<List<ExamCalendar>> getAvailableExamCalendars() {
        List<ExamCalendar> examCalendars = examCalendarRepository.findAvailableExams();
        return new ResponseDto<>(ResultCode.SUCCESS.name(), examCalendars, "아직 등록 가능한 시험 일정을 성공적으로 조회하였습니다.");
    }

    @Transactional
    @Override
    // 특정 과목의 등록 가능한 시험 일정을 조회
    public ResponseDto<List<ExamCalendar>> getAvailableExamCalendarsBySubject(String subjectName) {
        List<ExamCalendar> examCalendars = examCalendarRepository.findAvailableExamsBySubjectName(subjectName);
        return new ResponseDto<>(ResultCode.SUCCESS.name(), examCalendars, "특정 과목의 등록 가능한 시험 일정을 성공적으로 조회하였습니다.");
    }
}
