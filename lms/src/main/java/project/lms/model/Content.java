package project.lms.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "contents")
public class Content {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long contentID;

    @ManyToOne
    @JoinColumn(name = "courseID", nullable = false)
    private Course course;
    
    @Column(name = "contentTitle", length = 30, nullable = false)
    private String contentTitle;
    
    @Column(name = "contentDescription", length = 100, nullable = false)
    private String contentDescription;

    @Column(name = "contentType", length = 50, nullable = false)
    private String contentType;

    @Lob
    // @Lob은 Java Persistence API (JPA)에서 Large Object를 나타내는 어노테이션.
    // Large Object (LOB)는 데이터베이스에 대용량의 데이터를 저장할 때 사용.
    // ex) 텍스트나 이미지, 오디오, 비디오 등의 큰 데이터를 저장할 때 @Lob 어노테이션을 사용할 수 있음.
    @Column(name = "contentData", nullable = false)
    private byte[] contentData;
    
    @Column(name = "contentURL", length = 3000, nullable = false)
    private String contentURL;
    
    @Column(name = "contentDuration", nullable = false)
    private Integer contentDuration;
    
    @Column(name = "contentStatus", nullable = false)
    private String contentStatus;
    
    @Column(name = "sequenceOrder", nullable = false)
    private Integer sequenceOrder;

	public Content() {
		super();
	}

	public Content(Long contentID, Course course, String contentTitle, String contentDescription, String contentType,
			byte[] contentData, String contentURL, Integer contentDuration, String contentStatus,
			Integer sequenceOrder) {
		super();
		this.contentID = contentID;
		this.course = course;
		this.contentTitle = contentTitle;
		this.contentDescription = contentDescription;
		this.contentType = contentType;
		this.contentData = contentData;
		this.contentURL = contentURL;
		this.contentDuration = contentDuration;
		this.contentStatus = contentStatus;
		this.sequenceOrder = sequenceOrder;
	}

	public Long getContentID() {
		return contentID;
	}

	public void setContentID(Long contentID) {
		this.contentID = contentID;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public String getContentTitle() {
		return contentTitle;
	}

	public void setContentTitle(String contentTitle) {
		this.contentTitle = contentTitle;
	}

	public String getContentDescription() {
		return contentDescription;
	}

	public void setContentDescription(String contentDescription) {
		this.contentDescription = contentDescription;
	}

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	public byte[] getContentData() {
		return contentData;
	}

	public void setContentData(byte[] contentData) {
		this.contentData = contentData;
	}

	public String getContentURL() {
		return contentURL;
	}

	public void setContentURL(String contentURL) {
		this.contentURL = contentURL;
	}

	public Integer getContentDuration() {
		return contentDuration;
	}

	public void setContentDuration(Integer contentDuration) {
		this.contentDuration = contentDuration;
	}

	public String getContentStatus() {
		return contentStatus;
	}

	public void setContentStatus(String contentStatus) {
		this.contentStatus = contentStatus;
	}

	public Integer getSequenceOrder() {
		return sequenceOrder;
	}

	public void setSequenceOrder(Integer sequenceOrder) {
		this.sequenceOrder = sequenceOrder;
	}
    
}
