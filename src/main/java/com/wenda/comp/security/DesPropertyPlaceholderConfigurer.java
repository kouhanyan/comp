package com.wenda.comp.security;
import java.util.Enumeration;
import java.util.Properties;

import org.springframework.util.ObjectUtils;

/**
 * <p>
 * Description: 数据库用户名密码加密
 * </p>
 * Copyright: Copyright (c) 2012 Company: wenda
 * 
 * @Author sfy
 * @Version 1.0 2014-07-31
 */
public class DesPropertyPlaceholderConfigurer extends
		org.springframework.beans.factory.config.PropertyPlaceholderConfigurer {

	private static final String ENCRYPTED = "encrypted.";

	private DesBase64Crypto crypto = new DesBase64Crypto();

	@Override
	protected void convertProperties(Properties props) {
		Enumeration propertyNames = props.propertyNames();
		while (propertyNames.hasMoreElements()) {
			String propertyName = (String) propertyNames.nextElement();
			String propertyValue = props.getProperty(propertyName);
			String convertedValue = "";
			if (propertyName.startsWith(ENCRYPTED)) {
				// propertyName = propertyName.substring(ENCRYPTED.length());
				convertedValue = crypto.decrypt(propertyValue);
			} else {
				convertedValue = convertPropertyValue(propertyValue);
			}

			if (!ObjectUtils.nullSafeEquals(propertyValue, convertedValue)) {
				props.setProperty(propertyName, convertedValue);
			}
		}
	}

	public DesPropertyPlaceholderConfigurer() {
		super();
	}
}
