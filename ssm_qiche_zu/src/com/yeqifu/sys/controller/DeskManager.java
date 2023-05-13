// 
// 
// 

package com.yeqifu.sys.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;

@Controller
@RequestMapping({ "desk" })
public class DeskManager
{
    @RequestMapping({ "toDeskManager" })
    public String toDeskManager() {
        return "system/main/deskManager";
    }
}
