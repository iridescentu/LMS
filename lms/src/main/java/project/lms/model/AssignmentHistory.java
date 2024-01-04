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
@Table(name = "assignmentHistory")
public class AssignmentHistory {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long assignmentHistoryId;

    @ManyToOne
    @JoinColumn(name = "memberId", nullable = false)
    private Member member;

    @ManyToOne
    @JoinColumn(name = "assignmentId", nullable = false)
    private Assignment assignment;

    @Column(name = "submissionTime")
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime submissionTime;

    @Column(name = "assignCompletionStatus")
    private boolean assignCompletionStatus;

    @Column(name = "score")
    private Integer score;

    // 기본 생성자
    public AssignmentHistory() {
  
    }

    // 전체 생성자
    public AssignmentHistory(Long assignmentHistoryId, Member member, Assignment assignment, 
    		LocalDateTime submissionTime, boolean assignCompletionStatus, Integer score) {
        this.assignmentHistoryId = assignmentHistoryId;
        this.member = member;
        this.assignment = assignment;
        this.submissionTime = submissionTime;
        this.assignCompletionStatus = assignCompletionStatus;
        this.score = score;
    }

    // Getters and Setters
	public Long getAssignmentHistoryId() {
		return assignmentHistoryId;
	}

	public void setAssignmentHistoryId(Long assignmentHistoryId) {
		this.assignmentHistoryId = assignmentHistoryId;
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

	public LocalDateTime getSubmissionTime() {
		return submissionTime;
	}

	public void setSubmissionTime(LocalDateTime submissionTime) {
		this.submissionTime = submissionTime;
	}

	public boolean isAssignCompletionStatus() {
		return assignCompletionStatus;
	}

	public void setAssignCompletionStatus(boolean assignCompletionStatus) {
		this.assignCompletionStatus = assignCompletionStatus;
	}

	public Integer getScore() {
		return score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

}