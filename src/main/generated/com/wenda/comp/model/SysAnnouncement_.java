package com.wenda.comp.model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(SysAnnouncement.class)
public abstract class SysAnnouncement_ {

	public static volatile SingularAttribute<SysAnnouncement, String> sender;
	public static volatile SingularAttribute<SysAnnouncement, Date> sendDate;
	public static volatile SingularAttribute<SysAnnouncement, Long> id;
	public static volatile SingularAttribute<SysAnnouncement, Long> sysUserId;
	public static volatile SingularAttribute<SysAnnouncement, String> title;
	public static volatile SingularAttribute<SysAnnouncement, String> content;
	public static volatile SingularAttribute<SysAnnouncement, Boolean> isDisplay;

}

