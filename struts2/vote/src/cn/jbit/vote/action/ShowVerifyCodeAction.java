package cn.jbit.vote.action;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.Serializable;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.ServletRequestAware;
/**
 * 生成验证码
 * TODO
 * @date：May 31, 2016 10:43:28 AM
 * @author mxc
 */
@ParentPackage("base")
@Namespace("/")
public class ShowVerifyCodeAction implements Serializable,ServletRequestAware {
	
	//输入流对象
	protected InputStream inputStream = null;
	
	//request 对象
	protected HttpServletRequest request = null;
	
	//位置
	protected String location = null;
	
	/**
	 * 业务实现
	 * @date：May 31, 2016
	 * @author：mxc
	 * @return
	 */
	@Action(value="showVerifyCode",results={@Result(name="success",type="stream",location="",params={
			"inputName","inputStream","contentType","image/png"
	})})
	public String	execute(){
		
		//创建图片对象：
		BufferedImage image = new BufferedImage(100, 30, BufferedImage.TYPE_INT_BGR);
		
		//获取画笔对象 通过图片，因为要往里面话
		Graphics graphics = image.getGraphics();
		
		//设置前景色：(画笔)
		graphics.setColor(new Color(0,255,255));
		
		//填充背景  使用画笔填满
		graphics.fillRect(0, 0, 100, 30);
		
		//创建随机对象
		Random random = new Random();
		
		//干扰线
		
		//随机点
		int [] [] points = new int[15][2];
		
		//生成随机点
		for (int i = 0; i < points.length; i++) {
			points[i][0]=random.nextInt(100);	//x坐标
			points[i][1]=random.nextInt(30);	//y坐标
		}
		
		//设置前景色
		graphics.setColor(new Color(0,0,0));
		
		//把点连成线
		for (int i = 1; i < points.length; i++) {
			graphics.drawLine(points[i-1][0],points [i-1][1], points[i][0], points[i][1]);
		}
		
		//随机生成验证码
		StringBuffer code= new StringBuffer();
		for (int i = 0; i < 4; i++) {
			code.append(random.nextInt(10));
		}
		//存储到session
		if (location!=null&&location.equals("admin")) {
			request.getSession().setAttribute("adminVerifyCode", code.toString());
		}else if(location!=null&&location.equals("user")){
			request.getSession().setAttribute("userVerifyCode", code.toString());
		}
		
		
		//设置前景色
				graphics.setColor(new Color(255,0,0));
		
		//设置字体
		graphics.setFont(new Font("新宋体", Font.PLAIN, 18));
		
		//输出文字 文字在图片中的坐标
		graphics.drawString(code.toString(), 10, 15);
		
		//释放资源
		graphics.dispose();
		
		//生成图片的流
		try {
			
			//字节数组输出流
			ByteArrayOutputStream baos = new ByteArrayOutputStream();

			//解析图片 把图片解析为 二进制输出流 并且是png格式
			ImageIO.write(image, "png", baos);
			
			//将输出流转换成字节数组
			byte [] buffer = baos.toByteArray();
			
			//将二进制数组转换为输入流
			inputStream= new ByteArrayInputStream(buffer);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return "success";
	}

	/**
	 * @return the inputStream
	 */
	public InputStream getInputStream() {
		return inputStream;
	}

	/**
	 * @param inputStream the inputStream to set
	 */
	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}

	@Override
	public void setServletRequest(HttpServletRequest request) {
		// TODO Auto-generated method stub
		this.request=request;
		
	}

	/**
	 * @return the location
	 */
	public String getLocation() {
		return location;
	}

	/**
	 * @param location the location to set
	 */
	public void setLocation(String location) {
		this.location = location;
	}
	
}

