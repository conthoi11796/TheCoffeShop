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
					$("#PId").val(data);
				});

			});
			/** Create PId [END] */
/*---------------------------------------------------------------*/
			/** Check formProduct */
			function _checkFormProduct() {
				if ($("#PName").val() != "" && $("#prPrice").val() != ""
						&& $("#prDatestart").val() != "") {
					$("#btnStep1").removeClass("btn-disable");
					$("#btnStep1").addClass("btn-success");
				} else {
					$("#btnStep1").removeClass("btn-success");
					$("#btnStep1").addClass("btn-disable");
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
			/** Effect and check Form Category Product */
			$("#cgPrdName").change(function() {
				// alert($(this).val());
				$("#cgPrdId").val($(this).val());
				
				$("#btnStep2").removeClass("btn-disable");
				$("#btnStep2").addClass("btn-success");

			});
			/** Effect and check Form Category Product [END] */
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
				_effect("#info-tab", "#security-tab", "#info", "#security");
			});
			$("#btnStep2").click(function() {
				_effect("#security-tab", "#avatar-tab", "#security", "#avatar");
			});
			/** Effect TabContent [END] */
/*---------------------------------------------------------------*/
			/** Submit Form */
			function _saveProduct(FormData) {
				$.post("/admin/add-product", {
					FormData
				}, function(data, status) {
					// alert("Data: " + data + "\nStatus: " + status);
					$("#PId").val(data);
				});
			}
			
			$("#btnStep3").click(function(){
				var formData = new FormData($('#formProduct')[0]);
				var formData2 = new FormData($('#formCateGoryProduct')[0]);
				var formData3 = new FormData($('#formImagesOfProduct')[0]);
				
				// Merge three formData
				for(var pair of formData2.entries()) {
					   formData.append(pair[0], pair[1]);
					}
				for(var pair of formData3.entries()) {
					   formData.append(pair[0], pair[1]);
					}
				
				_saveProduct(formData);
			});
			/** Submit Form [END] */
/*---------------------------------------------------------------*/
		});