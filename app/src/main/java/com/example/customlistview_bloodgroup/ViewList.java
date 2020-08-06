package com.example.customlistview_bloodgroup;

import android.os.Bundle;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

class ViewList extends AppCompatActivity {

    DatabaseHelper helper;
    ListView listView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.viewlist);

        listView = findViewById(R.id.lvBloodGroups);
        helper = new DatabaseHelper(this);

        ArrayList<Person> list = helper.getData();

            PersonAdaptor personAdaptor = new PersonAdaptor(this,list);
            listView.setAdapter(personAdaptor);
            personAdaptor.notifyDataSetChanged();


    }
}
