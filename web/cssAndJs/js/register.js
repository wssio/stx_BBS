function fnRegister() {
    var username = document.getElementById("username");
    var nickname = document.getElementById("nickname");
    var passwordOne = document.getElementById("passwordOne");
    var regEmail = /^[a-z0-9]+([._\\-]*[a-z0-9])*@([a-z0-9]+[-a-z0-9]*[a-z0-9]+.){1,63}[a-z0-9]+$/;
    if (username.value.length == 0) {
        swal("邮箱错误", "请填写您的邮箱~", "error");
        return;
    } else if (!regEmail.test(username.value)) {
        swal("邮箱错误", "请检查您的邮箱格式是否填写正确~", "error");
        return;
    } else if (nickname.value.length == 0) {
        swal("昵称错误", "请您设置昵称~", "error");
        return;
    } else if ((nickname.value.length < 2) || (nickname.value.length > 10)) {
        swal("昵称错误", "昵称长度应介于2-10位之间~", "error");
        return;
    } else if (passwordOne.value.length == 0) {
        swal("密码错误", "请您设置密码~", "error");
        return;
    } else if ((passwordOne.value.length < 6) || (passwordOne.value.length > 18)) {
        swal("密码错误", "密码长度应介于6-18位之间~", "error");
        return;
    } else if (passwordTwo.value.length == 0) {
        swal("密码错误", "请确认您的密码~", "error");
        return;
    } else if ((passwordOne.value) != (passwordTwo.value)) {
        swal("密码错误", "两次输入密码不一致~", "error");
        return;
    } else {
        document.getElementById("zcan").type = "submit";
        document.getElementById("for1").value.clear();
    }
}

function fnLogin() {

    var username = document.getElementById("usernameLogin");
    var password = document.getElementById("passwordLogin");
    var regEmail = /^[a-z0-9]+([._\\-]*[a-z0-9])*@([a-z0-9]+[-a-z0-9]*[a-z0-9]+.){1,63}[a-z0-9]+$/;
    if (username.value.length == 0) {
        swal("邮箱错误", "请填写您的邮箱~", "error");
        return;
    } else if (!regEmail.test(username.value)) {
        swal("邮箱错误", "请检查您的邮箱格式是否填写正确~", "error");
        return;
    } else if (password.value.length == 0) {
        swal("密码错误", "请您填写密码~", "error");
        return;
    } else {
        document.getElementById("dlan").type = "submit";
    }
}

