package com.example.sync.provider;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Clase envoltura para el gestor de Base de Datos
 */
public class DatabaseHelper extends SQLiteOpenHelper{


    public DatabaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        createTable(db); //Crear tabla gasto
    }

    /**
     * Crear tabla en la base de datos
     * @param db Instancia de la base de datos
     */
    private void createTable(SQLiteDatabase db) {

        String Sql = "CREATE TABLE "+ ContractParaGastos.GASTO + " (" +
                ContractParaGastos.Columnas._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                ContractParaGastos.Columnas.MONTO + " TEXT, "+
                ContractParaGastos.Columnas.ETIQUETA + " TEXT, " +
                ContractParaGastos.Columnas.FECHA + " TEXT, " +
                ContractParaGastos.Columnas.DESCRIPCION + " TEXT," +
                ContractParaGastos.Columnas.ID_REMOTA + " TEXT UNIQUE," +
                ContractParaGastos.Columnas.ESTADO + " INTEGER NOT NULL DEFAULT "+ ContractParaGastos.ESTADO_OK+"," +
                ContractParaGastos.Columnas.PENDIENTE_INSERCION + " INTEGER NOT NULL DEFAULT 0)";

        db.execSQL(Sql);  // Ejecutarla consulta
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        try {
            db.execSQL("DROP TABLE "+ContractParaGastos.GASTO);
        } catch (SQLException exeption){}

        onCreate(db);
    }
}
