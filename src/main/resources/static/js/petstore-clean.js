htmx.on("htmx:responseError", function (evt) {
    document.getElementById('error').style.display = 'block';
    document.getElementById('error').innerHTML = evt.detail.xhr.responseText;
});
htmx.on("htmx:beforeSend", function () {
    document.getElementById('error').style.display = 'none';
    document.getElementById('error').innerHTML = "";
});
