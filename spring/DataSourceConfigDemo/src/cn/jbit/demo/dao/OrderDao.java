/**
 * 
 * 
 * 创建时间：2016-3-1 下午5:14:41
 * @author：moshco zhu
 */
package cn.jbit.demo.dao;

import java.io.Serializable;
import java.util.List;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.jbit.demo.entity.GoodsOrder;

/**
 * 数据控制层
 * 
 * 创建时间：2016-3-1 下午5:14:41
 * 
 * @author moshco zhu
 * 
 */
public class OrderDao extends HibernateDaoSupport implements Serializable {

	/**
	 * 订单列表
	 * 
	 * 
	 * 开发时间：2016-3-1 下午5:15:00
	 * 
	 * @author：moshco zhu
	 * @return
	 */
	public List<GoodsOrder> listOrder() {
		HibernateTemplate ht = getHibernateTemplate();
		List<GoodsOrder> list = ht
				.find("from GoodsOrder order by submitTime desc");
		return list;
	}

	/**
	 * 提交订单
	 * 
	 * 
	 * 开发时间：2016-3-1 下午5:16:31
	 * 
	 * @author：moshco zhu
	 * @param order
	 */
	public void submitOrder(GoodsOrder order) {
		HibernateTemplate ht = getHibernateTemplate();
		ht.save(order);
	}

	/**
	 * 找寻订单
	 * 
	 * 
	 * 开发时间：2016-3-1 下午5:16:54
	 * 
	 * @author：moshco zhu
	 * @param code
	 * @return
	 */
	public GoodsOrder findOrder(String code) {
		HibernateTemplate ht = getHibernateTemplate();
		List<GoodsOrder> list = ht.find("from GoodsOrder where code like ?",
				code);
		return (list == null || list.size() == 0) ? null : list.get(0);
	}

}
