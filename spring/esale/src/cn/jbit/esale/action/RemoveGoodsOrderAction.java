package cn.jbit.esale.action;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;

import cn.jbit.esale.entity.GoodsOrder;
import cn.jbit.esale.entity.GoodsOrderDetail;
import cn.jbit.esale.service.EsaleService;
/**
 * 删除订单
 * @author mxc  
 * @date 2016年6月15日 下午4:27:48
 */
public class RemoveGoodsOrderAction implements Serializable {

	//订单id 
	protected Integer id  =null;
	
	protected EsaleService esaleService= null;
	
	protected String message = null;
	
	/**
	 * 根据id删除订单
	 * 查询出 订单
	 * 查询订单明细表
	 * 删除订单对象 订单明细
	 * 2016年6月15日下午4:28:10 
	 * @author mxc  
	 *  @return
	 */
	public String execute(){
		//查询订单
		GoodsOrder goodsOrder = esaleService.findGoodsOrder(id);
		
		//查询订单详细
		List<GoodsOrderDetail> details = esaleService.queryGoodsOrderDetail(id);
		
		//删除订单
		esaleService.deleteGoodsOrder(goodsOrder, details);
		
		try {
			message = URLEncoder.encode("删除成功！","utf-8");
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
	
	
}
