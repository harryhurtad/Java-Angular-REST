import { Component, OnInit } from '@angular/core';

import { Reporte } from '../../model/Reporte';

import { ReporteService } from '../../service/reporte.service';

@Component({
  moduleId: module.id,
  selector: 'app-reporte',
  templateUrl: 'reporte.component.html',
  styleUrls: ['reporte.component.css']
})
export class ReporteComponent implements OnInit {

  reporte: Reporte = new Reporte(0, 0, false);

  constructor(private reporteService: ReporteService) { }

  ngOnInit() {
    this.reporteService.getInfo(this.reporte.siguiente).subscribe(data => {
      this.reporte = data;
    });
  }

  cargarAnterior() {
    this.reporteService.getInfo(this.reporte.anterior).subscribe(data => {
      this.reporte = data;
    });
  }

  cargarSiguiente() {
    this.reporteService.getInfo(this.reporte.siguiente).subscribe(data => {
      this.reporte = data;
    });
  }

  deshabilitarAnterior(){
    return this.reporte.anterior < 0;
  }

}