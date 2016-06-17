package cn.jbit.jbitoa.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 单据
 * 
 * 
 * 创建时间：2016-3-16 上午10:51:53
 * 
 * @author mxc
 * 
 */
public class ClaimVoucher implements Serializable {

	// 记录Id
	private Long id = null;

	// 下一个操作人
	private String nextDealSn = null;

	// 创建人
	private String createSn = null;

	// 创建时间
	private Date createTime = null;

	// 事件
	private String event = null;

	// 总计金额
	private String totalAccount = null;

	// 状态
	private String status = null;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNextDealSn() {
		return nextDealSn;
	}

	public void setNextDealSn(String nextDealSn) {
		this.nextDealSn = nextDealSn;
	}

	public String getCreateSn() {
		return createSn;
	}

	public void setCreateSn(String createSn) {
		this.createSn = createSn;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getEvent() {
		return event;
	}

	public void setEvent(String event) {
		this.event = event;
	}

	public String getTotalAccount() {
		return totalAccount;
	}

	public void setTotalAccount(String totalAccount) {
		this.totalAccount = totalAccount;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}