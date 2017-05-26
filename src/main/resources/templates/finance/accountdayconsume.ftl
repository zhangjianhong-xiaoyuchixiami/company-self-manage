
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

                                <label class="control-label">apiTypeName</label>

                                <div class="controls">

                                    <input type="text" <#if apiTypeName??>value="${apiTypeName}"</#if> id="apiTypeName" name="apiTypeName" >

                                </div>

                            </div>

                            <div class="pull-left head-search-bottom head-search-display">

                                <label class="control-label">stidName</label>

                                <div class="controls">

                                    <input type="text" <#if stidName??>value="${stidName}"</#if> id="stidName" name="stidName" >

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

                            <div class="caption"><#if apiTypeName??>${apiTypeName}</#if><#if stidName??>--${stidName}</#if></div>

                        </div>

                        <div class="portlet-body no-more-tables">

                            <div class="table-responsive">
                                <table class="table table-striped table-hover table-bordered table-condensed" id="sample">
                                    <thead>
                                    <tr>
                                        <th>消费日期</th>
                                        <th>请求次数</th>
                                        <th>扣费次数</th>
                                        <th>消费金额（单位：元）</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                        <#if companyApiTypeConsumeDayCountList??>
                                            <#list companyApiTypeConsumeDayCountList as companyApiTypeConsumeDayCount >
                                                <tr>
                                                    <td>${companyApiTypeConsumeDayCount.consuTime?date}</td>
                                                    <td>${companyApiTypeConsumeDayCount.countTotle}</td>
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
