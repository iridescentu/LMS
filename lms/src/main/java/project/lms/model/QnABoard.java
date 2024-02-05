package project.lms.model;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "qnaBoard")
public class QnABoard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long qnaId;
    
    @ManyToOne
    @JoinColumn(name = "courseId", nullable = false)
    private Course course;
    
    @ManyToOne
    @JoinColumn(name = "memberId", nullable = false)
    private Member member;
    
    private String questionText;
    
    @CreationTimestamp
    private LocalDateTime createdAt;
    
    @UpdateTimestamp
    private LocalDateTime updatedAt;
    
    @ManyToOne
    @JoinColumn(name = "createdBy", nullable = false)
    private Member createdBy;
    
    @ManyToOne
    @JoinColumn(name = "updatedBy", nullable = true)
    private Member updatedBy; // 수정자에 대한 필드 추가(권한이 없는 다른 사람이 질문을 수정하거나 삭제하는 것을 방지하기 위해)

    // 기본 생성자
    public QnABoard() {

    }

	public QnABoard(Long qnaId, Course course, Member member, String questionText, LocalDateTime createdAt) {
		super();
		this.qnaId = qnaId;
		this.course = course;
		this.member = member;
		this.questionText = questionText;
		this.createdAt = createdAt;
	}

	public Long getQnaId() {
		return qnaId;
	}

	public void setQnaId(Long qnaId) {
		this.qnaId = qnaId;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public String getQuestionText() {
		return questionText;
	}

	public void setQuestionText(String questionText) {
		this.questionText = questionText;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

}