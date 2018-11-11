$(function(){


    $("#btnSave").click(function(){
        $.post("/admin/position/insert",{
            positionid : $("#positionid").val(),
            name : $("#name").val()
       }, function(data, status){
           $("#result-form").html(data);
           _list();
       });
    });
    

    $("#btnClear").click(function() {
        document.getElementById("position_form").reset();
    });

    function _list() {
        $.get("/admin/position/table",{
       }, function(data, status){
           $("tbody").html(data);
       });
    };

    _list();
});