package com.wenda.comp.model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(SmsUseState.class)
public abstract class SmsUseState_ {

	public static volatile SingularAttribute<SmsUseState, Long> schoolId;
	public static volatile SingularAttribute<SmsUseState, Long> usedSms;
	public static volatile SingularAttribute<SmsUseState, Long> id;
	public static volatile SingularAttribute<SmsUseState, Date> effectiveDate;
	public static volatile SingularAttribute<SmsUseState, Long> enableSms;

}

