package com.example.ejerciciowassap;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class ArrayAdapterContacto extends ArrayAdapter<Contacto> {

    private Contacto[] objects;

    public ArrayAdapterContacto(Context context, Contacto[] objects) {
        super(context, R.layout.chat_layout, objects);
        this.objects = objects;
    }

    public View getView(int p, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View item = inflater.inflate(R.layout.chat_layout, null);
        TextView name = (TextView) item.findViewById(R.id.name);
        TextView lastmsg = (TextView) item.findViewById(R.id.lastmsg);
        ImageView img = (ImageView) item.findViewById(R.id.img);
        TextView date = (TextView) item.findViewById(R.id.date);

        name.setText(objects[p].getName());
        lastmsg.setText(objects[p].getLastmsg());
        img.setImageDrawable(objects[p].getImg().getDrawable());
        date.setText(objects[p].getDate());

        return item;

    }
    
}
