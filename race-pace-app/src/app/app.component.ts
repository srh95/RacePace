import { Component, OnInit } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { HttpErrorResponse } from '@angular/common/http';
import { Run } from './run'
import { RunService } from './run.service'

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet],
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  title = 'race-pace-app';
  public runs: Run[] = [];

  constructor(private runService: RunService){}

  ngOnInit(): void {
    this.getRuns();
  }

  public getRuns(): void {
    this.runService.getRuns().subscribe(
      (response: Run[]) => {
        this.runs = response;
      },
      (error: HttpErrorResponse) => {
        alert(error.message)
      }
    );
  }

}
