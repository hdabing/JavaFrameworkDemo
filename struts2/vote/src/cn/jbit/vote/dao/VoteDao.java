package cn.jbit.vote.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Property;
import org.hibernate.criterion.Restrictions;

import cn.jbit.vote.entity.VoteItem;
import cn.jbit.vote.entity.VoteOption;
import cn.jbit.vote.entity.VoteSubject;
import cn.jbit.vote.entity.VoteUser;

/**
 * 投票业务 TODO
 * 
 * @date：May 27, 2016 11:03:24 AM
 * @author mxc
 */
public class VoteDao implements Serializable {
	public static void main(String[] args) {
		getSession().close();
	}

	// session工厂
	public static SessionFactory sessionFactory = null;
	// session 绑定到本地线程
	public static ThreadLocal<Session> sessionLocal = new ThreadLocal<Session>();

	/**
	 * 
	 * 
	 * TODO 获取session 开发时间：May 17, 2016 12:04:17 PM
	 * 
	 * @author：mxc
	 * @return
	 */
	public static Session getSession() {
		Session session = sessionLocal.get();
		if (session == null) {
			if (sessionFactory == null) {
				// 构建配置对象
				Configuration configuration = new AnnotationConfiguration();
				// Hibernate初始化
				configuration.configure();
				// 构建sessionfactory
				sessionFactory = configuration.buildSessionFactory();
			}
			// 创建新的 session
			session = sessionFactory.openSession();
			// 放入本地线程
			sessionLocal.set(session);

		}
		return session;
	}

	/**
	 * 
	 * 
	 * TODO 开始事物 开发时间：May 17, 2016 12:12:46 PM
	 * 
	 * @author：
	 */
	public static void beginTransaction() {
		// 获取当前线程的session
		Session session = getSession();

		if (session != null) {
			// 开启事物
			session.beginTransaction();
		}
	}

	/**
	 * 
	 * 
	 * TODO 提交事物 开发时间：May 17, 2016 12:13:42 PM
	 * 
	 * @author：mxc
	 */
	public static void commitTransaction() {
		// 获取当前线程的session
		Session session = getSession();

		if (session != null) {
			// 开启事物
			Transaction transaction = session.beginTransaction();
			// 不为空，没有提叫，没有回滚
			if (transaction != null && !transaction.wasRolledBack()
					&& !transaction.wasCommitted()) {
				transaction.commit();
			}
		}
	}

	/**
	 * 
	 * 
	 * TODO 回滚事物 开发时间：May 17, 2016 12:13:42 PM
	 * 
	 * @author：mxc
	 */
	public static void rollerBackTransaction() {
		// 获取当前线程的session
		Session session = getSession();

		if (session != null) {
			// 开启事物
			Transaction transaction = session.beginTransaction();
			// 不为空，没有提叫，没有回滚
			if (transaction != null && !transaction.wasRolledBack()
					&& !transaction.wasCommitted()) {
				transaction.rollback();
			}
		}
	}

	/**
	 * 
	 * 关闭session 开发时间：May 17, 2016 12:17:41 PM
	 * 
	 * @author：孟祥超
	 */
	public static void closeSession() {
		// 获取当前线程的session
		Session session = getSession();
		if (session != null) {

			// 解除本地绑定
			sessionLocal.remove();
			// 如果不是打开就关闭
			if (session.isOpen()) {
				session.close();
			}

		}
	}

	/**
	 * 查找用户
	 * 
	 * @date：May 27, 2016
	 * @author：mxc
	 * @param vuUserName
	 * @return
	 */
	public VoteUser findVoteUserById(String vuUserName) {
		// 用户对象
		VoteUser user = null;

		try {
			// 创建
			DetachedCriteria dc = DetachedCriteria.forClass(VoteUser.class);

			// 添加条件
			dc.add(Property.forName("vuUserName").like(vuUserName));

			// 查询数据 设置查询缓存
			user = (VoteUser) dc.getExecutableCriteria(getSession())
					.setCacheable(true).uniqueResult();

		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			closeSession();
		}

		// 返回
		return user;
	}

	/**
	 * 分页查询投票
	 * 
	 * @date：Jun 1, 2016
	 * @author：mxc
	 * @param queryPram
	 * @param page
	 * @param rows
	 * @return
	 */
	public Object[] queryPaginationVote(Map<String, Object> queryPram,
			Integer page, Integer rows) {
		Object[] objs = null;
		try {
			DetachedCriteria dc = DetachedCriteria.forClass(VoteSubject.class);

			// 条件
			if (queryPram.get("vsTitle") != null) {
				dc.add(Property.forName("vsTitle").like(
						"%" + ((String) queryPram.get("vsTitle")) + "%",
						MatchMode.ANYWHERE));
			}

			Criteria criteria = dc.getExecutableCriteria(getSession());

			// 总记录数
			Integer count = (Integer) criteria.setProjection(
					Projections.rowCount()).uniqueResult();

			// 数据
			criteria.setProjection(null);
			criteria.addOrder(Order.desc("vsId"));

			// 分页参数
			criteria.setFirstResult((page - 1) * rows);
			criteria.setMaxResults(rows);

			List<VoteSubject> subjects = criteria.list();

			// 封装数据
			objs = new Object[] { count, subjects };

		} catch (Exception e) {

			e.printStackTrace();
		} finally {
			closeSession();
		}
		return objs;
	}

	/**
	 * 统计投票选项数
	 * 
	 * @date：Jun 1, 2016
	 * @author：mxc
	 * @param vsId
	 * @return
	 */
	public Integer countVoteOption(Integer vsId) {
		Integer totalOption = null;
		try {
			Session session = getSession();
			DetachedCriteria dc = DetachedCriteria.forClass(VoteOption.class);

			// 条件
			dc.add(Restrictions.eq("vsID", vsId));

			ProjectionList pList = Projections.projectionList();
			pList.add(Projections.rowCount());

			dc.setProjection(pList);
			Criteria criteria = dc.getExecutableCriteria(session);
			totalOption = (Integer) criteria.uniqueResult();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			closeSession();
		}
		return totalOption;
	}

	/**
	 * 统计投票人数
	 * 
	 * @date：Jun 1, 2016
	 * @author：mxc
	 * @param vsId
	 * @return
	 */
	public Integer countVoteUser(Integer vsId) {
		Integer totalUser = null;
		try {
			Session session = getSession();
			DetachedCriteria dc = DetachedCriteria.forClass(VoteItem.class);

			// 条件
			dc.add(Property.forName("vsID").eq(vsId));

			ProjectionList pList = Projections.projectionList();
			// 重复的只算一个
			pList.add(Projections.countDistinct("vuID"));

			dc.setProjection(pList);
			Criteria criteria = dc.getExecutableCriteria(session);
			totalUser = (Integer) criteria.uniqueResult();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			closeSession();
		}
		return totalUser;
	}

	/**
	 * 根据投票内容查找投票选项 返回选项列表
	 * 
	 * @date：Jun 2, 2016
	 * @author：mxc
	 * @param id
	 * @return
	 */
	public List<VoteOption> queryVoteOptionsByVsId(Integer id) {
		// 投票选项列表
		List<VoteOption> voteOptions = null;
		try {
			Session session = getSession();

			DetachedCriteria dc = DetachedCriteria.forClass(VoteOption.class);
			dc.add(Restrictions.eq("vsID", id));
			voteOptions = dc.getExecutableCriteria(session).setCacheable(true)
					.list();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeSession();
		}

		return voteOptions;
	}

	/**
	 * 根据投票内容id 查找投票内容对象
	 * 
	 * @date：Jun 2, 2016
	 * @author：mxc
	 * @param id
	 * @return 投票内容对象那个
	 */
	public VoteSubject findVoteSubjectVsId(Integer id) {
		// TODO Auto-generated method stub
		VoteSubject subject = null;
		try {
			Session session = getSession();

			subject = (VoteSubject) session.get(VoteSubject.class, id);

		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			closeSession();
		}
		return subject;
	}

	/**
	 * 删除投票内容，和投票选项
	 * 
	 * @date：Jun 2, 2016
	 * @author：mxc
	 * @param subject
	 * @param options
	 */
	public void removeVoteSubject(VoteSubject subject, List<VoteOption> options) {
		// TODO Auto-generated method stub
		try {
			Session session = getSession();
			beginTransaction();

			// 删除操作
			if (options != null && options.size() > 0) {
				for (VoteOption voteOption : options) {
					session.delete(voteOption);
				}
			}
			if (subject != null) {
				session.delete(subject);
			}

			commitTransaction();

		} catch (Exception e) {
			// TODO: handle exception
			rollerBackTransaction();
			e.printStackTrace();
		} finally {
			closeSession();
		}
	}

	/**
	 * 新增投票
	 * @date：Jun 3, 2016
	 * @author：mxc
	 * @param voteSubject
	 * @param voteOptions
	 */
	public void saveVoteSubject(VoteSubject voteSubject,
			List<VoteOption> voteOptions) {
		
		try {
			
			Session session= getSession();
			
			beginTransaction();
			
			//保存投票
			session.save(voteSubject);
			
			//保存 投票选项
			for (VoteOption voteOption : voteOptions) {
				voteOption.setVsID(voteSubject.getVsId());
				session.save(voteOption);
			}
			
			commitTransaction();
		} catch (Exception e) {
			// TODO: handle exception
			rollerBackTransaction();
			e.printStackTrace();
		}finally{
			closeSession();
		}
		
	}
	/**
	 * 根据id查找 option
	 * @date：Jun 3, 2016
	 * @author：mxc
	 * @param integer
	 * @return
	 */
	public VoteOption findVoteOptionById(Integer integer) {
		VoteOption option = null;
		
		try {
			Session session= getSession();
			
			
			option= (VoteOption) session.get(VoteOption.class, integer);
			
			
		} catch (Exception e) {
			// TODO: handle exception
			
		
		}finally{
			closeSession();
		}
		
		return option;
	}

	/**
	 * 编辑 选项
	 * @date：Jun 3, 2016
	 * @author：mxc
	 * @param voteSubject
	 * @param listAdd 要增加的项集合
	 * @param listEdit 要修改的项集合
	 * @param listdelete 要删除的项集合
	 */
	public void updateVoteSubject(VoteSubject voteSubject,
			List<VoteOption> listAdd, List<VoteOption> listEdit,
			List<VoteOption> listdelete) {
		try {
			Session session = getSession();
			beginTransaction();
			
			//跟新投票项
			session.update(voteSubject);
			
			//添加记录
			if (listAdd!=null&&listAdd.size()>0) {
				for (VoteOption voteOption : listAdd) {
					session.save(voteOption);
				}
			}
			
			
			//修改的记录
			if (listEdit!=null&&listEdit.size()>0) {
				for (VoteOption voteOption : listEdit) {
					session.update(voteOption);
				}
			}
			
			
			//删除记录
			if (listdelete !=null&&listdelete.size()>0) {
				for (VoteOption voteOption : listdelete) {
					session.delete(voteOption);
				}
			}
			
			commitTransaction();
		} catch (Exception e) {
			rollerBackTransaction();
			e.printStackTrace();
		}finally{
			closeSession();
		}
		
	}

	/**
	 * 保存 投票结果
	 * 2016年6月15日下午10:14:01 
	 * @author mxc  
	 *  @param item
	 */
	public void saveVoteIte(VoteItem item) {
		// TODO Auto-generated method stub
		Session session= getSession();
		try {
			beginTransaction();
			session.save(item);
			commitTransaction();
			
		} catch (Exception e) {
			rollerBackTransaction();
			e.printStackTrace();
		}finally{
			closeSession();
		}
	}
}
