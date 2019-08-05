package com.wenda.comp.model;

import java.sql.Timestamp;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(SysDesktop.class)
public abstract class SysDesktop_ {

	public static volatile SingularAttribute<SysDesktop, String> name;
	public static volatile SingularAttribute<SysDesktop, Integer> screenNo;
	public static volatile SingularAttribute<SysDesktop, Long> id;
	public static volatile SingularAttribute<SysDesktop, String> url;
	public static volatile SingularAttribute<SysDesktop, Timestamp> createDate;

}

