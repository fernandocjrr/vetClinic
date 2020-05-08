package staff;

public abstract class Staff {
	
	private String name;
	private int id;
	private static int idCounter = 0;
	protected double salaryLevel;
	
	
	public Staff() {
	}

	
	public Staff(String name, double salaryLevel) {
		this.name = name;
		this.id = idCounter ++;
		this.salaryLevel = salaryLevel;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public double getSalaryLevel() {
		return salaryLevel;
	}


	public void setSalaryLevel(double salaryLevel) {
		this.salaryLevel = salaryLevel;
	}	
	
	@Override
	public String toString() {
		return "Staff [Name = " + name + " , ID = " + id + ", Salary = " + salaryLevel + "]";
	}

}
