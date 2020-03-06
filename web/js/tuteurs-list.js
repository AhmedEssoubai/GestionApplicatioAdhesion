var count = 0;

function addParent()
{
    if (count > 4)
        return;
    
    var nom = getElementInsideContainer(getEml("new"), "nom").value;
    var prenom = getElementInsideContainer(getEml("new"), "prenom").value;
    var cin = getElementInsideContainer(getEml("new"), "cin").value;
    var tel = getElementInsideContainer(getEml("new"), "tel").value;
    var email = getElementInsideContainer(getEml("new"), "email").value;
    var profession = getElementInsideContainer(getEml("new"), "profession").value;

    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function() {
        if (this.readyState == 4 && this.status == 200) {
            var id = this.responseText;
            getEml("list").innerHTML += '<div id="parent_' + id + '" class="col-12 my-3">' + 
                '<div class="pt-4 px-4">' + 
                    '<div id="ds" class="d-flex">' + 
                        '<div class="flex-grow-1 d-flex flex-column">' + 
                            '<h4 id="nom" class="mb-4">' + prenom + ' ' + nom + '</h4>' + 
                            '<p class="text-muted">Tel : <span id="tel">' + tel + '</span></p>' + 
                            '<p class="text-muted">Address e-mail : <span id="email">' + email + '</span></p>' + 
                            '<p class="text-muted">Profession : <span id="profession">' + profession + '</span></p>' + 
                        '</div>' + 
                        '<div class="d-flex pl-2 pr-5">' + 
                            '<p>CIN : <span id="cin">' + cin + '</span></p>' + 
                        '</div>' + 
                        '<div class="d-flex">' + 
                            '<div class="mx-3 icon-mute"><a title="Editer" onclick="editParent(' + id + ')"><span><i class="fas fa-pen"></i></span></a></div>' + 
                            '<div class="mx-3 icon-r"><a title="Supprimer" onclick="deleteParent(' + id + ')" role="button"><span><i class="fa fa-times"></i></span></a></div>' + 
                        '</div>' + 
                    '</div>' + 
                    '<div id="edt" class="container px-0 hd">' + 
                        '<form onsubmit="return updateParent(' + id + ')">' + 
                            '<div class="row my-3">' + 
                                '<div class="col-md-5 pr-1">' + 
                                    '<input id="prenom" type="text" maxlength="125" class="form-control" placeholder="Prenom" value="' + prenom + '" required />' + 
                                '</div>' + 
                                '<div class="col-md-5 pr-4">' + 
                                    '<input id="nom" type="text" maxlength="125" class="form-control" placeholder="Nom" value="' + nom + '" required />' + 
                                '</div>' + 
                                '<div class="col-md-2">' + 
                                    '<input id="cin" type="text" maxlength="10" class="form-control" placeholder="CIN" value="' + cin + '" required />' + 
                                '</div>' + 
                            '</div>' + 
                            '<div class="row my-3">' + 
                                '<div class="col">' + 
                                    '<div class="my-3">' + 
                                        '<input id="tel" class="form-control" maxlength="10" type="tel" placeholder="Tel" value="' + tel + '" required />' + 
                                    '</div>' + 
                                    '<div class="my-4">' + 
                                        '<input id="email" class="form-control" type="email" placeholder="Address e-mail" value="' + email + '" required />' + 
                                    '</div>' + 
                                    '<div class="my-4">' + 
                                        '<input id="profession" maxlength="125" class="form-control" type="text" placeholder="Profession" value="' + profession + '" required />' + 
                                    '</div>' + 
                                    '<div class="mt-4 d-flex justify-content-end">' + 
                                        '<button type="submit" class="btn btn-primary px-5">Mise à jour</button>' + 
                                    '</div>' + 
                                '</div>' + 
                            '</div>' + 
                        '</form>' +
                    '</div>' + 
                    '<hr class="mt-3"/>' + 
                '</div>' + 
            '</div>';
            count++;
            if (count == 1)
                getEml("vide").classList.add("hd");
        }
    };
    xhttp.open("GET", "Parents?num=" + num + "&action=add" + "&nom=" + nom + "&prenom=" + prenom + "&tel=" + tel + "&email=" + email + "&cin=" + cin + "&profession=" + profession, true);
    xhttp.send();
    return false;
}

function editParent(id)
{
    var ds = getElementInsideContainer(getEml("parent_" + id), "ds");
    var edt = getElementInsideContainer(getEml("parent_" + id), "edt");
    
    ds.classList.add("hd");
    edt.classList.remove("hd");
}

function updateParent(id)
{
    var ds = getElementInsideContainer(getEml("parent_" + id), "ds");
    var edt = getElementInsideContainer(getEml("parent_" + id), "edt");
    
    var nom = getElementInsideContainer(edt, "nom").value;
    var prenom = getElementInsideContainer(edt, "prenom").value;
    var cin = getElementInsideContainer(edt, "cin").value;
    var tel = getElementInsideContainer(edt, "tel").value;
    var email = getElementInsideContainer(edt, "email").value;
    var profession = getElementInsideContainer(edt, "profession").value;

    getElementInsideContainer(ds, "nom").innerHTML = prenom + " " + nom;
    getElementInsideContainer(ds, "cin").innerHTML = cin;
    getElementInsideContainer(ds, "tel").innerHTML = tel;
    getElementInsideContainer(ds, "email").innerHTML = email;
    getElementInsideContainer(ds, "profession").innerHTML = profession;
    
    edt.classList.add("hd");
    ds.classList.remove("hd");

    serverCall("Parents?num=" + num + "&action=update" + "&id=" + id + "&nom=" + nom + "&prenom=" + prenom + "&tel=" + tel + "&email=" + email + "&cin=" + cin + "&profession=" + profession);
    return false;
}

function deleteParent(id)
{
    getEml("parent_" + id).remove();
    count--;
    if (count == 0)
        getEml("vide").classList.remove("hd");
    serverCall("Parents?num=" + num + "&action=delete&id=" + id);
}