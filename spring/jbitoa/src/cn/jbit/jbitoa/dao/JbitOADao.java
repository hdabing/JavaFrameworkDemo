package cn.jbit.jbitoa.dao;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.print.DocFlavor.STRING;

import org.apache.jasper.tagplugins.jstl.core.If;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Property;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateInterceptor;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.jbit.jbitoa.entity.CheckResult;
import cn.jbit.jbitoa.entity.ClaimVoucher;
import cn.jbit.jbitoa.entity.ClaimVoucherDetail;
import cn.jbit.jbitoa.entity.Department;
import cn.jbit.jbitoa.entity.Dictionary;
import cn.jbit.jbitoa.entity.Employee;
import cn.jbit.jbitoa.entity.Position;
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
				
				if (queryParam.get("id")!=null) {
					dt.add(Property.forName("id").eq(queryParam.get("id")));
				}

				if (queryParam.get("createTime1")!=null&&queryParam.get("createTime2")!=null) {
					dt.add(Property.forName("createTime").between(queryParam.get("createTime1"), queryParam.get("createTime2")));
				}

				if (queryParam.get("createSn")!=null) {
					dt.add(Property.forName("createSn").eq(queryParam.get("createSn")));
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

	/**
	 * 查找职位
	 * 2016年6月20日下午2:11:29 
	 * @author mxc  
	 *  @param positionId
	 *  @return
	 */
	public Position findPosition(Integer positionId) {
		HibernateTemplate ht = getHibernateTemplate();
		System.out.println("Debug Dao:"+positionId);
		Position position=ht.get(Position.class, positionId);
		return position;
	}

	/**
	 * 查询字典数据
	 * 2016年6月20日下午3:05:47 
	 * @author mxc  
	 *  @param queryParam
	 *  @return
	 */
	public List<Dictionary> queryDictionary(Map<String, Object> queryParam) {
		// TODO Auto-generated method stub
		
		//查询参数名列表
		List<String> paramNameList =  new ArrayList<String>();
		
		//查询参数值列表
		List<Object> paramValueList =  new ArrayList<Object>();
		
		//hql
		StringBuffer hql = new StringBuffer("from Dictionary d where 1=1 ");
		
		//数据类型
		if (queryParam.get("type")!=null) {
			hql.append(" and d.type like :type");
			paramNameList.add("type");
			paramValueList.add(queryParam.get("type"));
		}
		
		//转换为数组类型
		String[] aryParamName =  new String[paramNameList.size()];
		
		Object[] aryParamValue =  new Object[paramValueList.size()];
		
		aryParamName= paramNameList.toArray(aryParamName);
		aryParamValue= paramValueList.toArray(aryParamValue);
		System.out.println("Debug value:"+aryParamValue[0]);
		
		//查询数据
		List<Dictionary> list =  getHibernateTemplate().findByNamedParam(hql.toString(), aryParamName, aryParamValue);
		
		return list;
	}

	/**
	 * 根据部门id查询部门记录
	 * 2016年6月21日下午1:56:28 
	 * @author mxc  
	 *  @param departmentId
	 *  @return
	 */
	public Department findDepartmen(Integer departmentId) {
		Department department= getHibernateTemplate().get(Department.class, departmentId);
		return department;
	}

	/**
	 * 保存报销单及明细
	 * 2016年6月21日下午1:56:52 
	 * @author mxc  
	 *  @param claimVoucher
	 *  @param detaileList
	 */
	public void submitClaimVoucher(ClaimVoucher claimVoucher, List<ClaimVoucherDetail> detaileList) {
		HibernateTemplate ht = this.getHibernateTemplate();
		ht.save(claimVoucher);
		
		if (detaileList!=null&&detaileList.size()>0) {
			for (ClaimVoucherDetail claimVoucherDetail : detaileList) {
				claimVoucherDetail.setMainId(claimVoucher.getId());
				ht.save(claimVoucherDetail);
			}
		}
		
	}

	/**
	 * 根据报销单id查询报销单对象
	 * 2016年6月21日下午2:46:38 
	 * @author mxc  
	 *  @param id
	 *  @return
	 */
	public ClaimVoucher findfindClaimVoucher(Long id) {
		// TODO Auto-generated method stub
		return getHibernateTemplate().get(ClaimVoucher.class, id);
	}

	/**
	 * 根据报销单id 查询报销明细
	 * 2016年6月21日下午2:47:22 
	 * @author mxc  
	 *  @param id
	 *  @return
	 */
	public List<ClaimVoucherDetail> queryClaimVoucherDetail(Long id) {
		
		DetachedCriteria dc = DetachedCriteria.forClass(ClaimVoucherDetail.class);
		
		dc.add(Property.forName("mainId").eq(id));
		dc.addOrder(Order.asc("id"));
		
		HibernateTemplate ht = getHibernateTemplate();
		
		List<ClaimVoucherDetail> list = ht.findByCriteria(dc);
		
		return list;
	}

	/**
	 * 查询审核记录
	 * 2016年6月21日下午2:48:03 
	 * @author mxc  
	 *  @param queryParam
	 *  @return
	 */
	public List<CheckResult> queryCheckResult(Map<String, Object> queryParam) {
		// TODO Auto-generated method stub
		DetachedCriteria dc = DetachedCriteria.forClass(CheckResult.class);
		
		if (queryParam.get("sheetId")!=null) {
			dc.add(Property.forName("sheetId").eq(queryParam.get("sheetId")));
		}
		
		if (queryParam.get("sheetType")!=null) {
			dc.add(Property.forName("sheetType").eq(queryParam.get("sheetType")));
		}
		
		dc.addOrder(Order.asc("id"));
		
		HibernateTemplate ht = this.getHibernateTemplate();
		
		List<CheckResult> checkResults= ht.findByCriteria(dc);
		
		return checkResults;
	}
}
