package com.wenda.comp.controller;


import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;


import com.wenda.comp.common.util.RequestUtils;
import com.wenda.comp.constant.Constant;
import com.wenda.comp.form.SysUserQueryForm;
import com.wenda.comp.model.SysUser;
import com.wenda.comp.service.CompLogService;
import com.wenda.comp.service.LoginService;

@Controller
@RequestMapping("/login")
@SessionAttributes(value = {Constant.USER_NAME_KEY})
public class LoginController extends BaseController {
       
    @Autowired
    private LoginService loginService;
    
    @Autowired
    private CompLogService compLogService;
    

    
    /**
     * 公司登录跳转
     * 
     * @param session
     * @param request
     * @param response
     * @throws IOException
     * @throws ServletException
     */
    @RequestMapping("/compForward")
    public void compForward(HttpSession session, HttpServletRequest request, HttpServletResponse response)
        throws IOException, ServletException {
        SysUser localUser = (SysUser)session.getAttribute(Constant.LOCAL_USER);
        if (localUser != null && localUser.getSchool().getType() == Constant.IS_COMPANY) {
            response.sendRedirect("/frame/frameset.jsp");
            return;
        }
        request.getRequestDispatcher("/frame/login.jsp").forward(request, response);
        return;
    }
    
    /**
     * 公司登录
     * 
     * @param request
     * @param response
     * @param sysUserQueryForm
     * @throws IOException
     * @throws ServletException
     */
    @RequestMapping("/company")
    public void loginComp(HttpServletRequest request, HttpSession session, HttpServletResponse response,
        SysUserQueryForm sysUserQueryForm)
        throws IOException, ServletException {
        boolean isLoginSuccess =
            loginService.isLoginSuccess(sysUserQueryForm.getUserName(),
                sysUserQueryForm.getRawPass(),
                Constant.IS_COMPANY);
        if (!isLoginSuccess) {
            request.setAttribute(Constant.LOGIN_ERROR, Constant.LOGIN_ERROR_INFO);
            request.getRequestDispatcher("/frame/login.jsp").forward(request, response);
        } else {
            session.setAttribute(Constant.USER_NAME_KEY, sysUserQueryForm.getUserName());
            session.setAttribute(Constant.LOCAL_USER, getCurrentUser());
            compLogService.addCompLog(getCurrentUserName(), RequestUtils.getIpAddr(getRequest()),new Date());
            response.sendRedirect("/frame/frameset.jsp");
            return;
        }
    }
    
    /**
     * 公司系统登出
     * 
     * @param session
     * @param response
     * @throws IOException
     */
    @RequestMapping("/compOut")
    public void compOut(HttpSession session, HttpServletResponse response)
        throws IOException {
        if (session != null)
            session.setMaxInactiveInterval(1);
        response.sendRedirect("/frame/login.jsp");
        return;
    }
}
