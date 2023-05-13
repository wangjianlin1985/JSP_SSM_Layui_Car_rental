// 
// 
// 

package com.yeqifu.sys.utils;

import org.springframework.context.ApplicationContext;
import com.yeqifu.sys.domain.Menu;
import com.yeqifu.sys.mapper.MenuMapper;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class InitMenuData
{
    public static void main(final String[] args) {
        final ApplicationContext context = (ApplicationContext)new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        final MenuMapper menuMapper = (MenuMapper)context.getBean((Class)MenuMapper.class);
        menuMapper.insert(new Menu(1, 0, "\u6c7d\u8f66\u79df\u8d41\u7cfb\u7edf", null, 1, null, "&#xe68e;", 1));
        menuMapper.insert(new Menu(2, 1, "\u57fa\u7840\u7ba1\u7406", null, 1, null, "&#xe621;", 1));
        menuMapper.insert(new Menu(3, 1, "\u4e1a\u52a1\u7ba1\u7406", null, 0, null, "&#xe663;", 1));
        menuMapper.insert(new Menu(4, 1, "\u7cfb\u7edf\u7ba1\u7406", null, 0, null, "&#xe716;", 1));
        menuMapper.insert(new Menu(5, 1, "\u7edf\u8ba1\u5206\u6790", null, 0, null, "&#xe629;", 1));
        menuMapper.insert(new Menu(6, 2, "\u5ba2\u6237\u7ba1\u7406", null, 0, null, "&#xe770;", 1));
        menuMapper.insert(new Menu(7, 2, "\u8f66\u8f86\u7ba1\u7406", null, 0, null, "&#xe657;", 1));
        menuMapper.insert(new Menu(8, 3, "\u6c7d\u8f66\u51fa\u79df", null, 0, null, "&#xe65b;", 1));
        menuMapper.insert(new Menu(9, 3, "\u51fa\u79df\u5355\u7ba1\u7406", null, 0, null, "&#xe6b2;", 1));
        menuMapper.insert(new Menu(10, 3, "\u6c7d\u8f66\u5165\u5e93", null, 0, null, "&#xe65a;", 1));
        menuMapper.insert(new Menu(11, 3, "\u68c0\u67e5\u5355\u7ba1\u7406", null, 0, null, "&#xe705", 1));
        menuMapper.insert(new Menu(12, 4, "\u83dc\u5355\u7ba1\u7406", null, 0, null, "&#xe60f", 1));
        menuMapper.insert(new Menu(13, 4, "\u89d2\u8272\u7ba1\u7406", null, 0, null, "&#xe66f;", 1));
        menuMapper.insert(new Menu(14, 4, "\u7528\u6237\u7ba1\u7406", null, 0, null, "&#xe770;", 1));
        menuMapper.insert(new Menu(15, 4, "\u65e5\u5fd7\u7ba1\u7406", null, 0, null, "&#xe655;", 1));
        menuMapper.insert(new Menu(16, 4, "\u7cfb\u7edf\u516c\u544a", null, 0, null, "&#xe645;", 1));
        menuMapper.insert(new Menu(17, 4, "\u6570\u636e\u6e90\u76d1\u63a7", null, 0, null, "&#xe857;", 1));
        menuMapper.insert(new Menu(18, 5, "\u5ba2\u6237\u5730\u533a\u7edf\u8ba1", null, 0, null, "&#xe63c;", 1));
        menuMapper.insert(new Menu(19, 5, "\u516c\u53f8\u5e74\u5ea6\u6708\u4efd\u9500\u552e\u989d", null, 0, null, "&#xe62c;", 1));
        menuMapper.insert(new Menu(20, 5, "\u4e1a\u52a1\u5458\u5e74\u5ea6\u9500\u552e\u989d", null, 0, null, "&#xe62d;", 1));
        System.out.println("\u521d\u59cb\u5316\u5b8c\u6210");
    }
}
