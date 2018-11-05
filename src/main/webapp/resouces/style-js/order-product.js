/**
 * 
 */

function countPrice() {
		var countElement = $("tbody tr").length;
		for (var i = 0; i < countElement; i++) {
			var number = $("tbody tr td input:eq("+i+")").val();
			var price = $("tbody tr td label:eq("+i+")").text().trim();
			$("tbody tr td:nth-child(4)").text(number*price);
		}
}

$(function () {

	document.querySelector("#biDatetimeStart").valueAsDate = new Date();
	
	$("tbody tr td input").change(function(){
		countPrice();
	});
});