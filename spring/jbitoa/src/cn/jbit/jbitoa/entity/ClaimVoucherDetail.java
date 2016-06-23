package cn.jbit.jbitoa.entity;

import java.io.Serializable;

/**
 * 收据明细
 * 
 * 
 * 创建时间：2016-3-16 上午10:52:02
 * 
 * @author moshco zhu
 * 
 */
public class ClaimVoucherDetail implements Serializable {

	// 记录Id
	private Long id = null;

	// 主表Id
	private Long mainId = null;

	// 项目
	private String item = null;

	// 金额
	private String account = null;

	// 备注
	private String desc = null;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public Long getMainId() {
		return mainId;
	}

	public void setMainId(Long mainId) {
		this.mainId = mainId;
	}

}