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
 * Description: ��ʱ��daojdbc
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
	 * ����������Ŀ����
	 * @param isbn
	 * @param batchId
	 * @param bookType
	 * @return
	 */
	public Long findRepeatSellerReceive(String isbn,Long batchId,Integer bookType);
	
	/**
	 * ��ѯ��ʱ����Ŀ����
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
	 * ��ѯ��Ҫͨ��������
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
	 * ��ȡ������Ҫͨ��������
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
	 * Ԥ����¼ά����ѯ
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
	 * ����Ԥ����¼ά����ѯ
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
	 * ��ѯ�����������ζ�Ӧ��Ŀ
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
	 * Ԥ������������Ŀ��ѯ
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
	 * ��Ŀ����Ԥ��
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
	 * ��Ŀ��������
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
	 * ��ѯ�����������ζ�Ӧ��Ŀ(�ڿ�)
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
	 * ��ѯ�ǵ��б�
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
	 * �����������Ŀ¼����
	 * 
	 * @param batchId
	 * @param bookType
	 */
	@Transactional
	public void deleteSellerBatch(Long batchId, Long schoolId, Integer bookType);

	/**
	 * �ڿ�����Ԥ��
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
