package project.lms.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.persistence.UniqueConstraint;
import project.lms.enumstatus.Gender;
import project.lms.enumstatus.Nationality;

@Entity
@Table(name = "members", 
	uniqueConstraints = { 
		@UniqueConstraint(name = "uk_member_loginId", 
			columnNames = {"loginId"}),
		@UniqueConstraint(name = "uk_member_email", 
			columnNames = {"email"}),
		@UniqueConstraint(name = "uk_member_phoneNum", 
			columnNames = {"phoneNum"})
	})
public class Member {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long memberId;
	
	@ManyToMany
	@JoinTable(name = "member_authority",
	joinColumns = {@JoinColumn(name = "memberId", referencedColumnName = "memberId")},
	inverseJoinColumns = {@JoinColumn(name = "authorityName", referencedColumnName = "authorityName")})
	private Set<Authority> authorities;
	
	@Column(nullable = false, length = 50, updatable = false)
	private String loginId;
	
	@Column(nullable = false, length = 255)
	private String password;
	
	@Column(nullable = false, length = 50)
	private String name;
	
	@Column(nullable = false)
	@Temporal(TemporalType.DATE)
	private LocalDate birthDate;
	
	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private Gender gender;
	
	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private Nationality nationality;
	
	@Column(nullable = false, length = 100)
	private String email;
	
	@Column(nullable = false, length = 20)
	private String phoneNum;
	
	@Column
	@Temporal(TemporalType.TIMESTAMP)
	private LocalDateTime joinDate;
	
	@Column
	private boolean isActive;
	
	private String photo;
	
	private String resume;

	public Member() {
		super();
	}

	public Member(Long memberId, Set<Authority> authorities, String loginId, String password, String name,
			LocalDate birthDate, Gender gender, Nationality nationality, String email, String phoneNum,
			LocalDateTime joinDate, boolean isActive, String photo, String resume) {
		super();
		this.memberId = memberId;
		this.authorities = authorities;
		this.loginId = loginId;
		this.password = password;
		this.name = name;
		this.birthDate = birthDate;
		this.gender = gender;
		this.nationality = nationality;
		this.email = email;
		this.phoneNum = phoneNum;
		this.joinDate = joinDate;
		this.isActive = isActive;
		this.photo = photo;
		this.resume = resume;
	}

	public Long getMemberId() {
		return memberId;
	}

	public void setMemberId(Long memberId) {
		this.memberId = memberId;
	}

	public Set<Authority> getAuthorities() {
		return authorities;
	}

	public void setAuthorities(Set<Authority> authorities) {
		this.authorities = authorities;
	}

	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public Nationality getNationality() {
		return nationality;
	}

	public void setNationality(Nationality nationality) {
		this.nationality = nationality;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	public LocalDateTime getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(LocalDateTime joinDate) {
		this.joinDate = joinDate;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getResume() {
		return resume;
	}

	public void setResume(String resume) {
		this.resume = resume;
	}


}
