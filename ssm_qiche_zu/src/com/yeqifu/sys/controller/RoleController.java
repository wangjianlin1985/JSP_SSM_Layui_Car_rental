// 
// 
// 

package com.yeqifu.sys.controller;

import com.yeqifu.sys.utils.ResultObj;
import com.yeqifu.sys.utils.DataGridView;
import com.yeqifu.sys.vo.RoleVo;
import org.springframework.beans.factory.annotation.Autowired;
import com.yeqifu.sys.service.IRoleService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({ "role" })
public class RoleController
{
    @Autowired
    private IRoleService roleService;
    
    @RequestMapping({ "loadAllRole" })
    public DataGridView loadAllRole(final RoleVo roleVo) {
        return this.roleService.queryAllRole(roleVo);
    }
    
    @RequestMapping({ "addRole" })
    public ResultObj addRole(final RoleVo roleVo) {
        try {
            this.roleService.addRole(roleVo);
            return ResultObj.ADD_SUCCESS;
        }
        catch (Exception e) {
            e.printStackTrace();
            return ResultObj.ADD_ERROR;
        }
    }
    
    @RequestMapping({ "updateRole" })
    public ResultObj updateRole(final RoleVo roleVo) {
        try {
            this.roleService.updateRole(roleVo);
            return ResultObj.UPDATE_SUCCESS;
        }
        catch (Exception e) {
            e.printStackTrace();
            return ResultObj.UPDATE_ERROR;
        }
    }
    
    @RequestMapping({ "deleteRole" })
    public ResultObj deleteRole(final RoleVo roleVo) {
        try {
            this.roleService.deleteRole(roleVo.getRoleid());
            return ResultObj.DELETE_SUCCESS;
        }
        catch (Exception e) {
            e.printStackTrace();
            return ResultObj.DELETE_ERROR;
        }
    }
    
    @RequestMapping({ "deleteBatchRole" })
    public ResultObj deleteBatchRole(final RoleVo roleVo) {
        try {
            this.roleService.deleteBatchRole(roleVo.getIds());
            return ResultObj.DELETE_SUCCESS;
        }
        catch (Exception e) {
            return ResultObj.DELETE_ERROR;
        }
    }
    
    @RequestMapping({ "initRoleMenuTreeJson" })
    public DataGridView initRoleMenuJson(final Integer roleid) {
        return this.roleService.initRoleMenuTreeJson(roleid);
    }
    
    @RequestMapping({ "saveRoleMenu" })
    public ResultObj saveRoleMenu(final RoleVo roleVo) {
        try {
            this.roleService.saveRoleMenu(roleVo);
            return ResultObj.DISPATCH_SUCCESS;
        }
        catch (Exception e) {
            e.printStackTrace();
            return ResultObj.DISPATCH_ERROR;
        }
    }
}
