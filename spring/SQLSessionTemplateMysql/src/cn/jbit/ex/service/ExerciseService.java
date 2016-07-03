package cn.jbit.ex.service;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import cn.jbit.ex.entity.ClaimVoucher;
/**
 * 声明式事务接口
 * @author mxc  
 * @date 2016年7月1日 下午3:28:06
 */
public interface ExerciseService extends Serializable {

	/**
	 * 查询报销单 
	 * 根据条件
	 *  
	 * @author mxc  
	 * @Date 2016年7月1日下午3:43:19
	 *  @param queryParams
	 *  @return
	 */
	List<ClaimVoucher> queryClaimVoucher(Map<String, Object> queryParams);

	/**
	 * 保存报销单那
	 *  
	 * @author mxc  
	 * @Date 2016年7月1日下午4:51:01
	 *  @param claimVoucher
	 */
	void saveClaimVoucher(ClaimVoucher claimVoucher);

	/**
	 * 根据id查询报销单
	 *  
	 * @author mxc  
	 * @Date 2016年7月3日下午3:06:46
	 *  @param i
	 *  @return
	 */
	ClaimVoucher findClaimVoucher(Map<String, Object> queryParams);

	
}
