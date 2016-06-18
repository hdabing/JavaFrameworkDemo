package cn.jbit.demo.action.order;

import java.io.Serializable;
import java.util.List;

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
 * 订单列表
 * 
 * 
 * 创建时间：2016-3-2 下午1:27:20
 * 
 * @author moshco zhu
 * 
 */
@Scope(value = "prototype")
@Component("order.listAction")
@ParentPackage("order")
@Namespace("/order")
public class ListAction implements Serializable {

	protected OrderService orderService = null;

	protected List<GoodsOrder> listOrder = null;

	/**
	 * 业务实现
	 * 
	 * 
	 * 开发时间：2016-3-2 下午1:27:28
	 * 
	 * @author：moshco zhu
	 * @return
	 */
	@Action(value = "list", results = { @Result(name = com.opensymphony.xwork2.Action.SUCCESS, location = "/order/list.jsp") })
	public String execute() {

		listOrder = orderService.listOrder();

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

	public List<GoodsOrder> getListOrder() {
		return listOrder;
	}

	public void setListOrder(List<GoodsOrder> listOrder) {
		this.listOrder = listOrder;
	}

}
