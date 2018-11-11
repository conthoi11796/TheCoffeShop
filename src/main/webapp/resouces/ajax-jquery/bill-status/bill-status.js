$(function(){


    $("#btnSave").click(function(){
        $.post("/admin/bill-status/insert",{
            billstatusid : $("#billstatusid").val(),
            name : $("#name").val()
       }, function(data, status){
           $("#result-form").html(data);
           _list();
       });
    });
    

    $("#btnClear").click(function() {
        document.getElementById("billStatus_form").reset();
    });

    _list(1);// at loadTable.js
});