import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';

@Component({
  selector: 'question',
  templateUrl: './question.component.html',
  styleUrls: ['./question.component.scss']
})
export class QuestionComponent implements OnInit {
  @Input() statement!: string;
  @Input() options!: string[];
  @Input() selection!: number;
  @Output() select = new EventEmitter<number>();
  constructor() { }

  ngOnInit(): void {
  }

}
