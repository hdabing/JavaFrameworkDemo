package cn.jbit.esale.action;

import java.io.Serializable;
import java.util.List;

import com.sun.corba.se.impl.protocol.giopmsgheaders.Message;

import cn.jbit.esale.entity.Goods;
import cn.jbit.esale.entity.GoodsOrder;
import cn.jbit.esale.entity.GoodsOrderDetail;
import cn.jbit.esale.service.EsaleService;
/**
 * 去添加 订单详情
 * @author mxc  
 * @date 2016年6月15日 上午11:52:47
 */
public class ToSubmitGoodsOrderDetailAction implements Serializable {

	//订单ID
	protected Integer orderId = null;
	
	
	
	//业务对象
	protected EsaleService esaleService= null;
	
	//订单
	protected GoodsOrder goodsOrder = null;
	
	//订单明细列表
	protected List<GoodsOrderDetail> goodsOrderDetails = null;
	 
	//商品列表
	protected List<Goods> goodsList  =  null;
	
	/**
	 * 业务 实现 
	 * 首先根据id查出 订单
	 * 根据订单查询出订单下的订单明细列表
	 * 查询出 商品列表，添加订单明细时以供选择
	 * 然后跳转到 添加页面 显示订单信息
	 * 2016年6月15日上午11:53:27 
	 * @author mxc  
	 *  @return
	 */
	public String execute(){
		
		//找寻订单对象
		goodsOrder = esaleService.findGoodsOrder(orderId);
		
		//查询订单明细
		goodsOrderDetails = esaleService.queryGoodsOrderDetail(orderId);
		
		//查询商品列表
		goodsList= esaleService.queryGoods();
		
		return "success";
	}

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public EsaleService getEsaleService() {
		return esaleService;
	}

	public void setEsaleService(EsaleService esaleService) {
		this.esaleService = esaleService;
	}

	public GoodsOrder getGoodsOrder() {
		return goodsOrder;
	}

	public void setGoodsOrder(GoodsOrder goodsOrder) {
		this.goodsOrder = goodsOrder;
	}

	public List<GoodsOrderDetail> getGoodsOrderDetails() {
		return goodsOrderDetails;
	}

	public void setGoodsOrderDetails(List<GoodsOrderDetail> goodsOrderDetails) {
		this.goodsOrderDetails = goodsOrderDetails;
	}

	public List<Goods> getGoodsList() {
		return goodsList;
	}

	public void setGoodsList(List<Goods> goodsList) {
		this.goodsList = goodsList;
	}

	
	
	
}
