package project.lms.model;

import java.sql.Timestamp;
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
@Table(name = "Exams")
public class Exam {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long examId;

    @ManyToOne
    @JoinColumn(name = "contentId", nullable = false)
    private Content content;

    @Column(name = "examDate")
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime examDate;

    @Column(name = "numQuestions")
    private Integer numQuestions;

    @Column(name = "durationMins")
    private Integer durationMins;

    @Column(name = "passingScore")
    private Integer passingScore;

    @Column(name = "examIsActive")
    private boolean examIsActive;

    // 기본 생성자
    public Exam() {
  
    }

    // 전체 생성자
    public Exam(Long examId, Content content, LocalDateTime examDate, 
                 Integer numQuestions, Integer durationMins, Integer passingScore, boolean examIsActive) {
        this.examId = examId;
        this.content = content;
        this.examDate = examDate;
        this.numQuestions = numQuestions;
        this.durationMins = durationMins;
        this.passingScore = passingScore;
        this.examIsActive = examIsActive;
    }

    // Getters and Setters
	public Long getExamId() {
		return examId;
	}

	public void setExamId(Long examId) {
		this.examId = examId;
	}

	public Content getContent() {
		return content;
	}

	public void setContent(Content content) {
		this.content = content;
	}

	public LocalDateTime getExamDate() {
		return examDate;
	}

	public void setExamDate(LocalDateTime examDate) {
		this.examDate = examDate;
	}

	public Integer getNumQuestions() {
		return numQuestions;
	}

	public void setNumQuestions(Integer numQuestions) {
		this.numQuestions = numQuestions;
	}

	public Integer getDurationMins() {
		return durationMins;
	}

	public void setDurationMins(Integer durationMins) {
		this.durationMins = durationMins;
	}

	public Integer getPassingScore() {
		return passingScore;
	}

	public void setPassingScore(Integer passingScore) {
		this.passingScore = passingScore;
	}

	public boolean isExamIsActive() {
		return examIsActive;
	}

	public void setExamIsActive(boolean examIsActive) {
		this.examIsActive = examIsActive;
	}

}
