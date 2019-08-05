package com.wenda.comp.form;

import com.wenda.comp.page.Pager;
/**
 * <p>
 * Description: 数据字典表单
 * </p>
 * Copyright: Copyright (c) 2012 Company: wenda
 * 
 * @Author sfy
 * @Version 1.0 2014-07-18
 */
public class SysDicQueryForm extends Pager{

	private Integer dicType;//数据字典类型
	
	private Integer dicKey;//数据字典键值
	
	private String dicValue;//数据字典内容

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
