package com.wenda.comp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.wenda.comp.constant.Constant;
import com.wenda.comp.dao.ResourceOperateDao;
import com.wenda.comp.dao.SchoolDao;
import com.wenda.comp.dao.SysResourceDao;
import com.wenda.comp.dao.SysRoleDao;
import com.wenda.comp.dao.SysRoleResourceDao;
import com.wenda.comp.dao.jdbc.SysRoleDaoJdbc;
import com.wenda.comp.form.SysRoleQueryForm;
import com.wenda.comp.model.ResourceOperate;
import com.wenda.comp.model.School;
import com.wenda.comp.model.SysOperate;
import com.wenda.comp.model.SysResource;
import com.wenda.comp.model.SysRole;
import com.wenda.comp.model.SysRoleResource;
import com.wenda.comp.service.SysOperateService;
import com.wenda.comp.service.SysRoleResourceService;

/**
 * <p>
 * Description: 系统角色controller
 * </p>
 * Copyright: Copyright (c) 2012 Company: wenda
 * 
 * @Author sfy
 * @Version 1.0 2014-07-21
 */
@Controller
@RequestMapping("/comp/sysRole")
public class SysRoleController {

	@Autowired
	private SysRoleDao sysRoleDao;

	@Autowired
	private SysRoleDaoJdbc sysRoleDaoJdbc;
	
	@Autowired
	private SysResourceDao sysResourceDao;
	
	@Autowired
	private SchoolDao schoolDao;
	
	@Autowired
	private SysRoleResourceService sysRoleResourceService;

	@Autowired
	private ResourceOperateDao resourceOperateDao;
	
	@Autowired
	private SysOperateService sysOperateService;
	
	@Autowired
	private SysRoleResourceDao sysRoleResourceDao;
	
	private static final String PATH = "comp/";

	/**
	 * 获取系统角色列表
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping("/list")
	public String list(Model model, SysRoleQueryForm sysRoleQueryForm) {
		Page<SysRole> page = sysRoleDao.findAll(sysRoleQueryForm);
		model.addAttribute(Constant.PAGE_KEY, page);
		return PATH + "sysrole/listSysRole";
	}

	/**
	 * 查询系统角色
	 * 
	 * @param model
	 * @param sysRoleQueryForm
	 * @return
	 */
	@RequestMapping("/query")
	public String query(Model model, SysRoleQueryForm sysRoleQueryForm) {
		Page<SysRole> page = sysRoleDaoJdbc.query(sysRoleQueryForm.getName(),
				sysRoleQueryForm.getSchoolName(), sysRoleQueryForm);
		model.addAttribute(Constant.PAGE_KEY, page);
		model.addAttribute("sysRoleQueryForm", sysRoleQueryForm);
		return PATH + "sysrole/listSysRole";
	}

	/**
	 * 添加系统角色跳转页
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping("/addForward")
	public String addForward(Model model) {
		// Token.clearToken(model);
		List<SysResource> sysResources=sysResourceDao.findAll();
		model.addAttribute("sysResources", sysResources);
		List<School> schools=schoolDao.findAll();
		model.addAttribute("schools", schools);
		return PATH + "sysrole/addSysRole";
	}

	/**
	 * 添加系统角色
	 * 
	 * @param sysRole
	 * @param bindingResult
	 * @param model
	 * @param redirectAttrs
	 * @return
	 */
	@RequestMapping("/add")
	@Transactional
	public String add(SysRole sysRole, BindingResult bindingResult,
			Model model, RedirectAttributes redirectAttrs,
			SysRoleQueryForm sysRoleQueryForm) {
		if (bindingResult.hasErrors()) {
			model.addAttribute("sysRole", sysRole);
			model.addAttribute(Constant.MESSAGE_ERROR, Constant.ERROR_ADD);
			return PATH + "sysrole/addSysRole";
		}
		SysRole exist=sysRoleDao.findByRoleName(sysRole.getName());
		if(exist!=null){	
			model.addAttribute(Constant.MESSAGE_WARN,Constant.WARN_SYSROLE_EXIST);
			return addForward(model);
		}
		// if (Token.isTokenEmpty(model)) {
		// sysRoleDao.save(sysRole);
		// }
		// Token.saveToken(model);
		sysRole = sysRoleDao.save(sysRole);
		sysRoleResourceService.endueAuthority(sysRole,
				sysRoleQueryForm.getChecks());
		redirectAttrs.addFlashAttribute(Constant.MESSAGE_SUCCESS,
				Constant.SUCCESS_ADD);
		return "redirect:/comp/sysRole/list";
	}

	/**
	 * 删除系统角色
	 * 
	 * @param id
	 * @param redirectAttrs
	 * @return
	 */
	@RequestMapping("/delete/{id}")
	@Transactional
	public String delete(@PathVariable Long id, RedirectAttributes redirectAttrs) {
		try {
			sysRoleDao.delete(id);
			redirectAttrs.addFlashAttribute(Constant.MESSAGE_SUCCESS,
					Constant.SUCCESS_DELETE);
		} catch (Exception e) {
			redirectAttrs.addFlashAttribute(Constant.MESSAGE_ERROR,
					Constant.ERROR_DELETE);
			return "redirect:/comp/sysRole/list";
		}
		return "redirect:/comp/sysRole/list";
	}

	@RequestMapping("/findOne/{id}")
	public String findOne(@PathVariable("id") Long id,Model model){	
		SysRole sysRole=sysRoleDao.findOne(id);
		model.addAttribute("sysRole", sysRole);
		List<SysResource> sysResources=sysResourceDao.findAll();
		model.addAttribute("sysResources", sysResources);
		model.addAttribute("schools", schoolDao.findAll());
		List<SysRoleResource> sysRoleResources=sysRoleResourceDao.findByRoleId(id);
		model.addAttribute("sysRoleResources", sysRoleResources);
		return PATH+"sysrole/editSysRole";
	}
	
	/**
	 * 修改系统角色
	 * 
	 * @param sysRole
	 * @param bindingResult
	 * @param model
	 * @param redirectAttrs
	 * @return
	 */
	@RequestMapping("/edit")
	@Transactional
	public String edit(SysRole sysRole, BindingResult bindingResult,
			Model model, RedirectAttributes redirectAttrs,
			SysRoleQueryForm sysRoleQueryForm) {
		if (bindingResult.hasErrors()) {
			model.addAttribute("sysRole", sysRole);
			model.addAttribute(Constant.MESSAGE_ERROR, Constant.ERROR_EDIT);
			return PATH + "sysrole/editSysRole";
		}
//		SysRole exist=sysRoleDao.findByRoleName(sysRole.getName());
//		if(exist!=null && exist.getId().longValue()!=sysRole.getId().longValue()){	
//			model.addAttribute(Constant.MESSAGE_WARN,Constant.WARN_SYSROLE_EXIST);
//			return findOne(sysRole.getId(), model);
//		}
		sysRoleDao.save(sysRole);
		sysRoleResourceService.endueAuthority(sysRole,
				sysRoleQueryForm.getChecks());
		redirectAttrs.addFlashAttribute(Constant.MESSAGE_SUCCESS,
				Constant.SUCCESS_EDIT);
		return "redirect:/comp/sysRole/list";
	}
	
	/**
	 * 获取高级操作权限
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping("/findRoleOperrate/{id}")
	public String findRoleOperate(@PathVariable("id") Long id,Model model){
		SysRole sysRole=sysRoleDao.findOne(id);
		List<SysRoleResource> sysRoleResources=sysRoleResourceService.getDeskRoleResource(id, Constant.MENU_THREE, Constant.getResourceOperateList());
		List<SysOperate> sysOperates=sysOperateService.findAuthorityOperate(id,Constant.MENU_THREE,Constant.getResourceOperateList());
		model.addAttribute("sysOperates", sysOperates);
		model.addAttribute("sysRoleResources", sysRoleResources);
		model.addAttribute("sysRole", sysRole);
		return PATH+"sysrole/cancelOperate";
	}
	
	/**
	 * 取消选中的操作权限
	 * @param sysRoleQueryForm
	 * @return
	 */
	@RequestMapping("/cancelRoleOperate")
	@Transactional
	public String cancelRoleOperate(SysRoleQueryForm sysRoleQueryForm){
		List<ResourceOperate> list=resourceOperateDao.getRoleOperates(sysRoleQueryForm.getId());
		resourceOperateDao.delete(list);
		List<ResourceOperate> list1=sysRoleQueryForm.getList();
		for(ResourceOperate ro:list1){	
			ro.setRoleId(sysRoleQueryForm.getId());
		}
		resourceOperateDao.save(list1);
		return "redirect:/comp/sysRole/list";
	}
}
