package cn.jbit.esale.action;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Date;

import org.apache.commons.lang.ObjectUtils.Null;

import cn.jbit.esale.entity.GoodsOrder;
import cn.jbit.esale.entity.GoodsOrderDetail;
import cn.jbit.esale.service.EsaleService;
/**
 * 提交订单Action
 * @author mxc  
 * @date 2016年6月15日 上午11:08:24
 */
public class SubmitGoodsORderAction implements Serializable {

	//业务对象
	protected EsaleService esaleService = null;
	
	//订单
	protected GoodsOrder goodsOrder = null;
	
	//消息
	protected String message = null;
	
	//验证结果
	protected boolean verifyResult =true;
	
	public String execute() {
		
		if (goodsOrder==null) {
			verifyResult=false;
			message="请提交表单数据";
			
		}else if (goodsOrder.getCode()==null||goodsOrder.getCode().equals("")) {
			verifyResult=false;
			message="订单编号不能为空";
		}
		
		//验证订单编号是否存在
		if (verifyResult) {
			
			//找寻订单
			GoodsOrder goodsOrderDB = esaleService.findGoodsOrder(goodsOrder.getCode());
			
			if (goodsOrderDB==null) {
				verifyResult=false;
				message="订单编号重复";
			}
		}
		
		//验证不通过
		if (verifyResult) {
			return "input";
		}
		
		//设置订单提交时间
		goodsOrder.setSubmitTime(new Date());
		
		//提交订单
		esaleService.submitGoodsOrder(goodsOrder);
		
		//消息
		try {
			message= URLEncoder.encode("订单提交成功！", "utf-8");
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

	public GoodsOrder getGoodsOrder() {
		return goodsOrder;
	}

	public void setGoodsOrder(GoodsOrder goodsOrder) {
		this.goodsOrder = goodsOrder;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public boolean isVerifyResult() {
		return verifyResult;
	}

	public void setVerifyResult(boolean verifyResult) {
		this.verifyResult = verifyResult;
	}
	
	
}
