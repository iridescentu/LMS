package project.lms.repository;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import project.lms.model.Assignment;
import project.lms.model.Content;

// JpaRepository를 상속받아야 하며, 제네릭 타입은 <엔터티, 기본키의 타입>이다.
public interface AssignmentRepository extends JpaRepository<Assignment, Long> {

    // 특정 제목의 과제 검색
    Assignment findByAssignmentTitle(String assignmentTitle);
    
    // 과제 제목의 일부를 포함하는 과제 목록 검색
    List<Assignment> findByAssignmentTitleContaining(String partialTitle);
    
    // 과제 제목과 콘텐츠 ID를 기반으로 과제 검색
    Assignment findByAssignmentTitleAndContentId(String assignmentTitle, Long contentId);
    
	// 특정 콘텐츠와 관련된 과제 목록 검색
    List<Assignment> findByContent(Content content);
    
    // 과제 상태에 따른 과제 목록 검색
    List<Assignment> findByAssignCompletionStatus(boolean assignCompletionStatus);
    
    // 특정 날짜 이전에 제출된 과제 목록 검색
    List<Assignment> findByAssignSubmissionTimeBefore(Timestamp date);

    // 특정 점수 이상의 과제 목록 검색
    List<Assignment> findByAssignScoreGreaterThan(Integer score);
    
    // 과제 점수가 특정 범위 내인 과제 목록 검색
    List<Assignment> findByAssignScoreBetween(Integer minScore, Integer maxScore);

    // 과제 제출 시간 범위 내의 과제 목록 검색
    List<Assignment> findByAssignSubmissionTimeBetween(Timestamp start, Timestamp end);

    // 과제 제출 시간 이후의 과제 목록 검색 (만약 과제 제출 시간이 지났을 때 과제 제출을 비활성화시킬 거면 필요 X)
    List<Assignment> findByAssignSubmissionTimeAfter(Timestamp date);

    // 과제 활성화 상태에 따른 과제 목록 검색
    List<Assignment> findByAssignIsActive(boolean assignIsActive);

    // 과제 제출 시간과 상태에 따른 복합 검색
    List<Assignment> findByAssignSubmissionTimeBeforeAndAssignCompletionStatus(Timestamp date, boolean completionStatus);

    // 과제 설명에 특정 키워드를 포함하는 과제 목록 검색
    List<Assignment> findByDescriptionContaining(String keyword);

    // 과제의 최근 제출 시간 순으로 정렬된 목록 검색
    List<Assignment> findByOrderByAssignSubmissionTimeDesc();

    
//	assignmentID Long [primary key] // 과제의 고유 ID
//	courseID Long (foreign key > Courses.courseID) // 강의 ID
//	dueDate timestamp // 제출 마감 날짜
//	assignmentTitle VARCHAR(200) // 과제 제목
//	description TEXT // 과제 설명
//	passingScore INT // 합격 점수
//	assignIsActive BOOLEAN // 과제 활성 상태
//	assignSubmissionTime timestamp // 제출 시간
//	assignCompletionStatus boolean // 완료 상태 (완료/미완료)
//	assignScore int // 과제 점수
}

