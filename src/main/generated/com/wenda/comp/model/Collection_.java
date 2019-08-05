package com.wenda.comp.model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Collection.class)
public abstract class Collection_ {

	public static volatile SingularAttribute<Collection, Double> totalPrice;
	public static volatile SingularAttribute<Collection, String> callNo;
	public static volatile SingularAttribute<Collection, String> remark;
	public static volatile SingularAttribute<Collection, Integer> type;
	public static volatile SingularAttribute<Collection, BiblioAcceptanceBook> biblioAcceptanceBook;
	public static volatile SingularAttribute<Collection, Long> barcodeNum;
	public static volatile SingularAttribute<Collection, Double> singlePrice;
	public static volatile SingularAttribute<Collection, School> school;
	public static volatile SingularAttribute<Collection, CollectionPlace> collectionPlace;
	public static volatile SingularAttribute<Collection, BiblioTemp> biblioTemp;
	public static volatile SingularAttribute<Collection, Integer> volNum;
	public static volatile SingularAttribute<Collection, Date> dealDate;
	public static volatile SingularAttribute<Collection, Long> id;
	public static volatile SingularAttribute<Collection, Long> sysUserId;
	public static volatile SingularAttribute<Collection, Integer> state;
	public static volatile SingularAttribute<Collection, String> barcode;
	public static volatile SingularAttribute<Collection, Date> createDate;
	public static volatile SingularAttribute<Collection, Long> bookSellerId;
	public static volatile SingularAttribute<Collection, String> bindNo;
	public static volatile SingularAttribute<Collection, Integer> mediaType;
	public static volatile SingularAttribute<Collection, Long> budgetId;
	public static volatile SingularAttribute<Collection, Integer> isHadRegist;
	public static volatile SingularAttribute<Collection, Integer> bindInfo;
	public static volatile SingularAttribute<Collection, BookCirculateType> bookCirculateType;
	public static volatile SingularAttribute<Collection, Integer> bookSource;
	public static volatile SingularAttribute<Collection, String> volInfo;
	public static volatile SingularAttribute<Collection, Integer> totalLendNum;
	public static volatile SingularAttribute<Collection, Integer> status;

}

