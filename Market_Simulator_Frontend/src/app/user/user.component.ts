import { Component, OnInit } from '@angular/core';
import { User } from '../_models';
import { UserService } from '../_services';
import { NavbarService } from 'src/app/_services/navbar.service';
import { Router } from '@angular/router';
import { AuthenticationService } from 'src/app/_services/authentication.service';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit {

  user: User;
  wallet :any[];
  keys = [];
  constructor(private router: Router,
    private userService: UserService,
     public nav: NavbarService,
      private auth: AuthenticationService) {

  }

  ngOnInit() {

      this.nav.hide();
      this.user = JSON.parse(localStorage.getItem('currentUser'));
      this.wallet = JSON.parse(localStorage.getItem('currentUser')).wallet;


    //console.log(this.wallet);
    Object.keys(this.wallet).forEach(key => {
    this.keys.push(key);
    // this.wallet[key];
    // console.log('key is ' + key + ' Value is ' +   this.wallet[key] );
  });
  console.log(this.keys);

  }
  delete(user: User): void {
    if (window.confirm('Delete this Account?'))
    {    this.userService.delete(user.id)
      .subscribe( data => {
          this.auth.logout();})
        }
    else{    }


      }

  editUser(user: User): void {
    localStorage.removeItem("currentUser");
    localStorage.setItem("currentUser", JSON.stringify(user));
    this.router.navigate(['editUser']);
  };


}
