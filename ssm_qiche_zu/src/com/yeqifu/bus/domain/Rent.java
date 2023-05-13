// 
// 
// 

package com.yeqifu.bus.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;
import java.util.Date;

public class Rent
{
    private String rentid;
    private Double price;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GTM+8")
    private Date begindate;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH-mm-ss", timezone = "GTM+8")
    private Date returndate;
    private Integer rentflag;
    private String identity;
    private String carnumber;
    private String opername;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GTM+8")
    private Date createtime;
    
    public String getRentid() {
        return this.rentid;
    }
    
    public void setRentid(final String rentid) {
        this.rentid = ((rentid == null) ? null : rentid.trim());
    }
    
    public Double getPrice() {
        return this.price;
    }
    
    public void setPrice(final Double price) {
        this.price = price;
    }
    
    public Date getBegindate() {
        return this.begindate;
    }
    
    public void setBegindate(final Date begindate) {
        this.begindate = begindate;
    }
    
    public Date getReturndate() {
        return this.returndate;
    }
    
    public void setReturndate(final Date returndate) {
        this.returndate = returndate;
    }
    
    public Integer getRentflag() {
        return this.rentflag;
    }
    
    public void setRentflag(final Integer rentflag) {
        this.rentflag = rentflag;
    }
    
    public String getIdentity() {
        return this.identity;
    }
    
    public void setIdentity(final String identity) {
        this.identity = ((identity == null) ? null : identity.trim());
    }
    
    public String getCarnumber() {
        return this.carnumber;
    }
    
    public void setCarnumber(final String carnumber) {
        this.carnumber = ((carnumber == null) ? null : carnumber.trim());
    }
    
    public String getOpername() {
        return this.opername;
    }
    
    public void setOpername(final String opername) {
        this.opername = ((opername == null) ? null : opername.trim());
    }
    
    public Date getCreatetime() {
        return this.createtime;
    }
    
    public void setCreatetime(final Date createtime) {
        this.createtime = createtime;
    }
}
