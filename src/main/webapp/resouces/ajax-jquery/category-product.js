$(function(){


    $("#btnSave").click(function(){
        $.post("/admin/category-product/insert",{
            categoryproductid : $("#categoryproductid").val(),
            name : $("#name").val()
       }, function(data, status){
           $("#result-form").html(data);
           _list();
       });
    });
    

    $("#btnClear").click(function() {
        document.getElementById("categoryProduct_form").reset();
    });

    function _list() {
        $.get("/admin/category-product/table",{
       }, function(data, status){
           $("tbody").html(data);
       });
    };

    _list();
});