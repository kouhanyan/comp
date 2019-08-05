package com.wenda.comp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.wenda.comp.constant.Constant;
import com.wenda.comp.dao.FeedBackDao;
import com.wenda.comp.dao.SysDicDao;
import com.wenda.comp.dao.jdbc.FeedBackDaoJdbc;
import com.wenda.comp.exception.BusinessException;
import com.wenda.comp.form.FeedBackQueryForm;
import com.wenda.comp.model.FeedBack;
import com.wenda.comp.model.School;
import com.wenda.comp.model.SysDic;
import com.wenda.comp.service.FeedBackService;

/**
 * <p>
 * Description: 反馈Managercontroller
 * </p>
 * Copyright: Copyright (c) 2012 Company: wenda
 * 
 * @Author sfy
 * @Version 1.0 2014-07-21
 */
@Controller
@RequestMapping("/feedBack")
public class FeedBackController extends BaseController {

	@Autowired
	private FeedBackService feedBackService;

	@Autowired
	private FeedBackDao feedBackDao;

	@Autowired
	private SysDicDao sysDicDao;

	@Autowired
	private FeedBackDaoJdbc feedBackDaoJdbc;

	private static final String MANA_PATH = "maneger/";

	private List<SysDic> findSysDics() {
		List<SysDic> sysDics = sysDicDao.findByType(Constant.FEED_BACK_TYPE);
		return sysDics;
	}

	/**
	 * 获取反馈列表
	 * 
	 * @param model
	 * @param feedBackQueryForm
	 * @return
	 */
	@RequestMapping("/list")
	public String list(Model model, FeedBackQueryForm feedBackQueryForm) {
		Page<FeedBack> page = null;
		String userName = getCurrentUserName();
		School school = feedBackService.findSchool(userName);
		model.addAttribute("sysDics", findSysDics());
		page = feedBackDao.findBySchoolId(school.getId(), feedBackQueryForm);
		model.addAttribute(Constant.PAGE_KEY, page);
		return MANA_PATH + "feedback/listFeedBack";

	}

	/**
	 * 查询反馈信息
	 * 
	 * @param model
	 * @param feedBackQueryForm
	 * @return
	 */
	@RequestMapping("/query")
	public String query(Model model, FeedBackQueryForm feedBackQueryForm) {
		School school = getCurrentSchool();
		Page<FeedBack> page = feedBackDaoJdbc.query(school.getId(),
				school.getType(), feedBackQueryForm.getSysUserName(),
				feedBackQueryForm.getSchoolName(),
				feedBackQueryForm.getIsDeal(), feedBackQueryForm);
		model.addAttribute(Constant.PAGE_KEY, page);
		model.addAttribute("sysDics", findSysDics());
		model.addAttribute("feedBackQueryForm", feedBackQueryForm);
		return MANA_PATH + "feedback/listFeedBack";
	}

	/**
	 * 反馈信息添加跳转页
	 * 
	 * @return
	 */
	@RequestMapping("/addForward")
	public String addForward() {
		return MANA_PATH + "feedback/addFeedBack";
	}

	/**
	 * 添加反馈信息
	 * 
	 * @param file
	 * @param feedBack
	 * @param redirectAttrs
	 * @param model
	 * @return
	 */
	@RequestMapping("/add")
	public String add(@RequestParam("file") MultipartFile file,
			FeedBack feedBack, RedirectAttributes redirectAttrs, Model model) {
		try {
			feedBackService.saveFeedBack(getCurrentUserName(), feedBack, file);
			redirectAttrs.addFlashAttribute(Constant.MESSAGE_SUCCESS,
					Constant.SUCCESS_ADD);
		} catch (BusinessException e) {
			e.printStackTrace();
			model.addAttribute(Constant.MESSAGE_ERROR, e.getMessage());
			return MANA_PATH + "feedback/addFeedBack";
		}
		return "redirect:/feedBack/list";
	}

	/**
	 * 删除反馈信息
	 * 
	 * @param id
	 * @param redirectAttrs
	 * @return
	 */
	@RequestMapping("/delete/{id}")
	public String delete(@PathVariable("id") Long id,
			RedirectAttributes redirectAttrs) {
		try {
			School school = feedBackService.findSchool(getCurrentUserName());
			FeedBack feedBack = feedBackDao.findOne(id);
			if (school.getType() == Constant.IS_COMPANY
					&& feedBack.getIsDeal() == Constant.NOT_DEAL) {
				redirectAttrs.addFlashAttribute(Constant.MESSAGE_WARN,
						Constant.WARN_FEEDBACK_NODEAL);
				return "redirect:/feedBack/list";
			}
			feedBackDao.delete(id);
			redirectAttrs.addFlashAttribute(Constant.MESSAGE_SUCCESS,
					Constant.SUCCESS_DELETE);
		} catch (Exception e) {
			redirectAttrs.addFlashAttribute(Constant.MESSAGE_ERROR,
					Constant.ERROR_DELETE);
			return "redirect:/feedBack/list";
		}
		return "redirect:/feedBack/list";
	}

	/**
	 * 通过id查找反馈信息
	 * 
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping("/findOne/{id}")
	public String findOne(@PathVariable("id") Long id, Model model) {
		FeedBack feedBack = feedBackDao.findOne(id);
		model.addAttribute("feedBack", feedBack);
		return MANA_PATH + "feedback/editFeedBack";
	}

	/**
	 * 修改反馈信息
	 * 
	 * @param file
	 * @param feedBack
	 * @param redirectAttrs
	 * @param model
	 * @return
	 */
	@RequestMapping("/edit")
	public String edit(@RequestParam("file") MultipartFile file,
			FeedBack feedBack, RedirectAttributes redirectAttrs, Model model) {
		try {
			feedBackService.saveFeedBack(getCurrentUserName(), feedBack, file);
		} catch (BusinessException e) {
			e.printStackTrace();
			model.addAttribute(Constant.MESSAGE_ERROR, e.getMessage());
			return MANA_PATH + "feedback/editFeedBack";
		}
		redirectAttrs.addFlashAttribute(Constant.MESSAGE_SUCCESS,
				Constant.SUCCESS_EDIT);
		return "redirect:/feedBack/list";
	}

	/**
	 * 下载反馈问题截图文件
	 * 
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping("/download/{id}")
	public ResponseEntity<byte[]> downLoad(@PathVariable("id") Long id,
			Model model) {
		try {
			return feedBackService.downLoadFile(id);
		} catch (BusinessException e) {
			e.printStackTrace();
			model.addAttribute(Constant.MESSAGE_ERROR, e.getMessage());
			return null;
		}
	}

	/**
	 * 处理或撤销反馈信息
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping("/dealOrCancel")
	@ResponseBody
	public String deal(@RequestParam("id") Long id) {
		feedBackService.dealOrCancelFeedBack(id);
		return "success";
	}

}
