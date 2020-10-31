import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root',
})
export class QueryConstructionService {
  constructor(private httpClient: HttpClient) {}

  sendQuery(query: string) {
    const body = query;
    return this.httpClient
      .post('/sql-query', body, { responseType: 'text' })
      .toPromise();
  }
}
