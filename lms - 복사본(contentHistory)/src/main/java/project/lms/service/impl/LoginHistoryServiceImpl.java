package project.lms.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.lms.dto.ResponseDto;
import project.lms.enumstatus.ResultCode;
import project.lms.model.LoginHistory;
import project.lms.repository.LoginHistoryRepository;
import project.lms.service.LoginHistoryService;

import java.util.List;

@Service
public class LoginHistoryServiceImpl implements LoginHistoryService {

    private final LoginHistoryRepository loginHistoryRepository; // LoginHistoryRepository 객체

    @Autowired
    public LoginHistoryServiceImpl(LoginHistoryRepository loginHistoryRepository) {
        this.loginHistoryRepository = loginHistoryRepository; // 생성자를 통해 LoginHistoryRepository 객체를 주입
    }

    @Transactional
    @Override
    // 전체 회원의 로그인 이력을 조회하고, 로그인 시간을 기준으로 내림차순 정렬하는 메서드 구현
    public ResponseDto<List<LoginHistory>> getAllLoginHistories() {
        List<LoginHistory> loginHistories = loginHistoryRepository.findAllByOrderByLoginTimeDesc();
        return new ResponseDto<>(ResultCode.SUCCESS.name(), loginHistories, "로그인 이력을 성공적으로 조회하였습니다.");
    }

    @Transactional
    @Override
    // 전체 회원의 가장 최근 로그인 이력을 조회하는 메서드 구현
    public ResponseDto<LoginHistory> getLatestLoginHistory() {
        LoginHistory loginHistory = loginHistoryRepository.findTopByOrderByLoginTimeDesc();
        return new ResponseDto<>(ResultCode.SUCCESS.name(), loginHistory, "가장 최근의 로그인 이력을 성공적으로 조회하였습니다.");
    }

    @Override
    // 로그인 이력을 저장하는 메서드 구현. LoginHistory 객체를 받아서 저장
    public LoginHistory save(LoginHistory loginHistory) {
        return loginHistoryRepository.save(loginHistory); // LoginHistoryRepository의 save 메서드를 호출하여 LoginHistory 객체를 저장
    }
}
