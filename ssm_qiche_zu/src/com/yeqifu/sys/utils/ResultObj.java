// 
// 
// 

package com.yeqifu.sys.utils;

import com.yeqifu.sys.constast.SysConstast;

public class ResultObj
{
    private Integer code;
    private String msg;
    public static final ResultObj ADD_SUCCESS;
    public static final ResultObj ADD_ERROR;
    public static final ResultObj UPDATE_SUCCESS;
    public static final ResultObj UPDATE_ERROR;
    public static final ResultObj DELETE_SUCCESS;
    public static final ResultObj DELETE_ERROR;
    public static final ResultObj RESET_SUCCESS;
    public static final ResultObj RESET_ERROR;
    public static final ResultObj DISPATCH_SUCCESS;
    public static final ResultObj DISPATCH_ERROR;
    public static final ResultObj STATUS_TRUE;
    public static final ResultObj STATUS_FALSE;
    
    static {
        ADD_SUCCESS = new ResultObj(SysConstast.CODE_SUCCESS, "\u6dfb\u52a0\u6210\u529f");
        ADD_ERROR = new ResultObj(SysConstast.CODE_ERROR, "\u6dfb\u52a0\u5931\u8d25");
        UPDATE_SUCCESS = new ResultObj(SysConstast.CODE_SUCCESS, "\u66f4\u65b0\u6210\u529f");
        UPDATE_ERROR = new ResultObj(SysConstast.CODE_ERROR, "\u66f4\u65b0\u5931\u8d25");
        DELETE_SUCCESS = new ResultObj(SysConstast.CODE_SUCCESS, "\u5220\u9664\u6210\u529f");
        DELETE_ERROR = new ResultObj(SysConstast.CODE_ERROR, "\u5220\u9664\u5931\u8d25");
        RESET_SUCCESS = new ResultObj(SysConstast.CODE_SUCCESS, "\u91cd\u7f6e\u6210\u529f");
        RESET_ERROR = new ResultObj(SysConstast.CODE_ERROR, "\u91cd\u7f6e\u5931\u8d25");
        DISPATCH_SUCCESS = new ResultObj(SysConstast.CODE_SUCCESS, "\u5206\u914d\u6210\u529f");
        DISPATCH_ERROR = new ResultObj(SysConstast.CODE_ERROR, "\u5206\u914d\u5931\u8d25");
        STATUS_TRUE = new ResultObj(SysConstast.CODE_SUCCESS);
        STATUS_FALSE = new ResultObj(SysConstast.CODE_ERROR);
    }
    
    private ResultObj(final Integer code, final String msg) {
        this.code = code;
        this.msg = msg;
    }
    
    private ResultObj(final Integer code) {
        this.code = code;
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
}
