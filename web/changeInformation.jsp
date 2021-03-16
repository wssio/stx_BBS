<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ZZL
  Date: 2020/5/16
  Time: 15:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>${requestScope.user.username}-修改个人信息</title>

    <link rel="stylesheet" href="${pageContext.request.contextPath}/addScript/intelOne/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/addScript/intelOne/css/changeInformation.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/addScript/sex/sex.css">
    <script src="${pageContext.request.contextPath}/cssAndJs/js/getPhoto.js"></script>

    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/addScript/swal/css/sweet-alert.css">
    <script src="${pageContext.request.contextPath}/addScript/swal/js/sweet-alert.min.js"></script>

</head>

<body class="sub-page" onload="getAvatar()">

<%--隐藏数据用来动态修改前端页面--%>
<input type="hidden" id="userSex" value="${requestScope.user.sex}">
<input type="hidden" id="photoNumber" value="${requestScope.systemDate}">

<div id="page-content" class="single-page">
    <div class="container">
        <div class="row">
            <div id="main-content">
                <article>
                    <div class="art-content">
                        <div class="row">

                            <div class="col-md-4 box-item">
                                <div class="photoSelect" id="selectAvatar" style="color: #a6e22d;font-size: 20px"></div>
                            </div>


                            <div class="col-md-8">
                                <h3>${requestScope.user.username}</h3>

                                <form name="/change/information" method="get">

                                    <%--隐藏数据用来提交--%>
                                    <input type="hidden" name="update_userId" value="${requestScope.user.id}">
                                    <input type="hidden" name="updateAvarat" id="updateAvarat"
                                           value="${requestScope.user.avatar}">
                                    <input type="hidden" name="updateSex" id="updateSex" value="${requestScope.user.sex}">



                                    <div class="row">
                                        <div class="col-md-12">
                                            <div class="form-group">
                                                <input type="" class="form-control input-lg" name="nickname"
                                                       id="subject" placeholder="要换成什么昵称呢？" autocomplete="off"
                                                       value="${requestScope.user.nickname}"/>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col-md-6">
                                            <div class="form-group">
                                                <input type="password" class="form-control input-lg" name="passwordOne"
                                                       id="passwordOne"
                                                       placeholder="在这里更换密码~" autocomplete="off"/>
                                            </div>
                                        </div>
                                        <div class="col-md-6">
                                            <div class="form-group">
                                                <input type="password" class="form-control input-lg" name="passwordTwo"
                                                       id="passwordTwo" placeholder="再确认一下密码~" autocomplete="off"/>
                                            </div>
                                        </div>
                                    </div>


                                    <div class="row">
                                        <div class="col-md-12">

                                            <input type="hidden" id="womanAndMan" value="0">
                                            <%--女生--%>
                                            <c:if test="${requestScope.user.sex=='1'}">
                                                <li class="tg-list-item man man1">
                                                    <input class="tgl tgl-skewed" id="iMWoman" type="checkbox"
                                                           name="selectSex" value="0" checked onclick="sexAndAvatar()">
                                                    <label class="tgl-btn" data-tg-off="I'm a boy."
                                                           data-tg-on="I am a girl." for="iMWoman"></label>
                                                </li>
                                            </c:if>
                                            <%--男生--%>
                                            <c:if test="${requestScope.user.sex=='0'}">
                                                <li class="tg-list-item man man1">
                                                    <input class="tgl tgl-skewed" id="iMMan" type="checkbox"
                                                           name="selectSex" value="1" onclick="sexAndAvatar()">
                                                    <label class="tgl-btn" data-tg-off="I'm a boy."
                                                           data-tg-on="I am a girl." for="iMMan"></label>
                                                </li>
                                            </c:if>
                                            <%--默认--%>
                                            <c:if test="${requestScope.user.sex==2}">
                                                <li class="tg-list-item man man1">
                                                    <input class="tgl tgl-skewed" id="iMM" type="checkbox"
                                                           name="selectSex" value="1" checked onclick="sexAndAvatar()">
                                                    <label class="tgl-btn" data-tg-off="I'm a boy."
                                                           data-tg-on="I am a girl." for="iMM"></label>
                                                </li>
                                            </c:if>

                                        </div>
                                    </div>

                                    <br>
                                    <div class="row">
                                        <div class="col-md-12 man man2">
                                            <button type="button" class="btn btn-skin btn-block" name="submitcontact"
                                                    id="submit" onclick="realPassword()">确认修改
                                            </button>
                                        </div>
                                    </div>
                                    <br>

                                </form>
                                <form action="/delete/user" method="post" style="padding: 0px">
                                    <input type="hidden" name="delete_user" value="${requestScope.user.id}">
                                <div class="row">
                                    <div class="col-md-12 man man3" style="padding-top: 8px">
                                        <button type="button" onclick="realDeleteUser()" class="btn btn-skin btn-block"
                                                name="submitcontact"
                                                id="submitcontact">注销账号
                                        </button>
                                    </div>
                                </div>
                                </form>
                            </div>

                        </div>
                    </div>
                </article>
            </div>
        </div>
    </div>
</div>
</body>


</html>
