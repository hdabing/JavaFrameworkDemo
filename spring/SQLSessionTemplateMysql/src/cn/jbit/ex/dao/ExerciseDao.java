package cn.jbit.ex.dao;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;

import cn.jbit.ex.entity.ClaimVoucher;
/**
 * 数据操作
 * @author mxc  
 * @date 2016年7月1日 下午2:58:02
 */
public class ExerciseDao implements Serializable {

	//主要练习对象
	private SqlSessionTemplate sqlSessionTemplate = null;

	public SqlSessionTemplate getSqlSessionTemplate() {
		return sqlSessionTemplate;
	}

	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}

	/**
	 * 根据条件查询
	 *  
	 * @author mxc  
	 * @Date 2016年7月1日下午3:50:48
	 *  @param queryParams
	 *  @return
	 */
	public List<ClaimVoucher> queryClaimVoucher(Map<String, Object> queryParams) {
		
		List<ClaimVoucher> claimVouchers = sqlSessionTemplate.selectList("cn.jbit.ex.dao.ExerciseDao.queryClaimVoucher",queryParams);
		
		return claimVouchers;
	}

	/**
	 * 保存报销单
	 *  
	 * @author mxc  
	 * @Date 2016年7月1日下午4:51:42
	 *  @param claimVoucher
	 */
	public void saveClaimVoucher(ClaimVoucher claimVoucher) {
		sqlSessionTemplate.insert("cn.jbit.ex.dao.ExerciseDao.saveClaimVoucher2",claimVoucher);
	}

	/**
	 * 根据id查询
	 *  
	 * @author mxc  
	 * @Date 2016年7月3日下午3:09:00
	 *  @return
	 */
	public ClaimVoucher findClaimVoucher(Map<String, Object> queryParams) {
		/*Map<String, Object> queryParams = new HashMap<String, Object>();
		queryParams.put("id", 1);*/
		return sqlSessionTemplate.selectOne("cn.jbit.ex.dao.ExerciseDao.findClaimVoucher", queryParams);
	}
	
	
	
}
