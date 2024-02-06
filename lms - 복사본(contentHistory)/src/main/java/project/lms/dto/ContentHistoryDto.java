package project.lms.dto;

import java.time.LocalDateTime;

import project.lms.model.ContentHistory;

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
	
	public static ContentHistoryDto from(ContentHistory contentHistory) {
        ContentHistoryDto contentHistoryDto = new ContentHistoryDto();
        contentHistoryDto.setMemberId(contentHistory.getMember().getMemberId());
        contentHistoryDto.setContentId(contentHistory.getContent().getContentId());
        contentHistoryDto.setLastAccessed(contentHistory.getLastAccessed());
        contentHistoryDto.setIsCompleted(contentHistory.getIsCompleted());
        return contentHistoryDto;
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
