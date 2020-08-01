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
DatabaseHelper db;

PersonConstants pc =  new PersonConstants();
String imgurl[] = {"https://cdn.now.howstuffworks.com/media-content/0b7f4e9b-f59c-4024-9f06-b3dc12850ab7-1920-1080.jpg",
                    "https://upload.wikimedia.org/wikipedia/commons/a/a0/Pierre-Person.jpg",
                    "https://cdn.psychologytoday.com/sites/default/files/styles/image-article_inline_full/public/field_blog_entry_images/2018-09/shutterstock_648907024.jpg?itok=ji6Xj8tv",
                        "https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcSWliyP7gW39cCy0bxxFQQLf2l6ANn8kSBeUA&usqp=CAU"
                    };


    public PersonAdaptor(@NonNull Context context) {
        super(context,R.layout.row_layout);
        this.context = context;
       // this.values = list;

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
        Picasso.with(context).load(imgurl[position]).resize(80,100).into(ivPhoto);

        Cursor c = db.viewData();

        tvName.setText(values.get(position).getName());
        tvBlood.setText(values.get(position).getBlood_grp());
        tvDes.setText(values.get(position).getDescription());

//        tvName.setText(values.get(position).getName());
//        tvBlood.setText(values.get(position).getBlood_grp());
//        tvDes.setText(values.get(position).getDescription());
        //ivPhoto.setImageResource(values.get(position).getId());

        return rowview;


    }
}
