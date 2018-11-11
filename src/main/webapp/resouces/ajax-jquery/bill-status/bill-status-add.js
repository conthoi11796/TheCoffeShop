$(function() {
	$(".remove").click(function() {
		$.post("/admin/bill-status/remove", {
			billstatusid : $(this).attr("data-billstatusid")
		}, function(data, status) {
			$("#result-tbody").html(data);
			_list();// at loadTable.js
		});
	});

	$(".edit").click(function() {
		$.get("/admin/bill-status/edit", {
			billstatusid : $(this).attr("data-billstatusid")
		}, function(data, status) {
			$("#billStatus_form").html(data);
		});
	});
});