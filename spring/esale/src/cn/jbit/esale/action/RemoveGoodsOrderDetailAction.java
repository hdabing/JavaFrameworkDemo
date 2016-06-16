package cn.jbit.esale.action;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.net.URLEncoder;

import cn.jbit.esale.entity.GoodsOrder;
import cn.jbit.esale.entity.GoodsOrderDetail;
import cn.jbit.esale.service.EsaleService;
/**
 * 删除订单明细
 * @author mxc  
 * @date 2016年6月15日 下午5:07:11
 */
public class RemoveGoodsOrderDetailAction implements Serializable {

	//订单明细id
	protected Integer id = null;
	
	protected EsaleService esaleService = null;
	
	//消息
	protected String message = null;
	
	//订单
	protected GoodsOrder goodsOrder = null;
	/**
	 * 查找出订单明细对象 
	 * 删除
	 * 查询订单
	 * 计算订单金额
	 * 修改订单金额
	 * 2016年6月15日下午5:07:36 
	 * @author mxc  
	 *  @return
	 */
	public String  execute() {
		
		//查询订单明细对象
		GoodsOrderDetail detail = esaleService.findGoodsOrderDetail(id);
		
		goodsOrder= esaleService.findGoodsOrder(detail.getOrderId());
		
		//计算金额
		BigDecimal bd1 = new BigDecimal(goodsOrder.getTotalMoney());
		
		BigDecimal bd2 = new BigDecimal(detail.getSubMoney());
		
		BigDecimal bd3 = bd1.subtract(bd2);
		
		//设置金额
		goodsOrder.setTotalMoney(bd3.toString());
		
		//修改订单金额
		esaleService.updateGoodsOrder(goodsOrder);
		
		//删除订单明细
		esaleService.deleteGoodsOrderDetail(detail);
		
		try {
			message= URLEncoder.encode("删除订单明细成功！","utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "success";
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public EsaleService getEsaleService() {
		return esaleService;
	}
	public void setEsaleService(EsaleService esaleService) {
		this.esaleService = esaleService;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public GoodsOrder getGoodsOrder() {
		return goodsOrder;
	}
	public void setGoodsOrder(GoodsOrder goodsOrder) {
		this.goodsOrder = goodsOrder;
	}
	
	
	
	
	
}
