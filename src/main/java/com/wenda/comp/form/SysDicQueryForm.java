package com.wenda.comp.form;

import com.wenda.comp.page.Pager;
/**
 * <p>
 * Description: �����ֵ��
 * </p>
 * Copyright: Copyright (c) 2012 Company: wenda
 * 
 * @Author sfy
 * @Version 1.0 2014-07-18
 */
public class SysDicQueryForm extends Pager{

	private Integer dicType;//�����ֵ�����
	
	private Integer dicKey;//�����ֵ��ֵ
	
	private String dicValue;//�����ֵ�����

	public Integer getDicType() {
		return dicType;
	}

	public void setDicType(Integer dicType) {
		this.dicType = dicType;
	}

	public Integer getDicKey() {
		return dicKey;
	}

	public void setDicKey(Integer dicKey) {
		this.dicKey = dicKey;
	}

	public String getDicValue() {
		return dicValue;
	}

	public void setDicValue(String dicValue) {
		this.dicValue = dicValue;
	}
	
	
}
