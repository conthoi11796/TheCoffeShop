
  $(function(){

    $("#btnUpdate").click(function() {
        $.post("/admin/position/edit",{
            positionid : $("#positionid").val(),
            name : $("#name").val()
         }, function(data, status){
             $("#result-tbody").html(data);
//             _list(link ,);
         });
      });
  });