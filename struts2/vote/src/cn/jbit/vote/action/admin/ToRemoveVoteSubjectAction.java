package cn.jbit.vote.action.admin;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import cn.jbit.vote.dao.VoteDao;
import cn.jbit.vote.entity.VoteOption;
import cn.jbit.vote.entity.VoteSubject;

@ParentPackage("admin")
@Namespace("/admin")
public class ToRemoveVoteSubjectAction {

		// 投票id
		private Integer id = null;

		// 投票记录
		private VoteSubject voteSubject = null;

		// 投票选项列表
		private List<VoteOption> voteOptions = null;
	
	/**
	 * 
	 * @date：Jun 2, 2016
	 * @author：mxc
	 * @return
	 */
	@Action(value="toRemoveVoteSubject",results={@Result(name="success",type="dispatcher",location="/html/admin/to_remove_vote_subject.jsp")})
	public String execute(){
		//创建Dao对象
		VoteDao dao = new VoteDao();
		//查找投票记录
				voteSubject = dao.findVoteSubjectVsId(id);
				
				//查询投票选项列表
				voteOptions = dao.queryVoteOptionsByVsId(id);
		return "success";
	}

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the voteSubject
	 */
	public VoteSubject getVoteSubject() {
		return voteSubject;
	}

	/**
	 * @param voteSubject the voteSubject to set
	 */
	public void setVoteSubject(VoteSubject voteSubject) {
		this.voteSubject = voteSubject;
	}

	/**
	 * @return the voteOptions
	 */
	public List<VoteOption> getVoteOptions() {
		return voteOptions;
	}

	/**
	 * @param voteOptions the voteOptions to set
	 */
	public void setVoteOptions(List<VoteOption> voteOptions) {
		this.voteOptions = voteOptions;
	}
	
}
