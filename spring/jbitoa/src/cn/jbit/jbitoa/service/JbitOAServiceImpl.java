package cn.jbit.jbitoa.service;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import cn.jbit.jbitoa.dao.JbitOADao;
import cn.jbit.jbitoa.entity.CheckResult;
import cn.jbit.jbitoa.entity.ClaimVoucher;
import cn.jbit.jbitoa.entity.ClaimVoucherDetail;
import cn.jbit.jbitoa.entity.Department;
import cn.jbit.jbitoa.entity.Dictionary;
import cn.jbit.jbitoa.entity.Employee;
import cn.jbit.jbitoa.entity.Position;
/**
 * 将会织入事务的代码
 * TODO 此类专门用于事务控制
 * @author mxc  
 * @date 2016年6月13日 下午12:19:09    
 *
 */
public class JbitOAServiceImpl implements Serializable, JbitOAService {

	protected JbitOADao jbitOADao =null;

	
	public JbitOADao getJbitOADao() {
		return jbitOADao;
	}

	public void setJbitOADao(JbitOADao jbitOADao) {
		this.jbitOADao = jbitOADao;
	}

	@Override
	public Employee findEmployee(String employeeSN) {
		// TODO Auto-generated method stub
		return jbitOADao.findEmployee(employeeSN);
	}

	@Override
	public void saveEmployee(Employee employee) {
		// TODO Auto-generated method stub
		jbitOADao.saveEmployee(employee);
	}

	@Override
	public void updateEmployee(Employee employee) {
		// TODO Auto-generated method stub
		jbitOADao.udapteEmployee(employee);
	}

	@Override
	public void saveClaimVoucher(ClaimVoucher claimVoucher) {
		// TODO Auto-generated method stub
		jbitOADao.saveClaimVoucher( claimVoucher);
	}

	@Override
	public Position findPosition(Integer positionId) {
		// TODO Auto-generated method stub
		return jbitOADao.findPosition(positionId);
	}

	@Override
	public List<Dictionary> queryDictionary(Map<String, Object> queryParam) {
		// TODO Auto-generated method stub
		return jbitOADao.queryDictionary(queryParam);
	}

	@Override
	public Department findDepartment(Integer departmentId) {
		// TODO Auto-generated method stub
		return jbitOADao.findDepartmen(departmentId);
	}

	@Override
	public void submitClaimVoucher(ClaimVoucher claimVoucher, List<ClaimVoucherDetail> detaileList) {
		// TODO Auto-generated method stub
		jbitOADao.submitClaimVoucher(claimVoucher,detaileList);
	}

	@Override
	public ClaimVoucher findClaimVoucher(Long id) {
		// TODO Auto-generated method stub
		return jbitOADao.findfindClaimVoucher(id);
	}

	@Override
	public List<ClaimVoucherDetail> queryClaimVoucherDetail(Long id) {
		// TODO Auto-generated method stub
		return jbitOADao.queryClaimVoucherDetail(id);
	}

	@Override
	public List<CheckResult> queryCheckResult(Map<String, Object> queryParam) {
		// TODO Auto-generated method stub
		return jbitOADao.queryCheckResult(queryParam);
	}

	@Override
	public Object[] queryPaginactionClaimVoucher(Map<String, Object> queryParamMap, Integer pageIndex,
			Integer pageSize) {
		
		return jbitOADao.queryPaginationClaimVoucher(queryParamMap, pageIndex, pageSize);
	}
	
	
}
