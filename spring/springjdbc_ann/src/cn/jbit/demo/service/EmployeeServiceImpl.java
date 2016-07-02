package cn.jbit.demo.service;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.jbit.dome.dao.EmployeeDao;
import cn.jbit.dome.entity.Employee;

@Service("employeeService")
public class EmployeeServiceImpl implements Serializable ,EmployeeService {

	@Autowired
	@Qualifier("employeeDao")
	protected EmployeeDao employeeDao = null;

	public EmployeeDao getEmployeeDao() {
		return employeeDao;
	}

	public void setEmployeeDao(EmployeeDao employeeDao) {
		this.employeeDao = employeeDao;
	}

	@Override
	@Transactional(readOnly=true)
	public Employee findEmployee(int id) {
		
		return employeeDao.findEmployee(id);
	}
	
	
}
