var LocalLogin = function () {
    
    return {
        //main function to initiate the module
        init: function () {
        	
           $('.login_form').validate({
	            // errorElement: 'label', //default input error message container
	            // errorClass: 'help-inline', // default input error message class
	            // focusInvalid: false, // do not focus the last invalid input
	            // rules: {
                 //    login_username_email: {
	            //         required: true
	            //     },
                 //    login_password: {
	            //         required: true
	            //     }
	            // },
                //
	            // messages: {
                 //    login_username_email: {
	            //         required: "请输入用户名或邮箱."
	            //     },
                 //    login_password: {
	            //         required: "请输入密码."
	            //     }
	            // }

	            /*invalidHandler: function (event, validator) { //display error alert on form submit
	                $('.alert-error', $('.login_form')).show();
	            },

	            highlight: function (element) { // hightlight error inputs
	                $(element)
	                    .closest('.form-group').addClass('error'); // set error class to the control group
	            },

	            success: function (label) {
	                label.closest('.form-group').removeClass('error');
	                label.remove();
	            },*/

	           /* errorPlacement: function (error, element) {
	                error.addClass('help-small no-left-padding').insertAfter(element.closest('.input-icon'));
	            },

	            submitHandler: function (form) {
	                window.location.href = "/view/login-action";
	            }*/
	        });

	        $('.login_form input').keypress(function (e) {
	            if (e.which == 13) {
	                if ($('.login_form').validate().form()) {
	                    window.location.href = "/view/login-action";
	                }
	                return false;
	            }
	        });


	        // $('.forget-form').validate({
	        //     errorElement: 'label', //default input error message container
	        //     errorClass: 'help-inline', // default input error message class
	        //     focusInvalid: false, // do not focus the last invalid input
	        //     ignore: "",
	        //     rules: {
	        //         email: {
	        //             required: true,
	        //             email: true
	        //         }
	        //     },
            //
	        //     messages: {
	        //         email: {
	        //             required: "Email is required."
	        //         }
	        //     },
            //
	        //     invalidHandler: function (event, validator) { //display error alert on form submit
            //
	        //     },
            //
	        //     highlight: function (element) { // hightlight error inputs
	        //         $(element)
	        //             .closest('.control-group').addClass('error'); // set error class to the control group
	        //     },
            //
	        //     success: function (label) {
	        //         label.closest('.control-group').removeClass('error');
	        //         label.remove();
	        //     },
            //
	        //     errorPlacement: function (error, element) {
	        //         error.addClass('help-small no-left-padding').insertAfter(element.closest('.input-icon'));
	        //     },
            //
	        //     submitHandler: function (form) {
	        //         window.location.href = "index.html";
	        //     }
	        // });
            //
	        // $('.forget-form input').keypress(function (e) {
	        //     if (e.which == 13) {
	        //         if ($('.forget-form').validate().form()) {
	        //             window.location.href = "index.html";
	        //         }
	        //         return false;
	        //     }
	        // });
            //
	        // jQuery('#forget-password').click(function () {
	        //     jQuery('.login-form').hide();
	        //     jQuery('.forget-form').show();
	        // });
            //
	        // jQuery('#back-btn').click(function () {
	        //     jQuery('.login-form').show();
	        //     jQuery('.forget-form').hide();
	        // });
            //
	        // $('.register-form').validate({
	        //     errorElement: 'label', //default input error message container
	        //     errorClass: 'help-inline', // default input error message class
	        //     focusInvalid: false, // do not focus the last invalid input
	        //     ignore: "",
	        //     rules: {
	        //         username: {
	        //             required: true
	        //         },
	        //         password: {
	        //             required: true
	        //         },
	        //         rpassword: {
	        //             equalTo: "#register_password"
	        //         },
	        //         email: {
	        //             required: true,
	        //             email: true
	        //         },
	        //         tnc: {
	        //             required: true
	        //         }
	        //     },
            //
	        //     messages: { // custom messages for radio buttons and checkboxes
	        //         tnc: {
	        //             required: "Please accept TNC first."
	        //         }
	        //     },
            //
	        //     invalidHandler: function (event, validator) { //display error alert on form submit
            //
	        //     },
            //
	        //     highlight: function (element) { // hightlight error inputs
	        //         $(element)
	        //             .closest('.control-group').addClass('error'); // set error class to the control group
	        //     },
            //
	        //     success: function (label) {
	        //         label.closest('.control-group').removeClass('error');
	        //         label.remove();
	        //     },
            //
	        //     errorPlacement: function (error, element) {
	        //         if (element.attr("name") == "tnc") { // insert checkbox errors after the container
	        //             error.addClass('help-small no-left-padding').insertAfter($('#register_tnc_error'));
	        //         } else {
	        //             error.addClass('help-small no-left-padding').insertAfter(element.closest('.input-icon'));
	        //         }
	        //     },
            //
	        //     submitHandler: function (form) {
	        //         window.location.href = "index.html";
	        //     }
	        // });
            //
	        // jQuery('#register-btn').click(function () {
	        //     jQuery('.login-form').hide();
	        //     jQuery('.register-form').show();
	        // });
            //
	        // jQuery('#register-back-btn').click(function () {
	        //     jQuery('.login-form').show();
	        //     jQuery('.register-form').hide();
	        // });
        }

    };

}();