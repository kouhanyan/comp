package com.wenda.comp.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.wenda.comp.common.util.FileUtil;
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
 * Description: 反馈controller
 * </p>
 * Copyright: Copyright (c) 2012 Company: wenda
 * 
 * @Author sfy
 * @Version 1.0 2014-07-21
 */
@Controller
@RequestMapping("/comp/feedBack")
public class SysFeedBackController extends BaseController {
	@Autowired
	private FeedBackService feedBackService;

	@Autowired
	private FeedBackDao feedBackDao;

	@Autowired
	private SysDicDao sysDicDao;

	@Autowired
	private FeedBackDaoJdbc feedBackDaoJdbc;

	private static final String COMP_PATH = "comp/";

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
		Page<FeedBack> page = feedBackDao.findAll(feedBackQueryForm);
		model.addAttribute("sysDics", findSysDics());
		model.addAttribute(Constant.PAGE_KEY, page);
		return COMP_PATH + "feedback/listFeedBack";
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
		return COMP_PATH + "feedback/listFeedBack";
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
				return "redirect:/comp/feedBack/list";
			}
			feedBackDao.delete(id);
			redirectAttrs.addFlashAttribute(Constant.MESSAGE_SUCCESS,
					Constant.SUCCESS_DELETE);
		} catch (Exception e) {
			redirectAttrs.addFlashAttribute(Constant.MESSAGE_ERROR,
					Constant.ERROR_DELETE);
			return "redirect:/comp/feedBack/list";
		}
		return "redirect:/comp/feedBack/list";
	}

	/**
	 * 反馈的详情页面
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping("/detail/{id}")
	public String detail(@PathVariable Long id, Model model) {
		model.addAttribute("feedBack", feedBackDao.findOne(id));
		return COMP_PATH + "/feedback/detailFeedBack";
	}

	/**
	 * 
	 * @param binaryData
	 * @param response
	 */
	@RequestMapping("/image/{id}")
	public void image(@PathVariable("id") Long id, HttpServletResponse response) {
		response.setContentType("image/png");// 设置相应类型,告诉浏览器输出的内容为图片
		response.setHeader("Pragma", "No-cache");// 设置响应头信息，告诉浏览器不要缓存此内容
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expire", 0);
		try {
			FileUtil.writeBinaryDataToImage(setImageToByteArray(feedBackDao
					.findOne(id).getImagePath()), response);
		} catch (BusinessException e) {
			e.printStackTrace();
		}

	}

	/**
	 * 将文件转换成二进制
	 * 
	 * @param filePath
	 * @return
	 */
	private byte[] setImageToByteArray(String filePath) {
		byte[] b = null;
		try {
			FileInputStream fis = new FileInputStream(new File(filePath));
			b = new byte[fis.available()];
			fis.read(b);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return b;
	}

}
