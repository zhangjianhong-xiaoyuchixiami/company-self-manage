
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

                                <label class="control-label">customerId</label>

                                <div class="controls">

                                    <input type="text" value="${customerId}" id="customerId" name="customerId" >

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

                            <div class="pull-left head-search-bottom">

                                <label class="control-label">消费理由</label>

                                <div class="controls">

                                    <label class="checkbox">

                                        <input type="checkbox" <#if reasonIdArray??><#list reasonIdArray as reasonId><#if reasonId=="-1">checked="checked"</#if></#list></#if> id="reasonId" name="reasonId" value="-1">消费扣费

                                    </label>

                                    <label class="checkbox">

                                        <input type="checkbox" <#if reasonIdArray??><#list reasonIdArray as reasonId><#if reasonId=="-2">checked="checked"</#if></#list></#if> id="reasonId" name="reasonId" value="-2">弥补扣费

                                    </label>

                                    <label class="checkbox">

                                        <input type="checkbox" <#if reasonIdArray??><#list reasonIdArray as reasonId><#if reasonId=="-3">checked="checked"</#if></#list></#if> id="reasonId" name="reasonId" value="-3">测试销减

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
                                        <th>消费金额（单位/元）</th>
                                        <th>创建时间</th>
                                        <th>类型</th>
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

    </div>

    <#elseif section = "footer">

    <#elseif section = "publicJs">

    <#elseif section = "privateJs">

    <script type="text/javascript" src="/manage/js/jquery.dataTables.js"></script>

    <script type="text/javascript" src="/manage/js/DT_bootstrap.js"></script>

    <script type="text/javascript" src="/assets/js/local/account-consume-detail.js"></script>

    <script type="text/javascript" src="/assets/js/local/account-left-bar.js"></script>

    <script type="text/javascript">
        jQuery(document).ready(function() {
            //AccountConsumeDetail.init();
            AccountLeftBar.init();

            //初始化表格
            var table = $("#sample").dataTable({

                "aLengthMenu": [
                    [5, 15, 20, -1],
                    [5, 15, 20, "全部"] // change per page values here
                ],
                "sDom": "<'span12 text-center'r>t<'row-fluid'<'span6'il><'span6'p>>",

                "iDisplayLength": 15, //每页显示多少行

                "sPaginationType": "bootstrap",

                "oLanguage" : {  //设置语言
                    "sLengthMenu" : "每页显示 _MENU_ 条记录",
                    "sZeroRecords" : "对不起，没有匹配的数据",
                    "sInfo" : "第 _START_ - _END_ 条 / 共 _TOTAL_ 条数据",
                    "sInfoEmpty" : "没有匹配的数据",
                    "sInfoFiltered" : "(数据表中共 _MAX_ 条记录)",
                    "sProcessing" : "正在加载中...",
                    "oPaginate" : {
                        "sFirst" : "第一页",
                        "sPrevious" : " 上一页 ",
                        "sNext" : " 下一页 ",
                        "sLast" : " 最后一页 "
                    }
                },
                "bFilter" : false, //设置全文搜索框，默认true
                "bProcessing": true ,// 是否显示取数据时的那个等待提示
                "bServerSide": true,//这个用来指明是通过服务端来取数据
                "sAjaxDataProp" : "aaData",
                "sAjaxSource": "/customer/account-consume/detail-ajax",//这个是请求的地址
                "fnServerData": retrieveData ,// 获取数据的处理函数
                "aaSorting": [[1, 'desc']],
                "aoColumns": [
                    {
                        "name": "消费金额"
                    },
                    {
                        "name": "创建时间"
                    },
                    {
                        "name": "类型",
                        "bSortable": false
                    }
                ],
                "aoColumnDefs":[
                    {"aTargets":[0],
                        "mData": function (source) {
                            var resObj = {
                                'amount' : source.amount
                            };
                            return resObj;
                        },
                        "mRender":function(resObj,type,full){
                            if (full.amount != null){
                                return -(full.amount/100.0);
                            }
                            return "";
                        }
                    },
                    {"aTargets":[1],
                        "mData": function (source) {
                            var resObj = {
                                'createTime' : source.createTime.time
                            };
                            return resObj;
                        },
                        "mRender":function(resObj,type,full){
                            return new Date(full.createTime.time).toLocaleString();
                        }
                    },
                    {"aTargets":[2],
                        "mData": function (source) {
                            var resObj = {
                                'customerBalanceModifyReason' : source.customerBalanceModifyReason
                            };
                            return resObj;
                        },
                        "mRender":function(resObj,type,full){
                            if (full.customerBalanceModifyReason != null){
                                return full.customerBalanceModifyReason.name;
                            }
                            return "";
                        }
                    }
                ]
            });

            function retrieveData( sSource,aaData, fnCallback) {

                var apiTypeId = $('#apiTypeId').val();
                var stid = $('#stid').val();
                var customerId = $('#customerId').val();
                var beginDate = $('#beginDate').val();
                var endDate = $('#endDate').val();
                var reasonId =[];//定义一个数组
                $('input[name="reasonId"]:checked').each(function(){
                    reasonId.push($.trim($(this).val()));
                });
                console.log("apiTypeId="+apiTypeId);
                console.log("stid="+stid);
                console.log("customerId="+customerId);
                console.log("beginDate="+beginDate);
                console.log("endDate="+endDate);
                console.log("reasonId="+reasonId);
                $.ajax({
                    url : sSource,//这个就是请求地址对应sAjaxSource
                    data : {
                        "aaData":JSON.stringify(aaData),
                        "apiTypeId":apiTypeId,
                        "stid":stid,
                        "customerId":customerId,
                        "beginDate":beginDate,
                        "endDate":endDate,
                        "reasonId":reasonId
                    },//这个是把datatable的一些基本数据传给后台,比如起始位置,每页显示的行数
                    type : 'post',
                    dataType : 'json',
                    async : false,
                    success : function(data) {
                        fnCallback(data);//把返回的数据传给这个方法就可以了,datatable会自动绑定数据的
                    }
                });
            }

        });
    </script>


    </#if>

</@layout>
