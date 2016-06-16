package cn.jbit.esale.service;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import cn.jbit.esale.entity.Goods;
import cn.jbit.esale.entity.GoodsOrder;
import cn.jbit.esale.entity.GoodsOrderDetail;
import cn.jbit.esale.entity.User;
/**
 * Service接口 为了使用声明式事务
 * @author mxc  
 * @date 2016年6月15日 上午9:42:22
 */
public interface EsaleService extends Serializable {
	
	/**
	 * 保存订单
	 * 2016年6月15日上午10:21:30 
	 * @author mxc  
	 *  @param goodsOrder
	 */
	void saveGoodsOrder(GoodsOrder goodsOrder);
	
	/**
	 *保存订单详情
	 * 2016年6月15日上午10:22:35 
	 * @author mxc  
	 *  @param goodsOrderDetail
	 */
	void saveGoodsOrderDetail(GoodsOrderDetail goodsOrderDetail);

	/**
	 * 根据用户名查找User
	 * 2016年6月15日上午9:43:33 
	 * @author mxc  
	 *  @param name
	 *  @return
	 */
	User findUser(String name);
	
	/**
	 * 根据用户id查找
	 * 2016年6月15日上午9:43:54 
	 * @author mxc  
	 *  @param id
	 *  @return
	 */
	User findUser(Integer id);

	/**
	 * 查询订单
	 * 2016年6月15日上午11:28:35 
	 * @author mxc  
	 *  @param code
	 *  @return
	 */
	GoodsOrder findGoodsOrder(String code);
	
	GoodsOrder findGoodsOrder(Integer code);

	/**
	 * 提交订单
	 * 2016年6月15日上午11:28:46 
	 * @author mxc  
	 *  @param goodsOrder
	 */
	void submitGoodsOrder(GoodsOrder goodsOrder);

	/**
	 * 根据订单id查询订单明细列表
	 * 2016年6月15日下午12:09:14 
	 * @author mxc  
	 *  @param orderId
	 *  @return
	 */
	List<GoodsOrderDetail> queryGoodsOrderDetail(Integer orderId);

	/**
	 * 查询所有商品
	 * 2016年6月15日下午12:09:36 
	 * @author mxc  
	 *  @return
	 */
	List<Goods> queryGoods();

	/**
	 * 添加订单明细
	 * 2016年6月15日下午3:19:04 
	 * @author mxc  
	 *  @param detail
	 */
	void addGoodsOrderDetail(GoodsOrderDetail detail);

	/**
	 * 更新订单
	 * 2016年6月15日下午3:24:32 
	 * @author mxc  
	 *  @param goodsOrder
	 */
	void updateGoodsOrder(GoodsOrder goodsOrder);

	
	/**
	 * 删除订单 订单详情
	 * 2016年6月15日下午4:54:27 
	 * @author mxc  
	 *  @param goodsOrder
	 *  @param details
	 */
	void deleteGoodsOrder(GoodsOrder goodsOrder, List<GoodsOrderDetail> details);

	/**
	 * 查询订单明细
	 * 2016年6月15日下午5:14:15 
	 * @author mxc  
	 *  @param id
	 *  @return
	 */
	GoodsOrderDetail findGoodsOrderDetail(Integer id);

	/**
	 * 删除订单明细
	 * 2016年6月15日下午5:14:29 
	 * @author mxc  
	 *  @param detail
	 */
	void deleteGoodsOrderDetail(GoodsOrderDetail detail);

	/**
	 * 分页查询订单
	 * 有查询条件
	 * 2016年6月16日上午10:03:55 
	 * @author mxc  
	 *  @param queryParamMap
	 *  @param pageIndex
	 *  @param pageSize
	 *  @return
	 */
	Object[] queryPaginationGoodsOrder(Map<String, Object> queryParamMap, Integer pageIndex, Integer pageSize);
}
