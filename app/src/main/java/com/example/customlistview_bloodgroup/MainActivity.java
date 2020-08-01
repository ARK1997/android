package com.example.customlistview_bloodgroup;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    ListView lvPerson;
    ArrayList<Person> list;
    DatabaseHelper db = new DatabaseHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db.deleteItem();

        lvPerson = findViewById(R.id.lvBloodGroups);

          list = new ArrayList<>();

        Person p1 = new Person("Perry","No diseases","A+");
        Person p2 = new Person("Lucifer","Suffering from Corona","O-");
        Person p3 = new Person("Lisa","Suffering from Jaundice","AB+");
        Person p4 = new Person("Candice","No diseases","B+");

        db.insertData(p1);
        db.insertData(p2);
        db.insertData(p3);
        db.insertData(p4);


//        list.add(p1);
//        list.add(p2);
//        list.add(p3);
//        list.add(p4);

        loaddata();


    }




    public void loaddata(){

        list = db.getData();
        PersonAdaptor personAdaptor = new PersonAdaptor(this,list);
        lvPerson.setAdapter(personAdaptor);

    }
}

  //  public void insertToDB(){
//
//        String name = etName.getText().toString();
//        String desc = etDesc.getText().toString();
//        String blood = etBlood.getText().toString();
//
//
//        if (!name.equals("")&&db.insertData(new Person(name,desc,blood)))
//        {
//            Toast.makeText(MainActivity.this, "Data Added", Toast.LENGTH_SHORT).show();
//            etName.setText("");
//            etDesc.setText("");
//            etBlood.setText("");
//        }
//
//        else{
//
//            Toast.makeText(MainActivity.this, "Data not added", Toast.LENGTH_SHORT).show();
//
//        }
//
//    }
