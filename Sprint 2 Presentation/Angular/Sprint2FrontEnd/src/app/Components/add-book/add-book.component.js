function validateForm() {
    let x = document.forms["myForm"]["bookauthor"].value;
    const digitMatcher=/\d/
    if((x.match(digitMatcher))){
        alert("Enter text without digits");
        return false
    }
  }