$(function(){
    // hàm giống với file table-status.js
    function _list() {
        $.get("/admin/product/table",{
       }, function(data, status){
           $("tbody").html(data);
       });
    };
    // hàm giống với file table-status.js[END]

    $(".remove").click(function() {
        $.post("/admin/product/remove",{
            productid : $(this).attr("data-productid")
        }, function(data, status){
            $("#result-tbody").html(data);
            _list();
        });
    });
    
    $(".edit").click(function() {
        $.get("/admin/product/edit",{
            productid : $(this).attr("data-productid")
         }, function(data, status){
             $("#product_form").html(data);
         });
    });
});