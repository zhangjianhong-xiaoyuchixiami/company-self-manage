
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

                    <form action="/customer/account-charge" class="account_charge" method="get">

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

                            <div class="pull-left head-search-bottom">

                                <label class="control-label">充值理由</label>

                                <div class="controls">

                                    <label class="checkbox">

                                        <input type="checkbox" <#if reasonIdArray??><#list reasonIdArray as reasonId><#if reasonId=="1">checked="checked"</#if></#list></#if> id="reasonId" name="reasonId" value="1">正常充值

                                    </label>

                                    <label class="checkbox">

                                        <input type="checkbox" <#if reasonIdArray??><#list reasonIdArray as reasonId><#if reasonId=="2">checked="checked"</#if></#list></#if> id="reasonId" name="reasonId" value="2">弥补充值

                                    </label>

                                    <label class="checkbox">

                                        <input type="checkbox" <#if reasonIdArray??><#list reasonIdArray as reasonId><#if reasonId=="3">checked="checked"</#if></#list></#if> id="reasonId" name="reasonId" value="3">测试充值

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

                            <div class="clearfix margin-bottom-5">

                                <div class="pull-right table-top-bottom">

                                    <label class="control-label">

                                        <a href="/customer/month-record?customerId=${customerId}&authId=${authId}&typeId=1">
                                            月充值账单
                                        </a>

                                    </label>

                                </div>

                            </div>

                            <div class="table-responsive">

                                <table class="table table-striped table-hover table-bordered" id="sample_1">
                                    <thead>
                                    <tr>
                                        <th style="width: 30%">金额（单位：元）</th>
                                        <th style="width: 40%">时间</th>
                                        <th style="width: 30%">理由</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                        <#if customerBalanceLogList??>
                                            <#list customerBalanceLogList as customerBalanceLog>
                                            <tr>
                                                <td data-title="金额（单位：元）">${(customerBalanceLog.amount/100.0)?c}</td>
                                                <td data-title="时间">${customerBalanceLog.createTime}</td>
                                                <td data-title="理由">${customerBalanceLog.customerBalanceModifyReason.name}</td>
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

    <script type="text/javascript" src="/assets/js/local/account-charge.js"></script>

    <script type="text/javascript" src="/assets/js/local/account-left-bar.js"></script>

    <script type="text/javascript">

        jQuery(document).ready(function() {
            AccountCharge.init();
            AccountLeftBar.init();

        });
    </script>

    </#if>

</@layout>
