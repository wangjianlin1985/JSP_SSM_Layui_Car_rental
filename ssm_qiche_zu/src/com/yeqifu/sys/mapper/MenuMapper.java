// 
// 
// 

package com.yeqifu.sys.mapper;

import org.apache.ibatis.annotations.Param;
import java.util.List;
import com.yeqifu.sys.domain.Menu;

public interface MenuMapper
{
    int deleteByPrimaryKey(Integer p0);
    
    int insert(Menu p0);
    
    int insertSelective(Menu p0);
    
    Menu selectByPrimaryKey(Integer p0);
    
    int updateByPrimaryKeySelective(Menu p0);
    
    int updateByPrimaryKey(Menu p0);
    
    List<Menu> queryAllMenu(Menu p0);
    
    Integer queryMenuByPid(@Param("pid") Integer p0);
    
    void deleteRoleMenuByMid(@Param("mid") Integer p0);
    
    List<Menu> queryMenuByRoleId(@Param("available") Integer p0, @Param("rid") Integer p1);
    
    List<Menu> queryMenuByUid(@Param("available") Integer p0, @Param("uid") Integer p1);
}
