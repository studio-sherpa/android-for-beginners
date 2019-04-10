package com.sherpastudio.javainterfaces.view;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.sherpastudio.javainterfaces.R;
import com.sherpastudio.javainterfaces.model.ImportantTask;
import com.sherpastudio.javainterfaces.model.ToDoTask;


public class ImportantTaskViewHolder extends TaskViewHolder {

    public TextView deadline;

    public ImportantTaskViewHolder(@NonNull View itemView) {
        super(itemView);
        deadline = itemView.findViewById(R.id.deadline);
    }

    @Override
    public void onBind(@NonNull ToDoTask item) {
        super.onBind(item);
        deadline.setText(((ImportantTask)item).getDeadline());
    }
}
