// 
// 
// 

package com.yeqifu.stat.domain;

public class BaseEntity
{
    private String name;
    private Double value;
    
    public BaseEntity() {
    }
    
    public BaseEntity(final String name, final Double value) {
        this.name = name;
        this.value = value;
    }
    
    public String getName() {
        return this.name;
    }
    
    public void setName(final String name) {
        this.name = name;
    }
    
    public Double getValue() {
        return this.value;
    }
    
    public void setValue(final Double value) {
        this.value = value;
    }
    
    @Override
    public String toString() {
        return "BaseEntity{name='" + this.name + '\'' + ", value=" + this.value + '}';
    }
}
