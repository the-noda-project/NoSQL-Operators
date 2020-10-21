import { Component, Input, OnInit } from '@angular/core';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';

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

  constructor(private modal: NgbModal) {}

  ngOnInit(): void {
    console.log('The case is: ', this.case);
    console.log('The query is: ', this.query);
  }

  closeModal() {
    this.modal.dismissAll();
  }
}
