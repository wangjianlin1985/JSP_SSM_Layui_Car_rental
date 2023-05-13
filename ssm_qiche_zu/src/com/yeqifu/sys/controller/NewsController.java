// 
// 
// 

package com.yeqifu.sys.controller;

import com.yeqifu.sys.domain.News;
import com.yeqifu.sys.utils.WebUtils;
import com.yeqifu.sys.domain.User;
import java.util.Date;
import com.yeqifu.sys.utils.ResultObj;
import com.yeqifu.sys.utils.DataGridView;
import com.yeqifu.sys.vo.NewsVo;
import org.springframework.beans.factory.annotation.Autowired;
import com.yeqifu.sys.service.INewsService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({ "news" })
public class NewsController
{
    @Autowired
    private INewsService newsService;
    
    @RequestMapping({ "loadAllNews" })
    public DataGridView loadAllNews(final NewsVo newsVo) {
        return this.newsService.queryAllNews(newsVo);
    }
    
    @RequestMapping({ "addNews" })
    public ResultObj addNews(final NewsVo newsVo) {
        try {
            newsVo.setCreatetime(new Date());
            final User user = (User)WebUtils.getHttpSession().getAttribute("user");
            newsVo.setOpername(user.getRealname());
            this.newsService.addNews(newsVo);
            return ResultObj.ADD_SUCCESS;
        }
        catch (Exception e) {
            e.printStackTrace();
            return ResultObj.ADD_ERROR;
        }
    }
    
    @RequestMapping({ "deleteNews" })
    public ResultObj deleteNews(final NewsVo newsVo) {
        try {
            this.newsService.deleteNews(newsVo.getId());
            return ResultObj.DELETE_SUCCESS;
        }
        catch (Exception e) {
            e.printStackTrace();
            return ResultObj.DELETE_ERROR;
        }
    }
    
    @RequestMapping({ "deleteBatchNews" })
    public ResultObj deleteBatchNews(final NewsVo newsVo) {
        try {
            this.newsService.deleteBatchNews(newsVo.getIds());
            return ResultObj.DELETE_SUCCESS;
        }
        catch (Exception e) {
            e.printStackTrace();
            return ResultObj.DELETE_ERROR;
        }
    }
    
    @RequestMapping({ "updateNews" })
    public ResultObj updateNews(final NewsVo newsVo) {
        try {
            this.newsService.updateNews(newsVo);
            return ResultObj.UPDATE_SUCCESS;
        }
        catch (Exception e) {
            e.printStackTrace();
            return ResultObj.UPDATE_ERROR;
        }
    }
    
    @RequestMapping({ "loadNewsById" })
    public News loadNewsById(final Integer id) {
        return this.newsService.queryNewsById(id);
    }
}
