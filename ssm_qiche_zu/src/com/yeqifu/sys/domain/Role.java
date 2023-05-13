// 
// 
// 

package com.yeqifu.sys.domain;

public class Role
{
    private Integer roleid;
    private String rolename;
    private String roledesc;
    private Integer available;
    
    public Integer getRoleid() {
        return this.roleid;
    }
    
    public void setRoleid(final Integer roleid) {
        this.roleid = roleid;
    }
    
    public String getRolename() {
        return this.rolename;
    }
    
    public void setRolename(final String rolename) {
        this.rolename = ((rolename == null) ? null : rolename.trim());
    }
    
    public String getRoledesc() {
        return this.roledesc;
    }
    
    public void setRoledesc(final String roledesc) {
        this.roledesc = ((roledesc == null) ? null : roledesc.trim());
    }
    
    public Integer getAvailable() {
        return this.available;
    }
    
    public void setAvailable(final Integer available) {
        this.available = available;
    }
}
