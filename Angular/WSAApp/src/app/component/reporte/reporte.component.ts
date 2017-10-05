import { Component, OnInit } from '@angular/core';
import { ReporteService } from '../../service/reporte.service';

@Component({
  moduleId: module.id,
  selector: 'app-reporte',
  templateUrl: 'reporte.component.html',
  styleUrls: ['reporte.component.css']
})
export class ReporteComponent implements OnInit {

  reporte: Array<any> = [];

  constructor(private reporteService: ReporteService) { }

  ngOnInit() {
    this.reporteService.getInfo().subscribe(data => {
      this.reporte = data;
    });
  }

}
