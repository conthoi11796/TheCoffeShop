
  $(function(){

    $("#btnUpdate").click(function() {
        $.post("/admin/voucher/edit",{
            voucherid : $("#voucherid").val(),
            name : $("#name").val(),
            startdatetime : $("#startdatetime").val(),
            enddate : $("#enddate").val(),
            number : $("#number").val(),
            saleof : $("#saleof").val()
         }, function(data, status){
             $("#result-form").html(data);
 			$("#result-form").fadeOut(3000);
// 			_list(link, 1);// at loadTable.js
         });
      });
  });