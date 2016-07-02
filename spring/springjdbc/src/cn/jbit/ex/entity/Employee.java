package cn.jbit.ex.entity;

import java.io.Serializable;
/**
 * 员工实体类
 * @author mxc  
 * @date 2016年6月30日 下午3:53:00
 */
public class Employee implements Serializable {

	//记录编号
	protected Integer id = null;
	
	//姓名
	protected String trueName = null;
	
	//年龄
	protected Integer age = null;
	
	//性别
	protected String sex = null;
	
	//所在部门
	protected String department = null;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTrueName() {
		return trueName;
	}

	public void setTrueName(String trueName) {
		this.trueName = trueName;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}
	
	
}
