let arr=[11,2,33,4,-5]
let revArr=[];
console.log("OriginalArray: "+ arr)

for(let i= arr.length-1 ;i>=0; i--){
    revArr=[...revArr,arr[i]]
}
console.log("ReverseArray: "+revArr)

arr.sort(function(a,b){
    return a-b;
})
console.log("SortedArray: "+arr)

let positiveArr=[];
for(let j= 0;j<arr.length; j++){
    if(arr[j]>0)
    positiveArr=[...positiveArr,arr[j]]
}
console.log("PositiveArray: "+positiveArr)
//
let sum=0
for(let i= arr.length-1 ;i>=0; i--){
   sum=sum+arr[i]
}
console.log("Sum: "+sum)

function isDivisibleByTen(num){
    if(num%10==0)
     return true;
     else 
     return false
}
console.log(isDivisibleByTen(30))
