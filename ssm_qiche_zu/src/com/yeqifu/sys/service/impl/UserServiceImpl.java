// 
// 
// 

package com.yeqifu.sys.service.impl;

import java.util.Iterator;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import com.yeqifu.sys.domain.Role;
import com.yeqifu.sys.constast.SysConstast;
import java.util.List;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.yeqifu.sys.utils.DataGridView;
import org.springframework.util.DigestUtils;
import com.yeqifu.sys.domain.User;
import com.yeqifu.sys.vo.UserVo;
import com.yeqifu.sys.mapper.RoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import com.yeqifu.sys.mapper.UserMapper;
import org.springframework.stereotype.Service;
import com.yeqifu.sys.service.IUserService;

@Service
public class UserServiceImpl implements IUserService
{
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private RoleMapper roleMapper;
    
    @Override
    public User login(final UserVo userVo) {
        final String pwd = DigestUtils.md5DigestAsHex(userVo.getPwd().getBytes());
        System.out.println(pwd);
        userVo.setPwd(pwd);
        return this.userMapper.login(userVo);
    }
    
    @Override
    public DataGridView queryAllUser(final UserVo userVo) {
        final Page<Object> page = (Page<Object>)PageHelper.startPage((int)userVo.getPage(), (int)userVo.getLimit());
        final List<User> data = this.userMapper.queryAllUser(userVo);
        return new DataGridView(page.getTotal(), data);
    }
    
    @Override
    public void addUser(final UserVo userVo) {
        userVo.setPwd(DigestUtils.md5DigestAsHex("123456".getBytes()));
        userVo.setType(SysConstast.USER_TYPE_NORMAL);
        this.userMapper.insertSelective(userVo);
    }
    
    @Override
    public void updateUser(final UserVo userVo) {
        this.userMapper.updateByPrimaryKeySelective(userVo);
    }
    
    @Override
    public void deleteUser(final Integer userid) {
        this.userMapper.deleteByPrimaryKey(userid);
        this.roleMapper.deleteRoleUserByUid(userid);
    }
    
    @Override
    public void deleteBatchUser(final Integer[] ids) {
        for (final Integer uid : ids) {
            this.deleteUser(uid);
        }
    }
    
    @Override
    public void resetUserPwd(final Integer userid) {
        final User user = new User();
        user.setUserid(userid);
        user.setPwd(DigestUtils.md5DigestAsHex("123456".getBytes()));
        this.userMapper.updateByPrimaryKeySelective(user);
    }
    
    @Override
    public DataGridView queryUserRole(final Integer userid) {
        final Role role = new Role();
        role.setAvailable(SysConstast.AVAILABLE_TRUE);
        final List<Role> allRole = this.roleMapper.queryAllRole(role);
        final List<Role> userRole = this.roleMapper.queryRoleByUid(SysConstast.AVAILABLE_TRUE, userid);
        final List<Map<String, Object>> data = new ArrayList<Map<String, Object>>();
        for (final Role r1 : allRole) {
            Boolean LAY_CHECKED = false;
            for (final Role r2 : userRole) {
                if (r1.getRoleid() == r2.getRoleid()) {
                    LAY_CHECKED = true;
                }
            }
            final Map<String, Object> map = new HashMap<String, Object>();
            map.put("roleid", r1.getRoleid());
            map.put("rolename", r1.getRolename());
            map.put("roledesc", r1.getRoledesc());
            map.put("LAY_CHECKED", LAY_CHECKED);
            data.add(map);
        }
        return new DataGridView(data);
    }
    
    @Override
    public void saveUserRole(final UserVo userVo) {
        final Integer userid = userVo.getUserid();
        final Integer[] roleIds = userVo.getIds();
        this.roleMapper.deleteRoleUserByUid(userid);
        if (roleIds != null && roleIds.length > 0) {
            Integer[] array;
            for (int length = (array = roleIds).length, i = 0; i < length; ++i) {
                final Integer rid = array[i];
                this.userMapper.insertUserRole(userid, rid);
            }
        }
    }
}
