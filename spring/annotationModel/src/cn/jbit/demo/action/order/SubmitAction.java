package cn.jbit.demo.action.order;

import java.io.Serializable;
import java.util.Date;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import cn.jbit.demo.entity.GoodsOrder;
import cn.jbit.demo.service.OrderService;

/**
 * 提交订单
 * 
 * 
 * 创建时间：2016-3-2 下午1:27:39
 * 
 * @author moshco zhu
 * 
 */
@Scope(value = "prototype")
@Component("order.submitAction")
@ParentPackage("order")
@Namespace("/order")
public class SubmitAction implements Serializable {

	protected OrderService orderService = null;

	protected GoodsOrder goodsOrder = null;

	protected String msg = null;

	public SubmitAction() {
	}

	// public SubmitAction(OrderService orderService) {
	// this.orderService = orderService;
	// }

	/**
	 * 业务实现
	 * 
	 * 
	 * 开发时间：2016-3-2 下午1:27:52
	 * 
	 * @author：moshco zhu
	 * @return
	 */
	@Action(value = "submit", results = {
			@Result(name = com.opensymphony.xwork2.Action.SUCCESS, type = "redirect", location = "/order/list.action"),
			@Result(name = "input", location = "/order/to_submit.jsp") })
	public String execute() {

		if (goodsOrder.getCode() == null
				|| goodsOrder.getCode().trim().length() <= 0) {
			msg = "订单编号不能为空！";
			return com.opensymphony.xwork2.Action.INPUT;
		}

		GoodsOrder order = orderService.findOrder(goodsOrder.getCode());
		if (order != null) {
			msg = "订单编号重复！";
			return com.opensymphony.xwork2.Action.INPUT;
		}

		goodsOrder.setSubmitTime(new Date(System.currentTimeMillis()));
		orderService.submitOrder(goodsOrder);

		return com.opensymphony.xwork2.Action.SUCCESS;
	}

	public OrderService getOrderService() {
		return orderService;
	}

	@Autowired
	@Qualifier("orderService")
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
