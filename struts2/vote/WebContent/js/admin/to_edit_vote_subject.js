/**去添加对话框的JavaScript代码*/


/**
 * 添加投票选项
 * 
 * 将模板div 的内容 clone 出来一份 
 * 放入 在 原来输入框之上的 容器内（data-list）
 * 这样，原来的的框就在新添加的框下面 
 * 把原来输入框的值取出来，放入刚clone出来的额模板中  
 * 这样 值就放入了 新添加的框中 ，
 * 再把 原来的框 值 设置为空 
 * 就实现了 原来的值出现在新的输入框中， 旧的输入框 后置 成为了空的模板
 */
function addVoteOptionRow(oBtn){
	
	//找出模板行
	var template = oBtn.parents(".vote-option-list:first").find(".template");
	
	//copy 内容
	var newRow = template.find(">.row").clone();
	
	//找到数据行
	var dataRow =  oBtn.parents(".vote-option-list:first").find(".data-list");

	//将模板行的内容放入数据行
	dataRow.append(newRow);
	
	//录入行
	var unconfirmRow = oBtn.parents(".unconfirm:first");
	
	var voOption = unconfirmRow.find("input[name=voOption]").val();
	
	//设置给新行
	newRow.find("input[name=voOption]").val(voOption);
	
	//原来的滞空
	unconfirmRow.find("input[name=voOption]").val("");
	
}


/**
 * 删除当前选项
 * 
 * 
 * 开发时间：Jun 2, 2016 4:26:21 PM
 * @author 你的姓名
 * @param oBtn
 */
function removeVoteOptionRow(oBtn){
	try {
		
		oBtn.parents(".row:first").empty().remove();
		
	} catch (e) {
		alert(e.message);
	}
}