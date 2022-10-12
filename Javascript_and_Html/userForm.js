function blurEvent(){
    let displayText = document.getElementById("name");
    displayText.value = displayText.value.toUpperCase()
}

function OnChangeEvent(){
    let food = document.getElementById("food").value;
    document.getElementById("para").innerHTML="You have selected: "+ food;
}

function onFocusEvent(id){
    document.getElementById(id).style.background="green"
}