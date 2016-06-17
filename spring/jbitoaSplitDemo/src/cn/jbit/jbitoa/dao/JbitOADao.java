package cn.jbit.jbitoa.dao;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Property;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.jbit.jbitoa.entity.ClaimVoucher;
import cn.jbit.jbitoa.entity.Employee;
/**
 * 青鸟办公自动化业务
 * 使用 HIbernateTemplate 简化编码 继承 HIbernateDaoSupport
 * 
 * TODO 
 * @author mxc  
 * @date 2016年6月13日 上午11:44:56    
 *
 */
public class JbitOADao extends HibernateDaoSupport implements Serializable {

	/**
	 * 根据id查询员工 
	 *  使用HibernateTemplate 
	 * TODO
	 * 2016年6月13日上午11:47:13 
	 * @author mxc  
	 *  @param employeeSn  主键ID
	 *  @return
	 */
	public Employee	 findEmployee(String employeeSn) {
			//获取HibernateTemplate 对象
			HibernateTemplate ht = this.getHibernateTemplate();
			//通过主键 找寻数据
			Employee employee= ht.get(Employee.class, employeeSn);
			//返回函数值
			return employee;
	}
	
	/**
	 * 保存 员工
	 * TODO
	 * 2016年6月13日上午11:51:12 
	 * @author mxc  
	 *  @param employee
	 */
	public void saveEmployee(Employee employee){
		
		HibernateTemplate ht = this.getHibernateTemplate();
		
		ht.save(employee);
	}
	/**
	 * 执行更新
	 * TODO
	 * 2016年6月13日上午11:52:36 
	 * @author mxc  
	 *  @param employee
	 */
	public void udapteEmployee(Employee employee){
		
		HibernateTemplate ht = this.getHibernateTemplate();
		
		ht.update(employee);
	}

	/**
	 * 保存报销单
	 * 2016年6月13日下午5:14:18 
	 * @author mxc  
	 *  @param claimVoucher
	 */
	public void saveClaimVoucher(ClaimVoucher claimVoucher) {
		// TODO Auto-generated method stub
		HibernateTemplate ht = this.getHibernateTemplate();
		ht.save(claimVoucher);
	}
	
	/**
	 * 使用回调机制分页查询 
	 * 因为参数要在匿名内部类中使用 必须 final修饰
	 * 2016年6月14日下午5:02:19 
	 * @author mxc  
	 *  @param queryParam
	 *  @param pageIndex
	 *  @param pageSize
	 *  @return
	 */
	public Object[] queryPaginationClaimVoucher(final Map<String, Object> queryParam,final Integer pageIndex,final Integer pageSize) {
		
		//获取HibernateTemplate 对象
		HibernateTemplate ht= this.getHibernateTemplate();
		
		//使用匿名内部类的方式创建了对象 因为只会使用一次，不会多次使用，这样更简洁
		HibernateCallback<Object[]> hc = new HibernateCallback<Object[]>() {
		
			//这里就拿到了session
			@Override
			public Object[] doInHibernate(Session session) throws HibernateException, SQLException {
				
				Object[] ary = null;
				
				//添加匹配条件
				DetachedCriteria dt = DetachedCriteria.forClass(ClaimVoucher.class);
				
				if (queryParam.get("event")!=null) {
					dt.add(Property.forName("event").like((String)queryParam.get("event"), MatchMode.ANYWHERE));
				}
				if (queryParam.get("status")!=null) {
					dt.add(Property.forName("status").like((String)queryParam.get("status"), MatchMode.ANYWHERE));
				}
				//查询总记录数
				Criteria criteria= dt.getExecutableCriteria(session);
				criteria.setProjection(Projections.rowCount());
				Integer count = (Integer) criteria.uniqueResult();
				criteria.setProjection(null);
				//查询当前页记录
				criteria.setFirstResult((pageIndex-1)*pageSize);
				criteria.setMaxResults(pageSize);
				criteria.addOrder(Order.desc("id"));
				List<ClaimVoucher> claimVouchers= criteria.list();
				ary= new Object[]{count,claimVouchers};
				return ary;
			}
			
		};
		Object[] ary = ht.execute(hc);
		return ary;
	}
}
