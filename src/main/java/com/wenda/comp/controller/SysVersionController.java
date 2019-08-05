package com.wenda.comp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.wenda.comp.constant.Constant;
import com.wenda.comp.form.SysVersionQueryForm;
import com.wenda.comp.model.SysVersion;
import com.wenda.comp.service.SysVersionService;

/**
 * <p>
 * Description: 版本controller
 * </p>
 * Copyright: Copyright (c) 2012 Company: wenda
 * 
 * @Author jzp
 * @Version 1.0 2014-07-21
 */
@Controller
@RequestMapping("/comp/sysVersion")
public class SysVersionController {
	@Autowired
	private SysVersionService sysVersionService;

	private static final String PATH = "comp/";

	/**
	 * 获取版本信息的列表
	 * 
	 * @param model
	 * @param biblioTempQueryForm
	 * @return
	 */
	@RequestMapping("/list")
	public String list(Model model, SysVersionQueryForm sysVersionQueryForm) {
		Page<SysVersion> page = sysVersionService.find(
				sysVersionQueryForm.getEdition(),
				sysVersionQueryForm.getDirectory(), sysVersionQueryForm);
		model.addAttribute(Constant.PAGE_KEY, page);
		return PATH + "sysVersion/list";
	}

	/**
	 * 分页查询
	 * 
	 * @param model
	 * @param sysVersionQueryForm
	 * @return
	 */
	@RequestMapping("/query")
	public String query(Model model, SysVersionQueryForm sysVersionQueryForm) {
		Page<SysVersion> page = sysVersionService.find(
				sysVersionQueryForm.getEdition(),
				sysVersionQueryForm.getDirectory(), sysVersionQueryForm);
		model.addAttribute(Constant.PAGE_KEY, page);
		model.addAttribute("sysVersionQueryForm", sysVersionQueryForm);
		return PATH + "sysVersion/list";
	}

	/**
	 * 添加页面
	 * 
	 * @return
	 */
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String add() {
		return PATH + "sysVersion/add";
	}

	/**
	 * 添加
	 * 
	 * @param sysVersion
	 * @return
	 */
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String add(RedirectAttributes redirectAttrs, SysVersion sysVersion) {
		sysVersionService.saveOrEdit(sysVersion);
		redirectAttrs.addFlashAttribute(Constant.MESSAGE_SUCCESS,
				Constant.SUCCESS_ADD);
		return "redirect:/comp/sysVersion/list";

	}

	/**
	 * 编辑页面
	 * 
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping("/findOne/{id}")
	public String findOne(@PathVariable("id") Long id, Model model) {
		SysVersion sysVersion = sysVersionService.findOne(id);
		model.addAttribute("sysVersion", sysVersion);
		return PATH + "sysVersion/edit";
	}

	/**
	 * 编辑
	 * 
	 * @return
	 */
	@RequestMapping("/edit")
	public String edit(RedirectAttributes redirectAttrs, SysVersion sysVersion) {
		SysVersion entitySysVersion = sysVersionService.findOne(sysVersion.getId());
		entitySysVersion.setEdition(sysVersion.getEdition());
		entitySysVersion.setDirectory(sysVersion.getDirectory());
		entitySysVersion.setCharacteristic(sysVersion.getCharacteristic());
		entitySysVersion.setReleaseNotes(sysVersion.getReleaseNotes());
		sysVersionService.saveOrEdit(entitySysVersion);
		redirectAttrs.addFlashAttribute(Constant.MESSAGE_SUCCESS,
				Constant.SUCCESS_EDIT);
		return "redirect:/comp/sysVersion/list";
	}

	/**
	 * 删除
	 * 
	 * @param id
	 * @param model
	 * @param redirectAttrs
	 * @return
	 */
	@RequestMapping("/delete/{id}")
	@Transactional
	public String delete(@PathVariable Long id, RedirectAttributes redirectAttrs) {
		// 判断当前版次不给删除
		if (sysVersionService.findOne(id).getIsCurrentVersion()) {
			redirectAttrs.addFlashAttribute(Constant.MESSAGE_ERROR,
					Constant.WARN_CURRENT_VERSION);
			return "redirect:/comp/sysVersion/list";
		}
		try {
			sysVersionService.delete(id);
		} catch (Exception e) {
			e.printStackTrace();
			redirectAttrs.addFlashAttribute(Constant.MESSAGE_ERROR,
					Constant.ERROR_DELETE);
			return "redirect:/comp/sysVersion/list";
		}
		redirectAttrs.addFlashAttribute(Constant.MESSAGE_SUCCESS,
				Constant.SUCCESS_DELETE);
		return "redirect:/comp/sysVersion/list";
	}
	/**
	 * 查看
	 * @param id
	 * @return
	 */
	@RequestMapping("/showOne/{id}")
	public String showOne(@PathVariable Long id,Model model){
		model.addAttribute("sysVersion", sysVersionService.findOne(id));
		return  PATH + "sysVersion/showOne";
		
	}
	/**
	 * 设置为当前工作批次  
	 * @param id
	 * @return
	 */
	@RequestMapping("/setWorkState")
	public String setWorkState(Long workingId,SysVersionQueryForm sysVersionQueryForm,Model model){
		sysVersionService.setWorkState(workingId);
		return query(model, sysVersionQueryForm);
	}

}
