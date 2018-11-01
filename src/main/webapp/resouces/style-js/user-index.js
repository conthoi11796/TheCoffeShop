/*nav-search*/
$(function() {
	$('.nav-search input').click(function() {
		$('.nav-search button').css({
			"background-color" : "#4c4c4c",
			"color" : "white"
		});
	});
	$('.nav-search input').mouseleave(function() {
		$('.nav-search button').css({
			"background-color" : "#d4c9c9",
			"color" : "#4e4e4e"
		});
	});
});
/* End nav-search */
/*-------------------------------------------------------------------------*/
/* Quan tam */
$(function() {
	$('.add-to-wishlist').click(function() {
		// alert($(".add-to-wishlist").attr("id"));
		var class_exist = $(".add-to-wishlist > i").attr("class");
		// alert(class_exist);
		var address = "#" + $(".add-to-wishlist").attr("id") + " i";
		// alert(address);
		if (class_exist.search("fa-heart-o") != -1) {
			// exist
			$(address).addClass("fa-heart");
			$(address).removeClass("fa-heart-o");
		} else {
			// not exist
			$(address).addClass("fa-heart-o");
			$(address).removeClass("fa-heart");
		}
	});
});
/* End Quan tam */
/* Navs */
$(function() {
	$('#myTab li:first-child a').tab('show');
});
/* End Navs */
/* Add row table */
$(function() {
	$('.btn-light').click(function() {
		for (var i = 0; i < 1000; i++) {
			$("#btn-add").fadeToggle("slow");
		}
	});
	$('#btn-add')
			.click(
					function() {
						var text = '<tr class=""><td></td><td class="btn-menu-products"<button class="btn btn-light" data-toggle="modal" data-target="#exampleModal-2" data-whatever="@mdo"><i class="  icon-wallet"></i>Chọn món</button></td><td><form><input class="form-input-quanlity" type="text" placeholder=""></form></td><td></td><td></td></tr>';
						$("#sortable-table-2 tbody").append(text);

					});
})
/* End Add row table */
/* Box-chat */
$(function() {
	$("#btn-show").show();
	$("#btn-hidden").hide();
	$("#display-chat").hide();
	$("#btn-show").click(function() {
		$("#btn-show").hide();
		$("#btn-hidden").show();
		$("#display-chat").show();
		$("#div-box-chat").css("height", "250px");
	});
	$("#btn-hidden").click(function() {
		$("#btn-show").show();
		$("#btn-hidden").hide();
		$("#display-chat").hide();
		$("#div-box-chat").css("height", "37px");
	});
})
/* End Box-chat */
/* Add to cart */
function addToCart(PId) {
	 $.post("demo_test_post.asp",
			    {
		 			PId
			    },
			    function(data, status){
			        alert("Data: " + data + "\nStatus: " + status);
			    });
}
/* End Add to cart */
