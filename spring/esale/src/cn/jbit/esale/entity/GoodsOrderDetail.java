package cn.jbit.esale.entity;

import java.io.Serializable;

/**
 * 商品订单明细
 * 
 * 
 * 创建时间：2015-10-28 下午3:13:42
 * 
 * @author mxc
 * 
 */
public class GoodsOrderDetail implements Serializable {

	// 记录编号
	protected Integer id = null;

	// 订单主表Id
	protected Integer orderId = null;

	// 商品名称
	protected String goods = null;

	// 商品售价
	protected String price = null;

	// 购买数量
	protected Integer num = null;

	// 小计金额
	protected String subMoney = null;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public String getGoods() {
		return goods;
	}

	public void setGoods(String goods) {
		this.goods = goods;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public Integer getNum() {
		return num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

	public String getSubMoney() {
		return subMoney;
	}

	public void setSubMoney(String subMoney) {
		this.subMoney = subMoney;
	}

}
