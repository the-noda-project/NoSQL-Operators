import { Component, OnInit } from '@angular/core';

import { QuoteService } from './quote.service';
import { themeFromMapBox } from '../shell/shell.service';
import * as L from 'leaflet';
import { Options } from 'ng5-slider';
import * as _ from 'lodash';

import 'leaflet/dist/images/marker-icon.png';
import 'leaflet/dist/images/marker-icon-2x.png';
import 'leaflet/dist/images/marker-shadow.png';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss'],
})
export class HomeComponent implements OnInit {
  chosenDatabaseStore: string;

  dataFromServer: string;
  data: Array<any> = [];
  groupedData: any;
  idArray: Array<any> = [];
  isSpatial = false;

  changeFloor: boolean;
  changeCeil: boolean;
  fps: number;
  addTime: number;
  windowBetweenFloorAndCeil: number;

  activeArray: Array<any> = [];

  value: number = 5;
  maxValue: number = 8;

  opt: Options = {
    floor: 0,
    ceil: 10,
  };
  map: L.Map;
  layers: Array<any> = [];
  options = {
    layers: [L.tileLayer(themeFromMapBox, { maxZoom: 18, attribution: '...' })],
    zoom: 4,
    center: L.latLng(33.88889, -118.48143),
  };

  constructor(
    private quoteService: QuoteService,
    private router: Router
  ) {}

  ngOnInit() {
 

    // Responce for noda server connection
    this.quoteService.getConnectionMessage().then((res: any) => {
      console.log(res);
    });


  }

  goToVisualization() {
    if (
      this.chosenDatabaseStore === 'mongodb' ||
      this.chosenDatabaseStore === 'neo4j' ||
      this.chosenDatabaseStore === 'hbase' ||
      this.chosenDatabaseStore === 'redis'
    ) {
      this.router.navigate([
        '/visualization/dbtype/' + this.chosenDatabaseStore,
      ]);
    } else {
      alert('Please choose a database first to continue.');
    }
  }

  chooseDatabaseStore(dbName: string) {
    this.chosenDatabaseStore = dbName;
  }
}
