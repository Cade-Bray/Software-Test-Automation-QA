import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TaskServiceTest {

        @Test
        @DisplayName("addTask: Test if the addTask method adds a task to the list")
        void addTask() {
            TaskService taskService = new TaskService();
            taskService.addTask("Task 1", "Name 1", "Description 1");
            assertEquals(1, taskService.getTasks().size());
        }

        @Test
        @DisplayName("addTaskOverload: Test if the addTask overload method adds a task to the list using the Overload method")
        void addTaskOverload() {
            TaskService taskService = new TaskService();
            taskService.addTask("Task 1", "Name 1", "Description 1");
            assertEquals(1, taskService.getTasks().size());
        }

        @Test
        @DisplayName("addTaskException: Test if the addTask method throws an exception when the task already exists")
        void addTaskException() {
            TaskService taskService = new TaskService();
            taskService.addTask("Task 1", "Name 1", "Description 1");
            assertThrows(AssertionError.class, () -> taskService.addTask("Task 1", "Name 1", "Description 1"));
        }

        @Test
        @DisplayName("addTaskOverloadException: Test if the addTask overload method throws an exception when the task already exists")
        void addTaskOverloadException() {
            TaskService taskService = new TaskService();
            taskService.addTask("Task 1", "Name 1", "Description 1");
            Task task = new Task("Task 1", "Name 1", "Description 1");
            assertThrows(AssertionError.class, () -> taskService.addTask(task));
        }

        @Test
        @DisplayName("removeTask: Test if the removeTask method removes a task from the list")
        void removeTask(){
            TaskService taskService = new TaskService();
            taskService.addTask("Task 1", "Name 1", "Description 1");
            taskService.removeTask("Task 1");
            assertEquals(0, taskService.getTasks().size());
        }

        @Test
        @DisplayName("removeTaskException: Test if the removeTask method throws an exception when the task is not found")
        void removeTaskException(){
            TaskService taskService = new TaskService();
            taskService.addTask("Task 1", "Name 1", "Description 1");
            assertThrows(IllegalArgumentException.class, () -> taskService.removeTask("Task 2"));
        }

        @Test
        @DisplayName("removeTaskOverload: Test if the removeTask overload method removes a task from the list using the Overload method")
        void removeTaskOverload() {
            TaskService taskService = new TaskService();
            Task task = new Task("Task 1", "Name 1", "Description 1");
            taskService.addTask(task);

            taskService.removeTask(task);
            assertEquals(0, taskService.getTasks().size());
        }

        @Test
        @DisplayName("removeTaskOverloadException: Test if the removeTask overload method throws an exception when the task is not found")
        void removeTaskOverloadException() {
            TaskService taskService = new TaskService();
            Task task = new Task("Task 1", "Name 1", "Description 1");
            taskService.addTask(task);
            Task task2 = new Task("Task 2", "Name 2", "Description 2");
            assertThrows(IllegalArgumentException.class, () -> taskService.removeTask(task2));
        }

        @Test
        @DisplayName("getTasks: Test if the getTasks method returns a list of tasks")
        void getTasks() {
            TaskService taskService = new TaskService();
            Task task = new Task("Task 1", "Name 1", "Description 1");
            // Using the addTask overload method
            taskService.addTask(task);
            assertEquals(1, taskService.getTasks().size());
        }

        @Test
        @DisplayName("findTask: Test if the findTask method returns a task")
        void findTask() {
            TaskService taskService = new TaskService();
            Task task = new Task("Task 1", "Name 1", "Description 1");
            taskService.addTask(task);
            assertEquals(task, taskService.findTask("Task 1"));
        }

        @Test
        @DisplayName("findTaskException: Test if the findTask method throws an exception when the task is not found")
        void findTaskException() {
            TaskService taskService = new TaskService();
            Task task = new Task("Task 1", "Name 1", "Description 1");
            taskService.addTask(task);
            assertThrows(IllegalArgumentException.class, () -> taskService.findTask("Task 2"));
        }

        @Test
        @DisplayName("updateTaskName: Test if the updateTask method updates a task name")
        void updateTaskName() {
            TaskService taskService = new TaskService();
            Task task = new Task("Task 1", "Name 1", "Description 1");
            taskService.addTask(task);
            taskService.updateTask("Task 1", "Name 2", "Description 1");
            assertEquals("Name 2", taskService.findTask("Task 1").getName());
        }

        @Test
        @DisplayName("updateTaskDescription: Test if the updateTask method updates a task description")
        void updateTaskDescription() {
            TaskService taskService = new TaskService();
            Task task = new Task("Task 1", "Name 1", "Description 1");
            taskService.addTask(task);
            taskService.updateTask("Task 1", "Name 1", "Description 2");
            assertEquals("Description 2", taskService.findTask("Task 1").getDescription());
        }

}