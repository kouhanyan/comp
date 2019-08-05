package com.wenda.comp.common.util;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;

/**
 * <p>
 * Description: ���󹤾���
 * </p>
 * Copyright: Copyright (c) 2012 Company: wenda
 * 
 * @Author jzp
 * @Version 1.0 2014-07-17
 */
public class RequestUtils {
	/**
	 * ��ȡ������IP
	 * 
	 * ��һ�������ʹ��Request.getRemoteAddr()���ɣ����Ǿ���nginx�ȷ��������������������ʧЧ��
	 * 
	 * �������ȴ�Header�л�ȡX-Real-IP������������ٴ�X-Forwarded-For��õ�һ��IP(��,�ָ�)��
	 * ����������������Request .getRemoteAddr()��
	 * 
	 * @param request
	 * @return
	 */
	public static String getIpAddr(HttpServletRequest request) {
		String ip = request.getHeader("X-Real-IP");
		if (!StringUtils.isBlank(ip) && !"unknown".equalsIgnoreCase(ip)) {
			return ip;
		}
		ip = request.getHeader("X-Forwarded-For");
		if (!StringUtils.isBlank(ip) && !"unknown".equalsIgnoreCase(ip)) {
			// ��η���������ж��IPֵ����һ��Ϊ��ʵIP��
			int index = ip.indexOf(',');
			if (index != -1) {
				return ip.substring(0, index);
			} else {
				return ip;
			}
		} else {
			return request.getRemoteAddr();
		}
	}
}
