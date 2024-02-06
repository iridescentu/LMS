package project.lms.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

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
@Table(name = "examCalendar")
public class ExamCalendar {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long testId;
	
	@ManyToOne
    @JoinColumn(name = "subjectId")
    private Subject subject;
	
	private String testName;
	
	private LocalDate testDate;
	
	@Temporal(TemporalType.TIMESTAMP)
	private LocalDateTime startTime;
	
	@Temporal(TemporalType.TIMESTAMP)
	private LocalDateTime endTime;
	
	private String location;
	
	private LocalDate registrationDeadline;
	
	private String additionalInfo;
	
	private Integer price;
	
	// 아래의 세 가지는 필요할까?
	private Integer maxApplicants;
	
	private Integer currentApplicants;
	
	private Boolean isOnline;

	public ExamCalendar() {
		super();
	}

	public ExamCalendar(Long testId, Subject subject, String testName, LocalDate testDate, LocalDateTime startTime,
			LocalDateTime endTime, String location, LocalDate registrationDeadline, String additionalInfo,
			Integer price, Integer maxApplicants, Integer currentApplicants, Boolean isOnline) {
		super();
		this.testId = testId;
		this.subject = subject;
		this.testName = testName;
		this.testDate = testDate;
		this.startTime = startTime;
		this.endTime = endTime;
		this.location = location;
		this.registrationDeadline = registrationDeadline;
		this.additionalInfo = additionalInfo;
		this.price = price;
		this.maxApplicants = maxApplicants;
		this.currentApplicants = currentApplicants;
		this.isOnline = isOnline;
	}

	public Long getTestId() {
		return testId;
	}

	public void setTestId(Long testId) {
		this.testId = testId;
	}

	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	public String getTestName() {
		return testName;
	}

	public void setTestName(String testName) {
		this.testName = testName;
	}

	public LocalDate getTestDate() {
		return testDate;
	}

	public void setTestDate(LocalDate testDate) {
		this.testDate = testDate;
	}

	public LocalDateTime getStartTime() {
		return startTime;
	}

	public void setStartTime(LocalDateTime startTime) {
		this.startTime = startTime;
	}

	public LocalDateTime getEndTime() {
		return endTime;
	}

	public void setEndTime(LocalDateTime endTime) {
		this.endTime = endTime;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public LocalDate getRegistrationDeadline() {
		return registrationDeadline;
	}

	public void setRegistrationDeadline(LocalDate registrationDeadline) {
		this.registrationDeadline = registrationDeadline;
	}

	public String getAdditionalInfo() {
		return additionalInfo;
	}

	public void setAdditionalInfo(String additionalInfo) {
		this.additionalInfo = additionalInfo;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public Integer getMaxApplicants() {
		return maxApplicants;
	}

	public void setMaxApplicants(Integer maxApplicants) {
		this.maxApplicants = maxApplicants;
	}

	public Integer getCurrentApplicants() {
		return currentApplicants;
	}

	public void setCurrentApplicants(Integer currentApplicants) {
		this.currentApplicants = currentApplicants;
	}

	public Boolean getIsOnline() {
		return isOnline;
	}

	public void setIsOnline(Boolean isOnline) {
		this.isOnline = isOnline;
	}

}
