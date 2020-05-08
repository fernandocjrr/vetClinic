package user;

import java.util.ArrayList;
import java.util.Random;

import animals.Animal;
import staff.Staff;
import staff.Veterinarian;
import user.Tools;

public class mainVetClinic {

	public mainVetClinic() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Tools tools = new Tools();
		//tools.GenerateEmployees();
		//tools.EmployeesList();
		tools.GenerateAnimals();
		tools.AnimalsList();
	}
}
