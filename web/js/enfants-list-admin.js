var count = 0;

function addEnfant()
{
    var nom = getElementInsideContainer(getEml("new"), "nom").value;
    var prenom = getElementInsideContainer(getEml("new"), "prenom").value;
    var cne = getElementInsideContainer(getEml("new"), "cne").value;
    var date_naissance = getElementInsideContainer(getEml("new"), "date_naissance").value;
    var classe = getElementInsideContainer(getEml("new"), "classe").value;
    var assurance = getElementInsideContainer(getEml("new"), "assurance").value;

    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function() {
        if (this.readyState == 4 && this.status == 200) {
            var id = this.responseText;
            getEml("list").innerHTML += '<div id="enfant_' + id + '" class="col-12 my-3">' + 
                '<div class="bg-white shadow-sm p-4">' + 
                    '<div id="ds" class="d-flex">' + 
                        '<div class="flex-grow-1 d-flex flex-column">' + 
                            '<h4 id="nom" class="mb-4">' + prenom + ' ' + nom + '</h4>' + 
                            '<p class="text-muted">Date de naissance : <span id="date">' + date_naissance + '</span></p>' + 
                            '<p class="text-muted">Classe : <span id="classe">' + classe + '</span></p>' + 
                            '<p class="text-muted">Assurance : <span id="assurance">' + assurance + '</span></p>' + 
                        '</div>' + 
                        '<div class="d-flex pl-2 pr-5">' + 
                            '<p>CNE : <span id="cne">' + cne + '</span></p>' + 
                        '</div>' + 
                        '<div class="d-flex">' + 
                            '<div class="mx-3 icon-r"><a title="Supprimer" onclick="deleteEnfant(' + id + ')" role="button"><span><i class="fa fa-times"></i></span></a></div>' + 
                        '</div>' + 
                    '</div>' + 
                '</div>' + 
            '</div>';
            count++;
            if (count == 1)
                getEml("vide").classList.add("hd");
            }
        };
    xhttp.open("GET", "Enfants?num=" + num + "&action=add" + "&nom=" + nom + "&prenom=" + prenom + "&date_naissance=" + date_naissance + "&classe=" + classe + "&cne=" + cne + "&assurance=" + assurance, true);
    xhttp.send();
    return false;
}

function editEnfant(id)
{
    var ds = getElementInsideContainer(getEml("enfant_" + id), "ds");
    var edt = getElementInsideContainer(getEml("enfant_" + id), "edt");
    
    ds.classList.add("hd");
    edt.classList.remove("hd");
}

function updateEnfant(id)
{
    var ds = getElementInsideContainer(getEml("enfant_" + id), "ds");
    var edt = getElementInsideContainer(getEml("enfant_" + id), "edt");

    getElementInsideContainer(ds, "nom").innerHTML = getElementInsideContainer(edt, "prenom").value + " " + getElementInsideContainer(edt, "nom").value;
    getElementInsideContainer(ds, "cne").innerHTML = getElementInsideContainer(edt, "cne").value;
    getElementInsideContainer(ds, "date").innerHTML = getElementInsideContainer(edt, "date_naissance").value;
    getElementInsideContainer(ds, "classe").innerHTML = getElementInsideContainer(edt, "classe").value;
    getElementInsideContainer(ds, "assurance").innerHTML = getElementInsideContainer(edt, "assurance").value;
    
    edt.classList.add("hd");
    ds.classList.remove("hd");
}

function deleteEnfant(id)
{
    getEml("enfant_" + id).remove();
    count--;
    if (count <= 0)
        getEml("vide").classList.remove("hd");
    serverCall("Enfants?num=" + num + "&action=delete&id=" + id);
}