// 
// 
// 

package com.yeqifu.sys.service.impl;

import java.util.List;
import com.github.pagehelper.Page;
import com.yeqifu.sys.domain.LogInfo;
import com.github.pagehelper.PageHelper;
import com.yeqifu.sys.utils.DataGridView;
import com.yeqifu.sys.vo.LogInfoVo;
import org.springframework.beans.factory.annotation.Autowired;
import com.yeqifu.sys.mapper.LogInfoMapper;
import org.springframework.stereotype.Service;
import com.yeqifu.sys.service.ILogInfoService;

@Service
public class LogInfoServiceImpl implements ILogInfoService
{
    @Autowired
    private LogInfoMapper logInfoMapper;
    
    @Override
    public DataGridView queryAllLogInfo(final LogInfoVo logInfoVo) {
        final Page<Object> page = (Page<Object>)PageHelper.startPage((int)logInfoVo.getPage(), (int)logInfoVo.getLimit());
        final List<LogInfo> data = this.logInfoMapper.queryAllLogInfo(logInfoVo);
        return new DataGridView(page.getTotal(), data);
    }
    
    @Override
    public void addLogInfo(final LogInfoVo logInfoVo) {
        this.logInfoMapper.insertSelective(logInfoVo);
    }
    
    @Override
    public void deleteLogInfo(final Integer logInfoid) {
        this.logInfoMapper.deleteByPrimaryKey(logInfoid);
    }
    
    @Override
    public void deleteBatchLogInfo(final Integer[] ids) {
        for (final Integer id : ids) {
            this.deleteLogInfo(id);
        }
    }
}
