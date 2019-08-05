package com.wenda.comp.service;

import java.util.Date;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.wenda.comp.model.CloudManager;
import com.wenda.comp.model.School;

public interface CloudManagerService {

	/**
	 * ������޸��ƶ�ά��
	 * @param cloudManager
	 * @param sysUserId
	 * @param schoolId
	 */
	public void addOrEditCloudManager(CloudManager cloudManager,Long sysUserId,School school);
	
	/**
	 * ɾ���ƶ�ά��
	 * @param id
	 */
	public void deleteCloudManager(Long id);
	
	/**
	 * �����ȡ���ƶ�ά��״̬
	 * @param id
	 * @param dealStatus
	 */
	public void dealOrCancelCloudMannager(Long id,Integer dealStatus);
	
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
			Date startDate, Date endDate, Pageable pageable);
	
	/**
	 * ����һ���ƶ�ά����Ϣ
	 * @param id
	 * @return
	 */
	public CloudManager findOne(Long id);
}
