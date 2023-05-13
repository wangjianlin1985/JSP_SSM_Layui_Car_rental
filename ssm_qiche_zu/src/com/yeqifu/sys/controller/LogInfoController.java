// 
// 
// 

package com.yeqifu.sys.controller;

import com.yeqifu.sys.utils.ResultObj;
import com.yeqifu.sys.utils.DataGridView;
import com.yeqifu.sys.vo.LogInfoVo;
import org.springframework.beans.factory.annotation.Autowired;
import com.yeqifu.sys.service.ILogInfoService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({ "logInfo" })
public class LogInfoController
{
    @Autowired
    private ILogInfoService logInfoService;
    
    @RequestMapping({ "loadAllLogInfo" })
    public DataGridView loadAllLogInfo(final LogInfoVo logInfoVo) {
        return this.logInfoService.queryAllLogInfo(logInfoVo);
    }
    
    @RequestMapping({ "deleteLogInfo" })
    public ResultObj deleteLogInfo(final LogInfoVo logInfoVo) {
        try {
            this.logInfoService.deleteLogInfo(logInfoVo.getId());
            return ResultObj.DELETE_SUCCESS;
        }
        catch (Exception e) {
            e.printStackTrace();
            return ResultObj.DELETE_ERROR;
        }
    }
    
    @RequestMapping({ "deleteBatchLogInfo" })
    public ResultObj deleteBatchLogInfo(final LogInfoVo logInfoVo) {
        try {
            this.logInfoService.deleteBatchLogInfo(logInfoVo.getIds());
            return ResultObj.DELETE_SUCCESS;
        }
        catch (Exception e) {
            e.printStackTrace();
            return ResultObj.DELETE_ERROR;
        }
    }
}
