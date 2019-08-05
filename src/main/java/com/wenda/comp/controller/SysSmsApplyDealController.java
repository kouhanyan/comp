package com.wenda.comp.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.wenda.comp.common.util.EnumUtils;
import com.wenda.comp.constant.Constant;
import com.wenda.comp.dao.jdbc.SmsApplyDaoJdbc;
import com.wenda.comp.enumModel.SmsApplyStateEnum;
import com.wenda.comp.form.SmsApplyQueryForm;
import com.wenda.comp.model.SmsApply;
import com.wenda.comp.service.SmsApplyService;

/**
 * <p>
 * Description: 短信申请处理controller
 * </p>
 * Copyright: Copyright (c) 2012 Company: wenda
 * 
 * @Author sfy
 * @Version 1.0 2014-07-21
 */
@Controller
@RequestMapping("/comp/sysSmsApplyDeal")
public class SysSmsApplyDealController extends BaseController{
	@Autowired
	private SmsApplyService smsApplyService;
	@Autowired
	private SmsApplyDaoJdbc smsApplyDaoJdbc;

	private static final String PATH = "comp/";
	

	/**
	 * 列表
	 * 
	 * @param model
	 * @param smsApplyQueryForm
	 * @return
	 */
	@RequestMapping("/list")
	public String list(Model model, SmsApplyQueryForm smsApplyQueryForm) {
		Page<SmsApply> page = smsApplyService.findAll(smsApplyQueryForm);
		model.addAttribute(Constant.PAGE_KEY, page);
		model.addAttribute("states", EnumUtils.enumProp2NameMap(SmsApplyStateEnum.class, "name"));
		return PATH + "sysSmsApplyDeal/list";
	}

	/**
	 * 分页查询
	 * 
	 * @param model
	 * @param seriesCurrencyQueryForm
	 * @return
	 */
	@RequestMapping("/query")
	public String query(Model model, SmsApplyQueryForm smsApplyQueryForm) {
		Page<SmsApply> page = smsApplyDaoJdbc.query(
				smsApplyQueryForm.getSchoolName(),
				smsApplyQueryForm.getApplyStartDate(),
				smsApplyQueryForm.getApplyEndDate(),
				smsApplyQueryForm.getSmsApplyStateEnum(), smsApplyQueryForm);
		model.addAttribute("states", EnumUtils.enumProp2NameMap(SmsApplyStateEnum.class, "name"));
		model.addAttribute("smsApplyQueryForm", smsApplyQueryForm);
		model.addAttribute(Constant.PAGE_KEY, page);
		return PATH + "sysSmsApplyDeal/list";
	}
	
	/**
	 * 审核页面
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping("/audit/{id}")
	public String audit(@PathVariable Long id,Model model,RedirectAttributes redirectAttributes){
		SmsApply sa = smsApplyService.findOne(id);
		if(sa.getApplyState() != SmsApplyStateEnum.APPLY_SUCCESS){
			redirectAttributes.addFlashAttribute(Constant.MESSAGE_ERROR, Constant.WARN_AUDIT);
			return "redirect:/comp/sysSmsApplyDeal/list";
		}
		model.addAttribute("smsApply", sa);
		return PATH+"sysSmsApplyDeal/audit";
	}
	/**
	 * 审核处理
	 * @param id
	 * @param redirectAttributes
	 * @return
	 */
	@RequestMapping(value="/audit",method=RequestMethod.POST)
	public String audit(Long id,RedirectAttributes redirectAttributes,HttpServletRequest request){
		SmsApply sa = smsApplyService.findOne(id);
		smsApplyService.audit(sa);
		redirectAttributes.addFlashAttribute(Constant.MESSAGE_SUCCESS, Constant.SUCCESS_AUDIT);
		return "redirect:/comp/sysSmsApplyDeal/list";
	}
	
	
}
