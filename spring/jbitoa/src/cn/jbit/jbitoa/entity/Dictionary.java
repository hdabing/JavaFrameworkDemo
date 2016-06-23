package cn.jbit.jbitoa.entity;

import java.io.Serializable;

/**
 * 字典表
 * 
 * 
 * 创建时间：2016-3-16 上午10:52:22
 * 
 * @author mxc
 * 
 */
public class Dictionary implements Serializable {

	// 记录编号
	private Long id = null;

	// 类型
	private String type = null;

	// 项目
	private String item = null;

	// 值
	private String value = null;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}