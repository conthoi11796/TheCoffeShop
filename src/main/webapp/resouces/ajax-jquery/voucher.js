$(function(){


    $("#btnSave").click(function(){
        $.post("/admin/voucher/insert",{
            name : $("#name").val(),
            startdatetime : $("#startdatetime").val(),
            enddate : $("#enddate").val(),
            number : $("#number").val(),
            saleof : $("#saleof").val()
       }, function(data, status){
           $("#result-form").html(data);
           _list();
       });
    });
    

    $("#btnClear").click(function() {
        document.getElementById("voucher_form").reset();
    });

    function _list() {
        $.get("/admin/voucher/table",{
       }, function(data, status){
           $("tbody").html(data);
       });
    };

    _list();
});