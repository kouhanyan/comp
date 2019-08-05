package com.wenda.comp.service.impl;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.wenda.comp.common.util.Config;
import com.wenda.comp.constant.Constant;
import com.wenda.comp.dao.FeedBackDao;
import com.wenda.comp.dao.SysUserDao;
import com.wenda.comp.exception.BusinessException;
import com.wenda.comp.model.FeedBack;
import com.wenda.comp.model.School;
import com.wenda.comp.model.SysUser;
import com.wenda.comp.service.FeedBackService;

/**
 * <p>
 * Description: 反馈serviceImpl
 * </p>
 * Copyright: Copyright (c) 2012 Company: wenda
 * 
 * @Author sfy
 * @Version 1.0 2014-07-21
 */
@Service

public class FeedBackServiceImpl implements FeedBackService {

	@Autowired
	private SysUserDao sysUserDao;

	@Autowired
	private FeedBackDao feedBackDao;

	/**
	 * 通过用户名获取学校
	 * 
	 * @param userName
	 * @return
	 */
	public School findSchool(String userName) {
		SysUser sysUser = sysUserDao.findByUserName(userName);
		School school = sysUser.getSchool();
		return school;
	}

	/**
	 * 保存反馈信息
	 * 
	 * @param userName
	 * @param feedBack
	 * @param file
	 * @throws BusinessException
	 */
	@Transactional
	public void saveFeedBack(String userName, FeedBack feedBack,
			MultipartFile file) throws BusinessException {
		SysUser sysUser = sysUserDao.findByUserName(userName);
		School school = sysUser.getSchool();
		if (file != null && !file.isEmpty()) {
			String filePath = Config.parseFilePath("windows.feedBack.file",
					"linux.feedBack.file", file);
			feedBack.setImagePath(filePath);
		}
		feedBack.setIsDeal(Constant.NOT_DEAL);
		feedBack.setSysUserId(sysUser.getId());
		feedBack.setSysUserName(userName);
		feedBack.setSchoolId(school.getId());
		feedBack.setSchoolName(school.getSchoolName());
		feedBack.setCreateDate(new Date());
		feedBackDao.save(feedBack);
	}

	/**
	 * 处理反馈信息
	 * 
	 * @param id
	 */
	@Transactional
	public void dealOrCancelFeedBack(Long id) {
		FeedBack feedBack = feedBackDao.findOne(id);
		if (feedBack.getIsDeal() == Constant.NOT_DEAL)
			feedBack.setIsDeal(Constant.IS_DEAL);
		else
			feedBack.setIsDeal(Constant.NOT_DEAL);
		feedBackDao.save(feedBack);
	}

	/**
	 * 下载反馈截图文件
	 * 
	 * @param id
	 * @return
	 * @throws BusinessException
	 */
	public ResponseEntity<byte[]> downLoadFile(Long id)
			throws BusinessException {
		HttpHeaders headers = null;
		InputStream in = null;
		FeedBack feedBack = feedBackDao.findOne(id);
		try {
			in = new FileInputStream(feedBack.getImagePath());
			headers = new HttpHeaders();
			if(feedBack.getImagePath().indexOf(".jpg")!=-1){
			headers.setContentType(MediaType.IMAGE_JPEG);
			}
			else if(feedBack.getImagePath().indexOf(".gif")!=-1){	
				headers.setContentType(MediaType.IMAGE_GIF);
			}
			else{	
				headers.setContentType(MediaType.IMAGE_PNG);
			}
		} catch (FileNotFoundException e) {
			throw new BusinessException("找不到指定文件");
		}
		try {
			return new ResponseEntity<byte[]>(IOUtils.toByteArray(in), headers,
					HttpStatus.CREATED);
		} catch (IOException e) {
			throw new BusinessException("文件下载出错");
		}
	}
}
