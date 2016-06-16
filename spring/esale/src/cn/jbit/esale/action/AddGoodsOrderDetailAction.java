package cn.jbit.esale.action;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.net.URLEncoder;

import com.sun.xml.internal.messaging.saaj.soap.GifDataContentHandler;

import cn.jbit.esale.entity.GoodsOrder;
import cn.jbit.esale.entity.GoodsOrderDetail;
import cn.jbit.esale.service.EsaleService;
/**
 * 增加 订单明细
 * @author mxc  
 * @date 2016年6月15日 下午3:07:40
 */
public class AddGoodsOrderDetailAction implements Serializable {

	//业务接口
	protected EsaleService esaleService = null;
	
	//订单明细
	protected GoodsOrderDetail detail = null;
	
	//消息
	protected String message = null;
	
	/**
	 * 计算小计金额
	 * 添加 到数据库
	 * 查找订单，并改变其金额
	 * 更新订单总金额
	 * 2016年6月15日下午3:16:07 
	 * @author mxc  
	 *  @return
	 */
	public String execute() {
		
		//计算订单总计金额
		BigDecimal bd1 = new BigDecimal(detail.getPrice());
		BigDecimal bd2 = new BigDecimal(detail.getNum());
		BigDecimal bd3 = bd1.multiply(bd2);
		
		//设置
		detail.setSubMoney(bd3.toString());
		
		//保存
		esaleService.addGoodsOrderDetail(detail);
		
		//查找订单，
		GoodsOrder goodsOrder = esaleService.findGoodsOrder(detail.getOrderId());
		
		//计算订单总金额
		BigDecimal bd4 =  new BigDecimal("0.0");
		if (goodsOrder.getTotalMoney()!=null&&!goodsOrder.equals("")) {
			bd4 =  new BigDecimal(goodsOrder.getTotalMoney());
			
		}
		bd4= bd4.add(bd3);
		
		//设置总金额
		goodsOrder.setTotalMoney(bd4.toString());
		
		//更新订单
		esaleService.updateGoodsOrder(goodsOrder);
		
		try {
			message = URLEncoder.encode("订单明细添加成功！","utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "success";
	}


	public EsaleService getEsaleService() {
		return esaleService;
	}


	public void setEsaleService(EsaleService esaleService) {
		this.esaleService = esaleService;
	}


	public GoodsOrderDetail getDetail() {
		return detail;
	}


	public void setDetail(GoodsOrderDetail detail) {
		this.detail = detail;
	}


	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
	}

	
}
