package project.lms.service;

import java.util.List;

import project.lms.dto.ResponseDto;
import project.lms.model.ContentHistory;
import project.lms.model.Member;

public interface ContentHistoryService {
	
	// 모든 학습 이력 조회
	public ResponseDto<List<ContentHistory>> getAllContentHistories();
	
	// 특정 콘텐츠 ID에 대한 학습 이력 조회
	public ResponseDto<List<ContentHistory>> getContentHistoriesByContent(Long contentId);
	
	// 특정 회원의 학습 이력 조회
	public ResponseDto<List<ContentHistory>> getMyContentHistories();

	// 완료된 학습 이력 조회
    public ResponseDto<List<ContentHistory>> getCompletedContentHistories();

    // 완료되지 않은 학습 이력 조회
    public ResponseDto<List<ContentHistory>> getIncompleteContentHistories();
}
