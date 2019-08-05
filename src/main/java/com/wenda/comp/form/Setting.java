package com.wenda.comp.form;

import java.io.Serializable;

/**
 * ϵͳ��������Ϣ
 * 
 * @author jinzhaopo
 * 
 */
@SuppressWarnings("serial")
public class Setting implements Serializable {
	public static final String CACHE_NAME = "setting";
	public static final Integer CACHE_KEY = 0;

	// ===============�ʼ�����===========================
	private String smtpFromMail;// ����������
	private String smtpHost;// SMTP��������ַ
	private Integer smtpPort;// SMTP�������˿�
	private String smtpUsername;// SMTP�û���
	private String smtpPassword;// SMTP����
	private Integer buildHtmlDelayTime;// HTML�Զ�������ʱ

	private String sendMailUrl;// �����ʼ��ĵ�ַ

	// =============��������============
	private String smsAddress;// ����webservice�ĵ�ַ
	private String smsApplicationId;// �����û���
	private String smsPassWord;// ��������
	private String smsExtendCode;// �Զ�����չ�����

	private boolean createRole;// �Ƿ񴴽���ɫ

	private boolean charge;// �շ�
	private String agentUrl;// ��ͼ����url

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
