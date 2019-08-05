package com.wenda.comp.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wenda.comp.constant.Constant;
import com.wenda.comp.dao.CloudManagerDao;
import com.wenda.comp.dao.jdbc.CloudManagerDaoJdbc;
import com.wenda.comp.model.CloudManager;
import com.wenda.comp.model.School;
import com.wenda.comp.service.CloudManagerService;

/**
 * <p>
 * Description: �ƶ�ά��serviceImpl
 * </p>
 * Copyright: Copyright (c) 2012 Company: wenda
 * 
 * @Author sfy
 * @Version 1.0 2014-07-21
 */
@Service
public class CloudManagerServiceImpl implements CloudManagerService {

	@Autowired
	private CloudManagerDao cloudManagerDao;

	@Autowired
	private CloudManagerDaoJdbc cloudManagerDaoJdbc;

	/**
	 * ������޸��ƶ�ά��
	 * 
	 * @param cloudManager
	 * @param sysUserId
	 * @param schoolId
	 */
	@Transactional
	public void addOrEditCloudManager(CloudManager cloudManager,
			Long sysUserId, School school) {
		cloudManager.setCreateDate(new Date());
		cloudManager.setSysUserId(sysUserId);
		cloudManager.setSchool(school);
		cloudManager.setDealStatus(Constant.FINES_UNEXECED);
		cloudManagerDao.save(cloudManager);
	}

	/**
	 * ɾ���ƶ�ά��
	 * 
	 * @param id
	 */
	@Transactional
	public void deleteCloudManager(Long id) {
		cloudManagerDao.delete(id);
	}

	/**
	 * �����ȡ���ƶ�ά��״̬
	 * @param id
	 * @param dealStatus
	 */
	@Transactional
	public void dealOrCancelCloudMannager(Long id,Integer dealStatus) {
		CloudManager cloudManager = cloudManagerDao.findOne(id);
		cloudManager.setDealStatus(dealStatus);
		cloudManagerDao.save(cloudManager);
	}

	/**
	 * �ƶ�ά���б��ѯ
	 * 
	 * @param schoolId
	 * @param dealStatus
	 * @param startDate
	 * @param endDate
	 * @param pageable
	 * @return
	 */
	public Page<CloudManager> query(boolean isComp,Long schoolId, Integer dealStatus,
			Date startDate, Date endDate, Pageable pageable) {
		return cloudManagerDaoJdbc.query(isComp,schoolId, dealStatus, startDate,
				endDate, pageable);
	}
	
	/**
	 * ����һ���ƶ�ά����Ϣ
	 * @param id
	 * @return
	 */
	public CloudManager findOne(Long id){	
		return cloudManagerDao.findOne(id);
	}
}
