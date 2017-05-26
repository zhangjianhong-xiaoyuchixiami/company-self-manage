
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

                    <form action="/sms/sms-message" class="company_product" method="get">

                        <div class="clearfix margin-bottom-20 head-search-clearfix-top">
                        <#--起始日期-->
                            <div class="pull-left margin-right-20 head-search-bottom">

                                <label class="control-label">起始日期</label>

                                <div class="controls">

                                    <div class="input-append date date-picker" data-date-viewmode="years" data-date-minviewmode="months">

                                        <input <#if beginDate??>value="${beginDate}" </#if> id="beginDate" name="beginDate" class="m-wrap m-ctrl-medium date-picker" size="16" type="text" style="width: 150px;"><span class="add-on"><i class="icon-calendar"></i></span>

                                    </div>

                                </div>

                            </div>
                        <#--结束日期-->
                            <div class="pull-left head-search-bottom">

                                <label class="control-label">结束日期</label>

                                <div class="controls">

                                    <div class="input-append date date-picker" data-date-viewmode="years" data-date-minviewmode="months">

                                        <input <#if endDate??>value="${endDate}" </#if> id="endDate" name="endDate" class="m-wrap m-ctrl-medium date-picker" size="16" type="text" style="width: 150px;"><span class="add-on"><i class="icon-calendar"></i></span>

                                    </div>

                                </div>

                            </div>
                        <#--状态-->
                            <div class="pull-left head-search-bottom">
                                <label class="control-label">状态</label>
                                <div class="controls">
                                    <select id="vendorId" name="vendorId" class="medium m-wrap1" tabindex="1" style="width: 105px;">
                                        <option value="">请选择...</option>
                                        <option>发送成功</option>
                                        <option>接受成功</option>
                                        <option>发送失败</option>
                                        <option>接受失败</option>
                                        <option>系统拦截</option>
                                    </select>
                                </div>
                            </div>
                        <#--运营商-->
                            <div class="pull-left head-search-bottom">
                                <label class="control-label">运营商</label>
                                <div class="controls">
                                    <select id="vendorId" name="vendorId" class="medium m-wrap1" tabindex="1" style="width: 105px;">
                                        <option value="">请选择...</option>
                                        <option>中国移动</option>
                                        <option>中国电信</option>
                                        <option>中国联通</option>
                                    </select>
                                </div>
                            </div>
                        <#--接受号码-->
                            <div class="pull-left head-search-bottom">

                                <label class="control-label">接收号码</label>

                                <div class="controls">

                                    <div class="input-append">

                                        <input class="m-wrap" <#if content??>value="${content}" </#if> type="text" id="companyName" name="content" placeholder="请输入接受号码">

                                    </div>

                                </div>

                            </div>
                        <#--内容-->
                            <div class="pull-left head-search-bottom">

                                <label class="control-label">短信内容</label>

                                <div class="controls">

                                    <div class="input-append">

                                        <input class="m-wrap" <#if content??>value="${content}" </#if> type="text" id="companyName" name="content" placeholder="请输入短信内容">

                                    </div>

                                </div>

                            </div>
                        <#--签名-->
                            <div class="pull-left head-search-bottom">

                                <label class="control-label">签名</label>

                                <div class="controls">

                                    <div class="input-append">

                                        <input class="m-wrap" <#if content??>value="${content}" </#if> type="text" id="companyName" name="content" placeholder="请输入签名内容">

                                    </div>

                                </div>

                            </div>
                        <#--提交按钮-->
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

                    <div class="portlet box grey">

                        <div class="portlet-body no-more-tables">

                            <div class="table-responsive">
                                <table class="table table-bordered table-hover table-striped" id="sms_message_1">
                                    <thead>
                                    <tr>
                                        <th>客户代码</th>
                                        <th>运营商</th>
                                        <th>手机号码</th>
                                        <th>状态报告</th>
                                        <th>发送时间</th>
                                        <th>签名</th>
                                        <th>发送内容</th>
                                        <th>条数</th>
                                    </tr>
                                    </thead>
                                    <tbody>

                                    </tbody>

                                </table>

                            </div>

                        </div>

                    </div>

                    <#--<div id="title_tip" class="tile double bg-grey" style="height: 60px; text-align: center;">
                        <div class="tile-body" style="margin-top: 10px;">
                            <h4>操作失败，请检查你的输入！</h4>
                        </div>
                    </div>-->

                </div>

            </div>

        </div>

    </div>

    <#elseif section = "footer">

    <#elseif section = "publicJs">

    <#elseif section = "privateJs">

    <script type="text/javascript" src="/assets/js/local/sms-message.js"></script>

    <script type="text/javascript" src="/assets/js/local/sms-message-left-bar.js"></script>

    <script>
        jQuery(document).ready(function() {
            SMSMessage.init();
            SMSMessageBar.init();

            //var width = (document.body.clientWidth)/2-139;

            //var height = (document.body.clientHeight)/2-30;

            //$('#title_tip').attr('style','margin-left:400');

            //$('#title_tip').attr('style','margin-top:200');

            //$('#title_tip').fadeOut(3000); // 缓慢地淡出

        });

        $(function () { $("[data-toggle='tooltip']").tooltip(); });

    </script>
    </#if>

</@layout>
