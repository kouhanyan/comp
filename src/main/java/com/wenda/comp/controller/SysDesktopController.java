package com.wenda.comp.controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Timestamp;
import java.util.Date;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.wenda.comp.common.util.Config;
import com.wenda.comp.constant.Constant;
import com.wenda.comp.dao.SysDesktopDao;
import com.wenda.comp.exception.BusinessException;
import com.wenda.comp.form.SysDesktopQueryForm;
import com.wenda.comp.model.SysDesktop;

/**
 * <p>
 * Description: 系统桌面controller
 * </p>
 * Copyright: Copyright (c) 2012 Company: wenda
 * 
 * @Author sfy
 * @Version 1.0 2014-07-21
 */
@Controller
@RequestMapping("/comp/sysDesktop")
public class SysDesktopController {

	@Autowired
	private SysDesktopDao sysDesktopDao;

	private static final String PATH = "comp/";

	/**
	 * 获取系统桌面列表
	 * 
	 * @param model
	 * @param sysDesktopQueryForm
	 * @return
	 */
	@RequestMapping("/list")
	public String list(Model model, SysDesktopQueryForm sysDesktopQueryForm) {
		Page<SysDesktop> page = sysDesktopDao.findAll(sysDesktopQueryForm);
		model.addAttribute(Constant.PAGE_KEY, page);
		model.addAttribute("sysDesktopQueryForm", sysDesktopQueryForm);
		return PATH + "sysdesktop/listSysDesktop";
	}

	/**
	 * 查询系统桌面
	 * 
	 * @param model
	 * @param sysDesktopQueryForm
	 * @return
	 */
	@RequestMapping("/query")
	public String query(Model model, SysDesktopQueryForm sysDesktopQueryForm) {
		Page<SysDesktop> page = sysDesktopDao.query(
				"%" + sysDesktopQueryForm.getName() + "%", sysDesktopQueryForm);
		model.addAttribute(Constant.PAGE_KEY, page);
		return PATH + "sysdesktop/listSysDesktop";
	}

	/**
	 * 添加系统桌面跳转页
	 * 
	 * @return
	 */
	@RequestMapping("/addForward")
	public String addForward() {
		return PATH + "sysdesktop/addSysDesktop";
	}

	private String uploadIcon(MultipartFile file, Model model) {
		String filePath = null;
		try {
			filePath = Config.parseFilePath("windows.sysDesktop.icon",
					"linux.sysDesktop.icon", file);
		} catch (BusinessException e) {
			e.printStackTrace();
			model.addAttribute(Constant.MESSAGE_ERROR, e.getMessage());
			return PATH + "sysdesktop/addSysDesktop";
		}
		return filePath;
	}

	/**
	 * 添加系统桌面
	 * 
	 * @param icon
	 * @param sysDesktop
	 * @param bindingResult
	 * @param model
	 * @param redirectAttrs
	 * @return
	 */
	@RequestMapping("/add")
	@Transactional
	public String add(@RequestParam("file") MultipartFile file,
			SysDesktop sysDesktop, BindingResult bindingResult, Model model,
			RedirectAttributes redirectAttrs) {
		if (bindingResult.hasErrors()) {
			model.addAttribute("sysDesktop", sysDesktop);
			model.addAttribute(Constant.MESSAGE_ERROR, Constant.ERROR_ADD);
			return PATH + "sysdesktop/addSysDesktop";
		}
		sysDesktop.setCreateDate(new Timestamp(new Date().getTime()));
		sysDesktop.setUrl(uploadIcon(file, model));
		sysDesktopDao.save(sysDesktop);
		redirectAttrs.addFlashAttribute(Constant.MESSAGE_SUCCESS,
				Constant.SUCCESS_ADD);
		return "redirect:/comp/sysDesktop/list";
	}

	/**
	 * 删除系统桌面管理
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
			sysDesktopDao.delete(id);
			redirectAttrs.addFlashAttribute(Constant.MESSAGE_SUCCESS,
					Constant.SUCCESS_DELETE);
		} catch (Exception e) {
			redirectAttrs.addFlashAttribute(Constant.MESSAGE_ERROR,
					Constant.ERROR_DELETE);
			return "redirect:comp/sysDesktop/list";
		}
		return "redirect:/comp/sysDesktop/list";
	}

	@RequestMapping("/icos/{id}")
	public void initImageStream(HttpServletResponse response,
			@PathVariable("id") Long id) throws IOException {
		response.setContentType("ico/png/icns");
		InputStream in = new FileInputStream(sysDesktopDao.findOne(id).getUrl());
		ServletOutputStream out = response.getOutputStream();
		int len;
		byte[] buf = new byte[1024];
		while ((len = in.read(buf, 0, buf.length)) != -1) {
			out.write(buf, 0, len);
		}
		out.flush();
		in.close();
		out.close();
	}

	/**
	 * 通过id查找系统桌面
	 * 
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping("/findOne/{id}")
	public String findOne(@PathVariable("id") Long id, Model model) {
		SysDesktop sysDesktop = sysDesktopDao.findOne(id);
		model.addAttribute("sysDesktop", sysDesktop);
		return PATH + "sysdesktop/editSysDesktop";
	}

	@RequestMapping("/edit")
	@Transactional
	public String edit(@RequestParam("file") MultipartFile file,
			SysDesktop sysDesktop, BindingResult bindingResult, Model model,
			RedirectAttributes redirectAttrs) {
		if (bindingResult.hasErrors()) {
			model.addAttribute("sysDesktop", sysDesktop);
			model.addAttribute(Constant.MESSAGE_ERROR, Constant.ERROR_EDIT);
			return PATH + "sysdesktop/editSysDesktop";
		}
		sysDesktop.setCreateDate(new Timestamp(new Date().getTime()));
		if (file != null && !file.isEmpty()) {
			sysDesktop.setUrl(uploadIcon(file, model));
		}
		sysDesktopDao.save(sysDesktop);
		redirectAttrs.addFlashAttribute(Constant.MESSAGE_SUCCESS,
				Constant.SUCCESS_EDIT);
		return "redirect:/comp/sysDesktop/list";
	}
}
