import { Component, Input, OnInit } from '@angular/core';

@Component({
  selector: 'results',
  templateUrl: './results.component.html',
  styleUrls: ['./results.component.scss']
})
export class ResultsComponent implements OnInit {
  @Input() questions!: any;
  @Input() answers!: any;

  constructor() { }

  ngOnInit(): void {
  }

}
