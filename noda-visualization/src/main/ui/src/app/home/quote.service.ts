import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { ReplaySubject } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class QuoteService {
  dataFromServer: string;

  constructor(private httpClient: HttpClient) {}

  updateData(data: string) {
    this.dataFromServer = data;
  }

  getData() {
    return this.dataFromServer;
  }

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
