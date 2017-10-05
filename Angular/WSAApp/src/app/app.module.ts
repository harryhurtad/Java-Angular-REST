import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpModule } from '@angular/http';
import { Routes, RouterModule } from '@angular/router';
import { FormsModule } from '@angular/forms';

//Components
import { AppComponent } from './component/main/app.component';
import { EntidadComponent } from './component/entidad/entidad.component';
import { ReporteComponent } from './component/reporte/Reporte.component';

//Services
import { EntidadService } from './service/entidad.service';
import { ReporteService } from './service/reporte.service';


const routes: Routes = [
  { path: '', component: EntidadComponent },
  { path: 'entidad', component: EntidadComponent },
  { path: 'reporte', component: ReporteComponent }
];

@NgModule({
  declarations: [
    AppComponent,
    EntidadComponent,
    ReporteComponent
  ],
  imports: [
    BrowserModule,
    HttpModule,
    RouterModule.forRoot(routes),
    FormsModule
  ],
  providers: [EntidadService, ReporteService],
  bootstrap: [AppComponent]
})
export class AppModule { }
