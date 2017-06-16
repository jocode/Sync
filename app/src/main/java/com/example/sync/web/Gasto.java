package com.example.sync.web;

/**
 * Esta clase representa un gasto individual de cada registro de la base de datos
 */

public class Gasto {

    public String idGasto;
    public int monto;
    public String etiqueta;
    public String fecha;
    public String descripcion;

    public Gasto(String idGasto, int monto, String etiqueta, String fecha, String descripcion) {
        this.idGasto = idGasto;
        this.monto = monto;
        this.etiqueta = etiqueta;
        this.fecha = fecha;
        this.descripcion = descripcion;
    }
}
