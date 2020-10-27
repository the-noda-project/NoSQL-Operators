import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { QueryConstructionComponent } from './query-construction.component';

const routes: Routes = [{ path: '', component: QueryConstructionComponent }];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class QueryConstructionRoutingModule {}
