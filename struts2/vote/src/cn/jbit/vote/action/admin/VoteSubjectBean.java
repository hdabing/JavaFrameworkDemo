package cn.jbit.vote.action.admin;

import java.io.Serializable;

import javax.persistence.Column;

import cn.jbit.vote.entity.VoteSubject;

/**
 * 投票记录
 * TODO
 * @date：Jun 1, 2016 1:44:36 PM
 * @author mxc
 */
public class VoteSubjectBean implements Serializable {

	protected Integer vsId = null;
	
	//投票标题
	
	protected String vsTitle = null;
	
	//选项类型(1=radio 2=checkbox)
	
	protected Integer vsType = null;
	
	//投票选项数
	protected Integer totalOption = null;
	
	//投票人数
	protected Integer totalUser =null;
	
	public VoteSubjectBean(){};
	
	public VoteSubjectBean(VoteSubject subject){
		this.vsId= subject.getVsId();
		this.vsType= subject.getVsType();
		this.vsTitle=subject.getVsTitle();
	}

	/**
	 * @return the vsId
	 */
	public Integer getVsId() {
		return vsId;
	}

	/**
	 * @param vsId the vsId to set
	 */
	public void setVsId(Integer vsId) {
		this.vsId = vsId;
	}

	/**
	 * @return the vsTitle
	 */
	public String getVsTitle() {
		return vsTitle;
	}

	/**
	 * @param vsTitle the vsTitle to set
	 */
	public void setVsTitle(String vsTitle) {
		this.vsTitle = vsTitle;
	}

	/**
	 * @return the vsType
	 */
	public Integer getVsType() {
		return vsType;
	}

	/**
	 * @param vsType the vsType to set
	 */
	public void setVsType(Integer vsType) {
		this.vsType = vsType;
	}

	/**
	 * @return the totalOption
	 */
	public Integer getTotalOption() {
		return totalOption;
	}

	/**
	 * @param totalOption the totalOption to set
	 */
	public void setTotalOption(Integer totalOption) {
		this.totalOption = totalOption;
	}

	/**
	 * @return the totalUser
	 */
	public Integer getTotalUser() {
		return totalUser;
	}

	/**
	 * @param totalUser the totalUser to set
	 */
	public void setTotalUser(Integer totalUser) {
		this.totalUser = totalUser;
	}
	
}
