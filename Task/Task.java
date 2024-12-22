public class Task {
    private String taskID;
    private String name;
    private String description;

    /**
     * Constructor for the Task class.
     */
    public Task(String taskID, String name, String description) {
        setTaskID(taskID);
        setName(name);
        setDescription(description);
    }

    /**
     * Returns the task ID.
     *
     * @return the unique ID of the task
     * @see TaskTest#getTaskID()
     */
    public String getTaskID() {
        return taskID;
    }

    /**
     * Sets the task ID.
     * The function is private because the product requirements dictate that the task ID should not be updatable.
     *
     * @param taskID the unique ID of the task
     *
     * @throws IllegalArgumentException if the taskID is greater than 10 characters
     * @see TaskTest#taskIDAboveTen()
     *
     * @throws IllegalArgumentException if the taskID is null
     * @see TaskTest#taskIDToNull()
     *
     * @see TaskTest#taskIDBelowTen()
     * @see TaskTest#taskIDEqualToTen()
     * @see TaskTest#setTaskIDMethodPrivacy()
     */
    private void setTaskID(String taskID) {

        // The task ID should not be null and the test should throw an IllegalArgumentException
        if (taskID == null) {
            throw new IllegalArgumentException("Task ID cannot be null");
        } else if (taskID.length() > 10) {
            throw new IllegalArgumentException("Task ID cannot be longer than 10 characters");
        }

        // By this point all the validation checks have passed and the task ID can be set
        this.taskID = taskID;
    }

    /**
     * Gets the name of the task.
     *
     * @return the name of the task
     *
     * @see TaskTest#setNameBelowTwenty()
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the task.
     *
     * @param name the name of the task
     *
     * @throws IllegalArgumentException if the name is greater than 20 characters
     * @see TaskTest#setNameAboveTwenty()
     *
     * @throws IllegalArgumentException if the name is null
     * @see TaskTest#setNameToNull()
     *
     * @see TaskTest#setNameBelowTwenty()
     * @see TaskTest#setNameEqualToTwenty()
     */
    public void setName(String name) {
        if (name == null) {
            throw new IllegalArgumentException("Name cannot be null");
        } else if (name.length() > 20) {
            throw new IllegalArgumentException("Name cannot be longer than 20 characters");
        }

        this.name = name;
    }

    /**
     * Gets the description of the task.
     *
     * @return the description of the task
     *
     * @see TaskTest#getDescription()
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the description of the task.
     *
     * @param description of the task
     *
     * @throws IllegalArgumentException if the description is null
     * @see TaskTest#setDescriptionToNull()
     *
     * @throws IllegalArgumentException if the description is greater than 50 characters
     * @see TaskTest#setDescriptionAbove50()
     *
     * @see TaskTest#setDescriptionBelow50()
     * @see TaskTest#setDescriptionEqualTo50()
     */
    public void setDescription(String description) {
        if (description == null) {
            throw new IllegalArgumentException("Description cannot be null");
        } else if (description.length() > 50) {
            throw new IllegalArgumentException("Description cannot be longer than 50 characters");
        }

        this.description = description;
    }
}
