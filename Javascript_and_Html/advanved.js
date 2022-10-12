class Employee{
    setEmployee(name,id,position){
        this.name=name
        this.id=id
        this.position= position
    }
    getEmployeeName(){
        return this.name
    }
    getEmployeeId(){
        return this.id
    }
    getEmployeePosition(){
        return this.position
    }
}

let emp1 = new Employee()
let emp2 = new Employee()
emp1.setEmployee("Gayathri",100,"SrDev")
emp2.setEmployee("GayathriG",101,"JrDev")
console.log(emp1.getEmployeeName())
console.log(emp2.getEmployeeId())