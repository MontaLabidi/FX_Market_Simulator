import { Component, OnInit } from '@angular/core';
import { OperationService } from '../_services/operation.service';
import { NavbarService } from '../_services';
import { User } from '../_models';
import { Operation } from 'src/app/_models/Operation';

@Component({
  selector: 'app-activity',
  templateUrl: './activity.component.html',
  styleUrls: ['./activity.component.css']
})
export class ActivityComponent implements OnInit {
  user: User;
  public operations: Operation[];
  constructor(
    private nav : NavbarService,
    private operationService:OperationService
  ) { }
    ngOnInit() {
  this.nav.hide();
  this.user = JSON.parse(localStorage.getItem('currentUser'));
  this.operationService.getAllByUser(this.user.id).subscribe(data=>
  this.operations=data
  );


  }

}
