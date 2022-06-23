package ru.netology.javacore;

import java.util.*;
import java.util.stream.Collectors;

public class Todos {
    private String type;
    private String task;
    static ArrayList<String> tasks = new ArrayList<>(); //static ?

    public void addTask(String task) {
        tasks.add(task);
        Collections.sort(tasks);
    }

    public void removeTask(String task) {
        tasks.remove(task);
    }

    public String getAllTasks() {
        return tasks.toString();
    }

    public ArrayList<String> getListTask() {
        return tasks;
    }

    public String getType() {
        return type;
    }

    public String getTask() {
        return task;
    }
}
