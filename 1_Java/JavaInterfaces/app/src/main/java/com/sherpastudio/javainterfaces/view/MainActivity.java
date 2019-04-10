package com.sherpastudio.javainterfaces.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.sherpastudio.javainterfaces.R;
import com.sherpastudio.javainterfaces.model.TaskCreator;
import com.sherpastudio.javainterfaces.model.ToDoTask;


public class MainActivity extends AppCompatActivity {

    private ToDoTask[] listOfTasks;
    private TaskListAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Find the RecyclerView object on the layout
        RecyclerView listView = findViewById(R.id.list);

        //Initialise the list of tasks
        listOfTasks = new TaskCreator().createList();

        //Create and set the adapter
        mAdapter = new TaskListAdapter(listOfTasks, new MyItemListener());
        listView.setAdapter(mAdapter);

        //Create and set the layout manager
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getBaseContext());
        listView.setLayoutManager(layoutManager);
    }

    private class MyItemListener implements ItemSelection{

        @Override
        public void onItemSelectionChanged(int position) {
            boolean isDone = listOfTasks[position].isDone();
            if(isDone) listOfTasks[position].markAsNotDone();
            else listOfTasks[position].markAsDone();
            mAdapter.notifyItemChanged(position);
        }
    }


}
