package com.wenda.comp.controller;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.wenda.comp.constant.Constant;
import com.wenda.comp.dao.SysRegionDao;
import com.wenda.comp.dao.jdbc.SysRegionDaoJdbc;
import com.wenda.comp.form.SysRegionQueryForm;
import com.wenda.comp.model.SysRegion;

/**
 * <p>
 * Description: 行政区划controller
 * </p>
 * Copyright: Copyright (c) 2012 Company: wenda
 * 
 * @Author sfy
 * @Version 1.0 2014-07-21
 */
@Controller
@RequestMapping("/comp/sysRegion")
public class SysRegionController {

	@Autowired
	private SysRegionDao sysRegionDao;

	@Autowired
	private SysRegionDaoJdbc sysRegionDaoJdbc;

	private static final String PATH = "comp/";

	/**
	 * 获取行政区划列表
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping("/list")
	public String list(Model model, SysRegionQueryForm sysRegionQueryForm) {
		Page<SysRegion> page = sysRegionDao.findAll(sysRegionQueryForm);
		model.addAttribute(Constant.PAGE_KEY, page);
		List<SysRegion> parents = sysRegionDao.findParents();
		model.addAttribute("parents", parents);
		return PATH + "sysregion/listSysRegion";
	}

	/**
	 * 行政区划查询
	 * 
	 * @param model
	 * @param sysRegionQueryForm
	 * @return
	 */
	@RequestMapping("/query")
	public String query(Model model, SysRegionQueryForm sysRegionQueryForm) {
		Page<SysRegion> page = sysRegionDaoJdbc.query(
				sysRegionQueryForm.getCode(), sysRegionQueryForm.getName(),
				sysRegionQueryForm.getParentName(), sysRegionQueryForm);
		model.addAttribute("parents", sysRegionDao.findParents());
		if (StringUtils.isNotBlank(sysRegionQueryForm.getParentName())) {
			List<SysRegion> parents = sysRegionDao.findByParentName("%"
					+ sysRegionQueryForm.getParentName() + "%");
			model.addAttribute("parents", parents);
		}
		model.addAttribute(Constant.PAGE_KEY, page);
		model.addAttribute("sysRegionQueryForm", sysRegionQueryForm);
		return PATH + "sysregion/listSysRegion";
	}

	@RequestMapping("/findByLevel")
	@ResponseBody
	public List<SysRegion> findByLevel(
			@RequestParam("regionLevel") Integer regionLevel) {
		List<SysRegion> sysRegions = sysRegionDao.findByLevel(regionLevel - 1);
		return sysRegions;
	}

	/**
	 * 行政区划添加跳转
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping("/addForward")
	public String addForward(Model model) {
		// Token.clearToken(model);
		return PATH + "sysregion/addSysRegion";
	}

	/**
	 * 添加行政区划
	 * 
	 * @param sysRegion
	 * @param bindingResult
	 * @param model
	 * @param redirectAttrs
	 * @return
	 */
	@RequestMapping("/add")
	@Transactional
	public String add(SysRegion sysRegion,
			BindingResult bindingResult, Model model,
			RedirectAttributes redirectAttrs) {
		SysRegion newSysRegion = sysRegionDao.findByCode(sysRegion.getCode());
		if (newSysRegion != null) {
			model.addAttribute("sysRegion", sysRegion);
			model.addAttribute(Constant.MESSAGE_WARN,
					Constant.WARN_SYSREGION_EXIST);
			return PATH + "sysregion/addSysRegion";
		}
		// if (!Token.isTokenEmpty(model)) {
		// model.addAttribute(Constant.MESSAGE_ERROR, Constant.REPEAT_SUBMIT);
		// return PATH + "sysregion/addSysRegion";
		// }
		sysRegionDao.save(sysRegion);
		// Token.saveToken(model);
		redirectAttrs.addFlashAttribute(Constant.MESSAGE_SUCCESS,
				Constant.SUCCESS_ADD);
		return "redirect:/comp/sysRegion/list";
	}

	/**
	 * 删除行政区划
	 * 
	 * @param id
	 * @param redirectAttrs
	 * @return
	 */
	@RequestMapping("/delete/{id}")
	@Transactional
	public String delete(@PathVariable Long id, RedirectAttributes redirectAttrs) {
		List<SysRegion> sysRegions = sysRegionDao.findChildren(id);
		if (sysRegions != null && sysRegions.size() > 0) {
			redirectAttrs.addFlashAttribute(Constant.MESSAGE_ERROR,
					Constant.ERROR_DELETE);
			return "redirect:/comp/sysRegion/list";
		}
		try {
			sysRegionDao.delete(id);
			redirectAttrs.addFlashAttribute(Constant.MESSAGE_SUCCESS,
					Constant.SUCCESS_DELETE);
		} catch (Exception e) {
			redirectAttrs.addFlashAttribute(Constant.MESSAGE_ERROR,
					Constant.ERROR_DELETE);
			return "redirect:/comp/sysRegion/list";
		}
		return "redirect:/comp/sysRegion/list";
	}

	/**
	 * 根据id查找行政区划
	 * 
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping("/findOne/{id}")
	public String findOne(@PathVariable("id") Long id, Model model) {
		SysRegion sysRegion = sysRegionDao.findOne(id);
		model.addAttribute("sysRegion", sysRegion);
		List<SysRegion> sysRegions = sysRegionDao.findByLevel(sysRegion
				.getRegionLevel() - 1);
		model.addAttribute("sysRegions", sysRegions);
		return PATH + "sysregion/editSysRegion";
	}

	/**
	 * 修改行政区划
	 * 
	 * @param sysRegion
	 * @param bindingResult
	 * @param model
	 * @param redirectAttrs
	 * @return
	 */
	@RequestMapping("/edit")
	@Transactional
	public String edit(SysRegion sysRegion,
			BindingResult bindingResult, Model model,
			RedirectAttributes redirectAttrs) {
		SysRegion newSysRegion = sysRegionDao.findByCode(sysRegion.getCode());
		if (newSysRegion != null
				&& newSysRegion.getId().longValue() != sysRegion.getId()
						.longValue()) {
			model.addAttribute("sysRegion", sysRegion);
			model.addAttribute(Constant.MESSAGE_WARN,
					Constant.WARN_SYSREGION_EXIST);
			return PATH + "sysregion/editSysRegion";
		}
		sysRegionDao.save(sysRegion);
		redirectAttrs.addFlashAttribute(Constant.MESSAGE_SUCCESS,
				Constant.SUCCESS_EDIT);
		return "redirect:/comp/sysRegion/list";
	}

}
