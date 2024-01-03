package project.lms.model;

import java.math.BigDecimal;
import java.sql.Timestamp;
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
@Table(name = "orders")
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long orderId;
	
	@ManyToOne
	@JoinColumn(name = "memberId")
	private Member member;
	
	@Column(nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private LocalDateTime orderDate;
	
	@Column(nullable = false)
	private BigDecimal totalAmount;
	// double, float를 사용할 수 있으나 double과 float는 부동 소수점을 사용하기 때문
	// 정밀한 계산 금액이 필요한 경우 BigDecimal보다 정확도가 떨어지는 문제가 발생할 수 있으며,
	// double, float는 특정 범위 내에서만 값을 표현하기 때문에 큰 금액을 다루는 경우에는 오버플로우 문제가 발생할 수 있으므로
	// BigDecimal을 사용해 주었음
	
	@Column(name = "status")
    private String status;

    @Column(name = "address")
    private String address;

    @Column(name = "phoneNum")
    private Integer phoneNum;

    @Column(name = "email")
    private String email;

    @Column(name = "deliveryMessage")
    private String deliveryMessage;

    @Column(name = "paymentMethod")
    private String paymentMethod;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime paymentDate;

    @Column(name = "paymentStatus")
    private String paymentStatus;

    @Column(name = "OrdertotalAmount")
    private Integer orderTotalAmount;

	public Order() {
		super();
	}

	public Order(Long orderId, Member member, LocalDateTime orderDate, BigDecimal totalAmount, String status,
			String address, Integer phoneNum, String email, String deliveryMessage, String paymentMethod,
			LocalDateTime paymentDate, String paymentStatus, Integer orderTotalAmount) {
		super();
		this.orderId = orderId;
		this.member = member;
		this.orderDate = orderDate;
		this.totalAmount = totalAmount;
		this.status = status;
		this.address = address;
		this.phoneNum = phoneNum;
		this.email = email;
		this.deliveryMessage = deliveryMessage;
		this.paymentMethod = paymentMethod;
		this.paymentDate = paymentDate;
		this.paymentStatus = paymentStatus;
		this.orderTotalAmount = orderTotalAmount;
	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public LocalDateTime getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(LocalDateTime orderDate) {
		this.orderDate = orderDate;
	}

	public BigDecimal getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(BigDecimal totalAmount) {
		this.totalAmount = totalAmount;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Integer getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(Integer phoneNum) {
		this.phoneNum = phoneNum;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDeliveryMessage() {
		return deliveryMessage;
	}

	public void setDeliveryMessage(String deliveryMessage) {
		this.deliveryMessage = deliveryMessage;
	}

	public String getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public LocalDateTime getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(LocalDateTime paymentDate) {
		this.paymentDate = paymentDate;
	}

	public String getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	public Integer getOrderTotalAmount() {
		return orderTotalAmount;
	}

	public void setOrderTotalAmount(Integer orderTotalAmount) {
		this.orderTotalAmount = orderTotalAmount;
	}
	
}