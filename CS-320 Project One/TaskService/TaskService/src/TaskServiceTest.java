import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TaskServiceTest {

    @Test
    void testAddTask() {
        TaskService service = new TaskService();
        Task task = new Task("123", "Name", "Description");
        service.addTask(task);
        assertThrows(IllegalArgumentException.class, () -> service.addTask(task));
    }

    @Test
    void testDeleteTask() {
        TaskService service = new TaskService();
        Task task = new Task("123", "Name", "Description");
        service.addTask(task);
        service.deleteTask("123");
        assertThrows(IllegalArgumentException.class, () -> service.deleteTask("123"));
    }

    @Test
    void testUpdateTaskName() {
        TaskService service = new TaskService();
        Task task = new Task("123", "Name", "Description");
        service.addTask(task);
        service.updateTaskName("123", "Updated Name");
        assertEquals("Updated Name", service.tasks.get("123").getName());
    }

    @Test
    void testUpdateTaskDescription() {
        TaskService service = new TaskService();
        Task task = new Task("123", "Name", "Description");
        service.addTask(task);
        service.updateTaskDescription("123", "Updated Description");
        assertEquals("Updated Description", service.tasks.get("123").getDescription());
    }
}