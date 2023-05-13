// 
// 
// 

package com.yeqifu.sys.domain;

public class Menu
{
    private Integer id;
    private Integer pid;
    private String title;
    private String href;
    private Integer spread;
    private String target;
    private String icon;
    private Integer available;
    
    public Menu() {
    }
    
    public Menu(final Integer id, final Integer pid, final String title, final String href, final Integer spread, final String target, final String icon, final Integer available) {
        this.id = id;
        this.pid = pid;
        this.title = title;
        this.href = href;
        this.spread = spread;
        this.target = target;
        this.icon = icon;
        this.available = available;
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
        this.title = ((title == null) ? null : title.trim());
    }
    
    public String getHref() {
        return this.href;
    }
    
    public void setHref(final String href) {
        this.href = ((href == null) ? null : href.trim());
    }
    
    public Integer getSpread() {
        return this.spread;
    }
    
    public void setSpread(final Integer spread) {
        this.spread = spread;
    }
    
    public String getTarget() {
        return this.target;
    }
    
    public void setTarget(final String target) {
        this.target = ((target == null) ? null : target.trim());
    }
    
    public String getIcon() {
        return this.icon;
    }
    
    public void setIcon(final String icon) {
        this.icon = ((icon == null) ? null : icon.trim());
    }
    
    public Integer getAvailable() {
        return this.available;
    }
    
    public void setAvailable(final Integer available) {
        this.available = available;
    }
}
