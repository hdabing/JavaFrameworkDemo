package cn.jbit.demo.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 商品订单
 * 
 * 
 * 创建时间：2016-3-1 下午5:13:51
 * 
 * @author moshco zhu
 * 
 */
public class GoodsOrder implements Serializable {

	protected Integer id = null;

	protected String code = null;

	protected String trueName = null;

	protected String email = null;

	protected String phone = null;

	protected String address = null;

	protected String totalMoney = null;

	protected String remark = null;

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
