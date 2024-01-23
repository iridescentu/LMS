package project.lms.model;

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

import java.time.LocalDateTime;

@Entity
@Table(name = "assignments")
public class Assignment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long assignmentId;

    @ManyToOne
    @JoinColumn(name = "contentId")
    private Content content;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime dueDate;

    @Column(length = 200, nullable = false)
    private String assignmentTitle;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(nullable = false)
    private Integer passingScore;

    @Column
    private boolean assignIsActive;
    
    private String correctAnswer;

    // 기본 생성자
    public Assignment() {
    }

	public Assignment(Long assignmentId, Content content, LocalDateTime dueDate, String assignmentTitle,
			String description, Integer passingScore, boolean assignIsActive, String correctAnswer) {
		super();
		this.assignmentId = assignmentId;
		this.content = content;
		this.dueDate = dueDate;
		this.assignmentTitle = assignmentTitle;
		this.description = description;
		this.passingScore = passingScore;
		this.assignIsActive = assignIsActive;
		this.correctAnswer = correctAnswer;
	}

	public Long getAssignmentId() {
		return assignmentId;
	}

	public void setAssignmentId(Long assignmentId) {
		this.assignmentId = assignmentId;
	}

	public Content getContent() {
		return content;
	}

	public void setContent(Content content) {
		this.content = content;
	}

	public LocalDateTime getDueDate() {
		return dueDate;
	}

	public void setDueDate(LocalDateTime dueDate) {
		this.dueDate = dueDate;
	}

	public String getAssignmentTitle() {
		return assignmentTitle;
	}

	public void setAssignmentTitle(String assignmentTitle) {
		this.assignmentTitle = assignmentTitle;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getPassingScore() {
		return passingScore;
	}

	public void setPassingScore(Integer passingScore) {
		this.passingScore = passingScore;
	}

	public boolean isAssignIsActive() {
		return assignIsActive;
	}

	public void setAssignIsActive(boolean assignIsActive) {
		this.assignIsActive = assignIsActive;
	}

	public String getCorrectAnswer() {
		return correctAnswer;
	}

	public void setCorrectAnswer(String correctAnswer) {
		this.correctAnswer = correctAnswer;
	}

}