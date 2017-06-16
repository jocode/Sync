package com.example.sync.provider;

import android.content.UriMatcher;
import android.net.Uri;
import android.provider.BaseColumns;

import java.net.URI;

/**
 *  Contract class entre el provider y las aplicaciones
 */
public class ContractParaGastos {

    /**
     * Autoridad del ContentProvider
     */
    public final  static String AUTHORITY = "com.example.sync";

    /**
     * Representación de la tabla a consultar
     */
    public  static  final String GASTO = "gasto";

    /**
     * Tipo MIME que retorna la consulta de una sola fila
     */
    public static final String SINGLE_MIME = "vnd.android.cursor.item/vnd."+ AUTHORITY + GASTO;

    /**
     * Tipo MIME que retorna la consulta de {@link }
     */
    public static final  String MULTIPLE_MIME = "vnd.android.cursor.dir/vnd." + AUTHORITY + GASTO;

    /**
     * URI del contenido principal
     */
    public static final Uri CONTENT_URI = Uri.parse("content://"+ AUTHORITY + "/" + GASTO);

    /**
     * Comparador de URIs de contenido
     */
    public static final UriMatcher uriMatcher;

    /**
     * Código para URIs de multiples registros
     */
    public static final int ALLROWS = 1;
    /**
     * Código para URIS de un solo registro
     */
    public static final int SINGLE_ROW = 2;


    // Asignación de URIs
    static {
        uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
        uriMatcher.addURI(AUTHORITY, GASTO, ALLROWS);
        uriMatcher.addURI(AUTHORITY, GASTO + "/#", SINGLE_ROW);
    }

    // Valores para la columna ESTADO
    public static final int ESTADO_OK = 0;
    public static final int ESTADO_SYNC = 1;

    /**
     * Estructura de la tabla
     */
    public static class Columnas implements BaseColumns {

        private Columnas() {
            // Sin instancias
        }

        public final static String MONTO = "monto";
        public final static String ETIQUETA = "etiqueta";
        public final static String FECHA = "fecha";
        public final static String DESCRIPCION = "descripcion";

        public static final String ESTADO = "estado";
        public static final String ID_REMOTA = "idRemota";
        public final static String PENDIENTE_INSERCION = "pendiente_insercion";

    }

}
