let st="A stri ng with sp aces"
console.log(clearSpaces(st))
function clearSpaces(str){
    let final=""
    final= str.replace(/\s/g,'')
    return final
}