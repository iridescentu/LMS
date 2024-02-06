package project.lms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import project.lms.model.ExamCalendar;
import project.lms.model.Subject;

import java.time.LocalDate;
import java.util.List;

public interface ExamCalendarRepository extends JpaRepository<ExamCalendar, Long> {

    // 특정 과목의 모든 시험 일정 조회
    List<ExamCalendar> findBySubject(Subject subject);
    
    // 과목 이름으로 모든 시험 일정 조회
    List<ExamCalendar> findBySubjectSubjectName(String subjectName);

    // 특정 날짜의 모든 시험 일정 조회
    List<ExamCalendar> findByTestDate(LocalDate date);

    // 등록 마감일이 임박한 시험 일정 조회
    List<ExamCalendar> findByRegistrationDeadlineBefore(LocalDate date);

    // 아직 등록 가능한 시험 일정 조회 (현재 응시자 수 < 최대 응시자 수)
    @Query("SELECT e FROM ExamCalendar e WHERE e.currentApplicants < e.maxApplicants")
    List<ExamCalendar> findAvailableExams();

    // 특정 과목의 등록 가능한 시험 일정 조회
    @Query("SELECT e FROM ExamCalendar e WHERE e.subject = :subject AND e.currentApplicants < e.maxApplicants")
    List<ExamCalendar> findAvailableExamsBySubject(@Param("subject") Subject subject);
    
    // 과목 이름으로 등록 가능한 시험 일정 조회
    @Query("SELECT e FROM ExamCalendar e WHERE e.subject.subjectName = :subjectName AND e.currentApplicants < e.maxApplicants")
    List<ExamCalendar> findAvailableExamsBySubjectName(@Param("subjectName") String subjectName);

}
