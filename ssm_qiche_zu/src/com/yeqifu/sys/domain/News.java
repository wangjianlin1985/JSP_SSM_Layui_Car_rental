// 
// 
// 

package com.yeqifu.sys.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;

public class News
{
    private Integer id;
    private String title;
    private String content;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createtime;
    private String opername;
    
    public Integer getId() {
        return this.id;
    }
    
    public void setId(final Integer id) {
        this.id = id;
    }
    
    public String getTitle() {
        return this.title;
    }
    
    public void setTitle(final String title) {
        this.title = ((title == null) ? null : title.trim());
    }
    
    public String getContent() {
        return this.content;
    }
    
    public void setContent(final String content) {
        this.content = ((content == null) ? null : content.trim());
    }
    
    public Date getCreatetime() {
        return this.createtime;
    }
    
    public void setCreatetime(final Date createtime) {
        this.createtime = createtime;
    }
    
    public String getOpername() {
        return this.opername;
    }
    
    public void setOpername(final String opername) {
        this.opername = ((opername == null) ? null : opername.trim());
    }
}
