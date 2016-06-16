/**
 * @描述：
 * @开发人员：moshco zhu
 * @开发时间：2014-10-13 下午4:15:47
 */
package cn.jbit.esale.entity;

import java.io.Serializable;

/**
 * 商品表
 * 
 * 
 * 创建时间：2015-10-28 下午3:14:10
 * 
 * @author mxc
 * 
 */
public class Goods implements Serializable {

	// 记录编号
	protected Integer id = null;

	// 商品编码
	protected String code = null;

	// 商品名称
	protected String title = null;

	// 商品的价格
	protected String price = null;

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

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

}
