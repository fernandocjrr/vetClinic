package staff;

public class Task {

	protected Staff emp;
	protected String task;

	public Task() {
		super();
	}

	public Task(Staff emp, String task) {
		super();
		this.emp = emp;
		this.task = task;
	}

	public Staff getEmp() {
		return emp;
	}

	public void setEmp(Staff emp) {
		this.emp = emp;
	}

	public String getTask() {
		return task;
	}

	public void setTask(String task) {
		this.task = task;
	}

}
