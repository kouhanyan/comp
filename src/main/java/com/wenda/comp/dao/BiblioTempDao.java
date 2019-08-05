package com.wenda.comp.dao;

import java.sql.Clob;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.wenda.comp.model.BiblioTemp;


/**
 * <p>
 * Description: ��ʱ��dao
 * </p>
 * Copyright: Copyright (c) 2012 Company: wenda
 * 
 * @Author sfy
 * @Version 1.0 2014-07-21
 */
@Repository

public interface BiblioTempDao extends JpaRepository<BiblioTemp, Long> {

	/**
	 * ͨ��ѧУ������ʱ����Ŀ����
	 * 
	 * @param schoolId
	 * @param pageable
	 * @return
	 */
	@Query("select t from BiblioTemp t where t.schoolId=?1 and t.bookType=?2")
	public Page<BiblioTemp> findBySchool(Long schoolId, Integer bookType,
			Pageable pageable);

	/**
	 * ͨ����ĿId���Ϻ�ѧУId����
	 * 
	 * @param ids
	 * @param schoolId
	 * @return
	 */
	@Query("select t from BiblioTemp t where t.schoolId=?1 and t.bookType=?2 and t.id in(select t1.biblioTemp.id from BookOrder t1 where t1.type=?3)")
	public Page<BiblioTemp> findByIdsAndSchool(Long schoolId, Integer bookType,
			Integer type, Pageable pageable);

	/**
	 * ͨ�������������β��Ҷ�Ӧ��Ŀ
	 * 
	 * @param batchId
	 * @param pageable
	 * @return
	 */
	@Query("select t from BiblioTemp t where t.batchId=?1 and t.bookType=?2")
	public Page<BiblioTemp> findBySellerBatch(Long batchId, Integer bookType,
			Pageable pageable);

	/**
	 * ͨ�������������β��Ҷ�Ӧ��Ŀ
	 * 
	 * @param batchId
	 * @param pageable
	 * @return
	 */
	@Query("select t from BiblioTemp t where t.batchId=?1 and t.bookType=?2")
	public List<BiblioTemp> findBySellerBatch(Long batchId, Integer bookType);

	/**
	 * ��ȡԤ��������Ŀ����
	 * 
	 * @param bookOrderId
	 * @return
	 */
	@Query("select t from BiblioTemp t where t.id in(select t1.biblioTemp.id from BookOrder t1 where t1.batch.id=?1 and t1.type=?2)")
	public List<BiblioTemp> findByExitOrder(Long batchId, Integer type);

	/**
	 * ��ȡԤ��������Ŀ����
	 * 
	 * @param bookOrderId
	 * @return
	 */
	@Query("select t from BiblioTemp t where t.id in(select t1.biblioTemp.id from BookOrder t1 where t1.batch.id=?1 and t1.type=?2)")
	public Page<BiblioTemp> findByExitOrder(Long batchId, Integer type,Pageable pageable);
	
	/**
	 * ��ȡ�ǵ��б�
	 * ���ü��ϲ�Ҫ������ ��Ȼ�ᱨEncountered array-valued parameter binding, but was expecting [java.lang.Integer]��
	 * ʹ�þۺϺ�������group by����������ʱ�ر�˵����select �б����в����ڵ��п��Գ�����group by���б����У����������Ͳ����ˣ���select�б����г��ֵ��б���ȫ��������group by����(�ۺϺ�������)
	 * @param schoolId
	 * @param bookType
	 * @param pageable
	 * @return
	 */
	@Query("select t from BiblioTemp t where t.bookType = 2 and t.id in (select s.biblioTemp.id from SeriesOrder s  where s.schoolId =?1 and s.orderType in (?2) group by s.biblioTemp.id)")
	public Page<BiblioTemp> findForAccept(Long schoolId, List<Integer> orderType,
			Pageable pageable);
	
	/**
	 * ����marc���ݺ�����Idȥ��
	 * @param marcContent
	 * @param batchId
	 * @return
	 */
	@Query("select t from BiblioTemp t where t.marcContent=?1 and t.batchId=?2")
	public BiblioTemp findByMarcContentAndBatcId(Clob marcContent,Long batchId);
	
	/**
	 * ��ѯ
	 * @param issn isbn
	 * @param id  ѧУid
	 * @param isMagazine  ��Ŀ����
	 * @return
	 */
	@Query("select t from BiblioTemp t where t.isbn =?1 and t.schoolId =?2 and t.bookType =?3")
	public BiblioTemp findBySchoolAndTypeAndIsbn(String issn, Long id,
			int isMagazine);
	
	/**
	 * ��������������Ŀ����
	 * @param isbn
	 * @param schoolId
	 * @param bookType
	 * @return
	 */
	@Query("select t from BiblioTemp t where t.isbn =?1 and t.batchId =?2 and t.bookType =?3")
	public List<BiblioTemp> findRepeatSellerReceive(String isbn,Long batchId,Integer bookType);
	
	@Query("select t from BiblioTemp t where t.title  like ?3 and t.schoolId =?1 and t.bookType =?2")
	public List<BiblioTemp> getListBySchoolAndTypeAndTitleLike(Long schoolId,int bookType,String title);
	
	@Query("select t from BiblioTemp t where t.author like ?3 and t.schoolId =?1 and t.bookType =?2")
	public List<BiblioTemp> getListBySchoolAndTypeAndAuthorLike(Long schoolId,int bookType,String author);

	@Query("select t from BiblioTemp t where t.isbn =?3 and t.schoolId =?1 and t.bookType =?2")
	public List<BiblioTemp> getListBySchoolAndTypeAndISBN(Long schoolId,int booktype,String isbn);
}
