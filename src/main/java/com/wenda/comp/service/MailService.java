package com.wenda.comp.service;
/**
 * �ʼ�����
 * @author jinzhaopo
 *
 */
public interface MailService {
	/**
	 * ��html����ʾ����
	 * @param content
	 * @param email
	 * @return
	 */
	public boolean sendMail(String content,String email,String subject);

}
