// 
// 
// 

package com.yeqifu.sys.mapper;

import org.apache.ibatis.annotations.Param;
import java.util.List;
import com.yeqifu.sys.domain.Role;

public interface RoleMapper
{
    int deleteByPrimaryKey(Integer p0);
    
    int insert(Role p0);
    
    int insertSelective(Role p0);
    
    Role selectByPrimaryKey(Integer p0);
    
    int updateByPrimaryKeySelective(Role p0);
    
    int updateByPrimaryKey(Role p0);
    
    List<Role> queryAllRole(Role p0);
    
    void deleteRoleMenuByRid(Integer p0);
    
    void deleteRoleUserByRid(Integer p0);
    
    void insertRoleMenu(@Param("rid") Integer p0, @Param("mid") Integer p1);
    
    void deleteRoleUserByUid(Integer p0);
    
    List<Role> queryRoleByUid(@Param("available") Integer p0, @Param("uid") Integer p1);
}
