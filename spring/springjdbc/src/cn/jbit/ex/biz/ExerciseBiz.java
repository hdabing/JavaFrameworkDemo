package cn.jbit.ex.biz;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.jbit.ex.entity.Employee;
import cn.jbit.ex.service.ExerciseService;
/**
 * 业务层 
 * @author mxc  
 * @date 2016年6月30日 下午4:23:16
 */
public class ExerciseBiz implements Serializable {

	protected ExerciseService exerciseService = null;

	public ExerciseService getExerciseService() {
		return exerciseService;
	}

	public void setExerciseService(ExerciseService exerciseService) {
		this.exerciseService = exerciseService;
	}

	/**
	 * 查询员工 
	 * 根据员工id
	 *  
	 * @author mxc  
	 * @Date 2016年6月30日下午4:29:42
	 *  @param i
	 *  @return
	 */
	public Employee findEmployee(int i) {
		
		return exerciseService.findEmployee(i);
	}

	/**
	 * 查询员工
	 * 技术部，年龄在 20-30之间
	 *  
	 * @author mxc  
	 * @Date 2016年7月1日上午8:48:02
	 *  @param string
	 *  @param i
	 *  @param j
	 *  @return
	 */
	public List<Employee> queryEmployee(String dept, int min, int max) {
		//查询参数
		Map<String, Object> queryParam = new HashMap<String, Object>();
		queryParam.put("department", dept);
		queryParam.put("minAge", min);
		queryParam.put("maxAge", max);
		
		List<Employee> employees = exerciseService.queryEmployee(queryParam);
		return employees;
	}

	/**
	 * 查询员工通过存储过程
	 *  
	 * @author mxc  
	 * @Date 2016年7月1日上午10:11:09
	 *  @param string
	 *  @param i
	 *  @param j
	 *  @return
	 */
	public String findEmployeeByProcedure(String department, int min, int max) {
		//查询参数
				Map<String, Object> queryParam = new HashMap<String, Object>();
				queryParam.put("department", department);
				queryParam.put("minAge", min);
				queryParam.put("maxAge", max);
				
				String employees = exerciseService.findEmployeeByProcedure(queryParam);
				
				return employees;
	}

	/**
	 *
	 *  
	 * @author mxc  
	 * @Date 2016年7月2日下午4:52:25
	 */
	public List<Employee> findAllEmployee() {
		return  exerciseService.findAllEmployee();
	}

	/**
	 * 修改员工信息
	 *  
	 * @author mxc  
	 * @Date 2016年7月2日下午5:16:47
	 *  @param employee
	 *  @return
	 */
	public boolean updateEmployee(Employee employee) {
		boolean result =false;
		int count= exerciseService.updateEmployee(employee);
		if (count==1) {
			result=true;
		}
		return result;
	}
	
	
}
