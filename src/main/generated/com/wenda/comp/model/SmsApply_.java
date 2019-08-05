package com.wenda.comp.model;

import com.wenda.comp.enumModel.SmsApplyStateEnum;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(SmsApply.class)
public abstract class SmsApply_ {

	public static volatile SingularAttribute<SmsApply, Double> amount;
	public static volatile SingularAttribute<SmsApply, String> contactEmail;
	public static volatile SingularAttribute<SmsApply, String> contactName;
	public static volatile SingularAttribute<SmsApply, SmsApplyStateEnum> applyState;
	public static volatile SingularAttribute<SmsApply, String> project;
	public static volatile SingularAttribute<SmsApply, String> userName;
	public static volatile SingularAttribute<SmsApply, Long> applyNum;
	public static volatile SingularAttribute<SmsApply, Long> userId;
	public static volatile SingularAttribute<SmsApply, Long> schoolId;
	public static volatile SingularAttribute<SmsApply, Date> dealDate;
	public static volatile SingularAttribute<SmsApply, Long> id;
	public static volatile SingularAttribute<SmsApply, String> schoolName;
	public static volatile SingularAttribute<SmsApply, Date> applyDate;
	public static volatile SingularAttribute<SmsApply, String> contactPhone;

}

