package com.wenda.comp.enumModel;
/**
 * 识别号类别
 * @author jinzhaopo
 *
 */
public enum IDTypeEnum {
	帐号("1"),//帐号
	卡号("2"),//卡号
	卡内编号("3"),//卡内编号
	个人编号("4"),//个人编号
	第三方对接号("5");//第三方对接号
	
	private String key;

	private IDTypeEnum(String key) {
		this.key = key;
	}

	public String getKey() {
		return key;
	}
	
	
	
}
