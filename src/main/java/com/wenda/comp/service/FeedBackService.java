package com.wenda.comp.service;

import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.wenda.comp.exception.BusinessException;
import com.wenda.comp.model.FeedBack;
import com.wenda.comp.model.School;

/**
 * <p>
 * Description: ����service
 * </p>
 * Copyright: Copyright (c) 2012 Company: wenda
 * 
 * @Author sfy
 * @Version 1.0 2014-07-21
 */
public interface FeedBackService {
	/**
	 * ͨ���û�����ȡѧУ
	 * @param userName
	 * @return
	 */
	public School findSchool(String userName);
	
	/**
	 * ���淴����Ϣ
	 * @param userName
	 * @param feedBack
	 * @param file
	 * @throws BusinessException
	 */
	public void saveFeedBack(String userName, FeedBack feedBack,
			MultipartFile file) throws BusinessException;
	
	/**
	 * ��������Ϣ
	 * @param id
	 */
	@Transactional
	public void dealOrCancelFeedBack(Long id);
	
	/**
	 * ���ط�����ͼ�ļ�
	 * @param id
	 * @return
	 * @throws BusinessException
	 */
	public  ResponseEntity<byte[]> downLoadFile(Long id) throws BusinessException;
}
