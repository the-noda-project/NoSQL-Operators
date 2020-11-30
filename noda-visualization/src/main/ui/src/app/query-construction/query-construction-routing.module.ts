import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { Shell } from '@app/shell/shell.service';
import { QueryConstructionComponent } from './query-construction.component';

const routes: Routes = [
  Shell.childRoutes([
    {
      path: 'dbtype/:dbType',
      component: QueryConstructionComponent,
      // data: { title: extract('Home') },
    },
  ]),
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class QueryConstructionRoutingModule {}
