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

import com.sun.org.apache.xalan.internal.lib.ExsltBase;

import cn.jbit.vote.dao.VoteDao;
import cn.jbit.vote.entity.VoteOption;
import cn.jbit.vote.entity.VoteSubject;
/**
 * 修改 投票
 * TODO
 * @date：Jun 3, 2016 12:18:40 PM
 * @author mxc
 */
@ParentPackage("admin")
@Namespace("/admin")
public class EditSaveVoteSubjectAction implements Serializable {

		//消息
		protected String message =null;
		
		//投票项
		protected VoteSubject voteSubject =null;
		
		protected Integer[] voId = null;
		
		//投票选项
		protected String[] voOption =null;
		
		@Action(value="editSaveVoteSubject",results={@Result(name="success",type="redirectAction",location="showVoteSubject.action?id=${voteSubject.vsId}&message=${message}")})
		public String execute(){
			VoteDao dao = new VoteDao();
			//投票项添加记录列表
			List<VoteOption> listAdd = new ArrayList<VoteOption>();
			
			//投票项删除 记录列表
			List<VoteOption> listdelete = new ArrayList<VoteOption>();
			
			//投票项编辑 记录列表
			List<VoteOption> listEdit = new ArrayList<VoteOption>();
			
			//找出添加的记录 和编辑的记录
			if (voId!=null&&voId.length>0) {
				for (int i = 0; i < voId.length; i++) {
					VoteOption option= new VoteOption();
					if (voId[i]==-1) {
						listAdd.add(option);
						option.setVoId(voId[i]);
						option.setVoOption(voOption[i]);
						Integer index = i+1;
						option.setVsID(voteSubject.getVsId());
						option.setVoOrder(index.toString());
						
					}else{
						//编辑额
						option= dao.findVoteOptionById(voId[i]);
						option.setVoOption(voOption[i]);
						Integer index = i+1;
						option.setVsID(voteSubject.getVsId());
						option.setVoOrder(index.toString());
						listEdit.add(option);
						
					}
				}
				
			}
			
			//找寻删除列表
			//查询数据库中的投票选项列表
			List<VoteOption> listDB =dao .queryVoteOptionsByVsId(voteSubject.getVsId());
			
			if (listDB!=null&&listDB.size()>0) {
				
				//遍历数据库中的选项
				for (VoteOption voteOption : listDB) {
					
					
					//是否存在编辑列表中
					boolean exists = true;
					
					//遍历要编辑的列表 
					for(int i=0;i<listEdit.size();i++){
						VoteOption edit = listEdit.get(i);
						System.out.println("编辑id："+edit.getVoId()+"      数据库id  ："+voteOption.getVoId());
						//integer是封装类 引用类型 比较值的话 需要将引用类型转换为int类型
						System.out.println(edit.getVoId().intValue()==voteOption.getVoId().intValue());
						if (edit.getVoId().intValue()==voteOption.getVoId().intValue()) {
							exists=false;
							break;
						}
					}
					if (exists) {
						listdelete.add(voteOption);
					}
				}
			}
			
			dao.updateVoteSubject(voteSubject,listAdd,listEdit,listdelete);
			
			try {
				message= URLEncoder.encode("投票信息编辑成功！", "utf-8");
			} catch (Exception e) {
				// TODO: handle exception
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

		/**
		 * @return the voId
		 */
		public Integer[] getVoId() {
			return voId;
		}

		/**
		 * @param voId the voId to set
		 */
		public void setVoId(Integer[] voId) {
			this.voId = voId;
		}
		
		
	
}
