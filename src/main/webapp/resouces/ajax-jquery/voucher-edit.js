
  $(function(){
    // hàm giống với file table-status.js
    function _list() {
        $.get("/admin/voucher/table",{
       }, function(data, status){
           $("tbody").html(data);
       });
    };
    // hàm giống với file table-status.js[END]

    $("#btnUpdate").click(function() {
        $.post("/admin/voucher/edit",{
            voucherid : $("#voucherid").val(),
            name : $("#name").val(),
            startdatetime : $("#startdatetime").val(),
            enddate : $("#enddate").val(),
            number : $("#number").val(),
            saleof : $("#saleof").val()
         }, function(data, status){
             $("#result-tbody").html(data);
             _list();
         });
      });
  });