package com.wenda.comp.model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(SysVersion.class)
public abstract class SysVersion_ {

	public static volatile SingularAttribute<SysVersion, String> releaseNotes;
	public static volatile SingularAttribute<SysVersion, Date> modifyDate;
	public static volatile SingularAttribute<SysVersion, Boolean> isCurrentVersion;
	public static volatile SingularAttribute<SysVersion, String> edition;
	public static volatile SingularAttribute<SysVersion, Long> id;
	public static volatile SingularAttribute<SysVersion, String> directory;
	public static volatile SingularAttribute<SysVersion, String> characteristic;
	public static volatile SingularAttribute<SysVersion, Date> createDate;

}

