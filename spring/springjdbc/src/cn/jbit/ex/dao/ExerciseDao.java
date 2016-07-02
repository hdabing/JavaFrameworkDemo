package cn.jbit.ex.dao;

import java.io.Serializable;
import java.sql.CallableStatement;
import java.sql.Connection;
/**
 * 员工数据操作
 * @author mxc  
 * @date 2016年6月30日 下午4:15:38
 */
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.CallableStatementCallback;
import org.springframework.jdbc.core.CallableStatementCreator;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowMapper;

import cn.jbit.ex.entity.Employee;
public class ExerciseDao implements Serializable {

	protected JdbcTemplate jdbcTemplate = null;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	/**
	 * 查询员工呢
	 * 根据id
	 *  
	 * @author mxc  
	 * @Date 2016年6月30日下午4:44:16
	 *  @param i
	 *  @return
	 */
	public Employee findEmployee(int id) {
		
		
		//第一种方法
		List<Employee> employees= jdbcTemplate.query("select * from employee where id=?", new Object[]{id}, new RowMapper<Employee>(){

			@Override
			public Employee mapRow(ResultSet resultSet, int rowIndex) throws SQLException {
				Employee employee= new Employee();
				employee.setAge(resultSet.getInt("age"));
				employee.setDepartment(resultSet.getString("department"));
				employee.setId(resultSet.getInt("id"));
				employee.setSex(resultSet.getString("sex"));
				employee.setTrueName(resultSet.getString("true_name"));
				return employee;
			}
			
		});
		
		//第二种方法
		/* Employee employee=  jdbcTemplate.queryForObject("select * from employee where id =1", new RowMapper<Employee>(){

			@Override
			public Employee mapRow(ResultSet resultSet, int rowIndex) throws SQLException {
					Employee employee= new Employee();
					employee.setAge(resultSet.getInt("age"));
					employee.setDepartment(resultSet.getString("department"));
					employee.setId(resultSet.getInt("id"));
					employee.setSex(resultSet.getString("sex"));
					employee.setTrueName(resultSet.getString("true_name"));
					return employee;
			}
			
		});*/
		return employees.get(0);
	}

	/**
	 * 根据条件查询 员工
	 *  
	 * @author mxc  
	 * @Date 2016年7月1日上午8:53:19
	 *  @param queryParam
	 *  @return
	 */
	public List<Employee> queryEmployee(Map<String, Object> queryParam) {
		
		//员工列表
	final	List<Employee> employees =new ArrayList<Employee>();
		
		//sql语句
		StringBuffer sbBuffer = new StringBuffer();
		sbBuffer.append("select * from employee e where 1=1 ");
		
		//参数列表
		List<Object> paramValueLsit = new ArrayList<Object>();
		
		if (queryParam.get("department")!=null) {
			sbBuffer.append(" and e.department like ?");
			paramValueLsit.add(queryParam.get("department"));
		}
		
		if (queryParam.get("maxAge")!=null) {
			sbBuffer.append(" and e.age <= ?");
			paramValueLsit.add(queryParam.get("maxAge"));
		}
		
		if (queryParam.get("minAge")!=null) {
			sbBuffer.append(" and e.age >= ?");
			paramValueLsit.add(queryParam.get("minAge"));
		}
		
		//SQL 
		String sql = sbBuffer.toString();
		
		//参数数组
		Object[] objects = new Object[paramValueLsit.size()];
		paramValueLsit.toArray(objects);
		
		
		jdbcTemplate.query(sql,  objects,new RowCallbackHandler(){

			/**
			 * 该方法没有数据是不会执行的
			 * @author mxc
			 * 2016年7月1日上午9:06:56   
			 * @param rs
			 * @throws SQLException
			 */
			@Override
			public void processRow(ResultSet rs) throws SQLException {
				//必须使用do-while  因为指针 开始就指向了第一条数据
				do{
					Employee  employee= new Employee();
					employee.setAge(rs.getInt("age"));
					employee.setDepartment(rs.getString("department"));
					employee.setId(rs.getInt("id"));
					employee.setSex(rs.getString("sex"));
					employee.setTrueName(rs.getString("true_name"));
					
					employees.add(employee);
				}while(rs.next());
			}
			
		});
		
		return employees;
	}

	/**
	 * 查询员工 
	 * 根据条件
	 *  调用存储过程
	 * @author mxc  
	 * @Date 2016年7月1日上午10:13:24
	 *  @param queryParam
	 *  @return
	 */
	public String findEmployeeByProcedure(final Map<String, Object> queryParam) {
		String trueName = jdbcTemplate.execute(new CallableStatementCreator() {
			
				@Override
				public CallableStatement createCallableStatement(Connection conn) throws SQLException {
					String storeProc = "{call findEmployee(?,?,?,?)}";
					CallableStatement cs = conn.prepareCall(storeProc);
					cs.setString(1, (String)queryParam.get("department"));
					cs.setInt(2, (Integer)queryParam.get("minAge"));
					cs.setInt(3, (Integer)queryParam.get("maxAge"));
					cs.setString(4, (String)queryParam.get("trueName1"));
					cs.registerOutParameter(4, Types.VARBINARY);
					return cs;
				}
			},new CallableStatementCallback<String>() {

				@Override
				public String doInCallableStatement(CallableStatement cs) throws SQLException, DataAccessException {
					 cs.execute();
					return cs.getString(4) ;
				}
		});
		return trueName;
	}

	/**
	 * 查询全部员工
	 *  
	 * @author mxc  
	 * @Date 2016年7月2日下午4:54:22
	 *  @return
	 */
	public List<Employee> findAllEmployee() {
		
		//sql语句
		String sql = "select * from employee";
		
		List<Employee> employees = jdbcTemplate.query(sql,new RowMapper<Employee>(){

			@Override
			public Employee mapRow(ResultSet rs, int rowIndex) throws SQLException {
				Employee employee = new Employee();
				employee.setAge(rs.getInt("age"));
				employee.setDepartment(rs.getString("department"));
				employee.setId(rs.getInt("id"));
				employee.setSex(rs.getString("sex"));
				employee.setTrueName(rs.getString("true_name"));
				return employee;
			}
			
		});
		
		return employees;
	}

	/**
	 * 修改员工信息返回受影响行数
	 *  
	 * @author mxc  
	 * @Date 2016年7月2日下午5:19:12
	 *  @param employee
	 *  @return
	 */
	public int updateEmployee(Employee employee) {
		//增删与之类似
		String sql ="update employee set age = ? where id =?";
		int result =jdbcTemplate.update(sql, new Object[]{employee.getAge(),employee.getId()});
		return result;
	}
	
	
	
}
