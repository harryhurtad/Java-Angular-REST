import { Injectable } from '@angular/core';
import { Http, Response } from '@angular/http';
import { Observable } from 'rxjs/Observable';
import '../rxjs/index';

@Injectable()
export class EntidadService {

  private entidadWSURL = "http://localhost:7001/WSADemoWEB/webresources";

  constructor(private http: Http) { }

  findAll(): Observable<any[]> {
    return this.http.get(this.getUrl('entidad')).map(this.getData).catch(this.error);
  }

  findById(id: number): Observable<any> {
    return this.http.get(this.getUrl('entidad/' + id)).map(this.getData).catch(this.error);
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
    return this.entidadWSURL + '/' + model;
  }

}
