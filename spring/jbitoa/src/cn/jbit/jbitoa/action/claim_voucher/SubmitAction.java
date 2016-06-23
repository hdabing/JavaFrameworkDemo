package cn.jbit.jbitoa.action.claim_voucher;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.print.DocFlavor.STRING;

import org.apache.catalina.connector.ClientAbortException;

import cn.jbit.jbitoa.entity.ClaimVoucher;
import cn.jbit.jbitoa.entity.ClaimVoucherDetail;
import cn.jbit.jbitoa.entity.Department;
import cn.jbit.jbitoa.entity.Employee;
import cn.jbit.jbitoa.service.JbitOAService;

/**
 * 提交报销单
 * @author mxc  
 * @date 2016年6月21日 下午12:26:04
 */
public class SubmitAction implements Serializable {

	protected JbitOAService jbitOAService = null;
	
	//报销单
	protected ClaimVoucher claimVoucher = null;
	
	//报销项目
	protected String item[]  = null;
	
	//报销金额
	protected String [] account =null;
	
	//报销描述
	protected String[] desc = null;
	
	//消息
	protected String message = null;
	
	/**
	 * 首先找到报销人员工记录
	 * 2016年6月21日下午1:38:15 
	 * @author mxc  
	 *  @return
	 */
	public String execute(){
		
		//找寻报销人员工记录
		Employee employee = jbitOAService.findEmployee(claimVoucher.getCreateSn());
		
		//员工部门
		Department department = jbitOAService.findDepartment(employee.getDepartmentId());
		
		//设置下一个处理人 部门经理
		claimVoucher.setNextDealSn(department.getManagerSn());
		
		//设置创建时间
		claimVoucher.setCreateTime(new Date());
		
		//报销明细总计金额
		String totalAccount ="0.00";
		
		//报销明细列表
		List<ClaimVoucherDetail> detaileList = null;
		
		if (item!=null&&item.length>0) {
			//创建列表对象
			detaileList= new ArrayList<ClaimVoucherDetail>();
			//创建每一个报销明细记录
			for (int i = 0; i < item.length; i++) {
				//创建明细记录
				ClaimVoucherDetail detail = new ClaimVoucherDetail();
				detail.setItem(item[i]);
				detail.setAccount(account[i]);
				detail.setDesc(desc[i]);
				//加入到列表
				detaileList.add(detail);
				
				//计算总金额
				BigDecimal bd1 = new BigDecimal(totalAccount);
				BigDecimal bd2 = new BigDecimal(account[i]);
				bd1= bd1.add(bd2);
				totalAccount=bd1.toString();
			}
		}
		
		//报销总金额
		claimVoucher.setTotalAccount(totalAccount);
		
		//提交报销单
		jbitOAService.submitClaimVoucher(claimVoucher,detaileList);
		
		//消息
		try {
			message= URLEncoder.encode("报销单提交成功，等待审批", "utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "success";
	}

	public JbitOAService getJbitOAService() {
		return jbitOAService;
	}

	public void setJbitOAService(JbitOAService jbitOAService) {
		this.jbitOAService = jbitOAService;
	}

	public ClaimVoucher getClaimVoucher() {
		return claimVoucher;
	}

	public void setClaimVoucher(ClaimVoucher claimVoucher) {
		this.claimVoucher = claimVoucher;
	}

	public String[] getItem() {
		return item;
	}

	public void setItem(String[] item) {
		this.item = item;
	}

	public String[] getAccount() {
		return account;
	}

	public void setAccount(String[] account) {
		this.account = account;
	}

	public String[] getDesc() {
		return desc;
	}

	public void setDesc(String[] desc) {
		this.desc = desc;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
