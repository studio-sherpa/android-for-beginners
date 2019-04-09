package com.sherpastudio.buildingapplication.view;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.sherpastudio.buildingapplication.R;


public class BuildingViewHolder extends RecyclerView.ViewHolder {

    public TextView nameView;
    public TextView descriptionView;

    public BuildingViewHolder(@NonNull View itemView) {
        super(itemView);
        nameView = itemView.findViewById(R.id.name);
        descriptionView = itemView.findViewById(R.id.description);
    }
}
