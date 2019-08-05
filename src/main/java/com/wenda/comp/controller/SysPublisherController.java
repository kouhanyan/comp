package com.wenda.comp.controller;

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
import com.wenda.comp.dao.SysPublisherDao;
import com.wenda.comp.dao.jdbc.SysPublisherDaoJdbc;
import com.wenda.comp.form.SysPublisherQueryForm;
import com.wenda.comp.model.SysPublisher;
import com.wenda.comp.service.SysPublisherService;

@Controller
@RequestMapping("/comp/sysPublisher")
public class SysPublisherController extends BaseController {

	@Autowired
	private SysPublisherDao sysPublisherDao;

	@Autowired
	private SysPublisherDaoJdbc sysPublisherDaoJdbc;
	
	@Autowired
	private SysPublisherService sysPublisherService;

	private static final String PATH = "comp/";

	/**
	 * 获取出版社列表
	 * 
	 * @param model
	 * @param sysPublisherQueryForm
	 * @return
	 */
	@RequestMapping("/list")
	public String list(Model model, SysPublisherQueryForm sysPublisherQueryForm) {
		Page<SysPublisher> page = sysPublisherService.findPublicSysPublisher(sysPublisherQueryForm);
		model.addAttribute(Constant.PAGE_KEY, page);
		return PATH + "syspublisher/listSysPublisher";
	}

	/**
	 * 查询出版社
	 * 
	 * @param model
	 * @param sysPublisherQueryForm
	 * @return
	 */
	@RequestMapping("/query")
	public String query(Model model, SysPublisherQueryForm sysPublisherQueryForm) {
		Page<SysPublisher> page = sysPublisherDaoJdbc.queryPublicPulisher(sysPublisherQueryForm.getCode(),
				sysPublisherQueryForm.getName(), sysPublisherQueryForm);
		model.addAttribute(Constant.PAGE_KEY, page);
		model.addAttribute("sysPublisherQueryForm", sysPublisherQueryForm);
		return PATH + "syspublisher/listSysPublisher";
	}

	/**
	 * 出版社添加跳转页
	 * 
	 * @return
	 */
	@RequestMapping("/addForward")
	public String addForward() {
		return PATH + "syspublisher/addSysPublisher";
	}

	/**
	 * 添加出版社
	 * 
	 * @param sysPublisher
	 * @param bindingResult
	 * @param model
	 * @param redirectAttrs
	 * @return
	 */
	@RequestMapping("/add")
	@Transactional
	public String add(SysPublisher sysPublisher, BindingResult bindingResult,
			Model model, RedirectAttributes redirectAttrs) {
		if (bindingResult.hasErrors()) {
			model.addAttribute("sysPublisher", sysPublisher);
			model.addAttribute(Constant.MESSAGE_ERROR, Constant.ERROR_ADD);
			return PATH + "syspublisher/addSysPublisher";
		}
		SysPublisher newSysPublisher = sysPublisherDao.findByCode(sysPublisher
				.getCode());
		if (newSysPublisher != null) {
			model.addAttribute("sysPublisher", sysPublisher);
			model.addAttribute(Constant.MESSAGE_WARN,
					Constant.WARN_SYSPUBLISHER_EXIST);
			return PATH + "syspublisher/addSysPublisher";
		}
		//sysPublisher.setSchool(getCurrentSchool());后台添加的出版社这边设置为null
		sysPublisherDao.save(sysPublisher);
		redirectAttrs.addFlashAttribute(Constant.MESSAGE_SUCCESS,
				Constant.SUCCESS_ADD);
		return "redirect:/comp/sysPublisher/list";
	}

	/**
	 * 删除出版社
	 * 
	 * @param id
	 * @param redirectAttrs
	 * @return
	 */
	@RequestMapping("/delete/{id}")
	@Transactional
	public String delete(@PathVariable("id") Long id,
			RedirectAttributes redirectAttrs) {
		try {
			sysPublisherDao.delete(id);
			redirectAttrs.addFlashAttribute(Constant.MESSAGE_SUCCESS,
					Constant.SUCCESS_DELETE);
		} catch (Exception e) {
			redirectAttrs.addFlashAttribute(Constant.MESSAGE_ERROR,
					Constant.ERROR_DELETE);
			return "redirect:/comp/sysPublisher/list";
		}
		return "redirect:/comp/sysPublisher/list";
	}

	/**
	 * 通过Id查找出版社
	 * 
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping("/findOne/{id}")
	public String findOne(@PathVariable("id") Long id, Model model) {
		SysPublisher sysPublisher = sysPublisherDao.findOne(id);
		model.addAttribute("sysPublisher", sysPublisher);
		return PATH + "syspublisher/editSysPublisher";
	}

	/**
	 * 修改出版社
	 * 
	 * @param sysPublisher
	 * @param bindingResult
	 * @param model
	 * @param redirectAttrs
	 * @return
	 */
	@RequestMapping("/edit")
	@Transactional
	public String edit(SysPublisher sysPublisher, BindingResult bindingResult,
			Model model, RedirectAttributes redirectAttrs) {
		if (bindingResult.hasErrors()) {
			model.addAttribute("sysPublisher", sysPublisher);
			model.addAttribute(Constant.MESSAGE_ERROR, Constant.ERROR_EDIT);
			return PATH + "syspublisher/editSysPublisher";
		}
		SysPublisher newSysPublisher = sysPublisherDao.findByCode(sysPublisher
				.getCode());
		if (newSysPublisher != null
				&& newSysPublisher.getId().longValue() != sysPublisher.getId()
						.longValue()) {
			model.addAttribute("sysPublisher", sysPublisher);
			model.addAttribute(Constant.MESSAGE_WARN,
					Constant.WARN_SYSPUBLISHER_EXIST);
			return PATH + "syspublisher/editSysPublisher";
		}
		//sysPublisher.setSchool(getCurrentSchool());后台添加的出版社学校为null
		sysPublisherDao.save(sysPublisher);
		redirectAttrs.addFlashAttribute(Constant.MESSAGE_SUCCESS,
				Constant.SUCCESS_EDIT);
		return "redirect:/comp/sysPublisher/list";
	}
}
