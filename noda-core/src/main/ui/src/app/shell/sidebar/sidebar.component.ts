import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-sidebar',
  templateUrl: './sidebar.component.html',
  styleUrls: ['./sidebar.component.scss'],
})
export class SidebarComponent implements OnInit {
  navigationRoutes = [
    {
      routeName: 'Main',
      routeLink: '',
    },
    {
      routeName: 'Map Tracking',
      routeLink: '/mapbox-map',
    },
    {
      routeName: 'DropDown',
      routeLink: '/dropdown',
    },
  ];

  constructor() {}

  ngOnInit() {}
}
