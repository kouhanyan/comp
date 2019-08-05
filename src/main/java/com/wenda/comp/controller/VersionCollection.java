package com.wenda.comp.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wenda.comp.model.SysVersion;
import com.wenda.comp.service.SysVersionService;

/**
 * <p>
 * Description: �汾��Ϣcontroller
 * </p>
 * Copyright: Copyright (c) 2012 Company: wenda
 * 
 * @Author jzp
 * @Version 1.0 2014-07-21
 */
@Controller
@RequestMapping("/version")
public class VersionCollection extends BaseController{
	@Autowired
	private SysVersionService sysVersionService;
	
	private static final String PATH = "maneger/";
	
	/**
	 * ��ʾ��ǰ�������Ϣ
	 * @return
	 */
	@RequestMapping("/show")
	public String showCurrentVersionInfo(Model model,HttpServletResponse response,HttpServletRequest request){
		List<SysVersion> sysVersions = sysVersionService.getByICV(true);
		if(sysVersions != null && sysVersions.size() > 0){
			model.addAttribute("version", sysVersions.get(0));
			return PATH+"version/show";
		}else{
			try {
				request.setAttribute("error", "δ�а汾��Ϣ");
				request.getRequestDispatcher("/maneger/error.jsp").forward(request,
						response);//��ʾδ����ҳ��
			} catch (ServletException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return null;
		}
	}
	
	

}
