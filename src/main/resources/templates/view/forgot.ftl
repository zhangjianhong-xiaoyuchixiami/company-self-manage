<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <!--IE Compatibility modes-->
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <!--Mobile first-->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <title>忘记密码</title>

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

<div class="form-signin">
    <div class="text-center">
    <#--<img src="/assets/img/logo.png" alt="Metis Logo">-->
       <#-- <h3>欢迎登录</h3>-->
    </div>
    <hr>
    <div class="tab-content">

        <div id="forgot" class="tab-pane active">
            <form action="/user/forgot" class="forgot_form" method="post">
            <#if msg??>
                <div class="alert alert-error show">
                    <button class="close" data-dismiss="alert"></button>
                    <span>${msg}</span>
                </div>
            </#if>
            <#if successMsg??>
                <div class="alert alert-error show">
                    <button class="close" data-dismiss="alert"></button>
                    <span>${successMsg}</span>
                </div>
            </#if>
                <div class="form-group">
                    <input type="email" id="forgot_email" name="forgot_email" placeholder="请输入邮箱" class="form-control">
                </div>
                <div class="form-group">
                    <input type="password" id="forgot_password" name="forgot_password" placeholder="请输入新密码" class="form-control middle" data-toggle="tooltip" data-placement="auto" title="长度为6-18个字符">
                </div>
                <button class="btn btn-lg btn-danger btn-block" id="btn_btn_lg_btn_danger_btn_block" type="submit">找回密码</button>
            </form>
        </div>

    </div>
    <hr>
    <div class="text-center">
        <ul class="list-inline">
            <li><a class="text-muted" href="/login">登录</a></li>
            <li><a class="text-muted" href="#forgot" data-toggle="tab">忘记密码？</a></li>
            <#--<li><a class="text-muted" href="/user/sign-up">注册</a></li>-->
        </ul>
    </div>
</div>


<!--jQuery -->
<script src="/assets/lib/jquery/jquery.js"></script>

<!--Bootstrap -->
<script src="/assets/lib/bootstrap/js/bootstrap.js"></script>

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
            $(".forgot_form").submit();
    });

</script>
</body>

</html>
