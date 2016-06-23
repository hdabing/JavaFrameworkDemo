package cn.jbit.jbitoa.action;

import java.io.Serializable;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.interceptor.ServletRequestAware;

import cn.jbit.jbitoa.entity.Employee;
import cn.jbit.jbitoa.entity.Position;
import cn.jbit.jbitoa.service.JbitOAService;
/**
 * 登录成功之后进来的
 * @author mxc  
 * @date 2016年6月16日 下午3:59:25
 */
public class MainAction implements Serializable ,ServletRequestAware{

	protected JbitOAService jbitOAService = null;
	
	// 当前登录的用户的员工对象
		protected Employee employee = null;
		// 当前登录用户的职位
		protected Position position = null;
		// request
		protected HttpServletRequest request = null;

	
	/**
	 * 业务实现
	 * 2016年6月16日下午4:00:47 
	 * @author mxc  
	 *  @return
	 */
	public String execute() {
		//获取当前登录的标识
				HttpSession session=request.getSession();
				String currentSn=(String) session.getAttribute("currentSn");
				//找寻员工对象
				employee=jbitOAService.findEmployee(currentSn);
				System.err.println("positionID："+employee.getPositionId());
			//	System.out.println("Debug:Name:"+employee.getName());
				//找寻职位对象
				position=jbitOAService.findPosition(employee.getPositionId());
			//	System.out.println("Debug:position:"+position);
		return "success";
	}


	@Override
	public void setServletRequest(HttpServletRequest arg0) {
		// TODO Auto-generated method stub
		this.request=arg0;
	}


	public JbitOAService getJbitOAService() {
		return jbitOAService;
	}


	public void setJbitOAService(JbitOAService jbitOAService) {
		this.jbitOAService = jbitOAService;
	}


	public Employee getEmployee() {
		return employee;
	}


	public void setEmployee(Employee employee) {
		this.employee = employee;
	}


	public Position getPosition() {
		return position;
	}


	public void setPosition(Position position) {
		this.position = position;
	}
	
	
}
