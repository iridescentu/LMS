package project.lms.dto;

import java.time.LocalDateTime;

import project.lms.model.Content;

public class AssignmentDto {

	private Long assignmentId;
	
	private Content content;
	
	private LocalDateTime dueDate;
	
	private String assignmentTitle;
	
	private String description;
	
	private Integer passingScore;
	
	private boolean assignIsActive;
	
	private String correctAnswer;

	public AssignmentDto() {
		super();
	}

	public AssignmentDto(Long assignmentId, Content content, LocalDateTime dueDate, String assignmentTitle,
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
