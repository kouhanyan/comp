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
 * Description: 云端维护serviceImpl
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
	 * 保存或修改云端维护
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
	 * 删除云端维护
	 * 
	 * @param id
	 */
	@Transactional
	public void deleteCloudManager(Long id) {
		cloudManagerDao.delete(id);
	}

	/**
	 * 处理或取消云端维护状态
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
	 * 云端维护列表查询
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
	 * 查找一项云端维护信息
	 * @param id
	 * @return
	 */
	public CloudManager findOne(Long id){	
		return cloudManagerDao.findOne(id);
	}
}
