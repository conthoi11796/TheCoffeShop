
  $(function(){
    $("#btnUpdate").click(function() {
        $.post("/admin/table-status/edit",{
            tablestatusid : $("#tablestatusid").val(),
            name : $("#name").val()
         }, function(data, status){
             $("#result-tbody").html(data);
//             _list(link, 1);// at loadTable.js
         });
      });
  });