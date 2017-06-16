package com.example.sync.web;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 *  Clase que representa un cliente HTTP Volley
 */

public final class VolleySingleton {

    // Atributos
    private static VolleySingleton singleton;
    private RequestQueue requestQueue;
    private static Context context;

    private VolleySingleton(Context context){
        VolleySingleton.context = context;
        requestQueue = getRequestQueue();
    }


    /**
     * Retorna la instancia única del singleton
     *
     * @param context Contexto donde se ejecutarán las peticiones
     * @return Instancia
     */
    public static synchronized VolleySingleton getInstance(Context context){
        if (singleton == null){
            singleton = new VolleySingleton(context.getApplicationContext());
        }
        return singleton;
    }

    /**
     *  Obtiene la instancia de la cola de peticiones
     *
     * @return requestQueue
     */
    private RequestQueue getRequestQueue() {
        if(requestQueue == null){
            requestQueue = Volley.newRequestQueue(context.getApplicationContext());
        }
        return requestQueue;
    }


    /**
     *  Añade la peticion a la cola
     *
     *  @param request
     *  @param <T> Resultado final tipo T
     */
    public <T> void addToRequestQueue(Request<T> request){
        getRequestQueue().add(request);
    }

}
