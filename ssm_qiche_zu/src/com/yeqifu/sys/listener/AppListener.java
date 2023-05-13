// 
// 
// 

package com.yeqifu.sys.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.annotation.WebListener;
import javax.servlet.ServletContextListener;

@WebListener
public class AppListener implements ServletContextListener
{
    public void contextDestroyed(final ServletContextEvent arg0) {
    }
    
    public void contextInitialized(final ServletContextEvent arg0) {
        final ServletContext context = arg0.getServletContext();
        context.setAttribute("yeqifu", (Object)context.getContextPath());
        System.err.println("---------Servlet\u5bb9\u5668\u521b\u5efa\u6210\u529f ctx\u88ab\u653e\u5230ServletContext\u4f5c\u7528\u57df-------");
    }
}
