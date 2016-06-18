package cn.jbit.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cn.jbit.demo.dao.OrderDao;
import cn.jbit.demo.entity.GoodsOrder;

/**
 * Demo service
 * 
 * 
 * 创建时间：2016-3-2 下午1:30:04
 * 
 * @author moshco zhu
 * 
 */
@Service("orderService")
public class OrderServiceImpl implements OrderService {

	@Autowired
	@Qualifier("orderDao")
	protected OrderDao orderDao = null;

	public OrderDao getOrderDao() {
		return orderDao;
	}

	
	public void setOrderDao(OrderDao orderDao) {
		this.orderDao = orderDao;
	}

	/**
	 * 订单列表
	 * 
	 * 
	 * 开发时间：2016-3-2 下午1:30:13
	 * 
	 * @author：moshco zhu
	 * @return
	 */
	@Override
	@Transactional(readOnly = true)
	public List<GoodsOrder> listOrder() {
		return orderDao.listOrder();
	}

	/**
	 * 提交订单
	 * 
	 * 
	 * 开发时间：2016-3-2 下午1:30:22
	 * 
	 * @author：moshco zhu
	 * @param order
	 */
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void submitOrder(GoodsOrder order) {
		orderDao.submitOrder(order);
	}

	/**
	 * 找到订单
	 * 
	 * 
	 * 开发时间：2016-3-2 下午1:30:31
	 * 
	 * @author：moshco zhu
	 * @param code
	 * @return
	 */
	@Override
	@Transactional(readOnly = true)
	public GoodsOrder findOrder(String code) {
		return orderDao.findOrder(code);
	}

}
