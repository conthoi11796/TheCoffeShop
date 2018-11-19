
  $(function(){

    $("#btnUpdate").click(function() {
        $.post("/admin/position/edit",{
            positionid : $("#positionid").val(),
            name : $("#name").val()
         }, function(data, status){
             $("#result-form").html(data);
 			$("#result-form").fadeOut(3000);
//             _list(link ,);
         });
      });
  });