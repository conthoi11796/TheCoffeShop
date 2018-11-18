
  $(function(){

    $("#btnUpdate").click(function() {
        $.post("/admin/product/edit",{
            productid : $("#productid").val(),
            name : $("#name").val(),
            description : $("#description").val(),
            categoryproductid : $("#categoryproductid").val()
         }, function(data, status){
             $("#result-tbody").html(data);
//             _list(link, 1);
         });
      });
  });