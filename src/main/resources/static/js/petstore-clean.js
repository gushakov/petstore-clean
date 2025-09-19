htmx.on("htmx:afterSwap", function (evt) {
    if (evt.detail.xhr.responseText.includes('<!--//js: closeModals//-->')) {
        bootstrap.Modal.getOrCreateInstance(document.getElementById('findPetOwnerModal')).hide();
    }
    if (evt.detail.xhr.responseText.includes('<!--//js: clearMessages//-->')) {
       document.getElementById('error').style.display = 'none';
       document.getElementById('error').innerHTML = "";
       document.getElementById('success').style.display = 'none';
       document.getElementById('success').innerHTML = "";
    }
});