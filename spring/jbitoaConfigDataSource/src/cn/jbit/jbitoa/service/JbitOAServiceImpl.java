package cn.jbit.jbitoa.service;

import java.io.Serializable;


import cn.jbit.jbitoa.dao.JbitOADao;
import cn.jbit.jbitoa.entity.ClaimVoucher;
import cn.jbit.jbitoa.entity.Employee;
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
	
	
}
