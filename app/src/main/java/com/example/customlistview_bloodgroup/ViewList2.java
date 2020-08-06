package com.example.customlistview_bloodgroup;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class ViewList2 extends AppCompatActivity {

    DatabaseHelper helper;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_list2);

        listView = findViewById(R.id.lvBloodGroups);
        helper = new DatabaseHelper(this);

        ArrayList<Person> list = helper.getData();
        
        if (list == null)
        {
            Toast.makeText(this, "No Data", Toast.LENGTH_SHORT).show();
        }

        PersonAdaptor personAdaptor = new PersonAdaptor(this,list);
        listView.setAdapter(personAdaptor);
        personAdaptor.notifyDataSetChanged();


    }
}