<%--
  Created by IntelliJ IDEA.
  User: ZZL
  Date: 2020/5/14
  Time: 14:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fun" uri="http://java.sun.com/jsp/jstl/functions" %>

<style>

</style>

<html>
<head>
    <!-- META DATA -->

    <link rel="stylesheet" href="${pageContext.request.contextPath}/addScript/intelOne/css/bootstrap.min.css"
          type="text/css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/cssAndJs/css/article_show.css" type="text/css">
    <script src="${pageContext.request.contextPath}/addScript/intelOne/js/jquery-1.9.1.js"></script>
    <script src="${pageContext.request.contextPath}/cssAndJs/js/show_commentIdea.js"></script>
    <script src="${pageContext.request.contextPath}/cssAndJs/js/getPhoto.js"></script>

    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/addScript/intelOne/font-awesome-4.4.0/css/font-awesome.min.css"
          type="text/css">


    <title>${requestScope.article.title}-星辰博客</title>
</head>

<body class="sub-page" onload="setSex(${requestScope.article.user.sex});getPhoto(${requestScope.article.user.avatar})">

<a name="top"></a>
<%--实现不刷新提交--%>
<iframe name='hidden_frame' id="hidden_frame"></iframe>

<%--返回首页--%>
<div id="returnIntel">
    <a  title="返回首页" href="/intel"class="topAndIntel" title="返回"  style="outline: none;"><i class="fa fa-arrow-left"></i></a>
</div>
<%--返回顶部--%>
<div id="returnTop">
<%--    <div style="height: 7px"></div>--%>
        <a href="#top" class="topAndIntel" title="回到顶部" style="outline: none;"><i class="fa fa-arrow-up"></i></a>

</div>

<header class="container container_title">
    <div class="site-branding">
        <h1 class="site-title">
            <a >
                <span>${requestScope.article.title}</span>
            </a>
        </h1>
        <h2 class="site-description"><a id="user" href="/intel/private?userId=${requestScope.article.userid}">${requestScope.article.user.nickname}</a></h2>
    </div>
    <div class="photoDiv" id="photo"></div>
</header>

<!-- Content -->
<div id="page-content" class="single-page">
    <div class="container">
        <div class="row">


            <div class="main-content">
                <article class="article">
                    <div class="art-content">
                        <div class="info time">
                            ${requestScope.article.addTimeDate}&emsp;&emsp;「${requestScope.article.readTotal}次浏览.${requestScope.article.likeTotal}次获赞」
                        </div>
                        <div class="excerpt">
                            <div class="info">
                                <pre>${requestScope.article.summary}</pre>
                            </div>
                            <div class="info">
                                <pre>${requestScope.article.content}</pre>
                            </div>
                        </div>

                    </div>
                </article>
                <div class="widget">
                    <div class="heading">
                        <form action="/add/comment" method="post">
                            <input type="hidden" name="login_user" value="${requestScope.login_user}">
                            <input type="hidden" name="pLArticle" value="${requestScope.article.id}">
                            <div id="divIdea">
                                <textarea id="comment" name="addComment" placeholder="在这里输入你的想法"></textarea>
                            </div>
                            <input id="idea" type="button" value="留下此刻的想法..." onclick="hideElem()"/>
                        </form>
                    </div>
                </div>
            </div>

            <c:if test="${!empty requestScope.comments}">

                <header class="header_PL">
                    <div class="site-branding_PL">
                        <h1 class="site-title_PL">
                            <a>
                                <span>评论</span>
                            </a>
                        </h1>
                        <h2 class="site-description_PL">评论数量「${fun:length(requestScope.comments)}」</h2>
                    </div>
                </header>

                <c:forEach varStatus="idx" var="commentC" items="${requestScope.comments}">

                    <div class="main-content_PL">
                        <article class="article_PL">
                            <div class="art-content">
                                <div class="info">
                                    <a href="/intel/private?userId=${commentC.user.id}">${commentC.user.nickname}</a>
                                    <time class="time pLtime">${commentC.addTimeString}</time>
                                </div>
                                <div id="xianShipL${commentC.commentID}${idx.count}">${commentC.content}</div>
                                    <%--如果是自己评论的，就可以修改--%>
                                <c:if test="${requestScope.login_user==commentC.user.id}">
                                    <div class="widgetUpdate">
                                        <div class="heading headingPL">

                                            <form action="/update/comment" method="post" target="hidden_frame"
                                                  class="forM">

                                                    <%--hidden提交评论id--%>
                                                <input type="hidden" name="updateCommentID"
                                                       value="${commentC.commentID}">

                                                    <%--更新评论div，初始时隐藏--%>
                                                <div class="updateDivIdea updateDivIdeapL${commentC.commentID}${idx.count}">
                                                    <textarea class="updateComment"
                                                              id="textpL${commentC.commentID}${idx.count}"
                                                              name="updateIdea"
                                                              placeholder="在这里输入你的想法">${commentC.content}</textarea>
                                                </div>
                                                <input class="updateIdea" id="pL${commentC.commentID}${idx.count}"
                                                       type="button" value="我想，修改一下..."
                                                       onclick="hideElemUpdate(this)"/>
                                                <input class="deleteIdea" type="button"
                                                       onclick="window.location.href='/comment/delete?commentId=${commentC.commentID}&articleID=${requestScope.article.id}&login_user=${requestScope.login_user}'"
                                                       value="删除此条评论..."/>
                                            </form>
                                        </div>
                                    </div>
                                </c:if>

                            </div>
                        </article>
                    </div>

                </c:forEach>

            </c:if>


            <div class="bottomHeight"></div>
        </div>
    </div>

</div>


</body>
</html>