/**
 * 
 */
(function($) {
    'use strict';
    $.validator.setDefaults({
        submitHandler: function() {
            alert("submitted!");
        }
    });
   $(function() {
	$("#billStatus_form")
			.validate(
					{
						rules : {
							billstatusid : "required",
							name : "required"
						},
						messages : {
							billstatusid : "Please enter your firstname",
							name : "Please enter your lastname"
						}
					});

})(jQuery);