$(function(){
    // hàm giống với file table-status.js
    function _list() {
        $.get("/admin/schedule/table",{
       }, function(data, status){
           $("tbody").html(data);
       });
    };
    // hàm giống với file table-status.js[END]

    $(".remove").click(function() {
        $.post("/admin/schedule/remove",{
            scheduleid : $(this).attr("data-scheduleid")
        }, function(data, status){
            $("#result-tbody").html(data);
            _list();
        });
    });
    
    $(".edit").click(function() {
        $.get("/admin/schedule/edit",{
            scheduleid : $(this).attr("data-scheduleid")
         }, function(data, status){
             $("#schedule_form").html(data);
         });
    });
});