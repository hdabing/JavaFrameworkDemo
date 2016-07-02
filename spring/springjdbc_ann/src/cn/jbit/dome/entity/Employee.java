package cn.jbit.dome.entity;

import java.io.Serializable;

/**
 * 员工实体类
 * @author mxc  
 * @date 2016年6月30日 下午10:08:14
 */
public class Employee implements Serializable {

	protected Integer  id = null;
	
	protected String  trueName  = null;
	
	protected Integer  age = null;
	
	protected String sex = null;
	
	protected String dept = null;

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

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}
	
	
}
