package cn.jbit.demo.dao;

import java.io.Serializable;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import cn.jbit.demo.entity.Employee;

@Repository
public class EmployeeDao implements Serializable {

	@Autowired
	@Qualifier("sqlSessionTemplate")
	protected SqlSessionTemplate sqlSessionTemplate = null;

	public SqlSessionTemplate getSqlSessionTemplate() {
		return sqlSessionTemplate;
	}

	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}

	/**
	 * 10.3.1节示例：根据员工编号获取员工信息
	 * 
	 * @param sn
	 * @return
	 */
	public Employee findEmployeeBySN(String sn) {
		Employee emp = (Employee) sqlSessionTemplate.selectOne(
				"cn.jbit.demo.dao.EmployeeDao.findEmployeeBySN", sn);
		return emp;
	}

	/**
	 * 10.3.3节示例：增加员工信息
	 * 
	 * @param emp
	 */
	public void saveEmployee(Employee emp) {
		sqlSessionTemplate.insert("cn.jbit.demo.dao.EmployeeDao.saveEmployee",
				emp);
	}

	/**
	 * 10.3.3节示例：查询全部员工信息
	 * 
	 * @param emp
	 */
	public List<Employee> queryEmployee() {
		List<Employee> empList = sqlSessionTemplate
				.selectList("cn.jbit.demo.dao.EmployeeDao.queryEmployee");
		return empList;
	}

}
