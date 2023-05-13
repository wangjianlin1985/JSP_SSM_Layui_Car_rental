// 
// 
// 

package com.yeqifu.sys.service;

import com.yeqifu.sys.utils.DataGridView;
import com.yeqifu.sys.domain.Role;
import java.util.List;
import com.yeqifu.sys.vo.RoleVo;

public interface IRoleService
{
    List<Role> queryAllRoleForList(RoleVo p0);
    
    List<Role> queryRoleByUserIdForList(RoleVo p0, Integer p1);
    
    DataGridView queryAllRole(RoleVo p0);
    
    void addRole(RoleVo p0);
    
    void updateRole(RoleVo p0);
    
    void deleteRole(Integer p0);
    
    void deleteBatchRole(Integer[] p0);
    
    DataGridView initRoleMenuTreeJson(Integer p0);
    
    void saveRoleMenu(RoleVo p0);
}
