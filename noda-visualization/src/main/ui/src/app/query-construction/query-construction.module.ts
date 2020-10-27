import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { QueryConstructionRoutingModule } from './query-construction-routing.module';
import { QueryConstructionComponent } from './query-construction.component';
import { FieldnamesModalComponent } from './fieldnames-modal/fieldnames-modal.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

@NgModule({
  declarations: [QueryConstructionComponent, FieldnamesModalComponent],
  imports: [
    CommonModule,
    ReactiveFormsModule,
    FormsModule,
    QueryConstructionRoutingModule,
  ],
})
export class QueryConstructionModule {}
