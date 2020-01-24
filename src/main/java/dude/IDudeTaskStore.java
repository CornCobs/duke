package dude;

import java.io.IOException;
import java.util.List;

public interface IDudeTaskStore {
    List<Task> getAllTasks();
    void addTask(Task task);
    Task getTask(int index);
    Task removeTask(int index);
    String[] showAllTasks();
    void saveTasksToMemory();
    int taskCount();
}
