package cn.jbit.ex.entity;

import java.io.Serializable;
/**
 * 报销单
 * @author mxc  
 * @date 2016年7月1日 下午2:38:11
 */
import java.util.Date;
public class ClaimVoucher implements Serializable {

	//id
	protected Integer  id = null;
	
	//提交人
	protected String submitMan = null;
	
	//事件
	protected String event = null;
	
	//提交时间
	protected Date submitTime = null;
	
	//总计金额
	protected String totalMoney = null;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getSubmitMan() {
		return submitMan;
	}

	public void setSubmitMan(String submitMan) {
		this.submitMan = submitMan;
	}

	public String getEvent() {
		return event;
	}

	public void setEvent(String event) {
		this.event = event;
	}

	public Date getSubmitTime() {
		return submitTime;
	}

	public void setSubmitTime(Date submitTime) {
		this.submitTime = submitTime;
	}

	public String getTotalMoney() {
		return totalMoney;
	}

	public void setTotalMoney(String totalMoney) {
		this.totalMoney = totalMoney;
	}
	
	
}
