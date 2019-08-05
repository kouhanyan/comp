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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.wenda.comp.constant.Constant;
import com.wenda.comp.dao.SchoolDao;
import com.wenda.comp.dao.SysRoleDao;
import com.wenda.comp.dao.SysUserDao;
import com.wenda.comp.dao.jdbc.SysUserDaoJdbc;
import com.wenda.comp.form.SysUserQueryForm;
import com.wenda.comp.model.School;
import com.wenda.comp.model.SysRole;
import com.wenda.comp.model.SysUser;
import com.wenda.comp.security.PasswordEncoder;

/**
 * <p>
 * Description: 系统用户controller
 * </p>
 * Copyright: Copyright (c) 2012 Company: wenda
 * 
 * @Author sfy
 * @Version 1.0 2014-07-21
 */
@Controller
@RequestMapping("/comp/sysUser")
public class SysUserController {

	@Autowired
	private SysUserDaoJdbc sysUserDaoJdbc;

	@Autowired
	private SysUserDao sysUserDao;

	@Autowired
	private SysRoleDao sysRoleDao;

	@Autowired
	private SchoolDao schoolDao;

	private static final String PATH = "comp/";

	@RequestMapping("/list")
	public String list(Model model, SysUserQueryForm sysUserQueryForm) {
		Page<SysUser> page = sysUserDao.findAll(sysUserQueryForm);
		model.addAttribute(Constant.PAGE_KEY, page);
		return PATH + "sysuser/listSysUser";
	}

	@RequestMapping("/query")
	public String query(Model model, SysUserQueryForm sysUserQueryForm) {
		Page<SysUser> page = sysUserDaoJdbc.query(sysUserQueryForm.getName(),
				sysUserQueryForm.getUserName(),
				sysUserQueryForm.getSchoolName(), sysUserQueryForm);
		model.addAttribute(Constant.PAGE_KEY, page);
		model.addAttribute("sysUserQueryForm", sysUserQueryForm);
		return PATH + "sysuser/listSysUser";
	}

	private List<SysRole> findAllRoles() {
		List<SysRole> sysRoles = sysRoleDao.findAll();
		return sysRoles;
	}

	private List<School> findAllSchools() {
		List<School> schools = schoolDao.findAll();
		return schools;
	}

	/**
	 * 系统用户添加跳转页
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping("/addForward")
	public String addForward(Model model) {
		// Token.clearToken(model);
		model.addAttribute("sysRoles", findAllRoles());
		model.addAttribute("schools", findAllSchools());
		return PATH + "sysuser/addSysUser";
	}

	/**
	 * 添加系统用户
	 * 
	 * @param sysUser
	 * @param bindingResult
	 * @param model
	 * @param redirectAttrs
	 * @return
	 */
	@RequestMapping("/add")
	@Transactional
	public String add(SysUser sysUser, BindingResult bindingResult,
			Model model, RedirectAttributes redirectAttrs) {
		SysUser newUser = sysUserDao.findByUserName(sysUser.getUserName());
		if (newUser != null) {
			// model.addAttribute("sysRoles", findAllRoles());
			model.addAttribute("schools", findAllSchools());
			model.addAttribute("sysUser", sysUser);
			model.addAttribute(Constant.MESSAGE_WARN,
					Constant.WARN_SYSUSER_EXIST);
			return PATH + "sysuser/addSysUser";
		}
		String password = PasswordEncoder.encrypt(sysUser.getUserName(),
				sysUser.getPassword());
		sysUser.setPassword(password);
		sysUser.setIsStop(Constant.SCHOOL_USER_NO_STOP);
		sysUserDao.save(sysUser);
		redirectAttrs.addFlashAttribute(Constant.MESSAGE_SUCCESS,
				Constant.SUCCESS_ADD);
		return "redirect:/comp/sysUser/list";
	}

	@RequestMapping("/getRoles")
	@ResponseBody
	public List<SysRole> getRoles(Long schoolId) {
		List<SysRole> sysRoles = sysRoleDao.findBySchoolId(schoolId);
		return sysRoles;
	}

	/**
	 * 删除系统用户
	 * 
	 * @param id
	 * @param model
	 * @param redirectAttrs
	 * @return
	 */
	@RequestMapping("/delete/{id}")
	@Transactional
	public String delete(@PathVariable Long id, RedirectAttributes redirectAttrs) {
		try {
			sysUserDao.delete(id);
		} catch (Exception e) {
			e.printStackTrace();
			redirectAttrs.addFlashAttribute(Constant.MESSAGE_ERROR,
					Constant.ERROR_DELETE);
			return "redirect:/comp/sysUser/list";
		}
		redirectAttrs.addFlashAttribute(Constant.MESSAGE_SUCCESS,
				Constant.SUCCESS_DELETE);
		return "redirect:/comp/sysUser/list";
	}

	/**
	 * 开启系统用户
	 * 
	 * @param id
	 * @param model
	 * @param redirectAttrs
	 * @return
	 */
	@RequestMapping("/start/{id}")
	@Transactional
	public String start(@PathVariable Long id, RedirectAttributes redirectAttrs) {
		SysUser sysUser = sysUserDao.findOne(id);
		sysUser.setIsStop(Constant.SCHOOL_USER_NO_STOP);
        sysUserDao.save(sysUser);
        redirectAttrs.addFlashAttribute(Constant.MESSAGE_SUCCESS,Constant.SUCCESS_START);
		return "redirect:/comp/sysUser/list";
	}

	/**
	 * 根据id查找系统用户
	 * 
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping("/findOne/{id}")
	public String findOne(@PathVariable("id") Long id, Model model) {
		SysUser sysUser = sysUserDao.findOne(id);
		model.addAttribute("sysUser", sysUser);
		List<School> schools = schoolDao.findAll();
		model.addAttribute("sysRoles",
				sysRoleDao.findBySchoolId(sysUser.getSchool().getId()));
		model.addAttribute("schools", schools);
		return PATH + "sysuser/editSysUser";
	}

	/**
	 * 修改系统用户
	 * 
	 * @param sysUser
	 * @param bindingResult
	 * @param model
	 * @param redirectAttrs
	 * @return
	 */
	@RequestMapping("/edit")
	@Transactional
	public String edit(SysUser sysUser, BindingResult bindingResult,
			Model model, RedirectAttributes redirectAttrs) {
		SysUser newSysUser = sysUserDao.findByUserName(sysUser.getUserName());
		if (newSysUser != null
				&& newSysUser.getId().longValue() != sysUser.getId()
						.longValue()) {
			model.addAttribute("sysRoles",
					sysRoleDao.findBySchoolId(sysUser.getSchool().getId()));
			model.addAttribute("schools", findAllSchools());
			model.addAttribute("sysUser", sysUser);
			model.addAttribute(Constant.MESSAGE_WARN,
					Constant.WARN_SYSUSER_EXIST);
			return PATH + "sysuser/editSysUser";
		}
		if (StringUtils.isBlank(sysUser.getPassword())) {
			sysUser.setPassword(sysUserDao.findOne(sysUser.getId())
					.getPassword());
		} else {
			String password = PasswordEncoder.encrypt(sysUser.getUserName(),
					sysUser.getPassword());
			sysUser.setPassword(password);
		}
		sysUser.setIsStop(Constant.SCHOOL_USER_NO_STOP);
		sysUserDao.save(sysUser);
		redirectAttrs.addFlashAttribute(Constant.MESSAGE_SUCCESS,
				Constant.SUCCESS_EDIT);
		return "redirect:/comp/sysUser/list";
	}
}
