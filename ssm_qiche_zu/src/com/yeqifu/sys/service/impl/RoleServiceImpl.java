// 
// 
// 

package com.yeqifu.sys.service.impl;

import java.util.Iterator;
import com.yeqifu.sys.utils.TreeNode;
import java.util.ArrayList;
import com.yeqifu.sys.constast.SysConstast;
import com.yeqifu.sys.domain.Menu;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.yeqifu.sys.utils.DataGridView;
import com.yeqifu.sys.domain.Role;
import java.util.List;
import com.yeqifu.sys.vo.RoleVo;
import com.yeqifu.sys.mapper.MenuMapper;
import org.springframework.beans.factory.annotation.Autowired;
import com.yeqifu.sys.mapper.RoleMapper;
import org.springframework.stereotype.Service;
import com.yeqifu.sys.service.IRoleService;

@Service
public class RoleServiceImpl implements IRoleService
{
    @Autowired
    private RoleMapper roleMapper;
    @Autowired
    private MenuMapper menuMapper;
    
    @Override
    public List<Role> queryAllRoleForList(final RoleVo roleVo) {
        return this.roleMapper.queryAllRole(roleVo);
    }
    
    @Override
    public List<Role> queryRoleByUserIdForList(final RoleVo roleVo, final Integer userId) {
        return this.roleMapper.queryAllRole(roleVo);
    }
    
    @Override
    public DataGridView queryAllRole(final RoleVo roleVo) {
        final Page<Object> page = (Page<Object>)PageHelper.startPage((int)roleVo.getPage(), (int)roleVo.getLimit());
        final List<Role> data = this.roleMapper.queryAllRole(roleVo);
        return new DataGridView(page.getTotal(), data);
    }
    
    @Override
    public void addRole(final RoleVo roleVo) {
        this.roleMapper.insertSelective(roleVo);
    }
    
    @Override
    public void updateRole(final RoleVo roleVo) {
        this.roleMapper.updateByPrimaryKeySelective(roleVo);
    }
    
    @Override
    public void deleteRole(final Integer roleid) {
        this.roleMapper.deleteByPrimaryKey(roleid);
        this.roleMapper.deleteRoleMenuByRid(roleid);
        this.roleMapper.deleteRoleUserByRid(roleid);
    }
    
    @Override
    public void deleteBatchRole(final Integer[] ids) {
        for (final Integer rid : ids) {
            this.deleteRole(rid);
        }
    }
    
    @Override
    public DataGridView initRoleMenuTreeJson(final Integer roleid) {
        final Menu menu = new Menu();
        menu.setAvailable(SysConstast.AVAILABLE_TRUE);
        final List<Menu> allMenu = this.menuMapper.queryAllMenu(menu);
        final List<Menu> roleMenu = this.menuMapper.queryMenuByRoleId(SysConstast.AVAILABLE_TRUE, roleid);
        final List<TreeNode> data = new ArrayList<TreeNode>();
        for (final Menu m1 : allMenu) {
            String checkArr = new StringBuilder().append(SysConstast.CODE_ZERO).toString();
            for (final Menu m2 : roleMenu) {
                if (m1.getId() == m2.getId()) {
                    checkArr = new StringBuilder().append(SysConstast.CODE_ONE).toString();
                    break;
                }
            }
            final Integer id = m1.getId();
            final Integer pid = m1.getPid();
            final String title = m1.getTitle();
            final Boolean spread = m1.getSpread() == SysConstast.SPREAD_TRUE;
            data.add(new TreeNode(id, pid, title, spread, checkArr));
        }
        return new DataGridView(data);
    }
    
    @Override
    public void saveRoleMenu(final RoleVo roleVo) {
        final Integer rid = roleVo.getRoleid();
        final Integer[] mids = roleVo.getIds();
        this.roleMapper.deleteRoleMenuByRid(rid);
        Integer[] array;
        for (int length = (array = mids).length, i = 0; i < length; ++i) {
            final Integer mid = array[i];
            this.roleMapper.insertRoleMenu(rid, mid);
        }
    }
}
