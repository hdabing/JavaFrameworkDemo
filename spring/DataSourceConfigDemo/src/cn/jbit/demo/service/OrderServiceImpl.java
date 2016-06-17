/**
 * 
 * 
 * 创建时间：2016-3-1 下午5:12:52
 * @author：moshco zhu
 */
package cn.jbit.demo.service;

import java.util.List;

import cn.jbit.demo.dao.OrderDao;
import cn.jbit.demo.entity.GoodsOrder;

/**
 * Demo service
 * 
 * 创建时间：2016-3-1 下午5:12:52
 * 
 * @author moshco zhu
 * 
 */
public class OrderServiceImpl implements OrderService {

	protected OrderDao orderDao = null;

	/**
	 * @return the orderDao
	 */
	public OrderDao getOrderDao() {
		return orderDao;
	}

	/**
	 * @param orderDao
	 *            the orderDao to set
	 */
	public void setOrderDao(OrderDao orderDao) {
		this.orderDao = orderDao;
	}

	/**
	 * 订单列表
	 * 
	 * 
	 * 开发时间：2016-3-1 下午5:17:15
	 * 
	 * @author：moshco zhu
	 * @return
	 */
	public List<GoodsOrder> listOrder() {
		return orderDao.listOrder();
	}

	/**
	 * 提交订单
	 * 
	 * 
	 * 开发时间：2016-3-1 下午5:18:22
	 * 
	 * @author：moshco zhu
	 * @param order
	 */
	public void submitOrder(GoodsOrder order) {
		orderDao.submitOrder(order);
	}

	/**
	 * 找到订单
	 * 
	 * 
	 * 开发时间：2016-3-1 下午5:18:43
	 * 
	 * @author：moshco zhu
	 * @param code
	 * @return
	 */
	public GoodsOrder findOrder(String code) {
		return orderDao.findOrder(code);
	}

}
