var UpdatePassword = function () {

    return {
        //main function to initiate the module
        init: function () {



            $("#newPassword").focus(function () {
                $("#newPassword_Msg").html("");
            });

            $("#newRpPassword").focus(function () {
                $("#newRpPassword_Msg").html("");
            });

            $("#update-password-btn-black-btn-primary").on("click",function () {
                var password=$("#newPassword").val();
                var rpPassword=$("#newRpPassword").val();
                $.ajax({
                    type: "post",
                    url: "/user/update-login-password",
                    data: {"password":password,"rpPassword":rpPassword},
                    dataType: "json",
                    success: function (result) {
                        if(result.passwordMessage != null) {
                            $("#newPassword_Msg").empty();
                            $("#newPassword_Msg").html("<font color='red'>"+result.passwordMessage+"</font>");
                            return;
                        }
                        if(result.rpPasswordMessage != null) {
                            $("#newRpPassword_Msg").empty();
                            $("#newRpPassword_Msg").html("<font color='red'>"+result.rpPasswordMessage+"</font>");
                            return;
                        }
                        if(result.errorMessage != null) {
                            $("#error-alert").empty();
                            $("#error-alert").append('<div class="alert alert-error show"><button class="close" data-dismiss="alert"></button><span>'+result.errorMessage+'</span></div>');
                            return;
                        }
                        if(result.successMessage != null) {
                          window.location.href="/login"
                        }
                    }
                });
            });




        }

    };

}();