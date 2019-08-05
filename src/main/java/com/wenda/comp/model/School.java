package com.wenda.comp.model;

import java.io.Serializable;
import java.util.Date;

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
import org.springframework.format.annotation.DateTimeFormat;

/**
 * <p>
 * Description: 学校实体类
 * </p>
 * Copyright: Copyright (c) 2014 Company: wenda
 * 
 * @Author ylb
 * @Version 1.0 2014-07-21
 */

@Entity
@Cacheable
@Table(name = "school")
@SequenceGenerator(name = "s_school", sequenceName = "s_school", allocationSize = 1)
public class School implements Serializable {
    
    /**
	 * 
	 */
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "s_school")
    private Long id;// id
    
    @NotEmpty
    @Column(name = "school_code")
    private String schoolCode;// 学校代码
    
    @Column(name = "simple_name")
    private String simpleName;// 学校简称
    
    @NotEmpty
    @Column(name = "school_name")
    private String schoolName;// 学校名称
    
    @Column(name = "province_code")
    private String provinceCode;// 省代码
    
    @Column(name = "city_code")
    private String cityCode;// 市代码
    
    @Column(name = "county_code")
    private String countyCode;// 县代码
    
    @JoinColumn(name = "sys_region_id")
    @ManyToOne
    private SysRegion sysRegion;
    
    @NotNull
    private Integer type;// 类型
    
    @Column(nullable=true)
    private Boolean free;// 是否免费
    
    @Column(name = "mandate_expires_date")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date mandateExpiresDate;// 授权到期的时间
    
    private Long agent_user_id;// 代理id 应该不为null 但是温州地区没有
    
    @Column(name = "is_stop")
    private Integer isStop;// 停用标志(1允许2停用)
    
    @Column(name = "mandate_code")
    private String mandateCode;
    
    
    @Transient
    public boolean getManadateBoolean() {
        if(mandateExpiresDate == null) return false;
        if (new Date().getTime() >= mandateExpiresDate.getTime()) {
            // 说明已经超期了
            return true;
        } else {
            return false;
        }
    }
    
    public Boolean getFree() {
        return free;
    }
    
    public void setFree(Boolean free) {
        this.free = free;
    }
    
    public String getMandateCode() {
        return mandateCode;
    }
    
    public void setMandateCode(String mandateCode) {
        this.mandateCode = mandateCode;
    }
    
    public Long getAgent_user_id() {
        return agent_user_id;
    }
    
    public void setAgent_user_id(Long agent_user_id) {
        this.agent_user_id = agent_user_id;
    }
    
    public Date getMandateExpiresDate() {
        return mandateExpiresDate;
    }
    
    public void setMandateExpiresDate(Date mandateExpiresDate) {
        this.mandateExpiresDate = mandateExpiresDate;
    }
    
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getSchoolCode() {
        return schoolCode;
    }
    
    public void setSchoolCode(String schoolCode) {
        this.schoolCode = schoolCode;
    }
    
    public String getSimpleName() {
        return simpleName;
    }
    
    public void setSimpleName(String simpleName) {
        this.simpleName = simpleName;
    }
    
    public String getSchoolName() {
        return schoolName;
    }
    
    public String getProvinceCode() {
        return provinceCode;
    }
    
    public void setProvinceCode(String provinceCode) {
        this.provinceCode = provinceCode;
    }
    
    public String getCityCode() {
        return cityCode;
    }
    
    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }
    
    public String getCountyCode() {
        return countyCode;
    }
    
    public void setCountyCode(String countyCode) {
        this.countyCode = countyCode;
    }
    
    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }
    
    public SysRegion getSysRegion() {
        return sysRegion;
    }
    
    public void setSysRegion(SysRegion sysRegion) {
        this.sysRegion = sysRegion;
    }
    
    public Integer getType() {
        return type;
    }
    
    public void setType(Integer type) {
        this.type = type;
    }
    
    public Integer getIsStop() {
        return isStop;
    }
    
    public void setIsStop(Integer isStop) {
        this.isStop = isStop;
    }
    
}
