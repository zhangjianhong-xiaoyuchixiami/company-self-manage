
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

                    <div class="clearfix margin-bottom-20 head-search-clearfix-top">

                        <form action="/finance/account-consume" class="account-consume" method="get">
                            <#--产品类型-->
                            <div class="pull-left head-search-bottom">
                                <label class="control-label">产品类型</label>
                                <div class="controls">
                                    <select id="apiTypeId_subTypeId" name="apiTypeId_subTypeId" class="medium m-wrap1" tabindex="1">
                                        <option value="">请选择...</option>
                                        <#if companyApiList??>
                                            <#list companyApiList as companyApi>
                                                <option <#if apiTypeId_subTypeId?? && apiTypeId_subTypeId == companyApi.apiTypeId-companyApi.subTypeId>selected="selected"</#if> value="${companyApi.apiTypeId}-${companyApi.subTypeId}">${companyApi.apiType.name}<#if companyApi.mobileOperator??>--${companyApi.mobileOperator.name}</#if></option>
                                            </#list>
                                        </#if>
                                    </select>
                                </div>
                            </div>
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
                        <#--确定按钮-->
                            <div class="pull-left head-search-bottom">

                                <label class="control-label">&nbsp;&nbsp;</label>

                                <div class="controls" >

                                    <div class="input-append">

                                        <button class="btn black" type="submit">搜索</button>

                                    </div>

                                </div>

                            </div>
                        </form>

                    </div>

                    <div class="portlet box grey">

                        <div class="portlet-title">
                            <div class="caption"><i class="icon-user"></i><#if companyName??>${companyName}</#if></div>

                            <div class="actions">
                                <div class="btn-group">
                                    <a class="btn white" href="#" data-toggle="dropdown">工具<i class="icon-angle-down"></i></a>
                                    <ul class="dropdown-menu pull-right">
                                        <#if download??>
                                        <#list download as download>
                                            <li>
                                                <a href="/finance/download-consume-check?consuTime=${download.consuTime}" ><i class="icon-share icon-black"></i>下载${download.year?c}年${download.month}月份账单</a>
                                            </li>
                                        </#list>
                                        </#if>

                                    </ul>
                                </div>

                            </div>
                        </div>

                        <div class="portlet-body no-more-tables">

                            <div class="table-responsive">

                                <table class="table table-striped table-hover table-bordered" id="sample_4">
                                    <thead>
                                    <tr>
                                        <th>产品类型</th>
                                        <th>扣费次数</th>
                                        <th>消费金额（单位/元）</th>
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
                                                <td data-title="扣费次数">
                                                ${(customerApiConsume.feeAmount)?c}
                                                </td>
                                                <td data-title="消费金额（单位/元）">
                                                ${(-customerApiConsume.totleAmount/100.0)?c}
                                                </td>
                                                <td data-title="操作">
                                                    <a href="/finance/account-consume/day-detail?apiTypeId=${customerApiConsume.apiTypeId}&apiTypeName=${customerApiConsume.apiTypeName}<#if customerApiConsume.mobileOperatorName??>&stid=${customerApiConsume.mobileOperatorId}</#if><#if customerApiConsume.mobileOperatorName??>&stidName=${customerApiConsume.mobileOperatorName}</#if>">天消费明细</a>
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

    <script type="text/javascript" src="/assets/js/local/account-consume.js"></script>

    <script type="text/javascript" src="/assets/js/local/finance-left-bar.js"></script>

    <script type="text/javascript">
        jQuery(document).ready(function() {
            AccountConsume.init();
            FinanceLeftBar.init();
        });
    </script>

    </#if>

</@layout>
