package project.lms.model;

import java.sql.Date;
import java.time.LocalDate;

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
@Table(name = "courseHistory")
public class CourseHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long courseHistoryID;

    @ManyToOne
    @JoinColumn(name = "memberId", nullable = false)
    private Member member;

    @ManyToOne
    @JoinColumn(name = "courseId", nullable = false)
    private Course course;

    @Column(name = "startDate")
    @Temporal(TemporalType.DATE)
    private Date startDate;

    // 기본 생성자
    public CourseHistory() {

    }

	public CourseHistory(Long courseHistoryID, Member member, Course course, Date startDate) {
		super();
		this.courseHistoryID = courseHistoryID;
		this.member = member;
		this.course = course;
		this.startDate = startDate;
	}

	public Long getCourseHistoryID() {
		return courseHistoryID;
	}

	public void setCourseHistoryID(Long courseHistoryID) {
		this.courseHistoryID = courseHistoryID;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

    
}