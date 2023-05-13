// 
// 
// 

package com.yeqifu.bus.vo;

import com.yeqifu.bus.domain.Car;

public class CarVo extends Car
{
    private Integer page;
    private Integer limit;
    private String[] ids;
    
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
