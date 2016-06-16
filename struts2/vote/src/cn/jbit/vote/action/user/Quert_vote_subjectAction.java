package cn.jbit.vote.action.user;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import cn.jbit.vote.dao.VoteDao;
import cn.jbit.vote.entity.VoteSubject;

/**
 * 查询投票
 * TODO 
 * @author mxc  
 * @date 2016年6月7日 上午8:35:26    
 *
 */
@ParentPackage("base")
@Namespace("/user")
public class Quert_vote_subjectAction implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//页面序号
	protected Integer pageIndex = null;
	
	//页面尺寸
	protected Integer pageSize =null;
	
	//查询条件，标题
	protected String vsTitle = null;
	
	//总记录数
	protected Integer totalRecord = null;
	
	//当前页数
	protected Integer totalPage = null;
	
	//url 参数
	protected String urlParam = null;
	
	//但钱页列表
	protected java.util.List<VoteSubject> currentPageList = null;
	
	//投票选项数
	protected Map<VoteSubject,Integer> totalVoteOptionMap = null;
	
	//投票人数
	protected Map<VoteSubject, Integer> totalVoteUserMap = null;
	
	/**
	 * 业务之心
	 * TODO
	 * 2016年6月7日上午8:36:17 
	 * @author mxc  
	 *  @return
	 */
	@Action(value="quert_vote_subject" ,results={@Result(type="dispatcher" ,name="success",location="/html/user/query_vote_subject_result.jsp")})
	public String  execute() {
		
		if (pageIndex==null||pageIndex<=0) {
			pageIndex=1;
		}
		if (pageSize==null||pageSize<=0) {
			pageSize=10;
		}
		//封装查询条件
		Map<String, Object> queryParam = new HashMap<String, Object>();
		
		//连接url参数的对象
		StringBuffer strUrlParam = new StringBuffer();
		
		//查询条件
		
		if (vsTitle!=null&&!vsTitle.trim().equals("")) {
			queryParam.put("vsTitle", vsTitle);
			//连接到url中：
			strUrlParam.append("&vsTitle="+vsTitle);
		}
		//url参数
		urlParam= strUrlParam.toString();
		
		VoteDao  dao = new VoteDao();
		
		Object[] arrayPagination = dao.queryPaginationVote(queryParam, pageIndex, pageSize);
		
		//获取总记录数
		totalRecord = (Integer) arrayPagination[0];
		
		//计算总页数；
		totalPage = totalRecord/pageSize;
		if (totalRecord%pageSize>0) {
			totalPage++;
		}
		//当前页列表
		currentPageList= (List<VoteSubject>) arrayPagination[1];
		
		//查询扩展字段数据
		
		if (currentPageList!=null&&currentPageList.size()>0) {
			//投票选项数集合
			totalVoteOptionMap =new HashMap<VoteSubject, Integer>();
			//投票选项人数集合
			totalVoteUserMap= new HashMap<VoteSubject, Integer>();
			
			//查询每一个投票记录的扩展字段
			for (VoteSubject voteSubject : currentPageList) {
				//投票选项数
				Integer  totalVoteOption = dao.countVoteOption(voteSubject.getVsId());
				
				//投票人数
				Integer totalVoteUser = dao.countVoteUser(voteSubject.getVsId());
				
				//放入集合中
				totalVoteOptionMap.put(voteSubject, totalVoteOption);
				totalVoteUserMap.put(voteSubject, totalVoteUser);
			}
		}
		return "success";
	}

	public Integer getPageIndex() {
		return pageIndex;
	}

	public void setPageIndex(Integer pageIndex) {
		this.pageIndex = pageIndex;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public String getVsTitle() {
		return vsTitle;
	}

	public void setVsTitle(String vsTitle) {
		this.vsTitle = vsTitle;
	}

	public Integer getTotalRecord() {
		return totalRecord;
	}

	public void setTotalRecord(Integer totalRecord) {
		this.totalRecord = totalRecord;
	}

	public Integer getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}

	public String getUrlParam() {
		return urlParam;
	}

	public void setUrlParam(String urlParam) {
		this.urlParam = urlParam;
	}

	public java.util.List<VoteSubject> getCurrentPageList() {
		return currentPageList;
	}

	public void setCurrentPageList(java.util.List<VoteSubject> currentPageList) {
		this.currentPageList = currentPageList;
	}

	public Map<VoteSubject, Integer> getTotalVoteOptionMap() {
		return totalVoteOptionMap;
	}

	public void setTotalVoteOptionMap(Map<VoteSubject, Integer> totalVoteOptionMap) {
		this.totalVoteOptionMap = totalVoteOptionMap;
	}

	public Map<VoteSubject, Integer> getTotalVoteUserMap() {
		return totalVoteUserMap;
	}

	public void setTotalVoteUserMap(Map<VoteSubject, Integer> totalVoteUserMap) {
		this.totalVoteUserMap = totalVoteUserMap;
	}
	
	
}
