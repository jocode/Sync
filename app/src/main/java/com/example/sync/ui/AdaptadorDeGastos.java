package com.example.sync.ui;

import android.content.Context;
import android.database.Cursor;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.sync.R;

/**
 * Adaptador del Recycler View
 */
public class AdaptadorDeGastos extends RecyclerView.Adapter<AdaptadorDeGastos.SyncViewHolder> {

    private Cursor cursor;
    private Context context;

    public static class SyncViewHolder extends RecyclerView.ViewHolder {

        // Campos respectivos de un item
        public TextView tvMonto;
        public TextView tvEtiqueta;
        public TextView tvFecha;


        public SyncViewHolder(View v) {
            super(v);
            tvMonto = (TextView) v.findViewById(R.id.tvMonto);
            tvEtiqueta = (TextView) v.findViewById(R.id.tvEtiqueta);
            tvFecha = (TextView) v.findViewById(R.id.tvFecha);
        }
    }

    public AdaptadorDeGastos(Context context) {
        this.context= context;
    }

    @Override
    public int getItemCount() {
        if (cursor!=null)
            return cursor.getCount();
        return 0;
    }

    @Override
    public SyncViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_layout, viewGroup, false);
        return new SyncViewHolder(view);
    }

    @Override
    public void onBindViewHolder(SyncViewHolder viewHolder, int i) {
        cursor.moveToPosition(i);

        String monto;
        String etiqueta;
        String fecha;

        monto = cursor.getString(1);
        etiqueta = cursor.getString(2);
        fecha = cursor.getString(3);

        viewHolder.tvMonto.setText("$"+monto);
        viewHolder.tvEtiqueta.setText(etiqueta);
        viewHolder.tvFecha.setText(fecha);
    }

    public void swapCursor(Cursor newCursor) {
        cursor = newCursor;
        notifyDataSetChanged();
    }

    public Cursor getCursor() {
        return cursor;
    }

}
