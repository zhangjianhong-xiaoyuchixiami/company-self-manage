
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

                    <form action="/customer/account-message" method="get">

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

                            <div class="clearfix margin-bottom-5">

                                <div class="btn-group">

                                    <a class="btn black" id="add-partner" href="#form_modal1" data-toggle="modal">

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

                            </div>

                            <div class="table-responsive">
                                <table class="table table-bordered table-hover table-striped" id="sample_2">
                                    <thead>
                                    <tr>
                                        <th>账号</th>
                                        <th>账号类型</th>
                                        <th>密码</th>
                                        <th>余额（单位：元）</th>
                                        <th>创建时间</th>
                                        <th>状态</th>
                                        <th>操作</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                        <#if customerList??>
                                            <#list customerList as customer>
                                            <tr>
                                                <td data-title="账号">${customer.authId}</td>
                                                <td data-title="账号类型">${customer.customerType.name}</td>
                                                <td data-title="密码">${customer.authPass}</td>
                                                <td data-title="余额">${customer.balance}</td>
                                                <td data-title="创建时间">${customer.createTime}</td>
                                                <td data-title="状态">${customer.customerStatus.name}</td>
                                                <td data-title="操作">
                                                    <a href="/customer/account-consume?customerId=${customer.id}&authId=${customer.authId}">消费记录</a>|
                                                    <a href="/customer/account-charge?customerId=${customer.id}&authId=${customer.authId}&reasonId=1">充值记录</a>|
                                                    <a href="#">修改账号密码</a>
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

    <script type="text/javascript" src="/assets/js/local/account-message.js"></script>

    <script type="text/javascript" src="/assets/js/local/account-left-bar.js"></script>

    <script>
        jQuery(document).ready(function() {
            AccountMessage.init();
            AccountLeftBar.init();
        });
    </script>

    </#if>

</@layout>
