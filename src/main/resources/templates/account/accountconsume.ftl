
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

                    <div class="portlet box grey">

                        <div class="portlet-title">

                            <div class="caption"><i class="icon-user"></i><#if authId??>${authId}</#if></div>

                        </div>

                        <div class="portlet-body no-more-tables">

                            <#--<div class="clearfix margin-bottom-5">

                                <div class="pull-right table-top-bottom">

                                    <label class="control-label">

                                        <a href="/customer/month-record?customerId=${customerId}&authId=${authId}&typeId=2">
                                            月消费账单
                                        </a>

                                    </label>

                                </div>

                            </div>-->

                            <div class="table-responsive">

                                <table class="table table-striped table-hover table-bordered" id="sample_4">
                                    <thead>
                                    <tr>
                                        <th>产品类型</th>
                                        <th>金额（单位/元）</th>
                                        <th>操作</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                        <#if customerApiConsumeList??>
                                            <#list customerApiConsumeList as customerApiConsume>
                                            <tr>
                                                <td data-title="产品类型">${customerApiConsume.apiTypeName}<#if customerApiConsume.mobileOperatorName??>--${customerApiConsume.mobileOperatorName}</#if></td>
                                                <td data-title="金额（单位/元）">${(-customerApiConsume.totleAmount/100.0)?c}</td>
                                                <td data-title="操作"><a href="/customer/account-consume/detail?apiTypeId=${customerApiConsume.apiTypeId}&customerId=${customerId}&apiTypeName=${customerApiConsume.apiTypeName}<#if customerApiConsume.mobileOperatorName??>&mobileOperatorName=${customerApiConsume.mobileOperatorName}</#if>&reasonId=-1">明细</a></td>
                                            </tr>
                                            </#list>
                                        </#if>
                                    </tbody>
                                </table>

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

    <script type="text/javascript" src="/assets/js/local/account-consume.js"></script>

    <script type="text/javascript" src="/assets/js/local/account-left-bar.js"></script>

    <script type="text/javascript">
        jQuery(document).ready(function() {
            AccountConsume.init();
            AccountLeftBar.init();
        });
    </script>

    </#if>

</@layout>
