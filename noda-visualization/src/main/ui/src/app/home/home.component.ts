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
    private router: Router,
    private activeRoute: ActivatedRoute
  ) {}

  ngOnInit() {
    // this.fps = 0.2;
    // this.windowBetweenFloorAndCeil = 3;
    // this.changeFloor = false;
    // this.changeCeil = false;

    // this.activeRoute.paramMap.subscribe((params: any) => {
    //   const caseOfView = params.get('case');
    //   if (caseOfView === 'spatial') {
    //     this.isSpatial = true;
    //   }
    //   if (caseOfView === 'spatiotemporal') {
    //     this.isSpatial = false;
    //   }
    // });

    // Responce for noda server connection
    this.quoteService.getConnectionMessage().then((res: any) => {
      console.log(res);
    });

    // if (this.isSpatial === false) {
    //   let parsedData = JSON.parse(this.dataFromServer);
    //   this.data = parsedData['data'];

    //   // JS Date needs milli Epoch Timestamp (so below is a milli epoch converter)
    //   console.log(
    //     this.data,
    //     'ayto einai ena date: ' +
    //       new Date(parseInt(this.timestampManipulation(this.data[0]['time'])))
    //   );

    //   this.opt = {
    //     floor: parseInt(this.timestampManipulation(this.data[0]['time'])),
    //     ceil: parseInt(
    //       this.timestampManipulation(this.data[this.data.length - 1]['time'])
    //     ),
    //   };

    //   console.log('floor', this.opt.floor, 'ceil', this.opt.ceil);

    //   this.value = this.opt.floor;
    //   this.maxValue =
    //     this.opt.floor + this.windowBetweenFloorAndCeil * 60 * 60 * 1000;

    //   this.groupedData = _.groupBy(this.data, 'time');
    //   console.log('auta einai ta grouparismena data', this.groupedData);

    //   // for (let key in this.groupedData) {
    //   //   this.opt.ticksArray.push(parseInt(this.timestampManipulation(key)));
    //   // }

    //   // console.log('ticksArray: ', this.opt.ticksArray);

    //   let o = Math.round;
    //   let r = Math.random;
    //   let s = 255;
    //   this.data.forEach((element) => {
    //     let index = this.idArray.findIndex((id) => id.id === element.id);

    //     if (index === -1) {
    //       this.idArray.push({
    //         id: element.id,
    //         color:
    //           'rgb(' + o(r() * s) + ',' + o(r() * s) + ',' + o(r() * s) + ')',
    //       });
    //     }
    //   });

    //   // this.createActiveArray()

    //   console.log(' auto einai to id array: ', this.idArray);
    // } else {
    //   let parsedData = JSON.parse(this.dataFromServer);
    //   this.data = parsedData['data'];

    //   this.groupedData = this.data;
    //   console.log('auta einai ta grouparismena data', this.groupedData);
    //   if (this.groupedData[0].id) {
    //     let o = Math.round;
    //     let r = Math.random;
    //     let s = 255;
    //     this.data.forEach((element) => {
    //       let index = this.idArray.findIndex((id) => id.id === element.id);

    //       if (index === -1) {
    //         this.idArray.push({
    //           id: element.id,
    //           color:
    //             'rgb(' + o(r() * s) + ',' + o(r() * s) + ',' + o(r() * s) + ')',
    //         });
    //       }
    //     });

    //     // this.createActiveArray()

    //     console.log(' auto einai to id array: ', this.idArray);
    //   }

    //   this.spatialVisualization();
    // }

    // Call api to get noda spatio-temporal data
    // this.quoteService
    //   .getNodaSTData()
    //   .then((res: any) => {
    //     // json parse the responce and import in data variable
    //     let parsedData = JSON.parse(res);
    //     this.data = parsedData['data'];

    //     // JS Date needs milli Epoch Timestamp (so below is a milli epoch converter)
    //     console.log(
    //       this.data,
    //       'ayto einai ena date: ' +
    //         new Date(parseInt(this.timestampManipulation(this.data[0]['time'])))
    //     );

    //     this.opt = {
    //       floor: parseInt(this.timestampManipulation(this.data[0]['time'])),
    //       ceil: parseInt(
    //         this.timestampManipulation(this.data[this.data.length - 1]['time'])
    //       ),
    //     };

    //     console.log('floor', this.opt.floor, 'ceil', this.opt.ceil);

    //     this.value = this.opt.floor;
    //     this.maxValue =
    //       this.opt.floor + this.windowBetweenFloorAndCeil * 60 * 60 * 1000;

    //     this.groupedData = _.groupBy(this.data, 'time');
    //     console.log('auta einai ta grouparismena data', this.groupedData);

    //     // for (let key in this.groupedData) {
    //     //   this.opt.ticksArray.push(parseInt(this.timestampManipulation(key)));
    //     // }

    //     // console.log('ticksArray: ', this.opt.ticksArray);

    //     let o = Math.round;
    //     let r = Math.random;
    //     let s = 255;
    //     this.data.forEach((element) => {
    //       let index = this.idArray.findIndex((id) => id.id === element.id);

    //       if (index === -1) {
    //         this.idArray.push({
    //           id: element.id,
    //           color:
    //             'rgb(' + o(r() * s) + ',' + o(r() * s) + ',' + o(r() * s) + ')',
    //         });
    //       }
    //     });

    //     // this.createActiveArray()

    //     console.log(' auto einai to id array: ', this.idArray);
    //   })
    //   .catch((err) => {
    //     console.log(err);
    //   });

    // Spatial Manipulation
    // this.quoteService
    //   .getNodaSpatialData()
    //   .then((res: any) => {
    //     let parsedData = JSON.parse(res);
    //     this.data = parsedData['data'];

    //     this.groupedData = this.data;
    //     console.log('auta einai ta grouparismena data', this.groupedData);
    //     if (this.groupedData[0].id) {
    //       let o = Math.round;
    //       let r = Math.random;
    //       let s = 255;
    //       this.data.forEach((element) => {
    //         let index = this.idArray.findIndex((id) => id.id === element.id);

    //         if (index === -1) {
    //           this.idArray.push({
    //             id: element.id,
    //             color:
    //               'rgb(' +
    //               o(r() * s) +
    //               ',' +
    //               o(r() * s) +
    //               ',' +
    //               o(r() * s) +
    //               ')',
    //           });
    //         }
    //       });

    //       // this.createActiveArray()

    //       console.log(' auto einai to id array: ', this.idArray);
    //     }

    //     this.spatialVisualization();
    //   })
    //   .catch((err) => {
    //   console.log(err);
    // });
  }

  goToVisualization() {
    if (
      this.chosenDatabaseStore === 'mongodb' ||
      this.chosenDatabaseStore === 'neo4j'
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
