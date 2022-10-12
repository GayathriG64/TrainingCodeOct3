function Employee(name,age,salary){
    this.name=name
    this.age=age
    this.salary=salary
    this.bonus=10000
    this.getEmployeeDetails = function(){
        console.log('Name: '+ this.name+", Age: "+this.age+", Salary: "+this.salary)
    }

    this.calculateFinalSalary= function(){
        let finalSalary= this.salary+this.bonus
        console.log("Final Salary is: "+finalSalary)
    }
}

let emp1=new Employee("Gayathri",25,30000)
emp1.getEmployeeDetails()
emp1.calculateFinalSalary()