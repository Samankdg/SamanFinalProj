package com.example.todomvvm.database;

import androidx.lifecycle.LiveData;

import com.example.todomvvm.database.Tables.TaskEntry;

import java.util.List;

public class Repository {

    TaskDao dao;

    public Repository(AppDatabase appDatabase){
        dao = appDatabase.taskDao();
    }

    public LiveData<List<TaskEntry>> getTasks(){
       return dao.loadAllTasks();
    }

    public LiveData<TaskEntry> getTaskById(int taskId){
        return dao.loadTAskById(taskId);
    }

    public void updateTask(final TaskEntry task){
        AppDatabase.databaseWriteExecutor.execute(new Runnable() {
            @Override
            public void run() {
                dao.update(task);
            }
        });
    }

    public void deleteTask(final TaskEntry task){
        AppDatabase.databaseWriteExecutor.execute(new Runnable() {
            @Override
            public void run() {
               dao.deleteTask(task);
            }
        });
    }
    public void deleteAllTask() {
        AppDatabase.databaseWriteExecutor.execute(new Runnable() {
            @Override
            public void run() {
                dao.deleteAllTask();
            }
        });
    }

    public  void  insertTask(final TaskEntry task){
        AppDatabase.databaseWriteExecutor.execute(new Runnable() {
            @Override
            public void run() {
                dao.insertTask(task);
            }
        });
    }
}
