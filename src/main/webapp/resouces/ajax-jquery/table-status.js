$(function(){


    $("#btnSave").click(function(){
        $.post("/admin/table-status/insert",{
            name : $("#name").val()
       }, function(data, status){
           $("#result-form").html(data);
           _list();
       });
    });
    

    $("#btnClear").click(function() {
        document.getElementById("tableStatus_form").reset();
    });

    function _list() {
        $.get("/admin/table-status/table",{
       }, function(data, status){
           $("tbody").html(data);
       });
    };

    _list();
});