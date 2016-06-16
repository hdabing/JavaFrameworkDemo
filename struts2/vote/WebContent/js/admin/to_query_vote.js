/**
 * 初始化投票列表
 * 
 * 
 * 开发时间：Jun 1, 2016 11:48:30 AM
 * 
 * @author 你的姓名
 */
function initVoteList() {

	// 数据表
	var voteGrid = $(".query-result-panel");

	// 读取url
	var url = voteGrid.attr("url");

	// 列的参数
	var columns = [ [ {
		field : "vsId",
		checkbox : true,
		align : "center"

	}, {
		field : "vsTitle",
		title : "标题",
		width : 150,
		align : "left"
	}, {
		field : "vsType",
		title : "投票类型",
		width : 50,
		align : "center",
		formatter : function(value) {
			if (value == 1) {
				return "单选";
			}
			return "多选";
		}
	}, {
		field : "totalOption",
		title : "选项数量",
		width : 40,
		align : "center"
	}, {
		field : "totalUser",
		title : "投票人数",
		width : 40,
		align : "center"
	}, {
		field : "operator",
		title : "操作",
		width : 100,
		align : "center",
		formatter : function(value, record, index) {
			var strHtml = $(".operator").html();
			// alert(strHtml);
			/* javascript 正则表达式 g表示全局匹配 / #id / */
			strHtml = strHtml.replace(/#id/g, record.vsId);

			return strHtml;
		}
	}

	] ];

	// 表格参数
	var voteGridParam = {
		url : url, // 数据源
		queryParams : {}, // 查询参数
		pagination : true, // 分页条显示
		pageSize : 10, // 初始分页尺寸
		pageList : [ 2, 5, 10, 15, 20 ], // 页面尺寸列表
		columns : columns, // 定义列
		singleSelect : true, // 单个选择
		rowNumbers : true, // 行号显示
		iconCls : "icon-search", // 图标
		fitColumns : true, // 自动适应列宽度
		stripted : true, // 隔行变色
		loadMsg : "正在查询投票数据····"// 加载时显示的消息

	};

	// 生成表格
	voteGrid.datagrid(voteGridParam);

}
/** 调用 */
initVoteList();

function queryParam() {

	// 数据表
	var voteGrid = $(".query-result-panel");

	// 读取url
	var url = voteGrid.attr("url");
	// 标题
	var title = $("input[name=vsTitle]").val();

	// alert(title);

	// 绑定参数开始
	var param = voteGrid.datagrid("options").queryParams;

	param["vsTitle"] = title;

	// url
	var url = voteGrid.attr("url");
	// alert(url);
	voteGrid.datagrid("load");

	/*
	 * $.getJSON(url,param,function(result){ //alert(result.rows);
	 * voteGrid.datagrid("loadData",result); });
	 */

}

/**
 * 显示连接 点击事件
 * 
 * 
 * 开发时间：Jun 2, 2016 8:44:24 AM
 * 
 * @author 你的姓名
 * @param a
 */
function showVoteSubject(a) {

	try {
		// url
		var url = a.attr("href");

		// 对话框对应的jQuery对象
		var dialog = $("<div/>");
		// alert(url);
		// 动态创建对话框
		var showVoteSubjectDialog = dialog.dialog({
			title : "投票信息", // 标题
			width : 400, // 宽度
			height : 400, // 高度
			collapsible : false, // 是否可折叠
			modal : true, // 模式窗口显示
			close : false, // 默认是否关闭
			cache : false, // 是否使用缓存
			href : url, // 对话框页面内容
			onClose : function() { // 关闭
				// 销毁窗体
				$(this).dialog("destroy");
			},
			buttons : [ {
				text : "关闭",
				handler : function() {
					showVoteSubjectDialog.dialog("close");
				}
			} ]
		});
	} catch (e) {
		// TODO: handle exception
		alert(e.message);
	}
	return false;
}

/**
 * 删除 投票
 * 
 * 
 * 开发时间：Jun 2, 2016 10:55:00 AM
 * 
 * @author 你的姓名
 * @param oBtn
 */
function removeVoteSubject(a) {
	try {
		// url
		var url = a.attr("href");

		// 对话框对应的jQuery对象
		var dialog = $("<div/>");

		// 动态创建对话框
		var showVoteSubjectDialog = dialog.dialog({
			title : "删除投票", // 标题
			width : 400, // 宽度
			height : 400, // 高度
			collapsible : false, // 是否可折叠
			modal : true, // 模式窗口显示
			close : false, // 默认是否关闭
			cache : false, // 是否使用缓存
			href : url, // 对话框页面内容
			onClose : function() { // 关闭
				// 销毁窗体
				$(this).dialog("destroy");
			},
			buttons : [ {
				text : "关闭",
				handler : function() {
					showVoteSubjectDialog.dialog("close");
				}
			}, {
				text : "确认删除",
				handler : function() {
					// 删除投票
					confirmRemoveVoteSubject(dialog);
				}

			} ]
		});

	} catch (e) {
		alert(e.message);
	}
	return false;
}
/**
 * 删除投票
 * 
 * 
 * 开发时间：Jun 2, 2016 11:30:14 AM
 * 
 * @author mxc
 * @param dialog
 */
function confirmRemoveVoteSubject(dialog) {

	// 发送请求：
	dialog.find("form").form("submit", {
		onSubmit : function() {

		},
		success : function(strHtml) {// 发送之后成功的异步函数
			// 关闭原有的对话框
			dialog.dialog("close");
			// 刷新 datagrid列表
			$(".query-result-panel").datagrid("reload");
			// 显示结果信息的对话框
			showRemoveVoteSubjectResult(strHtml);
		}
	});
}

/**
 * 删除消息显示
 * 
 * 
 * 开发时间：Jun 2, 2016 11:53:30 AM
 * 
 * @author mxc
 * @param strHtml
 */
function showRemoveVoteSubjectResult(strHtml) {

	// 构建对话框对象
	var dialogDiv = $(strHtml);

	dialogDiv.dialog({
		title : "删除投票结果", // 标题
		width : 400, // 宽度
		height : 200, // 高度
		collapsible : false, // 是否可折叠
		modal : true, // 模式窗口显示
		close : false, // 默认是否关闭
		cache : false, // 是否使用缓存

		onClose : function() { // 关闭
			// 销毁窗体
			$(this).dialog("destroy");
		},
		buttons : [ {
			text : "关闭",
			handler : function() {
				dialogDiv.dialog("close");
			}

		} ]
	});
}

/**
 * 去添加 投票 弹出对话框，去添加内容
 * 
 * 开发时间：Jun 2, 2016 2:10:23 PM
 * 
 * @author mxc
 * @param oBtn
 */
function toAddVoteSubject(oBtn) {
	try {

		var url = oBtn.attr("href");

		// 动态 构建
		var dialogDiv = $("<div />");

		dialogDiv.dialog({
			title : "添加投票", // 标题
			width : 400, // 宽度
			height : 400, // 高度
			collapsible : false, // 是否可折叠
			modal : true, // 模式窗口显示
			close : false, // 默认是否关闭
			cache : false, // 是否使用缓存
			href : url,
			onClose : function() { // 关闭
				// 销毁窗体
				$(this).dialog("destroy");
			},
			buttons : [ {
				text : "关闭",
				handler : function() {
					dialogDiv.dialog("close");
				}

			}, {
				text : "确认添加",
				handler : function() {
					addVoteSubject(dialogDiv);
				}

			} ],
			onLoad : function() {
				var jsUrl = dialogDiv.find(".page-panel-content").attr("js");
				$.getScript(jsUrl);
			}

		});

	} catch (e) {
		alert(e.message);
	}
	return false;
}

/**
 * 保存新添加的投票
 * 
 * 
 * 开发时间：Jun 3, 2016 8:40:03 AM
 * 
 * @author mxc
 * @param dialogDiv
 */
function addVoteSubject(dialogDiv) {

	// 动态构建表单，并 执行submit 执行 Ajax请求
	dialogDiv.find("form").form("submit", {
		onSubmit : function() {

			// 将模板和 录入框 删除
			$(this).find(".row.template").empty().remove();
			 $(this).find(".row.unconfirm").empty().remove();
		},
		success : function(strHTML) {

			// 将现有对话框关闭
			dialogDiv.dialog("close");

			// 刷新列表数据
			$(".query-result-panel").datagrid("load");

			// 显示结果信息
			showAddVoteSubjectResult(strHTML);
		}
	});
}

/**
 * 
 * 
 * 
 * 开发时间：Jun 3, 2016 8:53:23 AM
 * 
 * @author 你的姓名
 * @param strHtml
 */
function showAddVoteSubjectResult(strHtml) {
	
	// 构建对话框对象
	var dialogDiv = $("<div />");
	dialogDiv.append(strHtml);

	dialogDiv.dialog({
		title : "添加投票结果", // 标题
		width : 400, // 宽度
		height : 400, // 高度
		collapsible : false, // 是否可折叠
		modal : true, // 模式窗口显示
		close : false, // 默认是否关闭
		cache : false, // 是否使用缓存

		onClose : function() { // 关闭
			// 销毁窗体
			$(this).dialog("destroy");
		},
		buttons : [ {
			text : "关闭",
			handler : function() {
				dialogDiv.dialog("close");
			}

		} ]
	});
}

/**
 * 去编辑投票
 * 
 * 
 * 开发时间：Jun 3, 2016 10:51:22 AM
 * 
 * @author mxc
 * @param oBtn
 */
function toEditVoteSubject(oBtn) {

	try {

		// action 名字
		var url = oBtn.attr("href");

		var dialogDiv = $("<div />");

		dialogDiv.dialog({
			title : "投票编辑", // 标题
			width : 400, // 宽度
			height : 400, // 高度
			collapsible : false, // 是否可折叠
			modal : true, // 模式窗口显示
			close : false, // 默认是否关闭
			cache : false, // 是否使用缓存
			href : url,
			onClose : function() { // 关闭
				// 销毁窗体
				$(this).dialog("destroy");
			},
			buttons : [ {
				text : "关闭",
				handler : function() {
					dialogDiv.dialog("close");
				}

			}, {
				text : "确认修改",
				handler : function() {
					editVoteSubject(dialogDiv);
				}

			} ],
			onLoad : function() {
				var jsUrl = dialogDiv.find(".page-panel-content").attr("js");
				$.getScript(jsUrl);
			}

		});

	} catch (e) {
		alert(e.message);
	}
	return false;
}

/**
 * 修改保存投票
 * 
 * 
 * 开发时间：Jun 3, 2016 12:07:44 PM
 * 
 * @author 你的姓名
 * @param dialogDiv
 */
function editVoteSubject(dialogDiv) {

	// 构建form 提交请求
	dialogDiv.find("form").form("submit", {
		onSubmit : function() {
			// 将模板和 录入框 删除
			$(this).find(".row.template").empty().remove();
			$(this).find(".row.unconfirm").empty().remove();
		},
		success : function(strHTML) {
			// 将现有对话框关闭
			dialogDiv.dialog("close");
			
			// 刷新列表数据
			$(".query-result-panel").datagrid("reload");
			
			// 显示结果信息
			showEditVoteSubjectResult(strHTML);
		}
	});
}

/**
 * 显示
 * 
 * 
 * 开发时间：Jun 3, 2016 12:11:28 PM
 * @author mxc
 * @param strHTML
 */
function 	showEditVoteSubjectResult(strHTML){

	// 构建对话框对象
	var dialogDiv = $("<div />");
	dialogDiv.append(strHTML);

	dialogDiv.dialog({
		title : "编辑投票结果", // 标题
		width : 400, // 宽度
		height : 400, // 高度
		collapsible : false, // 是否可折叠
		modal : true, // 模式窗口显示
		close : false, // 默认是否关闭
		cache : false, // 是否使用缓存

		onClose : function() { // 关闭
			// 销毁窗体
			$(this).dialog("destroy");
		},
		buttons : [ {
			text : "关闭",
			handler : function() {
				dialogDiv.dialog("close");
			}

		} ]
	});
}
