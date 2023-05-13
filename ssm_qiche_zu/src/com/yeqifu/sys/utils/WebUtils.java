// 
// 
// 

package com.yeqifu.sys.utils;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

public class WebUtils
{
    public static ServletRequestAttributes getServletRequestAttributes() {
        return (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
    }
    
    public static HttpServletRequest getHttpServletRequest() {
        return getServletRequestAttributes().getRequest();
    }
    
    public static HttpServletResponse getHttpServletResponse() {
        return getServletRequestAttributes().getResponse();
    }
    
    public static HttpSession getHttpSession() {
        return getHttpServletRequest().getSession();
    }
    
    public static String getServletContext() {
        return getHttpServletRequest().getServletPath();
    }
}
