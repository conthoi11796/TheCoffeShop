$(function(){


    $("#btnSave").click(function(){
        $.post("/admin/schedule/insert",{
            scheduleid : $("#scheduleid").val(),
            starttime : $("#starttime").val(),
            endtime : $("#endtime").val(),
            payrate : $("#payrate").val()
       }, function(data, status){
           $("#result-form").html(data);
           _list();
       });
    });
    

    $("#btnClear").click(function() {
        document.getElementById("schedule_form").reset();
    });

    function _list() {
        $.get("/admin/schedule/table",{
       }, function(data, status){
           $("tbody").html(data);
       });
    };

    _list();
});