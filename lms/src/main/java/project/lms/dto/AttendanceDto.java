package project.lms.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;

// 출석 Dto
public class AttendanceDto {

    @NotNull
    private Long memberId;

    @NotNull
    private Long courseId;

    @NotBlank
    private String status;

    @NotNull
    private LocalDateTime checkInTime;

    private LocalDateTime checkOutTime; // 퇴실 시간은 null일 수 있음

    // 기본 생성자
    public AttendanceDto() {
        super();
    }

    // 전체 생성자
    public AttendanceDto(@NotNull Long memberId, @NotNull Long courseId, @NotBlank String status,
                         @NotNull LocalDateTime checkInTime, LocalDateTime checkOutTime) {
        super();
        this.memberId = memberId;
        this.courseId = courseId;
        this.status = status;
        this.checkInTime = checkInTime;
        this.checkOutTime = checkOutTime;
    }

    // Getters and Setters
    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getCheckInTime() {
        return checkInTime;
    }

    public void setCheckInTime(LocalDateTime checkInTime) {
        this.checkInTime = checkInTime;
    }

    public LocalDateTime getCheckOutTime() {
        return checkOutTime;
    }

    public void setCheckOutTime(LocalDateTime checkOutTime) {
        this.checkOutTime = checkOutTime;
    }
}
