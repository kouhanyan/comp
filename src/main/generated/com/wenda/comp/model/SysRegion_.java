package com.wenda.comp.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(SysRegion.class)
public abstract class SysRegion_ {

	public static volatile SingularAttribute<SysRegion, String> code;
	public static volatile SingularAttribute<SysRegion, String> name;
	public static volatile SingularAttribute<SysRegion, String> remark;
	public static volatile SingularAttribute<SysRegion, Long> id;
	public static volatile SingularAttribute<SysRegion, Integer> regionLevel;
	public static volatile SingularAttribute<SysRegion, Long> parentId;

}

