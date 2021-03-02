import { Component, Input, OnInit } from '@angular/core';
import { QuoteService } from '@app/home/quote.service';
import { ChartDataSets, ChartOptions, ChartType } from 'chart.js';
import * as _ from 'lodash';
import { Label, MultiDataSet } from 'ng2-charts';

@Component({
  selector: 'app-sidebar',
  templateUrl: './sidebar.component.html',
  styleUrls: ['./sidebar.component.scss'],
})
export class SidebarComponent implements OnInit {
  data: Array<any> = [];
  groupedData: any;

  // bar chart data
  barChartOptions: ChartOptions = {
    responsive: true,
    // We use these empty structures as placeholders for dynamic theming.
    scales: { xAxes: [{}], yAxes: [{}] },
    plugins: {
      datalabels: {
        anchor: 'end',
        align: 'end',
      },
    },
  };
  barChartLabels: Label[] = [
    '2006',
    '2007',
    '2008',
    '2009',
    '2010',
    '2011',
    '2012',
  ];
  barChartType: ChartType = 'bar';
  barChartLegend = true;
  // barChartPlugins = [pluginDataLabels];

  public barChartData: ChartDataSets[] = [
    { data: [65, 59, 80, 81, 56, 55, 40], label: 'Series A' },
    { data: [28, 48, 40, 19, 86, 27, 90], label: 'Series B' },
  ];

  // doughnutChart Data
  public doughnutChartLabels: Label[] = [
    'Download Sales',
    'In-Store Sales',
    'Mail-Order Sales',
  ];
  public doughnutChartData: MultiDataSet = [
    [350, 450, 100],
    [50, 150, 120],
    [250, 130, 70],
  ];
  public doughnutChartType: ChartType = 'doughnut';

  constructor(private quoteService: QuoteService) {}

  ngOnInit() {
    //   this.quoteService.getNodaSTData().then((res: any) => {
    //     let parsedData = JSON.parse(res);
    //     this.data = parsedData['data'];
    //     this.groupedData = _.groupBy(this.data, 'time');
    //   });
  }
}
