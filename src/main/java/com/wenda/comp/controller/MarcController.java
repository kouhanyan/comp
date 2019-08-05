package com.wenda.comp.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.wenda.comp.common.util.Config;
import com.wenda.comp.common.util.MarcUtil;
import com.wenda.comp.constant.Constant;
import com.wenda.comp.dao.BookCirculateTypeDao;
import com.wenda.comp.dao.CollectionPlaceDao;
import com.wenda.comp.dao.SchoolDao;
import com.wenda.comp.dao.SysDicDao;
import com.wenda.comp.exception.BusinessException;
import com.wenda.comp.form.MarcForm;
import com.wenda.comp.model.BookCirculateType;
import com.wenda.comp.model.CollectionPlace;
import com.wenda.comp.model.School;

/**
 * 
 * @ClassName: MarcController
 * @Description: TODO
 * @author: zhaopo
 * @version: V1.0
 * @date: 2016年11月7日 下午3:57:15
 */
@Controller
@RequestMapping("/comp/marc")
public class MarcController extends BaseController {
	@Autowired
	private SysDicDao sysDicDao;
	@Autowired
	private SchoolDao schoolDao;
	@Autowired
	private BookCirculateTypeDao bookCirculateTypeDao;
	@Autowired
	private CollectionPlaceDao collectionPlaceDao;
	protected static final String PATH = "comp/";

	/**
	 * 
	 * @Title: add
	 * @Description: marc导入页面（选择参数）
	 * @return
	 * @return: String
	 */
	@RequestMapping("/add")
	public String add(Model model) {
		model.addAttribute("charsets", sysDicDao.findByType(Constant.CHAESET));
		model.addAttribute("userId", getCurrentUser().getId());
		return PATH + "/marc/add";

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
	 * @Title: getPlaceAndType
	 * @Description: 获取文献流通类型和馆藏地点
	 * @param schoolName
	 * @return
	 * @return: Map<String,Object>
	 */
	@RequestMapping("/getPlaceAndType")
	@ResponseBody
	public Map<String, Object> getPlaceAndType(Long schoolName, Model model) {
		List<BookCirculateType> types = bookCirculateTypeDao.getList(schoolName);
		List<CollectionPlace> places = collectionPlaceDao.getList(schoolName);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("types", types);
		map.put("places", places);
		return map;

	}

}
