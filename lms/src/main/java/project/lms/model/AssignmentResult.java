package project.lms.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "assignmentResults")
public class AssignmentResult {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long assignResultId;

    @ManyToOne
    @JoinColumn(name = "memberId", nullable = false)
    private Member member;

    @ManyToOne
    @JoinColumn(name = "assignmentId", nullable = false)
    private Assignment assignment;

    @Column(nullable = false)
    private boolean isCorrect;

    @Column(name = "wrongAnsExpl", columnDefinition = "TEXT")
    private String wrongAnsExpl;

    @Column(name = "correctAnswer", columnDefinition = "TEXT")
    private String correctAnswer;

    @Column(name = "submittedAnswer", columnDefinition = "TEXT")
    private String submittedAnswer;

    @Column(name = "submissionTime")
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime submissionTime;

    // 기본 생성자
    public AssignmentResult() {
    }

    // 전체 생성자
    public AssignmentResult(Long assignResultId, Member member, Assignment assignment, boolean isCorrect,
                            String wrongAnsExpl, String correctAnswer, String submittedAnswer,
                            LocalDateTime submissionTime) {
        this.assignResultId = assignResultId;
        this.member = member;
        this.assignment = assignment;
        this.isCorrect = isCorrect;
        this.wrongAnsExpl = wrongAnsExpl;
        this.correctAnswer = correctAnswer;
        this.submittedAnswer = submittedAnswer;
        this.submissionTime = submissionTime;
    }

    // Getters and Setters
	public Long getAssignResultId() {
		return assignResultId;
	}

	public void setAssignResultId(Long assignResultId) {
		this.assignResultId = assignResultId;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public Assignment getAssignment() {
		return assignment;
	}

	public void setAssignment(Assignment assignment) {
		this.assignment = assignment;
	}

	public boolean isCorrect() {
		return isCorrect;
	}

	public void setCorrect(boolean isCorrect) {
		this.isCorrect = isCorrect;
	}

	public String getWrongAnsExpl() {
		return wrongAnsExpl;
	}

	public void setWrongAnsExpl(String wrongAnsExpl) {
		this.wrongAnsExpl = wrongAnsExpl;
	}

	public String getCorrectAnswer() {
		return correctAnswer;
	}

	public void setCorrectAnswer(String correctAnswer) {
		this.correctAnswer = correctAnswer;
	}

	public String getSubmittedAnswer() {
		return submittedAnswer;
	}

	public void setSubmittedAnswer(String submittedAnswer) {
		this.submittedAnswer = submittedAnswer;
	}

	public LocalDateTime getSubmissionTime() {
		return submissionTime;
	}

	public void setSubmissionTime(LocalDateTime submissionTime) {
		this.submissionTime = submissionTime;
	}
    
}