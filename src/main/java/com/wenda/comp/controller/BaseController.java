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
 * ��ȡweb�������������
 * 
 * @author sfy
 * 
 */
@Controller("/base")
public class BaseController {


	public static final String MID_URL = "midUrl";

	public static final String FORM_TARGET = "formTarget";

	public static final int Z3950_BIBLIOTEMP_URL = 1;// ��Դ����Ŀά����ѯҳ

	public static final int Z3950_BOOKACCEPT_URL = 2;// ��Դ��ͼ�����ղ�ѯҳ

	public static final int Z3950_BIBLIOPUBLIC_URL = 3;// ��Դ�ڹ������ѯҳ

	public static final int Z3950_COLLECTIONBACK_URL = 4;// ��Դ�ڻ��ݽ����ѯҳ

	public static final int Z3950_BOOKORDER_URL = 5;// ��Դ��ͼ��Ԥ����Ŀ����ҳ

	public static final int Z3950_ORDERACCEPT_URL = 6;// ��Դ��Ԥ��������Ŀ����ҳ

	public static final int Z3950_BIBLIOOLDBOOK_URL = 7;// ��Դ�ھ����ѯҳ

	public static final int Z3950_SERIES_BIBLIOTEMP_URL = 16;// ��Դ�ڿ���Ŀ��ѯ

	public static final int Z3950_SERIES_ORDER_URL = 17;// �ڿ�����Ԥ��

	public static final int Z3950_SERIES_DIRECT_URL = 18;// �ڿ�ֱ��Ԥ��

	public static final int Z3950_SERIES_MODIFY_BIND_URL = 19;// �ڿ��϶���װ��

	public static final int Z3950_SERIES_BACK_URL = 20;// �ڿ��϶�������

	@Autowired
	private SysUserDao sysUserDao;

	/**
	 * ��ȡrequest
	 * 
	 * @return
	 */
	public HttpServletRequest getRequest() {
		return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
	}

	/**
	 * ��ȡ����uri
	 * 
	 * @return
	 */
	public String getRequestUri() {
		return getRequest().getRequestURI();
	}

	/**
	 * ��ȡsession
	 * 
	 * @return
	 */
	public HttpSession getSession() {
		return getRequest().getSession();
	}

	/**
	 * ��ȡ��ǰ�û���
	 * 
	 * @return
	 */
	public String getCurrentUserName() {
		String userName = (String) getSession().getAttribute(Constant.USER_NAME_KEY);
		return userName;
	}

	/**
	 * ��ȡ��ǰ��¼�û�
	 * 
	 * @return
	 */
	public SysUser getCurrentUser() {
		String userName = getCurrentUserName();
		SysUser sysUser = sysUserDao.findByUserName(userName);
		return sysUser;
	}

	/**
	 * ��ȡ��ǰ��¼ѧУ
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
	 * z3950����ɹ���·��ѡ��
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
	 * z3950����ɹ���·��ѡ��
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
	 * ����ѯ�Ľ��û��ֵ �����û��ֵ����Ϣ
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
	 * ����ѯ�Ľ��û��ֵ �����û��ֵ����Ϣ
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
