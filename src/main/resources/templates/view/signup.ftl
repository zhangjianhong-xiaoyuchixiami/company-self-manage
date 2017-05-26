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
    <link rel="stylesheet" href="/assets/css/bootstrap.min.css">

    <!-- Font Awesome -->
<#--   <link rel="stylesheet" href="/assets/lib/font-awesome/css/font-awesome.css">-->

    <link rel="stylesheet" href="/manage/css/font-awesome.css">

    <!-- Metis core stylesheet -->
    <link rel="stylesheet" href="/assets/css/main.css">

    <link rel="stylesheet" href="/assets/css/back.css">

    <!-- metisMenu stylesheet -->
    <link rel="stylesheet" href="/assets/lib/metismenu/metisMenu.css">

    <!-- animate.css stylesheet -->
    <link rel="stylesheet" href="/assets/lib/animate.css/animate.css">

    <link rel="stylesheet" href="/manage/css/icon.css">

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

<div class="form-signin max-width" style="max-width: 370px">
    <div class="text-center">


    </div>
    <hr>
    <div class="tab-content">

        <div id="signup" class="tab-pane active">
            <form action="" method="post" class="form-horizontal" role="form">
                <div id="alert_error">

                </div>

                <div class="control-group control-group-margin-bottom">
                    <label class="control-label control-label-width">邮箱<span class="required">*</span></label>
                    <div class="controls control-margin-left">
                        <input type="email" id="sign_up_email" name="sign_up_email" placeholder="请输入邮箱（必填）" class="m-wrap medium" />
                        <span class="help-inline" id="sign_up_email_msg"></span>
                    </div>
                </div>
                <div class="control-group control-group-margin-bottom">
                    <label class="control-label control-label-width">密码<span class="required">*</span></label>
                    <div class="controls control-margin-left">
                        <input type="password" id="sign_up_password" name="sign_up_password" placeholder="请输入密码（必填）" class="m-wrap medium" data-toggle="tooltip" data-placement="auto" title="长度为6-18个字符"/>
                        <span class="help-inline" id="sign_up_password_msg"></span>
                    </div>
                </div>
                <div class="control-group control-group-margin-bottom">
                    <label class="control-label control-label-width">确认密码<span class="required">*</span></label>
                    <div class="controls control-margin-left">
                        <input type="password" id="sign_up_rpPassword" name="sign_up_rpPassword" placeholder="请再次输入密码（必填）" class="m-wrap medium" data-toggle="tooltip" data-placement="auto" title="长度为6-18个字符"/>
                        <span class="help-inline" id="sign_up_rpPassword_msg"></span>
                    </div>
                </div>
                <div class="control-group control-group-margin-bottom">
                    <label class="control-label control-label-width">公司名称<span class="required">*</span></label>
                    <div class="controls control-margin-left">
                        <input type="text" id="sign_up_companyName" name="sign_up_companyName" placeholder="请输入公司名称（必填）" class="m-wrap medium" />
                        <span class="help-inline" id="sign_up_companyName_msg"></span>
                    </div>
                </div>
                <div class="control-group control-group-margin-bottom">
                    <label class="control-label control-label-width">商务负责人<span class="required">*</span></label>
                    <div class="controls control-margin-left">
                        <input type="text" id="sign_up_busPerson" name="sign_up_busPerson" placeholder="请输入商务负责人（必填）" class="m-wrap medium" />
                        <span class="help-inline" id="sign_up_busPerson_msg"></span>
                    </div>
                </div>
                <div class="control-group control-group-margin-bottom">
                    <label class="control-label control-label-width">联系电话<span class="required">*</span></label>
                    <div class="controls control-margin-left">
                        <input type="text" id="sign_up_busTel" name="sign_up_busTel" placeholder="请输入联系电话（必填）" class="m-wrap medium" />
                        <span class="help-inline" id="sign_up_busTel_msg"></span>
                    </div>
                </div>

                <div id="sign_up_more_message" class="text-none">
                    <div class="sign_up_companyUrl_more">
                        <div class="control-group control-group-margin-bottom">
                            <label class="control-label control-label-width">公司网址<span>*</span></label>
                            <div class="controls control-margin-left">
                                <input type="text" id="sign_up_companyUrl" name="sign_up_companyUrl" placeholder="请输入公司网址（选填）" class="m-wrap medium" />
                                <a class="sign_up_companyUrl text-muted"><i class="icon-plus"></i></a>
                                <span class="help-inline" id="sign_up_companyUrl_msg"></span>
                            </div>
                        </div>
                    </div>
                    <div class="sign_up_officialIp_more">
                        <div class="control-group control-group-margin-bottom">
                            <label class="control-label control-label-width">正式公网Ip<span>*</span></label>
                            <div class="controls control-margin-left">
                                <input type="text" id="sign_up_officialIp" name="sign_up_officialIp" placeholder="请输入正式公网Ip（选填）" class="m-wrap medium" />
                                <a class="sign_up_officialIp text-muted"><i class="icon-plus"></i></a>
                                <span class="help-inline" id="sign_up_officialIp_msg"></span>
                            </div>
                        </div>
                    </div>
                    <div class="sign_up_testIp_more">
                        <div class="control-group control-group-margin-bottom">
                            <label class="control-label control-label-width">测试公网Ip<span>*</span></label>
                            <div class="controls control-margin-left">
                                <input type="text" id="sign_up_testIp" name="sign_up_testIp" placeholder="请输入测试公网Ip（选填）" class="m-wrap medium" />
                                <a class="sign_up_testIp text-muted"><i class="icon-plus"></i></a>
                                <span class="help-inline" id="sign_up_testIp_msg"></span>
                            </div>
                        </div>
                    </div>
                    <div class="control-group control-group-margin-bottom">
                        <label class="control-label control-label-width">技术负责人<span>*</span></label>
                        <div class="controls control-margin-left">
                            <input type="text" id="sign_up_techPerson" name="sign_up_techPerson" placeholder="请输入技术负责人（选填）" class="m-wrap medium" />
                            <span class="help-inline" id="sign_up_techPerson_msg"></span>
                        </div>
                    </div>
                    <div class="control-group control-group-margin-bottom">
                        <label class="control-label control-label-width">联系电话<span>*</span></label>
                        <div class="controls control-margin-left">
                            <input type="text" id="sign_up_techTel" name="sign_up_techTel" placeholder="请输入联系电话（选填）" class="m-wrap medium" />
                            <span class="help-inline" id="sign_up_techTel_msg"></span>
                        </div>
                    </div>
                    <div class="control-group control-group-margin-bottom">
                        <label class="control-label control-label-width">申请开通产品<span>*</span></label>
                        <div class="controls control-margin-left">
                            <textarea rows="3" id="sign_up_product" name="sign_up_product" placeholder="请输入申请开通产品（选填）" class="medium m-wrap" ></textarea>
                            <span class="help-inline" id="sign_up_product_msg"></span>
                        </div>
                    </div>
                    <div class="control-group control-group-margin-bottom">
                        <label class="control-label control-label-width">备注<span>*</span></label>
                        <div class="controls control-margin-left">
                            <textarea rows="3" id="sign_up_content" name="sign_up_content" placeholder="备注（选填）" class="medium m-wrap" ></textarea>
                            <span class="help-inline" id="sign_up_content_msg"></span>
                        </div>
                    </div>

                </div>
                <span id="sign_up_block_message_span"><a onclick="blockMessage()" href="javaScript:;">+点击填写更多</a></span>

                <button class="btn btn-lg btn-success btn-block" id="btn_btn_lg_btn_success_btn_block" type="button">注册</button>

            </form>
        </div>

    </div>
    <hr>
    <div class="text-center">
        <ul class="list-inline">
            <li><a class="text-muted" href="/login">登录</a></li>
            <li><a class="text-muted" href="/user/forgot-url">忘记密码？</a></li>
            <li><a class="text-muted" href="#signup" data-toggle="tab">注册</a></li>
        </ul>
    </div>
</div>


<!--jQuery -->
<script src="/assets/lib/jquery/jquery.js"></script>

<!--Bootstrap -->
<script src="/assets/lib/bootstrap/js/bootstrap.js"></script>


<#--登录验证-->
<script src="/assets/js/local/sign-up.js"></script>

<script type="text/javascript">

    LocalSignUp.init();

</script>

<script>
    $(function () { $("[data-toggle='tooltip']").tooltip(); });

    function blockMessage() {
        $("#sign_up_more_message").removeClass("text-none");
        $("#sign_up_more_message").addClass("text-block");
        $("#sign_up_block_message_span").empty();
        $("#sign_up_block_message_span").html("<a onclick='noneMessage()' href='javaScript:;'>点击隐藏</a>")
    }

    function noneMessage() {
        $("#sign_up_more_message").removeClass("text-block");
        $("#sign_up_more_message").addClass("text-none");
        $("#sign_up_block_message_span").empty();
        $("#sign_up_block_message_span").html("<a onclick='blockMessage()' href='javaScript:;'>+点击填写更多</a>")
    }

</script>


</body>

</html>
