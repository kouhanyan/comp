package com.wenda.comp.exception;

/**
 * <p>
 * Description: 业务方面的错误类
 * </p>
 * Copyright: Copyright (c) 2012 Company: pangu
 * 
 * @Author
 * @Version 1.0 2012-5-15
 */

@SuppressWarnings("serial")
public class BusinessException extends Exception {
	public BusinessException(String msg) {
		super(msg);
		System.out.println(msg);

	}
}
