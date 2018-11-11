/**
 * 
 */
	function _list(startPosition) {
        $.get("/admin/bill-status/table",{
        	startPosition : startPosition
       }, function(data, status){
           $("tbody").html(data);
       });
    };
    $(function() {
		$(".pagination li").click(function() {
			$(".active").removeClass("active");
			$(this).addClass("active");
			_list($(this).text());
		});
	});