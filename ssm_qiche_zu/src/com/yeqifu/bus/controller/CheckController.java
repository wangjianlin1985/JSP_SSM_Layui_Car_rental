// 
// 
// 

package com.yeqifu.bus.controller;

import com.yeqifu.sys.utils.DataGridView;
import java.util.Date;
import com.yeqifu.sys.utils.ResultObj;
import com.yeqifu.bus.vo.CheckVo;
import java.util.Map;
import com.yeqifu.bus.domain.Rent;
import com.yeqifu.bus.service.ICheckService;
import org.springframework.beans.factory.annotation.Autowired;
import com.yeqifu.bus.service.IRentService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({ "check" })
public class CheckController
{
    @Autowired
    private IRentService rentService;
    @Autowired
    private ICheckService checkService;
    
    @RequestMapping({ "checkRentExist" })
    public Rent checkRentExist(final String rentid) {
        final Rent rent = this.rentService.queryRentByRentId(rentid);
        return rent;
    }
    
    @RequestMapping({ "initCheckFormData" })
    public Map<String, Object> initCheckFormData(final String rentid) {
        return this.checkService.initCheckFormData(rentid);
    }
    
    @RequestMapping({ "saveCheck" })
    public ResultObj saveCheck(final CheckVo checkVo) {
        try {
            checkVo.setCreatetime(new Date());
            this.checkService.addCheck(checkVo);
            return ResultObj.ADD_SUCCESS;
        }
        catch (Exception e) {
            e.printStackTrace();
            return ResultObj.ADD_ERROR;
        }
    }
    
    @RequestMapping({ "loadAllCheck" })
    public DataGridView loadAllCheck(final CheckVo checkVo) {
        return this.checkService.queryAllCheck(checkVo);
    }
    
    @RequestMapping({ "deleteCheck" })
    public ResultObj deleteCheck(final CheckVo checkVo) {
        try {
            this.checkService.deleteCheck(checkVo);
            return ResultObj.DELETE_SUCCESS;
        }
        catch (Exception e) {
            e.printStackTrace();
            return ResultObj.DELETE_ERROR;
        }
    }
    
    @RequestMapping({ "deleteBatchCheck" })
    public ResultObj deleteBatchCheck(final CheckVo checkVo) {
        try {
            this.checkService.deleteBatchCheck(checkVo.getIds());
            return ResultObj.DELETE_SUCCESS;
        }
        catch (Exception e) {
            e.printStackTrace();
            return ResultObj.DELETE_ERROR;
        }
    }
    
    @RequestMapping({ "updateCheck" })
    public ResultObj updateCheck(final CheckVo checkVo) {
        try {
            this.checkService.updateCheck(checkVo);
            return ResultObj.UPDATE_SUCCESS;
        }
        catch (Exception e) {
            e.printStackTrace();
            return ResultObj.UPDATE_ERROR;
        }
    }
}
