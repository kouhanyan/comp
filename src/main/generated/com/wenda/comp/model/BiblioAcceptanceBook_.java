package com.wenda.comp.model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(BiblioAcceptanceBook.class)
public abstract class BiblioAcceptanceBook_ {

	public static volatile SingularAttribute<BiblioAcceptanceBook, Integer> coplies;
	public static volatile SingularAttribute<BiblioAcceptanceBook, Date> acceptDate;
	public static volatile SingularAttribute<BiblioAcceptanceBook, Double> discountRate;
	public static volatile SingularAttribute<BiblioAcceptanceBook, Double> totalPrice;
	public static volatile SingularAttribute<BiblioAcceptanceBook, String> callNo;
	public static volatile SingularAttribute<BiblioAcceptanceBook, Double> discountPrice;
	public static volatile SingularAttribute<BiblioAcceptanceBook, Integer> mediaType;
	public static volatile SingularAttribute<BiblioAcceptanceBook, String> remark;
	public static volatile SingularAttribute<BiblioAcceptanceBook, String> libLocal;
	public static volatile SingularAttribute<BiblioAcceptanceBook, Integer> bindInfo;
	public static volatile SingularAttribute<BiblioAcceptanceBook, Double> singlePrice;
	public static volatile ListAttribute<BiblioAcceptanceBook, Collection> collections;
	public static volatile SingularAttribute<BiblioAcceptanceBook, Long> schoolId;
	public static volatile SingularAttribute<BiblioAcceptanceBook, BiblioTemp> biblioTemp;
	public static volatile SingularAttribute<BiblioAcceptanceBook, Integer> volNum;
	public static volatile SingularAttribute<BiblioAcceptanceBook, Long> id;
	public static volatile SingularAttribute<BiblioAcceptanceBook, Long> sysUserId;
	public static volatile SingularAttribute<BiblioAcceptanceBook, String> volInfo;
	public static volatile SingularAttribute<BiblioAcceptanceBook, Integer> bookSource;

}

