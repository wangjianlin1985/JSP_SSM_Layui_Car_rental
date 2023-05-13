// 
// 
// 

package com.yeqifu.sys.domain;

public class User
{
    private Integer userid;
    private String loginname;
    private String identity;
    private String realname;
    private Integer sex;
    private String address;
    private String phone;
    private String pwd;
    private String position;
    private Integer type;
    private Integer available;
    
    public Integer getUserid() {
        return this.userid;
    }
    
    public void setUserid(final Integer userid) {
        this.userid = userid;
    }
    
    public String getLoginname() {
        return this.loginname;
    }
    
    public void setLoginname(final String loginname) {
        this.loginname = ((loginname == null) ? null : loginname.trim());
    }
    
    public String getIdentity() {
        return this.identity;
    }
    
    public void setIdentity(final String identity) {
        this.identity = ((identity == null) ? null : identity.trim());
    }
    
    public String getRealname() {
        return this.realname;
    }
    
    public void setRealname(final String realname) {
        this.realname = ((realname == null) ? null : realname.trim());
    }
    
    public Integer getSex() {
        return this.sex;
    }
    
    public void setSex(final Integer sex) {
        this.sex = sex;
    }
    
    public String getAddress() {
        return this.address;
    }
    
    public void setAddress(final String address) {
        this.address = ((address == null) ? null : address.trim());
    }
    
    public String getPhone() {
        return this.phone;
    }
    
    public void setPhone(final String phone) {
        this.phone = ((phone == null) ? null : phone.trim());
    }
    
    public String getPwd() {
        return this.pwd;
    }
    
    public void setPwd(final String pwd) {
        this.pwd = ((pwd == null) ? null : pwd.trim());
    }
    
    public String getPosition() {
        return this.position;
    }
    
    public void setPosition(final String position) {
        this.position = ((position == null) ? null : position.trim());
    }
    
    public Integer getType() {
        return this.type;
    }
    
    public void setType(final Integer type) {
        this.type = type;
    }
    
    public Integer getAvailable() {
        return this.available;
    }
    
    public void setAvailable(final Integer available) {
        this.available = available;
    }
    
    @Override
    public String toString() {
        return "User{userid=" + this.userid + ", loginname='" + this.loginname + '\'' + ", identity='" + this.identity + '\'' + ", realname='" + this.realname + '\'' + ", sex=" + this.sex + ", address='" + this.address + '\'' + ", phone='" + this.phone + '\'' + ", pwd='" + this.pwd + '\'' + ", position='" + this.position + '\'' + ", type=" + this.type + ", available=" + this.available + '}';
    }
}
