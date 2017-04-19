<%--
  Created by IntelliJ IDEA.
  User: ben
  Date: 2017/4/16
  Time: 下午8:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>根据诗人查询</title>
    <link href="<%=request.getContextPath()%>/css/bootstrap.min.css" rel="stylesheet">
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
    <div class="row">
        <div class="col-md-3 col-lg-3">
            <c:if test="${type=='poet'}">
                <form class="form-horizontal" action="byPoetName.html" method="post">
                    <div class="input-group input-group-sm">
                        <input type="text" class="form-control" name="search" placeholder="诗人名">
                        <input type="hidden" name="currentPage" value="1">
                        <span class="input-group-btn">
                        <input type="submit" class="btn btn-primary" value="搜索">
                    </span>
                    </div>
                </form>
            </c:if>
            <c:if test="${type == 'title'}">
                <form class="form-horizontal" action="byTitle.html" method="post">
                    <div class="input-group input-group-sm">
                        <input type="text" class="form-control" name="search" placeholder="诗歌名">
                        <input type="hidden" name="currentPage" value="1">
                        <span class="input-group-btn">
                        <input type="submit" class="btn btn-primary" value="搜索">
                    </span>
                    </div>
                </form>
            </c:if>
            <c:if test="${type == 'content'}">
                <form class="form-horizontal" action="byContent.html" method="post">
                    <div class="input-group input-group-sm">
                        <input type="text" class="form-control" name="search" placeholder="名句">
                        <input type="hidden" name="currentPage" value="1">
                        <span class="input-group-btn">
                        <input type="submit" class="btn btn-primary" value="搜索">
                    </span>
                    </div>
                </form>
            </c:if>
        </div>
        <div class="col-md-2 col-lg-2 col-md-offset-7 col-lg-offset-7" >
                <a href="index.html" class="lead">首页</a>
        </div>
    </div>
    <br>
    <div class="row">
        <div class="col-lg-12 col-md-12 text-left" style="background-color: #FFDCB8">
            <c:if test="${type == 'poet'}">
                <h4>作者：${poetName}，共${total}首诗</h4>
            </c:if>
            <c:if test="${type == 'title'}">
                <h4>诗名包含：${title}，共搜索到${total}首诗</h4>
            </c:if>
            <c:if test="${type == 'content'}">
                <h4>根据名句：${content}，共搜索到${total}首诗</h4>
            </c:if>
        </div>
    </div>
    <br>
    <div class="row">
        <div class="col-lg-4 col-md-4 col-md-offset-2 col-lg-offset-2">
            <dl>
                <c:forEach var="list" items="${poetries}">
                    <li><a href="getById.html?id=${list.id}">${list.title}</a></li>
                    <dd>
                        &nbsp;&nbsp;&nbsp;&nbsp;<small class="text-muted"><c:out value="${fn:substring(list.content,0,12)}......"/></small>
                    </dd>
                </c:forEach>
            </dl>
        </div>
    </div>
    <div class="row">
        <div class="col-lg-4 col-md-4 col-md-offset-2 col-lg-offset-2">
            <c:if test="${type == 'poet'}">
                <c:if test="${pager.hasFirst}">
                    <a href="byPoetName.html?search=${poetName}&currentPage=1">首页</a>
                </c:if>
                <c:if test="${pager.hasPrevious}">
                    <a href="byPoetName.html?search=${poetName}&currentPage=${pager.currentPage-1}">上一页</a>
                </c:if>
                <c:if test="${pager.hasNext}">
                    <a href="byPoetName.html?search=${poetName}&currentPage=${pager.currentPage+1}">下一页</a>
                </c:if>
                <c:if test="${pager.hasLast}">
                    <a href="byPoetName.html?search=${poetName}&currentPage=${pager.totalPage}">尾页</a>
                </c:if>
                <br>
                当前第
                ${pager.currentPage}
                页, 总共
                ${pager.totalPage}
                页
            </c:if>
            <c:if test="${type == 'title'}">
                <c:if test="${pager.hasFirst}">
                    <a href="byTitle.html?search=${title}&currentPage=1">首页</a>
                </c:if>
                <c:if test="${pager.hasPrevious}">
                    <a href="byTitle.html?search=${title}&currentPage=${pager.currentPage-1}">上一页</a>
                </c:if>
                <c:if test="${pager.hasNext}">
                    <a href="byTitle.html?search=${title}&currentPage=${pager.currentPage+1}">下一页</a>
                </c:if>
                <c:if test="${pager.hasLast}">
                    <a href="byTitle.html?search=${title}&currentPage=${pager.totalPage}">尾页</a>
                </c:if>
                <br>
                当前第
                ${pager.currentPage}
                页, 总共
                ${pager.totalPage}
                页
            </c:if>
            <c:if test="${type == 'content'}">
                <c:if test="${pager.hasFirst}">
                    <a href="byContent.html?search=${content}&currentPage=1">首页</a>
                </c:if>
                <c:if test="${pager.hasPrevious}">
                    <a href="byContent.html?search=${content}&currentPage=${pager.currentPage-1}">上一页</a>
                </c:if>
                <c:if test="${pager.hasNext}">
                    <a href="byContent.html?search=${content}&currentPage=${pager.currentPage+1}">下一页</a>
                </c:if>
                <c:if test="${pager.hasLast}">
                    <a href="byContent.html?search=${content}&currentPage=${pager.totalPage}">尾页</a>
                </c:if>
                <br>
                当前第
                ${pager.currentPage}
                页, 总共
                ${pager.totalPage}
                页
            </c:if>
        </div>
    </div>
</div>
</body>
</html>
