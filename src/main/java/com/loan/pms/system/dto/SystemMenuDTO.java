package com.loan.pms.system.dto;

import java.util.List;

public class SystemMenuDTO {

	/*菜单代码*/
	private String menuCode;
	/*菜单名称*/
	private String menuName;
	/*父级菜单代码*/
	private String parentCode;
	/*菜单动作*/
	private String menuAction;
	/*子菜单*/
	private List<SystemMenuDTO> childMenu;
	
	public String getMenuCode() {
		return menuCode;
	}
	public void setMenuCode(String menuCode) {
		this.menuCode = menuCode;
	}
	public String getMenuName() {
		return menuName;
	}
	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}
	public String getParentCode() {
		return parentCode;
	}
	public void setParentCode(String parentCode) {
		this.parentCode = parentCode;
	}
	public String getMenuAction() {
		return menuAction;
	}
	public void setMenuAction(String menuAction) {
		this.menuAction = menuAction;
	}
	public List<SystemMenuDTO> getChildMenu() {
		return childMenu;
	}
	public void setChildMenu(List<SystemMenuDTO> childMenu) {
		this.childMenu = childMenu;
	}
	
}
