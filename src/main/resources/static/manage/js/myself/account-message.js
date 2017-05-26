/**
 * Created by Administrator on 2017/5/26.
 */

$(function () { $("[data-toggle='tooltip']").tooltip(); });

/*展示密码*/
function showPassword(id) {

    $("#table_password_"+id).empty();

    if($("#table_content_password_"+id).css('display')=='none'){

        $("#table_content_password_"+id).show();
    }else{
        $("#table_content_password_"+id).hide();
    }

}

/*显示Ip*/
function showIp(customerId) {
    $("#simple_customer_ip_1 tbody").empty();
    $.ajax({
        type: "post",
        url: "/customer/find-ip",
        data: {"customerId": customerId},
        dataType: "json",
        success: function (data) {
            if (data != null){
                for (var i = 0; i < data.length; i++) {
                    var myContent = "<tr>" +
                        "<td>" + data[i].beginIpRaw + "</td>" +
                        "<td>" + data[i].endIpRaw + "</td>" +
                        "</tr>"
                    $("#simple_customer_ip_1 tbody").append(myContent);
                }
            }
        }
    })
}