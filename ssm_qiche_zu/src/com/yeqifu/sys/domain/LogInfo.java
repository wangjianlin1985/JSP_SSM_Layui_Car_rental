// 
// 
// 

package com.yeqifu.sys.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;

public class LogInfo
{
    private Integer id;
    private String loginname;
    private String loginip;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date logintime;
    
    public Integer getId() {
        return this.id;
    }
    
    public void setId(final Integer id) {
        this.id = id;
    }
    
    public String getLoginname() {
        return this.loginname;
    }
    
    public void setLoginname(final String loginname) {
        this.loginname = ((loginname == null) ? null : loginname.trim());
    }
    
    public String getLoginip() {
        return this.loginip;
    }
    
    public void setLoginip(final String loginip) {
        this.loginip = ((loginip == null) ? null : loginip.trim());
    }
    
    public Date getLogintime() {
        return this.logintime;
    }
    
    public void setLogintime(final Date logintime) {
        this.logintime = logintime;
    }
}
