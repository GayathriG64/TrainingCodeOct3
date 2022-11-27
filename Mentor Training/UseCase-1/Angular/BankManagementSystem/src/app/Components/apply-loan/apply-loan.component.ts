import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Loan } from 'src/app/Entity/Loan';
import { LoanApplyRequest } from 'src/app/Entity/LoanApplyRequest';
import { LoginService } from 'src/app/Service/login.service';

@Component({
  selector: 'app-apply-loan',
  templateUrl: './apply-loan.component.html',
  styleUrls: ['./apply-loan.component.css']
})
export class ApplyLoanComponent implements OnInit {

  constructor(private loginService:LoginService,private activatedRoute:ActivatedRoute) { }
  loan:Loan=new Loan();
  username= this.activatedRoute.snapshot.params['username'];
  applyLoanRequest:LoanApplyRequest= new LoanApplyRequest();
  applyLoan(){
    this.loginService.applyLoan(this.applyLoanRequest,this.username).subscribe(
      (response)=>{
        console.log(response);
        this.loan = response as Loan
        alert("Loan applied and here is the loanId:"+this.loan.loanId)
      }
    )
  }
  ngOnInit(): void {
  }

}
