var UpdatePassword = function () {

    return {

        init: function () {

            var form = $('#form_update_password');
            var error = $('.alert-error', form);
            var success = $('.alert-success', form);

            //表单验证
            form.validate({
                doNotHideMessage: true, //this option enables to show the error/success messages on tab switch.
                errorElement: 'span', //default input error message container
                errorClass: 'validate-inline', // default input error message class
                focusInvalid: true, // do not focus the last invalid input
                rules: {
                    oldPassword: {
                        required: true,
                        remote: {
                            url: "/user/validate-old-password",
                            type: "post",
                            dataType: "json",
                            data: {
                                oldPassword: function(){
                                    return $("#oldPassword").val();
                                }
                            },
                            dataFilter: function (data,type) {
                                var json = $.parseJSON(data);
                                if (json.success == "true") {
                                    return true ;
                                }else if (json.fail == "false"){
                                    return false;
                                }
                            }
                        }
                    },
                    newPassword: {
                        minlength: 6,
                        maxlength: 12,
                        required:true
                    },
                    newRpPassword: {
                        required:true,
                        equalTo: '#newPassword'
                    }
                },

                messages: {
                    oldPassword:{
                        required:"请输入原始密码！",
                        remote:"原始密码不正确，请重新输入！"
                    },
                    newPassword:{
                        required:"请输入新密码！",
                        minlength:"长度必须大于等于6",
                        maxlength:"长度必须小于等于12"
                    },
                    newRpPassword:{
                        required:"请再次输入新密码！",
                        equalTo:"两次密码输入不一致！"
                    }
                },

                errorPlacement: function (error, element) { // render error placement for each input type
                    if (element.attr("name") == "gender") { // for uniform radio buttons, insert the after the given container
                        error.addClass("no-left-padding").insertAfter("#form_gender_error");
                    } else if (element.attr("name") == "payment[]") { // for uniform radio buttons, insert the after the given container
                        error.addClass("no-left-padding").insertAfter("#form_payment_error");
                    } else {
                        error.insertAfter(element); // for other inputs, just perform default behavoir
                    }
                },

                invalidHandler: function (event, validator) { //display error alert on form submit
                    success.hide();
                    error.show();
                    App.scrollTo(error, -200);
                },

                highlight: function (element) { // hightlight error inputs
                    $(element)
                        .closest('.help-inline').removeClass('ok'); // display OK icon
                    $(element)
                        .closest('.control-group').removeClass('success').addClass('error'); // set error class to the control group
                },

                unhighlight: function (element) { // revert the change dony by hightlight
                    $(element)
                        .closest('.control-group').removeClass('error'); // set error class to the control group
                },

                success: function (label) {
                    if (label.attr("for") == "gender" || label.attr("for") == "payment[]") { // for checkboxes and radip buttons, no need to show OK icon
                        label
                            .closest('.control-group').removeClass('error').addClass('success');
                        label.remove(); // remove error label here
                    } else { // display success icon for other inputs
                        label
                            .addClass('valid ok') // mark the current input as valid and display OK icon
                            .closest('.control-group').removeClass('error').addClass('success'); // set success class to the control group
                    }
                },

                submitHandler: function (form) {

                }

            });

            $('#update-password-btn-black-btn-primary').on("click",function () {
                if (form.valid() == false) {
                    return false;
                }
                var oldPassword=$("#oldPassword").val();
                var newPassword=$("#newPassword").val();
                var newRpPassword=$("#newRpPassword").val();
                $.ajax({
                    type: "post",
                    url: "/user/update-login-password",
                    data: {"oldPassword":oldPassword,"newPassword":newPassword,"newRpPassword":newRpPassword},
                    dataType: "json",
                    success: function (result) {
                        if(result.oldPasswordMessageNull != null && result.oldPasswordMessageNull == "oldPasswordMessageNull") {
                            return;
                        }
                        if(result.oldPasswordMessageExist != null && result.oldPasswordMessageExist == "oldPasswordMessageExist") {
                            return;
                        }
                        if(result.newPasswordMessageNull != null && result.newPasswordMessageNull == "newPasswordMessageNull") {
                            return;
                        }
                        if(result.newPasswordMessageFormat != null && result.newPasswordMessageFormat == "newPasswordMessageFormat") {
                            return;
                        }
                        if(result.rpPasswordMessageNull != null && result.rpPasswordMessageNull == "rpPasswordMessageNull") {
                            return;
                        }
                        if(result.rpPasswordMessageEqual != null && result.rpPasswordMessageEqual == "rpPasswordMessageEqual") {
                            return;
                        }
                        if(result.errorMessage != null && result.errorMessage == "errorMessage") {
                            success.hide();
                            error.show();
                            $("#error_alert").html("修改失败，请联系管理员！");
                            return;
                        }
                        if(result.successMessage != null && result.successMessage == "successMessage") {
                            window.location.href="/login"
                        }
                    }
                });

            });

        }

    };

}();