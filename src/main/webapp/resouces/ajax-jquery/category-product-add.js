$(function(){
    // hàm giống với file table-status.js
    function _list() {
        $.get("/admin/category-product/table",{
       }, function(data, status){
           $("tbody").html(data);
       });
    };
    // hàm giống với file table-status.js[END]

    $(".remove").click(function() {
        $.post("/admin/category-product/remove",{
            categoryproductid : $(this).attr("data-categoryproductid")
        }, function(data, status){
            $("#result-tbody").html(data);
            _list();
        });
    });
    
    $(".edit").click(function() {
        $.get("/admin/category-product/edit",{
            categoryproductid : $(this).attr("data-categoryproductid")
         }, function(data, status){
             $("#categoryProduct_form").html(data);
         });
    });
});