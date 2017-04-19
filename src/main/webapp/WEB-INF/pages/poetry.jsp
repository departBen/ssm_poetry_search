<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.bs.poetry.entity.Poetry" %><%--
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
    <title>${poetry.title}</title>
    <link href="<%=request.getContextPath()%>/css/bootstrap.min.css" rel="stylesheet">
</head>
<jsp:useBean id="contentFormat" class="com.bs.poetry.common.UtilsForString">
</jsp:useBean>
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
    <%
        Poetry poetry = (Poetry) request.getAttribute("poetry");
        String contents[] = contentFormat.formatStringForPoetry(poetry.getContent());
        request.setAttribute("contents", contents);
    %>
    <br>
    <div class="row">
        <div class="col-md-offset-1 col-lg-offset-1">
            <a href="index.html">首页</a>
        </div>
    </div>
    <br>
    <div class="row">
        <div class="col-md-4 col-lg-4 col-md-offset-4 col-lg-offset-4 text-center">
                <h2 class="text-info bg-danger">${poetry.title}</h2>
                <br>
                <h2><small class="bg-warning">${poetry.poet.name}</small></h2>
                <br>
                <c:forEach var="list" items="${contents}" varStatus="obj">

                        <p class="bg-success">
                                ${list}
                        </p>

                </c:forEach>
        </div>
    </div>
</div>

</body>
</html>
