$(function(){
    // hàm giống với file table-status.js
    function _list() {
        $.get("/admin/voucher/table",{
       }, function(data, status){
           $("tbody").html(data);
       });
    };
    // hàm giống với file table-status.js[END]

    $(".remove").click(function() {
        $.post("/admin/voucher/remove",{
            voucherid : $(this).attr("data-voucherid")
        }, function(data, status){
            $("#result-tbody").html(data);
            _list();
        });
    });
    
    $(".edit").click(function() {
        $.get("/admin/voucher/edit",{
            voucherid : $(this).attr("data-voucherid")
         }, function(data, status){
             $("#voucher_form").html(data);
         });
    });
});