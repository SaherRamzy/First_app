package com.example.saher.first_app;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class ContactAdaptor extends ArrayAdapter<Contact> {
    ArrayList<Contact> list;
    Context con;

    public ContactAdaptor(Context context,ArrayList<Contact> Alis) {
        super(context,R.layout.row_contact, Alis);
        con=context;
        list=Alis;
        //
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater layout=(LayoutInflater) con.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view =layout.inflate(R.layout.row_contact,parent, false);

        TextView fname =(TextView) view.findViewById(R.id.tv_first_name);
        TextView sname =(TextView) view.findViewById(R.id.tv_second_name);
        TextView mob =(TextView) view.findViewById(R.id.tv_mobile);

        fname.setText(list.get(position).first_name);
        sname.setText(list.get(position).second_name);
        mob.setText(list.get(position).mobile);

        return view;
    }


}
