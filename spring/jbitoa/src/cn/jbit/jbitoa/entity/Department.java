package cn.jbit.jbitoa.entity;

import java.io.Serializable;

/**
 * 部门表
 * 
 * 
 * 创建时间：2016-3-16 上午10:52:11
 * 
 * @author moshco zhu
 * 
 */
public class Department implements Serializable {

	// 记录Id
	private Integer id = null;

	// 名称
	private String name = null;

	// 经理
	private String managerSn = null;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getManagerSn() {
		return managerSn;
	}

	public void setManagerSn(String managerSn) {
		this.managerSn = managerSn;
	}

}