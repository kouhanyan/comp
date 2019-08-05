package com.wenda.comp.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(SysUser.class)
public abstract class SysUser_ {

	public static volatile SingularAttribute<SysUser, SysRole> sysRole;
	public static volatile SingularAttribute<SysUser, String> password;
	public static volatile SingularAttribute<SysUser, Integer> isStop;
	public static volatile SingularAttribute<SysUser, School> school;
	public static volatile SingularAttribute<SysUser, String> phone;
	public static volatile SingularAttribute<SysUser, String> name;
	public static volatile SingularAttribute<SysUser, Long> id;
	public static volatile SingularAttribute<SysUser, String> userName;
	public static volatile SingularAttribute<SysUser, String> limitIp;
	public static volatile SingularAttribute<SysUser, String> email;

}

