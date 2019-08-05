package com.wenda.comp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wenda.comp.constant.Constant;
import com.wenda.comp.form.CompLogQueryForm;
import com.wenda.comp.model.CompLog;
import com.wenda.comp.service.CompLogService;

/**
 * <p>
 * Description: 系统后台日志controller
 * </p>
 * Copyright: Copyright (c) 2012 Company: wenda
 * 
 * @Author sfy
 * @Version 1.0 2014-07-18
 */
@Controller
@RequestMapping("/comp/compLog")
public class CompLogController {

	@Autowired
	private CompLogService compLogService;

	private static final String COMP_PATH = "comp/";

	/**
	 * 系统日志列表
	 * @param model
	 * @param compLogQueryForm
	 * @return
	 */
	@RequestMapping("/list")
	public String list(Model model, CompLogQueryForm compLogQueryForm) {
		Page<CompLog> page = compLogService.query(null, null, null,
				compLogQueryForm);
		model.addAttribute(Constant.PAGE_KEY, page);
		return COMP_PATH + "complog/listCompLog";
	}

	/**
	 * 查询系统日志
	 * @param model
	 * @param compLogQueryForm
	 * @return
	 */
	@RequestMapping("/query")
	public String query(Model model, CompLogQueryForm compLogQueryForm) {
		Page<CompLog> page = compLogService.query(
				compLogQueryForm.getUserName(),
				compLogQueryForm.getStartDate(), compLogQueryForm.getEndDate(),
				compLogQueryForm);
		if(page.getContent().size()==0){	
			model.addAttribute(Constant.MESSAGE_WARN, Constant.WARN_QUERY_NO);
			return COMP_PATH + "complog/listCompLog";
		}
		model.addAttribute("compLogQueryForm", compLogQueryForm);
		model.addAttribute(Constant.PAGE_KEY, page);
		return COMP_PATH + "complog/listCompLog";
	}
}
