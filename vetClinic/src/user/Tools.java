package user;

import java.util.ArrayList;
import java.util.Random;

import animals.Animal;
import animals.Bird;
import animals.Cat;
import animals.Dog;
import animals.Hamster;
import animals.Rabbit;
import staff.HR_Staff;
import staff.Nurse;
import staff.Receptionist;
import staff.Staff;
import staff.Trainee_Vet;
import staff.Veterinarian;

public class Tools {

	ArrayList<Staff> Employees = new ArrayList<Staff>();
	ArrayList<Animal> Animals = new ArrayList<Animal>();

	String[] firstNames = { "Elias", "Bruno", "Fernando", "Philip", "Jessica", "Thais", "Jeniffer", "Peter" };
	String[] surnames = { "Caetano", "Souza", "Castellon", "Baroni", "Simionato", "Machota", "Grassi" };
	String[] petnames = { "Rex", "Spock", "Buddy", "Bobby", "Chimbo", "Estrela", "Harvey" };
	String[] conditions = { "c2", "c1", "c3", "c4", "c5", "c6", "c7" };

	public Tools() {
		// TODO Auto-generated constructor stub
	}

	public String getRandomName(String type) {
		Random r = new Random();
		if (type.equals("staff")) {
			String fname = firstNames[r.nextInt(firstNames.length)];
			String sname = surnames[r.nextInt(surnames.length)];
			return (fname + " " + sname);
		} else if (type.equals("pet")) {
			String petName = petnames[r.nextInt(petnames.length)];
			return (petName);
		} else {
			return "Animal type should be added in method call";
		}
	}

	public int getRandomAge() {
		Random r = new Random();
		int low = 0;
		int high = 19;
		int age = r.nextInt(high - low) + low;

		return age;
	}

	public String getRandomCondition() {
		Random r = new Random();
		String condition = conditions[r.nextInt(conditions.length)];
		return condition;
	}

	public void GenerateEmployees() {

		// ===================MEDICAL STAFF===================

		for (int i = 0; i < 10; i++) {
			Staff Vet = new Veterinarian(getRandomName("staff"), 1000);
			Employees.add(Vet);
		}
		for (int i = 0; i < 10; i++) {
			Staff Nur = new Nurse(getRandomName("staff"), 1000);
			Employees.add(Nur);
		}
		for (int i = 0; i < 10; i++) {
			Staff Tra = new Trainee_Vet(getRandomName("staff"), 1000);
			Employees.add(Tra);
		}

		// ===================ADMIN STAFF===================

		for (int i = 0; i < 5; i++) {
			Staff Rec = new Receptionist(getRandomName("staff"), 1000);
			Employees.add(Rec);
		}
		for (int i = 0; i < 5; i++) {
			Staff HRs = new HR_Staff(getRandomName("staff"), 1000);
			Employees.add(HRs);
		}
	}

	public void GenerateAnimals() {
		for (int i = 0; i < 200; i++) {
			Animal Dog = new Dog(getRandomName("pet"), getRandomAge(), getRandomCondition());
			Animals.add(Dog);
		}
		for (int i = 0; i < 200; i++) {
			Animal Cat = new Cat(getRandomName("pet"), getRandomAge(), getRandomCondition());
			Animals.add(Cat);
		}
		for (int i = 0; i < 200; i++) {
			Animal Ham = new Hamster(getRandomName("pet"), getRandomAge(), getRandomCondition());
			Animals.add(Ham);
		}
		for (int i = 0; i < 200; i++) {
			Animal Bir = new Bird(getRandomName("pet"), getRandomAge(), getRandomCondition());
			Animals.add(Bir);
		}
		for (int i = 0; i < 200; i++) {
			Animal Rab = new Rabbit(getRandomName("pet"), getRandomAge(), getRandomCondition());
			Animals.add(Rab);
		}
	}

	public void EmployeesList() {
		for (Staff staff : Employees) {
			String cla = null;
			if (staff.getClass().getSimpleName().equals("HR_Staff")) {
				cla = "Human Resource";
			} else if (staff.getClass().getSimpleName().equals("Trainee_Vet")) {
				cla = "Trainee Veterinarian";
			} else {
				cla = staff.getClass().getSimpleName();
			}
			System.out.println("Employee Name: " + staff.getName() + "\nJob Position: " + cla + "\n========================");
		}
	}

	public void AnimalsList() {
		for (Animal animal : Animals) {
			System.out.println("Pet Name: " + animal.getName() + "\nType: " + animal.getClass().getSimpleName()
					+ "\nAge: " + animal.getAge() + "\nMedical Condition: " + animal.getMedCondition() + "\n========================");
		}
	}

}
