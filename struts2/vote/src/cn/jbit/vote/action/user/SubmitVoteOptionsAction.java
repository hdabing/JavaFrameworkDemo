package cn.jbit.vote.action.user;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;


import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.ServletRequestAware;

import cn.jbit.vote.dao.VoteDao;
import cn.jbit.vote.entity.VoteItem;

/**
 * 投票
 * @author mxc  
 * @date 2016年6月15日 下午9:55:48
 */
@ParentPackage("user")
@Namespace("/user")
public class SubmitVoteOptionsAction implements Serializable,ServletRequestAware {

	//投票id
	protected Integer vsId = null;
	
	//投票项
	protected Integer[] options = null;
	
	//消息
	protected String message   = null;
	
	//投票结果集合
	protected List<VoteItem> voteItems= null;
	
	protected HttpServletRequest request = null;
	
	//单选投票项
	/**
	 * 业务实现
	 * 2016年6月15日下午9:56:12 
	 * @author mxc  
	 *  @return
	 */
	@Action(value="submitVoteOptions" ,results={@Result(name="success",type="json" ,params={
			"root","message"
			
	})})
	public String execute(){
		VoteDao dao = new VoteDao();
		//获取用户id
		Integer userId =  (Integer) request.getSession().getAttribute("userId");
		
		//获取投票项id
		if (options!=null&&options.length>0) {
			//封装到投票结果集合
			voteItems = new ArrayList<VoteItem>();
			for (int i = 0; i < options.length; i++) {
				VoteItem item = new VoteItem();
				item.setVoID(options[i]);
				item.setVsID(vsId);
				item.setVuID(userId);
				voteItems.add(item);
			}
			
			//保存到数据库
			for (VoteItem item : voteItems) {
				dao.saveVoteIte(item);
			}
			
			message="{\"message\":\"投票成功！\"}";
		}else{
			message="{\"message\":\"没有选中投票项哦同学\"}";
		}
		
		
		return "success";
	}

	public Integer getVsId() {
		return vsId;
	}

	public void setVsId(Integer vsId) {
		this.vsId = vsId;
	}

	public Integer[] getOptions() {
		return options;
	}

	public void setOptions(Integer[] options) {
		this.options = options;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public void setServletRequest(HttpServletRequest arg0) {
		// TODO Auto-generated method stub
		this.request=arg0;
	}

	public List<VoteItem> getVoteItems() {
		return voteItems;
	}

	public void setVoteItems(List<VoteItem> voteItems) {
		this.voteItems = voteItems;
	}
	
	
}
