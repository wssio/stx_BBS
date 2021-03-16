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

    <title>全部文章</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/addScript/intelOne/css/bootstrap.min.css"
          type="text/css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/addScript/intelOne/css/privateStyle.css"
          type="text/css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/addScript/intelOne/font-awesome-4.4.0/css/font-awesome.min.css"
          type="text/css">

</head>


<body class="index-page">

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
                <li>
                    <a class="page-scroll" href="/article/create">发表文章</a>
                </li>
                <li>
                    <a class="page-scroll" href="/intel">返回首页</a>
                </li>
            </ul>
        </div>


    </div>
</nav>


<div id="page-content">
    <section class="box-content box-1">
        <div class="container" style="margin-top: 150px">



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

                            <div class="anDiv3">
                                <ul class="list-inline social-buttons">
                                    <li>
                                        <a class="dianZanStop"><i class="fa fa-thumbs-up"></i></a>
                                    </li>
                                    <span>${article.likeTotal}</span>&ensp;&ensp;
                                    <li>
                                        <a class="dianZan"
                                           href="/article/show?id=${article.id}&login_user=${sessionScope.login_user.id}"><i
                                                class="fa fa-comment"></i></a>
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
                                <a id="readMore"
                                   href="/article/show?id=${article.id}&login_user=${sessionScope.login_user.id}">阅读更多...</a>
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




</body>
</html>