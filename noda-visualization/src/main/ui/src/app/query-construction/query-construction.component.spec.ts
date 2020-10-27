import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { QueryConstructionComponent } from './query-construction.component';

describe('QueryConstructionComponent', () => {
  let component: QueryConstructionComponent;
  let fixture: ComponentFixture<QueryConstructionComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [QueryConstructionComponent],
    }).compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(QueryConstructionComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
