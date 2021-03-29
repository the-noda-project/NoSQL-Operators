import { Component, OnInit } from '@angular/core';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { themeFromMapBox } from '../shell/shell.service';
import * as L from 'leaflet';
import { Options } from 'ng5-slider';
import * as _ from 'lodash';
import { ActivatedRoute, Router } from '@angular/router';
import { QueryConstructionService } from './query-construction.service';
import { QuoteService } from '@app/home/quote.service';
import * as turf from '@turf/turf';

@Component({
  selector: 'app-query-construction',
  templateUrl: './query-construction.component.html',
  styleUrls: ['./query-construction.component.scss'],
})
export class QueryConstructionComponent implements OnInit {
  query: string;

  queryToRunMongo: string =
    'SELECT* FROM car WHERE GEO_RECTANGLE(location, [(13.263160139322283, 52.49997397893388),(13.306762129068376, 52.52113031608697)] )';
  queryToRunNeo4j: string =
    "SELECT* FROM car WHERE GEO_TEMPORAL_CIRCLE_KM(location, (13.285476118326189, 52.51026611136366), 1.5, date, '29/05/2007 12:00:00', '1/06/2007 12:00:00')";
  queryToRunHbase: string =
    'SELECT* FROM car WHERE GEO_CIRCLE_KM(location, (13.272429853677751, 52.509430292042886), 1)';

  mongoSQLQuery: string =
    'SELECT* FROM car WHERE GEO_RECTANGLE(location, [(13.263160139322283, 52.49997397893388),(13.306762129068376, 52.52113031608697)] )';
  neo4jSQLQuery: string =
    "SELECT* FROM car WHERE GEO_TEMPORAL_CIRCLE_KM(location, (13.285476118326189, 52.51026611136366), 1.5, Timestamp, '29/05/2007 12:00:00', '1/06/2007 12:00:00')";
  hbaseSQLQuery: string =
    'SELECT* FROM car WHERE GEO_CIRCLE_KM(location, (13.272429853677751, 52.509430292042886), 1)';

  mongoActualQuery: string =
    "{'$match': {'$and': [{'location': {'$geoWithin': {'$geometry': {'type': 'Polygon', 'coordinates': [[[13.263160139322283, 52.49997397893388], [13.263160139322283, 52.52113031608697], [13.306762129068376, 52.52113031608697], [13.306762129068376, 52.49997397893388], [13.263160139322283, 52.49997397893388]]]}}}}, {'$or': [{'hilIndex': {'$in': [37893268]}}]}]}}, {'$limit': 10000}, {'$sample': {'size': 1000}}";
  neo4jActualQuery: string =
    "'MATCH (s:car) WHERE s.STHilbertIndex = 8651829 WITH s WHERE distance(point({ srid :7203, x: 52.51026611136366 , y: 13.285476118326189 }), s.location) < 1.5 AND 1180429200000 < s.Timestamp < 1180483200000 WITH s RETURN *'";
  hbaseActualQuery: string =
    'FilterList AND (2/2): [FilterList AND (2/2): [PrefixFilter u336w, CircleFilter (location, longitude, latitude, (13.272429853677751 52.509430292042886),1)], FilterList OR (0/0): []]';

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
  dbChangeConnectorLoading = false;

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
  actualQuery = 'Not available yet.';

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

  dropDownProps = {
    mongo: ['vehicle', 'car_type', 'hilIndex', 'location', 'date'],
    neo4j: [
      'car_Id',
      'location',
      'Timestamp',
      'HilbertIndex',
      'STHilbertIndex',
    ],
    hbase: ['cf:vehicle', 'location:date', 'location'],
  };

  map: L.Map;
  layers: Array<any> = [];
  options = {
    layers: [L.tileLayer(themeFromMapBox, { maxZoom: 18, attribution: '...' })],
    zoom: 14,
    center: L.latLng(52.5067614, 13.2846506),
  };

  ngOnInit(): void {
    this.isDropDownOpen = false;
    this.dbChangeConnectorLoading = true;
    this.fps = 0.2;
    this.windowBetweenFloorAndCeil = 3;
    this.changeFloor = false;
    this.changeCeil = false;

    this.activeRoute.paramMap.subscribe((params: any) => {
      this.activeDatabase = params.get('dbType');
    });

    setTimeout(() => {
      this.dbChangeConnectorLoading = false;
    }, 1500);
  }

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
    this.router.navigate(['/visualization/dbtype/' + db]);

    this.dbChangeConnectorLoading = true;
    this.query = null;
    this.actualQuery = 'Not available yet.';
    this.objectIdFieldName = 'default';
    this.objectLocationFieldName = 'default';
    this.objectTimeFieldName = 'default';

    this.layers.splice(0, this.layers.length - 1);

    this.chosenGeoSQLFunction = 'default';

    setTimeout(() => {
      this.dbChangeConnectorLoading = false;
    }, 2000);
  }

  changeStateOfDropDown() {
    this.isDropDownOpen = !this.isDropDownOpen;
  }

  onDrawCreated(e: any) {
    this.drawItems.addLayer((e as L.DrawEvents.Created).layer);
  }

  onMapReady(map: L.Map) {
    this.map = map;

    map.on(L.Draw.Event.CREATED, (e) => {
      this.drawLogic(e);
    });
  }

  drawLogic(e: any) {
    const type = (e as any).layerType,
      layer = (e as any).layer;

    if (type === 'circle') {
      var theCenterPt = layer.getLatLng();

      var center = [theCenterPt.lng, theCenterPt.lat];
      console.log(center);

      var theRadius = layer.getRadius();

      console.log('radius: ', theRadius, 'Center: ', theCenterPt);

      if (this.activeDatabase === 'mongodb') {
        this.query = this.mongoSQLQuery;
      }
      if (this.activeDatabase === 'neo4j') {
        this.query = this.neo4jSQLQuery;
      }
      if (this.activeDatabase === 'hbase') {
        this.query = this.hbaseSQLQuery;
      }
    }

    if (type === 'rectangle') {
      console.log(layer.getLatLngs());

      if (this.activeDatabase === 'mongodb') {
        this.query = this.mongoSQLQuery;
      }
      if (this.activeDatabase === 'neo4j') {
        this.query = this.neo4jSQLQuery;
      }
      if (this.activeDatabase === 'hbase') {
        this.query = this.hbaseSQLQuery;
      }
    }
  }

  runSpatialQuery() {
    let q = '';

    if (this.activeDatabase === 'mongodb') {
      q = this.queryToRunMongo;
    }
    if (this.activeDatabase === 'neo4j') {
      q = this.queryToRunNeo4j;
    }
    if (this.activeDatabase === 'hbase') {
      q = this.queryToRunHbase;
    }

    //must where strings karfota na valw auta
    // this.objectIdFieldName
    // this.objectLocationFieldName
    // this.objectTimeFieldName

    this.isLoading = true;
    this.queryConstructionServ
      .spatialSqlQueryPost(q, 'vehicle', 'location')
      .then((res) => {
        if (this.activeDatabase === 'mongodb') {
          this.query = this.mongoSQLQuery;
          this.actualQuery = this.mongoActualQuery;
        }
        if (this.activeDatabase === 'neo4j') {
          this.query = this.neo4jSQLQuery;
          this.actualQuery = this.neo4jActualQuery;
        }
        if (this.activeDatabase === 'hbase') {
          this.query = this.hbaseSQLQuery;
          this.actualQuery = this.hbaseActualQuery;
        }
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
    let q = '';

    if (this.activeDatabase === 'mongodb') {
      q = this.queryToRunMongo;
    }
    if (this.activeDatabase === 'neo4j') {
      q = this.queryToRunNeo4j;
    }
    if (this.activeDatabase === 'hbase') {
      q = this.queryToRunHbase;
    }

    //must where strings karfota na valw auta
    // this.objectIdFieldName
    // this.objectLocationFieldName
    // this.objectTimeFieldName

    this.isLoading = true;
    this.queryConstructionServ
      .spatioTemporalSqlQueryPost(q, 'vehicle', 'location', 'date')
      .then((res) => {
        console.log(res);
        const data = JSON.parse(res);
        if (data['status'] === 'ok') {
          this.isLoading = false;
          if (this.activeDatabase === 'mongodb') {
            this.query = this.mongoSQLQuery;
            this.actualQuery = this.mongoActualQuery;
          }
          if (this.activeDatabase === 'neo4j') {
            this.query = this.neo4jSQLQuery;
            this.actualQuery = this.neo4jActualQuery;
          }
          if (this.activeDatabase === 'hbase') {
            this.query = this.hbaseSQLQuery;
            this.actualQuery = this.hbaseActualQuery;
          }
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
    }
    if (time.length < 13) {
      manipulatedTime = parseInt((time += '000'));
    }
    if (time.length > 13) {
      manipulatedTime = new Date(time).getTime();
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

        if (this.layers.length >= 250) {
          this.layers.splice(0, 30);
        }
        // console.log("auta einai ta layers", this.layers);
      }, i * (this.fps * 1000));
    }
  }
}
