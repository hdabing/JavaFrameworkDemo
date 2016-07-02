package cn.jbit.ex.service;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import cn.jbit.ex.entity.Employee;
/**
 * 业务接口 织入声明式事务
 * @author mxc  
 * @date 2016年6月30日 下午4:18:53
 */
public interface ExerciseService extends Serializable {

	/**
	 * 查询员工
	 *  
	 * @author mxc  
	 * @Date 2016年6月30日下午4:43:27
	 *  @param i
	 *  @return
	 */
	Employee findEmployee(int i);

	/**
	 * 根据条件查询
	 *  
	 * @author mxc  
	 * @Date 2016年7月1日上午8:50:48
	 *  @param queryParam
	 *  @return
	 */
	List<Employee> queryEmployee(Map<String, Object> queryParam);

	/**
	 * 查询员工
	 * 根据条件
	 * 通过存储过程
	 *  
	 * @author mxc  
	 * @Date 2016年7月1日上午10:11:55
	 *  @param queryParam
	 *  @return
	 */
	String findEmployeeByProcedure(Map<String, Object> queryParam);

	/**
	 * 查询全部员工
	 *  
	 * @author mxc  
	 * @Date 2016年7月2日下午4:53:55
	 *  @return
	 */
	List<Employee> findAllEmployee();

	/**
	 * 修改员工信息
	 *  
	 * @author mxc  
	 * @Date 2016年7月2日下午5:18:34
	 *  @param employee
	 *  @return
	 */
	int updateEmployee(Employee employee);

}
