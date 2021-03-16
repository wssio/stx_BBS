function hideElem() {
    var key = document.getElementById("idea").value;
    var comm =document.getElementById("comment").value;
    if (key == '留下此刻的想法...') {
        $("#divIdea").slideDown(700);
        document.getElementById("idea").value = '就这样了，提交...';
    } else {
        if (key == '就这样了，提交...') {
            if ((comm!=null)&&(comm!="")){
                document.getElementById("idea").type = "submit";
            }
            $("#divIdea").slideUp(500);
            document.getElementById("idea").value = '留下此刻的想法...';
        }
    }
}

function hideElemUpdate(element) {
    var id = element.id;
    var updateDivIdea = '#updateDivIdea' + id;
    var key = document.getElementById(id).value;
    var textId = 'text' + id;
    var xianShiId = 'xianShi' + id;


    if (key == '我想，修改一下...') {
        $(".updateDivIdea" + id).slideDown(700);
        document.getElementById(id).value = '我改好了，提交...';
    } else {
        if (key == '我改好了，提交...') {

            document.getElementById(id).type = "submit";

            //text与评论div数据交换
            document.getElementById(xianShiId).innerHTML = document.getElementById(textId).value;
            $(".updateDivIdea" + id).slideUp(500);
            document.getElementById(id).value = '我想，修改一下...';
        }
    }
}
