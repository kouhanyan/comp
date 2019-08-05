package com.wenda.comp.model;

import java.sql.Timestamp;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(BookCirculateType.class)
public abstract class BookCirculateType_ {

	public static volatile SingularAttribute<BookCirculateType, Integer> isDefault;
	public static volatile SingularAttribute<BookCirculateType, String> code;
	public static volatile SingularAttribute<BookCirculateType, School> school;
	public static volatile SingularAttribute<BookCirculateType, String> name;
	public static volatile SingularAttribute<BookCirculateType, String> description;
	public static volatile SingularAttribute<BookCirculateType, Long> id;
	public static volatile SingularAttribute<BookCirculateType, SysUser> sysUser;
	public static volatile SingularAttribute<BookCirculateType, Integer> isAllowPre;
	public static volatile SingularAttribute<BookCirculateType, Timestamp> createDate;

}

