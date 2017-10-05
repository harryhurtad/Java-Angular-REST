/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wsademo.util;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author nestorarevalo|
 */
public class Reporte implements Serializable{

    private List<String> columnas;
    private List datos;

    public Reporte() {
    }

    public Reporte(List<String> nombresColumnas, List informacion) {
        this.columnas = nombresColumnas;
        this.datos = informacion;
    }

    public List<String> getColumnas() {
        return columnas;
    }

    public void setColumnas(List<String> columnas) {
        this.columnas = columnas;
    }

    public List getDatos() {
        return datos;
    }

    public void setDatos(List datos) {
        this.datos = datos;
    }
}