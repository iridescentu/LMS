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
@Table(name = "courses")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long courseId;

    @ManyToOne
    @JoinColumn(name = "subjectId", nullable = false)
    private Subject subject;

    @Column(nullable = false, length = 150)
    private String courseName;

    @Column(nullable = true, length = 500) // 강의 소개는 필수가 아닐 수 있음
    private String description;
    
    @Column(name = "courseThumbnail")
    private byte[] courseThumbnail;
    
    @Column(name = "contentLevel")
    private String contentLevel;

    @Column(nullable = false)
    private Integer durationMins;

    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private LocalDateTime startDate;

    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private LocalDateTime endDate;
    
    @Column(name = "price", nullable = false)
    private Integer price;

    // 기본 생성자
    public Course() {
        super();
    }

    // 전체 생성자
	public Course(Long courseId, Subject subject, String courseName, String description, byte[] courseThumbnail,
			String contentLevel, Integer durationMins, LocalDateTime startDate, LocalDateTime endDate, Integer price) {
		super();
		this.courseId = courseId;
		this.subject = subject;
		this.courseName = courseName;
		this.description = description;
		this.courseThumbnail = courseThumbnail;
		this.contentLevel = contentLevel;
		this.durationMins = durationMins;
		this.startDate = startDate;
		this.endDate = endDate;
		this.price = price;
	}

    // Getters and Setters
	public Long getCourseId() {
		return courseId;
	}

	public void setCourseId(Long courseId) {
		this.courseId = courseId;
	}

	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public byte[] getCourseThumbnail() {
		return courseThumbnail;
	}

	public void setCourseThumbnail(byte[] courseThumbnail) {
		this.courseThumbnail = courseThumbnail;
	}

	public String getContentLevel() {
		return contentLevel;
	}

	public void setContentLevel(String contentLevel) {
		this.contentLevel = contentLevel;
	}

	public Integer getDurationMins() {
		return durationMins;
	}

	public void setDurationMins(Integer durationMins) {
		this.durationMins = durationMins;
	}

	public LocalDateTime getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDateTime startDate) {
		this.startDate = startDate;
	}

	public LocalDateTime getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDateTime endDate) {
		this.endDate = endDate;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

}