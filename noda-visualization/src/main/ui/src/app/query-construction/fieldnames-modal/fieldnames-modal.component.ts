import { Component, Input, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { QuoteService } from '@app/home/quote.service';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { QueryConstructionService } from '../query-construction.service';

@Component({
  selector: 'app-fieldnames-modal',
  templateUrl: './fieldnames-modal.component.html',
  styleUrls: ['./fieldnames-modal.component.scss'],
})
export class FieldnamesModalComponent implements OnInit {
  @Input()
  case: string;

  @Input()
  query: string;

  objectIdFieldName: string;
  objectLocationFieldName: string;
  objectTimeFieldName: string;
  isLoading = false;

  constructor(
    private modal: NgbModal,
    private router: Router,
    private quoteService: QuoteService,
    private queryConstructionServ: QueryConstructionService
  ) {}

  ngOnInit(): void {
    console.log('The case is: ', this.case);
    console.log('The query is: ', this.query);
  }

  runSpatialQuery() {
    this.isLoading = true;
    this.queryConstructionServ
      .spatialSqlQueryPost(
        this.query,
        this.objectIdFieldName,
        this.objectLocationFieldName
      )
      .then((res) => {
        console.log(res);
        const data = JSON.parse(res);
        if (data['status'] === 'ok') {
          this.isLoading = false;
          this.quoteService.updateData(res);
          this.modal.dismissAll();
          this.router.navigate(['/visualization/' + 'spatial']);
        } else {
          alert('Κάτι δεν πήγε καλά');
        }
      })
      .catch((err) => {
        this.isLoading = false;
        console.log(err);
      });
  }

  runSpatioTemporalQuery() {
    this.isLoading = true;
    this.queryConstructionServ
      .spatioTemporalSqlQueryPost(
        this.query,
        this.objectIdFieldName,
        this.objectLocationFieldName,
        this.objectTimeFieldName
      )
      .then((res) => {
        console.log(res);
        const data = JSON.parse(res);
        if (data['status'] === 'ok') {
          this.isLoading = false;
          this.quoteService.updateData(res);
          this.modal.dismissAll();
          this.router.navigate(['/visualization/' + 'spatiotemporal']);
        } else {
          alert('Κάτι δεν πήγε καλά');
        }
      })
      .catch((err) => {
        this.isLoading = false;
        console.log(err);
      });
  }

  closeModal() {
    this.modal.dismissAll();
  }
}
