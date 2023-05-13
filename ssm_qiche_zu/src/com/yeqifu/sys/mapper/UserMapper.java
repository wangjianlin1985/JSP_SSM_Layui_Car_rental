// 
// 
// 

package com.yeqifu.sys.mapper;

import org.apache.ibatis.annotations.Param;
import java.util.List;
import com.yeqifu.sys.domain.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper
{
    int deleteByPrimaryKey(Integer p0);
    
    int insert(User p0);
    
    int insertSelective(User p0);
    
    User selectByPrimaryKey(Integer p0);
    
    int updateByPrimaryKeySelective(User p0);
    
    int updateByPrimaryKey(User p0);
    
    User login(User p0);
    
    List<User> queryAllUser(User p0);
    
    void insertUserRole(@Param("uid") Integer p0, @Param("rid") Integer p1);
}
