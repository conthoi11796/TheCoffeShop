
  $(function(){

    $("#btnUpdate").click(function() {
        $.post("/admin/category-product/edit",{
            categoryproductid : $("#categoryproductid").val(),
            name : $("#name").val()
         }, function(data, status){
             $("#result-tbody").html(data);
             _list(link, 1);
         });
      });
  });