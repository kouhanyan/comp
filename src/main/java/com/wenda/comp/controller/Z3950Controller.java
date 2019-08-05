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
import com.wenda.comp.dao.Z3950Dao;
import com.wenda.comp.dao.jdbc.Z3950DaoJdbc;
import com.wenda.comp.form.Z3950QueryForm;
import com.wenda.comp.model.Z3950;

/**
 * <p>
 * Description: z3950controller
 * </p>
 * Copyright: Copyright (c) 2012 Company: wenda
 * 
 * @Author sfy
 * @Version 1.0 2014-07-21
 */
@Controller
@RequestMapping("/comp/z3950")
public class Z3950Controller extends BaseController{

	@Autowired
	private Z3950Dao z3950Dao;

	@Autowired
	private Z3950DaoJdbc z3950DaoJdbc;

	
	private static final String PATH = "comp/";

	/**
	 * 获取z3950列表
	 * 
	 * @param z3950QueryForm
	 * @param model
	 * @return
	 */
	
	@RequestMapping("/list")
	public String list(Z3950QueryForm z3950QueryForm, Model model) {
		Page<Z3950> page = z3950Dao.findNoSchool(z3950QueryForm);
		model.addAttribute(Constant.PAGE_KEY, page);
		return PATH + "z3950/listZ3950";
	}

	/**
	 * 查询z3950
	 * 
	 * @param z3950QueryForm
	 * @param model
	 * @return
	 */
	@RequestMapping("/query")
	public String query(Z3950QueryForm z3950QueryForm, Model model) {
		Page<Z3950> page = z3950DaoJdbc.query(Constant.IS_COMPANY,z3950QueryForm.getName(),
				z3950QueryForm.getServer(), z3950QueryForm.getDatabase(),getCurrentSchool().getId(),
				z3950QueryForm);
        model.addAttribute(Constant.PAGE_KEY, page);
        model.addAttribute("z3950QueryForm", z3950QueryForm);
        return PATH+"z3950/listZ3950";
	}

	/**
	 * z3950添加跳转页
	 * 
	 * @return
	 */
	@RequestMapping("/addForward")
	public String addForward() {
		return PATH + "z3950/addZ3950";
	}

	/**
	 * 添加z3950
	 * 
	 * @param z3950
	 * @param bindingResult
	 * @param model
	 * @param redirectAttrs
	 * @return
	 */
	@RequestMapping("/add")
	@Transactional
	public String add(Z3950 z3950, BindingResult bindingResult, Model model,
			RedirectAttributes redirectAttrs) {
		if (bindingResult.hasErrors()) {
			model.addAttribute("z3950", z3950);
			model.addAttribute(Constant.MESSAGE_ERROR, Constant.ERROR_ADD);
			return PATH + "z3950/addZ3950";
		}
		z3950.setSysUser(getCurrentUser());
		z3950Dao.save(z3950);
		redirectAttrs.addFlashAttribute(Constant.MESSAGE_SUCCESS,
				Constant.SUCCESS_ADD);
		return "redirect:/comp/z3950/list";
	}

	/**
	 * 删除z3950
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
			z3950Dao.delete(id);
			redirectAttrs.addFlashAttribute(Constant.MESSAGE_SUCCESS,
					Constant.SUCCESS_DELETE);
		} catch (Exception e) {
			redirectAttrs.addFlashAttribute(Constant.MESSAGE_ERROR,
					Constant.ERROR_DELETE);
			return "redirect:/comp/z3950/list";
		}
		return "redirect:/comp/z3950/list";
	}

	/**
	 * 通过id查找z3950
	 * 
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping("/findOne/{id}")
	public String findOne(@PathVariable("id") Long id, Model model) {
		Z3950 z3950 = z3950Dao.findOne(id);
		model.addAttribute("z3950", z3950);
		return PATH + "z3950/editZ3950";
	}

	/**
	 * 修改z3950
	 * 
	 * @param z3950
	 * @param bindingResult
	 * @param model
	 * @param redirectAttrs
	 * @return
	 */
	@RequestMapping("/edit")
	@Transactional
	public String edit(Z3950 z3950, BindingResult bindingResult, Model model,
			RedirectAttributes redirectAttrs) {
		if (bindingResult.hasErrors()) {
			model.addAttribute("z3950", z3950);
			model.addAttribute(Constant.MESSAGE_ERROR, Constant.ERROR_EDIT);
			return PATH + "z3950/editZ3950";
		}
		z3950.setSysUser(getCurrentUser());
		z3950Dao.save(z3950);
		redirectAttrs.addFlashAttribute(Constant.MESSAGE_SUCCESS,
				Constant.SUCCESS_EDIT);
		return "redirect:/comp/z3950/list";
	}
}
