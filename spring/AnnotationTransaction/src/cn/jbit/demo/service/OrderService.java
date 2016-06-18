package cn.jbit.demo.service;

import java.io.Serializable;
import java.util.List;

import cn.jbit.demo.entity.GoodsOrder;

/**
 * Demo service
 * 
 * 
 * 创建时间：2016-3-2 下午1:29:24
 * 
 * @author moshco zhu
 * 
 */
public interface OrderService extends Serializable {

	List<GoodsOrder> listOrder();

	void submitOrder(GoodsOrder order);

	GoodsOrder findOrder(String code);

}
