import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { UpdateRequest } from 'src/app/Entity/updateRequest';
import { LoginService } from 'src/app/Service/login.service';

@Component({
  selector: 'app-update-account',
  templateUrl: './update-account.component.html',
  styleUrls: ['./update-account.component.css']
})
export class UpdateAccountComponent implements OnInit {

  constructor(private route:Router,private activatedRoute:ActivatedRoute, private service:LoginService) { }
  username = this.activatedRoute.snapshot.params['username'];
  response = this.activatedRoute.snapshot.params['response'];
  request : UpdateRequest = new UpdateRequest();
  goback(){
    this.route.navigate(['account/:username/:response']);
  }
  updateAccount(){
    this.service.updateAccount(this.username,this.request).subscribe(
      (res)=>{
        console.log("RESPONSE: "+res)
        if(res !=""){
        let name =res as string;
        alert(name+" Your details were updated successfully!")
        }
      }
    )
  }
  ngOnInit(): void {
  }

}
