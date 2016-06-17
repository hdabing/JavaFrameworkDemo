package cn.jbit.demo.action.order;

import java.io.Serializable;
import java.util.List;

import cn.jbit.demo.entity.GoodsOrder;
import cn.jbit.demo.service.OrderService;

import com.opensymphony.xwork2.Action;

/**
 * 订单列表
 * 
 * 
 * 创建时间：2016-3-1 下午5:19:45
 * 
 * @author moshco zhu
 * 
 */
public class ListAction implements Serializable {

	protected OrderService orderService = null;

	protected List<GoodsOrder> listOrder = null;

	/**
	 * 业务实现
	 * 
	 * 
	 * 开发时间：2016-3-1 下午5:19:53
	 * 
	 * @author：moshco zhu
	 * @return
	 */
	public String execute() {

		listOrder = orderService.listOrder();

		return Action.SUCCESS;
	}

	public OrderService getOrderService() {
		return orderService;
	}

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
