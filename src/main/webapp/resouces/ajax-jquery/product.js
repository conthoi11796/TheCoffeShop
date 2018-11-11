$(function(){


    $("#btnSave").click(function(){
        $.post("/admin/product/insert",{
            productid : $("#productid").val(),
            name : $("#name").val(),
            description : $("#description").val(),
            categoryproductid : $("#categoryproductid").val()
       }, function(data, status){
           $("#result-form").html(data);
           _list();
       });
    });
    

    $("#btnClear").click(function() {
        document.getElementById("product_form").reset();
    });

    function _list() {
        $.get("/admin/product/table",{
       }, function(data, status){
           $("tbody").html(data);
       });
    };

    _list();
});