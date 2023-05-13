// 
// 
// 

package com.yeqifu.sys.vo;

import com.yeqifu.sys.domain.Role;

public class RoleVo extends Role
{
    private Integer page;
    private Integer limit;
    private Integer[] ids;
    
    public Integer[] getIds() {
        return this.ids;
    }
    
    public void setIds(final Integer[] ids) {
        this.ids = ids;
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
}
