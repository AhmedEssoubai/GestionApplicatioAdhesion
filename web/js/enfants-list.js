var count = 0;
var id = 0;
var updating = 0;

function addEnfant()
{
    var nom = getElementInsideContainer(getEml("new"), "nom").value;
    var prenom = getElementInsideContainer(getEml("new"), "prenom").value;
    var cne = getElementInsideContainer(getEml("new"), "cne").value;
    var date_naissance = getElementInsideContainer(getEml("new"), "date_naissance").value;
    var classe = getElementInsideContainer(getEml("new"), "classe").value;
    var assurance = getElementInsideContainer(getEml("new"), "assurance").value;
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
                            '<div class="mx-3 icon-g"><a title="Editer" onclick="editEnfant(' + id + ')"><span><i class="fas fa-pen"></i></span></a></div>' + 
                            '<div class="mx-3 icon-r"><a title="Supprimer" onclick="deleteEnfant(' + id + ')" role="button"><span><i class="fa fa-times"></i></span></a></div>' + 
                        '</div>' + 
                    '</div>' + 
                    '<div id="edt" class="container px-0 hd">' + 
                        '<div class="row my-3">' + 
                            '<div class="col-md-5 pr-1">' + 
                                '<input id="prenom" type="text" class="form-control" placeholder="Prenom" value="' + prenom + '" required />' + 
                            '</div>' + 
                        '<div class="col-md-5 pr-4">' + 
                            '<input id="nom" type="text" class="form-control" placeholder="Nom" value="' + nom + '" required />' + 
                        '</div>' + 
                        '<div class="col-md-2">' + 
                            '<input id="cne" type="text" class="form-control" placeholder="CNE" value="' + cne + '" required />' + 
                        '</div>' + 
                    '</div>' + 
                    '<div class="row my-3">' + 
                        '<div class="col">' + 
                            '<input id="date_naissance" class="form-control my-3" type="date" placeholder="Date de naissance" value="' + date_naissance + '" required />' + 
                            '<select id="classe" class="custom-select my-3" placeholder="Classe" required>' + 
                                '<option value="Primaire" ' + (classe == 'Primaire' ? 'selected' : '') + '>Primaire</option>' + 
                                '<option value="Collège" ' + (classe == 'Collège' ? 'selected' : '') + '>Collège</option>' + 
                                '<option value="Lycée" ' + (classe == 'Lycée' ? 'selected' : '') + '>Lycée</option>' + 
                            '</select>' + 
                            '<select id="assurance" class="custom-select my-3" placeholder="Assurance" onchange="onAssuranceChanged(' + id + ')" required>' + 
                                '<option value="Assurance Hospitalisation/Soins de santé" ' + (assurance == 'Assurance Hospitalisation/Soins de santé' ? 'selected' : '') + '>Assurance Hospitalisation/Soins de santé</option>' + 
                                '<option value="Assurance Individuelle Accident" ' + (assurance == 'Assurance Individuelle Accident' ? 'selected' : '') + '>Assurance Individuelle Accident</option>' + 
                            '</select>' + 
                            '<div class="custom-control custom-checkbox my-3">' + 
                                '<input class="custom-control-input" type="checkbox" id="accepter_' + id + '" checked onchange="onAccepterChanged(' + id + ')">' + 
                                '<label class="custom-control-label" for="accepter_' + id + '">' + 
                                    "J'ai lu et j'accepte les conditions de l'assurance" + 
                                '</label>' + 
                            '</div>' + 
                            '<div class="mt-4 d-flex justify-content-end">' + 
                                '<button id="btn_update" type="button" onclick="updateEnfant(' + id + ')" class="btn btn-primary px-5">Mise à jour</button>' + 
                            '</div>' + 
                        '</div>' + 
                    '</div>' + 
                '</div>' + 
            '</div>' + 
        '</div>';
    count++;
    id++;
    if (count == 1)
    {
        getEml("vide").classList.add("hd");
        if (updating == 0)
            getEml("envoyer").disabled = false;
    }
    return false;
}

function editEnfant(id)
{
    var ds = getElementInsideContainer(getEml("enfant_" + id), "ds");
    var edt = getElementInsideContainer(getEml("enfant_" + id), "edt");
    
    ds.classList.add("hd");
    edt.classList.remove("hd");

    updating++;
    if (updating == 1)
        getEml("envoyer").disabled = true;
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

    updating--;
    if (updating == 0)
        getEml("envoyer").disabled = false;
}

function deleteEnfant(id)
{
    getEml("enfant_" + id).remove();
    count--;
    if (count <= 0)
    {
        getEml("vide").classList.remove("hd");
        getEml("envoyer").disabled = true;
    }
}

function onAccepterChanged(id)
{
    if (id >= 0)
        getElementInsideContainer(getEml("enfant_" + id), "btn_update").disabled = !getEml("accepter_" + id).checked;
    else
        getEml("btn_add").disabled = !getEml("accepter").checked;
    console.log(id);
}

function onAssuranceChanged(id)
{
    if (id >= 0)
    {
        var edt = getElementInsideContainer(getEml("enfant_" + id), "edt");
        getEml("accepter_" + id).checked = false;
        getElementInsideContainer(edt, "btn_update").disabled = true;
    }
    else
    {
        getEml("accepter").checked = false;
        getEml("btn_add").disabled = true;
    }
    console.log(id);
}

function canSubmit()
{
    return count > 0 && updating == 0;
}