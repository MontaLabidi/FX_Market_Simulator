import { Component, OnInit } from '@angular/core';
import { User } from '../_models';
import { FormGroup } from '@angular/forms';
import { FormBuilder } from '@angular/forms';
import { Router } from '@angular/router';
import { UserService } from '../_services';
import { Validators } from '@angular/forms';
import { first } from 'rxjs/internal/operators/first';
import { AlertService } from 'src/app/_services/alert.service';

@Component({
  selector: 'app-edit-user',
  templateUrl: './edit-user.component.html',
  styleUrls: ['./edit-user.component.css']
})
export class EditUserComponent implements OnInit {
  loading = false;
  submitted = false;
  user: User;
  EditForm: FormGroup;
  constructor(private formBuilder: FormBuilder,
              private router: Router,
              private userService: UserService,
              private alertService: AlertService) { }


  ngOnInit() {
    this.user= JSON.parse(localStorage.getItem('currentUser'));
      this.EditForm = this.formBuilder.group({
        id:[''],
        firstName: ['', Validators.required],
        lastName: ['', Validators.required],
        username: ['', [Validators.required, Validators.minLength(3)]],
        email: ['', Validators.required],
        password: ['', [Validators.required, Validators.minLength(6),Validators.maxLength(20)]]
    });
    this.userService.getById(+this.user.id)
      .subscribe( data => {
        this.EditForm.setValue(data);
      });
    }
    // convenience getter for easy access to form fields
    get f() { return this.EditForm.controls; }
    onSubmit() {
        this.submitted = true;

        // stop here if form is invalid
        if (this.EditForm.invalid) {
            return;
        }

        this.loading = true;
        this.userService.update(this.EditForm.value)
        .subscribe(
                data => {
                    this.alertService.success('Update successful', true);
                    this.router.navigate(['/login']);
                },
                error => {
                    this.alertService.error(error);
                    this.loading = false;
                });
    }


}
