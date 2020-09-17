import { Component, Input, OnInit } from '@angular/core';
import { QuoteService } from '@app/home/quote.service';

@Component({
  selector: 'app-sidebar',
  templateUrl: './sidebar.component.html',
  styleUrls: ['./sidebar.component.scss'],
})
export class SidebarComponent implements OnInit {
  data: Array<any> = [];

  constructor(private quoteService: QuoteService) {}

  ngOnInit() {
    this.quoteService.getNodaSTData().then((res: any) => {
      let parsedData = JSON.parse(res);
      this.data = parsedData['data'];
    });
  }
}
