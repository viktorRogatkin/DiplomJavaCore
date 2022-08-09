package ru.netology.javacore;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class TodosTest {
    /**
     * Method under test: {@link Todos#addTask(String)}
     */
    @Test
    void testAddTask() {
        (new Todos()).addTask("Task");
        ArrayList<String> stringList = Todos.tasks;
        assertEquals("", stringList.get(0));
        assertEquals("", stringList.get(1));
        assertEquals("", stringList.get(2));
        assertEquals("foo", stringList.get(124));
        assertEquals("foo", stringList.get(125));
        assertEquals("foo", stringList.get(126));
    }

    /**
     * Method under test: {@link Todos#removeTask(String)}
     */
    @Test
    void testRemoveTask() {
        Todos todos = new Todos();
        todos.removeTask("Task");
        assertEquals("[]", todos.getAllTasks());
    }

    /**
     * Method under test: {@link Todos#getAllTasks()}
     */
    @Test
    void testGetAllTasks() {
        assertEquals("[, , , , , , , 42, 42, 42, 42, 42, 42, 42, 4242, 4242, 4242, 4242, 4242, 4242, 4242, 424242, 424242,"
                + " 424242, 424242, 424242, 424242, 424242, 4242Task, 4242Task, 4242Task, 4242Task, 4242Task, 4242Task,"
                + " 4242Task, 42Task, 42Task, 42Task, 42Task, 42Task, 42Task, 42Task, 42Task42, 42Task42, 42Task42,"
                + " 42Task42, 42Task42, 42Task42, 42Task42, 42TaskTask, 42TaskTask, 42TaskTask, 42TaskTask, 42TaskTask,"
                + " 42TaskTask, 42TaskTask, Task, Task, Task, Task, Task, Task, Task, Task, Task, Task, Task, Task, Task,"
                + " Task, Task, Task, Task, Task, Task, Task, Task, Task, Task, Task, Task, Task, Task42, Task42, Task42,"
                + " Task42, Task42, Task42, Task42, Task4242, Task4242, Task4242, Task4242, Task4242, Task4242, Task4242,"
                + " Task42Task, Task42Task, Task42Task, Task42Task, Task42Task, Task42Task, Task42Task, TaskTask, TaskTask,"
                + " TaskTask, TaskTask, TaskTask, TaskTask, TaskTask, TaskTask42, TaskTask42, TaskTask42, TaskTask42,"
                + " TaskTask42, TaskTask42, TaskTask42, TaskTaskTask, TaskTaskTask, TaskTaskTask, TaskTaskTask, TaskTaskTask,"
                + " TaskTaskTask, TaskTaskTask, foo, foo, foo, foo, foo, foo, foo]", (new Todos()).getAllTasks());
    }

    /**
     * Method under test: default or parameterless constructor of {@link Todos}
     */
    @Test
    void testConstructor() {
        Todos actualTodos = new Todos();
        ArrayList<String> expectedListTask = Todos.tasks;
        assertSame(expectedListTask, actualTodos.getListTask());
        assertNull(actualTodos.getTask());
        assertNull(actualTodos.getType());
    }
}

