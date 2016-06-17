package cn.jbit.jbitoa.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 记账表
 * 
 * 
 * 创建时间：2016-3-16 上午10:51:28
 * 
 * @author mxc
 * 
 */
public class Account implements Serializable {

	// 记录Id
	private Integer id = null;

	// 用户Id
	private String usrId = null;

	// 类型
	private String accType = null;

	// 金额
	private String accMoney = null;

	// 表单Id
	private String sheetId = null;

	// 时间
	private Date accTime = null;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * 
	 * 
	 * 
	 * 开发时间：2016-3-19 下午4:16:46
	 * 
	 * @author：moshco zhu
	 * @return
	 */
	public String getUsrId() {
		return usrId;
	}

	public void setUsrId(String usrId) {
		this.usrId = usrId;
	}

	public String getAccType() {
		return accType;
	}

	public void setAccType(String accType) {
		this.accType = accType;
	}

	public String getAccMoney() {
		return accMoney;
	}

	public void setAccMoney(String accMoney) {
		this.accMoney = accMoney;
	}

	public String getSheetId() {
		return sheetId;
	}

	public void setSheetId(String sheetId) {
		this.sheetId = sheetId;
	}

	public Date getAccTime() {
		return accTime;
	}

	public void setAccTime(Date accTime) {
		this.accTime = accTime;
	}

}