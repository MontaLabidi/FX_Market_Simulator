import { Component, OnInit } from '@angular/core';
import { NavbarService } from '../_services';
import { User } from '../_models';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html'
})
export class NavbarComponent implements OnInit {
  currentUser: User;
  constructor( public nav: NavbarService ) {
if (!nav.show){this.currentUser = JSON.parse(localStorage.getItem('currentUser'));}

  }


  ngOnInit() {
  }

}
