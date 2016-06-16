package cn.jbit.vote.action.admin;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import oracle.net.aso.q;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import cn.jbit.vote.dao.VoteDao;
import cn.jbit.vote.entity.VoteSubject;

@ParentPackage("admin")
@Namespace("/admin")
public class QueryVoteAction implements Serializable {

	//接受参数 当前页 pageIndex
	protected Integer page = null;
	
	//页面尺寸 pageSize
	protected Integer rows = null;
	
	//返回数据
	protected Map<String, Object> paginationMap = null;
	
	//查询条件
	protected String vsTitle = null;
	
	@SuppressWarnings("unchecked")
	@Action(value="queryVote",results={
			@Result(name="success",type="json",params={
					"root","paginationMap"
			})
	})
	public String execute() {
		
		//页面序号
		if (page==null||page<=0) {
			page=1;
		
		}
		
		//页面尺寸
		if (rows==null||rows<=0) {
			rows=10;
		}
		
		//查询参数的集合
		Map<String, Object> queryPram = new HashMap<String, Object>();
		
		//查询条件
		if (vsTitle!=null&&!vsTitle.equals("")) {
//			try {
//				vsTitle= new String(vsTitle.getBytes("iso-8859-1"),"utf-8");
//			} catch (UnsupportedEncodingException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
			queryPram.put("vsTitle", vsTitle);
		}
		
		//创建dao对象，实现查询
		VoteDao dao = new VoteDao();
		Object[] objs = dao.queryPaginationVote(queryPram,page,rows);
		
		//总记录数
		Integer total = (Integer) objs[0];
		
		//当前页列表
		List<VoteSubject> currentPageList = (List<VoteSubject>) objs[1];
		
		//投票记录列表
		List<VoteSubjectBean> list = new ArrayList<VoteSubjectBean>();
		
		if (currentPageList!=null&&currentPageList.size()>0) {
			//创建投票记录列表
			
			for (VoteSubject subject : currentPageList) {
				VoteSubjectBean record = new VoteSubjectBean(subject);
				list.add(record);
				
				//查询投票选项数
				Integer totalOption = dao.countVoteOption(subject.getVsId());
				record.setTotalOption(totalOption);
				
				//统计投票人数
				Integer totalUser = dao.countVoteUser(subject.getVsId());
				record.setTotalUser(totalUser);
			}
		}
		paginationMap = new HashMap<String, Object>();
		paginationMap.put("total", total);
		paginationMap.put("rows", list);
		return "success";
	}

	/**
	 * @return the page
	 */
	public Integer getPage() {
		return page;
	}

	/**
	 * @param page the page to set
	 */
	public void setPage(Integer page) {
		this.page = page;
	}

	/**
	 * @return the rows
	 */
	public Integer getRows() {
		return rows;
	}

	/**
	 * @param rows the rows to set
	 */
	public void setRows(Integer rows) {
		this.rows = rows;
	}

	/**
	 * @return the paginationMap
	 */
	public Map<String, Object> getPaginationMap() {
		return paginationMap;
	}

	/**
	 * @param paginationMap the paginationMap to set
	 */
	public void setPaginationMap(Map<String, Object> paginationMap) {
		this.paginationMap = paginationMap;
	}

	/**
	 * @return the vsTitle
	 */
	public String getVsTitle() {
		return vsTitle;
	}

	/**
	 * @param vsTitle the vsTitle to set
	 */
	public void setVsTitle(String vsTitle) {
		this.vsTitle = vsTitle;
	}
	
	
}
