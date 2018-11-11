
  $(function(){
    // hàm giống với file table-status.js
    function _list() {
        $.get("/admin/schedule/table",{
       }, function(data, status){
           $("tbody").html(data);
       });
    };
    // hàm giống với file table-status.js[END]

    $("#btnUpdate").click(function() {
        $.post("/admin/schedule/edit",{
            scheduleid : $("#scheduleid").val(),
            starttime : $("#starttime").val(),
            endtime : $("#endtime").val(),
            payrate : $("#payrate").val()
         }, function(data, status){
             $("#result-tbody").html(data);
             _list();
         });
      });
  });