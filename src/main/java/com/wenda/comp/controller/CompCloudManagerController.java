package com.wenda.comp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wenda.comp.constant.Constant;
import com.wenda.comp.dao.SchoolDao;
import com.wenda.comp.dao.SysDicDao;
import com.wenda.comp.dao.SysRegionDao;
import com.wenda.comp.form.CloudManagerQueryForm;
import com.wenda.comp.model.CloudManager;
import com.wenda.comp.model.School;
import com.wenda.comp.model.SysRegion;
import com.wenda.comp.service.CloudManagerService;

/**
 * <p>
 * Description: ��̨�ƶ�ά��controller
 * </p>
 * Copyright: Copyright (c) 2012 Company: wenda
 * 
 * @Author sfy
 * @Version 1.0 2014-07-31
 */
@Controller
@RequestMapping("/comp/cloudManager")
public class CompCloudManagerController {

	private static final String PATH = "comp/";

	@Autowired
	private CloudManagerService cloudManagerService;

	@Autowired
	private SysRegionDao sysRegionDao;

	@Autowired
	private SchoolDao schoolDao;

	@Autowired
	private SysDicDao sysDicDao;
	
	private List<SysRegion> listProvince() {
		return sysRegionDao.findByLevel(1);
	}

	/**
	 * ��ȡ�ƶ�ά���б�
	 * 
	 * @param model
	 * @param cloudManagerQueryForm
	 * @return
	 */
	@RequestMapping("/list")
	public String list(Model model, CloudManagerQueryForm cloudManagerQueryForm) {
		Page<CloudManager> page = cloudManagerService.query(true, null,
				cloudManagerQueryForm.getDealStatus(),
				cloudManagerQueryForm.getStartDate(),
				cloudManagerQueryForm.getEndDate(), cloudManagerQueryForm);
		model.addAttribute(Constant.PAGE_KEY, page);
		model.addAttribute("provinces", listProvince());
		model.addAttribute("dealStatuses", sysDicDao.findByType(Constant.CLOUD_MANAGER_STATUS_DIC));
		return PATH + "cloudmanager/dealCloudManager";
	}

	/**
	 * �ƶ�ά����ѯ
	 * 
	 * @param model
	 * @param cloudManagerQueryForm
	 * @return
	 */
	@RequestMapping("/query")
	public String query(Model model, CloudManagerQueryForm cloudManagerQueryForm) {
		Page<CloudManager> page = cloudManagerService.query(true,
				cloudManagerQueryForm.getSchoolId(),
				cloudManagerQueryForm.getDealStatus(),
				cloudManagerQueryForm.getStartDate(),
				cloudManagerQueryForm.getEndDate(), cloudManagerQueryForm);
		model.addAttribute(Constant.PAGE_KEY, page);
		model.addAttribute("provinces", listProvince());
		model.addAttribute("dealStatuses", sysDicDao.findByType(Constant.CLOUD_MANAGER_STATUS_DIC));
		return PATH + "cloudmanager/dealCloudManager";
	}

	/**
	 * �����ƶ�ά��
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping("/deal")
	@ResponseBody
	public String deal(@RequestParam("id") Long id) {
		cloudManagerService
				.dealOrCancelCloudMannager(id, Constant.FINES_EXECED);
		return "success";
	}

	/**
	 * ȡ�������ƶ�ά��
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping("/cancel")
	@ResponseBody
	public String cancel(@RequestParam("id") Long id) {
		cloudManagerService.dealOrCancelCloudMannager(id,
				Constant.FINES_UNEXECED);
		return "success";
	}

	/**
	 * ������������
	 * 
	 * @param regionId
	 * @return
	 */
	@RequestMapping("/findRegions")
	@ResponseBody
	public List<SysRegion> findRegions(@RequestParam("regionId") Long regionId) {
		List<SysRegion> list = sysRegionDao.findChildren(regionId);
		return list;
	}

	/**
	 * ͨ�������ѧУ
	 * 
	 * @param regionId
	 * @return
	 */
	@RequestMapping("/findSchools")
	@ResponseBody
	public List<School> findSchools(@RequestParam("regionId") Long regionId) {
		return schoolDao.findByRegionId(regionId);
	}
}
