package project.lms.enumstatus;

public enum PaymentStatus {
    PAID("결제 완료"),
    CANCELED("결제 취소"),
    PENDING("결제 보류");
	
	private final String desc;
	
	private PaymentStatus(String desc) {
		this.desc = desc;
	}
	
	public String getDesc() {
		return desc;
	}
}
