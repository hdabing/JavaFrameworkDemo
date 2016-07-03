package cn.jbit.ex.service;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import cn.jbit.ex.dao.ExerciseDao;
import cn.jbit.ex.entity.ClaimVoucher;

public class ExerciseServiceImpl implements Serializable,ExerciseService {

	//dao实现类
	protected ExerciseDao exerciseDao  = null;

	public ExerciseDao getExerciseDao() {
		return exerciseDao;
	}

	public void setExerciseDao(ExerciseDao exerciseDao) {
		this.exerciseDao = exerciseDao;
	}

	@Override
	public List<ClaimVoucher> queryClaimVoucher(Map<String, Object> queryParams) {
		
		return exerciseDao.queryClaimVoucher(queryParams);
	}

	@Override
	public void saveClaimVoucher(ClaimVoucher claimVoucher) {
		exerciseDao.saveClaimVoucher(claimVoucher);
	}

	@Override
	public ClaimVoucher findClaimVoucher(Map<String, Object> queryParams) {
		ClaimVoucher claimVoucher = exerciseDao.findClaimVoucher(queryParams);
		return claimVoucher;
	}
	
	
}
