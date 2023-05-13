// 
// 
// 

package com.yeqifu.sys.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.yeqifu.sys.utils.DataGridView;
import com.yeqifu.sys.domain.Menu;
import java.util.List;
import com.yeqifu.sys.vo.MenuVo;
import org.springframework.beans.factory.annotation.Autowired;
import com.yeqifu.sys.mapper.MenuMapper;
import org.springframework.stereotype.Service;
import com.yeqifu.sys.service.IMenuService;

@Service
public class MenuServiceImpl implements IMenuService
{
    @Autowired
    private MenuMapper menuMapper;
    
    @Override
    public List<Menu> queryAllMenuForList(final MenuVo menuVo) {
        return this.menuMapper.queryAllMenu(menuVo);
    }
    
    @Override
    public List<Menu> queryMenuByUserIdForList(final MenuVo menuVo, final Integer userId) {
        return this.menuMapper.queryMenuByUid(menuVo.getAvailable(), userId);
    }
    
    @Override
    public DataGridView queryAllMenu(final MenuVo menuVo) {
        final Page<Object> page = (Page<Object>)PageHelper.startPage((int)menuVo.getPage(), (int)menuVo.getLimit());
        final List<Menu> data = this.menuMapper.queryAllMenu(menuVo);
        return new DataGridView(page.getTotal(), data);
    }
    
    @Override
    public void addMenu(final MenuVo menuVo) {
        this.menuMapper.insertSelective(menuVo);
    }
    
    @Override
    public void updateMenu(final MenuVo menuVo) {
        this.menuMapper.updateByPrimaryKeySelective(menuVo);
    }
    
    @Override
    public Integer queryMenuByPid(final Integer pid) {
        return this.menuMapper.queryMenuByPid(pid);
    }
    
    @Override
    public void deleteMenu(final MenuVo menuVo) {
        this.menuMapper.deleteByPrimaryKey(menuVo.getId());
        this.menuMapper.deleteRoleMenuByMid(menuVo.getId());
    }
}
