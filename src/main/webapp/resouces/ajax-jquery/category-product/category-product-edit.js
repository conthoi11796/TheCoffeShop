$(function() {

	$("#btnUpdate").click(function() {
		$.post("/admin/category-product/edit", {
			categoryproductid : $("#categoryproductid").val(),
			name : $("#name").val()
		}, function(data, status) {
			$("#result-form").html(data);
			$("#result-form").fadeOut(3000);
			_list(link, 1);
		});
	});
});