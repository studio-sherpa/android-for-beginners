package com.sherpastudio.buildingapplication.view;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.sherpastudio.buildingapplication.R;
import com.sherpastudio.buildingapplication.model.Building;

public class BuildingAdapter extends RecyclerView.Adapter<BuildingViewHolder> {

    private Building[] mListBuildings;

    public BuildingAdapter(Building [] list){
        this.mListBuildings = list;
    }


    @NonNull
    @Override
    public BuildingViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int position) {
        return new BuildingViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_building, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull BuildingViewHolder buildingViewHolder, int position) {
        Building building = mListBuildings[position];
        if(building == null){
            buildingViewHolder.nameView.setText("NoName");
            buildingViewHolder.descriptionView.setText("Description: Empty building");
        }
        else {
            buildingViewHolder.nameView.setText(building.getName());
            buildingViewHolder.descriptionView.setText("Description: " + building.getDescription());
        }


    }

    @Override
    public int getItemCount() {
        return mListBuildings.length;
    }
}
