import { Currency } from ".";
import { User } from "src/app/_models/user";

export class Operation {
      id: number;
      user: User;
      currency: Currency;
      operation: String ; //either S(sell) or B (buy)
      amount:  number ;
      price: number  ;
      quote: number;
      }
