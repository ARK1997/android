package com.example.customlistview_bloodgroup;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView lvPerson;
    ArrayList<Person> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvPerson = findViewById(R.id.lvBloodGroups);
        list = new ArrayList<>();

        Person p1 = new Person("Perry","No diseases","A+");
        Person p2 = new Person("Lucifer","Suffering from Corona","O-");
        Person p3 = new Person("Lisa","Suffering from Jaundice","AB+");
        Person p4 = new Person("Candice","No diseases","B+");

        list.add(p1);
        list.add(p2);
        list.add(p3);
        list.add(p4);

        PersonAdaptor personAdaptor = new PersonAdaptor(this,list);

        lvPerson.setAdapter(personAdaptor);

    }
}