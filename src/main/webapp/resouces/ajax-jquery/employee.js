$(function(){


    $("#btnSave").click(function(){
        var sex = "female";
        if( $('#Male').prop('checked')){
            sex ="male";
        }
        $.post("/admin/employee/insert",{
            employeeid : $("#employeeid").val(),
            name : $("#name").val(),
            sex : sex,
            phone : $("#phone").val(),
            address : $("#address").val(),
            usename : $("#usename").val(),
            password : $("#password").val(),
            position : $("#position").val(),
            salaryonhour : $("#salaryonhour"),
            startdate : $("#startdate").val()
       }, function(data, status){
           $("#result-form").html(data);
           _list();
       });
    });
    

    $("#btnClear").click(function() {
        document.getElementById("employee_form").reset();
    });

    function _list() {
        $.get("/admin/employee/table",{
       }, function(data, status){
           $("tbody").html(data);
       });
    };

    _list();
});