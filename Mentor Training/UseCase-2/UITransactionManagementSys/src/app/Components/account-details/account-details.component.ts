import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
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

  username=this.activatedRoute.snapshot.params['username'];
  accountId=this.activatedRoute.snapshot.params['response'];
  transactions: Transaction[] = [];
  request: TransactionRequest = new TransactionRequest();
  saveTransaction(){
    
  }
  updateAccount(){
    let response= this.accountId;
    this.route.navigate(['/updateAccount',this.username]);
  }
  ngOnInit(): void {
  }

}
