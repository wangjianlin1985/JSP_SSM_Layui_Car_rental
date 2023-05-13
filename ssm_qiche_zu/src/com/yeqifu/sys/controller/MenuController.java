// 
// 
// 

package com.yeqifu.sys.controller;

import com.yeqifu.sys.utils.ResultObj;
import com.yeqifu.sys.utils.DataGridView;
import java.util.Iterator;
import com.yeqifu.sys.utils.TreeNodeBuilder;
import com.yeqifu.sys.domain.Menu;
import java.util.ArrayList;
import com.yeqifu.sys.constast.SysConstast;
import com.yeqifu.sys.utils.WebUtils;
import com.yeqifu.sys.domain.User;
import com.yeqifu.sys.utils.TreeNode;
import java.util.List;
import com.yeqifu.sys.vo.MenuVo;
import org.springframework.beans.factory.annotation.Autowired;
import com.yeqifu.sys.service.IMenuService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({ "menu" })
public class MenuController
{
    @Autowired
    private IMenuService menuService;
    
    @RequestMapping({ "loadIndexleftMenuJson" })
    public List<TreeNode> loadIndexLeftMenuJson(final MenuVo menuVo) {
        final User user = (User)WebUtils.getHttpSession().getAttribute("user");
        List<Menu> list = null;
        menuVo.setAvailable(SysConstast.AVAILABLE_TRUE);
        if (user.getType() == SysConstast.USER_TYPE_SUPER) {
            list = this.menuService.queryAllMenuForList(menuVo);
        }
        else {
            list = this.menuService.queryMenuByUserIdForList(menuVo, user.getUserid());
        }
        final List<TreeNode> nodes = new ArrayList<TreeNode>();
        for (final Menu menu : list) {
            final Integer id = menu.getId();
            final Integer pid = menu.getPid();
            final String title = menu.getTitle();
            final String icon = menu.getIcon();
            final String href = menu.getHref();
            final Boolean spread = menu.getSpread() == SysConstast.SPREAD_TRUE;
            final String target = menu.getTarget();
            nodes.add(new TreeNode(id, pid, title, icon, href, spread, target));
        }
        return TreeNodeBuilder.builder(nodes, 1);
    }
    
    @RequestMapping({ "loadMenuManagerLeftTreeJson" })
    public DataGridView loadMenuManagerLeftTreeJson(final MenuVo menuVo) {
        menuVo.setAvailable(SysConstast.AVAILABLE_TRUE);
        final List<Menu> list = this.menuService.queryAllMenuForList(menuVo);
        final List<TreeNode> nodes = new ArrayList<TreeNode>();
        for (final Menu menu : list) {
            final Integer id = menu.getId();
            final Integer pid = menu.getPid();
            final String title = menu.getTitle();
            final String icon = menu.getIcon();
            final String href = menu.getHref();
            final Boolean spread = menu.getSpread() == SysConstast.SPREAD_TRUE;
            final String target = menu.getTarget();
            nodes.add(new TreeNode(id, pid, title, icon, href, spread, target));
        }
        return new DataGridView(nodes);
    }
    
    @RequestMapping({ "loadAllMenu" })
    public DataGridView loadAllMenu(final MenuVo menuVo) {
        return this.menuService.queryAllMenu(menuVo);
    }
    
    @RequestMapping({ "addMenu" })
    public ResultObj addMenu(final MenuVo menuVo) {
        try {
            System.out.println(menuVo);
            this.menuService.addMenu(menuVo);
            return ResultObj.ADD_SUCCESS;
        }
        catch (Exception e) {
            e.printStackTrace();
            return ResultObj.ADD_ERROR;
        }
    }
    
    @RequestMapping({ "updateMenu" })
    public ResultObj updateMenu(final MenuVo menuVo) {
        try {
            this.menuService.updateMenu(menuVo);
            return ResultObj.UPDATE_SUCCESS;
        }
        catch (Exception e) {
            e.printStackTrace();
            return ResultObj.UPDATE_ERROR;
        }
    }
    
    @RequestMapping({ "checkMenuHasChildren" })
    public ResultObj checkMenuHasChildren(final MenuVo menuVo) {
        final Integer count = this.menuService.queryMenuByPid(menuVo.getId());
        System.out.println(count);
        if (count > 0) {
            return ResultObj.STATUS_TRUE;
        }
        return ResultObj.STATUS_FALSE;
    }
    
    @RequestMapping({ "deleteMenu" })
    public ResultObj deleteMenu(final MenuVo menuVo) {
        try {
            this.menuService.deleteMenu(menuVo);
            return ResultObj.DELETE_SUCCESS;
        }
        catch (Exception e) {
            e.printStackTrace();
            return ResultObj.DELETE_ERROR;
        }
    }
}
