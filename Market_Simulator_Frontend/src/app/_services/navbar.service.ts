import { Injectable } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Router } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class NavbarService {
  show: boolean = false;
    constructor(  private route: ActivatedRoute,
        private router: Router)
     { }

  hide() { this.show = false; }

  showlog() { this.show = true; }


    //   showlog() {
    //     this.router.events.subscribe((url:any) =>{
    //       if (this.router.url === '/login'){
    //
    //             this.show=true;
    //               console.log(this.show);
    //               console.log("called");
    //           }});
    //     //  console.log(this.router.url);
    // }

}
