var AccountMessage = function () {

    return {
        //main function to initiate the module
        init: function () {

            if (!jQuery().dataTable) {
                return;
            }
            var oTable = $('#sample_2').dataTable({
                "aoColumns": [
                    { "bSortable": false },
                    { "bSortable": false },
                    { "bSortable": false },
                    { "bSortable": false },
                    { "bSortable": false }
                ],
                "aaSorting": [[4, 'desc']],
                "sDom": "t<'row-fluid'<'span6'il><'span6'p>>",
                "sPaginationType": "bootstrap",
                "oLanguage" : {  //设置语言
                    "sLengthMenu" : "每页显示 _MENU_ 条记录",
                    "sZeroRecords" : "对不起，没有匹配的数据",
                    "sInfo" : "第 _START_ - _END_ 条 / 共 _TOTAL_ 条数据",
                    "sInfoEmpty" : "没有匹配的数据",
                    "sInfoFiltered" : "(数据表中共 _MAX_ 条记录)",
                    "sProcessing" : "正在加载中...",
                    "sSearch" : "全文搜索：",
                    "oPaginate" : {
                        "sFirst" : "第一页",
                        "sPrevious" : " 上一页 ",
                        "sNext" : " 下一页 ",
                        "sLast" : " 最后一页 "
                    }
                },
                "bInfo" : false,
                "bPaginate" : false,
                "bFilter" : false //设置全文搜索框，默认true
            });

            $("#authId").focus(function () {
                $("#authId_Msg").html("");
            });

            $("#authPass").focus(function () {
                $("#authPass_Msg").html("");
            });

            $("#authId").blur(function(){
                $("#authId_Msg").load("/customer/find-customer-by-authId?authId="+$("#authId").val(),
                    function(responseTxt){
                        if(responseTxt=="yes")
                            $("#authId_Msg").html("");
                        if(responseTxt=="no")
                            $("#authId_Msg").html("<font color='red'>该账号不存在，请重新输入！</font>");
                    });
            });

            $("#authPass").blur(function(){
                $("#authPass_Msg").load("/customer/validate-password-customer-by-authId?authId="+$("#authId").val()+"&authPass="+$("#authPass").val(),
                    function(responseTxt){
                        if(responseTxt=="yes")
                            $("#authPass_Msg").html("");
                        if(responseTxt=="no")
                            $("#authPass_Msg").html("<font color='red'>密码不正确，请重新输入！</font>");
                    });
            });

            $("#add-btn-black-btn-primary").on("click",function () {
                var authId=$("#authId").val();
                var authPass=$("#authPass").val();
                $.ajax({
                    type: "post",
                    url: "/customer/bound-user-customer",
                    data: {"authId":authId,"authPass":authPass},
                    dataType: "json",
                    success: function (result) {
                        if(result.authIdMessage != null) {
                            $("#authId_Msg").empty();
                            $("#authId_Msg").html("<font color='red'>"+result.authIdMessage+"</font>");
                            return;
                        }
                        if(result.authPassMessage != null) {
                            $("#authPass_Msg").empty();
                            $("#authPass_Msg").html("<font color='red'>"+result.authPassMessage+"</font>");
                            return;
                        }
                        if(result.errorMessage != null) {
                            $("#error-alert").empty();
                            $("#error-alert").append('<div class="alert alert-error show"><button class="close" data-dismiss="alert"></button><span>'+result.errorMessage+'</span></div>');
                            return;
                        }
                        if (result.successMessage != null){
                            window.location.href=window.location.href
                        }
                    }
                });
            });


        }

    };

}();