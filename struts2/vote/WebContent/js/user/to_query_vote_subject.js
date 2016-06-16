/**
 * 查询投票事件
 * @param btn
 */
function queryVoteSubject(btn){
	
	//获取表单对象
	var form = btn.parents("div.query-form-panel:first");
	
	//查询参数
	var queryParam ={};
	
	//投票标题
	queryParam["vsTitle"]=form.find("input[name=vsTitle]").val();
	
	//获取url
	var url = btn.attr("url");
	
	//显示消息
	$(".query-result-panel").html("正在查询数据·····");
	
	//发送Ajax请求
	$.post(url,queryParam,function(strHtml){
		//显示查询结果
		$(".query-result-panel").html(strHtml);
	});
}
/**
 *点击换页事件
 * @param oBtn
 */
function clickPage(oBtn){
	//url
	var url = oBtn.attr("href");
	//alert(url);
	
	//参数
	var queryParam = oBtn.attr("query-param");
	//alert(queryParam);
	
	$.post(url,queryParam,function(strHtml){
		//alert(strHtml);
		//显示查询结果
		$(".query-result-panel").html(strHtml);
	})
	return false;
}
/**
 * 区第几页
 * @param btn
 */
function goPage(btn){
	//url
	var url = btn.attr("url");
	
	//queryParam
	var queryParam = btn.attr("query-param");
	
	//pageIndex
	var pageIndex = btn.parents("td:first").find("input[name='pageIndex']").val();
	queryParam=queryParam+"&pageIndex="+pageIndex
	
	$.post(url,queryParam,function(strHtml){
		$(".query-result-panel").html(strHtml);
	})
}
/**
 * 每页显示几条数据
 * @param pageSize
 */
function changePageSize(pageSize){
	//url
	var url = pageSize.attr("url");
	
	//queryParam
	var queryParam = pageSize.attr("query-param");
	
	//pageSize
	var pageSizeValue = pageSize.val();
	queryParam=queryParam+"&pageSize="+pageSizeValue;
	$.post(url,queryParam,function(strHtml){
		$(".query-result-panel").html(strHtml);
	})
}
/**
 * 去投票
 * @param btn
 * @returns {Boolean}
 */
function pullSubject(btn){
	
	var url = btn.attr("href");
	var dialogDiv = $("<div />");
	$.post(url,function(result){
		
		dialogDiv.append(result);
	});
	dialogDiv.dialog({
		title : "投票", // 标题
		width : 400, // 宽度
		height : 400, // 高度
		collapsible : false, // 是否可折叠
		modal : true, // 模式窗口显示
		close : false, // 默认是否关闭
		cache : false, // 是否使用缓存
		onClose:function(){
			// 销毁窗体
			$(this).dialog("destroy");
		},
		
		buttons:{
			"关闭":function(){
				dialogDiv.dialog("close");
			},
			"投票":function(){
				addVoteItems(dialogDiv);
				
			}
		}
	});
	return false;
	}
/**
 * 保存投票结果
 * @param dialogDiv
 */
function addVoteItems(dialogDiv){
	var frm= dialogDiv.find("form")
	alert(frm.html());
	frm.form("submit",{
		onSubmit:function(){
			alert("submit");
		},
		success:function(result){
			showSubmitVoteOptionResult(result);
		}
	});
}

/**
 * 显示结果
 * @param result
 */
function showSubmitVoteOptionResult(result){
	// 构建对话框对象
	var dialogDiv = $("<div />");
	dialogDiv.append(result.message);

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
 * 显示投票
 * @param btn
 */
function showSubject(btn){
	var url = btn.attr("href");
	var dialogDiv = $("<div />");
	$.post(url,function(result){
		
		dialogDiv.append(result);
	});
	dialogDiv.dialog({
		title : "投票", // 标题
		width : 400, // 宽度
		height : 400, // 高度
		collapsible : false, // 是否可折叠
		modal : true, // 模式窗口显示
		close : false, // 默认是否关闭
		cache : false, // 是否使用缓存
		onClose:function(){
			// 销毁窗体
			$(this).dialog("destroy");
		},
		
		buttons:{
			"关闭":function(){
				dialogDiv.dialog("close");
			}
		}
	});
	return false;
}
