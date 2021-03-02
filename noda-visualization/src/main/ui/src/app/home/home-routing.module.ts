import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomeComponent } from './home.component';
import { Shell } from '@app/shell/shell.service';

const routes: Routes = [
  { path: '', redirectTo: '/', pathMatch: 'full' },
  Shell.childRoutes([
    {
      path: '',
      component: HomeComponent,
      // data: { title: extract('Home') },
    },
  ]),

  // { path: 'visualization/:case', component: HomeComponent },
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
  providers: [],
})
export class HomeRoutingModule {}
