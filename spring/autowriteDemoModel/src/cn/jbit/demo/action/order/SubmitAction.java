package cn.jbit.demo.action.order;

import java.io.Serializable;
import java.util.Date;

import cn.jbit.demo.entity.GoodsOrder;
import cn.jbit.demo.service.OrderService;

import com.opensymphony.xwork2.Action;

/**
 * 提交订单
 * 
 * 
 * 创建时间：2016-3-1 下午5:20:08
 * 
 * @author moshco zhu
 * 
 */
public class SubmitAction implements Serializable {

	protected OrderService orderService = null;

	protected GoodsOrder goodsOrder = null;

	protected String msg = null;

	public SubmitAction() {
	}

	public SubmitAction(OrderService orderService) {
		this.orderService = orderService;
	}

	/**
	 * 业务实现
	 * 
	 * 
	 * 开发时间：2016-3-1 下午5:20:15
	 * 
	 * @author：moshco zhu
	 * @return
	 */
	public String execute() {

		if (goodsOrder.getCode() == null
				|| goodsOrder.getCode().trim().length() <= 0) {
			msg = "订单编号不能为空！";
			return Action.INPUT;
		}

		GoodsOrder order = orderService.findOrder(goodsOrder.getCode());
		if (order != null) {
			msg = "订单编号重复！";
			return Action.INPUT;
		}

		goodsOrder.setSubmitTime(new Date(System.currentTimeMillis()));
		orderService.submitOrder(goodsOrder);

		return Action.SUCCESS;
	}

	public OrderService getOrderService() {
		return orderService;
	}

	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
	}

	public GoodsOrder getGoodsOrder() {
		return goodsOrder;
	}

	public void setGoodsOrder(GoodsOrder goodsOrder) {
		this.goodsOrder = goodsOrder;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

}
