package com.wenda.comp.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.wenda.comp.constant.Constant;
import com.wenda.comp.dao.SysAnnouncementDao;
import com.wenda.comp.dao.SysUserDao;
import com.wenda.comp.form.SysAnnouncementQueryForm;
import com.wenda.comp.model.SysAnnouncement;
import com.wenda.comp.model.SysUser;
import com.wenda.comp.page.Pager;
import com.wenda.comp.service.SysAnnouncementService;

/**
 * <p>
 * Description: 系统公告controller
 * </p>
 * Copyright: Copyright (c) 2012 Company: wenda
 * 
 * @Author sfy
 * @Version 1.0 2014-07-21
 */
@Controller
@RequestMapping("/comp/sysAnnouncement")
public class SysAnnouncementController extends BaseController{

	@Autowired
	private SysAnnouncementDao sysAnnouncementDao;

	@Autowired
	private SysUserDao sysUserDao;
	
	@Autowired
	private SysAnnouncementService sysAnnouncementService;
	
	private static final String PATH = "comp/";

	/**
	 * 获取系统公告列表
	 * 
	 * @param model
	 * @param pager
	 * @return
	 */
	@RequestMapping("/list")
	public String list(Model model, Pager pager) {
		Page<SysAnnouncement> page = sysAnnouncementDao.findAll(pager);
		model.addAttribute(Constant.PAGE_KEY, page);
		return PATH + "sysannouncement/listSysAnnouncement";
	}
	
	/**
	 * 分页查询
	 * 
	 * @param model
	 * @param sysVersionQueryForm
	 * @return
	 */
	@RequestMapping("/query")
	public String query(Model model, SysAnnouncementQueryForm sysAnnouncementQueryForm) {
		Page<SysAnnouncement> page = sysAnnouncementService.find(
				sysAnnouncementQueryForm.getTitle(),
				sysAnnouncementQueryForm.getSender(), sysAnnouncementQueryForm);
		model.addAttribute(Constant.PAGE_KEY, page);
		model.addAttribute("sysAnnouncementQueryForm", sysAnnouncementQueryForm);
		return PATH + "sysannouncement/listSysAnnouncement";
	}

	/**
	 * 系统公告 添加跳转页
	 * 
	 * @return
	 */
	@RequestMapping("/addForward")
	public String addForward() {
		return PATH + "sysannouncement/addSysAnnouncement";
	}

	/**
	 * 添加系统公告
	 * 
	 * @param sysAnnouncement
	 * @param redirectAttrs
	 * @return
	 */
	@RequestMapping("/add")
	@Transactional
	public String add(SysAnnouncement sysAnnouncement,
			RedirectAttributes redirectAttrs) {
		SysUser sysUser=sysUserDao.findByUserName(getCurrentUserName());
		sysAnnouncement.setSender(sysUser.getUserName());
		sysAnnouncement.setSysUserId(sysUser.getId());
		sysAnnouncement.setSendDate(new Date());
		sysAnnouncementDao.save(sysAnnouncement);
		redirectAttrs.addFlashAttribute(Constant.MESSAGE_SUCCESS,
				Constant.SUCCESS_ADD);
		return "redirect:/comp/sysAnnouncement/list";
	}

	/**
	 * 删除系统公告
	 * @param id
	 * @param redirectAttrs
	 * @return
	 */
	@RequestMapping("/delete/{id}")
	@Transactional
	public String delete(@PathVariable("id") Long id,
			RedirectAttributes redirectAttrs) {
		try {
			sysAnnouncementDao.delete(id);
			redirectAttrs.addFlashAttribute(Constant.MESSAGE_SUCCESS,
					Constant.SUCCESS_DELETE);
		} catch (Exception e) {
			redirectAttrs.addFlashAttribute(Constant.MESSAGE_ERROR,
					Constant.ERROR_DELETE);
			return "redirect:/comp/sysAnnouncement/list";
		}
		return "redirect:/comp/sysAnnouncement/list";
	}
	
	/**
	 * 通过id查找系统公告
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping("/findOne/{id}")
	public String findOne(@PathVariable("id") Long id,Model model){	
		SysAnnouncement sysAnnouncement=sysAnnouncementDao.findOne(id);
		model.addAttribute("sysAnnouncement", sysAnnouncement);
		return PATH + "sysannouncement/editSysAnnouncement";
	}
	
	/**
	 * 修改系统公告
	 * @param sysAnnouncement
	 * @param redirectAttrs
	 * @return
	 */
	@RequestMapping("/edit")
	@Transactional
	public String edit(SysAnnouncement sysAnnouncement,RedirectAttributes redirectAttrs){	
		sysAnnouncementDao.save(sysAnnouncement);
		redirectAttrs.addFlashAttribute(Constant.MESSAGE_SUCCESS,Constant.SUCCESS_EDIT);
		return "redirect:/comp/sysAnnouncement/list";
	}
	/**
	 * 设置为在头部显示
	 * @param workingId
	 * @param sysAnnouncementQueryForm
	 * @param model
	 * @return
	 */
	@RequestMapping("/setDisplay")
	public String setDisplay(Long workingId,SysAnnouncementQueryForm sysAnnouncementQueryForm,Model model){
		sysAnnouncementService.setWorkState(workingId);
		return query(model, sysAnnouncementQueryForm);
	}
}
