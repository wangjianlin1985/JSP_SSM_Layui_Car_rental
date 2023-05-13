// 
// 
// 

package com.yeqifu.sys.controller;

import com.yeqifu.sys.utils.ResultObj;
import com.yeqifu.sys.utils.DataGridView;
import com.yeqifu.sys.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import com.yeqifu.sys.service.IUserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({ "user" })
public class UserController
{
    @Autowired
    private IUserService userService;
    
    @RequestMapping({ "loadAllUser" })
    public DataGridView loadAllUser(final UserVo userVo) {
        return this.userService.queryAllUser(userVo);
    }
    
    @RequestMapping({ "addUser" })
    public ResultObj addUser(final UserVo userVo) {
        try {
            this.userService.addUser(userVo);
            return ResultObj.ADD_SUCCESS;
        }
        catch (Exception e) {
            e.printStackTrace();
            return ResultObj.ADD_ERROR;
        }
    }
    
    @RequestMapping({ "updateUser" })
    public ResultObj updateUser(final UserVo userVo) {
        try {
            this.userService.updateUser(userVo);
            return ResultObj.UPDATE_SUCCESS;
        }
        catch (Exception e) {
            e.printStackTrace();
            return ResultObj.UPDATE_ERROR;
        }
    }
    
    @RequestMapping({ "deleteUser" })
    public ResultObj deleteUser(final UserVo userVo) {
        try {
            this.userService.deleteUser(userVo.getUserid());
            return ResultObj.DELETE_SUCCESS;
        }
        catch (Exception e) {
            e.printStackTrace();
            return ResultObj.DELETE_ERROR;
        }
    }
    
    @RequestMapping({ "deleteBatchUser" })
    public ResultObj deleteBatchUser(final UserVo userVo) {
        try {
            this.userService.deleteBatchUser(userVo.getIds());
            return ResultObj.DELETE_SUCCESS;
        }
        catch (Exception e) {
            return ResultObj.DELETE_ERROR;
        }
    }
    
    @RequestMapping({ "resetUserPwd" })
    public ResultObj resetUserPwd(final UserVo userVo) {
        try {
            this.userService.resetUserPwd(userVo.getUserid());
            return ResultObj.RESET_SUCCESS;
        }
        catch (Exception e) {
            return ResultObj.RESET_ERROR;
        }
    }
    
    @RequestMapping({ "initUserRole" })
    public DataGridView initUserRole(final UserVo userVo) {
        return this.userService.queryUserRole(userVo.getUserid());
    }
    
    @RequestMapping({ "saveUserRole" })
    public ResultObj saveUserRole(final UserVo userVo) {
        try {
            this.userService.saveUserRole(userVo);
            return ResultObj.DISPATCH_SUCCESS;
        }
        catch (Exception e) {
            e.printStackTrace();
            return ResultObj.DISPATCH_ERROR;
        }
    }
}
