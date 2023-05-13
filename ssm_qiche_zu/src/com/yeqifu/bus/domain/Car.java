// 
// 
// 

package com.yeqifu.bus.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;

public class Car
{
    private String carnumber;
    private String cartype;
    private String color;
    private Double price;
    private Double rentprice;
    private Double deposit;
    private Integer isrenting;
    private String description;
    private String carimg;
    @JsonFormat(pattern = "yyyy-MM-dd HH-mm-ss", timezone = "GTM+8")
    private Date createtime;
    
    public String getCarnumber() {
        return this.carnumber;
    }
    
    public void setCarnumber(final String carnumber) {
        this.carnumber = ((carnumber == null) ? null : carnumber.trim());
    }
    
    public String getCartype() {
        return this.cartype;
    }
    
    public void setCartype(final String cartype) {
        this.cartype = ((cartype == null) ? null : cartype.trim());
    }
    
    public String getColor() {
        return this.color;
    }
    
    public void setColor(final String color) {
        this.color = ((color == null) ? null : color.trim());
    }
    
    public Double getPrice() {
        return this.price;
    }
    
    public void setPrice(final Double price) {
        this.price = price;
    }
    
    public Double getRentprice() {
        return this.rentprice;
    }
    
    public void setRentprice(final Double rentprice) {
        this.rentprice = rentprice;
    }
    
    public Double getDeposit() {
        return this.deposit;
    }
    
    public void setDeposit(final Double deposit) {
        this.deposit = deposit;
    }
    
    public Integer getIsrenting() {
        return this.isrenting;
    }
    
    public void setIsrenting(final Integer isrenting) {
        this.isrenting = isrenting;
    }
    
    public String getDescription() {
        return this.description;
    }
    
    public void setDescription(final String description) {
        this.description = ((description == null) ? null : description.trim());
    }
    
    public String getCarimg() {
        return this.carimg;
    }
    
    public void setCarimg(final String carimg) {
        this.carimg = ((carimg == null) ? null : carimg.trim());
    }
    
    public Date getCreatetime() {
        return this.createtime;
    }
    
    public void setCreatetime(final Date createtime) {
        this.createtime = createtime;
    }
}
