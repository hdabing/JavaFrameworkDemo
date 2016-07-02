package cn.jbit.dome.dao;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.mhsdk.sdk.utils.database.ResultRowEvent;

import cn.jbit.dome.entity.Employee;
/**
 * 数据操作类
 * @author mxc  
 * @date 2016年6月30日 下午10:09:49
 */
@Repository("employeeDao")
public class EmployeeDao implements Serializable {

	@Autowired
	@Qualifier("jdbcTemplate")
	protected JdbcTemplate jdbcTemplate =null;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	/**
	 * 查询员工
	 * 通过id
	 * @author mxc  
	 * @Date 2016年6月30日下午10:21:44
	 *  @param id
	 *  @return
	 */
	public Employee findEmployee(int id) {
		Employee employee =  jdbcTemplate.queryForObject("select * from employee where id =?", new Object[]{id},new RowMapper<Employee>(){

			@Override
			public Employee mapRow(ResultSet resultSet, int resultIndex) throws SQLException {
				Employee	employee= new Employee();
				employee.setAge(resultSet.getInt("age"));
				employee.setDept(resultSet.getString("dept"));
				employee.setId(resultSet.getInt("id"));
				employee.setSex(resultSet.getString("sex"));
				employee.setTrueName(resultSet.getString("true_name"));
				return employee;
			}
			
		});
		return employee;
	}
	
	
}
