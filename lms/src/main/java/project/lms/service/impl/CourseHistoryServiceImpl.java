package project.lms.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import project.lms.dto.ResponseDto;
import project.lms.enumstatus.ResultCode;
import project.lms.exception.InvalidRequestException;
import project.lms.model.Course;
import project.lms.model.CourseHistory;
import project.lms.model.Member;
import project.lms.repository.CourseHistoryRepository;
import project.lms.repository.MemberRepository;
import project.lms.service.CourseHistoryService;
import project.lms.util.SecurityUtil;

import java.time.LocalDate;
import java.util.List;

@Service
public class CourseHistoryServiceImpl implements CourseHistoryService {
	
	private final CourseHistoryRepository courseHistoryRepository;

	private final MemberRepository memberRepository;
	
	@Autowired
	public CourseHistoryServiceImpl(CourseHistoryRepository courseHistoryRepository, MemberRepository memberRepository) {
		super();
		this.courseHistoryRepository = courseHistoryRepository;
		this.memberRepository = memberRepository;
	}

	// 전체 조회
	@Override
	public ResponseDto<List<CourseHistory>> getAllCourseHistories(){
		List<CourseHistory> courseHistories = courseHistoryRepository.findAll();
		return new ResponseDto<>(
				ResultCode.SUCCESS.name(),
				courseHistories,
				"모든 courseHistory를 조회하였습니다.");
	}
	
	// 강의별 조회
	@Override
	public ResponseDto<List<CourseHistory>> getCourseHistoriesByCourse(Long courseId){
		List<CourseHistory> courseHistories = courseHistoryRepository.findByCourseCourseId(courseId);
		return new ResponseDto<>(
				ResultCode.SUCCESS.name(),
				courseHistories,
				"courseHistory를 course에 따라 조회하였습니다.");
	}
	
	// 로그인 유저의 조회
	private Member getCurrentUser() {
        String username = SecurityUtil.getCurrentloginId()
                .orElseThrow(() -> new InvalidRequestException("not found username", "현재 해당 사용자를 찾을 수 없습니다."));
        
        return memberRepository.findByLoginId(username);
    }
	
	public ResponseDto<List<CourseHistory>> getMyCourseHistories() {
		Member member = getCurrentUser();
		List<CourseHistory> courseHistories = courseHistoryRepository.findByMember(member);
		
		return new ResponseDto<>(
				ResultCode.SUCCESS.name(),
				courseHistories,
				"로그인한 사용자가 수강 중인 courseHistory를 조회하였습니다.");
	}

//    private final CourseHistoryRepository courseHistoryRepository;
//
//    @Autowired
//    public CourseHistoryServiceImpl(CourseHistoryRepository courseHistoryRepository) {
//        this.courseHistoryRepository = courseHistoryRepository;
//    }
//
//    // 특정 회원의 수강 이력 조회
//    @Transactional
//    @Override
//    public ResponseDto<List<CourseHistory>> getCourseHistoryByMember(Member member) {
//        try {
//            List<CourseHistory> courseHistories = courseHistoryRepository.findByMember(member);
//            return new ResponseDto<>(ResultCode.SUCCESS.name(), courseHistories, "회원의 수강 이력을 성공적으로 조회하였습니다.");
//        } catch (Exception e) {
//            e.printStackTrace();
//            throw new InvalidRequestException("회원의 수강 이력 조회 중 오류가 발생했습니다.", e.getMessage());
//        }
//    }
//
//    // 특정 강좌의 수강 이력 조회
//    @Transactional
//    @Override
//    public ResponseDto<List<CourseHistory>> getCourseHistoryByCourse(Course course) {
//        try {
//            List<CourseHistory> courseHistories = courseHistoryRepository.findByCourse(course);
//            return new ResponseDto<>(ResultCode.SUCCESS.name(), courseHistories, "강좌의 수강 이력을 성공적으로 조회하였습니다.");
//        } catch (Exception e) {
//            e.printStackTrace();
//            throw new InvalidRequestException("강좌의 수강 이력 조회 중 오류가 발생했습니다.", e.getMessage());
//        }
//    }
//
//    // 특정 날짜 범위 내의 수강 이력 조회
//    @Transactional
//    @Override
//    public ResponseDto<List<CourseHistory>> getCourseHistoryInDateRange(LocalDate startDate, LocalDate endDate) {
//        try {
//            List<CourseHistory> courseHistories = courseHistoryRepository.findByStartDateBetween(startDate, endDate);
//            return new ResponseDto<>(ResultCode.SUCCESS.name(), courseHistories, "날짜 범위 내의 수강 이력을 성공적으로 조회하였습니다.");
//        } catch (Exception e) {
//            e.printStackTrace();
//            throw new InvalidRequestException("날짜 범위 내의 수강 이력 조회 중 오류가 발생했습니다.", e.getMessage());
//        }
//    }
//
//    // 특정 회원과 강좌의 수강 이력 조회
//    @Transactional
//    @Override
//    public ResponseDto<List<CourseHistory>> getCourseHistoryByMemberAndCourse(Member member, Course course) {
//        try {
//            List<CourseHistory> courseHistories = courseHistoryRepository.findByMemberAndCourse(member, course);
//            return new ResponseDto<>(ResultCode.SUCCESS.name(), courseHistories, "회원과 강좌의 수강 이력을 성공적으로 조회하였습니다.");
//        } catch (Exception e) {
//            e.printStackTrace();
//            throw new InvalidRequestException("회원과 강좌의 수강 이력 조회 중 오류가 발생했습니다.", e.getMessage());
//        }
//    }
//
//    // 종료일이 null인(아직 종료되지 않은) 수강 이력 조회
//    @Transactional
//    @Override
//    public ResponseDto<List<CourseHistory>> getOngoingCourseHistory() {
//        try {
//            List<CourseHistory> courseHistories = courseHistoryRepository.findByEndDateIsNull();
//            return new ResponseDto<>(ResultCode.SUCCESS.name(), courseHistories, "아직 종료되지 않은 수강 이력을 성공적으로 조회하였습니다.");
//        } catch (Exception e) {
//            e.printStackTrace();
//            throw new InvalidRequestException("아직 종료되지 않은 수강 이력 조회 중 오류가 발생했습니다.", e.getMessage());
//        }
//    }
//
//    // 특정 날짜 이후에 종료된 수강 이력 조회
//    @Transactional
//    @Override
//    public ResponseDto<List<CourseHistory>> getCourseHistoryEndedAfter(LocalDate date) {
//        try {
//            List<CourseHistory> courseHistories = courseHistoryRepository.findByEndDateAfter(date);
//            return new ResponseDto<>(ResultCode.SUCCESS.name(), courseHistories, "특정 날짜 이후에 종료된 수강 이력을 성공적으로 조회하였습니다.");
//        } catch (Exception e) {
//            e.printStackTrace();
//            throw new InvalidRequestException("특정 날짜 이후에 종료된 수강 이력 조회 중 오류가 발생했습니다.", e.getMessage());
//        }
//    }
//
//    // 특정 회원의 가장 최근 수강 이력 조회
//    @Transactional
//    @Override
//    public ResponseDto<CourseHistory> getLatestCourseHistoryForMember(Member member) {
//        try {
//            CourseHistory latestCourseHistory = courseHistoryRepository.findTopByMemberOrderByStartDateDesc(member);
//            return new ResponseDto<>(ResultCode.SUCCESS.name(), latestCourseHistory, "회원의 가장 최근 수강 이력을 성공적으로 조회하였습니다.");
//        } catch (Exception e) {
//            e.printStackTrace();
//            throw new InvalidRequestException("회원의 가장 최근 수강 이력 조회 중 오류가 발생했습니다.", e.getMessage());
//        }
//    }
//
//    // 특정 강좌의 수강 이력 개수 조회
//    @Transactional
//    @Override
//    public ResponseDto<Long> getCourseHistoryCountByCourse(Course course) {
//        try {
//            long count = courseHistoryRepository.countByCourse(course);
//            return new ResponseDto<>(ResultCode.SUCCESS.name(), count, "강좌의 수강 이력 개수를 성공적으로 조회하였습니다.");
//        } catch (Exception e) {
//            e.printStackTrace();
//            throw new InvalidRequestException("강좌의 수강 이력 개수 조회 중 오류가 발생했습니다.", e.getMessage());
//        }
//    }
//
//    // 종료일이 null이고 시작일이 특정 날짜 이전인 수강 이력 조회
//    @Transactional
//    @Override
//    public ResponseDto<List<CourseHistory>> getOngoingCourseHistoryBeforeDate(LocalDate date) {
//        try {
//            List<CourseHistory> courseHistories = courseHistoryRepository.findByEndDateIsNullAndStartDateBefore(date);
//            return new ResponseDto<>(ResultCode.SUCCESS.name(), courseHistories, "특정 날짜 이전에 시작되고 아직 종료되지 않은 수강 이력을 성공적으로 조회하였습니다.");
//        } catch (Exception e) {
//            e.printStackTrace();
//            throw new InvalidRequestException("특정 날짜 이전에 시작되고 아직 종료되지 않은 수강 이력 조회 중 오류가 발생했습니다.", e.getMessage());
//        }
//    }
}
