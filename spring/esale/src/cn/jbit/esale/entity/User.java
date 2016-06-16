/**
 * @描述：
 * @开发人员：moshco zhu
 * @开发时间：2012-4-21 上午10:17:23
 */
package cn.jbit.esale.entity;

import java.io.Serializable;

/**
 * @描述：实体-用户
 * @开发人员：mxc
 * @开发时间：2012-4-21 上午10:17:23
 */
public class User implements Serializable {

	// 记录编号
	protected Integer id = null;

	// 帐号
	protected String name = null;

	// 密码
	protected String password = null;

	// 电话号码
	protected String telephone = null;

	// 用户姓名
	protected String userName = null;

	// 是否是管理员
	protected String isAdmin = null;

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password
	 *            the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the telephone
	 */
	public String getTelephone() {
		return telephone;
	}

	/**
	 * @param telephone
	 *            the telephone to set
	 */
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param userName
	 *            the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * @return the isAdmin
	 */
	public String getIsAdmin() {
		return isAdmin;
	}

	/**
	 * @param isAdmin
	 *            the isAdmin to set
	 */
	public void setIsAdmin(String isAdmin) {
		this.isAdmin = isAdmin;
	}

}
