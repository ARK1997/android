package com.example.customlistview_bloodgroup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText etName,etURL,etDesc,etBlood;
    Button btAdd,btView,btBuilding;
   // ListView listView;


    String name,blood,description,url;
    DatabaseHelper db = new DatabaseHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        assert getSupportActionBar() != null;   //null check
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        etBlood=findViewById(R.id.etBlood);
        etName=findViewById(R.id.etName);
        etDesc = findViewById(R.id.etDesc);
        etURL = findViewById(R.id.etURl);
        btAdd = findViewById(R.id.btInsert);
        btView = findViewById(R.id.btView);
        btBuilding = findViewById(R.id.btBuilding);

        btBuilding.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,ViewListBuilding.class);

                startActivity(intent);
            }
        });

        btView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,ViewList2.class);

                startActivity(intent);
            }
        });

        btAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                name = etName.getText().toString();
                blood= etBlood.getText().toString();
                description = etDesc.getText().toString();
                url = etURL.getText().toString();

                if (etName.length()!=0&&etBlood.length()!=0&&etDesc.length()!=0&&etURL.length()!=0) {
                    Person p = new Person(name,description,blood,url);
                    add(p);
                    etName.setText("");
                    etBlood.setText("");
                    etDesc.setText("");
                    etURL.setText("");

                }
                else {
                    Toast.makeText(MainActivity.this, "Please fill the fields", Toast.LENGTH_SHORT).show();
                }



            }
        });


    }

    public void add(Person person){

        boolean wasInserted= db.insertData(person);

        if(wasInserted)
        {
            Toast.makeText(MainActivity.this, "Data Added", Toast.LENGTH_SHORT).show();
        }
        else
        {
            Toast.makeText(MainActivity.this, "Something went wrong", Toast.LENGTH_SHORT).show();
        }

    }



}


