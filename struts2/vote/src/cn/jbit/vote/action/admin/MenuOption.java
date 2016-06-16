package cn.jbit.vote.action.admin;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * 菜单项节点
 * TODO
 * @date：May 30, 2016 11:26:35 AM
 * @author mxc
 */
public class MenuOption implements Serializable {
	
	//节点编号
	private Integer  id  = null;
	
	//标题
	private String  text =null;
	
	//附加属性
	private Map<String, Object> attributes = null;
	
	//子节点列表
	private List<MenuOption> children = null;

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the text
	 */
	public String getText() {
		return text;
	}

	/**
	 * @param text the text to set
	 */
	public void setText(String text) {
		this.text = text;
	}

	/**
	 * @return the attributes
	 */
	public Map<String, Object> getAttributes() {
		return attributes;
	}

	/**
	 * @param attributes the attributes to set
	 */
	public void setAttributes(Map<String, Object> attributes) {
		this.attributes = attributes;
	}

	/**
	 * @return the children
	 */
	public List<MenuOption> getChildren() {
		return children;
	}

	/**
	 * @param children the children to set
	 */
	public void setChildren(List<MenuOption> children) {
		this.children = children;
	}
	
	
}
