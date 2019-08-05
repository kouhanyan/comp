package com.wenda.comp.model;

import java.io.Serializable;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * <p>
 * Description: ϵͳ�û�
 * </p>
 * Copyright: Copyright (c) 2012 Company: wenda
 * 
 * @Author sfy
 * @Version 1.0 2014-07-21
 */
@Entity
@Cacheable
@Table(name = "sys_user")
@SequenceGenerator(name = "s_sys_user", sequenceName = "s_sys_user", allocationSize = 1)
public class SysUser implements Serializable {
    
    /**
	 * 
	 */
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "s_sys_user")
    private Long id;
    
    @ManyToOne
    @NotNull
    private School school;// ѧУʵ��
    
    @ManyToOne
    @JoinColumn(name = "sys_role_id")
    @NotNull
    private SysRole sysRole;// ��ɫʵ��
    
    @Column(name = "user_name")
    @NotEmpty
    private String userName;// �û���
    
    @NotEmpty
    private String password;// ����
    
    private String name;// ��ʵ����
    
    private String email;// �����ַ
    
    private String phone;// ��ϵ�绰
    
    @Column(name = "limit_ip")
    private String limitIp;// ���޵�ip
    
    @Column(name = "is_stop")
    private Integer isStop;// �Ƿ�ͣ��
    
    @Transient
    public String getStopMessage() {
        if (isStop.intValue() == 1) {
            return "����";
        } else {
            return "ͣ��";
        }
    }
    
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public School getSchool() {
        return school;
    }
    
    public void setSchool(School school) {
        this.school = school;
    }
    
    public SysRole getSysRole() {
        return sysRole;
    }
    
    public void setSysRole(SysRole sysRole) {
        this.sysRole = sysRole;
    }
    
    public String getUserName() {
        return userName;
    }
    
    public void setUserName(String userName) {
        this.userName = userName;
    }
    
    public String getPassword() {
        return password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getPhone() {
        return phone;
    }
    
    public void setPhone(String phone) {
        this.phone = phone;
    }
    
    public String getLimitIp() {
        return limitIp;
    }
    
    public void setLimitIp(String limitIp) {
        this.limitIp = limitIp;
    }
    
    public Integer getIsStop() {
        return isStop;
    }
    
    public void setIsStop(Integer isStop) {
        this.isStop = isStop;
    }
    
}
