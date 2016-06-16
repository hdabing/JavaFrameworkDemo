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
 * 投票选项表
 * TODO
 * @date：May 27, 2016 10:17:01 AM
 * @author mxc
 */
@Entity
@Table(name="VOTE_OPTION")
@org.hibernate.annotations.Entity(dynamicUpdate=true,selectBeforeUpdate=true)
@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
public class VoteOption implements Serializable {
	
	//记录编号
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="SEQ")
	@SequenceGenerator(name="SEQ",sequenceName="SEQ_VOTE_OPTION",initialValue=1,allocationSize=5)
	@Column(name="VO_ID")
	protected Integer voId = null;
	
	//选项标题
	@Column(name="VO_OPTION")
	protected String voOption =null;
	
	//投票主表编号
	@Column(name="VS_ID")
	protected Integer vsID = null;
	
	//排序
	@Column(name="VO_ORDER")
	protected String voOrder =  null;

	/**
	 * @return the voId
	 */
	public Integer getVoId() {
		return voId;
	}

	/**
	 * @param voId the voId to set
	 */
	public void setVoId(Integer voId) {
		this.voId = voId;
	}

	/**
	 * @return the voOption
	 */
	public String getVoOption() {
		return voOption;
	}

	/**
	 * @param voOption the voOption to set
	 */
	public void setVoOption(String voOption) {
		this.voOption = voOption;
	}

	/**
	 * @return the vsID
	 */
	public Integer getVsID() {
		return vsID;
	}

	/**
	 * @param vsID the vsID to set
	 */
	public void setVsID(Integer vsID) {
		this.vsID = vsID;
	}

	/**
	 * @return the voOrder
	 */
	public String getVoOrder() {
		return voOrder;
	}

	/**
	 * @param voOrder the voOrder to set
	 */
	public void setVoOrder(String voOrder) {
		this.voOrder = voOrder;
	}
	
	
	
	
}
