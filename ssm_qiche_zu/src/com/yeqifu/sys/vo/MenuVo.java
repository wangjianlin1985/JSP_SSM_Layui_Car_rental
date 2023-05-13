// 
// 
// 

package com.yeqifu.sys.vo;

import com.yeqifu.sys.domain.Menu;

public class MenuVo extends Menu
{
    private Integer page;
    private Integer limit;
    
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
}
