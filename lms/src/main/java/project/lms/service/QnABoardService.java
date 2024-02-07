package project.lms.service;

import project.lms.dto.QnABoardDto;
import project.lms.dto.ResponseDto;

import java.util.List;

public interface QnABoardService {

    ResponseDto<Void> createQnABoard(QnABoardDto qnaBoardDto, Long courseId, Long memberId);

    ResponseDto<QnABoardDto> updateQnABoard(Long qnaId, QnABoardDto qnaBoardDto, Long memberId);

    ResponseDto<String> deleteQnABoard(Long qnaId, Long memberId);

    ResponseDto<List<QnABoardDto>> getAllQnABoards();

    ResponseDto<List<QnABoardDto>> getQnABoardsByMemberId(Long memberId);
    
    ResponseDto<List<QnABoardDto>> getQnABoardsByCourseId(Long courseId);
    
}
