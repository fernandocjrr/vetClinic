package animals;

public abstract class Animal {
	
	private String name;
	private int age;
	private String medCondition;
	
	
	public Animal () {
	}
	
	public Animal(String name, int age, String medCondition) {
		super();
		this.name = name;
		this.age = age;
		this.medCondition = medCondition;
	}	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getMedCondition() {
		return medCondition;
	}

	public void setMedCondition(String medCondition) {
		this.medCondition = medCondition;
	}
		
	@Override
	public String toString() {
		return "Animal [name=" + name + ", age=" + age + ", medCondition=" + medCondition + "]";
	}

}
