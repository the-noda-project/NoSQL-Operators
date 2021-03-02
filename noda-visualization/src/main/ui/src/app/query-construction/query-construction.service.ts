import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root',
})
export class QueryConstructionService {
  constructor(private httpClient: HttpClient) {}

  spatialSqlQueryPost(
    query: string,
    idFieldName: string,
    locationFieldName: string
  ) {
    const body = {
      query: query,
      idFieldName: idFieldName,
      locationFieldName: locationFieldName,
    };

    return this.httpClient
      .post('/spatial-sql-query', body, { responseType: 'text' })
      .toPromise();
  }

  spatioTemporalSqlQueryPost(
    query: string,
    idFieldName: string,
    locationFieldName: string,
    timeFieldName: string
  ) {
    const body = {
      query: query,
      idFieldName: idFieldName,
      locationFieldName: locationFieldName,
      timeFieldName: timeFieldName,
    };
    return this.httpClient
      .post('/spatiotemporal-sql-query', body, { responseType: 'text' })
      .toPromise();
  }
}
