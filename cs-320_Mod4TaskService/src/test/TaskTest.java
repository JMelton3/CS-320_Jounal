package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;


import task.TaskService;

class TaskTest {
	TaskService taskService = new TaskService();

	// This tests all the getter and setters in the Task class.
	@Test
	public void testAddingTask() {
			TaskService taskService = new TaskService();
			taskService.addTask("Laundry", "Wash clothes");
			taskService.addTask("Dishes", "Wash the dishes");
			
			assertEquals("Laundry", taskService.getTask("0").getName());
			assertEquals("Wash clothes", taskService.getTask("0").getDescription());
			
			assertEquals("Dishes", taskService.getTask("1").getName());
			assertEquals("Wash the dishes", taskService.getTask("1").getDescription());
	}
}
