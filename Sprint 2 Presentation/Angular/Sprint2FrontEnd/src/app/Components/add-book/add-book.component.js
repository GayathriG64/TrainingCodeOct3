function validateForm() {
    let x = document.getElementById("bookauthor").value;
    const digitMatcher=/\d/
    if((x.match(digitMatcher))){
        alert("Enter text without digits");
        return false
    }
  }