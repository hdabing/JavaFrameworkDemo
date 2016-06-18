package cn.jbit.demo.dao;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import cn.jbit.demo.entity.GoodsOrder;

/**
 * 数据控制层
 * 
 * 
 * 创建时间：2016-3-2 下午1:28:15
 * 
 * @author moshco zhu
 * 
 */
@Repository
public class OrderDao implements Serializable {

	// @Autowired
	// @Qualifier("hibernateTemplate")
	protected HibernateTemplate hibernateTemplate = null;

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	@Autowired
	@Qualifier("hibernateTemplate")
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	/**
	 * 订单列表
	 * 
	 * 
	 * 开发时间：2016-3-2 下午1:28:27
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
	 * 开发时间：2016-3-2 下午1:28:34
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
	 * 开发时间：2016-3-2 下午1:28:41
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
