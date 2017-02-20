
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
                    <div class="table-responsive">
                        <table class="table table-bordered table-hover table-striped">
                            <thead>
                            <tr>
                                <th>账号</th>
                                <th>账号类型</th>
                                <th>密码</th>
                                <th>余额</th>
                                <th>创建时间</th>
                                <th>操作</th>
                            </tr>
                            </thead>
                            <tbody>
                            <tr>
                                <td>/index.html</td>
                                <td>1265</td>
                                <td>32.3%</td>
                                <td>$321.33</td>
                                <td>32.3%</td>
                                <td><a href="#">消费账单</a><a href="#">充值账单</a></td>
                            </tr>
                            <tr>
                                <td>/about.html</td>
                                <td>261</td>
                                <td>33.3%</td>
                                <td>$234.12</td>
                                <td>32.3%</td>
                                <td>$321.33</td>
                            </tr>

                            </tbody>
                        </table>
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

    <script>
        $(function() {
            $("#accountMessage").click();
        });
    </script>

    </#if>

</@layout>
