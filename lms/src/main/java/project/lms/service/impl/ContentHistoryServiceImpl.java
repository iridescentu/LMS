package project.lms.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.lms.dto.ResponseDto;
import project.lms.enumstatus.ResultCode;
import project.lms.exception.InvalidRequestException;
import project.lms.model.ContentHistory;
import project.lms.model.Member;
import project.lms.repository.ContentHistoryRepository;
import project.lms.repository.MemberRepository;
import project.lms.service.ContentHistoryService;
import project.lms.util.SecurityUtil;

import java.util.List;

@Service
public class ContentHistoryServiceImpl implements ContentHistoryService {
	
	private final ContentHistoryRepository contentHistoryRepository;

	private final MemberRepository memberRepository;
	
	@Autowired
	public ContentHistoryServiceImpl(ContentHistoryRepository contentHistoryRepository, MemberRepository memberRepository) {
		super();
		this.contentHistoryRepository = contentHistoryRepository;
		this.memberRepository = memberRepository;
	}

	// 전체 조회
	@Override
	public ResponseDto<List<ContentHistory>> getAllContentHistories(){
		List<ContentHistory> contentHistories = contentHistoryRepository.findAll();
		return new ResponseDto<>(
				ResultCode.SUCCESS.name(),
				contentHistories,
				"모든 contentHistory를 조회하였습니다.");
	}
	
	// 콘텐츠별 조회
	@Override
	public ResponseDto<List<ContentHistory>> getContentHistoriesByContent(Long contentId){
		List<ContentHistory> contentHistories = contentHistoryRepository.findByContentContentId(contentId);
		return new ResponseDto<>(
				ResultCode.SUCCESS.name(),
				contentHistories,
				"contentHistory를 content에 따라 조회하였습니다.");
	}
	
	// 완료된 학습 이력 조회
	@Override
	public ResponseDto<List<ContentHistory>> getCompletedContentHistories(){
		List<ContentHistory> contentHistories = contentHistoryRepository.findByIsCompletedTrue();
		return new ResponseDto<>(
				ResultCode.SUCCESS.name(),
				contentHistories,
				"완료된 학습 이력을 조회하였습니다.");
	}
	
	// 완료되지 않은 학습 이력 조회
	@Override
	public ResponseDto<List<ContentHistory>> getIncompleteContentHistories(){
		List<ContentHistory> contentHistories = contentHistoryRepository.findByIsCompletedFalse();
		return new ResponseDto<>(
				ResultCode.SUCCESS.name(),
				contentHistories,
				"완료되지 않은 학습 이력을 조회하였습니다.");
	}
	
	// 로그인 유저의 조회
		private Member getCurrentUser() {
	        String username = SecurityUtil.getCurrentloginId()
	                .orElseThrow(() -> new InvalidRequestException("not found username", "현재 해당 사용자를 찾을 수 없습니다."));
	        
	        return memberRepository.findByLoginId(username);
	    }
		
		@Override
		public ResponseDto<List<ContentHistory>> getMyContentHistories() {
			Member member = getCurrentUser();
			List<ContentHistory> contentHistories = contentHistoryRepository.findByMember(member);
			
			return new ResponseDto<>(
					ResultCode.SUCCESS.name(),
					contentHistories,
					"로그인한 사용자가 학습 중인 contentHistory를 조회하였습니다.");
		}

}
