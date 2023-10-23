package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer;

import task.TaskService;


@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class TaskServiceTest {	
	TaskService taskService = new TaskService();

	// Testing invalid length
	@Order(6)
	@Test
	void testDescriptionLength() {
		// Exactly 50 length
		taskService.addTask("Mow Grass", "This will be mowing the lawn and it will look good");
		assertEquals("Mow Grass", taskService.getTask("7").getName());
		assertEquals("This will be mowing the lawn and it will look good", taskService.getTask("7").getDescription());	
		
		// Over 50 length
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			taskService.addTask("Mowing", "This will be mowing the lawn and it will look good.");
		});
	}
	
	@Order(5)
	@Test
	void testNameLength() {
		// Exactly 20 length
		taskService.addTask("I need to do yardwok", "mow lawn");
		assertEquals("I need to do yardwok", taskService.getTask("5").getName());
		assertEquals("mow lawn", taskService.getTask("5").getDescription());	
		
		// Over 20 length
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			taskService.addTask("Wash my car pleaseeee", "wash car");
		});
	}
	
	//Testing nulls
	@Order(4)
	@Test
	void testNullName() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			taskService.addTask(null, "wash car");
		});
	}
	
	@Order(3)
	@Test
	void testNullDescription() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			taskService.addTask("Grass", null);
		});
	}
	
	// testing update and delete.
	@Order(2)
	@Test
	public void testUpdateAndDeleteTask() {
			taskService.addTask("Yardwork", "Mow the grass");
			
			assertEquals("Yardwork", taskService.getTask("2").getName());
			assertEquals("Mow the grass", taskService.getTask("2").getDescription());
			
			taskService.updateTask("2", "Weeds", "Pick the Weeds");
			
			assertEquals("Weeds", taskService.getTask("2").getName());
			assertEquals("Pick the Weeds", taskService.getTask("2").getDescription());
			
			taskService.deleteTask("2");
			
			assertNull(taskService.getTask("2"));
	}
	
	// Testing Adding and Getting Tasks.
	@Order(1)
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