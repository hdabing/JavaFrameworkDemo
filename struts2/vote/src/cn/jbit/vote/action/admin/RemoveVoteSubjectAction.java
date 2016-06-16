package cn.jbit.vote.action.admin;

import java.io.Serializable;
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
public class RemoveVoteSubjectAction implements Serializable {

	//subjectId
	protected Integer vsid = null;
	
	//消息
	protected String message =  null;
	
	
	@Action(value="removeVoteSubject",results={@Result(name="success",type="dispatcher",location="/html/admin/remove_vote_subject_result.jsp")})
	public String execute() {
		
		VoteDao dao = new VoteDao();
		
		//找寻投票记录
		VoteSubject subject= dao.findVoteSubjectVsId(vsid);
		
		//投票选项列表
		List<VoteOption> options= dao.queryVoteOptionsByVsId(vsid);
		
		//删除投票记录
		dao.removeVoteSubject(subject,options);
		
		//消息
		message="恭喜，投票记录已经删除";
		
		return "success";
	}


	/**
	 * @return the vsid
	 */
	public Integer getVsid() {
		return vsid;
	}


	/**
	 * @param vsid the vsid to set
	 */
	public void setVsid(Integer vsid) {
		this.vsid = vsid;
	}


	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}


	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
