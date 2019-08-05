package com.wenda.comp.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.wenda.comp.constant.Constant;
import com.wenda.comp.dao.SysUserDao;
import com.wenda.comp.model.School;
import com.wenda.comp.model.SysUser;

/**
 * 获取web容器共享控制器
 * 
 * @author sfy
 * 
 */
@Controller("/base")
public class BaseController {


	public static final String MID_URL = "midUrl";

	public static final String FORM_TARGET = "formTarget";

	public static final int Z3950_BIBLIOTEMP_URL = 1;// 来源于书目维护查询页

	public static final int Z3950_BOOKACCEPT_URL = 2;// 来源于图书验收查询页

	public static final int Z3950_BIBLIOPUBLIC_URL = 3;// 来源于公共库查询页

	public static final int Z3950_COLLECTIONBACK_URL = 4;// 来源于回溯建库查询页

	public static final int Z3950_BOOKORDER_URL = 5;// 来源于图书预订书目查重页

	public static final int Z3950_ORDERACCEPT_URL = 6;// 来源于预订验收书目查重页

	public static final int Z3950_BIBLIOOLDBOOK_URL = 7;// 来源于旧书查询页

	public static final int Z3950_SERIES_BIBLIOTEMP_URL = 16;// 来源期刊书目查询

	public static final int Z3950_SERIES_ORDER_URL = 17;// 期刊查重预定

	public static final int Z3950_SERIES_DIRECT_URL = 18;// 期刊直接预定

	public static final int Z3950_SERIES_MODIFY_BIND_URL = 19;// 期刊合订本装订

	public static final int Z3950_SERIES_BACK_URL = 20;// 期刊合订本回溯

	@Autowired
	private SysUserDao sysUserDao;

	/**
	 * 获取request
	 * 
	 * @return
	 */
	public HttpServletRequest getRequest() {
		return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
	}

	/**
	 * 获取请求uri
	 * 
	 * @return
	 */
	public String getRequestUri() {
		return getRequest().getRequestURI();
	}

	/**
	 * 获取session
	 * 
	 * @return
	 */
	public HttpSession getSession() {
		return getRequest().getSession();
	}

	/**
	 * 获取当前用户名
	 * 
	 * @return
	 */
	public String getCurrentUserName() {
		String userName = (String) getSession().getAttribute(Constant.USER_NAME_KEY);
		return userName;
	}

	/**
	 * 获取当前登录用户
	 * 
	 * @return
	 */
	public SysUser getCurrentUser() {
		String userName = getCurrentUserName();
		SysUser sysUser = sysUserDao.findByUserName(userName);
		return sysUser;
	}

	/**
	 * 获取当前登录学校
	 * 
	 * @return
	 */
	public School getCurrentSchool() {
		String userName = getCurrentUserName();
		SysUser sysUser = sysUserDao.findByUserName(userName);
		return sysUser.getSchool();
	}

	public Long getReaderId() {
		Long readerId = (Long) getSession().getAttribute(Constant.READER_ID);
		return readerId;
	}

	/**
	 * z3950保存成功后路径选择
	 * 
	 * @param urlMark
	 * @return
	 */
	public String z3950RedirectUrl(Integer urlMark, String isbn) {
		if (StringUtils.isNotBlank(isbn)) {
			String redirectUrl = null;
			switch (urlMark) {
			case Z3950_SERIES_BIBLIOTEMP_URL:
				redirectUrl = "redirect:/series/biblioTemp/query?isbn=" + isbn;
				break;
			case Z3950_SERIES_ORDER_URL:
				redirectUrl = "redirect:/series/order/batch/listRepeatBiblio?isbn=" + isbn;
				break;
			case Z3950_SERIES_DIRECT_URL:
				redirectUrl = "redirect:/series/order/direct/queryBiblioTemp?isbn=" + isbn;
				break;
			case Z3950_SERIES_MODIFY_BIND_URL:
				redirectUrl = "redirect:/series/bind/queryBiblioTemp?isbn=" + isbn;
				break;
			case Z3950_SERIES_BACK_URL:
				redirectUrl = "redirect:/series/backtracking/queryBiblioTemp?isbn=" + isbn;
				break;
			}
			return redirectUrl;
		} else {
			return z3950RedirectUrl(urlMark);
		}
	}

	/**
	 * z3950保存成功后路径选择
	 * 
	 * @param urlMark
	 * @return
	 */
	public String z3950RedirectUrl(Integer urlMark) {
		String redirectUrl = null;
		switch (urlMark) {
		case Z3950_BIBLIOTEMP_URL:
			redirectUrl = "redirect:/biblioAcceptanceBook/biblioList";
			break;
		case Z3950_BOOKACCEPT_URL:
			redirectUrl = "redirect:/biblioAcceptanceBook/biblioList";
			break;
		case Z3950_BIBLIOPUBLIC_URL:
			redirectUrl = "redirect:/biblioAcceptanceBook/biblioList";
			break;
		case Z3950_COLLECTIONBACK_URL:
			redirectUrl = "redirect:/collectionBack/biblioList";
			break;
		case Z3950_BOOKORDER_URL:
			redirectUrl = "redirect:/bookOrder/listRepeatBiblio";
			break;
		case Z3950_ORDERACCEPT_URL:
			redirectUrl = "redirect:/orderAccept/listRepeatBiblio";
			break;
		case Z3950_BIBLIOOLDBOOK_URL:
			redirectUrl = "redirect:/biblioOldBook/listBiblioOldBook";
			break;
		}
		return redirectUrl;
	}

	/**
	 * 若查询的结果没有值 则添加没有值的信息
	 * 
	 * @param list
	 * @param model
	 */
	public void prompt(List<? extends Object> list, Model model) {
		if (list == null || list.size() <= 0) {
			model.addAttribute(Constant.MESSAGE_WARN, Constant.WARN_QUERY_NO);
		}
	}

	/**
	 * 若查询的结果没有值 则添加没有值的信息
	 * 
	 * @param page
	 * @param model
	 */
	public void prompt(Page<? extends Object> page, Model model) {
		if (page == null || page.getContent().size() == 0) {
			model.addAttribute(Constant.MESSAGE_WARN, Constant.WARN_QUERY_NO);
		}
	}

}
