package com.example.equipo.carpark.adapters;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.equipo.carpark.R;
import com.example.equipo.carpark.models.parqueaderos;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by EQUIPO on 21/03/2016.
 */
public class carparkadapters extends BaseAdapter {

    Context context;
    List<parqueaderos> data;



    public carparkadapters (Context context, List<parqueaderos> data){
    this.context = context;
    this.data = data;
}
@Override
public int getCount() {
    return data.size();
}

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v =convertView;
        if (convertView == null)
            v = View.inflate(context, R.layout.template,null);
        parqueaderos p = data.get(position);

        TextView titulo = (TextView) v.findViewById(R.id.titulo);
        titulo.setText(p.getNombre());

        TextView direccion = (TextView) v.findViewById(R.id.direccion);
        direccion.setText(p.getDireccion());

        ImageView img= (ImageView) v.findViewById(R.id.img);

        Uri uri = Uri.parse(p.getImgUrl());
        Picasso.with(context).load(uri).into(img);
        return v;

    }



}

