package cn.jbit.jbitoa.entity;

import java.io.Serializable;

/**
 * 职位
 * 
 * 
 * 创建时间：2016-3-16 上午10:52:50
 * 
 * @author moshco zhu
 * 
 */
public class Position implements Serializable {

	// 记录Id
	private Integer id = null;

	// 中文名称
	private String nameCn = null;

	// 英文名称
	private String nameEn = null;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNameCn() {
		return nameCn;
	}

	public void setNameCn(String nameCn) {
		this.nameCn = nameCn;
	}

	public String getNameEn() {
		return nameEn;
	}

	public void setNameEn(String nameEn) {
		this.nameEn = nameEn;
	}

}