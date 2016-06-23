package cn.jbit.jbitoa.action.claim_voucher;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.jbit.jbitoa.entity.CheckResult;
import cn.jbit.jbitoa.entity.ClaimVoucher;
import cn.jbit.jbitoa.entity.ClaimVoucherDetail;
import cn.jbit.jbitoa.entity.Employee;
import cn.jbit.jbitoa.service.JbitOAService;

/**
 * 显示报销单 及明细
 * @author mxc  
 * @date 2016年6月21日 下午2:08:50
 */
public class ShowAction implements Serializable {

	protected JbitOAService jbitOAService = null;
	
	//报销单记录id
	protected Long id = null;
	
	//报销单明细记录
	protected List<ClaimVoucherDetail> details = null;
	
	//报销单 
	protected ClaimVoucher claimVoucher= null;
	
	//报销人
	protected Employee employee = null;
	
	//审核记录列表
	protected List<CheckResult> checkResults = null;
	
	//审核记录对应的审核人
	protected Map<CheckResult, Employee> checkEmployeeMap = null;
	
	/**
	 * 业务实现
	 * 1. 查询报销单对象
	 * 2. 查询报销人
	 * 2016年6月21日下午2:11:54 
	 * @author mxc  
	 *  @return
	 */
	public String execute() {
		
		//查询报销单
		claimVoucher = jbitOAService.findClaimVoucher(id);
		
		//查询报销人
		if (claimVoucher!=null) {
			employee= jbitOAService.findEmployee(claimVoucher.getCreateSn());
			
			//查询报销单明细记录表
			details = jbitOAService.queryClaimVoucherDetail( claimVoucher.getId());
			
			//查询审核记录
			
			//查询参数
			Map<String, Object> queryParam = new HashMap<String, Object>();
			
			queryParam.put("sheetType", "报销单");
			queryParam.put("sheetId", id);
			
			checkResults = jbitOAService.queryCheckResult(queryParam);
			
			//审核记录对应的审核人
			if (checkResults!=null&&checkResults.size()>0) {
				
				//创建集合
				checkEmployeeMap = new HashMap<CheckResult, Employee>();
				
				//为每个审核记录匹配审核人
				for (CheckResult checkResult : checkResults) {
					//审核人
					Employee checkEmployee = jbitOAService.findEmployee(checkResult.getCheckSn());
				
					//放入集合中
					checkEmployeeMap.put(checkResult, checkEmployee);
				}
			}
		}
		
		
		
		
		return "success";
	}
	
	
	

	public Employee getEmployee() {
		return employee;
	}




	public void setEmployee(Employee employee) {
		this.employee = employee;
	}




	public List<CheckResult> getCheckResults() {
		return checkResults;
	}




	public void setCheckResults(List<CheckResult> checkResults) {
		this.checkResults = checkResults;
	}




	public Map<CheckResult, Employee> getCheckEmployeeMap() {
		return checkEmployeeMap;
	}




	public void setCheckEmployeeMap(Map<CheckResult, Employee> checkEmployeeMap) {
		this.checkEmployeeMap = checkEmployeeMap;
	}




	public JbitOAService getJbitOAService() {
		return jbitOAService;
	}

	public void setJbitOAService(JbitOAService jbitOAService) {
		this.jbitOAService = jbitOAService;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id; 
	}

	public List<ClaimVoucherDetail> getDetails() {
		return details;
	}

	public void setDetails(List<ClaimVoucherDetail> details) {
		this.details = details;
	}

	public ClaimVoucher getClaimVoucher() {
		return claimVoucher;
	}

	public void setClaimVoucher(ClaimVoucher claimVoucher) {
		this.claimVoucher = claimVoucher;
	}

	
	
}
