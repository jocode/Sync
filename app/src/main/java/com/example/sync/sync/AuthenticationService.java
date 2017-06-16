package com.example.sync.sync;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;

/**
 * Bound service para gestionar la autenticación
 */
public class AuthenticationService extends Service {

    // Instancia del Autenticador
    private SyncAuthenticator authenticator;

    @Override
    public void onCreate() {
        // Nueva instacia del autenticador
        authenticator = new SyncAuthenticator(this);
    }


    /**
     * Ligando el servicio al Framework de Android
     * @param intent
     * @return
     */
    @Override
    public IBinder onBind(Intent intent) {
        return authenticator.getIBinder();
    }
    
}
