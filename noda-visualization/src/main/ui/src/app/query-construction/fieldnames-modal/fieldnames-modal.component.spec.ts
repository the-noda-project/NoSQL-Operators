import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { FieldnamesModalComponent } from './fieldnames-modal.component';

describe('FieldnamesModalComponent', () => {
  let component: FieldnamesModalComponent;
  let fixture: ComponentFixture<FieldnamesModalComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [FieldnamesModalComponent],
    }).compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FieldnamesModalComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
