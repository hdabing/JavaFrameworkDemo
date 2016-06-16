$(function(){
	inintMenu();
});

/**
 * 初始化菜单 
 * 
 * 开发时间：May 30, 2016 10:47:27 AM
 * @author 你的姓名
 */
function inintMenu(){
	
	//菜单容器
	var menuContainer=$(".menu-tree");
	
	//url
	var url = menuContainer.attr("url");
	
	//d读取属性
	var contextPath =  menuContainer.attr("contextPath");
	//alert(url);
	//菜单参数
	var meunParam={
			url:url,
			animate:true,
		//	checkbox:false,
			cascade:true,
			onlyLeafCheck:false,
			dnd:false,
			onClick:function(node){
				
			//	$(".page-panel").html("点击事件触发");
				//url扩展属性
				var strUrl = null;
				
				//判断是否有扩展属性
				if(node.attributes==null||node.attributes.url==null||node.attributes.url=="#"){
					//alert("null");
					return;
				}
				//获取 扩展
				strUrl= node.attributes.url;
			//	alert(strUrl);
			//	$(".page-panel").html("获取到扩展属性："+strUrl+"；开始load");
				// 加载 对应的页面
				$(".page-panel").load(contextPath+strUrl);
				
			}
	}
	
	//构造菜单
	menuContainer.tree(meunParam);
	
} 