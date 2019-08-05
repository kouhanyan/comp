package com.wenda.comp.model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(BiblioTemp.class)
public abstract class BiblioTemp_ {

	public static volatile SingularAttribute<BiblioTemp, String> batchName;
	public static volatile SingularAttribute<BiblioTemp, String> notes;
	public static volatile SingularAttribute<BiblioTemp, String> marcContent;
	public static volatile SingularAttribute<BiblioTemp, String> totalPrice;
	public static volatile ListAttribute<BiblioTemp, BiblioAcceptanceBook> biblioAcceptanceBooks;
	public static volatile SingularAttribute<BiblioTemp, String> subject;
	public static volatile SingularAttribute<BiblioTemp, String> isbn;
	public static volatile SingularAttribute<BiblioTemp, String> publishDate;
	public static volatile SingularAttribute<BiblioTemp, String> edition;
	public static volatile SingularAttribute<BiblioTemp, String> language;
	public static volatile SingularAttribute<BiblioTemp, Integer> hadInform;
	public static volatile SingularAttribute<BiblioTemp, String> title;
	public static volatile SingularAttribute<BiblioTemp, Long> batchId;
	public static volatile SingularAttribute<BiblioTemp, String> frequency;
	public static volatile SingularAttribute<BiblioTemp, String> attachment;
	public static volatile ListAttribute<BiblioTemp, Collection> collections;
	public static volatile SingularAttribute<BiblioTemp, String> price;
	public static volatile SingularAttribute<BiblioTemp, Long> schoolId;
	public static volatile SingularAttribute<BiblioTemp, String> unionNo;
	public static volatile SingularAttribute<BiblioTemp, Long> id;
	public static volatile SingularAttribute<BiblioTemp, Integer> marcFormat;
	public static volatile SingularAttribute<BiblioTemp, Long> sysUserId;
	public static volatile SingularAttribute<BiblioTemp, Date> createDate;
	public static volatile SingularAttribute<BiblioTemp, String> summary;
	public static volatile SingularAttribute<BiblioTemp, String> address;
	public static volatile SingularAttribute<BiblioTemp, String> orderNo;
	public static volatile SingularAttribute<BiblioTemp, String> author;
	public static volatile SingularAttribute<BiblioTemp, String> bookSize;
	public static volatile SingularAttribute<BiblioTemp, String> classNo;
	public static volatile SingularAttribute<BiblioTemp, Integer> isShare;
	public static volatile SingularAttribute<BiblioTemp, String> publisher;
	public static volatile SingularAttribute<BiblioTemp, String> page;
	public static volatile SingularAttribute<BiblioTemp, Integer> bookType;
	public static volatile SingularAttribute<BiblioTemp, Integer> status;

}

