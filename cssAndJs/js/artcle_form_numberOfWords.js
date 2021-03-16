function titleNumber() {
    var numberOfWords = (inTitle.value.replace(/[^\r\n]/g, "**").length) / 2;
    if (numberOfWords > 20) {
        wordTitle.style.color = "red";
    } else {
        wordTitle.style.color = "gray";
    }
    wordTitle.innerHTML = numberOfWords;
}

function summaryNumber() {
    var numberOfWords = (inSummary.value.replace(/[^\r\n]/g, "**").length) / 2;
    if (numberOfWords > 100) {
        wordSummary.style.color = "red";
    } else {
        wordSummary.style.color = "gray";
    }
    wordSummary.innerHTML = numberOfWords;
}

function contentNumber() {
    var numberOfWords = (inContent.value.replace(/[^\r\n]/g, "**").length) / 2;
    if (numberOfWords > 400) {
        wordContent.style.color = "red";
    } else {
        wordContent.style.color = "gray";
    }
    wordContent.innerHTML = numberOfWords;
}

function meanwhile() {
    titleNumber();
    summaryNumber();
    contentNumber();
}

onload = meanwhile;