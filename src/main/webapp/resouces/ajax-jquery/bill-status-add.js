$(function(){
    // hàm giống với file table-status.js
    function _list() {
        $.get("/admin/bill-status/table",{
       }, function(data, status){
           $("tbody").html(data);
       });
    };
    // hàm giống với file table-status.js[END]

    $(".remove").click(function() {
        $.post("/admin/bill-status/remove",{
            billstatusid : $(this).attr("data-billstatusid")
        }, function(data, status){
            $("#result-tbody").html(data);
            _list();
        });
    });
    
    $(".edit").click(function() {
        $.get("/admin/bill-status/edit",{
            billstatusid : $(this).attr("data-billstatusid")
         }, function(data, status){
             $("#billStatus_form").html(data);
         });
    });
});