
<#include "../errorpages/layout.ftl">

<@layout ; section>

    <#if section = "head">

    <#elseif section = "content" >

    <div id="page-wrapper">

        <div class="container-fluid back-min-height">

            <!-- Page Heading -->
            <div class="row">
                <div class="col-lg-12">
                    <ol class="breadcrumb bar-back-color">
                        <li>
                            <i class="fa fa-dashboard"></i>  <a href="view/index.ftl">账号管理</a>
                        </li>
                        <li class="active">
                            <i class="fa fa-table"></i> 表格
                        </li>
                    </ol>
                </div>
            </div>
            <!-- /.row -->
            <div class="row">
                <div class="col-lg-12">
                    <div class="portlet box grey">

                        <div class="portlet-title">

                            <div class="caption"><i class="fa fa-user"></i>账号Id</div>

                        </div>
                        <div class="table-responsive">

                            <table class="table table-bordered table-hover table-striped" id="sample_1">
                                <thead>
                                <tr>
                                    <th>金额</th>
                                    <th>时间</th>
                                    <th>理由</th>
                                </tr>
                                </thead>
                                <tbody>
                                <tr>
                                    <td>/index.html</td>
                                    <td>1265</td>
                                    <td>32.3%</td>
                                </tr>
                                </tbody>
                            </table>

                        </div>

                    </div>

                </div>
            </div>


            <!-- /.row -->
        </div>
        <!-- /.container-fluid -->

    </div>

    <#elseif section = "footer">

    <#elseif section = "publicJs">

    <#elseif section = "privateJs">

    <script type="text/javascript" src="/media/js/jquery.dataTables.js"></script>

    <script type="text/javascript" src="/assets/js/local/account-charge.js"></script>

    <script type="text/javascript" src="/media/js/DT_bootstrap.js"></script>

    <script>

        jQuery(document).ready(function() {
            AccountCharge.init();
        });

        $(function() {
            $("#accountMessage").click();
        });
    </script>

    </#if>

</@layout>
