function eliminate() {
    var title = document.getElementById("inTitle").value;
    var summary = document.getElementById("inSummary").value;
    var content = document.getElementById("inContent").value;
    if ((title.length != 0) || (summary.length != 0) || (content.length != 0)) {
        document.getElementById("inTitle").value = "";
        document.getElementById("inSummary").value = "";
        document.getElementById("inContent").value = "";
        swal("清除成功", "您已成功清除所有内容~", "success");
    } else {
        swal("清除失败", "您还没有输入任何内容~", "error");
    }
}

function issue() {
    var title = document.getElementById("inTitle").value;
    var summary = document.getElementById("inSummary").value;
    var content = document.getElementById("inContent").value;
    // var numberOfWordsTitle = (inTitle.value.replace(/[^\r\n]/g, "**").length) / 2;
    // var numberOfWordsSummary = (inSummary.value.replace(/[^\r\n]/g, "**").length) / 2;
    // var numberOfWordsContent = (inContent.value.replace(/[^\r\n]/g, "**").length) / 2;
    if (title.length == 0) {
        swal("标题错误", "请您填写文章标题~", "error");
        return;
    } else if (title.length > 20) {
        swal("字数超出限制", "文章标题字数不得多于20字~", "error");
    } else if (summary.length == 0) {
        swal("摘要错误", "请您填写文章摘要~", "error");
        return;
    } else if (summary.length > 100) {
        swal("字数超出限制", "文章摘要字数不得多于100字~", "error");
    } else if (content.length == 0) {
        swal("内容错误", "请您填写文章内容~", "error");
        return;
    } else if (content.length > 400) {
        swal("字数超出限制", "文章内容字数不得多于400字~", "error");
    } else {
        document.getElementById("issueArticle").type = "submit";
    }
}
