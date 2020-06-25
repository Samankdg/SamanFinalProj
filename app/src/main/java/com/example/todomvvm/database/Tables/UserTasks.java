package com.example.todomvvm.database.Tables;

import androidx.room.Embedded;
import androidx.room.Relation;

import java.util.List;

public class UserTasks {
    @Embedded
    User user;

    @Relation(
            parentColumn = "id",
            entityColumn = "id",
            entity = TaskEntry.class)

    public List<TaskEntry> userTasks;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<TaskEntry> getUserTasks() {
        return userTasks;
    }

    public void setUserTasks(List<TaskEntry> userTODO) {
        this.userTasks = userTODO;
    }
}
