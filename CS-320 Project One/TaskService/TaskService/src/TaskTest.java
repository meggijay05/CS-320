import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TaskTest {

    @Test
    void testTaskCreation() {
        Task task = new Task("123", "Task Name", "Task Description");
        assertEquals("123", task.getTaskId());
        assertEquals("Task Name", task.getName());
        assertEquals("Task Description", task.getDescription());
    }

    @Test
    void testInvalidTaskId() {
        assertThrows(IllegalArgumentException.class, () -> new Task(null, "Name", "Description"));
        assertThrows(IllegalArgumentException.class, () -> new Task("12345678901", "Name", "Description"));
    }

    @Test
    void testInvalidName() {
        assertThrows(IllegalArgumentException.class, () -> new Task("123", null, "Description"));
        assertThrows(IllegalArgumentException.class, () -> new Task("123", "This name is too long for the field", "Description"));
    }

    @Test
    void testInvalidDescription() {
        assertThrows(IllegalArgumentException.class, () -> new Task("123", "Name", null));
        assertThrows(IllegalArgumentException.class, () -> new Task("123", "Name", "This description is way too long for the field and should throw an exception."));
    }
}