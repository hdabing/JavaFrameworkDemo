package cn.jbit.esale.service;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.springframework.orm.hibernate3.HibernateTemplate;

import cn.jbit.esale.dao.EsaleDao;
import cn.jbit.esale.entity.Goods;
import cn.jbit.esale.entity.GoodsOrder;
import cn.jbit.esale.entity.GoodsOrderDetail;
import cn.jbit.esale.entity.User;

/**
 * Service接口实现
 * @author mxc  
 * @date 2016年6月15日 上午9:44:28
 */
public class EsaleServiceImpl implements Serializable, EsaleService {

	protected EsaleDao esaleDao = null; 
	
	@Override
	public User findUser(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User findUser(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void saveGoodsOrder(GoodsOrder goodsOrder) {
		// TODO Auto-generated method stub
		esaleDao.saveGoodsOrder(goodsOrder);
	}

	@Override
	public void saveGoodsOrderDetail(GoodsOrderDetail goodsOrderDetail) {
		// TODO Auto-generated method stub
		esaleDao.saveGoodsOrderDetail(goodsOrderDetail);
	}
	public EsaleDao getEsaleDao() {
		return esaleDao;
	}

	public void setEsaleDao(EsaleDao esaleDao) {
		this.esaleDao = esaleDao;
	}

	@Override
	public GoodsOrder findGoodsOrder(String code) {
		// TODO Auto-generated method stub
		return esaleDao.findGoodsOrder(code);
	}

	@Override
	public void submitGoodsOrder(GoodsOrder goodsOrder) {
		// TODO Auto-generated method stub
		esaleDao.submitGoodsOrder(goodsOrder);
	}

	@Override
	public GoodsOrder findGoodsOrder(Integer code) {
		// TODO Auto-generated method stub
		return esaleDao.findGoodsOrder(code);
	}

	@Override
	public List<GoodsOrderDetail> queryGoodsOrderDetail(Integer orderId) {
		// TODO Auto-generated method stub
		return esaleDao.queryGoodsOrderDetail(orderId);
	}

	@Override
	public List<Goods> queryGoods() {
		// TODO Auto-generated method stub
		return esaleDao.queryGoods();
	}

	@Override
	public void addGoodsOrderDetail(GoodsOrderDetail detail) {
		// TODO Auto-generated method stub
		esaleDao.addGoodsOrderDetail(detail);
	}

	@Override
	public void updateGoodsOrder(GoodsOrder goodsOrder) {
		// TODO Auto-generated method stub
		esaleDao.updateGoodsOrder(goodsOrder);
	}

	@Override
	public void deleteGoodsOrder(GoodsOrder goodsOrder,List<GoodsOrderDetail> details) {
		esaleDao.deleteGoodsOrder(goodsOrder,details);
		
	}

	@Override
	public GoodsOrderDetail findGoodsOrderDetail(Integer id) {
		// TODO Auto-generated method stub
		return esaleDao.findGoodsOrderDetail(id);
	}

	@Override
	public void deleteGoodsOrderDetail(GoodsOrderDetail detail) {
		// TODO Auto-generated method stub
		esaleDao.deleteGoodsOrderDetail(detail);
	}

	@Override
	public Object[] queryPaginationGoodsOrder(Map<String, Object> queryParamMap, Integer pageIndex, Integer pageSize) {
		// TODO Auto-generated method stub
		return esaleDao.queryPaginationGoodsOrder(queryParamMap,pageIndex,pageSize);
	}

	

	
}
