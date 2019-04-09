package com.sherpastudio.buildingapplication.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.sherpastudio.buildingapplication.R;
import com.sherpastudio.buildingapplication.model.Building;
import com.sherpastudio.buildingapplication.model.BuildingCreator;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView listView = findViewById(R.id.building_list);

        //Create the list of buildings
        BuildingCreator buildingCreator = new BuildingCreator();
        Building[] listBuildings = buildingCreator.createBuildings();

        //Create and set the adapter
        BuildingAdapter adapter = new BuildingAdapter(listBuildings);
        listView.setAdapter(adapter);

        //Create and set the layout manager
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getBaseContext());
        listView.setLayoutManager(layoutManager);
    }
}
