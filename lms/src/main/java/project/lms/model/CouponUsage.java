package project.lms.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "couponUsage")
public class CouponUsage {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long usageId;
	
	@ManyToOne
	@JoinColumn(name = "couponCode", nullable = false)
	private Benefit benefit;
	
	@ManyToOne
	@JoinColumn(name = "memberId", nullable = false)
	private Member member;
	
	@Column(nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private LocalDateTime usageDate;
	
	@Column(name = "isUsed", nullable = false)
	private boolean isUsed;

	public CouponUsage() {
		super();
	}

	public CouponUsage(Long usageId, Benefit benefit, Member member, LocalDateTime usageDate, boolean isUsed) {
		super();
		this.usageId = usageId;
		this.benefit = benefit;
		this.member = member;
		this.usageDate = usageDate;
		this.isUsed = isUsed;
	}

	public Long getUsageId() {
		return usageId;
	}

	public void setUsageId(Long usageId) {
		this.usageId = usageId;
	}

	public Benefit getBenefit() {
		return benefit;
	}

	public void setBenefit(Benefit benefit) {
		this.benefit = benefit;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public LocalDateTime getUsageDate() {
		return usageDate;
	}

	public void setUsageDate(LocalDateTime usageDate) {
		this.usageDate = usageDate;
	}

	public boolean isUsed() {
		return isUsed;
	}

	public void setUsed(boolean isUsed) {
		this.isUsed = isUsed;
	}
	
}
