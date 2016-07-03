package cn.jbit.demo.entity;

import java.io.Serializable;

/**
 * 员工的实体类
 * 
 * @author weiyun.zhang
 * 
 */
public class Employee implements Serializable {

	private String sn = null; // 员工编号

	private String name = null; // 员工姓名

	private String password = null;

	private String status = null;

	private Integer positionId = null;

	private Integer departmentId = null;

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

	public String getSn() {
		return sn;
	}

	public void setSn(String sn) {
		this.sn = sn;
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
