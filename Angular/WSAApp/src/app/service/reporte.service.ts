import { Injectable } from '@angular/core';
import { Http, Response } from '@angular/http';
import { Observable } from 'rxjs/Observable';
import '../rxjs/index';

@Injectable()
export class ReporteService {

  private reportedWSURL = "http://localhost:7001/WSADemoWEB/webresources";

  constructor(private http: Http) { }

  getInfo(inicio: number): Observable<any> {
    return this.http.get(this.getUrl('reporte?inicio=' + inicio)).map(this.getData).catch(this.error);
  }

  getData(data: Response) {
    let datos = data.json();
    return datos || [];
  }

  private error(error: any) {
    let mensaje = (error.message) ? error.message : 'Error desconocido';
    console.log(mensaje);
    return Observable.throw(mensaje);
  }

  private getUrl(model: String) {
    return this.reportedWSURL + '/' + model;
  }

}
