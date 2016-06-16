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
 * TODO 用户实体类
 * @date：May 27, 2016 9:57:48 AM
 * @author mxc
 */
@Entity
@Table(name="VOTE_USER")
@org.hibernate.annotations.Entity(dynamicUpdate=true,selectBeforeUpdate=true)
@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
public class VoteUser implements Serializable {

	//记录编号
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="SEQ1")
	@SequenceGenerator(name="SEQ1",sequenceName="SEQ_VOTE_USER",initialValue=1,allocationSize=5)
	@Column(name="VU_ID")
	protected Integer vuId=null;
	
	//账号
	@Column(name="VU_USER_NAME")
	protected String vuUserName=null;
	
	//密码
	@Column(name="VU_PASSWORD")
	protected String vuPassword=null;
	
	//用户类型 (p普通用户，管理员)
	@Column(name="VU_USER_TYPE")
	protected String vuUserType =null;

	/**
	 * @return the vuId
	 */
	public Integer getVuId() {
		return vuId;
	}

	/**
	 * @param vuId the vuId to set
	 */
	public void setVuId(Integer vuId) {
		this.vuId = vuId;
	}

	/**
	 * @return the vuUserName
	 */
	public String getVuUserName() {
		return vuUserName;
	}

	/**
	 * @param vuUserName the vuUserName to set
	 */
	public void setVuUserName(String vuUserName) {
		this.vuUserName = vuUserName;
	}

	/**
	 * @return the vuPassword
	 */
	public String getVuPassword() {
		return vuPassword;
	}

	/**
	 * @param vuPassword the vuPassword to set
	 */
	public void setVuPassword(String vuPassword) {
		this.vuPassword = vuPassword;
	}

	/**
	 * @return the vuUserType
	 */
	public String getVuUserType() {
		return vuUserType;
	}

	/**
	 * @param vuUserType the vuUserType to set
	 */
	public void setVuUserType(String vuUserType) {
		this.vuUserType = vuUserType;
	}
}
	