package cn.jbit.vote.action.admin;

import java.io.Serializable;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
/**
 * 去增加投票
 * TODO
 * @date：Jun 2, 2016 2:17:19 PM
 * @author mxc
 */
@ParentPackage("admin")
@Namespace("/admin")
public class ToAddVoteSubjectAction implements Serializable {

	@Action(value="toAddVoteSubject" ,results={@Result(type="dispatcher",name="success",location="/html/admin/to_add_vote_subject.jsp")})
	public String execute() {
		
		return "success";
	}
}
