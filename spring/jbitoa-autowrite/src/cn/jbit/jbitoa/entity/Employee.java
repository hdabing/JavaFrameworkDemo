package cn.jbit.jbitoa.entity;

import java.io.Serializable;

/**
 * 员工表
 * 
 * 
 * 创建时间：2016-3-16 上午10:52:31
 * 
 * @author moshco zhu
 * 
 */
public class Employee implements Serializable {

	// 编码
	private String sn = null;

	// 职位
	private Integer positionId = null;

	// 部门
	private Integer departmentId = null;

	// 密码
	private String password = null;

	// 姓名
	private String name = null;

	// 状态
	private String status = null;

	public String getSn() {
		return sn;
	}

	public void setSn(String sn) {
		this.sn = sn;
	}

	public Integer getPositionId() {
		return positionId;
	}

	public void setPositionId(Integer positionId) {
		this.positionId = positionId;
	}

	public Integer getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(Integer departmentId) {
		this.departmentId = departmentId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}