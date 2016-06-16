package cn.jbit.vote.action.user;

import java.io.Serializable;
import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import cn.jbit.vote.dao.VoteDao;
import cn.jbit.vote.entity.VoteOption;
import cn.jbit.vote.entity.VoteSubject;

/**
 * 去投票
 * TODO 
 * @author mxc  
 * @date 2016年6月12日 下午9:47:07    
 *
 */
@ParentPackage("/user")
@Namespace("user")
public class ToPullVoteSubject implements Serializable {

	//投票项id
	protected Integer vsId = null;
	
	//投票项 
	protected VoteSubject votesubject = null;
	
	protected List<VoteOption> voteOptions = null;
	/**
	 * 业务执行
	 * TODO
	 * 2016年6月12日下午9:47:38 
	 * @author mxc  
	 *  @return
	 */
	@Action(value="to_pull_vote_subject" ,results={@Result(name="success",type="dispatcher",location="/html/user/to_pull_vote_subject.jsp")})
	public String execute() {
		VoteDao dao = new VoteDao();
		votesubject= dao.findVoteSubjectVsId(vsId);
		voteOptions= dao.queryVoteOptionsByVsId(vsId);
		return "success";
	}
	public Integer getVsId() {
		return vsId;
	}
	public void setVsId(Integer vsId) {
		this.vsId = vsId;
	}
	public VoteSubject getVotesubject() {
		return votesubject;
	}
	public void setVotesubject(VoteSubject votesubject) {
		this.votesubject = votesubject;
	}
	public List<VoteOption> getVoteOptions() {
		return voteOptions;
	}
	public void setVoteOptions(List<VoteOption> voteOptions) {
		this.voteOptions = voteOptions;
	}
	
	
}
