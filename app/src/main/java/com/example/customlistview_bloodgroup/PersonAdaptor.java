package com.example.customlistview_bloodgroup;

import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class PersonAdaptor extends ArrayAdapter<Person> {

private Context context;
private ArrayList<Person>  values;


    public PersonAdaptor(@NonNull Context context,ArrayList<Person> list) {
        super(context,R.layout.row_layout,list);
        this.context = context;
        this.values = list;

    }

    // Calls xml file for each listview row.
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {


        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowview= inflater.inflate(R.layout.row_layout,parent,false);

        TextView tvName= rowview.findViewById(R.id.tvName);
        TextView tvBlood = rowview.findViewById(R.id.tvBloodgroup);
        TextView tvDes= rowview.findViewById(R.id.tvDescription);

        ImageView ivPhoto = rowview.findViewById(R.id.ivPerson);

        Picasso.with(context).load(values.get(position).getURL()).resize(90,100).placeholder(R.drawable.ic_launcher_foreground).into(ivPhoto);

        tvName.setText(values.get(position).getName());
        tvBlood.setText(values.get(position).getBlood_grp());
        tvDes.setText(values.get(position).getDescription());


        return rowview;


    }
}
