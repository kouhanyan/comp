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
import com.wenda.comp.dao.SysDicDao;
import com.wenda.comp.dao.jdbc.SysDicDaoJdbc;
import com.wenda.comp.form.SysDicQueryForm;
import com.wenda.comp.model.SysDic;

/**
 * <p>
 * Description: 数据字典controller
 * </p>
 * Copyright: Copyright (c) 2012 Company: wenda
 * 
 * @Author sfy
 * @Version 1.0 2014-07-18
 */
@Controller
@RequestMapping("/comp/sysDic")
public class SysDicController {

	@Autowired
	private SysDicDao sysDicDao;

	@Autowired
	private SysDicDaoJdbc sysDicDaoJdbc;

	private static final String PATH = "comp/";

	/**
	 * 获取数据字典列表
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping("/list")
	public String list(Model model,SysDicQueryForm sysDicQueryForm) {
		Page<SysDic> page = sysDicDao.findAll(sysDicQueryForm);
		model.addAttribute(Constant.PAGE_KEY, page);
		return PATH+"sysdic/listSysDic";
	}

	/**
	 * 查询数据字典记录
	 * 
	 * @param model
	 * @param sysDicQueryForm
	 * @return
	 */
	@RequestMapping("/query")
	public String query(Model model, SysDicQueryForm sysDicQueryForm) {
		Page<SysDic> page = sysDicDaoJdbc.query(sysDicQueryForm.getDicType(),
				sysDicQueryForm.getDicKey(), sysDicQueryForm.getDicValue(),
				sysDicQueryForm);
		model.addAttribute(Constant.PAGE_KEY, page);
		model.addAttribute("sysDicQueryForm", sysDicQueryForm);
		return PATH + "sysdic/listSysDic";
	}

	/**
	 * 添加跳转页
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping("/addForward")
	public String addForward(Model model) {
//		Token.clearToken(model);
		return PATH + "sysdic/addSysDic";
	}

	/**
	 * 添加数据字典记录
	 * 
	 * @param sysDic
	 * @param bindingResult
	 * @param model
	 * @param redirectAttrs
	 * @return
	 */
	@RequestMapping("/add")
	@Transactional
	public String add(SysDic sysDic, BindingResult bindingResult, Model model,
			RedirectAttributes redirectAttrs) {
		if (bindingResult.hasErrors()) {
			model.addAttribute(Constant.MESSAGE_ERROR, Constant.ERROR_ADD);
			model.addAttribute("sysDic", sysDic);
			return PATH + "sysdic/addSysDic";
		}
		SysDic newSysDic = sysDicDao.findByTypeAndKey(sysDic.getDicType(),
				sysDic.getDicKey());
		if (newSysDic != null) {
			model.addAttribute("sysDic", sysDic);
			model.addAttribute(Constant.MESSAGE_WARN, Constant.WARN_SYSDIC_EXIST);
			return PATH + "sysdic/addSysDic";
		}
//		if (!Token.isTokenEmpty(model)) {
//			model.addAttribute(Constant.MESSAGE_ERROR, Constant.REPEAT_SUBMIT);
//			return PATH+"sysdic/addSysDic";
//		}
		sysDicDao.save(sysDic);
//		Token.saveToken(model);
		redirectAttrs.addFlashAttribute(Constant.MESSAGE_SUCCESS,
				Constant.SUCCESS_ADD);
		return "redirect:/comp/sysDic/list";
	}

	/**
	 * 删除数据字典记录
	 * 
	 * @param id
	 * @param redirectAttrs
	 * @return
	 */
	@RequestMapping("/delete/{id}")
	@Transactional
	public String delete(@PathVariable("id") Long id, RedirectAttributes redirectAttrs) {
		sysDicDao.delete(id);
		redirectAttrs.addFlashAttribute(Constant.MESSAGE_SUCCESS,
				Constant.SUCCESS_DELETE);
		return "redirect:/comp/sysDic/list";
	}

	/**
	 * 通过id查找数据字典
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping("/findOne/{id}")
	public String findOne(@PathVariable("id") Long id,Model model){	
		SysDic sysDic=sysDicDao.findOne(id);
		model.addAttribute("sysDic", sysDic);
		return PATH+"sysdic/editSysDic";
	}
	
	/**
	 * 修改数据字典记录
	 * 
	 * @param sysDic
	 * @param bindingResult
	 * @param model
	 * @param redirectAttrs
	 * @return
	 */
	@RequestMapping("/edit")
	@Transactional
	public String edit(SysDic sysDic, BindingResult bindingResult, Model model,
			RedirectAttributes redirectAttrs) {
		SysDic newSysDic = sysDicDao.findByTypeAndKey(sysDic.getDicType(),
				sysDic.getDicKey());
		if (newSysDic != null && newSysDic.getId().longValue() != sysDic.getId().longValue()) {
			model.addAttribute("sysDic", sysDic);
			model.addAttribute(Constant.MESSAGE_WARN, Constant.WARN_SYSDIC_EXIST);
			return PATH + "sysdic/editSysDic";
		}
		sysDicDao.save(sysDic);
		redirectAttrs.addFlashAttribute(Constant.MESSAGE_SUCCESS,
				Constant.SUCCESS_EDIT);
		return "redirect:/comp/sysDic/list";
	}

}
