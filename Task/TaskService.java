import java.util.ArrayList;

public class TaskService {
    private final ArrayList<Task> tasks = new ArrayList<>();

    /**
     * Gets the list of tasks.
     *
     * @return the Array list of tasks
     *
     * @see TaskServiceTest#getTasks()
     */
    public ArrayList<Task> getTasks() {
        return tasks;
    }

    /**
     * Finds a task by its ID.
     *
     * @param ID the ID of the task
     * @return the task with the given ID
     *
     * @throws IllegalArgumentException if the task is not found
     * @see TaskServiceTest#findTask()
     * @see TaskServiceTest#findTaskException()
     */
    public Task findTask(String ID) {
        for (Task task : tasks) {
            if (task.getTaskID().equals(ID)) {
                return task;
            }
        }
        throw new IllegalArgumentException("Task not found");
    }

    /**
     * Adds a task to the list.
     *
     * @param ID the ID of the task
     * @param title the title of the task
     * @param description the description of the task
     *
     * @see TaskServiceTest#addTask()
     */
    public void addTask(String ID, String title, String description) {
        Task task = new Task(ID, title, description);
        assert tasks.stream().noneMatch(t -> t.getTaskID().equals(ID)) : "Task already exists";
        tasks.add(task);
    }

    /**
     * Adds a task to the list.
     *
     * @param task the task to add
     *
     * @see TaskServiceTest#addTaskOverload()
     */
    public void addTask(Task task) {
        assert tasks.stream().noneMatch(t -> t.getTaskID().equals(task.getTaskID())) : "Task already exists";
        tasks.add(task);
    }

    /**
     * Removes a task from the list.
     *
     * @param ID the ID of the task
     *
     * @throws IllegalArgumentException if the task is not found
     * @see TaskServiceTest#removeTask()
     * @see TaskServiceTest#removeTaskException()
     */
    public void removeTask(String ID) {
        Task task = findTask(ID);
        tasks.remove(task);
    }

    /**
     * Removes a task from the list.
     *
     * @param task the task to remove
     *
     * @see TaskServiceTest#removeTaskOverload()
     * @see TaskServiceTest#removeTaskOverloadException()
     */
    public void removeTask(Task task) {
        if (!tasks.contains(task)) {
            throw new IllegalArgumentException("Task not found");
        }
        tasks.remove(task);
    }

    /**
     * Updates a task in the list.
     *
     * @param ID the ID of the task
     * @param name the name of the task
     * @param description the description of the task
     *
     * @throws IllegalArgumentException if the task is not found
     * @see TaskServiceTest#updateTaskName()
     * @see TaskServiceTest#updateTaskDescription()
     */
    public void updateTask(String ID, String name, String description) {
        Task task = findTask(ID);

        task.setName(name);
        task.setDescription(description);
    }
}
