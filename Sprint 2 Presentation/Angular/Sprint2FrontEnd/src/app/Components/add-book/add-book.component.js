function validateForm() {
    let x = document.forms["myform"]["bookauthor"].value;
    const digitMatcher=/\d/
    if((x.match(digitMatcher))){
        alert("Enter text without digits");
        return false
    }
  }