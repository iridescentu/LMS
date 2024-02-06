package project.lms.dto;

import java.time.LocalDateTime;

public class ContentHistoryDto {
	
	private Long memberId;
    private Long contentId;
    private LocalDateTime lastAccessed;
    private Boolean isCompleted;
    
	public ContentHistoryDto() {
		super();
	}
	
	public ContentHistoryDto(Long memberId, Long contentId, LocalDateTime lastAccessed, Boolean isCompleted) {
		super();
		this.memberId = memberId;
		this.contentId = contentId;
		this.lastAccessed = lastAccessed;
		this.isCompleted = isCompleted;
	}
	
	public Long getMemberId() {
		return memberId;
	}
	public void setMemberId(Long memberId) {
		this.memberId = memberId;
	}
	public Long getContentId() {
		return contentId;
	}
	public void setContentId(Long contentId) {
		this.contentId = contentId;
	}
	public LocalDateTime getLastAccessed() {
		return lastAccessed;
	}
	public void setLastAccessed(LocalDateTime lastAccessed) {
		this.lastAccessed = lastAccessed;
	}
	public Boolean getIsCompleted() {
		return isCompleted;
	}
	public void setIsCompleted(Boolean isCompleted) {
		this.isCompleted = isCompleted;
	}

}
