
  $(function(){

    $("#btnUpdate").click(function() {
        $.post("/admin/product/edit",{
            productid : $("#productid").val(),
            name : $("#name").val(),
            description : $("#description").val(),
            categoryproductid : $("#categoryproductid").val()
         }, function(data, status){
             $("#result-form").html(data);
 			$("#result-form").fadeOut(3000);
//             _list(link, 1);
         });
      });
  });