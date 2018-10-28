/**
 * 
 */

$(document).ready(
		function() { 

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
// alert("Data: " + data + "\nStatus: " + status);
					 var object = JSON.parse(data);
// alert(object.success);
// alert(object.warning);
					 if(object.success!=null){
						$('.modal-body').text(object.success);
						$('.modal-body').addClass('label-success');
						
						$('#pname').text(object.pname);
						$('#cgPrdName').text(object.cgPrdName);
						$('#prPrice').text(object.prprice + " Ngày áp dụng: " + object.prDatestart);
						$('#pdescription').text(object.pdescription);

						$('#modalResult').modal('show');
						$('#modalResult').fadeOut("slow");
					 }
					 if(object.warning!=null){
						$('#modalResult').modal('show');
						$('#modalResult').fadeOut("slow");
						$('.modal-body').text(object.warning);
						$('.modal-body').addClass('label-warning');
					 }
				});
			}
			
			$("#btnStep3").click(function(){
// alert($('#PId').val());
// alert($('#cgPrdId').val());
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