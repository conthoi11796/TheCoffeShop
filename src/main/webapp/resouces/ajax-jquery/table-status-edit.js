
  $(function(){
    // hàm giống với file table-status.js
    function _list() {
        $.get("/admin/table-status/table",{
       }, function(data, status){
           $("tbody").html(data);
       });
    };
    // hàm giống với file table-status.js[END]

    $("#btnUpdate").click(function() {
        $.post("/admin/table-status/edit",{
            tablestatusid : $("#tablestatusid").val(),
            name : $("#name").val()
         }, function(data, status){
             $("#result-tbody").html(data);
             _list();
         });
      });
  });