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
 * Description: 临时库dao
 * </p>
 * Copyright: Copyright (c) 2012 Company: wenda
 * 
 * @Author sfy
 * @Version 1.0 2014-07-21
 */
@Repository

public interface BiblioTempDao extends JpaRepository<BiblioTemp, Long> {

	/**
	 * 通过学校查找临时库书目数据
	 * 
	 * @param schoolId
	 * @param pageable
	 * @return
	 */
	@Query("select t from BiblioTemp t where t.schoolId=?1 and t.bookType=?2")
	public Page<BiblioTemp> findBySchool(Long schoolId, Integer bookType,
			Pageable pageable);

	/**
	 * 通过书目Id集合和学校Id查找
	 * 
	 * @param ids
	 * @param schoolId
	 * @return
	 */
	@Query("select t from BiblioTemp t where t.schoolId=?1 and t.bookType=?2 and t.id in(select t1.biblioTemp.id from BookOrder t1 where t1.type=?3)")
	public Page<BiblioTemp> findByIdsAndSchool(Long schoolId, Integer bookType,
			Integer type, Pageable pageable);

	/**
	 * 通过书商征订批次查找对应书目
	 * 
	 * @param batchId
	 * @param pageable
	 * @return
	 */
	@Query("select t from BiblioTemp t where t.batchId=?1 and t.bookType=?2")
	public Page<BiblioTemp> findBySellerBatch(Long batchId, Integer bookType,
			Pageable pageable);

	/**
	 * 通过书商征订批次查找对应书目
	 * 
	 * @param batchId
	 * @param pageable
	 * @return
	 */
	@Query("select t from BiblioTemp t where t.batchId=?1 and t.bookType=?2")
	public List<BiblioTemp> findBySellerBatch(Long batchId, Integer bookType);

	/**
	 * 获取预订验收书目数据
	 * 
	 * @param bookOrderId
	 * @return
	 */
	@Query("select t from BiblioTemp t where t.id in(select t1.biblioTemp.id from BookOrder t1 where t1.batch.id=?1 and t1.type=?2)")
	public List<BiblioTemp> findByExitOrder(Long batchId, Integer type);

	/**
	 * 获取预订验收书目数据
	 * 
	 * @param bookOrderId
	 * @return
	 */
	@Query("select t from BiblioTemp t where t.id in(select t1.biblioTemp.id from BookOrder t1 where t1.batch.id=?1 and t1.type=?2)")
	public Page<BiblioTemp> findByExitOrder(Long batchId, Integer type,Pageable pageable);
	
	/**
	 * 获取记到列表
	 * （用集合不要用数组 不然会报Encountered array-valued parameter binding, but was expecting [java.lang.Integer]）
	 * 使用聚合函数中用group by来分组数据时特别说明了select 列表项中不存在的列可以出现在group by的列表项中，但反过来就不行了，在select列表项中出现的列必须全部出现在group by后面(聚合函数除外)
	 * @param schoolId
	 * @param bookType
	 * @param pageable
	 * @return
	 */
	@Query("select t from BiblioTemp t where t.bookType = 2 and t.id in (select s.biblioTemp.id from SeriesOrder s  where s.schoolId =?1 and s.orderType in (?2) group by s.biblioTemp.id)")
	public Page<BiblioTemp> findForAccept(Long schoolId, List<Integer> orderType,
			Pageable pageable);
	
	/**
	 * 根据marc数据和批次Id去重
	 * @param marcContent
	 * @param batchId
	 * @return
	 */
	@Query("select t from BiblioTemp t where t.marcContent=?1 and t.batchId=?2")
	public BiblioTemp findByMarcContentAndBatcId(Clob marcContent,Long batchId);
	
	/**
	 * 查询
	 * @param issn isbn
	 * @param id  学校id
	 * @param isMagazine  书目类型
	 * @return
	 */
	@Query("select t from BiblioTemp t where t.isbn =?1 and t.schoolId =?2 and t.bookType =?3")
	public BiblioTemp findBySchoolAndTypeAndIsbn(String issn, Long id,
			int isMagazine);
	
	/**
	 * 书商征订接收书目查重
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
