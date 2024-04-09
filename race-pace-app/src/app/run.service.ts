import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { environment } from '../environments/environment';
import { Run } from './run';

@Injectable({
  providedIn: 'root'
})
export class RunService {

  private apiServerUrl = environment.apiBaseUrl;

  constructor(private http: HttpClient) { }

    public getRuns(): Observable<Run[]> {
        return this.http.get<Run[]>(`${this.apiServerUrl}/all`)
    }

    public getRunByTitle(title: string): Observable<Run>{
        return this.http.get<Run>(`${this.apiServerUrl}/find/${title}`)
    }

    public addNewRun(run: Run): Observable<void>{
        return this.http.post<void>(`${this.apiServerUrl}/add`, run)
    }

    public updateRun(runId: number, run: Run): Observable<void>{
        return this.http.put<void>(`${this.apiServerUrl}/update${runId}`, run)
    }

    public deleteRun(runId: number): Observable<void>{
        return this.http.delete<void>(`${this.apiServerUrl}/delete/${runId}`)
    }

}
