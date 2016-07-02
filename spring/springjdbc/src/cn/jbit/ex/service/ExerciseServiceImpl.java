package cn.jbit.ex.service;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import cn.jbit.ex.dao.ExerciseDao;
import cn.jbit.ex.entity.Employee;

public class ExerciseServiceImpl implements Serializable, ExerciseService {

	//Dao
	protected ExerciseDao exerciseDao = null;

	@Override
	public Employee findEmployee(int i) {
		
		return exerciseDao.findEmployee(i);
	}

	public ExerciseDao getExerciseDao() {
		return exerciseDao;
	}

	public void setExerciseDao(ExerciseDao exerciseDao) {
		this.exerciseDao = exerciseDao;
	}

	@Override
	public List<Employee> queryEmployee(Map<String, Object> queryParam) {
		
		return exerciseDao.queryEmployee(queryParam);
	}

	@Override
	public String findEmployeeByProcedure(Map<String, Object> queryParam) {
		
		return exerciseDao.findEmployeeByProcedure(queryParam);
	}

	@Override
	public List<Employee> findAllEmployee() {
		
		return exerciseDao.findAllEmployee();
	}

	@Override
	public int updateEmployee(Employee employee) {
		
		return exerciseDao.updateEmployee(employee);
	}
	
	
}
