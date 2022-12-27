import {Component, Input, OnInit} from '@angular/core';

@Component({
  selector: 'app-progress-bar',
  templateUrl: './progress-bar.component.html',
  styleUrls: ['./progress-bar.component.css']
})
export class ProgressBarComponent implements OnInit {
  number: number = 11;
  private interval = 0;

  constructor() {
  }

  ngOnInit() {
  }

  loading() {
    // @ts-ignore
    this.interval = setInterval(() => {
      this.number = +this.number - 1;
      if (this.number <= 0) {
        clearInterval(this.interval);
      }
    }, 1000);
  }

  reset() {
    this.number = 11;
  }

  pause() {
    clearInterval(this.interval)
  }
}
