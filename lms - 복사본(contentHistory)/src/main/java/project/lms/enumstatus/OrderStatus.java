package project.lms.enumstatus;

public enum OrderStatus {

	PROCESSING("처리 중"),
    COMPLETED("완료"),
    CANCELED("취소");
	
	private final String desc;
	
	private OrderStatus(String desc) {
		this.desc = desc;
	}
	
	public String getDesc() {
		return desc;
	}
    
}
