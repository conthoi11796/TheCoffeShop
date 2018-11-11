
  $(function(){

    $("#btnUpdate").click(function() {
        $.post("/admin/bill-status/edit",{
            billstatusid : $("#billstatusid").val(),
            name : $("#name").val()
         }, function(data, status){
             $("#result-form").html(data);
             _list();// at loadTable.js
         });
      });
  });