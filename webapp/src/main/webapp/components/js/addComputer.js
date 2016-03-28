(function($, W, D) {
	var JQUERY4U = {};
	JQUERY4U.UTIL = {
		setupFormValidation : function() {
			// form validation rules
			$("#register-form")
					.validate(
							{
								rules : {
									firstname : {
										required : true
									},
									lastname : {
										required : true
									},
									email : {
										required : true,
										email : true
									},
									password : {
										required : true,
										minlength : 5
									}
								},
								messages : {
									firstname : {
										required : "Please enter your firstname"
									},
									lastname : {
										required : "Please enter your lastname"
									},
									password : {
										required : "Please provide a password",
										minlength : "Your password must be at least 5 characters long"
									},
									email : "Please enter a valid email address",
								},
								submitHandler : function(form) {
									form.submit();
								}
							});
		}
	}

	// when the dom has loaded setup form validation rules
	$(D).ready(function($) {
		JQUERY4U.UTIL.setupFormValidation();
	});

})(jQuery, window, document);