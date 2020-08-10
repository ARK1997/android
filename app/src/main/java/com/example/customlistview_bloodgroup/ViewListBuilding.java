package com.example.customlistview_bloodgroup;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class ViewListBuilding extends AppCompatActivity {

    ListView listView;
    ArrayList<BuildingData> buildingList= new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_list_building);

        //Adding back button
        assert getSupportActionBar() != null;   //null check
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);   //show back button

        listView = findViewById(R.id.lvBuilding);

        BuildingData b1 = new BuildingData("#ID7546","Assigned","Problem in second floor lighting","Amsterdam",
                "2 Days Ago","Electrical","Low","Web Order",R.drawable.ic_baseline_computer_24,R.drawable.ic_baseline_location_city_24);
        BuildingData b2 = new BuildingData("#ID7546","Assigned","Fault in elevator display at Block A in New Atlantis","New Atlantis A",
                "3 Days Ago","Electrical","High",null,R.drawable.ic_baseline_house_24,R.drawable.ic_baseline_location_city_24);
        BuildingData b3 = new BuildingData("#ID7546","Assigned","Half Yearly Maintenance For Air Circuit Breaker","AHU",
                "4 Days Ago","HVAC","Medium","Preventive",R.drawable.ic_baseline_message_24,R.drawable.ic_baseline_location_city_24);
        BuildingData b4 = new BuildingData("#ID7546","nOT Assigned","Flickering of light in ground floor lobby - Block B","Acropolis Block B",
                "4 Days Ago","Electrical","High","Corrective",R.drawable.ic_baseline_house_24,R.drawable.ic_baseline_location_city_24);

        buildingList.add(b1);
        buildingList.add(b2);
        buildingList.add(b3);
        buildingList.add(b4);

        BuildingDataAdapter buildingDataAdapter = new BuildingDataAdapter(this,buildingList);
        listView.setAdapter(buildingDataAdapter);
        buildingDataAdapter.notifyDataSetChanged();

    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }

}