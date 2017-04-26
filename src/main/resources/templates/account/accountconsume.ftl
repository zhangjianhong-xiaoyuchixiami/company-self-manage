
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

                    <form action="/customer/account-consume" method="get">

                        <div class="clearfix margin-bottom-20 head-search-clearfix-top">

                            <div class="pull-left head-search-bottom head-search-display">

                                <label class="control-label">customerId</label>

                                <div class="controls">

                                    <input type="text" value="${customerId}" id="customerId" name="customerId" >

                                </div>

                            </div>

                            <div class="pull-left head-search-bottom head-search-display">

                                <label class="control-label">authId</label>

                                <div class="controls">

                                    <input type="text" value="${authId}" id="authId" name="authId" >

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
                                                <td data-title="产品类型">
                                                    ${customerApiConsume.apiTypeName}
                                                    <#if customerApiConsume.mobileOperatorName??>
                                                        --${customerApiConsume.mobileOperatorName}
                                                    </#if>
                                                </td>
                                                <td data-title="金额（单位/元）">
                                                    ${(-customerApiConsume.totleAmount/100.0)?c}
                                                </td>
                                                <td data-title="操作">
                                                    <a href="/customer/account-consume/detail?apiTypeId=${customerApiConsume.apiTypeId}<#if customerApiConsume.mobileOperatorId??>&stid=${customerApiConsume.mobileOperatorId}</#if>&customerId=${customerId}&apiTypeName=${customerApiConsume.apiTypeName}<#if customerApiConsume.mobileOperatorName??>&mobileOperatorName=${customerApiConsume.mobileOperatorName}</#if>&reasonId=-1">明细</a>
                                                </td>
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
