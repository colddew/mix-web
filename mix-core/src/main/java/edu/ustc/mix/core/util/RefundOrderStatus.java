package edu.ustc.mix.core.util;

import java.util.ArrayList;
import java.util.List;

public enum RefundOrderStatus {
	
	CREATE(1, "已创建"),
	WAIT_RETURN_GOODS_AUDIT(2, "待退货审核"),
	REFUSE_RETURN_GOODS(3, "拒绝退货"),
	WAIT_RETURN_GOODS(4, "待买家退货"),
	WAIT_REFUND_AUDIT(5, "待退款审核"),
	WAIT_REFUND(6, "待退款"),
	AGREE_REFUND(7, "同意退款"),
	REFUSE_REFUND(8, "拒绝退款"),
	SUCCESS(9, "退款成功");
	
	private Integer value;
	private String display;
	
	private RefundOrderStatus(Integer value, String display) {
		this.value = value;
		this.display = display;
	}
	
	public Integer getValue() {
		return value;
	}
	
	public String getDisplay() {
		return display;
	}
	
	public static RefundOrderStatus getRefundOrderStatus(Integer value) {
		
		for(RefundOrderStatus status : values()) {
			
			if(status.getValue().equals(value)) {
				return status;
			}
		}
		
		return null;
	}
	
	public static List<String> getRefundOrderStatusDisplays() {
		
		List<String> list = new ArrayList<String>();
		
		for(RefundOrderStatus status : values()) {
			list.add(status.getDisplay());
		}
		
		return list;
	}
	
	public static void main(String[] args) {
		
		System.out.println(RefundOrderStatus.getRefundOrderStatus(2));
		System.out.println(RefundOrderStatus.getRefundOrderStatus(2).getDisplay());
		System.out.println(getRefundOrderStatusDisplays());
	}
}
