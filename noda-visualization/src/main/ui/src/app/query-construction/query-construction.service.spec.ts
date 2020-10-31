import { TestBed } from '@angular/core/testing';

import { QueryConstructionService } from './query-construction.service';

describe('QueryConstructionService', () => {
  let service: QueryConstructionService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(QueryConstructionService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
