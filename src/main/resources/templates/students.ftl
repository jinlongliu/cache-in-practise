<#include "header.ftl">
<#setting number_format="0.0###">
<#--<div class="jumbotron">-->
    <div class="container">
        <div class="row">



            <p><h1>学生清单</h1></p>

            <a href="addStudent" class="btn btn-info">新增</a>

            <button class="btn btn-success">刷新</button>

            <button class="btn btn-info">清除</button>

            <input type="text" class="form-control">

        </div>

        <div class="row">
            <table class="table table-hover">
                <caption>人员</caption>
                <thead>
                <tr>
                    <th>序号</th>
                    <th>姓名</th>
                    <th>地址</th>
                    <th>生日</th>
                    <th>操作</th>
                </tr>
                </thead>
                <tbody>
                <#list students as student>
                <tr>
                    <td>${student.id?c}</td>
                    <td>${student.name!""}</td>
                    <td>${student.address!""}</td>
                    <td><#if student.birthday??>${student.birthday?string("yyyy-MM-dd")}</#if></td>
                    <td>
                        <#--<button class="btn btn-danger" value="${student.id?c}">删除1</button>-->
                        <button onclick="deleteStudent(${student.id?c})" class="btn btn-danger">删除</button>
                    </td>
                </tr>
                </#list>
                </tbody>
            </table>
        </div>

    </div>
    <script>

        function deleteStudent(id) {
            $.post("/deleteStudent/" + id,
                    {
                    }
                    , function (data, status) {
                        if (data == "SUCCESS") {
                            console.log("SUCCESS");
                            flushData();
                        } else {
                            console.log("FAILURE");
                        }});
        }

        function flushData() {
            $.post("/getData",
                    {
                    },
                    function (data, status) {
                        console.log(data.length)
                        var tableBody = "";
                        for(var i=0; i< data.length; i++) {
                            console.log(data[i].name);
                            console.log(data[i].address);
                            if( data[i].birthday == "null") {
                                data[i].birthday = "";
                            }
                            tableBody += "<tr>";
                            tableBody += "<td>" + data[i].id + "</td>";
                            tableBody += "<td>" + data[i].name + "</td>";
                            tableBody += "<td>" + data[i].address + "</td>";
                            if( data[i].birthday == null) {
                                tableBody += "<td>" + "" + "</td>";
                            } else {
                                console.log(typeof(data[i].birthday));
                                console.log(data[i].birthday);
                                var m = moment(data[i].birthday);
                                var dateStr = m.format("YYYY-MM-DD");
                                console.log(dateStr);
                                tableBody += "<td>" + dateStr + "</td>";
                            }
                            tableBody += "<td><button onclick='deleteStudent("+ data[i].id +")' class='btn btn-danger' >删除</button></td>";
                            tableBody += "</tr>";
                        }
                        $("tbody").html(tableBody);
                        console.log(data);
                        console.log(status);
                    });
        }

        $(function () {

            $(".btn-success").click(function () {
                flushData();
            });

            $(".btn-info").click(function () {
                $("tbody").html("");
            });


        });
    </script>
<#--</div>-->
<#include "footer.ftl">

