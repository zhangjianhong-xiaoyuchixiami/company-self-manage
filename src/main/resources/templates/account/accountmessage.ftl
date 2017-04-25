
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

                    <#-- <div class="portlet-title">

                         <div class="caption"><i class="icon-user"></i></div>

                     </div>-->

                        <div class="portlet-body no-more-tables">

                        <#--   <div class="clearfix margin-bottom-5">

                               <div class="btn-group">

                                   <a class="btn black" id="add-account" href="#form_modal1" data-toggle="modal">

                                       绑定账号<i class="icon-plus"></i>

                                   </a>

                               </div>

                               <div id="form_modal1" class="modal hide fade myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel1" aria-hidden="true">

                                   <div class="modal-header">

                                       <button type="button" class="close" data-dismiss="modal" aria-hidden="true"></button>

                                       <h3 id="myModalLabel1">请填写信息</h3>

                                   </div>

                                   <div class="modal-body">

                                       <form action="#" class="form-horizontal">

                                           <div class="control-group"></div>

                                           <div class="control-group"></div>

                                           <div id="error-alert"></div>

                                           <div class="control-group">

                                               <label class="control-label">请输入账号<span class="required">*</span></label>

                                               <div class="controls">

                                                   <input type="text" id="authId" name="authId" class="m-wrap medium">

                                                   <span id="authId_Msg" class="help-line"></span>

                                               </div>

                                           </div>

                                           <div class="control-group">

                                               <label class="control-label">请输入账号密码<span class="required">*</span></label>

                                               <div class="controls">

                                                   <input type="text" id="authPass" name="authPass" class="m-wrap medium">

                                                   <span id="authPass_Msg" class="help-line"></span>

                                               </div>

                                           </div>

                                       </form>

                                   </div>

                                   <div class="modal-footer">

                                       <button class="btn" data-dismiss="modal" aria-hidden="true">取消</button>

                                       <button class="btn black btn-primary" id="add-btn-black-btn-primary" type="button">提交</button>

                                   </div>

                               </div>

                           </div>-->

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
                                            <th>剩余信用额度（单位：元）</th>
                                            <th>可用信用额度（单位：元）</th>
                                        </#if>
                                        <th>Ip范围</th>
                                        <th>操作</th>
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
                                                    <td data-title="剩余信用额度">${-customer.surplusFloor/100.0}</td>
                                                    <td data-title="可用信用额度">${customer.usableFloor/100.0}</td>
                                                </#if>
                                                <td data-title="Ip段">
                                                    <#if customer.customerIpList?? && (customer.customerIpList?size>0)>
                                                        <a href="#form_modal_customer_ip_list"  onclick="showIp(${customer.id})" data-toggle="modal">点击查看Ip段</a>
                                                    <#else >
                                                        <span class="warning">暂无Ip</span>
                                                    </#if>
                                                </td>
                                                <td data-title="操作">
                                                    <a href="/customer/account-consume?customerId=${customer.id}&authId=${customer.authId}">消费记录</a>
                                                <#-- <a href="/customer/account-charge?customerId=${customer.id}&authId=${customer.authId}&reasonId=1">充值记录</a>-->
                                                <#-- <a href="#">修改账号密码</a>-->
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

    <script type="text/javascript" src="/manage/js/jquery.dataTables.js"></script>

    <script type="text/javascript" src="/manage/js/DT_bootstrap.js"></script>

    <script type="text/javascript" src="/assets/js/local/account-message.js"></script>

    <script type="text/javascript" src="/assets/js/local/account-left-bar.js"></script>

    <script>
        jQuery(document).ready(function() {
            AccountMessage.init();
            AccountLeftBar.init();

            $(function () { $("[data-toggle='tooltip']").tooltip(); });

        });

        /*展示密码*/
        function showPassword(id) {

            $("#table_password_"+id).empty();

            if($("#table_content_password_"+id).css('display')=='none'){

                $("#table_content_password_"+id).show();
            }else{
                $("#table_content_password_"+id).hide();
            }

        }

        /*显示Ip*/
        function showIp(customerId) {
            $("#simple_customer_ip_1 tbody").empty();
            $.ajax({
                type: "post",
                url: "/customer/find-ip",
                data: {"customerId": customerId},
                dataType: "json",
                success: function (data) {
                    if (data != null){
                        for (var i = 0; i < data.length; i++) {
                            var myContent = "<tr>" +
                                    "<td>" + data[i].beginIpRaw + "</td>" +
                                    "<td>" + data[i].endIpRaw + "</td>" +
                                    "</tr>"
                            $("#simple_customer_ip_1 tbody").append(myContent);
                        }
                    }
                }
            })
        }


    </script>

    </#if>

</@layout>
