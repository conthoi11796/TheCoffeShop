/**
 * 
 */

$(".remove").click(function () {
	var id=$(this).attr('data-productid');
	$('#'+id).remove();
});

$("#btnSearch").click(function() {
	var inputSearch = $('#inputSearch').val();
	$.get("/admin/index-modal", {
		dinnertableid : $("#dinnertableid").val(),
		startPosition : 0,
		inputSearch : $('#inputSearch').val()
	}, function(data, status) {
		$('.modal-body').html(data);
	});
});

$("#btnCapNhatTrangThaiBan").click(function() {
var dinnertableid = $("#dinnertableid").val();
	$.post("/admin/index-updateTableStatus", {
		dinnertableid,
		tablestatusid : $("#tablestatusid").val()
	}, function(data, status) {
		var obj = JSON.parse(data);
		$('#exampleModalLabel div').attr("class","");
		$('#exampleModalLabel div').attr("class",obj.class);
		$('#exampleModalLabel div').html(obj.mes);
		$("#exampleModalLabel").fadeToggle(3000);
		
		if(obj.nameTableStatus != ""){
			$('#'+dinnertableid).text(obj.nameTableStatus);
		}

		$(".stretch-card").click();
	});
});

$("#btnThemVaoHoaDon").click(function() {
					var countTr = $(".add-food .stretch-card").length;
					var list = [];
					for (var i = 0; i < countTr; i++) {
						list[i] = {
							productid : $(
									".add-food .stretch-card input:eq(" + i
											+ ")").attr('data-productid'),
							quantity : $(
									".add-food .stretch-card input:eq(" + i
											+ ")").val()
						};
					}
					var listProduct = {
						listProduct : list
					};
					$.post("/admin/index-updateBillDetail", {
						dinnertableid : $("#dinnertableid").val(),
						listProduct : JSON.stringify(listProduct)
					}, function(data, status) {
						$('#exampleModalLabel').html(data);
						$("#exampleModalLabel").fadeToggle(3000);

						$(".stretch-card").click();
					});
				});

$("#btnLuuChinhSua").click(function () {
	
	var countTr = $("#bill tbody tr").length;
	var list = [];
	for (var i = 0; i < countTr; i++) {
		list[i] = {
			productid : $( "#bill tbody tr:eq(" + i + ")").attr('data-productid')
		};
	}
	var listProduct = {
		listProduct : list
	};
	
	$.post("/admin/index-updateBill", {
		billid : $(this).attr('data-billid'),
		listProduct : JSON.stringify(listProduct)
	}, function(data, status) {
		$('#exampleModalLabel').html(data);
		$("#exampleModalLabel").fadeToggle(3000);

		$(".stretch-card").click();
	});
});

$("#btnThanhToan").click(function() {
	$.post("/admin/index-updateBillStatus", {
		billid : $(this).attr('data-billid')
	}, function(data, status) {
		$('#exampleModalLabel').html(data);
		$("#exampleModalLabel").fadeToggle(3000);

		$(".stretch-card").click();
	});
});

function _modalContent(dinnertableid, startPosition, inputSearch) {
	$.get("/admin/index-modal", {
		dinnertableid,
		startPosition,
		inputSearch
	}, function(data, status) {
		$('.modal-body').html(data);
	});
}

_loadPagination(1);// at loadTable.js
hide_all_Pagination();
_hide_show_Pagination(1, "right");// at loadTable.js

$(".pa").click(function() {
	$(".active").removeClass("active");
	$(this).addClass("active");

	_modalContent($("#dinnertableid").val(), $(this).attr("data-startPosition"), '');
});

$(".right").click(
		function() {
			$(".active").removeClass("active");
			$(
					"[data-startPosition='"
							+ $(this).attr("data-startPosition") + "']")
					.addClass("active");
			
			_modalContent($("#dinnertableid").val(), $(this).attr("data-startPosition"), '');
			_hide_show_Pagination($(this).attr("data-startPosition"), "right");// at
			// loadTable.js
		});
$(".left").click(function() {

	_modalContent($("#dinnertableid").val(), $(this).attr("data-startPosition"), '');
	_hide_show_Pagination($(this).attr("data-startPosition"), "left");// at
	// loadTable.js
});