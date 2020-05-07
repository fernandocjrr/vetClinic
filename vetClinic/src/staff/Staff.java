package staff;

public abstract class Staff {
	
	private String fname;
	private String surname;
	private int id;
	private static int idCounter = 0;
	protected double salaryLevel;
	
	
	public Staff() {
	}

	
	public Staff(String name, String surname, double salaryLevel) {
		this.fname = name;
		this.surname = surname;
		this.id = idCounter ++;
		this.salaryLevel = salaryLevel;
	}


	public String getFname() {
		return fname;
	}


	public void setFname(String fname) {
		this.fname = fname;
	}


	public String getSurname() {
		return surname;
	}


	public void setSurname(String surname) {
		this.surname = surname;
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
		return "Staff [fname=" + fname + ", surname=" + surname + ", id=" + id + ", salaryLevel=" + salaryLevel + "]";
	}
}
