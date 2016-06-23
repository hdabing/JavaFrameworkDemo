package cn.jbit.jbitoa.action.claim_voucher;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;

import cn.jbit.jbitoa.entity.ClaimVoucher;
import cn.jbit.jbitoa.entity.Employee;
import cn.jbit.jbitoa.service.JbitOAService;

/**
 * 查询我的报销单
 * 
 * @author mxc
 * @date 2016年6月22日 下午2:05:39
 */
public class QueryMyAction implements Serializable, ServletRequestAware {

	protected JbitOAService jbitOAService = null;

	protected HttpServletRequest request = null;
	
	//页面序号
	protected Integer pageIndex = null;

	//页面尺寸
	protected Integer pageSize = null;
	
	//单号
	protected Long id = null;
	
	//事件
	protected String event = null;
	
	//状态
	protected String status = null;
	
	//创建时间
	protected Date createTime1 = null;
	
	
	//创建时间
	protected Date createTime2 = null;
	
	//总记录数
	protected Integer  totalRecord = null;
	
	//总页数
	protected Integer totalPage = null;
	
	//当前页列表
	protected List<ClaimVoucher > claimVouchers = null;
	
	//url参数
	protected String urlParam = null;
	
	//报销单提交人
	protected Map<ClaimVoucher, Employee> claimVoucherCreateEmployeeMap= null;
	
	
	/**
	 * 业务实现
	 * 
	 * @author mxc
	 * @Date 2016年6月22日下午2:06:01
	 * @return
	 */
	public String execute(){
		
		if (pageIndex==null||pageIndex<=0) {
			pageIndex=1;
		}
		
		
		if (pageSize==null||pageSize<=0) {
			pageSize=5;
		}
		
		//查询条件封装
		Map<String,Object> queryParamMap = new HashMap<String, Object>();
		
		StringBuffer sBuffer = new StringBuffer();
		
		if (id!=null) {
			queryParamMap.put("id", id);
			sBuffer.append("&id="+id);
		}

		if (event!=null) {
			
			try {
				event= new String(event.getBytes("iso-8859-1"), "utf-8");
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			queryParamMap.put("event", event);
			sBuffer.append("&event="+event);
		}
		
		if (status!=null) {
			
			try {
				status= new String(status.getBytes("iso-8859-1"), "utf-8");
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			queryParamMap.put("status", status);
			sBuffer.append("&status="+status);
		}
		
		//创建时间
		if (createTime1!=null&&createTime2!=null) {
			queryParamMap.put("createTime1", createTime1);
			queryParamMap.put("createTime2", createTime2);
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			
			sBuffer.append("&createTime1="+createTime1+"&createTime2="+createTime2);
		}
		
		String currentSn = (String) request.getSession().getAttribute("currentSn");
		
		//报销单提交人
		queryParamMap.put("createSn", currentSn);
		
		//url  参数
		sBuffer.append("&createSn="+currentSn);
		
		urlParam=sBuffer.toString();
		
		//分页查询
		Object[] aryPagination =jbitOAService.queryPaginactionClaimVoucher(queryParamMap,pageIndex,pageSize);
		
		//总页数
		totalRecord= (Integer) aryPagination[0];
		
		totalPage= (totalRecord%pageSize==0)?totalRecord/pageSize:totalRecord/pageSize+1;
		
		//当前页列表
		claimVouchers= (List<ClaimVoucher>) aryPagination[1];
		
		
		//查询报销单审核人
		if (claimVouchers!=null&&claimVouchers.size()>0) {
			claimVoucherCreateEmployeeMap= new HashMap<ClaimVoucher, Employee>();
			
			//查询提交人
			for (ClaimVoucher claimVoucher : claimVouchers) {
				Employee employee= jbitOAService.findEmployee(claimVoucher.getCreateSn());
				
				claimVoucherCreateEmployeeMap.put(claimVoucher, employee);
			}
		}
		
		return "success";
	}
	

	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}

	public JbitOAService getJbitOAService() {
		return jbitOAService;
	}

	public void setJbitOAService(JbitOAService jbitOAService) {
		this.jbitOAService = jbitOAService;
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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEvent() {
		return event;
	}

	public void setEvent(String event) {
		this.event = event;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getCreateTime1() {
		return createTime1;
	}

	public void setCreateTime1(Date createTime1) {
		this.createTime1 = createTime1;
	}

	public Date getCreateTime2() {
		return createTime2;
	}

	public void setCreateTime2(Date createTime2) {
		this.createTime2 = createTime2;
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

	public List<ClaimVoucher> getClaimVouchers() {
		return claimVouchers;
	}

	public void setClaimVouchers(List<ClaimVoucher> claimVouchers) {
		this.claimVouchers = claimVouchers;
	}

	public String getUrlParam() {
		return urlParam;
	}

	public void setUrlParam(String urlParam) {
		this.urlParam = urlParam;
	}


	public Map<ClaimVoucher, Employee> getClaimVoucherCreateEmployeeMap() {
		return claimVoucherCreateEmployeeMap;
	}


	public void setClaimVoucherCreateEmployeeMap(Map<ClaimVoucher, Employee> claimVoucherCreateEmployeeMap) {
		this.claimVoucherCreateEmployeeMap = claimVoucherCreateEmployeeMap;
	}

	
	
	
}
