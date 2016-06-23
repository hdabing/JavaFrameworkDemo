package cn.jbit.jbitoa.service;

import java.io.Serializable;
/**
 * 青鸟办公自动化业务 
 * 定义的方法都会被织入事务  
 * 注意方法名称  决定了织入什么事务
 * TODO 
 * @author mxc  
 * @date 2016年6月13日 下午12:18:28    
 *
 */
import java.util.List;
import java.util.Map;

import cn.jbit.jbitoa.entity.CheckResult;
import cn.jbit.jbitoa.entity.ClaimVoucher;
import cn.jbit.jbitoa.entity.ClaimVoucherDetail;
import cn.jbit.jbitoa.entity.Department;
import cn.jbit.jbitoa.entity.Dictionary;
import cn.jbit.jbitoa.entity.Employee;
import cn.jbit.jbitoa.entity.Position;
public interface JbitOAService extends Serializable {

	/**
	 * 查找员工
	 * TODO
	 * 2016年6月13日下午12:26:02 
	 * @author mxc  
	 *  @param employeeSN
	 *  @return
	 */
	Employee findEmployee(String employeeSN);
	
	/**
	 * 保存员工
	 * TODO
	 * 2016年6月13日下午12:26:21 
	 * @author mxc  
	 *  @param employee
	 */
	void saveEmployee(Employee employee);
	
	/**
	 * 更新员工
	 * TODO
	 * 2016年6月13日下午12:26:47 
	 * @author mxc  
	 *  @param employee
	 */
	void updateEmployee(Employee employee);

	/**
	 * 保存报销单
	 * 2016年6月13日下午5:13:28 
	 * @author mxc  
	 *  @param claimVoucher
	 */
	void saveClaimVoucher(ClaimVoucher claimVoucher);

	/**
	 * 查找职位
	 * 2016年6月20日下午2:10:09 
	 * @author mxc  
	 *  @param positionId
	 *  @return
	 */
	Position findPosition(Integer positionId);

	/**
	 * 查询 字典数据
	 * 2016年6月20日下午3:02:09 
	 * @author mxc  
	 *  @param queryParam
	 *  @return
	 */
	List<Dictionary> queryDictionary(Map<String, Object> queryParam);

	/**
	 * 根据部门id查找部门记录
	 * 2016年6月21日下午1:40:32 
	 * @author mxc  
	 *  @param departmentId
	 *  @return
	 */
	Department findDepartment(Integer departmentId);

	/**
	 * 保存报销单 及明细
	 * 2016年6月21日下午1:51:51 
	 * @author mxc  
	 *  @param claimVoucher
	 *  @param detaileList
	 */
	void submitClaimVoucher(ClaimVoucher claimVoucher, List<ClaimVoucherDetail> detaileList);

	/**
	 * 根据报销单id查询报销单
	 * 2016年6月21日下午2:20:15 
	 * @author mxc  
	 *  @param id
	 *  @return
	 */
	ClaimVoucher findClaimVoucher(Long id);

	/**
	 * 根据报销单记录id查询明细列表
	 * 2016年6月21日下午2:34:44 
	 * @author mxc  
	 *  @param id
	 *  @return
	 */
	List<ClaimVoucherDetail> queryClaimVoucherDetail(Long id);

	/**
	 * 查询审核记录列表
	 * 2016年6月21日下午2:37:50 
	 * @author mxc  
	 *  @param queryParam
	 *  @return
	 */
	List<CheckResult> queryCheckResult(Map<String, Object> queryParam);

	/**
	 * 分页查询我的报销单
	 *  
	 * @author mxc  
	 * @Date 2016年6月22日下午3:07:50
	 *  @param queryParamMap 各种参数 包括 登录人
	 *  @param pageIndex 
	 *  @param pageSize
	 *  @return
	 */
	Object[] queryPaginactionClaimVoucher(Map<String, Object> queryParamMap, Integer pageIndex, Integer pageSize);
}
