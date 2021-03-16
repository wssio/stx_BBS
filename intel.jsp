<%--
  Created by IntelliJ IDEA.
  User: ZZL
  Date: 2020/5/12
  Time: 14:26
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<html>
<head>
    <!-- META DATA -->
    <meta charset="utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <meta name="description" content="">
    <meta name="author" content="">

    <title>星辰世界</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/addScript/intelOne/css/bootstrap.min.css" type="text/css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/addScript/intelOne/css/style.css"  type="text/css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/addScript/intelOne/font-awesome-4.4.0/css/font-awesome.min.css" type="text/css">

    <script src="${pageContext.request.contextPath}/cssAndJs/js/getPhoto.js"></script>


</head>


<body class="index-page" onload="setSex(${sessionScope.login_user.sex});getPhoto(${sessionScope.login_user.avatar})">

<!-- 标题栏 -->
<nav class="navbar navbar-default navbar-fixed-top">
    <div class="container">
        <div class="navbar-header page-scroll">
            <a class="navbar-brand page-scroll" href="/intel">
                <c:if test="${sessionScope.login_user==null}">
                    亲，
                </c:if>
                <c:if test="${(requestScope.systemDate=='03')||(requestScope.systemDate=='04')||(requestScope.systemDate=='05')}">
                    凌晨，好梦
                </c:if>
                <c:if test="${(requestScope.systemDate=='06')||(requestScope.systemDate=='07')}">
                    早上好
                </c:if>
                <c:if test="${(requestScope.systemDate=='08')||(requestScope.systemDate=='09')||(requestScope.systemDate=='10')}">
                    上午好
                </c:if>
                <c:if test="${(requestScope.systemDate=='11')||(requestScope.systemDate=='12')}">
                    中午好
                </c:if>
                <c:if test="${(requestScope.systemDate=='13')||(requestScope.systemDate=='14')||(requestScope.systemDate=='15')||(requestScope.systemDate=='16')}">
                    下午好
                </c:if>
                <c:if test="${(requestScope.systemDate=='17')||(requestScope.systemDate=='18')}">
                    快下班啦
                </c:if>
                <c:if test="${(requestScope.systemDate=='19')||(requestScope.systemDate=='20')||(requestScope.systemDate=='21')||(requestScope.systemDate=='22')}">
                    晚上好
                </c:if>
                <c:if test="${(requestScope.systemDate=='23')||(requestScope.systemDate=='00')||(requestScope.systemDate=='01')||(requestScope.systemDate=='02')}">
                    夜深了，早点休息吧
                </c:if>
                <c:if test="${(sessionScope.login_user!=null)&&(!(requestScope.systemDate=='23')||(requestScope.systemDate=='00')||(requestScope.systemDate=='01')||(requestScope.systemDate=='02')||(requestScope.systemDate=='03')||(requestScope.systemDate=='04')||(requestScope.systemDate=='05'))}">
                    ,&nbsp;${sessionScope.login_user.nickname}
                </c:if>
                <c:if test="${(sessionScope.login_user==null)||((sessionScope.login_user!=null)&&((requestScope.systemDate=='23')||(requestScope.systemDate=='00')||(requestScope.systemDate=='01')||(requestScope.systemDate=='02')||(requestScope.systemDate=='03')||(requestScope.systemDate=='04')||(requestScope.systemDate=='05')))}">
                    !
                </c:if>

            </a>
        </div>

        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav navbar-right">

                <c:if test="${sessionScope.login_user==null}">
                    <li>
                        <a class="page-scroll" href="/login">登录</a>
                    </li>
                    <li>
                        <a class="page-scroll" href="/register">注册</a>
                    </li>
                </c:if>

                <c:if test="${login_user !=null}">
                    <li>
                        <a class="page-scroll" href="/article/create">发表文章</a>
                    </li>
                    <li>
                        <a class="page-scroll" href="/intel/private?userId=${sessionScope.login_user.id}">我的作品</a>
                    </li>
                    <li>
                        <form class="hiddenForm" action="/change/information" id="loginForm" method="post">
                            <input type="hidden" name="login_user" value="${sessionScope.login_user.username}">
                            <input type="hidden" name="userSex" value="${sessionScope.login_user.sex}">
                        </form>
                        <a class="page-scroll aShou" onclick="document:loginForm.submit()" >个人信息</a>
                    </li>
                    <li>
                        <a class="page-scroll" href="/login?status=quit">退出登录</a>
                    </li>
                    <div class="photoDiv" id="photo"></div>
                </c:if>

            </ul>
        </div>
    </div>
</nav>


<!-- CAROUSEL图片和字 -->
<div id="carousel-example-generic" class="carousel slide hidden-xs" data-ride="carousel" data-interval="4000">
    <div class="carousel-inner">
        <div class="item active">
            <img src="addScript/intelOne/images/banner1.jpg" alt="...">
            <div class="header-text hidden-xs">
                <div class="col-md-12 text-center">
                    <h1>第1个图片上的文字标题</h1>
                    <hr>
                    <p>第1个图片上的文字,第1个图片上的文字,第1个图片上的文字,第1个图片上的文字,第1个图片上的文字,第1个图片上的文字,第1个图片上的文字,第1个图片上的文字,第1个图片上的文字,</p>
                    <a href="" class="btn btn-primary btn-xl page-scroll">第1个假按钮</a>
                </div>
            </div>
        </div>
        <div class="item">
            <img src="addScript/intelOne/images/banner2.jpg" alt="...">
            <div class="header-text hidden-xs">
                <div class="col-md-12 text-center">
                    <h1>第2个图片上的文字标题</h1>
                    <hr>
                    <p>第2个图片上的文字,第2个图片上的文字,第2个图片上的文字,第2个图片上的文字,第2个图片上的文字,第2个图片上的文字,第2个图片上的文字,第2个图片上的文字,</p>
                    <a href="" class="btn btn-primary btn-xl page-scroll">第2个假按钮</a>
                </div>
            </div>
        </div>
    </div>


    <!-- Controls切换图片 -->
    <a class="left carousel-control" href="#carousel-example-generic" role="button" data-slide="prev">
        <span class="glyphicon glyphicon-chevron-left"></span>
    </a>
    <a class="right carousel-control" href="#carousel-example-generic" role="button" data-slide="next">
        <span class="glyphicon glyphicon-chevron-right"></span>
    </a>
</div>


<div id="page-content">
    <section class="box-content box-1">
        <div class="container">

            <c:forEach varStatus="idx" var="article" items="${requestScope.articles}">
                <div class="box-item">
                    <div class="addDiv">
                        <div class="content">

                            <c:if test="${(sessionScope.login_user.id==article.user.id)}">
                                <div class="anDiv">
                                    <ul class="list-inline social-buttons">
                                        <li>
                                            <a class="shanChu" href="/article/delete?id=${article.id}"><i
                                                    class="fa fa-remove"></i></a>
                                        </li>
                                    </ul>
                                </div>
                                <div class="anDiv2">
                                    <ul class="list-inline social-buttons">

                                        <li>
                                            <a class="dianZan" href="/article/modify?id=${article.id}"><i
                                                    class="fa fa-pencil"></i></a>
                                        </li>
                                    </ul>
                                </div>
                            </c:if>
                            <div class="anDiv21">
                                <ul class="list-inline social-buttons">
                                    <span>浏览次数：${article.readTotal}</span>
                                </ul>
                            </div>
                            <div class="anDiv3">
                                <ul class="list-inline social-buttons">
                                    <li>
                                        <a class="dianZan" href="/like/article?id=${article.id}&like_user=${sessionScope.login_user.id}"><i class="fa fa-thumbs-up"></i></a>
                                    </li>
                                    <span>${article.likeTotal}</span>&ensp;&ensp;
                                    <li>
                                        <a class="dianZan" href="/article/show?id=${article.id}&login_user=${sessionScope.login_user.id}"><i class="fa fa-comment"></i></a>
                                    </li>
                                    <span>${article.commentTotal}</span>
                                </ul>
                            </div>

                            <div class="titleDiv">
                                <h3>
                                    <c:if test="${(article.title).length()>11}">
                                        ${article.title.substring(0,10)}...
                                    </c:if>
                                    <c:if test="${(article.title).length()<=11}">
                                        ${article.title}
                                    </c:if>
                                </h3>
                            </div>

                            <div class="summaryDiv">
                                <p class="weRq">
                                    <span class="ZYZW">摘要:&ensp;</span>
                                    <c:if test="${(article.summary).length()>36}">
                                        ${article.summary.substring(0,35)}...
                                    </c:if>
                                    <c:if test="${(article.summary).length()<=36}">
                                        ${article.summary}
                                    </c:if>
                                </p>
                            </div>
                            <div class="contentDiv">
                                <p class="weRq">
                                    <span class="ZYZW">正文:&ensp;</span>
                                    <c:if test="${(article.content).length()>56}">
                                        ${article.content.substring(0,55)}...
                                    </c:if>
                                    <c:if test="${(article.content).length()<=56}">
                                        ${article.content}
                                    </c:if>
                                </p>
                            </div>

                            <div class="readMoreDiv">
                                <a id="readMore" href="/article/show?id=${article.id}&login_user=${sessionScope.login_user.id}">阅读更多...</a>
                                <br><br>
                            </div>
                            <div class="zuoZheDiv">
                                    <%--<span><fmt:formatDate value="${article.addTime}"--%>
                                    <%--pattern="yyyy-MM-dd hh:mm:ss"></fmt:formatDate></span><span--%>
                                    <%--—————————————————————————————————————————————————————————————————————————————————————————————————————————————————--%>
                                <span>${article.addTimeDate}</span>
                                    <%--—————————————————————————————————————————————————————————————————————————————————————————————————————————————————--%>
                                <span class="ZZNameSpan">作者:${article.nickName}</span><br>
                            </div>
                        </div>
                    </div>
                </div>
            </c:forEach>

        </div>
    </section>
</div>


<!-- FOOTER -->
<footer>
    <div class="bottom-footer">
        <div class="container">
            <div class="col-md-4"></div>
            <div class="col-md-4">
                <ul class="list-inline social-buttons">

                    <li>
                        <a href="#" ><i class="fa fa-wechat"></i></a>
                    </li>
                    <li>
                        <a href="#" ><i class="fa fa-envelope"></i></a>
                    </li>

                </ul>
            </div>
            <div class="col-md-4"></div>
        </div>
    </div>
</footer>

<script type="text/javascript" src="addScript/intelOne/js/jquery-2.1.1.js"></script>
<script type="text/javascript" src="/addScript/intelOne/js/bootstrap.min.js"></script>
<script src="/addScript/intelOne/js/classie.js"></script>


</body>
</html>