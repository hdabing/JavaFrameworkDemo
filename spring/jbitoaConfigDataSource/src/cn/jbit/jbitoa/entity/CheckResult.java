package cn.jbit.jbitoa.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 审核表
 * 
 * 
 * 创建时间：2016-3-16 上午10:51:42
 * 
 * @author mxc
 * 
 */
public class CheckResult implements Serializable {

	// 记录Id
	private Long id = null;

	// 表单类型
	private String sheetType = null;

	// 表单Id
	private Long sheetId = null;

	// 审核时间
	private Date checkTime = null;

	// 类型
	private String type = null;

	// 审核人
	private String checkSn = null;

	// 结果
	private String result = null;

	// 审核内容
	private String comment = null;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSheetType() {
		return sheetType;
	}

	public void setSheetType(String sheetType) {
		this.sheetType = sheetType;
	}

	public Long getSheetId() {
		return sheetId;
	}

	public void setSheetId(Long sheetId) {
		this.sheetId = sheetId;
	}

	public Date getCheckTime() {
		return checkTime;
	}

	public void setCheckTime(Date checkTime) {
		this.checkTime = checkTime;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getCheckSn() {
		return checkSn;
	}

	public void setCheckSn(String checkSn) {
		this.checkSn = checkSn;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

}