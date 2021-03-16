<%--
  Created by IntelliJ IDEA.
  User: ZZL
  Date: 2020/5/13
  Time: 15:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>发表文章</title>

    <link rel="stylesheet" href="${pageContext.request.contextPath}/cssAndJs/css/artcle_form.css">
    <script src="${pageContext.request.contextPath}/cssAndJs/js/artcle_form.js"></script>
    <script src="${pageContext.request.contextPath}/cssAndJs/js/artcle_form_numberOfWords.js"></script>

    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/addScript/swal/css/sweet-alert.css">
    <script src="${pageContext.request.contextPath}/addScript/swal/js/sweet-alert.min.js"></script>

</head>
<body>

<form action="${requestScope.article==null?"/article/create":"/article/modify"}" method="post">

        <div id="h1Div">
            <h1>发表文章</h1>
            <div class="Fh">
                <button id="returnTop" type="button" title="返回" onclick="window.history.go(-1);"></button>
            </div>
        </div>

    <div class="divCenter">
        <input type="hidden" name="id" value="${requestScope.article.id}">
        <div class="titleDiv">
            <input id="inTitle" value="${requestScope.article.title}" type="text" autocomplete="off" name="title"
                   onkeyup="titleNumber()" placeholder="此处输入文章标题">
            <div class="titleNumberDiv"><span id=wordTitle>0</span><span>/20</span></div>
        </div>
    </div>

    <div class="divCenter" class="summary">
        <div class="SACDiv">
        <textarea id="inSummary" class="summaryTextarea" name="summary" onkeyup="summaryNumber()"
                  placeholder="此处输入文章摘要">${requestScope.article.summary}</textarea>
            <div class="SACNumberDiv"><span id=wordSummary>0</span><span>/100</span></div>
        </div>
    </div>

    <div class="divCenter" class="content">
        <div class="SACDiv">
        <textarea id="inContent" class="contentTextarea" name="content" onkeyup="contentNumber()"
                  placeholder="此处输入文章内容">${requestScope.article.content}</textarea>
            <div class="SACNumberDiv"><span id=wordContent>0</span><span>/400</span></div>
        </div>
    </div>

    <div class="divCenter">
        <button class="butt" type="button" onclick="eliminate()">清空</button>
        <button class="butt" id="issueArticle" type="button" onclick="issue()">发布</button>
    </div>

</form>
</body>
</html>