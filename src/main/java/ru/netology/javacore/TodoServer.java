package ru.netology.javacore;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class TodoServer {
    protected int port;
    private Todos todos;

    public TodoServer(int port, Todos todos) {
        this.port = port;
        this.todos = todos;
    }

    public void start() throws IOException {
        try (ServerSocket serverSocket = new ServerSocket(port)) {
        System.out.println("Starting server at " + port + "...");
            while (true) {
                try (Socket clientSocket = serverSocket.accept();
                     PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                     BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {

                    GsonBuilder builder = new GsonBuilder();
                    Gson gson = builder.create();
                    String inRead = in.readLine();
                    Task task = gson.fromJson(inRead, Task.class);

                    if (task.type.equals("ADD")) {
                        todos.addTask(task.task);
                        System.out.println(todos.getAllTasks());
                        out.println(todos.getAllTasks());
                    } else if (task.type.equals("REMOVE")) {
                        todos.removeTask(task.task);
                        System.out.println(todos.getAllTasks());
                        out.println(todos.getAllTasks());
                    } else {
                        System.out.println("Incorrect input!");
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
