// 
// 
// 

package com.yeqifu.bus.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;

public class Customer
{
    private String identity;
    private String custname;
    private Integer sex;
    private String address;
    private String phone;
    private String career;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createtime;
    
    public String getIdentity() {
        return this.identity;
    }
    
    public void setIdentity(final String identity) {
        this.identity = ((identity == null) ? null : identity.trim());
    }
    
    public String getCustname() {
        return this.custname;
    }
    
    public void setCustname(final String custname) {
        this.custname = ((custname == null) ? null : custname.trim());
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
    
    public String getCareer() {
        return this.career;
    }
    
    public void setCareer(final String career) {
        this.career = ((career == null) ? null : career.trim());
    }
    
    public Date getCreatetime() {
        return this.createtime;
    }
    
    public void setCreatetime(final Date createtime) {
        this.createtime = createtime;
    }
}
