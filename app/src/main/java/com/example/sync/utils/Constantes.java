package com.example.sync.utils;

/**
 * Constantes
 */
public class Constantes {

    /**
     * Puerto que utilizas para la conexión.
     * Dejalo en blanco si no has configurado esta característica.
     */
    private static final String PUERTO_HOST = "";

    /**
     * Dirección IP de genymotion o AVD
     */
    //private static final String IP = "http://10.0.3.2";
    private static final String IP = "http://192.168.0.102";

    /**
     * URLs del Web Service
     */
    public static final String GET_URL = IP + "/sync/web/obtener_gastos.php";
    public static final String INSERT_URL = IP + "/sync/web/insertar_gasto.php";

    /**
     * Campos de las respuestas Json
     */
    public static final String ID_GASTO = "idGasto";
    public static final String ESTADO = "estado";
    public static final String GASTOS = "gastos";
    public static final String MENSAJE = "mensaje";



    public static final String SUCCESS = "1";
    public static final String FAILED = "2";

    /**
     * Tipo de cuenta para la sincronización
     */
    public static final String ACCOUNT_TYPE = "com.example.sync.account";


}
