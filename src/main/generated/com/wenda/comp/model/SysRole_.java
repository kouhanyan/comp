package com.wenda.comp.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(SysRole.class)
public abstract class SysRole_ {

	public static volatile SingularAttribute<SysRole, String> roleDesc;
	public static volatile SingularAttribute<SysRole, School> school;
	public static volatile SingularAttribute<SysRole, String> name;
	public static volatile SingularAttribute<SysRole, Long> id;

}

