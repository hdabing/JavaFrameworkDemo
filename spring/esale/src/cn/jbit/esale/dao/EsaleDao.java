package cn.jbit.esale.dao;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;

import cn.jbit.esale.entity.Goods;
import cn.jbit.esale.entity.GoodsOrder;
import cn.jbit.esale.entity.GoodsOrderDetail;
import sun.net.www.content.text.plain;

/**
 * Dao 
 * @author mxc  
 * @date 2016年6月15日 上午9:36:15
 */
public class EsaleDao implements Serializable {

	HibernateTemplate hibernateTemplate = null;
	
	/**
	 * 保存订单
	 * 2016年6月15日上午10:19:47 
	 * @author mxc  
	 *  @param goodsOrder
	 */
	public void saveGoodsOrder(GoodsOrder goodsOrder){
		HibernateTemplate ht =  this.getHibernateTemplate();
		ht.save(goodsOrder);
	}

	/**
	 * 保存订单明细
	 * 2016年6月15日上午10:20:49 
	 * @author mxc  
	 *  @param goodsOrderDetail
	 */
	public void saveGoodsOrderDetail(GoodsOrderDetail goodsOrderDetail){
		HibernateTemplate ht = this.getHibernateTemplate();
		ht.save(goodsOrderDetail);
	}
	
	
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	/**
	 * 查询 订单
	 * 2016年6月15日上午11:44:45 
	 * @author mxc  
	 *  @param code
	 *  @return
	 */
	public GoodsOrder findGoodsOrder(String code) {
		// TODO Auto-generated method stub
		HibernateTemplate ht = this.getHibernateTemplate();
		
		String hql =" from GoodsOrder go where go.code like :code";
		
		List<GoodsOrder> list = ht.findByNamedParam(hql, "code", code);
		
		//读取结果
		GoodsOrder goodsOrder= (list==null||list.size()<=0||list.get(0)==null)?null:list.get(0);
		
		return goodsOrder;
	}

	/**
	 * 提交订单  保存订单
	 * 2016年6月15日上午11:45:02 
	 * @author mxc  
	 *  @param goodsOrder
	 */
	public void submitGoodsOrder(GoodsOrder goodsOrder) {
		hibernateTemplate.save(goodsOrder);
		
	}
	
	/**
	 * 根据订单id查询订单
	 * 2016年6月15日下午12:10:45 
	 * @author mxc  
	 *  @param code
	 *  @return
	 */
	public GoodsOrder findGoodsOrder(Integer code) {
		// TODO Auto-generated method stub
		return hibernateTemplate.get(GoodsOrder.class, code);
	}

	/**
	 * 根据订单id查询订单明细列表
	 * 2016年6月15日下午12:11:57 
	 * @author mxc  
	 *  @param orderId
	 *  @return
	 */
	public List<GoodsOrderDetail> queryGoodsOrderDetail(Integer orderId) {
		// TODO Auto-generated method stub
		String hql ="from GoodsOrderDetail god  where god.orderId = :orderId";
		
		List<GoodsOrderDetail> list = hibernateTemplate.findByNamedParam(hql, "orderId", orderId);
		return list; 
	}
	
	/**
	 * 查询所有商品
	 * 2016年6月15日下午12:13:16 
	 * @author mxc  
	 *  @return
	 */
	public List<Goods> queryGoods() {
		// TODO Auto-generated method stub
		String hql ="from Goods";
		
		return hibernateTemplate.find(hql);
	}

	/**
	 * 保存到数据库  订单明细
	 * 2016年6月15日下午3:46:58 
	 * @author mxc  
	 *  @param detail
	 */
	public void addGoodsOrderDetail(GoodsOrderDetail detail) {
		// TODO Auto-generated method stub
		hibernateTemplate.save(detail);
	}
	/**
	 * 更新订单
	 * 2016年6月15日下午3:47:11 
	 * @author mxc  
	 *  @param goodsOrder
	 */
	public void updateGoodsOrder(GoodsOrder goodsOrder) {
		// TODO Auto-generated method stub
		hibernateTemplate.update(goodsOrder);
	}
	
	/**
	 * 删除订单
	 * 2016年6月15日下午4:44:40 
	 * @author mxc  
	 *  @param goodsOrder
	 */
	public void deleteGoodsOrder(GoodsOrder goodsOrder,List<GoodsOrderDetail> details) {
		// TODO Auto-generated method stub
		hibernateTemplate.delete(goodsOrder);
		
		if (details!=null&&details.size()>0) {
			for (GoodsOrderDetail goodsOrderDetail : details) {
				hibernateTemplate.delete(goodsOrderDetail);
			}
		}
	}

	/**
	 * 查询 订单详细
	 * 2016年6月15日下午5:15:38 
	 * @author mxc  
	 *  @param id
	 *  @return
	 */
	public GoodsOrderDetail findGoodsOrderDetail(Integer id) {
		// TODO Auto-generated method stub
		return hibernateTemplate.get(GoodsOrderDetail.class, id);
	}

	/**
	 * 删除订单详细
	 * 2016年6月15日下午5:15:52 
	 * @author mxc  
	 *  @param detail
	 */
	public void deleteGoodsOrderDetail(GoodsOrderDetail detail) {
		// TODO Auto-generated method stub
		hibernateTemplate.delete(detail);
	}

	/**
	 * 分页查询
	 * 2016年6月16日上午10:05:00 
	 * @author mxc  
	 *  @param queryParamMap 查询参数
	 *  @param pageIndex 当前页
	 *  @param pageSize 页面记录数目
	 *  @return
	 */
	public Object[] queryPaginationGoodsOrder(final Map<String, Object> queryParamMap,final Integer pageIndex,final Integer pageSize) {
		// TODO Auto-generated method stub
		Object[] aryPagination= hibernateTemplate.execute(new HibernateCallback<Object[]>() {

			@Override
			public Object[] doInHibernate(Session session) throws HibernateException, SQLException {
				// 结果
				Object[] aryPagination = null;
				
				
				//封装查询条件
				Criteria criteria= session.createCriteria(GoodsOrder.class);
				
				if (queryParamMap.get("code")!=null&&!queryParamMap.get("code").equals("")) {
					criteria.add(Restrictions.like("code",(String) queryParamMap.get("code"),MatchMode.ANYWHERE));
				}
				if (queryParamMap.get("phone")!=null&&!queryParamMap.get("phone").equals("")) {
					criteria.add(Restrictions.like("phone",(String) queryParamMap.get("phone"),MatchMode.ANYWHERE));
				}
				if (queryParamMap.get("trueName")!=null&&!queryParamMap.get("trueName").equals("")) {
					criteria.add(Restrictions.like("trueName",(String) queryParamMap.get("trueName"),MatchMode.ANYWHERE));
				}
				
				//查询总记录数
				ProjectionList pList= Projections.projectionList();
				pList.add(Projections.rowCount());
				criteria.setProjection(pList);
				Integer count = (Integer) criteria.uniqueResult();
				
				//查询数据
				criteria.setProjection(null);
				criteria.setFirstResult((pageIndex-1)*pageSize);
				criteria.setMaxResults(pageSize);
				criteria.addOrder(Order.desc("id"));
				List<GoodsOrder> goodsOrders= criteria.list();
				
				//封装数据
				aryPagination= new Object[]{count,goodsOrders};
				return aryPagination;
			}
			
		});
		return aryPagination;
	}
	
	
}
