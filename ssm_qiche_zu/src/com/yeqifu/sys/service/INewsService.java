// 
// 
// 

package com.yeqifu.sys.service;

import com.yeqifu.sys.domain.News;
import com.yeqifu.sys.utils.DataGridView;
import com.yeqifu.sys.vo.NewsVo;

public interface INewsService
{
    DataGridView queryAllNews(NewsVo p0);
    
    void addNews(NewsVo p0);
    
    void deleteNews(Integer p0);
    
    void deleteBatchNews(Integer[] p0);
    
    void updateNews(NewsVo p0);
    
    News queryNewsById(Integer p0);
}
