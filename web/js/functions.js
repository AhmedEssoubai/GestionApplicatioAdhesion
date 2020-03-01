function getEml(id)
{
    return document.getElementById(id);
}

function getElementInsideContainer(container, childID) {
    var elm = {};
    var elms = container.getElementsByTagName("*");
    for (var i = 0; i < elms.length; i++) {
        if (elms[i].id === childID) {
            elm = elms[i];
            break;
        }
    }
    return elm;
}

function serverCall(url)
{
    var xhttp = new XMLHttpRequest();
    xhttp.open("GET", url, true);
    xhttp.send();
}