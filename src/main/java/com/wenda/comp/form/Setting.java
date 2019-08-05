package com.wenda.comp.form;

import java.io.Serializable;

/**
 * 系统的配置信息
 * 
 * @author jinzhaopo
 * 
 */
@SuppressWarnings("serial")
public class Setting implements Serializable {
	public static final String CACHE_NAME = "setting";
	public static final Integer CACHE_KEY = 0;

	// ===============邮件设置===========================
	private String smtpFromMail;// 发件人邮箱
	private String smtpHost;// SMTP服务器地址
	private Integer smtpPort;// SMTP服务器端口
	private String smtpUsername;// SMTP用户名
	private String smtpPassword;// SMTP密码
	private Integer buildHtmlDelayTime;// HTML自动生成延时

	private String sendMailUrl;// 发送邮件的地址

	// =============短信设置============
	private String smsAddress;// 短信webservice的地址
	private String smsApplicationId;// 短信用户名
	private String smsPassWord;// 短信密码
	private String smsExtendCode;// 自定义扩展代码快

	private boolean createRole;// 是否创建角色

	private boolean charge;// 收费
	private String agentUrl;// 云图代理url

	public String getAgentUrl() {
		return agentUrl;
	}

	public void setAgentUrl(String agentUrl) {
		this.agentUrl = agentUrl;
	}

	public boolean isCharge() {
		return charge;
	}

	public void setCharge(boolean charge) {
		this.charge = charge;
	}

	public String getSendMailUrl() {
		return sendMailUrl;
	}

	public void setSendMailUrl(String sendMailUrl) {
		this.sendMailUrl = sendMailUrl;
	}

	public boolean isCreateRole() {
		return createRole;
	}

	public void setCreateRole(boolean createRole) {
		this.createRole = createRole;
	}

	public String getSmsExtendCode() {
		return smsExtendCode;
	}

	public void setSmsExtendCode(String smsExtendCode) {
		this.smsExtendCode = smsExtendCode;
	}

	public String getSmsAddress() {
		return smsAddress;
	}

	public void setSmsAddress(String smsAddress) {
		this.smsAddress = smsAddress;
	}

	public String getSmsApplicationId() {
		return smsApplicationId;
	}

	public void setSmsApplicationId(String smsApplicationId) {
		this.smsApplicationId = smsApplicationId;
	}

	public String getSmsPassWord() {
		return smsPassWord;
	}

	public void setSmsPassWord(String smsPassWord) {
		this.smsPassWord = smsPassWord;
	}

	public String getSmtpFromMail() {
		return smtpFromMail;
	}

	public void setSmtpFromMail(String smtpFromMail) {
		this.smtpFromMail = smtpFromMail;
	}

	public String getSmtpHost() {
		return smtpHost;
	}

	public void setSmtpHost(String smtpHost) {
		this.smtpHost = smtpHost;
	}

	public Integer getSmtpPort() {
		return smtpPort;
	}

	public void setSmtpPort(Integer smtpPort) {
		this.smtpPort = smtpPort;
	}

	public String getSmtpUsername() {
		return smtpUsername;
	}

	public void setSmtpUsername(String smtpUsername) {
		this.smtpUsername = smtpUsername;
	}

	public String getSmtpPassword() {
		return smtpPassword;
	}

	public void setSmtpPassword(String smtpPassword) {
		this.smtpPassword = smtpPassword;
	}

	public Integer getBuildHtmlDelayTime() {
		return buildHtmlDelayTime;
	}

	public void setBuildHtmlDelayTime(Integer buildHtmlDelayTime) {
		this.buildHtmlDelayTime = buildHtmlDelayTime;
	}

}
