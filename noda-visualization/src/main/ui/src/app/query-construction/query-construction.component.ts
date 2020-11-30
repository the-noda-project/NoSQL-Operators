import { Component, OnInit } from '@angular/core';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { FieldnamesModalComponent } from './fieldnames-modal/fieldnames-modal.component';
import { themeFromMapBox } from '../shell/shell.service';
import * as L from 'leaflet';
import { Options } from 'ng5-slider';
import * as _ from 'lodash';
import { ActivatedRoute, Router } from '@angular/router';
import { QueryConstructionService } from './query-construction.service';
import { QuoteService } from '@app/home/quote.service';

@Component({
  selector: 'app-query-construction',
  templateUrl: './query-construction.component.html',
  styleUrls: ['./query-construction.component.scss'],
})
export class QueryConstructionComponent implements OnInit {
  query: string;
  isLoading: boolean = false;
  constructor(
    private modal: NgbModal,
    private quoteService: QuoteService,
    private queryConstructionServ: QueryConstructionService,
    private activeRoute: ActivatedRoute,
    private router: Router
  ) {}

  chosenGeoSQLFunction: string = 'default';

  activeDatabase: string;

  changeFloor: boolean;
  changeCeil: boolean;
  fps: number;
  addTime: number;
  windowBetweenFloorAndCeil: number;

  dataFromServer: string;
  data: Array<any> = [];
  groupedData: any;
  idArray: Array<any> = [];

  opt: Options = {
    floor: 0,
    ceil: 10,
  };

  activeArray: Array<any> = [];

  value: number = 5;
  maxValue: number = 8;

  isDropDownOpen: boolean = false;
  isQueryConstructorTabOpen: boolean = true;
  isSQLqueryTabOpen: boolean = true;
  isActualDBTabOpen: boolean = true;

  objectIdFieldName: string = 'default';
  objectLocationFieldName: string = 'default';
  objectTimeFieldName: string = 'default';

  drawItems: L.FeatureGroup = L.featureGroup();
  actualQuery =
    'MATCH (s:Car) WHERE s.STHilbertIndex = 8651786 WITH s WHERE distance(point({ srid :7203, x: 52.5067614 , y: 13.2846506 }), s.location) < 0.02 AND 1180429200000 < s.Timestamp < 1180688400000 WITH s RETURN *';

  drawOptions = {
    edit: {
      featureGroup: this.drawItems,
    },
    position: 'topleft',
    draw: {
      marker: false,
      circle: {
        shapeOptions: {
          fillOpacity: 0.08,
        },
      },
      rectangle: {
        showArea: false,
        shapeOptions: {
          fillOpacity: 0.08,
        },
      }, // disable showArea
      polyline: false,
      polygon: false,
      circlemarker: false,
    },
  };

  map: L.Map;
  layers: Array<any> = [];
  options = {
    layers: [L.tileLayer(themeFromMapBox, { maxZoom: 18, attribution: '...' })],
    zoom: 14,
    center: L.latLng(52.5067614, 13.2846506),
  };

  ngOnInit(): void {
    this.fps = 0.2;
    this.windowBetweenFloorAndCeil = 3;
    this.changeFloor = false;
    this.changeCeil = false;

    this.activeRoute.paramMap.subscribe((params: any) => {
      this.activeDatabase = params.get('dbType');
    });
  }

  // openModal(selsectedCase: string) {
  //   if (this.query) {
  //     const x = this.modal.open(FieldnamesModalComponent);
  //     x.componentInstance.ref = x;
  //     x.componentInstance.case = selsectedCase;
  //     x.componentInstance.query = this.query;
  //   } else {
  //     alert('You must write a query first');
  //   }
  // }

  openCloseQueryConstructorTab() {
    this.isQueryConstructorTabOpen = !this.isQueryConstructorTabOpen;
  }

  openCloseSQLQueryTab() {
    this.isSQLqueryTabOpen = !this.isSQLqueryTabOpen;
  }

  openCloseActualDBTab() {
    this.isActualDBTabOpen = !this.isActualDBTabOpen;
  }

  goToOtherDb(db: string) {
    this.changeStateOfDropDown();
    this.router.navigate(['/visualization/dbtype/' + db]);
  }

  changeStateOfDropDown() {
    this.isDropDownOpen = !this.isDropDownOpen;
  }

  onDrawCreated(e: any) {
    this.drawItems.addLayer((e as L.DrawEvents.Created).layer);
  }

  onMapReady(map: L.Map) {
    this.map = map;
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
          // Take data from serve from quoteService
          this.dataFromServer = this.quoteService.getData();

          console.log(
            'edwwwwwwwwwwwwwwwwwwwedwwwwwwwwwwwwwwwwwwwedwwwwwwwwwwwwwwwwwwwedwwwwwwwwwwwwwwwwwwwedwwwwwwwwwwwwwwwwwww',
            this.dataFromServer
          );

          let parsedData = JSON.parse(this.dataFromServer);
          this.data = parsedData['data'];

          this.groupedData = this.data;
          console.log('auta einai ta grouparismena data', this.groupedData);
          if (this.groupedData[0].id) {
            let o = Math.round;
            let r = Math.random;
            let s = 255;
            this.data.forEach((element) => {
              let index = this.idArray.findIndex((id) => id.id === element.id);

              if (index === -1) {
                this.idArray.push({
                  id: element.id,
                  color:
                    'rgb(' +
                    o(r() * s) +
                    ',' +
                    o(r() * s) +
                    ',' +
                    o(r() * s) +
                    ')',
                });
              }
            });

            // this.createActiveArray()

            console.log(' auto einai to id array: ', this.idArray);

            this.spatialVisualization();
          } else {
            alert('Κάτι δεν πήγε καλά');
          }
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
          // Take data from serve from quoteService
          this.dataFromServer = this.quoteService.getData();

          console.log(
            'edwwwwwwwwwwwwwwwwwwwedwwwwwwwwwwwwwwwwwwwedwwwwwwwwwwwwwwwwwwwedwwwwwwwwwwwwwwwwwwwedwwwwwwwwwwwwwwwwwww',
            this.dataFromServer
          );
          let parsedData = JSON.parse(this.dataFromServer);
          this.data = parsedData['data'];

          // JS Date needs milli Epoch Timestamp (so below is a milli epoch converter)
          console.log(
            this.data,
            'ayto einai ena date: ' +
              new Date(
                parseInt(this.timestampManipulation(this.data[0]['time']))
              )
          );

          this.opt = {
            floor: parseInt(this.timestampManipulation(this.data[0]['time'])),
            ceil: parseInt(
              this.timestampManipulation(
                this.data[this.data.length - 1]['time']
              )
            ),
          };

          console.log('floor', this.opt.floor, 'ceil', this.opt.ceil);

          this.value = this.opt.floor;
          this.maxValue =
            this.opt.floor + this.windowBetweenFloorAndCeil * 60 * 60 * 1000;

          this.groupedData = _.groupBy(this.data, 'time');
          console.log('auta einai ta grouparismena data', this.groupedData);

          // for (let key in this.groupedData) {
          //   this.opt.ticksArray.push(parseInt(this.timestampManipulation(key)));
          // }

          // console.log('ticksArray: ', this.opt.ticksArray);

          let o = Math.round;
          let r = Math.random;
          let s = 255;
          this.data.forEach((element) => {
            let index = this.idArray.findIndex((id) => id.id === element.id);

            if (index === -1) {
              this.idArray.push({
                id: element.id,
                color:
                  'rgb(' +
                  o(r() * s) +
                  ',' +
                  o(r() * s) +
                  ',' +
                  o(r() * s) +
                  ')',
              });
            }
          });

          // this.createActiveArray()

          console.log(' auto einai to id array: ', this.idArray);
          this.playSpatioTemporal();
        } else {
          alert('Κάτι δεν πήγε καλά');
        }
      })
      .catch((err) => {
        this.isLoading = false;
        console.log(err);
      });
  }

  timestampManipulation(time: any) {
    let manipulatedTime;

    if (time.length === 13) {
      manipulatedTime = time;
    } else {
      manipulatedTime = parseInt((time += '000'));
    }

    return manipulatedTime;
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

  getRGBofPin(id: string) {
    const index = this.idArray.findIndex((el) => el.id === id);
    return this.idArray[index].color;
  }

  spatialVisualization() {
    const myRenderer = L.canvas({
      padding: 0.01,
    });

    this.groupedData.forEach((position: any) => {
      const lat = position.lat;
      const lon = position.lon;
      if (position.id) {
        let myIcon = L.divIcon({
          html:
            '<div style="background-color: ' +
            this.getRGBofPin(position.id) +
            ' ; height: 10px; width: 10px; border-radius: 100%;"></div>',
        });

        this.layers.push(
          L.circleMarker([lat, lon], {
            renderer: myRenderer,
            color: this.getRGBofPin(position.id),
            fillColor: this.getRGBofPin(position.id),
            fill: true,
            weight: 0.2,
            stroke: false,
            fillOpacity: 1,
          })
          // .bindPopup(
          //   `<div>CraftID: ` +
          //     craftID +
          //     `</div>` +
          //     `<div>TimeStamp: ` +
          //     TimeStamp +
          //     `</div>` +
          //     `<div>Speed: ` +
          //     Speed +
          //     `</div>`
          // )
        );
      } else {
        let myIcon = L.divIcon({
          html:
            '<div style="background-color: green; height: 10px; width: 10px; border-radius: 100%;"></div>',
        });

        this.layers.push(
          L.circleMarker([lat, lon], {
            renderer: myRenderer,
            color: '#228B22',
            fillColor: '#228B22',
            fill: true,
            weight: 0.2,
            stroke: false,
            fillOpacity: 1,
          })
          // .bindPopup(
          //   `<div>CraftID: ` +
          //     craftID +
          //     `</div>` +
          //     `<div>TimeStamp: ` +
          //     TimeStamp +
          //     `</div>` +
          //     `<div>Speed: ` +
          //     Speed +
          //     `</div>`
          // )
        );

        this.layers.push(
          L.circleMarker([lat, lon], {
            renderer: myRenderer,
            color: '#228B22',
            fillColor: '#228B22',
            fill: true,
            weight: 0.2,
            stroke: false,
            fillOpacity: 1,
          })
          // .bindPopup(
          //   `<div>CraftID: ` +
          //     craftID +
          //     `</div>` +
          //     `<div>TimeStamp: ` +
          //     TimeStamp +
          //     `</div>` +
          //     `<div>Speed: ` +
          //     Speed +
          //     `</div>`
          // )
        );
      }
    });
  }

  playSpatioTemporal() {
    // this.value = this.opt.floor;
    this.maxValue =
      this.opt.floor + this.windowBetweenFloorAndCeil * 60 * 60 * 1000;
    let i = 0;

    // for (let key in this.groupedData) {
    for (let key in this.groupedData) {
      console.log('eimai akrivos apekso!');

      i++;
      setTimeout(() => {
        if (parseInt(this.timestampManipulation(key)) > this.opt.floor) {
          this.groupedData[key].forEach((element: any) => {
            const lat = element.lat;
            const lon = element.lon;
            const time = element.time;
            let myIcon = L.divIcon({
              html:
                '<div style="background-color: ' +
                this.getRGBofPin(element.id) +
                ' ; height: 10px; width: 10px; border-radius: 100%;"></div>',
            });

            // this.layers = [];
            const myRenderer = L.canvas({
              padding: 0.5,
            });

            this.layers.push(
              // L.circleMarker([lat, lon], {
              //   renderer: myRenderer,
              //   color: this.getRGBofPin(element.id),
              //   fillColor: this.getRGBofPin(element.id),
              //   fill: true,
              //   stroke: false,
              //   fillOpacity: 1,
              // })
              L.marker([lat, lon], {
                icon: myIcon,
              })
              // .bindPopup(
              //   `<div>CraftID: ` +
              //     craftID +
              //     `</div>` +
              //     `<div>TimeStamp: ` +
              //     TimeStamp +
              //     `</div>` +
              //     `<div>Speed: ` +
              //     Speed +
              //     `</div>`
              // )
            );
            // this.value = parseInt(this.timestampManipulation(time));
            // this.maxValue = this.value + this.windowBetweenFloorAndCeil * 60 * 60 * 1000;
            // this.map.panTo(new L.LatLng(lat, lon));
          });
        }
        this.value = parseInt(this.timestampManipulation(key));
        this.maxValue =
          this.value + this.windowBetweenFloorAndCeil * 60 * 60 * 1000;

        if (this.layers.length >= 180) {
          this.layers.splice(0, 30);
        }
        // console.log("auta einai ta layers", this.layers);
      }, i * (this.fps * 1000));
    }
  }
}
