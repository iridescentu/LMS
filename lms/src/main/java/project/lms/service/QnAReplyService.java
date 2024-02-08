package project.lms.service;

import project.lms.dto.QnAReplyDto;
import project.lms.dto.ResponseDto;

import java.util.List;

public interface QnAReplyService {

    // 모든 답글 조회
    ResponseDto<List<QnAReplyDto>> getAllQnAReplies();
    
    // QnAId로 해당 질문 댓글에 달린 댓글 조회
    ResponseDto<List<QnAReplyDto>> getQnARepliesByQnABoardId(Long qnaId);
    
    ResponseDto<QnAReplyDto> createQnAReply(QnAReplyDto qnaReplyDto, Long memberId, Long qnaId);

    ResponseDto<String> deleteQnAReply(Long replyId);

    
    
    // ----- 사용 안 할 듯 -----
    // 특정 회원이 작성한 모든 질문 조회
    ResponseDto<List<QnAReplyDto>> getQnARepliesByMemberId(Long memberId);
    // 질문에 대한 답변 수정
//    ResponseDto<QnAReplyDto> updateQnAReply(Long replyId, QnAReplyDto qnaReplyDto, Long memberId);
    ResponseDto<List<QnAReplyDto>> getQnARepliesByQnABoardIdAndMemberId(Long qnaId, Long memberId);

}
