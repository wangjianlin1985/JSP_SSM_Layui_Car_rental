// 
// 
// 

package com.yeqifu.sys.utils;

public class DataGridView
{
    private Integer code;
    private String msg;
    private Long count;
    private Object data;
    
    public DataGridView() {
        this.code = 0;
        this.msg = "";
    }
    
    public DataGridView(final Object data) {
        this.code = 0;
        this.msg = "";
        this.data = data;
    }
    
    public DataGridView(final Long count, final Object data) {
        this.code = 0;
        this.msg = "";
        this.count = count;
        this.data = data;
    }
    
    public Integer getCode() {
        return this.code;
    }
    
    public void setCode(final Integer code) {
        this.code = code;
    }
    
    public String getMsg() {
        return this.msg;
    }
    
    public void setMsg(final String msg) {
        this.msg = msg;
    }
    
    public Long getCount() {
        return this.count;
    }
    
    public void setCount(final Long count) {
        this.count = count;
    }
    
    public Object getData() {
        return this.data;
    }
    
    public void setData(final Object data) {
        this.data = data;
    }
}
