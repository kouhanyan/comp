package com.wenda.comp.service.impl;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import org.springframework.stereotype.Service;

import com.wenda.comp.common.util.HttpRequestor;
import com.wenda.comp.common.util.SettingUtils;
import com.wenda.comp.service.MailService;

@Service
public class MailServiceImpl implements MailService {

	public boolean sendMail(String content, String email, String subject) {
		// // ��װ����
		// MailSenderInfo mailInfo = new MailSenderInfo();
		// mailInfo.setToAddress(email);
		// mailInfo.setSubject("��ͼ���");
		// mailInfo.setContent(content);
		// // ����html��ʽ
		// return SimpleMailSender.sendHtmlMail(mailInfo);
		try {
			String parameterData = "content="
					+ URLEncoder.encode(content, "utf-8") + "&email="
					+ URLEncoder.encode(email, "utf-8") + "&subject="
					+ URLEncoder.encode(subject, "utf-8");
			String url = SettingUtils.get().getSendMailUrl();
			return HttpRequestor.doPost(url, parameterData, "utf-8").equals(
					"true") ? true : false;
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;

	}

}
