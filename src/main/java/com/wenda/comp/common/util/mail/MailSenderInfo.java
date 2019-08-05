package com.wenda.comp.common.util.mail;

import java.util.Arrays;
import java.util.Properties;

import com.wenda.comp.common.util.SettingUtils;

/**
 * �����ʼ���Ҫ�Ļ�����Ϣ
 * 
 * @author jinzhaopo
 * 
 */
public class MailSenderInfo {

	// �����ʼ��ķ�������IP�Ͷ˿�
	private String mailServerHost;
	private String mailServerPort = "25";
	// �ʼ������ߵĵ�ַ
	private String fromAddress;
	// �ʼ������ߵĵ�ַ
	private String toAddress;
	// ��½�ʼ����ͷ��������û���������
	private String userName;
	private String password;
	// �Ƿ���Ҫ�����֤
	private boolean validate = false;
	// �ʼ�����
	private String subject;
	// �ʼ����ı�����
	private String content;
	// �ʼ��������ļ���
	private String[] attachFileNames;

	public MailSenderInfo() {
		this.setMailServerHost(SettingUtils.get().getSmtpHost());
		this.setMailServerPort(SettingUtils.get().getSmtpPort().toString());
		this.setValidate(true);
		this.setUserName(SettingUtils.get().getSmtpUsername());
		this.setPassword(SettingUtils.get().getSmtpPassword().replaceAll("#", "&"));// ������������
		this.setFromAddress(SettingUtils.get().getSmtpFromMail());
	}

	public MailSenderInfo(String toAddress, String subject, String content) {
		this();
		this.toAddress = toAddress;
		this.subject = subject;
		this.content = content;
	}

	/**
	 * ����ʼ��Ự����
	 */
	public Properties getProperties() {
		Properties p = new Properties();
		p.put("mail.smtp.host", this.mailServerHost);
		p.put("mail.smtp.port", this.mailServerPort);
		p.put("mail.smtp.auth", validate ? "true" : "false");
		return p;
	}

	public String getMailServerHost() {
		return mailServerHost;
	}

	public void setMailServerHost(String mailServerHost) {
		this.mailServerHost = mailServerHost;
	}

	public String getMailServerPort() {
		return mailServerPort;
	}

	public void setMailServerPort(String mailServerPort) {
		this.mailServerPort = mailServerPort;
	}

	public boolean isValidate() {
		return validate;
	}

	public void setValidate(boolean validate) {
		this.validate = validate;
	}

	public String[] getAttachFileNames() {
		return attachFileNames;
	}

	public void setAttachFileNames(String[] fileNames) {
		this.attachFileNames = fileNames;
	}

	public String getFromAddress() {
		return fromAddress;
	}

	public void setFromAddress(String fromAddress) {
		this.fromAddress = fromAddress;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getToAddress() {
		return toAddress;
	}

	public void setToAddress(String toAddress) {
		this.toAddress = toAddress;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String textContent) {
		this.content = textContent;
	}

	@Override
	public String toString() {
		return "MailSenderInfo [mailServerHost=" + mailServerHost
				+ ", mailServerPort=" + mailServerPort + ", fromAddress="
				+ fromAddress + ", toAddress=" + toAddress + ", userName="
				+ userName + ", password=" + password + ", validate="
				+ validate + ", subject=" + subject + ", content=" + content
				+ ", attachFileNames=" + Arrays.toString(attachFileNames) + "]";
	}
	
	
}
