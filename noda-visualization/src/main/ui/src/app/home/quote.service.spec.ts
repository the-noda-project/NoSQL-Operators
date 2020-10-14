import { Type } from '@angular/core';
import { TestBed, async } from '@angular/core/testing';
import {
  HttpClientTestingModule,
  HttpTestingController,
} from '@angular/common/http/testing';

import { CoreModule } from '@core';
import { QuoteService } from './quote.service';

describe('QuoteService', () => {
  let quoteService: QuoteService;
  let httpMock: HttpTestingController;

  beforeEach(() => {
    TestBed.configureTestingModule({
      imports: [CoreModule, HttpClientTestingModule],
      providers: [QuoteService],
    });

    quoteService = TestBed.inject(QuoteService);
    httpMock = TestBed.inject(
      HttpTestingController as Type<HttpTestingController>
    );
  });

  afterEach(() => {
    httpMock.verify();
  });
});
