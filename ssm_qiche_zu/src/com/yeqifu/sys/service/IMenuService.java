// 
// 
// 

package com.yeqifu.sys.service;

import com.yeqifu.sys.utils.DataGridView;
import com.yeqifu.sys.domain.Menu;
import java.util.List;
import com.yeqifu.sys.vo.MenuVo;

public interface IMenuService
{
    List<Menu> queryAllMenuForList(MenuVo p0);
    
    List<Menu> queryMenuByUserIdForList(MenuVo p0, Integer p1);
    
    DataGridView queryAllMenu(MenuVo p0);
    
    void addMenu(MenuVo p0);
    
    void updateMenu(MenuVo p0);
    
    Integer queryMenuByPid(Integer p0);
    
    void deleteMenu(MenuVo p0);
}
