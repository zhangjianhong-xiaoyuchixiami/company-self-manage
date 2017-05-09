
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

                    <form action="/customer/account-consume/detail" class="account_consume_detail" method="get">

                        <div class="clearfix margin-bottom-20 head-search-clearfix-top">

                            <div class="pull-left head-search-bottom head-search-display">

                                <label class="control-label">apiTypeId</label>

                                <div class="controls">

                                    <input type="text" value="${apiTypeId}" id="apiTypeId" name="apiTypeId" >

                                </div>

                            </div>

                            <div class="pull-left head-search-bottom head-search-display">

                                <label class="control-label">stid</label>

                                <div class="controls">

                                    <input type="text" <#if stid??>value="${stid}"</#if> id="stid" name="stid" >

                                </div>

                            </div>

                            <div class="pull-left head-search-bottom head-search-display">

                                <label class="control-label">apiTypeName</label>

                                <div class="controls">

                                    <input type="text" value="${apiTypeName}" id="apiTypeName" name="apiTypeName" >

                                </div>

                            </div>

                            <div class="pull-left head-search-bottom head-search-display">

                                <label class="control-label">mobileOperatorName</label>

                                <div class="controls">

                                    <input type="text" <#if mobileOperatorName??>value="${mobileOperatorName}"</#if> id="mobileOperatorName" name="mobileOperatorName" >

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

                <#--表单-->
                    <div class="portlet box grey">

                        <div class="portlet-title">

                            <div class="caption"><i class="icon-user"></i><#if apiTypeName??>${apiTypeName}</#if></div>

                        </div>

                        <div class="portlet-body no-more-tables">

                            <div class="table-responsive">
                                <table class="table table-striped table-hover table-bordered table-condensed" id="sample">
                                    <thead>
                                    <tr>
                                        <th>周期</th>
                                        <th>扣费次数</th>
                                        <th>消费金额（单位：元）</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                        <#if companyApiTypeConsumeDayCountList??>
                                            <#list companyApiTypeConsumeDayCountList as companyApiTypeConsumeDayCount >
                                                <tr>
                                                    <td>${companyApiTypeConsumeDayCount.year}年${companyApiTypeConsumeDayCount.month}月${companyApiTypeConsumeDayCount.day}号</td>
                                                    <td>${companyApiTypeConsumeDayCount.countSuccess}</td>
                                                    <td>${-companyApiTypeConsumeDayCount.sumAmount/100.0}</td>
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

    <script type="text/javascript" src="/assets/js/local/account-day-consume.js"></script>

    <script type="text/javascript" src="/assets/js/local/finance-left-bar.js"></script>

    <script type="text/javascript">
        jQuery(document).ready(function() {
            FinanceDayConsume.init();
            FinanceLeftBar.init();

        });
    </script>

    </#if>

</@layout>
