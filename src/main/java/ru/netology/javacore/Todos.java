package ru.netology.javacore;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Todos {
    protected final int todosLength = 7;
    List<String> todosList = new ArrayList<>();
    public void addTask(String task) {
        if (todosList.size() < todosLength) {
            todosList.add(task);
        }
    }

    public void removeTask(String task) {
        todosList.remove(task);
    }

    public String getAllTasks() {
        if (todosList.size() > 0) {
            String sortList = "";
            Collections.sort(todosList);
            for (String item : todosList) {
                sortList += item + " ";
            }
            return sortList;
        }
        return "Empty ToDo list";
    }

}
