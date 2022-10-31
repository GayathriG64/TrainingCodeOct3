import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-pipe-demo',
  templateUrl: './pipe-demo.component.html',
  styleUrls: ['./pipe-demo.component.css']
})
export class PipeDemoComponent implements OnInit {

  employee={
    "name":'Kakashi Hatake',
    "baseSalary":"1000000",
    "joinedOn": Date.now(),
    "Qualification":"B.Tech",
    "WinningPercentage":0.956,
    "About":"Kakashi Hatake is a shinobi of Konohagakure 's Hatake clan. Famed as Kakashi of the Sharingan ( Sharingan no Kakashi ), he is one of Konoha's most talented ninja, regularly looked to for advice and leadership despite his personal dislike of responsibility"
  }
  constructor() { }

  ngOnInit(): void {
  }

}
