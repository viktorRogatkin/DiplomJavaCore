package ru.netology.javacore;

import org.junit.jupiter.api.*;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertTrue;

import static org.assertj.core.api.Assertions.*;

public class TodosTests {

    @BeforeAll
    public static void startTesting() {
        System.out.println("Старт тестирования");
    }

    @BeforeEach
    public void setUp() {
        System.out.println("запуск теста");
    }

    @AfterEach
    public void refresh() {
        Todos.tasks.clear();
        System.out.println("тест произведен");
    }

    @AfterAll
    public static void endTesting() {
        System.out.println("Завершение тестирования");
    }

    @Test
    public void testRemoveTask() {
        Todos todos = new Todos();
        String task1 = "Отдых";
        String task2 = "Пробежка";
        String task3 = "Работа";
        Todos.tasks.add(task1);
        Todos.tasks.add(task2);
        Todos.tasks.add(task3);
        todos.removeTask("Работа");
        ArrayList<String> taskList = todos.getListTask();
        assertThat(taskList.size()).isEqualTo(2);
    }

    @Test
    public void testAddNewTask() {
        Todos todos = new Todos();
        String task1 = "Отдых";
        String task2 = "Пробежка";
        String task3 = "Работа";
        Todos.tasks.add(task1);
        Todos.tasks.add(task2);
        Todos.tasks.add(task3);
        assertThat(todos.getListTask().size()).isEqualTo(3);
        todos.addTask("Учеба");
        assertThat(todos.getListTask().size()).isEqualTo(4);
    }

    @Test
    public void testGetAllTasks() {
        Todos todos = new Todos();
        String task1 = "Отдых";
        String task2 = "Пробежка";
        String task3 = "Работа";
        Todos.tasks.add(task1);
        Todos.tasks.add(task2);
        Todos.tasks.add(task3);
        String testTaskLIst = "[Отдых, Пробежка, Работа]";
        assertThat(todos.getAllTasks()).isEqualTo(testTaskLIst);
    }
}
