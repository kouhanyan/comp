$(function() {

});

function opeanDialogSeries(uri, top, left, width, height) {
	var info = "top="
			+ top
			+ ",left="
			+ left
			+ ",toolbar=yes, location=no,directories=no, status=no, menubar=yes, scrollbars=yes, resizable=yes,copyhistory=yes, width="
			+ width + ", height=" + height;
	window.open(uri, "_blank", info,false);
}

function ajaxAddBiblioTemp(uri) {
	var id = $("#id").val();
	var isbn = $("#isbn").val();
	var classNo = $("#classNo").val();
	var orderNo = $("#orderNo").val();
	var price = $("#price").val();
	var totalPrice = $("#totalPrice").val();
	var title = $("#title").val();
	var author = $("#author").val();
	var address = $("#address").val();
	var publisher = $("#publisher").val();
	var publishDate = $("#publishDate").val();
	var frequency = $("#frequency").val();
	var unionNo = $("#unionNo").val();
	var isShare = $("#isShare").val();
	var data = {
		"id" : id,
		"isbn" : isbn,
		"classNo" : classNo,
		"orderNo" : orderNo,
		"price" : price,
		"totalPrice" : totalPrice,
		"title" : title,
		"author" : author,
		"address" : address,
		"publisher" : publisher,
		"publishDate" : publishDate,
		"frequency" : frequency,
		"unionNo" : unionNo,
		"isShare" : isShare
	};
	$.ajax({
		url : uri,
		type : "POST",
		dataType : "text",
		data : data,
		async : false,
		cache : false,
		success : function(data) {
			if (data == "ok") {
				alert("操作成功");
				self.opener.location.reload();
				window.close();
			}
		}
	});

}

function addMarcDialog(uri){
	var biblioTempId = $("input[name='biblioTempId']").val();
	var marcFieldskey0 = $("input[name='marcFields[0].key']").val();
	var marcFieldskey1 = $("input[name='marcFields[1].key']").val();
	var marcFieldskey2 = $("input[name='marcFields[2].key']").val();
	var marcFieldskey3 = $("input[name='marcFields[3].key']").val();
	var marcFieldskey4 = $("input[name='marcFields[4].key']").val();
	var marcFieldskey5 = $("input[name='marcFields[5].key']").val();
	var marcFieldskey6 = $("input[name='marcFields[6].key']").val();
	var marcFieldskey7 = $("input[name='marcFields[7].key']").val();
	var marcFieldskey8 = $("input[name='marcFields[8].key']").val();
	var marcFieldskey9 = $("input[name='marcFields[9].key']").val();
	var marcFieldscontent0 = $("textarea[name='marcFields[0].content']").html();
	var marcFieldscontent1 = $("textarea[name='marcFields[1].content']").html();
	var marcFieldscontent2 = $("textarea[name='marcFields[2].content']").html();
	var marcFieldscontent3 = $("textarea[name='marcFields[3].content']").html();
	var marcFieldscontent4 = $("textarea[name='marcFields[4].content']").html();
	var marcFieldscontent5 = $("textarea[name='marcFields[5].content']").html();
	var marcFieldscontent6 = $("textarea[name='marcFields[6].content']").html();
	var marcFieldscontent7 = $("textarea[name='marcFields[7].content']").html();
	var marcFieldscontent8 = $("textarea[name='marcFields[8].content']").html();
	var marcFieldscontent9 = $("textarea[name='marcFields[9].content']").html();
	var data = {
			"marcFields[0].key" :  marcFieldskey0,
			"marcFields[0].content" : marcFieldscontent0,
			"marcFields[1].key" :  marcFieldskey1,
			"marcFields[1].content" : marcFieldscontent1,
			"marcFields[2].key" :  marcFieldskey2,
			"marcFields[2].content" : marcFieldscontent2,
			"marcFields[3].key" :  marcFieldskey3,
			"marcFields[3].content" : marcFieldscontent3,
			"marcFields[4].key" :  marcFieldskey4,
			"marcFields[4].content" : marcFieldscontent4,
			"marcFields[5].key" :  marcFieldskey5,
			"marcFields[5].content" : marcFieldscontent5,
			"marcFields[6].key" :  marcFieldskey6,
			"marcFields[6].content" : marcFieldscontent6,
			"marcFields[7].key" :  marcFieldskey7,
			"marcFields[7].content" : marcFieldscontent7,
			"marcFields[8].key" :  marcFieldskey8,
			"marcFields[8].content" : marcFieldscontent8,
			"marcFields[9].key" :  marcFieldskey9,
			"marcFields[9].content" : marcFieldscontent9,
			"biblioTempId" : biblioTempId
	};
	$.ajax({
		url : uri,
		type : "POST",
		dataType : "text",
		data : data,
		async : false,
		cache : false,
		success : function(data) {
			if (data == "ok") {
				alert("操作成功");
				self.opener.location.reload();
				window.close();
			}
		}
	});
	
	
}

function editDialog(uri){
	var id = '';
	$("[name='checks']").each(function() {
		if ($(this).attr("checked")) {
			id = $(this).val();
		}
	});
	if (id == '') {
		alert("请选择一个记录！");
		return;
	}
	opeanDialogSeries(uri.replace(/#id#/, id),50,200,1200,600);
	
}











