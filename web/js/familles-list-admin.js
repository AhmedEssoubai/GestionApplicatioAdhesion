var count = 0;

function deleteEnfant(id)
{
    getEml("famille_" + id).remove();
    count--;
    if (count <= 0)
        getEml("vide").classList.remove("hd");
    serverCall("Familles?action=delete&id=" + id);
}