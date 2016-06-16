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
/**
 * 投票记录表
 * TODO
 * @date：May 27, 2016 10:47:23 AM
 * @author mxc
 */
import org.hibernate.annotations.CacheConcurrencyStrategy;
@Entity
@Table(name="VOTE_ITEM")
@org.hibernate.annotations.Entity(dynamicUpdate=true,selectBeforeUpdate=true)
@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
public class VoteItem implements Serializable {

	//记录编号
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="SEQ")
	@SequenceGenerator(name="SEQ",sequenceName="SEQ_VOTE_ITEM",initialValue=1,allocationSize=5)
	@Column(name="VI_ID")
	protected Integer viID = null;
	
	//投票编号
	@Column(name="VS_ID")
	protected Integer vsID =  null;
	
	//投票选项 编号
	@Column(name="VO_ID")
	protected Integer voID = null;
	
	//投票人id
	@Column(name="VU_ID")
	protected Integer vuID =  null;

	/**
	 * @return the viID
	 */
	public Integer getViID() {
		return viID;
	}

	/**
	 * @param viID the viID to set
	 */
	public void setViID(Integer viID) {
		this.viID = viID;
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
	 * @return the voID
	 */
	public Integer getVoID() {
		return voID;
	}

	/**
	 * @param voID the voID to set
	 */
	public void setVoID(Integer voID) {
		this.voID = voID;
	}

	/**
	 * @return the vuID
	 */
	public Integer getVuID() {
		return vuID;
	}

	/**
	 * @param vuID the vuID to set
	 */
	public void setVuID(Integer vuID) {
		this.vuID = vuID;
	}
	
	
}
