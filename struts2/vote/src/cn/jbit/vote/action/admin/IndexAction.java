package cn.jbit.vote.action.admin;

import java.io.Serializable;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

/**
 * 管理主页面
 * TODO
 * @date：May 27, 2016 12:24:11 PM
 * @author mxc
 */
@ParentPackage("admin")
@Namespace("/admin")
public class IndexAction implements Serializable {

	
	/**
	 * 业务实现
	 * @date：May 27, 2016
	 * @author：mxc
	 * @return
	 */
	@Action(value="index",results={@Result(name="success",type="dispatcher",location="/html/admin/index.jsp")})
	public String execute(){
		return "success";
	}
}
