package com.wenda.comp.service;

import java.util.Date;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.wenda.comp.model.CloudManager;
import com.wenda.comp.model.School;

public interface CloudManagerService {

	/**
	 * 保存或修改云端维护
	 * @param cloudManager
	 * @param sysUserId
	 * @param schoolId
	 */
	public void addOrEditCloudManager(CloudManager cloudManager,Long sysUserId,School school);
	
	/**
	 * 删除云端维护
	 * @param id
	 */
	public void deleteCloudManager(Long id);
	
	/**
	 * 处理或取消云端维护状态
	 * @param id
	 * @param dealStatus
	 */
	public void dealOrCancelCloudMannager(Long id,Integer dealStatus);
	
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
			Date startDate, Date endDate, Pageable pageable);
	
	/**
	 * 查找一项云端维护信息
	 * @param id
	 * @return
	 */
	public CloudManager findOne(Long id);
}
