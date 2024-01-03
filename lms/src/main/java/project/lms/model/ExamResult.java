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
@Table(name = "examResults")
public class ExamResult {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long examResultId;

    @ManyToOne
    @JoinColumn(name = "memberId", nullable = false)
    private Member member;

    @ManyToOne
    @JoinColumn(name = "examId", nullable = false)
    private Exam exam;

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
    public ExamResult() {
    }

    // 전체 생성자
    public ExamResult(Long examResultId, Member member, Exam exam, boolean isCorrect,
                      String wrongAnsExpl, String correctAnswer, String submittedAnswer,
                      LocalDateTime submissionTime) {
        this.examResultId = examResultId;
        this.member = member;
        this.exam = exam;
        this.isCorrect = isCorrect;
        this.wrongAnsExpl = wrongAnsExpl;
        this.correctAnswer = correctAnswer;
        this.submittedAnswer = submittedAnswer;
        this.submissionTime = submissionTime;
    }

    // Getters and Setters

    // ... (생략)

    public Long getExamResultId() {
        return examResultId;
    }

    public void setExamResultId(Long examResultId) {
        this.examResultId = examResultId;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public Exam getExam() {
        return exam;
    }

    public void setExam(Exam exam) {
        this.exam = exam;
    }

    public boolean isCorrect() {
        return isCorrect;
    }

    public void setCorrect(boolean correct) {
        isCorrect = correct;
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
