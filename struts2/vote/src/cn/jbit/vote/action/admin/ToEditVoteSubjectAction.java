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

/**
 * 去编辑投票
 * TODO
 * @date：Jun 3, 2016 10:56:47 AM
 * @author mxc
 */
@ParentPackage("admin")
@Namespace("/admin")
@Action(value="toEditVoteSubject" ,results={@Result(type="dispatcher",name="success",location="/html/admin/to_edit_vote_subject.jsp")})
public class ToEditVoteSubjectAction implements Serializable {
	// 投票id
		private Integer id = null;

		// 投票记录
		private VoteSubject voteSubject = null;

		// 投票选项列表
		private List<VoteOption> voteOptions = null;
		
		
		public String execute() {
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
