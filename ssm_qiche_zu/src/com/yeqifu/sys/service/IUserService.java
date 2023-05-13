// 
// 
// 

package com.yeqifu.sys.service;

import com.yeqifu.sys.utils.DataGridView;
import com.yeqifu.sys.domain.User;
import com.yeqifu.sys.vo.UserVo;

public interface IUserService
{
    User login(UserVo p0);
    
    DataGridView queryAllUser(UserVo p0);
    
    void addUser(UserVo p0);
    
    void updateUser(UserVo p0);
    
    void deleteUser(Integer p0);
    
    void deleteBatchUser(Integer[] p0);
    
    void resetUserPwd(Integer p0);
    
    DataGridView queryUserRole(Integer p0);
    
    void saveUserRole(UserVo p0);
}
