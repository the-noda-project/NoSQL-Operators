import { Component, OnInit } from '@angular/core';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { FieldnamesModalComponent } from './fieldnames-modal/fieldnames-modal.component';

@Component({
  selector: 'app-query-construction',
  templateUrl: './query-construction.component.html',
  styleUrls: ['./query-construction.component.scss'],
})
export class QueryConstructionComponent implements OnInit {
  query: string;

  constructor(private modal: NgbModal) {}

  ngOnInit(): void {}

  openModal(selsectedCase: string) {
    if (this.query) {
      const x = this.modal.open(FieldnamesModalComponent);
      x.componentInstance.ref = x;
      x.componentInstance.case = selsectedCase;
      x.componentInstance.query = this.query;
    } else {
      alert('You must write a query first');
    }
  }
}
