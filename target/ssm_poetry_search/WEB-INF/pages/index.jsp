<%--
  Created by IntelliJ IDEA.
  User: ben
  Date: 2017/4/16
  Time: 下午7:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>诗歌查询网站</title>
    <link href="<%=request.getContextPath()%>/css/bootstrap.min.css" rel="stylesheet">
    <script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery.min.js"></script>
    <script type="text/javascript">
        function change(obj) {
            $(".active").removeClass("active")
            $(obj).parent().addClass("active");
            switch ($(obj).html()){
                case '作者':$("#myFormId").attr("action","byPoetName.html");
                    break;
                case '诗名':$("#myFormId").attr("action","byTitle.html");
                    break;
                case '名句':$("#myFormId").attr("action","byContent.html");
                    break;
            }
        }
    </script>
</head>
<body>
<div class="container-fluid">
    <div class="row">
        <div class="col-lg-12 col-md-12 text-center" style="background-color: #eea236">
            <h1><span style="color: orangered">全</span><span style="color: white">唐</span><span
                    style="color: dodgerblue">诗</span>
                <small>查询网</small>
            </h1>
        </div>
    </div>
    <br>
    <br>
    <div class="row">
        <div class="col-md-4 col-lg-4 col-md-offset-4 col-lg-offset-4 text-left">
            <ul class="nav nav-pills">
                <li role="presentation" class="active"><a href="#" onclick="change(this)">作者</a></li>
                <li role="presentation"><a href="#" onclick="change(this)">诗名</a></li>
                <li role="presentation"><a href="#" onclick="change(this)">名句</a></li>
            </ul>
        </div>
    </div>
    <br>
    <div class="row">
        <div class="col-md-4 col-lg-4 col-md-offset-4 col-lg-offset-4">
            <form class="form-horizontal" id="myFormId" action="byPoetName.html" method="post">
                <div class="input-group input-group-lg">
                    <input type="text" class="form-control" name="search" placeholder="Search for...">
                    <input type="hidden" name="currentPage" value="1">
                    <span class="input-group-btn">
                        <input type="submit" class="btn btn-primary" value="搜索">
                    </span>
                </div>
                <div>
                    <a href="byPoetName.html?search=李白">李白</a>&nbsp;&nbsp;<a href="byTitle.html?search=将进酒">将进酒</a>
                    &nbsp;&nbsp;<a href="byPoetName.html?search=杜甫">杜甫</a>
                </div>
            </form>
        </div>
    </div>
</div>

</body>
</html>
