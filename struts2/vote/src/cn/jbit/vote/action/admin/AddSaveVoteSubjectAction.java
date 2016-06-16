package cn.jbit.vote.action.admin;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import cn.jbit.vote.dao.VoteDao;
import cn.jbit.vote.entity.VoteOption;
import cn.jbit.vote.entity.VoteSubject;
/**
 * 增加投票
 * TODO
 * @date：Jun 3, 2016 9:00:23 AM
 * @author mxc
 */
@ParentPackage("admin")
@Namespace("/admin")
public class AddSaveVoteSubjectAction implements Serializable {
	
	//消息
	protected String message =null;
	
	//投票项
	protected VoteSubject voteSubject =null;
	
	
	//投票选项
	protected String[] voOption =null;
	
	@Action(value="addSaveVoteSubject",results={@Result(name="success",type="redirectAction",location="showVoteSubject.action?id=${voteSubject.vsId}&message=${message}")})
	public String execute(){
		
		//构建投票项列表
		List<VoteOption> voteOptions= null ;
		
		if (voOption!=null&&voOption.length>0) {
			voteOptions= new ArrayList<VoteOption>();
			Integer index=1;
			for (String option : voOption) {
				
				VoteOption voteOption= new VoteOption();
				voteOption.setVoOption(option);
				voteOption.setVoOrder(index.toString());
				index++;
				voteOptions.add(voteOption);
			}
		}
		
		//创建dao对象 
		VoteDao dao = new VoteDao();
		
		//保存
		dao.saveVoteSubject(voteSubject,voteOptions);
		
		try {
			message= URLEncoder.encode("投票保存成功！", "utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return "success";
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
	 * @return the voOption
	 */
	public String[] getVoOption() {
		return voOption;
	}

	/**
	 * @param voOption the voOption to set
	 */
	public void setVoOption(String[] voOption) {
		this.voOption = voOption;
	}
	
	
}
