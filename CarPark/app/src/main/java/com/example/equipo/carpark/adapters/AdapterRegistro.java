package com.example.equipo.carpark.adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.equipo.carpark.R;
import com.example.equipo.carpark.models.Actividad;

import java.util.List;

/**
 * Created by hp on 03/05/2016.
 */
public class AdapterRegistro extends BaseAdapter{


    Context context;
    List<Actividad> actividades;

    public AdapterRegistro(Context context, List<Actividad> actividades) {
        this.context = context;
        this.actividades = actividades;
    }

    @Override
    public int getCount() {
        return actividades.size();

    }

    @Override
    public Object getItem(int position) {
        return actividades.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;
        if(v==null)
            v= View.inflate(context, R.layout.template_registro,null);

        Actividad a = actividades.get(position);

        TextView nombreActividad = (TextView) v.findViewById(R.id.nombreactividad);

        nombreActividad.setText(a.getCodigo());
        return v;

    }
}
