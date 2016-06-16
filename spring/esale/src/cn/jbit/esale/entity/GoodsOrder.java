/**
 * @描述：
 * @开发人员：moshco zhu
 * @开发时间：2013-3-22 上午9:28:37
 */
package cn.jbit.esale.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 商品订单
 * 
 * 
 * 创建时间：2015-10-28 下午3:13:52
 * 
 * @author mxc
 * 
 */
public class GoodsOrder implements Serializable {

	// 记录编号
	protected Integer id = null;

	// 订单编号
	protected String code = null;

	// 客户姓名
	protected String trueName = null;

	// 邮箱
	protected String email = null;

	// 电话号码
	protected String phone = null;

	// 客户的地址
	protected String address = null;

	// 订单总计金额
	protected String totalMoney = null;

	// 订单备注信息
	protected String remark = null;

	// 订单提交时间
	protected Date submitTime = null;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getTrueName() {
		return trueName;
	}

	public void setTrueName(String trueName) {
		this.trueName = trueName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getTotalMoney() {
		return totalMoney;
	}

	public void setTotalMoney(String totalMoney) {
		this.totalMoney = totalMoney;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Date getSubmitTime() {
		return submitTime;
	}

	public void setSubmitTime(Date submitTime) {
		this.submitTime = submitTime;
	}

}
