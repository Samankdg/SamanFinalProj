package com.example.todomvvm.tasks;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.todomvvm.CalendarActivity;
import com.example.todomvvm.LoginActivity;
import com.example.todomvvm.database.User;
import com.example.todomvvm.addedittask.AddEditTaskActivity;
import com.example.todomvvm.R;
import com.example.todomvvm.database.TaskEntry;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;

import java.util.List;


public class MainActivity extends AppCompatActivity implements TaskAdapter.ItemClickListener , NavigationView.OnNavigationItemSelectedListener {

    // Constant for logging
    private static final String TAG = MainActivity.class.getSimpleName();
    // Member variables for the adapter and RecyclerView
    private RecyclerView mRecyclerView;
    private TaskAdapter mAdapter;

    MainActivityViewModel viewModel;

    DrawerLayout drawerLayout;
    NavigationView navigationView;

    private User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        user = (User) getIntent().getSerializableExtra("User");

        if (user != null) {

            viewModel = ViewModelProviders.of(this).get(MainActivityViewModel.class);

            // Set the RecyclerView to its corresponding view
            mRecyclerView = findViewById(R.id.recyclerViewTasks);

            // Set the layout for the RecyclerView to be a linear layout, which measures and
            // positions items within a RecyclerView into a linear list
            mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

            // Initialize the adapter and attach it to the RecyclerView
            mAdapter = new TaskAdapter(this, this);
            mRecyclerView.setAdapter(mAdapter);

            DividerItemDecoration decoration = new DividerItemDecoration(getApplicationContext(), DividerItemDecoration.VERTICAL);
            mRecyclerView.addItemDecoration(decoration);

        /*
         Add a touch helper to the RecyclerView to recognize when a user swipes to delete an item.
         An ItemTouchHelper enables touch behavior (like swipe and move) on each ViewHolder,
         and uses callbacks to signal when a user is performing these actions.
         */
            new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
                @Override
                public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
                    return false;
                }

                // Called when a user swipes left or right on a ViewHolder
                @Override
                public void onSwiped(RecyclerView.ViewHolder viewHolder, int swipeDir) {
                    // Here is where you'll implement swipe to delete

                    int position = viewHolder.getAdapterPosition();
                    List<TaskEntry> todoList = mAdapter.getTasks();
                    viewModel.deleteTask(todoList.get(position));
                }
            }).attachToRecyclerView(mRecyclerView);

            //navigation menu
            drawerLayout = findViewById(R.id.drawer_layout);
            navigationView = findViewById(R.id.nav_view);
            navigationView.bringToFront();
            navigationView.setNavigationItemSelectedListener(this);
            navigationView.setCheckedItem(R.id.nav_home);


        /*
         Set the Floating Action Button (FAB) to its corresponding View.
         Attach an OnClickListener to it, so that when it's clicked, a new intent will be created
         to launch the AddTaskActivity.
         */
            FloatingActionButton fabButton = findViewById(R.id.fab);

            fabButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    // Create a new intent to start an AddTaskActivity
                    Intent addTaskIntent = new Intent(MainActivity.this, AddEditTaskActivity.class);
                    startActivity(addTaskIntent);
                }
            });

            viewModel.getTasks().observe(this, new Observer<List<TaskEntry>>() {
                @Override
                public void onChanged(List<TaskEntry> taskEntries) {
                    mAdapter.setTasks(taskEntries);
                }
            });
        }
    }

    @Override
    public void onItemClickListener(int itemId) {
        // Launch AddTaskActivity adding the itemId as an extra in the intent
        Intent intent = new Intent(MainActivity.this, AddEditTaskActivity.class);
        intent.putExtra(AddEditTaskActivity.EXTRA_TASK_ID, itemId);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.mainmenu, menu);

        //for Search Bar
        MenuItem item = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) item.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                mAdapter.getFilter().filter(newText);
                return true;
            }
        });
        return true;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.nav_home:
                Intent intent = new Intent(MainActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
                break;

            case R.id.nav_calendar:
                Intent intent1 = new Intent(MainActivity.this, CalendarActivity.class);
                startActivity(intent1);
                finish();
                break;

            case R.id.nav_delete:
                viewModel.deleteAllTask();
                Toast.makeText(this, "All TODOs Deleted", Toast.LENGTH_SHORT).show();
                return true;

            case R.id.nav_logout:
                Intent intent2 = new Intent(MainActivity.this, LoginActivity.class);
                finish();
                startActivity(intent2);
                break;

            case R.id.nav_exit:
                finish();
            default:
        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }
}
