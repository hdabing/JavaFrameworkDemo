package cn.jbit.vote.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
/**
 * TODO 投票表
 * @date：May 27, 2016 10:08:10 AM
 * @author mxc
 */
@Entity 
@Table(name="VOTE_SUBJECT")
@org.hibernate.annotations.Entity(dynamicUpdate=true,selectBeforeUpdate=true)
@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
public class VoteSubject implements Serializable {
	
	//记录编号
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="SEQ")
	@SequenceGenerator(sequenceName="SEQ_VOTE_SUBJECT",name="SEQ",initialValue=1,allocationSize=5)
	@Column(name="VS_ID")
	protected Integer vsId = null;
	
	//投票标题
	@Column(name="VS_TITLE")
	protected String vsTitle = null;
	
	//选项类型(1=radio 2=checkbox)
	@Column(name="VS_TYPE")
	protected Integer vsType = null;

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
	
	
}
