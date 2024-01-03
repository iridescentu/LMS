package project.lms.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(name = "roles", uniqueConstraints = {
        @UniqueConstraint(columnNames = "roleName")
})
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long roleId; // 역할의 고유 ID

    @Column(nullable = false, length = 50)
    private String roleName; // 역할 이름

    // 기본 생성자
    public Role() {
        super();
    }

    // 전체 생성자
	public Role(Long roleId, String roleName) {
		super();
		this.roleId = roleId;
		this.roleName = roleName;
	}

    // Getters and Setters
	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

}