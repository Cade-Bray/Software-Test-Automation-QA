import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import static org.junit.jupiter.api.Assertions.*;

class TaskTest {

    //********** TaskID Tests **********

    @Test
    @DisplayName("getTaskID: Test to ensure that TaskID when constructed will return the correct value")
    void getTaskID() {
        // The Task ID should not be null and the test should pass
        Task task = new Task("1234567890", "TaskName", "desc.");
        assertEquals("1234567890", task.getTaskID());
    }

    @Test
    @DisplayName("setTaskID: Test to ensure that the taskID is private to prevent updates")
    void setTaskIDMethodPrivacy() throws NoSuchMethodException {
        Method setTaskIDMethod = Task.class.getDeclaredMethod("setTaskID", String.class);
        assertFalse(Modifier.isPublic(setTaskIDMethod.getModifiers()), "setTaskID should be private");
    }

    @Test
    @DisplayName("Task Constructor: Test to ensure that TaskID cannot be null")
    void taskIDToNull() {
        // The Task ID should not be null and the test should throw an IllegalArgumentException
        // Since the Task ID setter is private, we need to test this through the constructor.
        assertThrows(IllegalArgumentException.class, () -> new Task(null, "TaskName", "desc."));
    }

    @Test
    @DisplayName("Task Constructor: Test to ensure setting a TaskID below ten characters will pass")
    void taskIDBelowTen() {
        // The Task ID should not be null and the test should pass
        assertDoesNotThrow(() -> new Task("123456789", "TaskName", "desc."));
    }

    @Test
    @DisplayName("Task Constructor: Edge case test to ensure that setting a TaskID of ten characters will pass")
    void taskIDEqualToTen() {
        assertDoesNotThrow(() -> new Task("1234567890", "TaskName12", "desc."));
    }

    @Test
    @DisplayName("Task Constructor: Test to ensure that setting a TaskID longer than 10 characters throws an exception")
    void taskIDAboveTen() {
        assertThrows(IllegalArgumentException.class, () ->
                new Task("genericTaskID", "TaskName123", "desc."));
    }

    //********** End TaskID Tests **********

    //********** Name Tests **********

    @Test
    @DisplayName("getName: Test to ensure getter returns the correct name")
    void getName() {
        // The name should not be null and the test should pass
        Task task = new Task("genericTID", "TaskName", "desc.");
        assertEquals("TaskName", task.getName());
    }

    @Test
    @DisplayName("setName: Test to ensure that setting a name to null throws an exception")
    void setNameToNull() {
        // The name should not be null and the test should throw an IllegalArgumentException

        //Creates a task with a name that is 16 characters long which will pass
        Task task = new Task("genericTID", "TheQuickBrownFox", "desc.");

        //Sets the name to null which will throw an exception
        assertThrows(IllegalArgumentException.class, () -> task.setName(null));
    }

    @Test
    @DisplayName("setName: Test to ensure that setting a name under twenty characters will pass")
    void setNameBelowTwenty() {
        //This is 16 characters long
        String name = "TheQuickBrownFox";
        assertDoesNotThrow(() -> new Task("genericTID", name, "desc."));
    }

    @Test
    @DisplayName("setName: Edge case test to ensure that setting a name of twenty characters will pass")
    void setNameEqualToTwenty() {
        // The name should not be null and the test should pass

        //This is 20 characters long
        String name = "TheQuickBrownFoxIsTo";
        assertDoesNotThrow(() -> new Task("genericTID", name, "desc."));
    }

    @Test
    @DisplayName("setName: Test to ensure that setting a name longer than 20 characters throws an exception")
    void setNameAboveTwenty() {
        // The name should not be greater than 20 characters and the test should throw an IllegalArgumentException
        Task task = new Task("genericTID", "TheQuickBrownFox", "desc.");
        assertThrows(IllegalArgumentException.class, () -> task.setName("This name is longer than 20 characters"));
    }

    //********** End Name Tests **********

    //********** Description Tests **********

    @Test
    @DisplayName("getDescription: Test to ensure getter returns the correct description")
    void getDescription() {
        Task task = new Task("genericTID", "TaskName", "desc.");
        assertEquals("desc.", task.getDescription());
    }

    @Test
    @DisplayName("setDescription: Test to ensure that setting a description to null throws an exception")
    void setDescriptionToNull() {
        // The description should not be null and the test should throw an IllegalArgumentException
        Task task = new Task("genericTID", "TaskName", "desc.");
        assertThrows(IllegalArgumentException.class, () -> task.setDescription(null));
    }

    @Test
    @DisplayName("setDescription: Test to ensure that setting a description below 50 characters will pass")
    void setDescriptionBelow50() {
        // This is 49 characters long
        String description = "Lorem ipsum odor amet, consectetuer adipiscing el";
        assertDoesNotThrow(() -> new Task("genericTID", "TaskName", description));
    }

    @Test
    @DisplayName("setDescription: Test to ensure that setting a description to 50 characters will pass")
    void setDescriptionEqualTo50() {
        // This is 50 characters long
        String description = "Lorem ipsum odor amet, consectetuer adipiscing eli";
        assertDoesNotThrow(() -> new Task("genericTID", "TaskName", description));
    }

    @Test
    @DisplayName("setDescription: Edge case to ensure that setting a desc. above 50 characters will throw an exception")
    void setDescriptionAbove50() {
        // This is 51 characters long
        Task task = new Task("genericTID", "TaskName", "desc.");
        assertThrows(IllegalArgumentException.class, () ->
                task.setDescription("Lorem ipsum odor amet, consectetuer adipiscing elit"));
    }

    //********** End Description Tests **********
}