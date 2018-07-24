import { NgModule }      from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { ReactiveFormsModule }    from '@angular/forms';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';

import { AppComponent }  from './app.component';
import { routing }        from './app.routing';

import { AlertComponent } from './_directives';
import { AuthGuard } from './_guards';
import { JwtInterceptor, ErrorInterceptor } from './_helpers';
import { AlertService, AuthenticationService, UserService } from './_services';
import { HomeComponent } from './home';
import { LoginComponent } from './login';
import { RegisterComponent } from './register';
import { NavbarComponent } from './navbar/navbar.component';
import { UserComponent } from './user/user.component';
import { ExchangeComponent } from './exchange/exchange.component';
import { EditUserComponent } from './edit-user/edit-user.component';
import { CurrencyService } from './_services/currency.service';
import { OperationService } from './_services/operation.service';
import { ActivityComponent } from './activity/activity.component';
@NgModule({
    imports: [
        BrowserModule,
        ReactiveFormsModule,
        HttpClientModule,
        routing
    ],
    declarations: [
        AppComponent,
        AlertComponent,
        HomeComponent,
        LoginComponent,
        RegisterComponent,
          NavbarComponent ,
          UserComponent ,
          ExchangeComponent ,
          EditUserComponent,
            ActivityComponent

          ],



    providers: [
        AuthGuard,
        AlertService,
        AuthenticationService,
        UserService,
        CurrencyService,
        OperationService,
        { provide: HTTP_INTERCEPTORS, useClass: JwtInterceptor, multi: true },
        { provide: HTTP_INTERCEPTORS, useClass: ErrorInterceptor, multi: true },


    ],
    bootstrap: [AppComponent]
})

export class AppModule { }
