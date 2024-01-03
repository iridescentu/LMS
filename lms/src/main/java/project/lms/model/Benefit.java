package project.lms.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "benefits")
public class Benefit {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long benefitId;
	
	@ManyToOne
	@JoinColumn(name = "courseId", nullable = false)
	private Course course;
	
	@Column(name = "description", columnDefinition = "TEXT")
    private String description;

//	Benefit enum
//    @Enumerated(EnumType.STRING)
//    @Column(name = "type", nullable = false)
//    private BenefitType type;
	
	private Benefit benefit;

    @Column(name = "requiredCompletionCount")
    private Integer requiredCompletionCount;

    @Column(name = "couponCode", unique = true, length = 50)
    private String couponCode;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime expirationDate;

    @Column(name = "isActive", nullable = false)
    private Boolean isActive;
    
    // BenefitType 열거형 정의 (Line 33 ~ Line 36 사용할 땐 얘도 같이)
//    public enum BenefitType {
//        COURSE_COMPLETION,
//        EXAM_COMPLETION
//    }

	public Benefit() {
		super();
	}

	public Benefit(Long benefitId, Course course, String description, Benefit benefit, Integer requiredCompletionCount,
			String couponCode, LocalDateTime expirationDate, Boolean isActive) {
		super();
		this.benefitId = benefitId;
		this.course = course;
		this.description = description;
		this.benefit = benefit;
		this.requiredCompletionCount = requiredCompletionCount;
		this.couponCode = couponCode;
		this.expirationDate = expirationDate;
		this.isActive = isActive;
	}

	public Long getBenefitId() {
		return benefitId;
	}

	public void setBenefitId(Long benefitId) {
		this.benefitId = benefitId;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Benefit getBenefit() {
		return benefit;
	}

	public void setBenefit(Benefit benefit) {
		this.benefit = benefit;
	}

	public Integer getRequiredCompletionCount() {
		return requiredCompletionCount;
	}

	public void setRequiredCompletionCount(Integer requiredCompletionCount) {
		this.requiredCompletionCount = requiredCompletionCount;
	}

	public String getCouponCode() {
		return couponCode;
	}

	public void setCouponCode(String couponCode) {
		this.couponCode = couponCode;
	}

	public LocalDateTime getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(LocalDateTime expirationDate) {
		this.expirationDate = expirationDate;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}
	
}
