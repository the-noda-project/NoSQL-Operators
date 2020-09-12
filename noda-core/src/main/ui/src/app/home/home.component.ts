import { Component, OnInit } from '@angular/core';
import { finalize } from 'rxjs/operators';

import { QuoteService } from './quote.service';
import { themeFromMapBox } from '../shell/shell.service';
import * as L from 'leaflet';
import { Options } from 'ng5-slider';
import * as _ from 'lodash';

import 'leaflet/dist/images/marker-icon.png';
import 'leaflet/dist/images/marker-icon-2x.png';
import 'leaflet/dist/images/marker-shadow.png';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss'],
})
export class HomeComponent implements OnInit {
  // data = [
  //   {
  //     id: 1,
  //     lat: -27.3641383333,
  //     lon: 153.176081667,
  //     time: '2019-09-07T00:07:54Z',
  //   },
  //   {
  //     id: 2,
  //     lat: -27.336745,
  //     lon: 153.190841667,
  //     time: '2019-09-07T01:09:52Z',
  //   },
  //   {
  //     id: 3,
  //     lat: -27.336745,
  //     lon: 153.190841667,
  //     time: '2019-09-07T01:09:52Z',
  //   },
  //   {
  //     id: 4,
  //     lat: -27.148075,
  //     lon: 153.350708333,
  //     time: '2019-09-07T02:09:58Z',
  //   },
  //   {
  //     id: 5,
  //     lat: -26.915405,
  //     lon: 153.19185,
  //     time: '2019-09-07T03:09:58Z',
  //   },
  //   {
  //     id: 6,
  //     lat: -26.7047333333,
  //     lon: 153.182855,
  //     time: '2019-09-07T04:09:59Z',
  //   },
  //   {
  //     id: 7,
  //     lat: -26.4476166667,
  //     lon: 153.338056667,
  //     time: '2019-09-07T05:14:57Z',
  //   },
  //   {
  //     id: 8,
  //     lat: -26.1195666667,
  //     lon: 153.46412,
  //     time: '2019-09-07T06:19:57Z',
  //   },
  // ];

  data: Array<any> = [];

  changeFloor: boolean;
  changeCeil: boolean;
  refreshTime: number;
  windowBetweenFloorAndCeil: number;
  dataRefreshTime: number;

  value: number;
  maxValue: number;

  opt: Options = {};
  map: L.Map;
  layers: Array<any> = [];
  options = {
    layers: [L.tileLayer(themeFromMapBox, { maxZoom: 18, attribution: '...' })],
    zoom: 4,
    center: L.latLng(-27.750998, 127.581219),
  };

  constructor(private quoteService: QuoteService) {}

  ngOnInit() {
    this.quoteService.getConnectionMessage().then((res: any) => {
      console.log(res);
    });

    this.quoteService.getNodaSTData().then((res: any) => {
      console.log(res);
    });

    // this.quoteService
    //   .temporalRange('2019-09-13T14:15', '2019-09-16T14:15')
    //   .then((res: any) => {
    //     this.opt = {
    //       floor: new Date('2019-09-07T00:07:54Z').getTime(),
    //       ceil: new Date('2019-09-07T06:19:57Z').getTime(),
    //     };

    //     console.log('ayto einai to res', res['results']['records']);
    //     this.data = res['results']['records'];

    //     const length = this.data.length;
    //     console.log(length);
    //     this.opt.floor = new Date(
    //       this.data[0]['_fields'][0]['properties']['TIMESTAMP']
    //     ).getTime();
    //     this.opt.ceil = new Date(
    //       this.data[length - 1]['_fields'][0]['properties']['TIMESTAMP']
    //     ).getTime();
    //     this.value = this.opt.floor;
    //     this.maxValue =
    //       this.value + this.windowBetweenFloorAndCeil * 60 * 60 * 1000;
    //   });

    this.refreshTime = 0.5;
    this.dataRefreshTime = 10;
    this.windowBetweenFloorAndCeil = 4;
    this.changeFloor = false;
    this.changeCeil = false;

    // this.opt.ticksArray = [];
    // this.data.forEach((position) => {
    // this.opt.ticksArray.push(new Date(position.time).getTime());
    // });
  }

  changeFloorOrCeil(type: string) {
    if (type === 'floor') {
      this.changeFloor = !this.changeFloor;
      console.log(this.opt.floor);
    }
    if (type === 'ceil') {
      this.changeCeil = !this.changeCeil;
      console.log(this.opt.ceil);
    }
  }

  onMapReady(map: L.Map) {
    this.map = map;
  }

  playSpatioTemporal() {
    this.value = this.opt.floor;
    this.maxValue =
      this.opt.floor + this.windowBetweenFloorAndCeil * 60 * 60 * 1000;
    let i = 0;
    let myIcon = L.divIcon({
      html:
        '<div style="background-color: red; color: rgba(255, 0, 0, 0); height: 10px; width: 10px; border-radius: 100%;">sdfsf</div>',
    });

    let path = '_fields[0].properties.TIMESTAMP';

    let mpla = _(this.data)
      .filter((object) => _.has(object, path))
      .groupBy(path)
      .value();

    console.log(mpla);

    // this.data.forEach((el) => {
    //   if (new Date(el.time) > new Date(this.opt.floor)) {
    //     i++;
    //     setTimeout(() => {
    //       const lat = el.lat;
    //       const lon = el.lon;
    //       const time = el.time;

    //       // console.log(this.latlngsPolyline);
    //       this.layers = [];
    //       // this.map.setZoom(7);
    //       this.map.panTo(new L.LatLng(lat, lon));
    //       this.layers.push(
    //         L.marker([lat, lon], {
    //           icon: myIcon,
    //           // icon: this.greenIcon
    //         })
    //         // .bindPopup(
    //         //   `<div>CraftID: ` +
    //         //     craftID +
    //         //     `</div>` +
    //         //     `<div>TimeStamp: ` +
    //         //     TimeStamp +
    //         //     `</div>` +
    //         //     `<div>Speed: ` +
    //         //     Speed +
    //         //     `</div>`
    //         // )
    //       );
    //       this.value = new Date(time).getTime();
    //       this.maxValue = this.value + this.windowBetweenFloorAndCeil * 60 * 60 * 1000;
    //     }, i * (this.refreshTime * 1000));
    //   }
    // });
  }
}
