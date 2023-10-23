package task;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicLong;

public class TaskService {
	
	private static AtomicLong idGenerator = new AtomicLong();
	private ArrayList<Task> taskList = new ArrayList<Task>();
		
	public void addTask(String name, String description) {
		String taskID = String.valueOf(idGenerator.getAndIncrement());
		
		if(validateTask(taskID, name, description)) {
			Task task = new Task(taskID, name, description);
			taskList.add(task);
		}
	}
	
	public Task getTask(String taskID) {
		for (Task t : taskList) {
            if (t.getTaskID().equals(taskID)) {
            	return t;
            }
		}
		return null;
	}
	
	public void deleteTask(String taskID) {
		for (Task t : taskList) {
            if (t.getTaskID().equals(taskID)) {
            	taskList.remove(t);
                break;
            }
		}		
	}
	
	public void updateTask(String taskID, String name, String description) {
		if(!validateTask(taskID, name, description)) {return;}
		
		for (Task t : taskList) {
            if (t.getTaskID().equals(taskID)) {
            	t.setName(name);
            	t.setDescription(description);
            }
		}
	}
	
	public boolean validateTask(String taskID, String name, String description) {
		boolean isValid = true;
		
		if(taskID.length() > 10) {isValid = false; }
		if(name == null || name.length() > 20) {isValid = false;}
		if(description == null || description.length() > 50) {isValid = false;}
		
		if(!isValid) {
			throw new IllegalArgumentException("Task is not valid");
		}
		
		return isValid;
	}
}
