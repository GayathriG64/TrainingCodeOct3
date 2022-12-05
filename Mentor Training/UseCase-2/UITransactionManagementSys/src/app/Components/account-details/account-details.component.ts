import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Customer } from 'src/app/Entity/Customer';
import { Transaction } from 'src/app/Entity/Transaction';
import { TransactionRequest } from 'src/app/Entity/TransactionRequest';
import { LoginService } from 'src/app/Service/login.service';

@Component({
  selector: 'app-account-details',
  templateUrl: './account-details.component.html',
  styleUrls: ['./account-details.component.css']
})
export class AccountDetailsComponent implements OnInit {

  constructor(private route:Router,private activatedRoute:ActivatedRoute,private service:LoginService) { }
  customer:Customer = new Customer();
  username=this.activatedRoute.snapshot.params['username'];
  response=this.activatedRoute.snapshot.params['response'];
  transactions: Transaction[]=[];
  request: TransactionRequest = new TransactionRequest();
  order:string;
  availableAmt:any;
  saveTransaction(){
    let accountId=this.customer.accountId;
    
    this.request.accountId=accountId;
    console.log(this.request)
    this.service.saveTransaction(this.request)
    .subscribe(
      (res)=>{
        let transaction :Transaction = new Transaction();
        transaction = res as Transaction;
        if(transaction.accountId==null){
          console.log(transaction)
          alert(transaction.status)
        }
        else{
        alert("sent money!")
        }
        this.route.navigate(['/account', this.username, this.response])
      }
    )
  }
  getAllTransactions(){
    this.service.getAllTransactions(this.username).subscribe(
      (response)=>{
        console.log(response)
        this.transactions = response as unknown as Transaction[];
      }
    )
    ;
  }
  updateAccount(){
    this.route.navigate(['/updateAccount',this.username,this.response]);
  }

  sortTrans(){
    if(this.order=="asc"){
      this.sortAsc();
    }
    else{
      this.sortDsc();
    }
  }

  sortAsc(){
    this.transactions.sort(
      function(t1,t2){
      if(t1.transactionDate.getTime>t2.transactionDate.getTime)
        return -1;
      else return 1;
    })
  }
  sortDsc(){
    this.transactions.sort(
      function(t1,t2){
      if(t1.transactionDate.getTime>t2.transactionDate.getTime)
        return 1;
      else return -1;
    })
  }

  logout(){
    localStorage.clear()
  }
  ngOnInit(): void {
    let cust:Customer = new Customer();
    this.service.getCustomer(this.username).subscribe(
      (response)=>{
        cust = response as Customer;
        console.log(cust.amount)
        this.availableAmt=cust.amount;
      }
    )
    
    let data =localStorage.getItem("customer");
    this.customer= JSON.parse(data);
    console.log(this.customer)
    
    if(this.customer==null){
      alert("Session expired! Please login again.")
      this.route.navigate(['login'])
    }
  }

}
