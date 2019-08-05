package com.wenda.comp.model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(School.class)
public abstract class School_ {

	public static volatile SingularAttribute<School, Long> agent_user_id;
	public static volatile SingularAttribute<School, SysRegion> sysRegion;
	public static volatile SingularAttribute<School, Integer> isStop;
	public static volatile SingularAttribute<School, String> provinceCode;
	public static volatile SingularAttribute<School, String> cityCode;
	public static volatile SingularAttribute<School, Integer> type;
	public static volatile SingularAttribute<School, String> countyCode;
	public static volatile SingularAttribute<School, String> simpleName;
	public static volatile SingularAttribute<School, Date> mandateExpiresDate;
	public static volatile SingularAttribute<School, String> mandateCode;
	public static volatile SingularAttribute<School, Long> id;
	public static volatile SingularAttribute<School, String> schoolName;
	public static volatile SingularAttribute<School, Boolean> free;
	public static volatile SingularAttribute<School, String> schoolCode;

}

