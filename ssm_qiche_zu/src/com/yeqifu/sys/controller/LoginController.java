// 
// 
// 

package com.yeqifu.sys.controller;

import java.io.IOException;
import javax.servlet.ServletOutputStream;
import cn.hutool.captcha.LineCaptcha;
import java.io.OutputStream;
import java.awt.image.RenderedImage;
import javax.imageio.ImageIO;
import cn.hutool.captcha.CaptchaUtil;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletResponse;
import com.yeqifu.sys.domain.User;
import java.util.Date;
import com.yeqifu.sys.vo.LogInfoVo;
import com.yeqifu.sys.utils.WebUtils;
import org.springframework.ui.Model;
import com.yeqifu.sys.vo.UserVo;
import com.yeqifu.sys.service.ILogInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import com.yeqifu.sys.service.IUserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;

@Controller
@RequestMapping({ "login" })
public class LoginController
{
    @Autowired
    private IUserService userService;
    @Autowired
    private ILogInfoService logInfoService;
    
    @RequestMapping({ "toLogin" })
    public String toLogin() {
        return "system/main/login";
    }
    
    @RequestMapping({ "login" })
    public String login(final UserVo userVo, final Model model) {
        final String code = WebUtils.getHttpSession().getAttribute("code").toString();
        if (!userVo.getCode().equals(code)) {
            model.addAttribute("error", (Object)"\u9a8c\u8bc1\u7801\u4e0d\u6b63\u786e");
            return "system/main/login";
        }
        final User user = this.userService.login(userVo);
        System.out.println(user);
        if (user != null) {
            WebUtils.getHttpSession().setAttribute("user", (Object)user);
            final LogInfoVo logInfoVo = new LogInfoVo();
            logInfoVo.setLogintime(new Date());
            logInfoVo.setLoginname(String.valueOf(user.getRealname()) + "-" + user.getLoginname());
            logInfoVo.setLoginip(WebUtils.getHttpServletRequest().getRemoteAddr());
            this.logInfoService.addLogInfo(logInfoVo);
            return "system/main/index";
        }
        model.addAttribute("error", (Object)"\u7528\u6237\u540d\u6216\u5bc6\u7801\u4e0d\u6b63\u786e");
        return "system/main/login";
    }
    
    @RequestMapping({ "getCode" })
    public void getCode(final HttpServletResponse response, final HttpSession session) throws IOException {
        final LineCaptcha lineCaptcha = CaptchaUtil.createLineCaptcha(116, 36, 4, 5);
        session.setAttribute("code", (Object)lineCaptcha.getCode());
        final ServletOutputStream outputStream = response.getOutputStream();
        ImageIO.write(lineCaptcha.getImage(), "JPEG", (OutputStream)outputStream);
    }
}
