let name = 'GayathriG';
let age = 65;
console.log(name + " - " + age);
{
    var x = 'var22';
    let y = 'let33';
    const z = 'const44';

    function operators() {
        var varTest = 'varTest22';
        let a = 6000;
        var b = 10;
        console.log("Adding: " + a + b);
        console.log("Multiplying: " + a * b);
        console.log("Dividing: " + a / b);
        console.log("Mod value: " + a % b);

    }
}
operators();
console.log(x); // we can access             - var scope is anywhere   - rarely used
//console.log(varTest);// can't access this  - var is defined in func  - rarely used 
//console.log(y); // can't access this       - let is block scoped     - used
//console.log(z); // can't access this       - const is block scoped   - mostly used(since we can't change the value once assigned)
let inc = 555;
console.log(inc++);
console.log(++inc);
console.log(inc--);
console.log(--inc);

let c1 = 10;
let c2;
//alert(!c2);
//alert(15 && 10);  // gives last value
//alert (88 || 10 || 100); // gives first value
//alert(true || false );
console.log("hey" && "hi");

const names = ["Gayathri", "chinnu", "nami"];
names[0] = 'g3'
console.log(names);
const arr = [];
arr[0] = "zero"
arr[1] = 12
console.log(arr);

const moreNames = [...names, "janu"];
console.log(moreNames)

const marks = [45, 55, 65, 75, 35];
let maxMark = Math.max(...marks);
console.log(maxMark);

const studMap = new Map([
    ["Gayathri", 01],
    ["Jahnavi", 02],
    ["Chinnu", 03],
    [04, "janu"]
])

console.log(studMap);
studMap.set(05, "John");
console.log(studMap);
studMap.delete(05); // studMap.size // studMap.clear(); // studMap.get("key"); // studMap.has("key")

for (let i = 0; i < moreNames.length; i++) {
    console.log(moreNames[i]);
}

if (moreNames.length > 10)
    console.log("We have more than 10 in moreNames");
else if (moreNames.length == 10)
    console.log("We have 10 in moreNames");
else
    console.log("We have less than 10 in moreNames");

switch(moreNames.length){
case 0: console.log("no names")
break;
case 1: console.log("1 name")
break;
case 2: console.log("2 names")
break;
case 3: console.log("3 names")
break;
case 4: console.log("4 names")
break;
case 5: console.log("5 names")
break;
}

function Area(l,b){
    console.log("Area: "+l*b);
    return l*b;
}

arrowArea= (l,b) => {
    console.log("arrowArea: "+l*b);
    return l*b;
}

Area(1,111)
arrowArea(1,222)

const set1 = new Set([1,2,3,4,5,1]);
console.log(set1);

set1.add(22);
let adder=100
set1.forEach(
    function(value){
        adder+=value
    }
)
console.log(set1)

const mapEmp = new Map([
    ["Emp1",111],
    ["Emp2",112],
    ["Emp3",113],
    ["Emp4",114],
    ["Emp5",115]
])
console.log(mapEmp);
const setEmpID= new Set([
    111,112,113,114,115
])
console.log(setEmpID);

var promise = new Promise(function (resolve,reject){
    const passingMarks = 35
    const securedMarks=99
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
