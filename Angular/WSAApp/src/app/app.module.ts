import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpModule } from '@angular/http';
import { Routes, RouterModule } from '@angular/router';
import { FormsModule } from '@angular/forms';

//Components
import { AppComponent } from './component/main/app.component';
import { EntidadComponent } from './component/entidad/entidad.component';

//Services
import { EntidadService } from './service/entidad.service';


const routes: Routes = [
  { path: '', component: EntidadComponent },
  { path: 'entidad', component: EntidadComponent }
];

@NgModule({
  declarations: [
    AppComponent,
    EntidadComponent
  ],
  imports: [
    BrowserModule,
    HttpModule,
    RouterModule.forRoot(routes),
    FormsModule
  ],
  providers: [EntidadService],
  bootstrap: [AppComponent]
})
export class AppModule { }
