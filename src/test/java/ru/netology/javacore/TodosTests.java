package ru.netology.javacore;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;

import java.util.ArrayList;

import org.junit.jupiter.api.*;

class TodosTests {
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
    void testAddTask() {
        (new Todos()).addTask("отдых");
        (new Todos()).addTask("пробежка");
        (new Todos()).addTask("работа");
        ArrayList<String> stringList = Todos.tasks;
        assertEquals("отдых",stringList.get(0));
        assertEquals("пробежка", stringList.get(1));
        assertEquals("работа", stringList.get(2));
    }

    @Test
    void testRemoveTask() {
        Todos todos = new Todos();
        todos.addTask("отдых");
        todos.addTask("пробежка");
        todos.addTask("работа");
        ArrayList<String> stringList = Todos.tasks;
        todos.removeTask("пробежка");
        todos.removeTask("отдых");
        assertEquals("[работа]", todos.getAllTasks());
    }

    @Test
    void testGetAllTasks() {
        Todos todos = new Todos();
        todos.addTask("отдых");
        todos.addTask("пробежка");
        todos.addTask("работа");
        assertEquals("[отдых, пробежка, работа]", todos.getAllTasks());
    }

    @Test
    void testConstructor() {
        Todos actualTodos = new Todos();
        ArrayList<String> expectedListTask = Todos.tasks;
        assertSame(expectedListTask, actualTodos.getListTask());
        assertNull(actualTodos.getTask());
        assertNull(actualTodos.getType());
    }
}
