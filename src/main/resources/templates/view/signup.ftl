<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <!--IE Compatibility modes-->
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <!--Mobile first-->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <title>注册账号</title>

    <meta name="description" content="Free Admin Template Based On Twitter Bootstrap 3.x">
    <meta name="author" content="">

    <meta name="msapplication-TileColor" content="#5bc0de" />
    <meta name="msapplication-TileImage" content="assets/img/metis-tile.png" />

    <!-- Bootstrap -->
    <link rel="stylesheet" href="/assets/lib/bootstrap/css/bootstrap.css">

    <!-- Font Awesome -->
    <link rel="stylesheet" href="/assets/lib/font-awesome/css/font-awesome.css">

    <!-- Metis core stylesheet -->
    <link rel="stylesheet" href="/assets/css/main.css">

    <link rel="stylesheet" href="/assets/css/back.css">

    <!-- metisMenu stylesheet -->
    <link rel="stylesheet" href="/assets/lib/metismenu/metisMenu.css">

    <!-- animate.css stylesheet -->
    <link rel="stylesheet" href="/assets/lib/animate.css/animate.css">

    <link rel="shortcut icon" href="/manage/image/favicon.ico" />

<#--    <link href="/media/css/style.css" rel="stylesheet" type="text/css"/>-->

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->

    <style>
        .alert{padding:8px 35px 8px 14px;margin-bottom:20px;text-shadow:0 1px 0 rgba(255,255,255,0.5);background-color:#fcf8e3;border:1px solid #fbeed5;-webkit-border-radius:4px;-moz-border-radius:4px;border-radius:4px}
        .alert,.alert h4{color:#c09853}
        .alert h4{margin:0}
        .alert-error{color:#b94a48;background-color:#f2dede;border-color:#eed3d7}
        .alert-success{color:#333;background-color:#f5f5f5;border-color:#eee}
        .close{
            display: inline-block;
            margin-top: 0px;
            margin-right: -20px;
            width: 9px;
            height: 9px;
            background-repeat: no-repeat !important;
            background-image: url("../manage/image/remove-icon-small.png") !important;
        }
    </style>
</head>

<body class="login">

<div class="form-signin" style="max-width: 660px">
    <div class="text-center">
    <#--<img src="/assets/img/logo.png" alt="Metis Logo">-->
       <#-- <h3>欢迎登录</h3>-->
    </div>
    <hr>
    <div class="tab-content">

        <div id="signup" class="tab-pane active">
            <form action="/user/register" method="post" class="form-horizontal" role="form">
                <div class="form-group">
                    <label class="col-sm-2 control-label">邮箱<span class="required">*</span></label>
                    <div class="col-sm-10">
                        <input type="email" id="sign_up_email" name="sign_up_email" placeholder="请输入邮箱（必填）" class="form-control">
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label">密码<span class="required">*</span></label>
                    <div class="col-sm-10">
                        <input type="password" id="sign_up_password" name="sign_up_password" placeholder="请输入密码（必填）" class="form-control middle" data-toggle="tooltip" data-placement="auto" title="长度为6-18个字符">
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label">确认密码<span class="required">*</span></label>
                    <div class="col-sm-10">
                        <input type="password" id="sign_up_rpPassword" name="sign_up_rpPassword" placeholder="请再次输入密码（必填）" class="form-control bottom" data-toggle="tooltip" data-placement="auto" title="长度为6-18个字符">
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label">公司名称<span class="required">*</span></label>
                    <div class="col-sm-10">
                        <input type="text" id="sign_up_rpPassword" name="sign_up_rpPassword" placeholder="请输入公司名称（必填）" class="form-control bottom" data-toggle="tooltip" data-placement="auto" title="长度为6-18个字符">
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label">商务负责人<span class="required">*</span></label>
                    <div class="col-sm-10">
                        <input type="text" id="sign_up_rpPassword" name="sign_up_rpPassword" placeholder="请输入商务负责人（必填）" class="form-control bottom" data-toggle="tooltip" data-placement="auto" title="长度为6-18个字符">
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label">联系电话<span class="required">*</span></label>
                    <div class="col-sm-10">
                        <input type="text" id="sign_up_rpPassword" name="sign_up_rpPassword" placeholder="请输入联系电话（必填）" class="form-control bottom" data-toggle="tooltip" data-placement="auto" title="长度为6-18个字符">
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label">公司网址<span>*</span></label>
                    <div class="col-sm-10">
                        <input type="password" id="sign_up_rpPassword" name="sign_up_rpPassword" placeholder="请输入公司网址（选填）" class="form-control bottom" data-toggle="tooltip" data-placement="auto" title="长度为6-18个字符">
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label">正式公网Ip<span>*</span></label>
                    <div class="col-sm-10">
                        <input type="password" id="sign_up_rpPassword" name="sign_up_rpPassword" placeholder="请输入正式公网Ip（选填）" class="form-control bottom" data-toggle="tooltip" data-placement="auto" title="长度为6-18个字符">
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label">测试公网Ip<span>*</span></label>
                    <div class="col-sm-10">
                        <input type="password" id="sign_up_rpPassword" name="sign_up_rpPassword" placeholder="请输入测试公网Ip（选填）"" class="form-control bottom" data-toggle="tooltip" data-placement="auto" title="长度为6-18个字符">
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label">技术负责人<span>*</span></label>
                    <div class="col-sm-10">
                        <input type="password" id="sign_up_rpPassword" name="sign_up_rpPassword" placeholder="请输入技术负责人（选填）"" class="form-control bottom" data-toggle="tooltip" data-placement="auto" title="长度为6-18个字符">
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label">联系电话<span>*</span></label>
                    <div class="col-sm-10">
                        <input type="password" id="sign_up_rpPassword" name="sign_up_rpPassword" placeholder="请输入联系电话（选填）"" class="form-control bottom" data-toggle="tooltip" data-placement="auto" title="长度为6-18个字符">
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label">申请开通产品<span>*</span></label>
                    <div class="col-sm-10">
                        <textarea id="sign_up_rpPassword" name="sign_up_rpPassword" placeholder="请输入申请开通产品（选填）"" class="form-control bottom"></textarea>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label">备注<span>*</span></label>
                    <div class="col-sm-10">
                        <textarea id="sign_up_rpPassword" name="sign_up_rpPassword" placeholder="备注（选填）"" class="form-control bottom" data-toggle="tooltip" data-placement="auto" title="长度为6-18个字符"></textarea>
                    </div>
                </div>

                <div class="form-group" style="text-align: right">
                    <label><a>+点击填写更多</a></label
                </div>
                <button class="btn btn-lg btn-success btn-block" id="btn_btn_lg_btn_success_btn_block" type="submit">注册</button>
            </form>
        </div>

    </div>
    <hr>
    <div class="text-center">
        <ul class="list-inline">
            <li><a class="text-muted" href="#login" data-toggle="tab">登录</a></li>
            <li><a class="text-muted" href="#forgot" data-toggle="tab">忘记密码？</a></li>
            <li><a class="text-muted" href="#signup" data-toggle="tab">注册</a></li>
        </ul>
    </div>
</div>


<!--jQuery -->
<script src="/assets/lib/jquery/jquery.js"></script>

<!--Bootstrap -->
<script src="/assets/lib/bootstrap/js/bootstrap.js"></script>

<script src="/manage/js/jquery.validate.min.js" type="text/javascript"></script>

<#--登录验证-->
<script src="/assets/js/local/login.js"></script>

<script type="text/javascript">

    /*  $(document).ready(function() {
          LocalLogin.init();
      });*/
</script>

<script>
    $(function () { $("[data-toggle='tooltip']").tooltip(); });
</script>

<script type="text/javascript">
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
        });
    })(jQuery);


    $(document).keypress(function(e) {
        if (e.which == 13)
            $(".register_form").submit();
    });
</script>
</body>

</html>
