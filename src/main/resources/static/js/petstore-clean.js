htmx.on("htmx:responseError", function (evt) {
    document.getElementById('error').style.display = 'block';
    bootstrap.Modal.getOrCreateInstance(document.getElementById('findPetOwnerModal')).hide();
    document.getElementById('error').innerHTML = evt.detail.xhr.responseText;
});
htmx.on("htmx:beforeSend", function () {
    document.getElementById('error').style.display = 'none';
    document.getElementById('error').innerHTML = "";
});
htmx.on("htmx:afterSwap", function (evt) {
    if (evt.detail.xhr.responseText.includes('<!--//js: closeFindPetOwnerModal//-->')) {
        bootstrap.Modal.getOrCreateInstance(document.getElementById('findPetOwnerModal')).hide();
    }
});