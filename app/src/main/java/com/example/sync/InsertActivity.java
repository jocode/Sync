package com.example.sync;

import android.app.DatePickerDialog;
import android.content.ContentValues;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.sync.R;
import com.example.sync.provider.ContractParaGastos;
import com.example.sync.sync.SyncAdapter;
import com.example.sync.ui.DateDialog;
import com.example.sync.utils.Utilidades;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Actividad de inserción para los gastos
 */
public class InsertActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {
    EditText monto;
    Spinner etiqueta;
    TextView fecha;
    EditText descripcion;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert);

        setToolbar();

        monto = (EditText) findViewById(R.id.monto);
        etiqueta = (Spinner) findViewById(R.id.categoria);
        fecha = (TextView) findViewById(R.id.fecha);
        descripcion = (EditText) findViewById(R.id.descripcion);

        fecha.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        new DateDialog().show(getSupportFragmentManager(), "DatePicker");
                    }
                }
        );
    }

    private void setToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null)
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public void alClickearBoton(View v) {
        String montoText = monto.getText().toString();
        String etiquetaText = etiqueta.getSelectedItem().toString();
        String fechaText = fecha.getText().toString();
        String descripcionText = descripcion.getText().toString();

        ContentValues values = new ContentValues();
        values.put(ContractParaGastos.Columnas.MONTO, montoText);
        values.put(ContractParaGastos.Columnas.ETIQUETA, etiquetaText);
        values.put(ContractParaGastos.Columnas.FECHA, fechaText);
        values.put(ContractParaGastos.Columnas.DESCRIPCION, descripcionText);
        values.put(ContractParaGastos.Columnas.PENDIENTE_INSERCION, 1);

        getContentResolver().insert(ContractParaGastos.CONTENT_URI, values);
        SyncAdapter.sincronizarAhora(this, true);

        if (Utilidades.materialDesign())
            finishAfterTransition();
        else finish();
    }

    @Override
    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date = dateFormat.parse(year + "-" + monthOfYear + "-" + dayOfMonth);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        String outDate = dateFormat.format(date);

        fecha.setText(outDate);
    }

}