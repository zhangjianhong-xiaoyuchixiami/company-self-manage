
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

                    <form action="/customer/account-message" class="account_message" method="get">

                        <div class="clearfix margin-bottom-20 head-search-clearfix-top">

                            <div class="pull-left head-search-bottom head-search-top">

                                <label class="control-label">&nbsp;&nbsp;</label>

                                <div class="controls">

                                    <div class="input-append">

                                        <input class="m-wrap" <#if content??>value="${content}" </#if> type="text" id="content" name="content" placeholder="请输入账号">

                                        <button class="btn black" type="submit">搜索</button>

                                    </div>

                                </div>

                            </div>

                        </div>

                    </form>

                <#--表单-->

                    <div class="portlet box grey">

                        <div class="portlet-title">

                            <div class="caption"><i class="icon-user"></i><#if companyName??>${companyName}</#if></div>

                        </div>

                        <div class="portlet-body no-more-tables">

                            <div class="table-responsive">
                                <table class="table table-bordered table-hover table-striped" id="sample_2">
                                    <thead>
                                    <tr>
                                        <th>账号</th>
                                        <th>账号类型</th>
                                        <th>密码</th>
                                        <th>余额（单位：元）</th>
                                        <#if floor != 0>
                                            <th>信用额度（单位：元）</th>
                                            <th>可用额度（单位：元）</th>
                                        </#if>
                                        <th>Ip范围</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                        <#if customerList??>
                                            <#list customerList as customer>
                                            <tr>
                                                <#if customer.status == 0>
                                                <td data-title="账号">
                                                <#else >
                                                <td data-title="账号" class="font-text-decoration">
                                                </#if>
                                            ${customer.authId}
                                            </td>
                                                <td data-title="账号类型">${customer.customerType.name}</td>
                                                <td data-title="密码">
                                                    <span id="table_password_${customer.id}">
                                                        <a href="javaScript:;" onclick="showPassword(${customer.id})" data-toggle="tooltip" data-placement="auto" title="点击显示密码">显示密码</a>
                                                    </span>
                                                    <span id="table_content_password_${customer.id}" style="display: none">${customer.authPass}</span>
                                                </td>
                                                <td data-title="余额">${customer.balance/100.0}</td>
                                                <#if floor != 0>
                                                    <td data-title="信用额度">${-customer.floor/100.0}</td>
                                                    <td data-title="可用额度">${customer.usableFloor/100.0}</td>
                                                </#if>
                                                <td data-title="Ip段">
                                                    <#if customer.customerIpList?? && (customer.customerIpList?size>0)>
                                                        <a href="#form_modal_customer_ip_list"  onclick="showIp(${customer.id})" data-toggle="modal">点击查看Ip段</a>
                                                    <#else >
                                                        <span class="warning">暂无Ip</span>
                                                    </#if>
                                                </td>
                                            </tr>
                                            </#list>
                                        </#if>
                                    </tbody>

                                </table>

                            </div>

                        </div>

                    </div>

                <#--Ip列表-->
                    <div id="form_modal_customer_ip_list" class="modal hide fade myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel_customer_ip_list" aria-hidden="true">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true"></button>
                            <h3 id="myModalLabel_customer_ip_list">Ip列表</h3>
                        </div>

                        <div class="modal-body">
                            <table class="table table-striped table-hover table-bordered table-condensed" id="simple_customer_ip_1">
                                <thead>
                                <tr>
                                    <th>起始Ip</th>
                                    <th>结束Ip</th>
                                </tr>
                                </thead>
                                <tbody>
                                </tbody>
                            </table>
                        </div>
                    </div>

                </div>

            </div>

        </div>

    </div>

    <#elseif section = "footer">

    <#elseif section = "publicJs">

    <#elseif section = "privateJs">

    <script type="text/javascript" src="/assets/js/local/account-message.js"></script>

    <script type="text/javascript" src="/assets/js/local/account-left-bar.js"></script>

    <script type="text/javascript" src="/manage/js/myself/account-message.js"></script>

    <script>
        jQuery(document).ready(function() {
            AccountMessage.init();
            AccountLeftBar.init();
        });

    </script>

    </#if>

</@layout>
