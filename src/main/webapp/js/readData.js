const fetchData = function () {
    sendAjax("GET", "/comment", readData);
}

let readData = function () {
    console.log(this.responseText);
    const data = JSON.parse(this.responseText);
    let feedbacks = document.getElementById('feedbacks');
    let block = data.map(function (data) {
        return showData(data);
    });
    block.forEach((comment => {
        feedbacks.appendChild(comment);
    }));
}

const sendAjax = function (reqType, url = null, callback = null, data = null) {
    const xhr = new XMLHttpRequest();
    xhr.open(reqType, url, true);
    xhr.addEventListener("load", callback);
    xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
    xhr.send(data);
}

window.onload = fetchData;
