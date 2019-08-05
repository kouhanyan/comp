package com.wenda.comp.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.wenda.comp.model.Collection;

/**
 * <p>
 * Description: 条码库dao
 * </p>
 * Copyright: Copyright (c) 2012 Company: wenda
 * 
 * @Author sfy
 * @Version 1.0 2014-07-21
 */

@Repository

public interface CollectionDao extends JpaRepository<Collection, Long> {

	/**
	 * 通过临时库id和学校id查找馆藏信息
	 * 
	 * @param biblioTempId
	 * @param schoolId
	 * @return
	 */
	@Query("select t from Collection t where t.biblioTemp.id=?1 and t.school.id=?2 and t.state=?3")
	public List<Collection> findByBiblioTempIdAndSchoolId(Long biblioTempId,
			Long schoolId,Integer state);

	/**
	 * 通过条码号和学校id查找馆藏信息
	 * 
	 * @param barcode
	 * @param schoolId
	 * @return
	 */
	@Query("select t from Collection t where t.barcode=?1 and t.school.id=?2")
	public Collection findByBarcode(String barcode, Long schoolId);

	/**
	 * 通过验收id和学校id查找馆藏信息
	 * 
	 * @param acceptId
	 * @param schoolId
	 * @return
	 */
	@Query("select t from Collection t where t.biblioAcceptanceBook.id=?1 and t.school.id=?2 and t.state=?3")
	public List<Collection> findAcceptIdAndSchoolId(Long acceptId, Long schoolId,Integer state);

	/**
	 * 同学临时表id分页查找
	 * 
	 * @param biblioTempId
	 * @param schoolId
	 * @param collectionQueryForm
	 * @return
	 */
	@Query("select t from Collection t where t.biblioTemp.id=?1 and t.state=?2")
	public Page<Collection> findByBiblioTempId(Long biblioTempId,Integer state,
			Pageable pageable);
	
	/**
	 * 查找误删的馆藏列表
	 * @param state
	 * @param schoolId
	 * @return
	 */
	@Query("select t from Collection t where t.state=?1 and t.school.id=?2")
	public Page<Collection> findDeleted(Integer state,Long schoolId,Pageable pageable);
	
	/**
	 * 查找需要登记的馆藏记录
	 * @param ids
	 * @return
	 */
	@Query("select t from Collection t where t.id in (?1)")
	public List<Collection> findNeedRegistCollection(List<Long> ids);
	
	/**
	 * 是否删除中间库的标志
	 * @param biblioTempId
	 * @param isHadRegist
	 * @param state
	 * @return
	 */
	@Query("select t from Collection t where t.biblioTemp.id in (?1) and t.isHadRegist=?2 and t.state=?3")
	public List<Collection> findRegistIsOver(Long biblioTempId,Integer isHadRegist,Integer state);
}
