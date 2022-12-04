package ru.netology.javacore;


import java.util.TreeSet;

public class Todos {
    protected final int TODOSLENGTH = 7;
    protected TreeSet<String> ts = new TreeSet<>();

    public void addTask(String task) {
        if (ts.size() < TODOSLENGTH) {
            ts.add(task);
        }
    }

    public void removeTask(String task) {
        ts.remove(task);
    }

    public String stringCorrector(TreeSet<String> ts) {
        String toDo = ts.toString().replaceAll(",", "");
        StringBuilder sb = new StringBuilder(toDo);
        sb.deleteCharAt(toDo.length() - 1);
        sb.deleteCharAt(0);
        return sb.toString();
    }

    public String getAllTasks() {
        if (ts.isEmpty()) return "Empty ToDo list";
        return stringCorrector(ts);
    }
}

