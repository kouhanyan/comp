package com.wenda.comp.vo;

/**
 * <p>
 * Description: marc�ֶ�
 * </p>
 * Copyright: Copyright (c) 2012 Company: wenda
 * 
 * @Author sfy
 * @Version 1.0 2014-07-18
 */
public class MarcField {

	private String marcMark;//�Ǳ����ֶ�Ϊ�ձ�ʶ��
	
	private String key;// marc�ֶμ�ֵ

	private String sign;// marcָʾ��

	private String content;// marc�ֶ�����
	
	public String getMarcMark() {
		return marcMark;
	}

	public void setMarcMark(String marcMark) {
		this.marcMark = marcMark;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}
