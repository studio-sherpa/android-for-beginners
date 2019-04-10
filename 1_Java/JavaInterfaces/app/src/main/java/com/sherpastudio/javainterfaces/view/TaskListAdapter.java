package com.sherpastudio.javainterfaces.view;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sherpastudio.javainterfaces.R;
import com.sherpastudio.javainterfaces.model.ImportantTask;
import com.sherpastudio.javainterfaces.model.ToDoTask;

public class TaskListAdapter extends RecyclerView.Adapter<TaskViewHolder> {

    private static final int IMPORTANT_TASK = 1;
    private static final int BASIC_TASK = 0;
    private final ItemSelection mItemSelectionListener;

    private ToDoTask[] mListItems;

    public TaskListAdapter(ToDoTask [] list, ItemSelection itemSelection){
        this.mListItems = list;
        this.mItemSelectionListener = itemSelection;
    }


    @NonNull
    @Override
    public TaskViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, final int position) {
        TaskViewHolder viewHolder;
        switch (getItemViewType(position)){
            case IMPORTANT_TASK: viewHolder = new ImportantTaskViewHolder(
                    LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_important_task, viewGroup, false));
            break;
            case BASIC_TASK:
                default:
                    viewHolder = new TaskViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_basic_task, viewGroup, false));
                    break;
        }

        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mItemSelectionListener == null) return;
                mItemSelectionListener.onItemSelectionChanged(position);
            }
        });

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull TaskViewHolder taskViewHolder, int position) {
        ToDoTask item = mListItems[position];
        taskViewHolder.onBind(item);
    }

    @Override
    public int getItemViewType(int position) {
        if(mListItems[position] instanceof ImportantTask){
            return IMPORTANT_TASK;
        }
        else{
            return BASIC_TASK;
        }
    }

    @Override
    public int getItemCount() {
        return mListItems.length;
    }
}
