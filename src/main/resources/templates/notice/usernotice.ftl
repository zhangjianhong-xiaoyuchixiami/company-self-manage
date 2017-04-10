
<#include "../publicpart/layout.ftl">

<#import "../publicpart/headnavigationbars.ftl" as c>

<@layout ; section>

    <#if section = "head">

    <#elseif section = "content" >

    <div class="page-content">

        <div class="container-fluid">

            <@c.navigationBars></@c.navigationBars>

            <div class="row-fluid">

                <div class="span12">

                    <form action="/notice/user-notice" class="user_notice" method="get">

                        <div class="clearfix margin-bottom-20 head-search-clearfix-top">

                            <div class="pull-left head-search-bottom">

                                <label class="control-label">状态</label>

                                <div class="controls">

                                    <label class="checkbox">

                                        <input type="checkbox" <#if reasonIdArray??><#list reasonIdArray as reasonId><#if reasonId=="0">checked="checked"</#if></#list></#if> id="reasonId" name="reasonId" value="0">未读

                                    </label>

                                    <label class="checkbox">

                                        <input type="checkbox" <#if reasonIdArray??><#list reasonIdArray as reasonId><#if reasonId=="1">checked="checked"</#if></#list></#if> id="reasonId" name="reasonId" value="1">已读

                                    </label>

                                </div>

                            </div>

                            <div class="pull-left margin-right-20 head-search-bottom">

                                <label class="control-label">起始日期</label>

                                <div class="controls">

                                    <div class="input-append date date-picker" data-date-viewmode="years" data-date-minviewmode="months">

                                        <input <#if beginDate??>value="${beginDate}" </#if> id="beginDate" name="beginDate" class="m-wrap m-ctrl-medium date-picker" size="16" type="text" style="width: 150px;"><span class="add-on"><i class="icon-calendar"></i></span>

                                    </div>

                                </div>

                            </div>

                            <div class="pull-left head-search-bottom">

                                <label class="control-label">结束日期</label>

                                <div class="controls">

                                    <div class="input-append date date-picker" data-date-viewmode="years" data-date-minviewmode="months">

                                        <input <#if endDate??>value="${endDate}" </#if> id="endDate" name="endDate" class="m-wrap m-ctrl-medium date-picker" size="16" type="text" style="width: 150px;"><span class="add-on"><i class="icon-calendar"></i></span>

                                    </div>

                                </div>

                            </div>

                            <div class="pull-left head-search-bottom">

                                <label class="control-label">请输入标题</label>

                                <div class="controls">

                                    <div class="input-append">

                                        <input class="m-wrap" <#if title??>value="${title}" </#if> type="text" id="title" name="title" placeholder="请输入标题">

                                    </div>

                                </div>

                            </div>

                            <div class="pull-left head-search-bottom">

                                <label class="control-label">&nbsp;&nbsp;</label>

                                <div class="controls" >

                                    <div class="input-append">

                                        <button class="btn black" type="submit">搜索</button>

                                    </div>

                                </div>

                            </div>

                        </div>

                    </form>

                <#--表单-->

                    <div class="portlet box grey">

                        <div class="portlet-body no-more-tables">

                            <div class="table-responsive">
                                <table class="table table-bordered table-hover table-striped" id="sample_6">
                                    <thead>
                                    <tr>
                                        <th>标题</th>
                                        <th>发布时间</th>
                                        <th>状态</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                        <#if userNoticeList??>
                                            <#list userNoticeList as userNotice>
                                                <#if userNotice.isActive=0>
                                                <tr class="danger">
                                                    <td data-title="标题"><a href="#form_modal_user_notice_receive" data-toggle="modal" onclick="queryNoticeByIdReceive(${userNotice.id})">${userNotice.notice.title}</a></td>
                                                    <td data-title="发布时间">${userNotice.createTime}</td>
                                                    <td data-title="状态"><a href="javaScript:;" onclick="updateStatus(${userNotice.id})">标记为已读</a></td>
                                                </tr>
                                                <#else >
                                                <tr>
                                                    <td data-title="标题"><a href="#form_modal_user_notice_receive" data-toggle="modal" onclick="queryNoticeByIdReceive(${userNotice.id})">${userNotice.notice.title}</a></td>
                                                    <td data-title="发布时间">${userNotice.createTime}</td>
                                                    <td data-title="状态">${userNotice.noticeStatus.name}</td>
                                                </tr>
                                                </#if>
                                            </#list>
                                        </#if>
                                    </tbody>

                                </table>

                                <div id="form_modal_user_notice_receive" class="modal hide fade myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel_user_notice_receive" aria-hidden="true">

                                    <div class="modal-header">

                                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true"></button>

                                        <h4 id="myModalLabel_user_notice_receive"><i class="icon-reorder"></i><span id="myModalLabel_user_notice_receive_span"></span></h4>

                                    </div>

                                    <div class="modal-body">

                                        <div class="row-fluid">

                                            <div class="span12 ">

                                                <div class="portlet">

                                                    <div id="user-notice-portlet-body-receive" class="portlet-body">

                                                    </div>

                                                    <span id="user-notice-portlet-body-receive-id" class="head-search-display"></span>

                                                </div>

                                            </div>

                                        </div>

                                    </div>

                                    <div class="modal-footer" id="modal-footer-user-notice-receive">

                                        <button class="btn" data-dismiss="modal" aria-hidden="true">取消</button>

                                    </div>

                                </div>

                            </div>

                        </div>

                    </div>

                </div>

            </div>

        </div>

    </div>

    <#elseif section = "footer">

    <#elseif section = "publicJs">

    <#elseif section = "privateJs">

    <script type="text/javascript" src="/manage/js/jquery.dataTables.js"></script>

    <script type="text/javascript" src="/manage/js/DT_bootstrap.js"></script>

    <script src="/assets/js/local/user-notice.js"></script>

    <script type="text/javascript" src="/assets/js/local/user-notice-left-bar.js"></script>

    <script>
        jQuery(document).ready(function() {
            UserNotice.init();
            UserNoticeLeftBar.init();
        });
    </script>

    <script type="text/javascript">

        function updateStatus(id) {
            $.ajax({
                type: "post",
                url: "/notice/update-active",
                data: {"id":id},
                dataType: "json",
                success: function(result){
                    if (result.successMessage != null){
                        window.location.href=window.location.href
                    }
                }
            });
        }

        function deleteUserNotice(id) {
            $.ajax({
                type: "post",
                url: "/notice/delete-notice",
                data: {"id":id},
                dataType: "json",
                success: function(result){
                    if (result.successMessage != null){
                        window.location.href=window.location.href
                    }
                }
            });
        }

        function queryNoticeByIdReceive(id) {
            $.ajax({
                type: "post",
                url: "/notice/notice-content",
                data: {"id":id},
                dataType: "json",
                success: function(date){
                    if ( date != null){
                        $("#myModalLabel_user_notice_receive_span").empty();
                        $("#user-notice-portlet-body-receive").empty();
                        $("#user-notice-portlet-body-receive-id").empty();
                        $("#myModalLabel_user_notice_receive_span").html(date.notice.title);
                        $("#user-notice-portlet-body-receive").html(date.notice.content);
                        $("#user-notice-portlet-body-receive-id").html(id);
                        $("#user-notice-receive-btn-black-btn-primary").remove();
                        if (date.isActive == 0){
                            $("#modal-footer-user-notice-receive").append("<button class='btn black btn-primary' id='user-notice-receive-btn-black-btn-primary' onclick='mark()' type='button'>标记为已读</button>")
                        }
                    }
                }
            });
        }

        function mark() {
            var id=$("#user-notice-portlet-body-receive-id").text();
            $.ajax({
                type: "post",
                url: "/notice/update-active",
                data: {"id":id},
                dataType: "json",
                success: function(result){
                    if (result.successMessage != null){
                        window.location.href=window.location.href
                    }
                }
            });
        }

    </script>

    </#if>

</@layout>
