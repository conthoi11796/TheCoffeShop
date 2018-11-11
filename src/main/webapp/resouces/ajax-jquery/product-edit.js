
  $(function(){
    // hàm giống với file table-status.js
    function _list() {
        $.get("/admin/product/table",{
       }, function(data, status){
           $("tbody").html(data);
       });
    };
    // hàm giống với file table-status.js[END]

    $("#btnUpdate").click(function() {
        $.post("/admin/product/edit",{
            productid : $("#productid").val(),
            name : $("#name").val(),
            description : $("#description").val(),
            categoryproductid : $("#categoryproductid").val()
         }, function(data, status){
             $("#result-tbody").html(data);
             _list();
         });
      });
  });