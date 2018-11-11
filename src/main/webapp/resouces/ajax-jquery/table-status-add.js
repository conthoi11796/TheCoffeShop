$(function(){
    // hàm giống với file table-status.js
    function _list() {
        $.get("/admin/table-status/table",{
       }, function(data, status){
           $("tbody").html(data);
       });
    };
    // hàm giống với file table-status.js[END]

    $(".remove").click(function() {
        $.post("/admin/table-status/remove",{
           tablestatusid : $(this).attr("data-tablestatusid")
        }, function(data, status){
            $("#result-tbody").html(data);
            _list();
        });
    });
    
    $(".edit").click(function() {
        $.get("/admin/table-status/edit",{
            tablestatusid : $(this).attr("data-tablestatusid")
         }, function(data, status){
             $("#tableStatus_form").html(data);
         });
    });
});