package com.wenda.comp.model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(CompLog.class)
public abstract class CompLog_ {

	public static volatile SingularAttribute<CompLog, String> ip;
	public static volatile SingularAttribute<CompLog, Long> id;
	public static volatile SingularAttribute<CompLog, String> userName;
	public static volatile SingularAttribute<CompLog, Date> createDate;

}

