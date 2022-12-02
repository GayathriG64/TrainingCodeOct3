import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Customer } from 'src/app/Entity/Customer';
import { UpdateRequest } from 'src/app/Entity/UpdateRequest';
import { LoginService } from 'src/app/Service/login.service';

@Component({
  selector: 'app-update-account',
  templateUrl: './update-account.component.html',
  styleUrls: ['./update-account.component.css']
})
export class UpdateAccountComponent implements OnInit {

  constructor(private router:Router,private activatedRoute:ActivatedRoute, private service:LoginService) { }
  username = this.activatedRoute.snapshot.params['username'];
  response = this.activatedRoute.snapshot.params['response'];
  request : UpdateRequest = new UpdateRequest();
  goback(){
    //this.router.navigate(['account',,]);
    alert("goin back");
    this.router.navigate(['account',this.username,this.response]);
    
  }
  updateAccount(){
    this.request.name= this.customer.name;
        this.request.address= this.customer.address;
        this.request.state= this.customer.state;
        this.request.country = this.customer.country;
        this.request.email= this.customer.email;
        this.request.phoneNo= this.customer.phoneNo;
        console.log(this.customer.name);
    this.service.updateAccount(this.username,this.request).subscribe(
      (res)=>{
        console.log(res)
        alert("Your details were updated successfully!")
        this.router.navigate(['account',this.username,this.response]);
      }, function(error){
        console.log(error);
        alert("Something wrong.Please try again")
      }
    )
  }
  //customer:any;
  userdata:any;
  customer:Customer = new Customer();
  ngOnInit(): void {
    this.service.getCustomer(this.username).subscribe(
      (response)=>{
        //console.log(response)
        this.customer = response as Customer;
        console.log(this.customer)
      }
    )
  }

}
