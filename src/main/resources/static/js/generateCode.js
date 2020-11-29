function generateCode() {


    alert("he");

    var xhttp = new XMLHttpRequest();

    xhttp.open("GET", "/generateCode", true);
    xhttp.send();

    xhttp.onreadystatechange = function () {
        var code;
        if (this.readyState === 4 && this.status === 200) {
            code = xhttp.responseText;
            document.getElementById("instCode").value = code;

        }
    }

}