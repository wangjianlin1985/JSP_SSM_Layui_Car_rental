// 
// 
// 

package com.yeqifu.sys.utils;

import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

public class TreeNode
{
    private Integer id;
    @JsonProperty("parentId")
    private Integer pid;
    private String title;
    private String icon;
    private String href;
    private Boolean spread;
    private String target;
    private List<TreeNode> children;
    private String checkArr;
    
    public TreeNode(final Integer id, final Integer pid, final String title, final String icon, final String href, final Boolean spread, final String target) {
        this.children = new ArrayList<TreeNode>();
        this.checkArr = "0";
        this.id = id;
        this.pid = pid;
        this.title = title;
        this.icon = icon;
        this.href = href;
        this.spread = spread;
        this.target = target;
    }
    
    public TreeNode(final Integer id, final Integer pid, final String title, final Boolean spread, final String checkArr) {
        this.children = new ArrayList<TreeNode>();
        this.checkArr = "0";
        this.id = id;
        this.pid = pid;
        this.title = title;
        this.spread = spread;
        this.checkArr = checkArr;
    }
    
    public Integer getId() {
        return this.id;
    }
    
    public void setId(final Integer id) {
        this.id = id;
    }
    
    public Integer getPid() {
        return this.pid;
    }
    
    public void setPid(final Integer pid) {
        this.pid = pid;
    }
    
    public String getTitle() {
        return this.title;
    }
    
    public void setTitle(final String title) {
        this.title = title;
    }
    
    public String getIcon() {
        return this.icon;
    }
    
    public void setIcon(final String icon) {
        this.icon = icon;
    }
    
    public String getHref() {
        return this.href;
    }
    
    public void setHref(final String href) {
        this.href = href;
    }
    
    public Boolean getSpread() {
        return this.spread;
    }
    
    public void setSpread(final Boolean spread) {
        this.spread = spread;
    }
    
    public String getTarget() {
        return this.target;
    }
    
    public void setTarget(final String target) {
        this.target = target;
    }
    
    public List<TreeNode> getChildren() {
        return this.children;
    }
    
    public void setChildren(final List<TreeNode> children) {
        this.children = children;
    }
    
    public String getCheckArr() {
        return this.checkArr;
    }
    
    public void setCheckArr(final String checkArr) {
        this.checkArr = checkArr;
    }
}
