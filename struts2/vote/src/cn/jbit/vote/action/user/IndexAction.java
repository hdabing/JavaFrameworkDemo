package cn.jbit.vote.action.user;

import java.io.Serializable;

import oracle.net.aso.n;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
/**
 * 客户平台主页面
 * TODO
 * @date：May 27, 2016 3:05:09 PM
 * @author mxc
 */
@ParentPackage("user")
@Namespace("/user")
public class IndexAction implements Serializable {

	/**
	 * 业务实现
	 * @date：May 27, 2016
	 * @author：mxc
	 * @return
	 */
	@Action(value="index",results={@Result(name="success",type="dispatcher",location="/html/user/index.jsp")})
	public String execute() {
		return "success";
	}
}
