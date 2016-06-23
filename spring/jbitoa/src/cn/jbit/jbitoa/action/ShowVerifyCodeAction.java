package cn.jbit.jbitoa.action;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.Serializable;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;
/**
 * 验证码生成
 * @author mxc  
 * @date 2016年6月16日 下午2:36:48
 */
public class ShowVerifyCodeAction implements Serializable,ServletRequestAware {


	//验证码图片输入流
	protected InputStream inputStream = null;
	
	protected HttpServletRequest request = null;
	
	/**
	 * 业务实现
	 * 2016年6月16日下午2:37:57 
	 * @author mxc  
	 *  @return
	 */
	public String execute() {
		
		//创建图片对象
		BufferedImage image = new BufferedImage(60, 24, BufferedImage.TYPE_INT_RGB);
		
		//获取图片画笔
		Graphics graphics = image.getGraphics();
		
		//图片填充为白色
		graphics.setColor(new Color(255, 255, 255));
		
		//填充图片
		graphics.fillRect(0, 0, 60, 24);
		
		//创建随机对象
		Random random = new Random(System.currentTimeMillis());
		
		//创建点的坐标  二维数组
		int[][] aryPoint = new int[9][2];
		
		//生成随机的点
		for (int i = 0; i < aryPoint.length; i++) {
			aryPoint[i][0]=random.nextInt(60);
			aryPoint[i][1]=random.nextInt(24);
		}
		
		//设置点的颜色
		graphics.setColor(new Color(0, 0, 0));
		
		//将点连成线
		for (int i = 1; i < aryPoint.length; i++) {
			graphics.drawLine(aryPoint[i-1][0], aryPoint[i-1][1], aryPoint[i][0], aryPoint[i][1]);
		}
			
		//生成随机验证码
		String verifyCode = "";
		for (int i = 0; i < 4; i++) {
			verifyCode+=random.nextInt(10);
		}
		
		//设置前景色 就是 码的颜色
		graphics.setColor(new Color(255,0,0));
		
		//设置字体
		graphics.setFont(new Font("新宋体", Font.PLAIN, 15));
		
		//绘制验证码   将验证码绘制在图片上
		graphics.drawString(verifyCode, 10, 15);
		
		//将验证码保存到session中
		request.getSession().setAttribute("verfiyCdoe", verifyCode);
		
		//释放资源
		graphics.dispose();
		
		try {
			//将图片写进输出流
			
			ByteArrayOutputStream bos  = new ByteArrayOutputStream();
			
			ImageIO.write(image, "png", bos);
			
			//将输出流转为二进制数组
			byte[] buffer = bos.toByteArray();
			
			//将二进制数组封装为输入流
			inputStream= new ByteArrayInputStream(buffer);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
				
				
				
		return "success";
	}

	public InputStream getInputStream() {
		return inputStream;
	}

	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}

	@Override
	public void setServletRequest(HttpServletRequest request) {
		// TODO Auto-generated method stub
		this.request= request;
	}
	
	
}
