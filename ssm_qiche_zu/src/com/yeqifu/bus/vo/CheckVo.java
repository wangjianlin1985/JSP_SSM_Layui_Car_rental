// 
// 
// 

package com.yeqifu.bus.vo;

import org.springframework.format.annotation.DateTimeFormat;
import java.util.Date;
import com.yeqifu.bus.domain.Check;

public class CheckVo extends Check
{
    private Integer page;
    private Integer limit;
    private String[] ids;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date startTime;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date endTime;
    
    public Date getStartTime() {
        return this.startTime;
    }
    
    public void setStartTime(final Date startTime) {
        this.startTime = startTime;
    }
    
    public Date getEndTime() {
        return this.endTime;
    }
    
    public void setEndTime(final Date endTime) {
        this.endTime = endTime;
    }
    
    public Integer getPage() {
        return this.page;
    }
    
    public void setPage(final Integer page) {
        this.page = page;
    }
    
    public Integer getLimit() {
        return this.limit;
    }
    
    public void setLimit(final Integer limit) {
        this.limit = limit;
    }
    
    public String[] getIds() {
        return this.ids;
    }
    
    public void setIds(final String[] ids) {
        this.ids = ids;
    }
}
