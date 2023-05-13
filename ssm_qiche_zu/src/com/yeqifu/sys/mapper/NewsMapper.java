// 
// 
// 

package com.yeqifu.sys.mapper;

import java.util.List;
import com.yeqifu.sys.domain.News;

public interface NewsMapper
{
    int deleteByPrimaryKey(Integer p0);
    
    int insert(News p0);
    
    int insertSelective(News p0);
    
    News selectByPrimaryKey(Integer p0);
    
    int updateByPrimaryKeySelective(News p0);
    
    int updateByPrimaryKey(News p0);
    
    List<News> queryAllNews(News p0);
}
