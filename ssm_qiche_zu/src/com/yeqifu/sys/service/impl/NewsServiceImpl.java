// 
// 
// 

package com.yeqifu.sys.service.impl;

import java.util.List;
import com.github.pagehelper.Page;
import com.yeqifu.sys.domain.News;
import com.github.pagehelper.PageHelper;
import com.yeqifu.sys.utils.DataGridView;
import com.yeqifu.sys.vo.NewsVo;
import org.springframework.beans.factory.annotation.Autowired;
import com.yeqifu.sys.mapper.NewsMapper;
import org.springframework.stereotype.Service;
import com.yeqifu.sys.service.INewsService;

@Service
public class NewsServiceImpl implements INewsService
{
    @Autowired
    private NewsMapper newsMapper;
    
    @Override
    public DataGridView queryAllNews(final NewsVo newsVo) {
        final Page<Object> page = (Page<Object>)PageHelper.startPage((int)newsVo.getPage(), (int)newsVo.getLimit());
        final List<News> data = this.newsMapper.queryAllNews(newsVo);
        return new DataGridView(page.getTotal(), data);
    }
    
    @Override
    public void addNews(final NewsVo newsVo) {
        this.newsMapper.insertSelective(newsVo);
    }
    
    @Override
    public void deleteNews(final Integer newsid) {
        this.newsMapper.deleteByPrimaryKey(newsid);
    }
    
    @Override
    public void deleteBatchNews(final Integer[] ids) {
        for (final Integer id : ids) {
            this.deleteNews(id);
        }
    }
    
    @Override
    public void updateNews(final NewsVo newsVo) {
        this.newsMapper.updateByPrimaryKeySelective(newsVo);
    }
    
    @Override
    public News queryNewsById(final Integer id) {
        return this.newsMapper.selectByPrimaryKey(id);
    }
}
