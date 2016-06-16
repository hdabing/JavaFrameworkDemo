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
 * @author mxc  
 * @date 2016年6月15日 下午9:04:37
 */
@ParentPackage("user")
@Namespace("/user")
public class ToPullVoteSubjectAction implements Serializable {

	//投票id
	protected Integer vsId =null;
	
	//投票对象
	protected VoteSubject votesubject = null;
	
	//投票项集合
	protected List<VoteOption> voteOptions =null;
	
	/**
	 * 获取投票对象
	 * 获取投票选集合
	 * 2016年6月15日下午9:09:42 
	 * @author mxc  
	 *  @return
	 */
	@Action(value="toPullVoteSubject" ,results={@Result(name="success",type="dispatcher" ,location="/html/user/to_pull_vote_subject.jsp")})
	public String execute(){
		
		VoteDao dao = new VoteDao();
		
		//获取 投票对象
		votesubject= dao.findVoteSubjectVsId(vsId);
		
		//获取投票项集合
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
