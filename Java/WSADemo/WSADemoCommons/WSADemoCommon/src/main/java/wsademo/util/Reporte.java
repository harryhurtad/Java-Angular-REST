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
public class Reporte implements Serializable {

    private int anterior;
    private List<String> columnas;
    private List datos;
    private boolean fin;
    private int siguiente;

    public Reporte() {
    }

    public Reporte(int anterior, List<String> columnas, List datos, boolean fin, int siguiente) {
        this.anterior = anterior;
        this.columnas = columnas;
        this.datos = datos;
        this.fin = fin;
        this.siguiente = siguiente;
    }

    public int getAnterior() {
        return anterior;
    }

    public void setAnterior(int anterior) {
        this.anterior = anterior;
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

    public boolean isFin() {
        return fin;
    }

    public void setFin(boolean fin) {
        this.fin = fin;
    }

    public int getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(int siguiente) {
        this.siguiente = siguiente;
    }

}
