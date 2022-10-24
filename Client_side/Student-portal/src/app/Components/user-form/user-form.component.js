function phoneNumVal(){
    let phoneNum = document.getElementById("mobileNumber");
    const matcher= /^\d{10}$/
    if(!(phoneNum.value.match(matcher)))
        alert("Enter a valid phone number");
    
}
function genderVal(){
    let gender = document.getElementById("gender");
    if(!(gender.value=="Male" || gender.value=="Female")){
        alert("Enter Male or Female");
        return false
    }
}
function textVal(id){
    let text = document.getElementById(id);
    if(text.value==""){
        alert("This field can't be empty")
        return false
    }
    const digitMatcher=/\d/
    if((text.value.match(digitMatcher))){
        alert("Enter text without digits");
        return false
    }
}
function idVal(){
    idNum=document.getElementById("idNumber")
    const digitMatcher=/\d/
    if(!(idNum.value.match(digitMatcher))){
        alert("Enter only digits");
        return false
    }
}
 function emailVal(){
     const email= document.getElementById("email");
     const at ="@"
     const dot="."
     const i= email.value.indexOf(at)
     const j =  email.value.lastIndexOf(dot)
     if(i<1 ){
        alert("Enter valid email")
        return false
     }
     if(j-i!=6){
        alert("Enter valid email: ending with @gmail.com")
        return false
     }
}

function dateVal(id){
    const dateValue= document.getElementById(id).value
    dateMatcher= /^(0[1-9]|1[0-2])\/(0[1-9]|1\d|2\d|3[0-1])\/([0-2][0-9][0-9][0-9])/
    /*(0[1-9]|1[0-9]|2[0-9]) */
    if(!(dateValue.match(dateMatcher)) || dateValue.length!= 10)
        alert("Enter valid date in mm/dd/yyyy format.")
    return false
}
/*
function printName(){
        const name = localStorage.fullNameInForm.value
        document.getElementById("para").innerHTML= name+"! Your submission has been sent."
    
}
function saveName()
{
    if(typeof(localStorage)!="undefined")
    localStorage.fullNameInForm = document.getElementById("fullName").value
}
 */
function formCheck(){
    const fullName= document.getElementById("fullName")
    const email=document.getElementById("email")
    const idNum=document.getElementById("idNumber")
    console.log(fullName)
    console.log(email)
    console.log(idNum)
}
