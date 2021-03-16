var sex;
var photoNumber;

function setSex(xB) {
    sex = xB;
}

function getPhoto(number) {
    photoNumber = number;
    setPhoto(sex, photoNumber);
}

function setPhoto(sex, photoNumber) {
    var key = document.getElementById("photo").childElementCount;
    console.debug('性别:' + sex + ',头像:' + photoNumber + ',已有头像:' + key)
    if (key < 1) {
        var img = document.createElement('img');//创建一个标签
        img.setAttribute('class', 'addImg');
        if (sex == 0) {
            if (photoNumber != null) {
                img.setAttribute('src', 'http://localhost:8080/img/photo/man/head' + photoNumber + '.png');//给标签定义src链接
            } else {
                img.setAttribute('src', 'http://localhost:8080/img/photo/rest/head10000.png');//给标签定义src链接
            }
        } else if (sex == 1) {
            if (photoNumber != null) {
                img.setAttribute('src', 'http://localhost:8080/img/photo/woman/head' + photoNumber + '.png');//给标签定义src链接
            } else {
                img.setAttribute('src', 'http://localhost:8080/img/photo/rest/head10000.png');//给标签定义src链接
            }
        } else {
            img.setAttribute('src', 'http://localhost:8080/img/photo/rest/head10000.png');//给标签定义src链接
        }
        img.setAttribute('width', '100%');
        img.setAttribute('style', 'border-radius:90px;background-position:center center;background-color: white;');
        document.getElementById("photo").appendChild(img);//放到指定的id里
    }
}


//获取头像列表
function getAvatar() {
    var photoNumber = document.getElementById("photoNumber").value;
    var userSex = document.getElementById("userSex").value;
    if ((userSex == 0) || (userSex == 1)) {
        for (var i = 1; i <= photoNumber; i++) {
            var addDiv = document.createElement('div');//创建一个标签
            addDiv.setAttribute('class', 'headDiv');
            addDiv.setAttribute('id', 'xz' + i);
            addDiv.setAttribute('onclick', 'selectImg(this)');
            if (userSex == 0) {
                addDiv.setAttribute('style', "background-image:url('http://localhost:8080/img/photo/man/head" + i + ".png');width:40px;height:40px;border-radius:50%;float:left;background-size:100% 100%;background-repeat:no-repeat;background-position:center center;margin:18px 5px 8px 10px;");
            } else if (userSex == 1) {
                addDiv.setAttribute('style', "background-image:url('http://localhost:8080/img/photo/woman/head" + i + ".png');width:40px;height:40px;border-radius:50%;float:left;background-size:100% 100%;background-repeat:no-repeat;background-position:center center;margin:18px 5px 8px 10px;");
            }
            document.getElementById("selectAvatar").appendChild(addDiv);//放到指定的id里
        }
    } else {
        document.getElementById("selectAvatar").innerHTML = '请先告诉我你是男生还是女生，这样我才能为您提供对应的头像哦~'
    }
}


//选择头像
function selectImg(element) {
    var thidID = element.id;
    var headDiv = document.getElementsByClassName('headDiv');
    for (var i = 0; i < headDiv.length; i++) {
        var headDivID = headDiv[i].id;
        // var ifHaveHead = headDiv[i].getElementsByClassName("addImg");

        //先清除img
        if ((headDiv[i].childElementCount) != 0) {
            headDiv[i].removeChild(headDiv[i].childNodes[0]);
        }
        //添加img
        if (headDivID == thidID) {
            var img = document.createElement('img');//创建一个标签
            img.setAttribute('class', 'addImg');
            img.setAttribute('src', 'http://localhost:8080/img/correct/yes.png');//给标签定义src链接
            img.setAttribute('style', 'width:100%;border-radius:90px;background-position:center center;');
            document.getElementById(thidID).appendChild(img);//放到指定的id里
            document.getElementById("updateAvarat").value = (i + 1);
        }
    }
}


//性别切换头像
function sexAndAvatar() {
    var key = document.getElementById("selectAvatar").childElementCount;
    var photoSelect = document.getElementsByClassName('photoSelect');
    var sexKey = document.getElementById("womanAndMan").value;
    var photoNumber = document.getElementById("photoNumber").value;
    var userSex = document.getElementById("userSex").value;

    //如果有头像，先清除
    for (var i = 0; i < photoSelect.length; i++) {

        if ((photoSelect[i].childElementCount) != 0) {
            for (var j = 0; j < key; j++) {
                photoSelect[i].removeChild(photoSelect[i].childNodes[i]);
            }
        }
    }

    if (userSex == 0) {

        for (var i = 1; i <= photoNumber; i++) {
            var addDiv = document.createElement('div');//创建一个标签
            addDiv.setAttribute('class', 'headDiv');
            addDiv.setAttribute('id', 'xz' + i);
            addDiv.setAttribute('onclick', 'selectImg(this)');
            if (sexKey == 0) {
                addDiv.setAttribute('style', "background-image:url('http://localhost:8080/img/photo/woman/head" + i + ".png');width:40px;height:40px;border-radius:50%;float:left;background-size:100% 100%;background-repeat:no-repeat;background-position:center center;margin:18px 5px 8px 10px;");
                document.getElementById("updateSex").value = 1;
            } else if (sexKey == 1) {
                addDiv.setAttribute('style', "background-image:url('http://localhost:8080/img/photo/man/head" + i + ".png');width:40px;height:40px;border-radius:50%;float:left;background-size:100% 100%;background-repeat:no-repeat;background-position:center center;margin:18px 5px 8px 10px;");
                document.getElementById("updateSex").value = 0;
            }
            document.getElementById("selectAvatar").appendChild(addDiv);//放到指定的id里
        }
        if (sexKey == 0) {
            document.getElementById("womanAndMan").value = 1;
        } else {
            document.getElementById("womanAndMan").value = 0;
        }
        document.getElementById("updateAvarat").value = 0;
    } else if (userSex == 1) {

        for (var i = 1; i <= photoNumber; i++) {
            var addDiv = document.createElement('div');//创建一个标签
            addDiv.setAttribute('class', 'headDiv');
            addDiv.setAttribute('id', 'xz' + i);
            addDiv.setAttribute('onclick', 'selectImg(this)');
            if (sexKey == 0) {
                addDiv.setAttribute('style', "background-image:url('http://localhost:8080/img/photo/man/head" + i + ".png');width:40px;height:40px;border-radius:50%;float:left;background-size:100% 100%;background-repeat:no-repeat;background-position:center center;margin:18px 5px 8px 10px;");
                document.getElementById("updateSex").value = 0;
            } else if (sexKey == 1) {
                addDiv.setAttribute('style', "background-image:url('http://localhost:8080/img/photo/woman/head" + i + ".png');width:40px;height:40px;border-radius:50%;float:left;background-size:100% 100%;background-repeat:no-repeat;background-position:center center;margin:18px 5px 8px 10px;");
                document.getElementById("updateSex").value = 1;
            }
            document.getElementById("selectAvatar").appendChild(addDiv);//放到指定的id里
        }
        if (sexKey == 0) {
            document.getElementById("womanAndMan").value = 1;
        } else {
            document.getElementById("womanAndMan").value = 0;
        }
        document.getElementById("updateAvarat").value = 0;

    } else if (userSex == 2) {

        document.getElementById("selectAvatar").innerHTML = ''
        for (var i = 1; i <= photoNumber; i++) {
            var addDiv = document.createElement('div');//创建一个标签
            addDiv.setAttribute('class', 'headDiv');
            addDiv.setAttribute('id', 'xz' + i);
            addDiv.setAttribute('onclick', 'selectImg(this)');
            if (sexKey == 0) {
                addDiv.setAttribute('style', "background-image:url('http://localhost:8080/img/photo/man/head" + i + ".png');width:40px;height:40px;border-radius:50%;float:left;background-size:100% 100%;background-repeat:no-repeat;background-position:center center;margin:18px 5px 8px 10px;");
                document.getElementById("updateSex").value = 0;
            } else if (sexKey == 1) {
                addDiv.setAttribute('style', "background-image:url('http://localhost:8080/img/photo/woman/head" + i + ".png');width:40px;height:40px;border-radius:50%;float:left;background-size:100% 100%;background-repeat:no-repeat;background-position:center center;margin:18px 5px 8px 10px;");
                document.getElementById("updateSex").value = 1;
            }
            document.getElementById("selectAvatar").appendChild(addDiv);//放到指定的id里
        }
        if (sexKey == 0) {
            document.getElementById("womanAndMan").value = 1;
        } else {
            document.getElementById("womanAndMan").value = 0;
        }
        document.getElementById("updateAvarat").value = 0;

    }
}

function realUpdateUser() {

}

function realPassword() {

    var passwordOne = document.getElementById("passwordOne").value;
    var passwordTwo = document.getElementById("passwordTwo").value;

    if (passwordOne==passwordTwo){
        document.getElementById('submit').type='submit';
    }else{
        swal("密码错误", "两次输入密码不一致，请检查后重试~", "error");
    }
}

function realDeleteUser() {

    var yesName = document.getElementById("subject").value;
    if (yesName!=1){
        swal("注销提示", "如需注销账户，请在昵称处填写1，然后再次点击注销按钮~", "error");
    }else{
        document.getElementById('submitcontact').type='submit';
    }
}