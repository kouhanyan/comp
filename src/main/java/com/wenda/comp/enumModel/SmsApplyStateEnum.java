package com.wenda.comp.enumModel;

/**
 * ����״̬
 * 
 * @author jinzhaopo
 * 
 */
public enum SmsApplyStateEnum {
	APPLY_SUCCESS("����ɹ�"), HANDLE_SUCCESS("����ɹ�");

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
