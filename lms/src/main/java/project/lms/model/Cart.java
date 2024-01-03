package project.lms.model;

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
@Table(name = "carts")
public class Cart {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long cartId;
	
	@ManyToOne
	@JoinColumn(name = "memberId")
	private Member member;
	
	@ManyToOne
	@JoinColumn(name = "courseId")
	private Course course;
	
	@Column(nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private LocalDateTime createDate;
	
	@Column(name = "totalQuantity", nullable = false)
	private Integer totalQuantity;
	
	@ManyToOne
    @JoinColumn(name = "price", referencedColumnName = "price", nullable = false)
    private Course price;

    @Column(name = "totalPrice", nullable = false)
    private Integer totalPrice;

	public Cart() {
		super();
	}

	public Cart(Long cartId, Member member, Course course, LocalDateTime createDate, Integer totalQuantity,
			Course price, Integer totalPrice) {
		super();
		this.cartId = cartId;
		this.member = member;
		this.course = course;
		this.createDate = createDate;
		this.totalQuantity = totalQuantity;
		this.price = price;
		this.totalPrice = totalPrice;
	}

	public Long getCartId() {
		return cartId;
	}

	public void setCartId(Long cartId) {
		this.cartId = cartId;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public LocalDateTime getCreateDate() {
		return createDate;
	}

	public void setCreateDate(LocalDateTime createDate) {
		this.createDate = createDate;
	}

	public Integer getTotalQuantity() {
		return totalQuantity;
	}

	public void setTotalQuantity(Integer totalQuantity) {
		this.totalQuantity = totalQuantity;
	}

	public Course getPrice() {
		return price;
	}

	public void setPrice(Course price) {
		this.price = price;
	}

	public Integer getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Integer totalPrice) {
		this.totalPrice = totalPrice;
	}
	
}