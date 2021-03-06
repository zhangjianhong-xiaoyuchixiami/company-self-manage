<#macro layout>

    <#import "publisjs.ftl" as puj>
<!DOCTYPE html>

<!--[if IE 8]> <html lang="en" class="ie8"> <![endif]-->

<!--[if IE 9]> <html lang="en" class="ie9"> <![endif]-->

<!--[if !IE]><!--> <html lang="en"> <!--<![endif]-->
<head>

    <meta charset="utf-8" />
    <title>个人管理后台</title>
    <meta content="width=device-width, height=device-height, initial-scale=1.0" name="viewport" />
    <meta content="" name="description" />
    <meta content="" name="author" />
    <link rel="stylesheet" type="text/css" href="/manage/css/bootstrap.min.css"/>
    <link rel="stylesheet" type="text/css" href="/manage/css/bootstrap-responsive.min.css"/>
    <link rel="stylesheet" type="text/css" href="/manage/css/font-awesome.min.css"/>
    <link rel="stylesheet" type="text/css" href="/manage/css/font-awesome.css"/>
    <link rel="stylesheet" type="text/css" href="/manage/css/style-metro.css"/>
    <link rel="stylesheet" type="text/css" href="/manage/css/style.css"/>
    <link rel="stylesheet" type="text/css" href="/manage/css/style-responsive.css"/>
    <link rel="stylesheet" type="text/css" href="/manage/css/default.css" id="style_color"/>
    <link rel="stylesheet" type="text/css" href="/manage/css/uniform.default.css" />
    <link rel="stylesheet" type="text/css" href="/manage/css/DT_bootstrap.css" />
    <link rel="stylesheet" type="text/css" href="/manage/css/bootstrap-fileupload.css" />
    <link rel="stylesheet" type="text/css" href="/manage/css/jquery.gritter.css" />
    <link rel="stylesheet" type="text/css" href="/manage/css/chosen.css" />
    <link rel="stylesheet" type="text/css" href="/manage/css/select2_metro.css" />
    <link rel="stylesheet" type="text/css" href="/manage/css/jquery.tagsinput.css" />
    <link rel="stylesheet" type="text/css" href="/manage/css/clockface.css" />
    <link rel="stylesheet" type="text/css" href="/manage/css/bootstrap-wysihtml5.css" />
    <link rel="stylesheet" type="text/css" href="/manage/css/datepicker.css" />
    <link rel="stylesheet" type="text/css" href="/manage/css/timepicker.css" />
    <link rel="stylesheet" type="text/css" href="/manage/css/colorpicker.css" />
    <link rel="stylesheet" type="text/css" href="/manage/css/bootstrap-toggle-buttons.css" />
    <link rel="stylesheet" type="text/css" href="/manage/css/daterangepicker.css" />
    <link rel="stylesheet" type="text/css" href="/manage/css/datetimepicker.css" />
    <link rel="stylesheet" type="text/css" href="/manage/css/multi-select-metro.css" />
    <link rel="stylesheet" type="text/css" href="/manage/css/bootstrap-modal.css"/>
    <link rel="stylesheet" type="text/css" href="/manage/css/datepicker.css" />
    <link rel="stylesheet" type="text/css" href="/manage/css/search.css"/>
    <link rel="stylesheet" type="text/css" href="/manage/css/icon.css" />
    <link rel="stylesheet" type="text/css" href="/manage/css/local/head-search.css"/>
    <link rel="stylesheet" type="text/css" href="/manage/css/local/main-response-table.css"/>
    <link rel="shortcut icon" href="/manage/image/favicon.ico" />
<#--  <link rel="stylesheet" type="text/css" href="/font-awesome/css/font-awesome.min.css">-->
    <style>
        a:hover {text-decoration: none;}
    </style>

</head>

<body class="page-header-fixed">

<div id="head"><#nested "head" />

    <div class="header navbar navbar-inverse navbar-fixed-top">

        <div class="navbar-inner">

            <div class="container-fluid">

                <a href="javascript:;" class="btn-navbar collapsed" data-toggle="collapse" data-target=".nav-collapse">

                    <img src="/manage/image/icon/left-icon.png" alt="" />

                </a>

                <ul class="nav pull-right">

                <#-- <li class="dropdown" id="header_inbox_bar">

                     <a href="#" class="dropdown-toggle" data-toggle="dropdown">

                         <span class="badge"></span>

                         <i class="icon-envelope"></i>

                     </a>

                     <ul id="dropdown-menu-extended-notification" class="dropdown-menu extended inbox">

                     </ul>

                 </li>-->

                    <li class="dropdown">

                        <a href="javaScript:;" class="dropdown-toggle" data-toggle="dropdown">

                            <i class="icon-user"></i>

                            <span class="username"><@shiro.principal/></span>

                            <i class="icon-angle-down"></i>

                        </a>

                        <ul class="dropdown-menu">

                            <li><a href="#form_modal_update_password" data-toggle="modal"><i class="icon-calendar"></i>修改登录密码</a></li>

                            <li><a href="/view/logout"><i class="icon-key"></i> 退出</a></li>

                        </ul>

                    </li>

                </ul>

            <#--修改密码弹框-->
                <div id="form_modal_update_password" class="modal hide fade myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel_update_password" aria-hidden="true">

                    <form id="form_update_password" action="#" class="form-horizontal">

                        <div class="modal-header">

                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true"></button>

                            <h3 id="myModalLabel_update_password">请填写信息</h3>

                        </div>

                        <div class="modal-body">

                            <div class="alert alert-error hide">

                                <button class="close" data-dismiss="alert"></button>

                                <span id="error_alert">对不起，请检查你的输入！</span>

                            </div>

                            <div class="alert alert-success hide">

                                <button class="close" data-dismiss="alert"></button>

                                <span>恭喜您，操作成功!</span>

                            </div>

                            <div class="control-group">

                                <label class="control-label">请输入原始密码<span class="required">*</span></label>

                                <div class="controls">

                                    <input type="password" id="oldPassword" name="oldPassword" class="m-wrap medium">

                                    <span id="oldPassword_Msg" class="help-line"></span>

                                </div>

                            </div>

                            <div class="control-group">

                                <label class="control-label">请输入新密码<span class="required">*</span></label>

                                <div class="controls">

                                    <input type="password" id="newPassword" name="newPassword" class="m-wrap medium">

                                    <span id="newPassword_Msg" class="help-line"></span>

                                    <span class="help-block">说明：长度为6-12个字符</span>

                                </div>

                            </div>

                            <div class="control-group">

                                <label class="control-label">请再次输入新密码<span class="required">*</span></label>

                                <div class="controls">

                                    <input type="password" id="newRpPassword" name="newRpPassword" class="m-wrap medium">

                                    <span id="newRpPassword_Msg" class="help-line"></span>

                                </div>

                            </div>

                        </div>

                        <div class="modal-footer">

                            <button class="btn" data-dismiss="modal" aria-hidden="true">取消</button>

                            <button class="btn black btn-primary" id="update-password-btn-black-btn-primary" type="button">提交</button>

                        </div>

                    </form>

                </div>

            <#--查看消息弹框-->
                <div id="form_modal_user_notice" class="modal hide fade myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel_user_notice" aria-hidden="true">

                    <div class="modal-header">

                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true"></button>

                        <h4 id="myModalLabel_user_notice"><i class="icon-reorder"></i><span id="myModalLabel_user_notice_span"></span></h4>

                    </div>

                    <div class="modal-body">

                        <div class="row-fluid">

                            <div class="span12 ">

                                <div class="portlet">

                                    <div id="user-notice-portlet-body" class="portlet-body">

                                    </div>

                                    <span id="user-notice-portlet-body-id" class="head-search-display"></span>

                                </div>

                            </div>

                        </div>

                    </div>

                    <div class="modal-footer" id="modal-footer-user-notice">

                        <button class="btn" data-dismiss="modal" aria-hidden="true">取消</button>

                    </div>

                </div>

            </div>

        </div>

    </div>

    <div class="page-container row-fluid">

        <div class="page-sidebar nav-collapse collapse">

            <ul class="page-sidebar-menu">

                <li>
                    <div class="sidebar-toggler hidden-phone"></div>
                </li>

            <#--账号信息-->
                <li id="customerManage">
                    <a href="javascript:;"><i class="icon-group"></i>
                        <span class="title">账号管理</span>
                        <span class="" id="customerManageSelect"></span>
                        <span class="arrow" id="customerManageArrow"></span>
                    </a>
                    <ul class="sub-menu">
                        <li id="customerList"><a href="/customer/account-message">账号信息</a></li>
                    <#-- <li id="customerProductList"><a href="/company/find-company-product-by-company-id">已购买产品</a></li>-->
                    </ul>
                </li>

            <#-- <li id="noticeManage">
                 <a href="javascript:;"><i class="icon-envelope"></i>
                     <span class="title">消息通知</span>
                     <span class="" id="noticeManageSelect"></span>
                     <span class="arrow" id="noticeManageArrow"></span>
                 </a>
                 <ul class="sub-menu">
                     <li id="noticeList"><a href="/notice/user-notice?reasonId=1">收件箱</a></li>
                 </ul>
             </li>-->

            <#--财务管理-->
                <li id="financeManage">
                    <a href="javascript:;"><i class="icon-bar-chart"></i>
                        <span class="title">财务管理</span>
                        <span class="" id="financeManageSelect"></span>
                        <span class="arrow" id="financeManageArrow"></span>
                    </a>
                    <ul class="sub-menu">
                        <li id="consumeList"><a href="/finance/account-consume">消费账单</a></li>
                    </ul>
                </li>

            <#--接口短信-->
               <#-- <li id="SMSManage">
                    <a href="javascript:;"><i class="icon-th"></i>
                        <span class="title">接口短信</span>
                        <span class="" id="SMSManageSelect"></span>
                        <span class="arrow" id="SMSManageArrow"></span>
                    </a>
                    <ul class="sub-menu">
                        <li id="SMSList"><a href="/sms/sms-message">发送记录</a></li>
                    </ul>
                </li>-->

            </ul>

        </div>

    </div>

</div>

<div id="content"><#nested "content" />

</div>

<div id="footer"><#nested "footer" />

    <div class="footer">

        <div class="footer-inner">

        <#--2016 &copy;-->
        </div>

        <div class="footer-tools">

			<span class="go-top">

			<i class="icon-angle-up"></i>

			</span>

        </div>

    </div>

</div>

    <#nested "publicJs" />

    <@puj.publicJs></@puj.publicJs>

<script src="/assets/js/local/update-password.js"></script>

<script>
    jQuery(document).ready(function() {

        UpdatePassword.init();

    });
</script>

<script>

    /*显示有几条未读信息*/
    function getCount() {
        $.ajax({
            type: "post",
            url: "/notice/unread-notice-content",
            dataType: "json",
            success: function(date){
                var result = date.userNoticeList;
                var count = date.userNoticeCount;
                if ( result != null){
                    $("#dropdown-menu-extended-notification").empty();
                    $("#dropdown-menu-extended-notification").append("<li> <p>你有&nbsp;<span id='badge_msg'></span>&nbsp;条未读消息</p> </li>");
                    for (var i=0; i<result.length; i++){
                        $("#dropdown-menu-extended-notification").append(
                                "<li>" +
                                "<a href='#form_modal_user_notice' data-toggle='modal' onclick='queryNoticeById("+result[i].id+")'>" +
                                "<span class='subject'>" +
                                "<div><span class='from'>" +result[i].notice.title+ "</span></div>" +
                                "<span class='time'>" +result[i].estimate.roughEstimateCreateTime+ "</span>" +
                                "</span>"+
                                "</a>" +
                                "</li>");
                    }
                    $("#dropdown-menu-extended-notification").append("<li class='external'> <a href='/notice/user-notice?reasonId=1'>查看所有消息 <i class='m-icon-swapright'></i></a></li>");
                    $(".badge").empty();
                    $(".badge").html(count);
                    $("#badge_msg").empty();
                    $("#badge_msg").html(count);
                }
            }
        });
    }

    /*一秒请求一次*/
    /*setInterval("getCount()",1000);*/

    /*根据Id查询通知信息*/
    function queryNoticeById(id) {
        $.ajax({
            type: "post",
            url: "/notice/notice-content",
            data: {"id":id},
            dataType: "json",
            success: function(date){
                if ( date != null){
                    $("#myModalLabel_user_notice_span").empty();
                    $("#user-notice-portlet-body").empty();
                    $("#user-notice-portlet-body-id").empty();
                    $("#myModalLabel_user_notice_span").html(date.notice.title);
                    $("#user-notice-portlet-body").html(date.notice.content);
                    $("#user-notice-portlet-body-id").html(id);
                    $("#user-notice-btn-black-btn-primary").remove();
                    if (date.isActive == 0){
                        $("#modal-footer-user-notice").append("<button class='btn black btn-primary' id='user-notice-btn-black-btn-primary' onclick='markRead()' type='button'>标记为已读</button>")
                    }
                }
            }
        });
    }

    /*将消息标记为已读*/
    function markRead() {
        var id=$("#user-notice-portlet-body-id").text();
        $.ajax({
            type: "post",
            url: "/notice/update-active",
            data: {"id":id},
            dataType: "json",
            success: function(result){
                if (result.successMessage != null){
                    $("#user-notice-btn-black-btn-primary").remove();
                }
            }
        })
    }

</script>

    <#nested "privateJs" />

</body>
</html>
</#macro>