//当窗体加载完毕后执行
$(window).load(
		function() {

			// 窗体内容与窗体自动适应
			autoFitResize();

			// 当窗体尺寸发生改变时运行
			$(window).resize(autoFitResize);

			// 读取默认Url
			var defaultUrl = $(
					".page-right>.content-page>.page>.content>.content1").attr(
					"default-url");
			// 打开默认Url的页面
			if (defaultUrl != null && defaultUrl != "") {
				// 读取页面标题
				var pageTitle = $(
						".page-right>.content-page>.page>.content>.content1")
						.attr("page-title");
				pageTitle = (pageTitle == null) ? "" : pageTitle;
				// 打开页面
				openPage(defaultUrl, pageTitle, false);
			}

			// 初始化菜单
			initMenu();

		});

/**
 * 窗体内容与窗体自动适应
 * 
 * 
 * 开发时间：2016-3-30 下午4:26:05
 * 
 * @author moshco zhu
 */
function autoFitResize() {

	// 读取窗体的高度
	var iWinHeight = $(window).height();
	
	

	// 左边菜单的高度
	var iMenuHeight = iWinHeight
			- $(".page-header").outerHeight()
			- $(".page-bottom").outerHeight()
			- ($(".page-left>.left-menu").outerHeight() - $(
					".page-left>.left-menu").height());

	// 设置左边菜单的高度
	$(".page-left>.left-menu").height(iMenuHeight);

	// 左边菜单内容的高度
	var iMenuContent1Height = iMenuHeight
			- $(".page-left>.left-menu>.top").outerHeight()
			- $(".page-left>.left-menu>.bottom").outerHeight()
			- ($(".page-left>.left-menu>.content>.content1").outerHeight() - $(
					".page-left>.left-menu>.content>.content1").height());
	// 设置左边菜单内容的高度
	$(".page-left>.left-menu>.content>.content1").height(iMenuContent1Height);

	// 右边页面内容的高度
	var iPageContent1Height = iWinHeight
			- $(".page-header").outerHeight()
			- $(".page-bottom").outerHeight()
			- ($(".page-right>.content-page>.page").outerHeight() - $(
					".page-right>.content-page>.page").height())
			- $(".page-right>.content-page>.page>.title").outerHeight()
			- $(".page-right>.content-page>.page>.footer").outerHeight()
			- ($(".page-right>.content-page>.page>.content>.content1")
					.outerHeight() - $(
					".page-right>.content-page>.page>.content>.content1")
					.height());
	// 设置右边页面内容的高度
	$(".page-right>.content-page>.page>.content>.content1").height(
			iPageContent1Height);

}

/**
 * 打开页面
 * 
 * 
 * 开发时间：2016-3-31 下午3:17:05
 * 
 * @author moshco zhu
 * @param url
 * @param pageTitle
 * @param removeMessage
 */
function openPage(url, pageTitle, removeMessage) {

	// 清空消息
	if (removeMessage == null || removeMessage) {
		$(".page-right>.content-page>.page>.content>.content1>.message")
				.empty().remove();
	}

	// 消息
	$(".page-right>.content-page>.page>.content>.content1>.content-panel")
			.html("正在加载页面内容......");

	// 加载页面内容
	$(".page-right>.content-page>.page>.content>.content1>.content-panel")
			.load(url);

	// 设置标题
	if (pageTitle != null) {
		$(".page-right>.content-page>.page>.title>.tab>.text").html(pageTitle);
	}

}

/**
 * 打开页面
 * 
 * 
 * 开发时间：2016-3-31 下午3:20:24
 * 
 * @author moshco zhu
 * @param oBtn
 */
function goPage(oBtn) {

	// 清空消息
	$(".page-right>.content-page>.page>.content>.content1>.message").empty()
			.remove();

	// 读取页面url
	var url = oBtn.attr("href");

	// 消息
	$(".page-right>.content-page>.page>.content>.content1>.content-panel")
			.html("正在加载页面内容......");

	// 加载页面内容
	$(".page-right>.content-page>.page>.content>.content1>.content-panel")
			.load(url);

	// 读取标题
	var pageTitle = oBtn.attr("page-title");
	// 设置标题
	if (pageTitle != null) {
		$(".page-right>.content-page>.page>.title>.tab>.text").html(pageTitle);
	}

	// 返回函数值
	return false;

}

/**
 * 初始化菜单
 * 
 * 
 * 开发时间：2016-4-1 上午8:47:36
 * 
 * @author moshco zhu
 */
function initMenu() {

	// 菜单容器
	var menuContainer = $(".page-left>.left-menu>.content>.content1");
	// context root
	var contextRoot = menuContainer.attr("context-path");
	// 菜单数据源
	var menuUrl = menuContainer.attr("menu-url");
	// 生成菜单
	menuContainer.tree({
		url : menuUrl,
		animate : true,
		checkbox : false,
		cascadeCheck : false,
		onlyLeafCheck : false,
		dnd : false,
		onClick : function(node) {
			if (node.attributes != null && node.attributes.url != null) {
				// 组装Url
				var url = contextRoot + node.attributes.url;
				// 打开url
				openPage(url, node.text);
			}
		},
		onDblClick : function(node) {
			$(this).tree("toggle", node.target);
		}
	});

}
