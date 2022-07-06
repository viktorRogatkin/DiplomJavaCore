package ru.netology.javacore;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class TodoServer {

    Todos todos;
    int port;

    public TodoServer(int port, Todos todos) {
        this.port = port;
        this.todos = todos;
    }

    public void start() throws IOException {
        //int port = 8989;
        System.out.println("Starting server at " + port + "...");
        ServerSocket serverSocket = new ServerSocket(port);
        while (true) {
            try (
                    Socket clientSocket = serverSocket.accept();
                    PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                    BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {

                System.out.println("New connection accepted");

                GsonBuilder builder = new GsonBuilder();
                Gson gson = builder.create();
                String tasking;

                tasking = in.readLine();
                if (tasking.equals("0")) break;

                todos = gson.fromJson(tasking, Todos.class);

                switch (todos.getType()) {
                    case "ADD":
                        todos.addTask(todos.getTask());
                        break;
                    case "REMOVE":
                        todos.removeTask(todos.getTask());
                        break;
                }
                out.println(todos.getAllTasks());
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("Соединение разорвано");
            }
        }
    }
}
