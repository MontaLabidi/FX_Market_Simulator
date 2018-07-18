import { Component, OnInit } from '@angular/core';
import { TradingViewwidget } from '../../assets/js/script';
import { NavbarService } from '../_services';

@Component({
  selector: 'app-exchange',
  templateUrl: './exchange.component.html',
  styleUrls: ['./exchange.component.css']
})
export class ExchangeComponent implements OnInit {

  constructor(private nav : NavbarService) { }

  ngOnInit() {
    this.nav.hide()
    TradingViewwidget();

  }
  // public loadScript(url: string) {
  //           let body = <HTMLDivElement> document.body;
  //           let script = document.createElement('script');
  //           script.innerHTML = '';
  //
  //           script.type="text/javascript"
  //           script.src = url;
  //         // script.async = true;
  //         // script.defer = true;
  //           body.appendChild(script);
  //   }

}
