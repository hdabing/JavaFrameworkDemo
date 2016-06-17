package cn.jbit.jbitoa.entity;

import java.io.Serializable;

/**
 * 菜单项
 * 
 * 
 * 创建时间：2016-3-16 上午10:52:41
 * 
 * @author moshco zhu
 * 
 */
public class MenuOption implements Serializable {

	// 数据库表字段:id 描述:记录编号
	protected Integer id = null;

	// 数据库表字段:code 描述:菜单编码
	protected String code = null;

	// 数据库表字段:inner_code 描述:目录内编码
	protected String innerCode = null;

	// 数据库表字段:title 描述:菜单项名称
	protected String title = null;

	// 数据库表字段:super_id 描述:上级菜单项编号
	protected Integer superId = null;

	// 数据库表字段:super_title 描述:上级菜单项名称
	protected String superTitle = null;

	// 数据库表字段:depth 描述:菜单深度
	protected Integer depth = null;

	// 数据库表字段:url 描述:功能链接
	protected String url = null;

	// 数据库表字段:remark 描述:备注
	protected String remark = null;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getInnerCode() {
		return innerCode;
	}

	public void setInnerCode(String innerCode) {
		this.innerCode = innerCode;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Integer getSuperId() {
		return superId;
	}

	public void setSuperId(Integer superId) {
		this.superId = superId;
	}

	public String getSuperTitle() {
		return superTitle;
	}

	public void setSuperTitle(String superTitle) {
		this.superTitle = superTitle;
	}

	public Integer getDepth() {
		return depth;
	}

	public void setDepth(Integer depth) {
		this.depth = depth;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}