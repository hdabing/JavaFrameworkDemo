//窗体加载完成后
$(window).load(function() {
	// 窗体内容自动适应窗体的大小
	autoFitSize();
	// 设置窗体尺寸变化的事件
	$(window).resize(autoFitSize);
});
/**
 * 让窗体内容自动适应窗体的大小
 * 
 * 
 * 开发时间：2016-6-20 上午11:56:43
 * 
 * @author AIThink
 */
function autoFitSize() {
	//获取窗体的高度
	var iHeight=$(window).height();
	//减去边界高度
	iHeight-=($(".menu").outerHeight()-$(".menu").height());
	//减去顶部高度
	iHeight-=$(".menu>.top").outerHeight();
	//减去底部高度
	iHeight-=$(".menu>.bottom").outerHeight();
	//减去菜单内容边界高度
	iHeight-=($(".menu>.content>.content1").outerHeight()-$(".menu>.content>.content1").height())+5;
	//设置菜单内容高度
	$(".menu>.content>.content1").height(iHeight);
	
}