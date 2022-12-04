package ru.netology.javacore;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TodosTests {

    Todos todos = new Todos();
    Task task = new Task();

    @BeforeEach
    void setUp() {
        String jsonText = "{ \"type\": \"ADD\", \"task\": \"Play Games\" }";
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        task = gson.fromJson(jsonText, Task.class);
    }

    @Test
    public void testAddTask() {
        todos.addTask(task.getTask());
        Assertions.assertEquals("Play Games", todos.getAllTasks());
    }

    @Test
    public void testRemoveTask() {
        todos.addTask("Finish Homework");
        todos.addTask("Surf the Internet");
        todos.addTask("Clean Room");
        todos.removeTask("Surf the Internet");
        Assertions.assertEquals("Clean Room Finish Homework", todos.getAllTasks());
    }

    @Test
    public void testGetAllTasks() {
        todos.addTask("Finish Homework");
        todos.addTask("Clean Room");
        todos.addTask("Surf the Internet");
        Assertions.assertEquals("Clean Room Finish Homework Surf the Internet", todos.getAllTasks());
    }
}