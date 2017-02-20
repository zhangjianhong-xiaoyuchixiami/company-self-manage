<#macro layout>
<!DOCTYPE html>

<!--[if IE 8]> <html lang="en" class="ie8"> <![endif]-->

<!--[if IE 9]> <html lang="en" class="ie9"> <![endif]-->

<!--[if !IE]><!--> <html lang="en"> <!--<![endif]-->
<head>

    <meta charset="utf-8" />
    <title>后台</title>
    <meta content="width=device-width, height=device-height, initial-scale=1.0" name="viewport" />
    <meta content="" name="description" />
    <meta content="" name="author" />
   <link rel="stylesheet" type="text/css"  href="/manage/css/local/main-response-table.css"/>
    <link rel="stylesheet" type="text/css" href="/manage/css/bootstrap.min.css"/>
    <link rel="stylesheet" type="text/css" href="/manage/css/bootstrap-responsive.min.css"/>
    <link rel="stylesheet" type="text/css" href="/manage/css/font-awesome.min.css"/>
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
    <link rel="shortcut icon" href="/manage/image/favicon.ico" />
    <link rel="stylesheet" type="text/css" href="/font-awesome/css/font-awesome.min.css">
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

                    <li class="dropdown" id="header_notification_bar">

                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">

                            <span class="badge">6</span>

                            <i class="fa fa-envelope"></i>

                        </a>

                        <ul class="dropdown-menu extended notification">

                            <li>

                                <p>You have 14 new notifications</p>

                            </li>

                            <li>

                                <a href="#">

                                    <span class="label label-success"><i class="icon-plus"></i></span>

                                    New user registered.

                                    <span class="time">Just now</span>

                                </a>

                            </li>

                            <li>

                                <a href="#">

                                    <span class="label label-important"><i class="icon-bolt"></i></span>

                                    Server #12 overloaded.

                                    <span class="time">15 mins</span>

                                </a>

                            </li>

                            <li>

                                <a href="#">

                                    <span class="label label-warning"><i class="icon-bell"></i></span>

                                    Server #2 not respoding.

                                    <span class="time">22 mins</span>

                                </a>

                            </li>

                            <li>

                                <a href="#">

                                    <span class="label label-info"><i class="icon-bullhorn"></i></span>

                                    Application error.

                                    <span class="time">40 mins</span>

                                </a>

                            </li>

                            <li>

                                <a href="#">

                                    <span class="label label-important"><i class="icon-bolt"></i></span>

                                    Database overloaded 68%.

                                    <span class="time">2 hrs</span>

                                </a>

                            </li>

                            <li>

                                <a href="#">

                                    <span class="label label-important"><i class="icon-bolt"></i></span>

                                    2 user IP blocked.

                                    <span class="time">5 hrs</span>

                                </a>

                            </li>

                            <li class="external">

                                <a href="#">See all notifications <i class="m-icon-swapright"></i></a>

                            </li>

                        </ul>

                    </li>

                    <li class="dropdown">

                        <a href="javaScript:;" class="dropdown-toggle" data-toggle="dropdown">

                            <i class="fa fa-user"></i>

                            <span class="username"><@shiro.principal/></span>

                            <i class="icon-angle-down"></i>

                        </a>

                        <ul class="dropdown-menu">

                            <li><a href="/user/updatePasswordView"><i class="icon-calendar"></i>修改密码</a></li>

                            <li><a href="/view/logout"><i class="icon-key"></i> 退出</a></li>

                        </ul>

                    </li>

                </ul>

            </div>

        </div>

    </div>

    <div class="page-container row-fluid">

        <div class="page-sidebar nav-collapse collapse">

            <ul class="page-sidebar-menu">

                <li>
                    <div class="sidebar-toggler hidden-phone"></div>
                </li>

                <li class="active" id="customerManage">
                    <a href="javascript:;"><i class="icon-sitemap"></i>
                        <span class="title">账号管理</span>
                        <span class="" id="customerManageSelect"></span>
                        <span class="arrow " id="customerManageArrow"></span>
                    </a>
                    <ul class="sub-menu">
                        <li id="customerList"><a href="/customer/account-message">账号信息</a></li>
                        <li id="customerList"><a href="/company/find-company-product-by-company-id">已购买产品</a></li>
                    </ul>
                </li>

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

<script src="/manage/js/jquery-1.10.1.min.js" type="text/javascript"></script>

<script src="/manage/js/jquery-migrate-1.2.1.min.js" type="text/javascript"></script>

<script src="/manage/js/jquery-ui-1.10.1.custom.min.js" type="text/javascript"></script>

<script src="/manage/js/bootstrap.min.js" type="text/javascript"></script>

<script src="/manage/js/excanvas.min.js"></script>

<script src="/manage/js/respond.min.js"></script>

<script src="/manage/js/jquery.slimscroll.min.js" type="text/javascript"></script>

<script src="/manage/js/jquery.blockui.min.js" type="text/javascript"></script>

<script src="/manage/js/jquery.cookie.min.js" type="text/javascript"></script>

<script src="/manage/js/jquery.uniform.min.js" type="text/javascript" ></script>

<script type="text/javascript" src="/manage/js/bootstrap-datepicker.js"></script>

<script type="text/javascript" src="/manage/js/locales/bootstrap-datepicker.zh-CN.js"></script>

<script type="text/javascript">
    $('.date-picker').datepicker({
        language: 'zh-CN',
        autoclose: true,
        todayHighlight: false
    })
</script>

<script src="/manage/js/search.js"></script>

<script type="text/javascript" src="/manage/js/jquery.validate.min.js"></script>

<script type="text/javascript" src="/manage/js/select2.min.js"></script>

<script type="text/javascript" src="/manage/js/chosen.jquery.min.js"></script>

<script type="text/javascript" src="/manage/js/ckeditor.js"></script>

<script type="text/javascript" src="/manage/js/bootstrap-fileupload.js"></script>

<script type="text/javascript" src="/manage/js/chosen.jquery.min.js"></script>

<script type="text/javascript" src="/manage/js/select2.min.js"></script>

<script type="text/javascript" src="/manage/js/wysihtml5-0.3.0.js"></script>

<script type="text/javascript" src="/manage/js/bootstrap-wysihtml5.js"></script>

<script type="text/javascript" src="/manage/js/jquery.tagsinput.min.js"></script>

<script type="text/javascript" src="/manage/js/jquery.toggle.buttons.js"></script>

<script type="text/javascript" src="/manage/js/bootstrap-datepicker.js"></script>

<script type="text/javascript" src="/manage/js/bootstrap-datetimepicker.js"></script>

<script type="text/javascript" src="/manage/js/clockface.js"></script>

<script type="text/javascript" src="/manage/js/date.js"></script>

<script type="text/javascript" src="/manage/js/daterangepicker.js"></script>

<script type="text/javascript" src="/manage/js/bootstrap-colorpicker.js"></script>

<script type="text/javascript" src="/manage/js/bootstrap-timepicker.js"></script>

<script type="text/javascript" src="/manage/js/jquery.inputmask.bundle.min.js"></script>

<script type="text/javascript" src="/manage/js/jquery.input-ip-address-control-1.0.min.js"></script>

<script type="text/javascript" src="/manage/js/jquery.multi-select.js"></script>

<script src="/manage/js/bootstrap-modal.js" type="text/javascript" ></script>

<script src="/manage/js/bootstrap-modalmanager.js" type="text/javascript" ></script>

<script src="/manage/js/app.js"></script>

<script src="/manage/js/form-validation.js"></script>

<script src="/manage/js/form-components.js"></script>

<script>

    jQuery(document).ready(function() {
        App.init();

        Search.init();

    });
</script>

<script type="text/javascript">  var _gaq = _gaq || [];  _gaq.push(['_setAccount', 'UA-37564768-1']);  _gaq.push(['_setDomainName', 'keenthemes.com']);  _gaq.push(['_setAllowLinker', true]);  _gaq.push(['_trackPageview']);  (function() {    var ga = document.createElement('script'); ga.type = 'text/javascript'; ga.async = true;    ga.src = ('https:' == document.location.protocol ? 'https://' : 'http://') + 'stats.g.doubleclick.net/dc.js';    var s = document.getElementsByTagName('script')[0]; s.parentNode.insertBefore(ga, s);  })();
</script>

    <#nested "privateJs" />
</body>
</html>
</#macro>