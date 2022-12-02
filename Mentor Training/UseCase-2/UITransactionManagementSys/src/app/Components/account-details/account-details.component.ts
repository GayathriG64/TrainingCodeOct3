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
  saveTransaction(){
    let accountId=this.customer.accountId;
    
    this.request.accountId=accountId;
    console.log(this.request)
    this.service.saveTransaction(this.request)
    .subscribe(
      (res)=>{
        let transaction :Transaction = new Transaction();
        transaction = res as Transaction;
        if(transaction.accountId==null)
          alert(transaction.message)
        alert("sent money!")
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

  ngOnInit(): void {
    this.service.getCustomer(this.username).subscribe(
      (response)=>{
        //console.log(response)
        this.customer = response as Customer;
        console.log(this.customer.accountId)
      }
    )

  }

}
