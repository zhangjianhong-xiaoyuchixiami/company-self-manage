
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

                    <form action="/company/find-all-company-customer-by-dept-id" method="get">

                        <div class="clearfix margin-bottom-20" style="margin-top: -18px;">

                            <div class="control-group pull-left" style="margin-bottom: -20px;margin-top: -25px;">

                                <label class="control-label">&nbsp;&nbsp;</label>

                                <div class="controls">

                                    <div class="input-append">

                                        <input class="m-wrap" <#if content??>value="${content}" </#if> type="text" id="companyName" name="content" placeholder="请输入公司名称">

                                        <button class="btn black" type="submit">搜索</button>

                                    </div>

                                </div>

                            </div>

                        </div>

                    </form>

                <#--表单-->

                    <div class="portlet box grey">

                        <div class="portlet-title">

                            <div class="caption"><i class="icon-user"></i></div>

                        </div>

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
                                <table class="table table-bordered table-hover table-striped" id="sample_3">
                                    <thead>
                                    <tr>
                                        <th>产品</th>
                                        <th>价格</th>
                                        <th>购买时间</th>
                                        <th>操作</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                        <#if companyApiList??>
                                            <#list companyApiList as companyApi>
                                            <tr>
                                                <td data-title="产品">${companyApi.apiType.name}<#if companyApi.mobileOperator??>--${companyApi.mobileOperator.name}</#if></td>
                                                <td data-title="价格">${companyApi.price}</td>
                                                <td data-title="购买时间">${companyApi.createTime}</td>
                                                <td data-title="操作">${companyApi.createTime}</td>
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

    <script type="text/javascript" src="/assets/js/local/company-product.js"></script>

    <script>

        jQuery(document).ready(function() {
            CompanyProduct.init();
        });

    </script>

    </#if>

</@layout>
