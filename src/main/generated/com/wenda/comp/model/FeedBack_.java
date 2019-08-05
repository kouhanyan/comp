package com.wenda.comp.model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(FeedBack.class)
public abstract class FeedBack_ {

	public static volatile SingularAttribute<FeedBack, String> problem;
	public static volatile SingularAttribute<FeedBack, String> sysUserName;
	public static volatile SingularAttribute<FeedBack, String> imagePath;
	public static volatile SingularAttribute<FeedBack, Long> schoolId;
	public static volatile SingularAttribute<FeedBack, Integer> isDeal;
	public static volatile SingularAttribute<FeedBack, Long> id;
	public static volatile SingularAttribute<FeedBack, Long> sysUserId;
	public static volatile SingularAttribute<FeedBack, String> schoolName;
	public static volatile SingularAttribute<FeedBack, Date> createDate;

}

