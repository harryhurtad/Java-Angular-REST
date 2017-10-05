import { Component, OnInit } from '@angular/core';
import { EntidadService } from '../../service/entidad.service';

@Component({
  moduleId: module.id,
  selector: 'app-entidad',
  templateUrl: 'entidad.component.html',
  styleUrls: ['entidad.component.css']
})
export class EntidadComponent implements OnInit {

  entidades: Array<any> = [];

  constructor(private entidadService: EntidadService) { }

  ngOnInit() {
    this.entidadService.findAll().subscribe(data => {
      this.entidades = data;
    });
  }

}
