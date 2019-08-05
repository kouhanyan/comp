package com.wenda.comp.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wenda.comp.constant.Constant;
import com.wenda.comp.dao.SchoolDao;
import com.wenda.comp.dao.SysDicDao;
import com.wenda.comp.dao.SysUserDao;
import com.wenda.comp.model.School;
import com.wenda.comp.model.SysUser;
@Controller
@RequestMapping("/comp/readerLendRecord")
public class ReaderLendRecordController  extends BaseController{

	protected static final String PATH = "comp/";
	
	@Autowired
	private SysUserDao sysUserDao;
	
	@Autowired
	private SysDicDao sysDicDao;
	
	@Autowired
	private SchoolDao schoolDao;
	
	/**
	 * 
	 * @Title: add
	 * @Description: 获取流通数据导入的页面
	 * @param model
	 * @return
	 * @return: String
	 */
	@RequestMapping("/add")
	public String add(Model model) {
		model.addAttribute("charsets", sysDicDao.findByType(Constant.CHAESET));
		model.addAttribute("userId", getCurrentUser().getId());
		return PATH + "/readerLendRecord/add";

	}
	
	/**
	 * 
	 * @Title: searchSchool
	 * @Description: 查询学校
	 * @param schoolName
	 * @return
	 * @return: List<School>
	 */
	@RequestMapping("/searchSchool")
	@ResponseBody
	public List<School> searchSchool(String schoolName) {
		List<School> list = schoolDao.findByName("%" + schoolName.trim() + "%");
		return list;
	}
	
	/**
	 * 
	 * @Title: getSysUse
	 * @Description: 获取系统管理员
	 * @param schoolName
	 * @param model
	 * @return
	 * @return: Map<String,Object>
	 */
	@RequestMapping("/getSysUser")
	@ResponseBody
	public Map<String, Object> getSysUse(Long schoolName, Model model){
		List<SysUser> list = sysUserDao.getListBySchoolId(schoolName);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("sysUsers", list);
		return map;
	}
}
