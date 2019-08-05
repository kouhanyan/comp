package com.wenda.comp.common.util.mail;

import java.util.Arrays;
import java.util.Properties;

import com.wenda.comp.common.util.SettingUtils;

/**
 * 发送邮件需要的基本信息
 * 
 * @author jinzhaopo
 * 
 */
public class MailSenderInfo {

	// 发送邮件的服务器的IP和端口
	private String mailServerHost;
	private String mailServerPort = "25";
	// 邮件发送者的地址
	private String fromAddress;
	// 邮件接收者的地址
	private String toAddress;
	// 登陆邮件发送服务器的用户名和密码
	private String userName;
	private String password;
	// 是否需要身份验证
	private boolean validate = false;
	// 邮件主题
	private String subject;
	// 邮件的文本内容
	private String content;
	// 邮件附件的文件名
	private String[] attachFileNames;

	public MailSenderInfo() {
		this.setMailServerHost(SettingUtils.get().getSmtpHost());
		this.setMailServerPort(SettingUtils.get().getSmtpPort().toString());
		this.setValidate(true);
		this.setUserName(SettingUtils.get().getSmtpUsername());
		this.setPassword(SettingUtils.get().getSmtpPassword().replaceAll("#", "&"));// 您的邮箱密码
		this.setFromAddress(SettingUtils.get().getSmtpFromMail());
	}

	public MailSenderInfo(String toAddress, String subject, String content) {
		this();
		this.toAddress = toAddress;
		this.subject = subject;
		this.content = content;
	}

	/**
	 * 获得邮件会话属性
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
