var promise = new Promise(function (resolve,reject){
    const passingMarks = 35
    const securedMarks=100
    if(securedMarks<passingMarks)
        reject();
    else 
        resolve();
})

promise.then(function(){
    console.log("You have passed! Congratulations!!")
}).catch(function(){
    console.log("Please try again next year")
})

async function sayMyName(){
    return "async function called: sayMyName";
}
async function getUsers(){
    const response =await fetch("https://api.github.com/users")
    console.log("Before response")
    const users = await response.json()
    console.log("Users response resolved")
    return users;
}
//console.log("Before async function call")
let get = getUsers()

console.log(sayMyName())
//console.log("After async function call")
get.then(users=>console.log(users))
console.log(get)
console.log("Last logging statement")