import { Component, OnInit } from '@angular/core';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { FieldnamesModalComponent } from './fieldnames-modal/fieldnames-modal.component';
import { QueryConstructionService } from './query-construction.service';

@Component({
  selector: 'app-query-construction',
  templateUrl: './query-construction.component.html',
  styleUrls: ['./query-construction.component.scss'],
})
export class QueryConstructionComponent implements OnInit {
  query: string;

  constructor(
    private modal: NgbModal,
    private queryConstructionServ: QueryConstructionService
  ) {}

  ngOnInit(): void {}

  runpost() {
    this.queryConstructionServ
      .sendQuery(this.query)
      .then((res) => {
        console.log(res);
      })
      .catch((err) => {
        console.log(err);
      });
  }

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
