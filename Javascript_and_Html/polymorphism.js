class Animal{
    constructor(name){
        this.name=name
    }
    eats(){
        console.log(this.name+" eats food")
    }

}
class Lion extends Animal{
    eats(){
        console.log(this.name+" eats meat")
    }
}

let John = new Lion("John")
John.eats()