package com.wenda.comp.enumModel;

/**
 * 申请状态
 * 
 * @author jinzhaopo
 * 
 */
public enum SmsApplyStateEnum {
	APPLY_SUCCESS("申请成功"), HANDLE_SUCCESS("处理成功");

	private String name;

	private SmsApplyStateEnum(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
