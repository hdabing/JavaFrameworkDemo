
/**
 * 增加报销记录
 * @param btn
 */
function addCliamVoucherItem(btn){
	
	try {
		
		
		//读取保单对象
		var oform=  btn.parents("form:first");
		
		//找寻模板行
		var templateRow =oform.find("tr.row.template");
		
		//复制模板
		var newRow =  templateRow.clone(true);
		
		//去除样式
		newRow.removeClass("template").css("display","");
		
		
		
		//找寻路入行
		var unconfirmRow = oform.find("tr.row.unconfirm");
		
		//报销项目
		var  item = unconfirmRow.find("select[name=item]").val();
		
		if(item=="-1"){
			alert("请选择一个报销项目");
			return true ;
		}
		
		//将新行添加到末班航的前面
		templateRow.before(newRow);
		
		//在新行设置 item 
		newRow.find("input[name=item]").val(item);
		
		//将UNconfirm的值设置为空
		unconfirmRow.find("select[name=item]").val();
		
		//报销金额
		var  account = unconfirmRow.find("input[name=account]").val();
		newRow.find("input[name=account]").val(account);
		unconfirmRow.find("input[name=account]").val("");
		
		//描述
		var  desc = unconfirmRow.find("input[name=desc]").val();
		newRow.find("input[name=desc]").val(desc);
		unconfirmRow.find("input[name=desc]").val("");
		
		//重新运算总计金额
		
		totalAccount(oform);
	} catch (e) {
		alert(e.message);
	}
	
	
}
/**
 * 重新运算总计金额
 * @param form
 */
function totalAccount(form){
	
	//明细总计金额
	var totalMoney = 0.0;
	
	//合计明细金额 查询里面每一行
	form.find("tr.row").each(function(){
		//模板行和录入行不在计算范围内
		if($(this).hasClass("template"||$(this).hasClass("unconfirm"))){
			return true;
		}
		//合计
		var strMoney =$(this).find("input[name=account]").val();
		if (isNaN(parseFloat(strMoney))) {
			return true;
		}
		totalMoney+=parseFloat(strMoney);
		
	});
	//alert("totalMoney:"+totalMoney);
	//設置給總計金額
	form.find("input[name='claimVoucher.totalAccount']").val(totalMoney);
	
}
/**
 * 删除报销记录
 * @param btn
 */
function removeClaimVoucherItem(btn){
	
	try {
		//找到表单
		var form = btn.parents("form:first");
		
		//删除按钮所在行
		btn.parents("tr:first").empty().remove();
		
		//重新运算金额
		totalAccount(form);
	} catch (e) {
		alert(e.message);
	}
	
}
/**
 * 表单提交事件
 * 验证提交报销单的表单
 * @param form
 */
function checkfrmSubmitClaimVoucher(form){
	//至少添加一条数据才能提交
	var detailRowNum = 0;
	form.find("tr.row").each(function(){
		if($(this).hasClass("template")||$(this).hasClass("unconfirm")){
			
			return true;
		}
		detailRowNum++;
		
	});
	if (detailRowNum<=0) {
		alert("至少需要一个报销项");
		return false;
	}
	//删除模板行
	form.find("tr.template").empty().remove();
	
	//删除路入行
	form.find("tr.unconfirm").empty().remove();
	
	return true;
}