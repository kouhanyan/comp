package com.wenda.comp.service;
/**
 * 邮件发送
 * @author jinzhaopo
 *
 */
public interface MailService {
	/**
	 * 以html的显示发送
	 * @param content
	 * @param email
	 * @return
	 */
	public boolean sendMail(String content,String email,String subject);

}
