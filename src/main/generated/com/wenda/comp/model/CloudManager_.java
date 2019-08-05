package com.wenda.comp.model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(CloudManager.class)
public abstract class CloudManager_ {

	public static volatile SingularAttribute<CloudManager, School> school;
	public static volatile SingularAttribute<CloudManager, Long> id;
	public static volatile SingularAttribute<CloudManager, String> describe;
	public static volatile SingularAttribute<CloudManager, Integer> dealStatus;
	public static volatile SingularAttribute<CloudManager, Long> sysUserId;
	public static volatile SingularAttribute<CloudManager, Date> createDate;

}

