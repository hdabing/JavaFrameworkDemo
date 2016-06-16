package cn.jbit.esale.action;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.jbit.esale.entity.GoodsOrder;
import cn.jbit.esale.service.EsaleService;
/**
 * 分页查询订单
 * @author mxc  
 * @date 2016年6月16日 上午9:32:03
 */
public class QueryGoodsOrderAction implements Serializable {

	protected EsaleService esaleService = null;
	
	//页面序号
	protected Integer pageIndex= null;
	
	//页面尺寸
	protected Integer pageSize = null;
	
	//查条件 ：订单编号
	protected String code = null;
	
	//查询条件：客户姓名
	protected String trueName = null;
	
	//电话号码
	protected String phone = null;
	
	//总记录数
	protected Integer totalRecord = null;
	
	//总页数
	protected Integer totalPage = null;
	
	//当前页列表
	protected List<GoodsOrder > goodsOrders = null;
	
	//url参数
	protected String urlParam = null;
	
	/**
	 * 业务实现
	 * 2016年6月16日上午9:37:55 
	 * @author mxc  
	 *  @return
	 */
	public String execute(){
		
		//验证当前页
		if (pageIndex==null||pageIndex<=0) {
			pageIndex=1;
		}
		//验证页面尺寸
		if (pageSize==null||pageSize<=0) {
			pageSize=10;
		}
		
		//封装查询条件
		Map<String, Object> queryParamMap = new HashMap<String, Object>();
		
		//url参数拼接
		StringBuffer strUrl = new StringBuffer();
		
		if (code!=null) {
			queryParamMap.put("code", code);
			strUrl.append("&code="+code);
		}
		if (trueName!=null) {
			try {
				trueName= new String(trueName.getBytes("iso-8859-1"),"utf-8");
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			queryParamMap.put("trueName", trueName);
			strUrl.append("&trueName="+trueName);
		}
		if (phone!=null) {
			queryParamMap.put("phone", phone);
			strUrl.append("&phone="+phone);
		}
		
		//并入url参数
		urlParam= strUrl.toString();
		
		//执行查询 获取结果
		Object[] aryPagination = esaleService.queryPaginationGoodsOrder(queryParamMap,pageIndex,pageSize);
		
		//总记录数
		totalRecord = (Integer) aryPagination[0];
		
		//总页数
		totalPage = (totalRecord%pageSize==0)?totalRecord/pageSize:totalRecord/pageSize+1;
		
		//当前页列表
		goodsOrders= (List<GoodsOrder>) aryPagination[1];
		
		
		
		return "success";
	}

	public EsaleService getEsaleService() {
		return esaleService;
	}

	public void setEsaleService(EsaleService esaleService) {
		this.esaleService = esaleService;
	}

	public Integer getPageIndex() {
		return pageIndex;
	}

	public void setPageIndex(Integer pageIndex) {
		this.pageIndex = pageIndex;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getTrueName() {
		return trueName;
	}

	public void setTrueName(String trueName) {
		this.trueName = trueName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Integer getTotalRecord() {
		return totalRecord;
	}

	public void setTotalRecord(Integer totalRecord) {
		this.totalRecord = totalRecord;
	}

	public Integer getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}

	public List<GoodsOrder> getGoodsOrders() {
		return goodsOrders;
	}

	public void setGoodsOrders(List<GoodsOrder> goodsOrders) {
		this.goodsOrders = goodsOrders;
	}

	public String getUrlParam() {
		return urlParam;
	}

	public void setUrlParam(String urlParam) {
		this.urlParam = urlParam;
	}
	
	}
