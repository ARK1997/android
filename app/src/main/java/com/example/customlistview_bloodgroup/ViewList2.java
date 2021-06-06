package com.example.customlistview_bloodgroup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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

        //Adding back button
        assert getSupportActionBar() != null;   //null check
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);   //show back button

        listView = findViewById(R.id.lvBloodGroups);
        helper = new DatabaseHelper(this);


        ArrayList<Person> list = helper.getData();

        if (list.isEmpty()) {
            Toast.makeText(this, "Insert Some Data", Toast.LENGTH_SHORT).show();
        } else {
            PersonAdaptor personAdaptor = new PersonAdaptor(this, list);
            listView.setAdapter(personAdaptor);
            personAdaptor.notifyDataSetChanged();
        }


    }

    // Adding functionality to back button
    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }
}