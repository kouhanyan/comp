package com.wenda.comp.common.util;

import java.text.ParseException;
import java.util.Date;


import org.apache.commons.lang.time.DateUtils;

/**
 * 日期类型转换器
 * 
 * @author jinzhaopo
 * 
 */
public class DateEditor {
	public static final String DATE_PATTERNS[] = { "yyyy", "yyyy-MM", "yyyyMM",
			"yyyy/MM", "yyyy-MM-dd", "yyyyMMdd", "yyyy/MM/dd",
			"yyyy-MM-dd HH:mm:ss", "yyyyMMddHHmmss", "yyyy/MM/dd HH:mm:ss",
			"yyyy.MM", "yyyy.MM.dd" };

	/**
	 * 根据字符串获取日期类型
	 * 
	 * @param text
	 * @return
	 */
	public static Date getDate(String text) {
		Date date = new Date();
		try {
			date = DateUtils.parseDate(text, DATE_PATTERNS);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;

	}

}
