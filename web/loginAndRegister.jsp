<%--
  Created by IntelliJ IDEA.
  User: ZZL
  Date: 2020/5/12
  Time: 20:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>
    <meta charset="UTF-8">
    <title>欢迎来到星辰的世界~~</title>

    <link rel="stylesheet" href="${pageContext.request.contextPath}/addScript/LAndR/css/DontKnow.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/addScript/LAndR/css/DontKnow2.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/addScript/LAndR/css/loginAndRegister.css">
    <script src="${pageContext.request.contextPath}/addScript/LAndR/js/loginAndRegister.js"></script>

    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/addScript/swal/css/sweet-alert.css">
    <script src="${pageContext.request.contextPath}/addScript/swal/js/sweet-alert.min.js"></script>

    <script src="${pageContext.request.contextPath}/cssAndJs/js/register.js"></script>

</head>
<body>
<div class="cotn_principal">
    <div class="cont_centrar">
        <div class="cont_login">
            <div class="cont_info_log_sign_up">
                <div class="col_md_login">
                    <div class="cont_ba_opcitiy">
                        <h2>又见面啦</h2>
                        <p>欢迎回到星辰的世界~~ 现在登录，尽情遨游</p>
                        <button class="btn_login" onClick="cambiar_login()">朕要现在登录</button>
                    </div>
                </div>
                <div class="col_md_sign_up">
                    <div class="cont_ba_opcitiy">
                        <h2>初次见面</h2>
                        <p>还没有账号？~~ 即刻注册，遨游星辰的世界</p>
                        <button class="btn_sign_up" onClick="cambiar_sign_up()">立刻帮朕注册</button>
                    </div>
                </div>
            </div>
            <div class="cont_back_info">
                <div class="cont_img_back_grey"><img src="/img/loginAndRegister/ld.jpg" alt=""/></div>
            </div>
            <div class="cont_forms">
                <div class="cont_img_back_"><img src="/img/loginAndRegister/ld.jpg" alt=""/></div>
                <form action="/login" method="post">
                    <div class="cont_form_login"><a href="#" onClick="ocultar_login_sign_up()"><i
                            class="material-icons">&#xE5C4;</i></a>
                        <h2>登录</h2>
                        <input type="text" id="usernameLogin" name="username" autocomplete="off" placeholder="输入您的邮箱~"/>
                        <input type="password" id="passwordLogin" name="password" autocomplete="off"
                               placeholder="输入您的密码~"/>
                        <button class="btn_login" id="dlan" type="button" onClick="fnLogin();cambiar_login()">立即登录
                        </button>
                    </div>
                </form>
                <form id="for2" action="/register" method="post">
                    <div class="cont_form_sign_up"><a href="#" onClick="ocultar_login_sign_up()"><i
                            class="material-icons">&#xE5C4;</i></a>
                        <h2>注册</h2>
                        <input type="text" id="username" name="username" autocomplete="off" placeholder="请告诉我您的邮箱~"/>
                        <input type="text" id="nickname" name="nickname" autocomplete="off" placeholder="为您起一个昵称吧~"/>
                        <input type="password" id="passwordOne" name="passwordOne" autocomplete="off"
                               placeholder="来设置一个密码吧~"/>
                        <input type="password" id="passwordTwo" name="passwordTwo" autocomplete="off"
                               placeholder="请您再次输入密码~"/>
                        <button class="btn_sign_up" id="zcan" type="button" onClick="fnRegister();cambiar_sign_up()">
                            立即注册
                        </button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>


<c:if test="${requestScope.errorMsg=='1'}">
    <script>
        window.onload = function () {
            swal("邮箱错误", "此邮箱尚未注册~", "error");
        }
    </script>
</c:if>
<c:if test="${requestScope.errorMsg=='2'}">
    <script>
            window.onload = function () {
                swal("密码错误", "输入的密码不正确哦~", "error");
            }
    </script>
</c:if>



<c:if test="${requestScope.hint=='1'}">
    <script>
        window.onload = function () {
            swal("注册失败", "此邮箱已经注册，请直接登录~", "error");
        }
    </script>
</c:if>
<c:if test="${requestScope.hint=='2'}">
    <script>
        window.onload = function () {
            swal("注册成功", "赶快就登录吧~", "success");
        }
    </script>
</c:if>
<c:if test="${requestScope.hint=='3'}">
    <script>
        window.onload = function () {
            swal("注册失败", "登录逻辑错误，请联系管理员处理~", "error");
        }
    </script>
</c:if>

</body>
</html>


