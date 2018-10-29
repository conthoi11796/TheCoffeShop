/**
 * 
 */

$(document).ready(
		function() { 
			
			$("#notifyResult").hide();

/*---------------------------------------------------------------*/
			/** Create PId */
			$("#PName").blur(function() {

// alert($(this).val());
				$.get("/admin/add-product/createPId", {
					PName : $(this).val()
				}, function(data, status) {
					 // alert("Data: " + data + "\nStatus: " + status);
					if(data!=null){
						$("#ShowPId").val(data);
						$("#PId").val(data);
					}
				});

			});
			/** Create PId [END] */
/*---------------------------------------------------------------*/
			/** Check formProduct */
			function _checkFormProduct() {
// True
				if ($("#PName").val() != "" && $("#prPrice").val() != ""
						&& $("#prDatestart").val() != "") {
					$("#btnStep1").removeClass("btn-disable");
					$("#btnStep1").addClass("btn-success");
					return true;
				} 
// False
				else {
					$("#btnStep1").removeClass("btn-success");
					$("#btnStep1").addClass("btn-disable");
					return false;
				}
			}

			$("#PName").mouseleave(function() {
				_checkFormProduct();
			});
			$("#prPrice").mouseleave(function() {
				_checkFormProduct();
			});
			$("#prDatestart").mouseleave(function() {

				_checkFormProduct();
			});
			/** Check formProduct [END] */
/*---------------------------------------------------------------*/
			/** Effect Clean Button */
			$("#btnClean1").click(function(){
				document.getElementById("formProduct").reset();
			});
			$("#btnClean2").click(function(){
				document.getElementById("formCateGoryProduct").reset();
			});
			/** Effect Clean Button [END] */
/*---------------------------------------------------------------*/
			/** Effect and check formCategoryProduct */
			$("#cgPrdId").change(function() {
// alert($(this).val());
				$("#ShowcgPrdId").val($(this).val());
				
				$("#btnStep2").removeClass("btn-disable");
				$("#btnStep2").addClass("btn-success");

			});
			/** Effect and check formCategoryProduct [END] */
/*---------------------------------------------------------------*/
			/** Effect TabContent */
			function _effect(idTabOld, idTabNew, idTabContentOld,
					idTabContentNew) {
				$(idTabOld).toggleClass("active show");
				$(idTabNew).toggleClass("active show");

				$(idTabContentOld).toggleClass("active show");
				$(idTabContentNew).toggleClass("active show");
			}

			$("#btnStep1").click(function() {
				_effect("#Product", "#CategoryProduct", "#Product-tab", "#CategoryProduct-tab" );
			});
			$("#btnStep2").click(function() {
				_effect( "#CategoryProduct", "#image", "#CategoryProduct-tab", "#image-tab");
			});
			/** Effect TabContent [END] */
/*---------------------------------------------------------------*/
			/** Check #btnStep3 */
			$("#btnStep2").click(function() {
				if($("#cgPrdId").val()!=null && _checkFormProduct() == true){
				$("#btnStep3").removeClass("btn-disable");
				$("#btnStep3").addClass("btn-success");
			}
			});
			
			/** Check #btnStep3 [END] */
/*---------------------------------------------------------------*/
			/** Submit Form */
			function _saveProduct(FormData) {
				console.log(FormData);
				$.post("/admin/add-product", {
					FormData
				}, function(data, status) {
					 var object = JSON.parse(data);
					 if(object.code == '101'){
						$("#mesResult").html(object.mes);
						$("#notifyResult").show();
						
						$('#pname').text(object.pname);
						$('#cgPrdName').text(object.cgPrdName);
						$('#prPrice').text(object.prprice + " Ngày áp dụng: " + object.prDatestart);
						$('#pdescription').text(object.pdescription);
					 }else 
						 if(object.code=='102'){
							$("#mesResult").html(object.mes);
							$("#notifyResult").show(); 
					 }
						 else if(object.code=='103'){
							$("#mesResult").html(object.mes);
							$("#notifyResult").show();
						 }
				});
			}
			
			$("#btnStep3").click(function(){
				console.log($('form').serialize());
				
				_saveProduct($('form').serialize());
				$("#btnStep3").removeClass("btn-success");
				$("#btnStep3").addClass("btn-disable");
				document.getElementById("formProduct").reset();
				document.getElementById("formCateGoryProduct").reset();
				_effect( "#image", "#Product", "#image-tab", "#Product-tab");
			});
			/** Submit Form [END] */
/*---------------------------------------------------------------*/
		});