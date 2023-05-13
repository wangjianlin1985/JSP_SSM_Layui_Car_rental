// 
// 
// 

package com.yeqifu.bus.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;
import java.util.Date;

public class Check
{
    private String checkid;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date checkdate;
    private String checkdesc;
    private String problem;
    private Double paymoney;
    private String opername;
    private String rentid;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createtime;
    
    public String getCheckid() {
        return this.checkid;
    }
    
    public void setCheckid(final String checkid) {
        this.checkid = ((checkid == null) ? null : checkid.trim());
    }
    
    public Date getCheckdate() {
        return this.checkdate;
    }
    
    public void setCheckdate(final Date checkdate) {
        this.checkdate = checkdate;
    }
    
    public String getCheckdesc() {
        return this.checkdesc;
    }
    
    public void setCheckdesc(final String checkdesc) {
        this.checkdesc = ((checkdesc == null) ? null : checkdesc.trim());
    }
    
    public String getProblem() {
        return this.problem;
    }
    
    public void setProblem(final String problem) {
        this.problem = ((problem == null) ? null : problem.trim());
    }
    
    public Double getPaymoney() {
        return this.paymoney;
    }
    
    public void setPaymoney(final Double paymoney) {
        this.paymoney = paymoney;
    }
    
    public String getOpername() {
        return this.opername;
    }
    
    public void setOpername(final String opername) {
        this.opername = ((opername == null) ? null : opername.trim());
    }
    
    public String getRentid() {
        return this.rentid;
    }
    
    public void setRentid(final String rentid) {
        this.rentid = ((rentid == null) ? null : rentid.trim());
    }
    
    public Date getCreatetime() {
        return this.createtime;
    }
    
    public void setCreatetime(final Date createtime) {
        this.createtime = createtime;
    }
}
