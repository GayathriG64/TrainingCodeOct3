import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Loan } from 'src/app/Entity/Loan';
import { LoginService } from 'src/app/Service/login.service';

@Component({
  selector: 'app-account-details',
  templateUrl: './account-details.component.html',
  styleUrls: ['./account-details.component.css']
})
export class AccountDetailsComponent implements OnInit {

  constructor(private activatedRoute:ActivatedRoute,private service:LoginService) { }

  username=this.activatedRoute.snapshot.params['username'];
  accountId=this.activatedRoute.snapshot.params['response'];
  allLoans:Loan[]=[];
  applyLoan(){

  }

  getMyLoans(){
    console.log(this.username);
    this.service.getMyLoans(this.username).subscribe(
      (response)=>{
        console.log(response)
        this.allLoans= response as Loan[];
        console.log(this.allLoans)
      }
    )
  }
  ngOnInit(): void {
  }

}
