package task;

public class Task {

	private String _taskID;
	private String _name;
	private String _description;
	
	public Task(String taskID, String name, String description) {
		_taskID = taskID;
		_name = name;
		_description = description;
	}
	
	public String getDescription() {
		return _description;
	}
	
	public void setDescription(String _description) {
		this._description = _description;
	}
	
	public String getName() {
		return _name;
	}
	
	public void setName(String _name) {
		this._name = _name;
	}
	
	public String getTaskID() {
		return _taskID;
	}
	
	public void setTaskID(String _taskID) {
		this._taskID = _taskID;
	}	
}