package entity;

import java.io.Serializable;



/**
 * 实体类
 * TODO 
 * @author mxc  
 * @date 2016年6月11日 下午11:28:39    
 *
 */
public class User implements Serializable {

	protected String name = null;
	
	protected String address  = null;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	
}
