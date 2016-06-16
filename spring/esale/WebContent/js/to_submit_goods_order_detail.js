/**
 * 改变商品价格
 * @param oBtn
 */
function changeGoods(oBtn) {
	
	// 读取价格
	var price = oBtn.find("option:selected").attr("price");
	// 找寻表单对象
	var oForm = oBtn.parents("tr:first");
	// 找寻单价字段
	oForm.find("input[name='detail.price']").val(price);

}

/**
 * 确认删除订单明细
 * 
 * 
 * 开发时间：2016-3-11 下午4:44:25
 * 
 * @author mxc
 * @returns {Boolean}
 */
function confirmRemove() {
	if (window.confirm("你确认要删除这个订单明细记录吗？")) {
		return true;
	}
	return false;
}
