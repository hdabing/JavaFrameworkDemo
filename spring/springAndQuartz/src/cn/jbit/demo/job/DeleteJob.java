package cn.jbit.demo.job;

import java.io.Serializable;




public class DeleteJob  implements Serializable {

	protected String name = null;

	protected String pwd = null;

	public void show(){
		System.out.println("Name:"+name+",Pwd"+pwd);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

}
