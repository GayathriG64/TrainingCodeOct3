import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-book-contents',
  templateUrl: './book-contents.component.html',
  styleUrls: ['./book-contents.component.css']
})
export class BookContentsComponent implements OnInit {

  content = this.route.snapshot.params['content']
  authorId=this.route.snapshot.params['authorId']
  constructor(private route: ActivatedRoute,private router:Router) { }
  goBack(){
    this.router.navigate(['/authorbooks',this.authorId])
  }
  ngOnInit(): void {
  }

}
