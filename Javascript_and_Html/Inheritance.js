class Car{
    setName(name){
        this.name=name;
        console.log(name)
    }
    drive(){
        console.log("Now driving: "+ this.name)
    }
    stop(){
        console.log("Now stopping:"+ this.name)
    }
}

class Mercedes extends Car{
    driver(driverName){
        console.log("Mercedes is driven by:  "+ driverName);
    }
}

let w13= new Mercedes()
w13.setName("F1 car")
w13.drive()
w13.stop()
w13.driver("GayathriG")
