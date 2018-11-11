$(function(){
    // hàm giống với file table-status.js
    function _list() {
        $.get("/admin/position/table",{
       }, function(data, status){
           $("tbody").html(data);
       });
    };
    // hàm giống với file table-status.js[END]

    $(".remove").click(function() {
        $.post("/admin/position/remove",{
            positionid : $(this).attr("data-positionid")
        }, function(data, status){
            $("#result-tbody").html(data);
            _list();
        });
    });
    
    $(".edit").click(function() {
        $.get("/admin/position/edit",{
            positionid : $(this).attr("data-positionid")
         }, function(data, status){
             $("#position_form").html(data);
         });
    });
});