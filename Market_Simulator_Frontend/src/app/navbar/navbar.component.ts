import { Component, OnInit } from '@angular/core';
import { NavbarService } from '../_services';
import { User } from '../_models';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html'
})
export class NavbarComponent implements OnInit {
  
  constructor( private nav: NavbarService ) {


  }


  ngOnInit() {

  }

}
