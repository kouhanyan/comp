package com.wenda.comp.dao.jdbc;

import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

import com.wenda.comp.model.BiblioTemp;


/**
 * <p>
 * Description: 临时库daojdbc
 * </p>
 * Copyright: Copyright (c) 2012 Company: wenda
 * 
 * @Author sfy
 * @Version 1.0 2014-07-18
 */
public interface BiblioTempDaoJdbc {

	@Autowired
	public abstract void setDataSource(DataSource oracleSource);

	/**
	 * 书商征订书目查重
	 * @param isbn
	 * @param batchId
	 * @param bookType
	 * @return
	 */
	public Long findRepeatSellerReceive(String isbn,Long batchId,Integer bookType);
	
	/**
	 * 查询临时库书目数据
	 * 
	 * @param isbn
	 * @param title
	 * @param author
	 * @param classNo
	 * @param publisher
	 * @param schoolId
	 * @param pageable
	 * @return
	 */
	public Page<BiblioTemp> query(String isbn, String barcode, String title,
			String author, String classNo, String publisher, String subjet,
			String unionNo, Integer bookType, Long schoolId, Integer state,
			Pageable pageable);

	/**
	 * 查询需要通报的新书
	 * 
	 * @param batchId
	 * @param startDate
	 * @param endDate
	 * @param schoolId
	 * @param pageable
	 * @return
	 */
	public Page<BiblioTemp> queryNeedBookInform(Long batchId, Date startDate,
			Date endDate, Long schoolId, Integer bookType, Pageable pageable);

	/**
	 * 获取所有需要通报的新书
	 * 
	 * @param batchId
	 * @param startDate
	 * @param endDate
	 * @param schoolId
	 * @param bookType
	 * @return
	 */
	public List<BiblioTemp> queryNeedBookInform(Long batchId, Date startDate,
			Date endDate, Long schoolId, Integer bookType);

	/**
	 * 预订记录维护查询
	 * 
	 * @param isbn
	 * @param barcode
	 * @param title
	 * @param author
	 * @param schoolId
	 * @param type
	 * @param pageable
	 * @return
	 */
	public Page<BiblioTemp> queryOrderBiblioTemp(String isbn, String title,
			String author, String classNo, String publisher, Long schoolId,
			Integer bookType, Pageable pageable);

	/**
	 * 批次预订记录维护查询
	 * 
	 * @param batchId
	 * @param isbn
	 * @param title
	 * @param author
	 * @param subject
	 * @param classNo
	 * @param publisher
	 * @param unionNo
	 * @param type
	 * @param bookType
	 * @param pageable
	 * @return
	 */
	public Page<BiblioTemp> queryOrderBiblioTemp(Long batchId, String isbn,
			String title, String author, String classNo, String publisher,
			Integer bookType, Pageable pageable);

	/**
	 * 查询书商征订批次对应书目
	 * 
	 * @param batchId
	 * @param isbn
	 * @param title
	 * @param author
	 * @param subject
	 * @param classNo
	 * @param publisher
	 * @param unionNo
	 * @param pageable
	 * @return
	 */
	public Page<BiblioTemp> querySellerBiblioTemp(Long batchId,
			String isbn, String title, String author, String subject,
			String classNo, String publisher, String unionNo, Integer bookType,
			Pageable pageable);


	/**
	 * 预订验收批次书目查询
	 * @param batchId
	 * @param isbn
	 * @param title
	 * @param author
	 * @param subject
	 * @param classNo
	 * @param publisher
	 * @param unionNo
	 * @param bookType
	 * @param pageable
	 * @return
	 */
	public Page<BiblioTemp> queryOrderAcceptBiblioTemp(Long batchId,
			String isbn, String title, String author, String subject,
			String classNo, String publisher, String unionNo, Integer bookType,
			Pageable pageable);
	
	/**
	 * 书目查重预订
	 * 
	 * @param isbn
	 * @param title
	 * @param author
	 * @param subject
	 * @param classNo
	 * @param publisher
	 * @param unionNo
	 * @param callNo
	 * @param barcode
	 * @param schoolId
	 * @param bookType
	 * @param pageable
	 * @return
	 */
	public Page<BiblioTemp> queryRepeatBiblio(String isbn, String title,
			String author,String classNo, String publisher,
			Long schoolId, Integer bookType, Pageable pageable);

	/**
	 * 书目查重验收
	 * 
	 * @param isbn
	 * @param title
	 * @param author
	 * @param subject
	 * @param classNo
	 * @param publisher
	 * @param unionNo
	 * @param callNo
	 * @param barcode
	 * @param schoolId
	 * @param bookType
	 * @param pageable
	 * @return
	 */
	public Page<BiblioTemp> queryRepeatAccept(String isbn, String title,
			String author, String classNo, String publisher,
			Long schoolId, Integer bookType,Pageable pageable);
	
	/**
	 * 查询书商征订批次对应书目(期刊)
	 * 
	 * @param isbn
	 * @param barcode
	 * @param title
	 * @param author
	 * @param classNo
	 * @param publisher
	 * @param subjet
	 * @param unionNo
	 * @param bookType
	 * @param batchId
	 * @param pageable
	 * @return
	 */

	public abstract Page<BiblioTemp> querySeriesSellerOrAcceptBiblioTemp(
			String isbn, String barcode, String title, String author,
			String classNo, String publisher, String subjet, String unionNo,
			Integer bookType, Long schoolId, Long batchId, Pageable pageable);

	/**
	 * 查询记到列表
	 * 
	 * @param schoolId
	 * @param orderType
	 * @param isbn
	 * @param title
	 * @param author
	 * @param subject
	 * @param classNo
	 * @param publisher
	 * @param orderNo
	 * @param unionNo
	 * @param pageable
	 * @return
	 */
	public abstract Page<BiblioTemp> queryForAccept(Long schoolId,
			List<Integer> orderType, String isbn, String title, String author,
			String subject, String classNo, String publisher, String orderNo,
			String unionNo, Pageable pageable);

	/**
	 * 清空书商征订目录内容
	 * 
	 * @param batchId
	 * @param bookType
	 */
	@Transactional
	public void deleteSellerBatch(Long batchId, Long schoolId, Integer bookType);

	/**
	 * 期刊查重预定
	 * 
	 * @param isbn
	 * @param barcode
	 * @param title
	 * @param author
	 * @param classNo
	 * @param publisher
	 * @param subject
	 * @param unionNo
	 * @param bookType
	 * @param schoolId
	 * @param batchId
	 * @param biblioTempQueryForm
	 * @return
	 */
	public Page<BiblioTemp> queryBiblioTempAndBatchId(String isbn,
			String barcode, String title, String author, String classNo,
			String publisher, String subject, String unionNo, Integer bookType,
			Long schoolId, Long batchId, Pageable pageable);
}
