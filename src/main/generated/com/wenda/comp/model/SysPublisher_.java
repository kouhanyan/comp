package com.wenda.comp.model;

import java.sql.Timestamp;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(SysPublisher.class)
public abstract class SysPublisher_ {

	public static volatile SingularAttribute<SysPublisher, String> code;
	public static volatile SingularAttribute<SysPublisher, String> cityName;
	public static volatile SingularAttribute<SysPublisher, School> school;
	public static volatile SingularAttribute<SysPublisher, String> cityCode;
	public static volatile SingularAttribute<SysPublisher, String> name;
	public static volatile SingularAttribute<SysPublisher, Long> id;
	public static volatile SingularAttribute<SysPublisher, Timestamp> createDate;

}

