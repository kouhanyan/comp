package com.wenda.comp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.wenda.comp.constant.Constant;
import com.wenda.comp.dao.SchoolDao;
import com.wenda.comp.dao.SysDicDao;
import com.wenda.comp.dao.SysRegionDao;
import com.wenda.comp.dao.jdbc.SchoolDaoJdbc;
import com.wenda.comp.form.SchoolQueryForm;
import com.wenda.comp.model.School;
import com.wenda.comp.model.SysDic;
import com.wenda.comp.model.SysRegion;

/**
 * <p>
 * Description: 学校controller
 * </p>
 * Copyright: Copyright (c) 2012 Company: wenda
 * 
 * @Author sfy
 * @Version 1.0 2014-07-21
 */
@Controller
@RequestMapping("/comp/school")
public class SchoolController extends BaseController {

	@Autowired
	private SchoolDao schoolDao;

	@Autowired
	private SysRegionDao sysRegionDao;

	@Autowired
	private SysDicDao sysDicDao;

	@Autowired
	private SchoolDaoJdbc schoolDaoJdbc;
	private static final String PATH = "comp/";

	/**
	 * 锟斤拷取学校锟叫憋拷
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping("/list")
	public String list(Model model, SchoolQueryForm schoolQueryForm) {
		Page<School> page = schoolDao.findAll(schoolQueryForm);
		model.addAttribute(Constant.PAGE_KEY, page);
		model.addAttribute("sysDics", findSysDicsByType());
		return PATH + "school/listSchool";
	}

	/**
	 * 锟斤拷询学校
	 * 
	 * @param model
	 * @param schoolQueryForm
	 * @return
	 */
	@RequestMapping("/query")
	public String query(Model model, SchoolQueryForm schoolQueryForm) {
		Page<School> page = schoolDaoJdbc.query(schoolQueryForm.getSchoolCode(), schoolQueryForm.getSimpleName(), schoolQueryForm.getSchoolName(), schoolQueryForm.getType(), schoolQueryForm);
		model.addAttribute(Constant.PAGE_KEY, page);
		model.addAttribute("schoolQueryForm", schoolQueryForm);
		model.addAttribute("sysDics", findSysDicsByType());
		return PATH + "school/listSchool";
	}

	/**
	 * 锟斤拷锟窖ｏ拷锟阶�
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping("/addForward")
	public String addForward(Model model) {
		// Token.clearToken(model);
		model.addAttribute("isStops", findSchoolUserStopDics());
		model.addAttribute("sysDics", findSysDicsByType());
		
		return PATH + "school/addSchool";
	}

	@RequestMapping("/getRegion")
	@ResponseBody
	public List<SysRegion> getRegion(String schoolCode) {
		String regionCode = schoolCode.substring(0, 6);
		List<SysRegion> likeByCode = sysRegionDao.getLikeByCode("%" + regionCode + "%");
		return likeByCode;

	}

	private List<SysRegion> findAllSysRegions() {
		List<SysRegion> sysRegions = sysRegionDao.findAll();
		return sysRegions;
	}

	private List<SysDic> findSysDicsByType() {
		List<SysDic> sysDics = sysDicDao.findByType(Constant.SCHOOL_TYPE);
		return sysDics;
	}

	private List<SysDic> findSchoolUserStopDics() {
		List<SysDic> sysDics = sysDicDao.findByType(Constant.SCHOOL_USER_STOP_DIC_TYPE);
		return sysDics;
	}

	/**
	 * 锟斤拷锟窖�
	 * 
	 * @param school
	 * @param bindingResult
	 * @param model
	 * @param redirectAttrs
	 * @return
	 */
	@RequestMapping("/add")
	@Transactional
	public String add(@Validated School school, BindingResult bindingResult, Model model, RedirectAttributes redirectAttrs) {
		if (bindingResult.hasErrors()) {
			model.addAttribute("school", school);
			model.addAttribute(Constant.MESSAGE_ERROR, Constant.ERROR_ADD);
			model.addAttribute("sysRegions", findAllSysRegions());
			model.addAttribute("sysDics", findSysDicsByType());
			return PATH + "school/addSchool";
		}
		School newSchool = schoolDao.findByCode(school.getSchoolCode());
		if (newSchool != null) {
			model.addAttribute(Constant.MESSAGE_WARN, Constant.WARN_SCHOOL_EXIST);
			model.addAttribute("school", school);
			model.addAttribute("sysRegions", findAllSysRegions());
			model.addAttribute("sysDics", findSysDicsByType());
			return PATH + "school/addSchool";
		}
		// if (!Token.isTokenEmpty(model)) {
		// model.addAttribute(Constant.MESSAGE_ERROR, Constant.REPEAT_SUBMIT);
		// return PATH+"school/addSchool";
		// }
		String schoolCode = school.getSchoolCode();
		school.setProvinceCode(schoolCode.substring(0, 2));
		school.setCityCode(schoolCode.substring(0,4));
		school.setCountyCode(schoolCode.substring(0, 6));
		schoolDao.save(school);
		// Token.saveToken(model);
		redirectAttrs.addFlashAttribute(Constant.MESSAGE_SUCCESS, Constant.SUCCESS_ADD);
		return "redirect:/comp/school/list";
	}

	/**
	 * 删锟斤拷学校
	 * 
	 * @param id
	 * @param redirectAttrs
	 * @param model
	 * @return
	 */
	@RequestMapping("/delete/{id}")
	@Transactional
	public String delete(@PathVariable("id") Long id, RedirectAttributes redirectAttrs) {
		try {
			schoolDao.delete(id);
			redirectAttrs.addFlashAttribute(Constant.MESSAGE_SUCCESS, Constant.SUCCESS_DELETE);
		} catch (Exception e) {
			e.printStackTrace();
			redirectAttrs.addFlashAttribute(Constant.MESSAGE_ERROR, Constant.ERROR_DELETE);
			return "redirect:/comp/school/list";
		}
		return "redirect:/comp/school/list";
	}

	/**
	 * 锟斤拷锟斤拷id锟斤拷锟斤拷学校
	 * 
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping("/findOne/{id}")
	public String findOne(@PathVariable("id") Long id, Model model) {
		model.addAttribute("isStops", findSchoolUserStopDics());
		model.addAttribute("sysRegions", findAllSysRegions());
		model.addAttribute("sysDics", findSysDicsByType());
		School school = schoolDao.findOne(id);
		model.addAttribute("school", school);
		return PATH + "/school/editSchool";
	}

	/**
	 * 锟睫革拷学校
	 * 
	 * @param school
	 * @param bindingResult
	 * @param model
	 * @param redirectAttrs
	 * @return
	 */
	@RequestMapping("/edit")
	@Transactional
	public String edit(@Validated School school, BindingResult bindingResult, Model model, RedirectAttributes redirectAttrs) {
		if (bindingResult.hasErrors()) {
			model.addAttribute("school", school);
			model.addAttribute(Constant.MESSAGE_ERROR, Constant.ERROR_EDIT);
			model.addAttribute("sysRegions", findAllSysRegions());
			model.addAttribute("sysDics", findSysDicsByType());
			return PATH + "school/editSchool";
		}
		School newSchool = schoolDao.findByCode(school.getSchoolCode());
		if (newSchool != null && newSchool.getId().longValue() != school.getId().longValue()) {
			model.addAttribute("school", school);
			model.addAttribute(Constant.MESSAGE_WARN, Constant.WARN_SCHOOL_EXIST);
			model.addAttribute("sysRegions", findAllSysRegions());
			model.addAttribute("sysDics", findSysDicsByType());
			return PATH + "school/editSchool";
		}
		schoolDao.save(school);
		redirectAttrs.addFlashAttribute(Constant.MESSAGE_SUCCESS, Constant.SUCCESS_EDIT);
		return "redirect:/comp/school/list";
	}

	/**
	 * 锟届步锟斤拷锟斤拷学校
	 * 
	 * @return
	 */
	@RequestMapping("/getAllSchools")
	@ResponseBody
	public List<School> getAllSchools(@RequestParam("name") String name) {
		if (name == null)
			return schoolDao.findAll();
		else
			return schoolDao.findByName(name);

	}

}
