package cn.jbit.vote.action.admin;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.omg.PortableServer.LIFESPAN_POLICY_ID;

/**
 * 显示用户菜单
 * TODO
 * @date：May 30, 2016 11:17:01 AM
 * @author mxc
 */
@ParentPackage("admin")
@Namespace("/admin")
public class ShowUserMenuTreeAction implements Serializable {

	//用户菜单树
	protected List<MenuOption> userMenuTree = null;
	/**
	 * 业务实现
	 * @date：May 30, 2016
	 * @author：mxc
	 * @return
	 */
	@Action(value="showUserMenuTree",results={@Result(type="json", name="success",
			params={"root","userMenuTree"})})
	public String execute() {
		
		//创建跟节点列表
		userMenuTree = new ArrayList<MenuOption>();
		
		//创建根节点
		MenuOption root = new MenuOption();
		root.setId(1);
		root.setText("系统菜单");
		userMenuTree.add(root);
		
		//创建一级节点的子项列表
		List<MenuOption> list1 =new ArrayList<MenuOption>();
		root.setChildren(list1);
		
		//节点目录 :常用
		MenuOption commonMenuOption = new MenuOption();
		commonMenuOption.setId(2);
		commonMenuOption.setText("常用");
		
		//设置子节点
		commonMenuOption.setChildren(getCommonChildren());
		
		
		//加入到根节点下：
		list1.add(commonMenuOption);
		
		//节点目录 ：系统管理
		MenuOption sysMenuOption = new MenuOption();
		sysMenuOption.setId(4);
		sysMenuOption.setText("系统管理");
		
		//设置子节点列表
		sysMenuOption.setChildren(getSysChildren());
		
		//加入到根节点下：
		list1.add(sysMenuOption);
		
		//节点目录：投票管理
		MenuOption voteMenuOption = new MenuOption();
		voteMenuOption.setId(3);
		voteMenuOption.setText("投票管理");
		//设置子节点列表
		voteMenuOption.setChildren(getvoteChildren());
		
		//加入到根节点下：
		list1.add(voteMenuOption);
		
		//节点：注销
		MenuOption cancelMenuOption = new MenuOption();
		cancelMenuOption.setId(5);
		cancelMenuOption.setText("注销");
		
		//注销节点 附加属性
		Map<String, Object> canelMap = new HashMap<String, Object>();
		canelMap.put("url", "/html/admin/to_logout.jsp");
		cancelMenuOption.setAttributes(canelMap);
		
		//加入到根节点下：
		list1.add(cancelMenuOption);
		
		return "success";
	}
	/**
	 * 创建系统管理节点的子节点
	 * @date：May 31, 2016
	 * @author：mxc
	 * @return
	 */
	public List<MenuOption> getSysChildren() {
		List<MenuOption> sysChildrens =new ArrayList<MenuOption>();
		
		//用户
		MenuOption userMenuOption= new MenuOption();
		userMenuOption.setId(41);
		userMenuOption.setText("用户");
		//扩展属性
		Map<String, Object> uattributes = new HashMap<String, Object>();
		uattributes.put("url", "#");
		userMenuOption.setAttributes(uattributes);
		
		//用户组
		MenuOption userGropMenuOption= new MenuOption();
		userGropMenuOption.setId(42);
		userGropMenuOption.setText("用户组");
		//扩展属性
		Map<String, Object> ugattributes = new HashMap<String, Object>();
		ugattributes.put("url", "#");
		userGropMenuOption.setAttributes(ugattributes);
		
		//加入到列表中
		sysChildrens.add(userMenuOption);
		sysChildrens.add(userGropMenuOption);
		
		//返回函数值
		return sysChildrens;
	}
	/**
	 * 创建投票节点的子节点列表
	 * @date：May 31, 2016
	 * @author：mxc
	 * @return
	 */
	public List<MenuOption> getvoteChildren() {
		List<MenuOption> voteChildrens = new ArrayList<MenuOption>();
		
		//投票列表
		MenuOption queryVoteMenuOption = new MenuOption();
		queryVoteMenuOption.setId(31);
		queryVoteMenuOption.setText("投票列表");
		//扩展属性
				Map<String, Object> qlsattribute = new HashMap<String, Object>();
				qlsattribute.put("url", "/html/admin/to_query_vote.jsp");
				queryVoteMenuOption.setAttributes(qlsattribute);
		//加入到 列表中
	    voteChildrens.add(queryVoteMenuOption);
	    
		//报表
	    MenuOption reportMenuOption = new MenuOption();
	    reportMenuOption.setId(32);
	    reportMenuOption.setText("报表");
		//扩展属性
				Map<String, Object> resattribute = new HashMap<String, Object>();
				resattribute.put("url", "#");
				reportMenuOption.setAttributes(resattribute);
		//加入到 列表中
	    voteChildrens.add(reportMenuOption);
		return voteChildrens;
	}
	/**
	 * 创建常用 节点下 子节点列表 并返回
	 * @date：May 30, 2016
	 * @author：mxc
	 * @return
	 */
	private List<MenuOption> getCommonChildren() {
		List<MenuOption> commons = new ArrayList<MenuOption>();
		
		//主页
		MenuOption index= new MenuOption();
		index.setId(21);
		index.setText("主页");
		//扩展属性
		Map<String, Object> iattribute = new HashMap<String, Object>();
		iattribute.put("url", "/html/admin/welcome.jsp");
		index.setAttributes(iattribute);
		//添加到列表中
		commons.add(index);
		
		//用户信息
		MenuOption userInfoMenuOption = new MenuOption();
		userInfoMenuOption.setId(22);
		userInfoMenuOption.setText("用户信息");
		//扩展属性
		Map<String, Object> uattribute = new HashMap<String, Object>();
		uattribute.put("utl", "#");
		userInfoMenuOption.setAttributes(uattribute);
		//添加到列表中
		commons.add(userInfoMenuOption);
		
		//修改密码
		MenuOption updatepwdMenuOption = new MenuOption();
		updatepwdMenuOption.setId(23);
		updatepwdMenuOption.setText("修改密码");
		//扩展属性
		Map<String, Object> upattribute = new HashMap<String, Object>();
		upattribute.put("utl", "#");
		userInfoMenuOption.setAttributes(upattribute);
		//添加到列表中
		commons.add(updatepwdMenuOption);
		
		
		return commons;
	}
	/**
	 * @return the userMenuTree
	 */
	public List<MenuOption> getUserMenuTree() {
		return userMenuTree;
	}
	/**
	 * @param userMenuTree the userMenuTree to set
	 */
	public void setUserMenuTree(List<MenuOption> userMenuTree) {
		this.userMenuTree = userMenuTree;
	}
	
	
}
