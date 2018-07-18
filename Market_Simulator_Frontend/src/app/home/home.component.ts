import { Component, OnInit } from '@angular/core';
import { first } from 'rxjs/operators';

import { User } from '../_models';
import { UserService } from '../_services';
import { NavbarService } from 'src/app/_services/navbar.service';

@Component({
selector: 'app-home',
templateUrl: 'home.component.html',
styleUrls: ['./home.component.css']})
export class HomeComponent implements OnInit {
    currentUser: User;

    constructor(public nav: NavbarService) {
        this.currentUser = JSON.parse(localStorage.getItem('currentUser'));
    }

    ngOnInit() {
      if (this.currentUser)
        this.nav.hide();

    }

    // deleteUser(id: number) {
    //   console.log(id)
    //     this.userService.delete(id).pipe(first()).subscribe(() => {
    //         this.loadAllUsers()
    //     });
    // }
    //
    // private loadAllUsers() {
    //     this.userService.getAll().pipe(first()).subscribe(users => {
    //
    //     });
    // }
}
