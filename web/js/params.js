function checkForm()
{
    if (getEml("new_pwd").value != "")
        return getEml("new_pwd").value.length > 5 && getEml("new_pwd").value == getEml("conf_pwd").value;
    return true;
}


