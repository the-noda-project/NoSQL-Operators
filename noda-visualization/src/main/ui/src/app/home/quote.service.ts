import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, of } from 'rxjs';
import { map, catchError } from 'rxjs/operators';

const routes = {
  quote: (c: RandomQuoteContext) => `/jokes/random?category=${c.category}`,
};

export interface RandomQuoteContext {
  // The quote's category: 'dev', 'explicit'...
  category: string;
}

@Injectable({
  providedIn: 'root',
})
export class QuoteService {
  constructor(private httpClient: HttpClient) {}

  getConnectionMessage() {
    return this.httpClient
      .get('/connection-message', { responseType: 'text' })
      .toPromise();
  }

  getNodaSTData() {
    return this.httpClient
      .get('/noda-st-timelapse', { responseType: 'text' })
      .toPromise();
  }

  getNodaSpatialData() {
    return this.httpClient
      .get('/noda-spatial', { responseType: 'text' })
      .toPromise();
  }
}
