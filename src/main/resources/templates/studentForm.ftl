<#include "header.ftl">
<#setting number_format="0.0###">
<#--<div class="jumbotron">-->
    <div class="container">
        <div class="row">

            <p>
                <h1>输入学生信息</h1>
            </p>
            <form class="form-horizontal" role="form" name="student" action="saveStudent" method="post">
                <div class="form-group">
                    <label for="name" class="col-sm-2 control-label">姓名</label>
                    <div class="col-sm-6">
                        <input type="text" class="form-control" id="name" name="name" value="${(student.name)!}" placeholder="请输入姓名">
                    </div>
                </div>
                <div class="form-group">
                    <label for="address" class="col-sm-2 control-label">地址</label>
                    <div class="col-sm-6">
                        <input type="text" class="form-control" id="address" name="address" placeholder="请输入地址">
                    </div>
                </div>
                <div class="form-group">
                    <label for="dtp_input2" class="col-sm-2 control-label">生日</label>
                    <div class="col-sm-6">
                        <div class="input-group date form_date" data-date="" data-date-format="yyyy-mm-dd" data-link-field="dtp_input2" data-link-format="yyyy-mm-dd">
                            <input class="form-control" type="text" value="" readonly>
                            <span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>
                            <span class="input-group-addon"><span class="glyphicon glyphicon-calendar"></span></span>
                        </div>
                        <input type="hidden" id="dtp_input2" name="birthday" value="" /><br/>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-offset-2 col-sm-10">
                        <button type="submit" class="btn btn-info">提交</button>
                    </div>
                </div>
            </form>

        </div>

    </div>
    <script>
        $(function () {

        });
    </script>
<#--</div>-->
<#include "footer.ftl">

