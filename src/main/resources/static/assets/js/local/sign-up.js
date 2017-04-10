var LocalSignUp = function () {
    
    return {

        init: function () {

            (function($) {
                $(document).ready(function() {
                    $('.list-inline li > a').click(function() {
                        var activeForm = $(this).attr('href') + ' > form';
                        //console.log(activeForm);
                        $(activeForm).addClass('animated fadeIn');
                        //set timer to 1 seconds, after that, unload the animate animation
                        setTimeout(function() {
                            $(activeForm).removeClass('animated fadeIn');
                        }, 1000);
                    });

                    $('.sign_up_companyUrl').on('click',function () {
                        $('.sign_up_companyUrl_more').append
                        (
                            "<div class='control-group control-group-margin-bottom'>" +
                            "<label class='control-label control-label-width'>公司网址<span>*</span></label>"+
                            "<div class='controls control-margin-left'>"+
                            "<input type='text' id='sign_up_companyUrl' name='sign_up_companyUrl' placeholder='请输入公司网址（选填）' class='m-wrap medium' />"+
							/*"<a><i class='icon-remove icon-white text-muted'></i></a>"+*/
                            "</div>"+
                            "</div>"
                        )
                    });

                    $('.sign_up_officialIp').on('click',function () {
                        $('.sign_up_officialIp_more').append
                        (
                            "<div class='control-group control-group-margin-bottom'>" +
                            "<label class='control-label control-label-width'>正式公网Ip<span>*</span></label>"+
                            "<div class='controls control-margin-left'>"+
                            "<input type='text' id='sign_up_officialIp' name='sign_up_officialIp' placeholder='请输入正式公网Ip（选填）' class='m-wrap medium' />"+
                            "</div>"+
                            "</div>"
                        )
                    });

                    $('.sign_up_testIp').on('click',function () {
                        $('.sign_up_testIp_more').append
                        (
                            "<div class='control-group control-group-margin-bottom'>" +
                            "<label class='control-label control-label-width'>测试公网Ip<span>*</span></label>"+
                            "<div class='controls control-margin-left'>"+
                            "<input type='text' id='sign_up_testIp' name='sign_up_testIp' placeholder='请输入测试公网Ip（选填）' class='m-wrap medium' />"+
                            "</div>"+
                            "</div>"
                        )
                    });

                    $('#sign_up_email').focus(function () {
                        $('#sign_up_email_msg').html("")
                    });
                    $('#sign_up_password').focus(function () {
                        $('#sign_up_password_msg').html("")
                    });
                    $('#sign_up_rpPassword').focus(function () {
                        $('#sign_up_rpPassword_msg').html("")
                    });
                    $('#sign_up_companyName').focus(function () {
                        $('#sign_up_companyName_msg').html("")
                    });
                    $('#sign_up_busPerson').focus(function () {
                        $('#sign_up_busPerson_msg').html("")
                    });
                    $('#sign_up_busTel').focus(function () {
                        $('#sign_up_busTel_msg').html("")
                    });

                    $('#btn_btn_lg_btn_success_btn_block').on('click',function () {
                        var sign_up_email = $('#sign_up_email').val();
                        var sign_up_password = $('#sign_up_password').val();
                        var sign_up_rpPassword = $('#sign_up_rpPassword').val();
                        var sign_up_companyName = $('#sign_up_companyName').val();
                        var sign_up_busPerson = $('#sign_up_busPerson').val();
                        var sign_up_busTel = $('#sign_up_busTel').val();
                        var sign_up_companyUrl = [];
                        $('input[name="sign_up_companyUrl"]').each(function(){
                            sign_up_companyUrl.push($(this).val());
                        });
                        var sign_up_officialIp = [];
                        $('input[name="sign_up_officialIp"]').each(function(){
                            sign_up_officialIp.push($(this).val());
                        });
                        var sign_up_testIp = [];
                        $('input[name="sign_up_testIp"]').each(function(){
                            sign_up_testIp.push($(this).val());
                        });
                        var sign_up_techPerson = $('#sign_up_techPerson').val();
                        var sign_up_techTel = $('#sign_up_techTel').val();
                        var sign_up_product = $('#sign_up_product').val();
                        var sign_up_content = $('#sign_up_content').val();
                        $.ajax({
                            url: '/user//register',
                            type: 'post',
                            data: {
                                'sign_up_email': sign_up_email,
                                'sign_up_password': sign_up_password,
                                'sign_up_rpPassword': sign_up_rpPassword,
                                'sign_up_companyName': sign_up_companyName,
                                'sign_up_busPerson': sign_up_busPerson,
                                'sign_up_busTel': sign_up_busTel,
                                'sign_up_companyUrl': sign_up_companyUrl,
                                'sign_up_officialIp': sign_up_officialIp,
                                'sign_up_testIp': sign_up_testIp,
                                'sign_up_techPerson': sign_up_techPerson,
                                'sign_up_techTel': sign_up_techTel,
                                'sign_up_product': sign_up_product,
                                'sign_up_content': sign_up_content
                            },
                            dataType: 'json',
                            success: function (data) {
                                if(data.sign_up_email != null) {
                                    $("#sign_up_email_msg").empty();
                                    $("#sign_up_email_msg").html("<font color='red'>"+data.sign_up_email+"</font>");
                                    return;
                                }
                                if(data.sign_up_password != null) {
                                    $("#sign_up_password_msg").empty();
                                    $("#sign_up_password_msg").html("<font color='red'>"+data.sign_up_password+"</font>");
                                    return;
                                }
                                if(data.sign_up_rpPassword != null) {
                                    $("#sign_up_rpPassword_msg").empty();
                                    $("#sign_up_rpPassword_msg").html("<font color='red'>"+data.sign_up_rpPassword+"</font>");
                                    return;
                                }
                                if(data.sign_up_companyName != null) {
                                    $("#sign_up_companyName_msg").empty();
                                    $("#sign_up_companyName_msg").html("<font color='red'>"+data.sign_up_companyName+"</font>");
                                    return;
                                }
                                if(data.sign_up_busPerson != null) {
                                    $("#sign_up_busPerson_msg").empty();
                                    $("#sign_up_busPerson_msg").html("<font color='red'>"+data.sign_up_busPerson+"</font>");
                                    return;
                                }
                                if(data.sign_up_busTel != null) {
                                    $("#sign_up_busTel_msg").empty();
                                    $("#sign_up_busTel_msg").html("<font color='red'>"+data.sign_up_busTel+"</font>");
                                    return;
                                }
                                if(data.successMsg != null) {
                                    $("#alert_error").empty();
                                    $("#alert_error").append("<div class='alert alert-error show'>"+
                                    	"<button class='close' data-dismiss='alert'></button>"+
                                        "<span>"+data.successMsg+"</span>"+
                                        "</div>");
                                    return;
                                }
                                if(data.msg != null) {
                                    $("#alert_error").empty();
                                    $("#alert_error").append("<div class='alert alert-error show'>"+
                                        "<button class='close' data-dismiss='alert'></button>"+
                                        "<span>"+data.msg+"</span>"+
                                        "</div>");
                                    return;
                                }

                            }
                        })
                    })

                });
            })(jQuery);


            $(document).keypress(function(e) {
                if (e.which == 13)
                    $("#btn_btn_lg_btn_success_btn_block").click();
            });

        }

    };

}();