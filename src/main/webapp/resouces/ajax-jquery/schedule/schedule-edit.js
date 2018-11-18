
  $(function(){
    $("#btnUpdate").click(function() {
        $.post("/admin/schedule/edit",{
            scheduleid : $("#scheduleid").val(),
            starttime : $("#starttime").val(),
            endtime : $("#endtime").val(),
            payrate : $("#payrate").val()
         }, function(data, status){
             $("#result-tbody").html(data);
// 			_list(link, 1);// at loadTable.js
         });
      });
  });