package com.wenda.comp.controller;

import java.io.IOException;
import java.util.List;

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
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.wenda.comp.constant.Constant;
import com.wenda.comp.dao.SysResourceDao;
import com.wenda.comp.dao.jdbc.SysResourceDaoJdbc;
import com.wenda.comp.form.SysResourceQueryForm;
import com.wenda.comp.model.SysResource;

/**
 * <p>
 * Description: 系统资源controller
 * </p>
 * Copyright: Copyright (c) 2012 Company: wenda
 * 
 * @Author sfy
 * @Version 1.0 2014-07-21
 */
@Controller
@RequestMapping("/comp/sysResource")
public class SysResourceController {

	@Autowired
	private SysResourceDao sysResourceDao;

	@Autowired
	private SysResourceDaoJdbc sysResourceDaoJdbc;

	private static final String PATH = "comp/";

	/**
	 * 获取系统资源列表
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping("/list")
	public String list(Model model, SysResourceQueryForm sysResourceQueryForm) {
		Page<SysResource> page = sysResourceDao.findAll(sysResourceQueryForm);
		model.addAttribute(Constant.PAGE_KEY, page);
		List<SysResource> parents = sysResourceDao.findParents();
		model.addAttribute("parents", parents);
		return PATH + "sysresource/listSysResource";
	}

	/**
	 * 查询系统资源
	 * 
	 * @param model
	 * @param sysResourceQueryForm
	 * @return
	 */
	@RequestMapping("/query")
	public String query(Model model, SysResourceQueryForm sysResourceQueryForm) {
		Page<SysResource> page = sysResourceDaoJdbc.query(
				sysResourceQueryForm.getName(), sysResourceQueryForm.getUrl(),
				sysResourceQueryForm.getParentName(),
				sysResourceQueryForm.getResourceLevel(), sysResourceQueryForm);
		model.addAttribute("parents", sysResourceDao.findParents());
		model.addAttribute(Constant.PAGE_KEY, page);
		model.addAttribute("sysResourceQueryForm", sysResourceQueryForm);
		return PATH + "sysresource/listSysResource";
	}

	/**
	 * 系统资源添加跳转页
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping("/addForward")
	public String addForward(Model model) {
		// Token.clearToken(model);
		return PATH + "sysresource/addSysResource";
	}

	/**
	 * 添加系统资源
	 * 
	 * @param sysResource
	 * @param bindingResult
	 * @param model
	 * @param redirectAttrs
	 * @return
	 */
	@RequestMapping("/add")
	@Transactional
	public String add(@RequestParam("file") MultipartFile file,SysResource sysResource, BindingResult bindingResult,
			Model model, RedirectAttributes redirectAttrs) {
		if (bindingResult.hasErrors()) {
			model.addAttribute("sysResource", sysResource);
			model.addAttribute(Constant.MESSAGE_ERROR, Constant.ERROR_ADD);
			return PATH + "sysresource/addSysResource";
		}
		// if (Token.isTokenEmpty(model)) {
		// sysResourceDao.save(sysResource);
		// }
		// Token.saveToken(model);
		try {
			sysResource.setIco(file.getBytes());
			sysResourceDao.save(sysResource);
			redirectAttrs.addFlashAttribute(Constant.MESSAGE_SUCCESS,
					Constant.SUCCESS_ADD);
		} catch (IOException e) {
			e.printStackTrace();
			model.addAttribute(Constant.MESSAGE_ERROR, e.getMessage());
			return PATH + "sysresource/addSysResource";
		}
		return "redirect:/comp/sysResource/list";
	}

	/**
	 * 删除系统资源
	 * 
	 * @param id
	 * @param redirectAttrs
	 * @return
	 */
	@RequestMapping("/delete/{id}")
	@Transactional
	public String delete(@PathVariable("id") Long id,
			RedirectAttributes redirectAttrs) {
		List<SysResource> children = sysResourceDao.findChildren(id);
		if (children != null && children.size() > 0) {
			redirectAttrs.addFlashAttribute(Constant.MESSAGE_ERROR,
					Constant.ERROR_DELETE);
			return "redirect:/comp/sysResource/list";
		}
		try {
			sysResourceDao.delete(id);
			redirectAttrs.addFlashAttribute(Constant.MESSAGE_SUCCESS,
					Constant.SUCCESS_DELETE);
		} catch (Exception e) {
			redirectAttrs.addFlashAttribute(Constant.MESSAGE_ERROR,
					Constant.ERROR_DELETE);
			return "redirect:/comp/sysResource/list";
		}
		return "redirect:/comp/sysResource/list";
	}

	/**
	 * 通过id查找资源
	 * 
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping("/findOne/{id}")
	public String findOne(@PathVariable("id") Long id, Model model) {
		SysResource sysResource = sysResourceDao.findOne(id);
		model.addAttribute("sysResource", sysResource);
		List<SysResource> sysResources=sysResourceDao.findByLevel(sysResource.getResourceLevel()-1);
		model.addAttribute("sysResources", sysResources);
		return PATH + "sysresource/editSysResource";
	}

	/**
	 * 修改系统资源
	 * 
	 * @param sysResource
	 * @param bindingResult
	 * @param model
	 * @param redirectAttrs
	 * @return
	 */
	@RequestMapping("/edit")
	@Transactional
	public String edit(@RequestParam("file") MultipartFile file,SysResource sysResource, BindingResult bindingResult,
			Model model, RedirectAttributes redirectAttrs) {
		if (bindingResult.hasErrors()) {
			model.addAttribute("sysResource", sysResource);
			model.addAttribute(Constant.MESSAGE_ERROR, Constant.ERROR_EDIT);
			return PATH + "sysresource/editSysResource";
		}
		try {
			for(byte b : file.getBytes()){
				System.out.print(b+",");
			}
			System.out.println("222222");
			if(file != null && file.getBytes().length > 0){
				sysResource.setIco(file.getBytes());
			}
		} catch (IOException e) {
			e.printStackTrace();
			model.addAttribute(Constant.MESSAGE_ERROR, e.getMessage());
			return PATH + "sysresource/editSysResource";
		}
		sysResourceDao.save(sysResource);
		redirectAttrs.addFlashAttribute(Constant.MESSAGE_SUCCESS,
				Constant.SUCCESS_EDIT);
		return "redirect:/comp/sysResource/list";
	}

	/**
	 * 通过资源查找父资源
	 * 
	 * @param level
	 * @return
	 */
	@RequestMapping("/findByLevel")
	@ResponseBody
	public List<SysResource> findByLevel(
			@RequestParam("resourceLevel") Integer level) {
		List<SysResource> sysResources = sysResourceDao.findByLevel(level - 1);
		return sysResources;
	}
	
}
