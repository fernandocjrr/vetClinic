package user;

public class mainVetClinic {

	Tools tools = new Tools();

	public mainVetClinic() {

		tools.GenerateEmployees();
		tools.GenerateAnimals();
		tools.animalQueue();
		tools.assignMedical();
		
		MainMenu();
		

	}

	public void MainMenu() {

		int userOption = 0;
		boolean exit = false;

		System.out.println("=============================\n" 
						 + "       Veterinary Clinic     \n"
						 + "=============================\n" 
						 + "          MAIN MENU          \n");
		do {
			userOption = Tools.getInput("1>   Staff Menu.\n" 
									  + "2>   Animal Menu.\n\n" 
									  + "0>   Exit.\n");

			if (userOption == 1) {
				System.out.println("\n\n\n\n\n\n\n\n\n");
				staffMenu();
				exit = true;
			} else if (userOption == 2) {
				System.out.println("\n\n\n\n\n\n\n\n\n");
				animalMenu();
				exit = true;
			} else if (userOption == 0) {
				System.out.println("Program Finished!");
				exit = true;
			} else {
				System.out.println("That is not an option.\n"); // in case user type an option that doesn`t exist
			}

		} while (!exit);

	}

	public void staffMenu() {

		int userOption = 0;
		boolean back = false;

		System.out.println("=============================\n" 
						 + "       Veterinary Clinic     \n"
						 + "=============================\n" 
						 + "          STAFF MENU         \n");
		do {
			userOption = Tools.getInput("1>   List all staff.\n" 
								+ "2>   List staff by categories.\n"
								+ "3>   List all Admin staff performing a certain task.\n"
								+ "4>   Search for a specific member of staff by name.\n\n" 
								+ "0>   Back.\n");

			if (userOption == 1) {
				tools.EmployeesList();
			} else if (userOption == 2) {
				System.out.println("\n\n\n\n\n\n\n\n\n");
				staffByCategory();
				back = true;
			} else if (userOption == 3) {

			} else if (userOption == 4) {
				String userInput = Tools.getStringInput("Type the name of the employee:");
				System.out.println("\n\n==============================\n");
				tools.search("employee", userInput);
				
			} else if (userOption == 0) {
				System.out.println("\n\n\n\n\n\n\n\n\n");
				back = true;
				MainMenu();
			} else {
				System.out.println("That is not an option.\n"); // in case user type an option that doesnt exist
			}

		} while (!back);

	}

	public void animalMenu() {

		int userOption = 0;
		boolean back = false;

		System.out.println("=============================\n" 
						 + "       Veterinary Clinic     \n"
						 + "=============================\n" 
						 + "         ANIMAL MENU         \n");
		do {
			userOption = Tools.getInput("1>   List all animals.\n" 
								+ "2>   List animals by various types.\n"
								+ "3>   Search for a specific animal by name.\n"
								+ "4>   List pets queue by veterinarian / Pet Check out.\n\n"
								+ "0>   Back.\n");

			if (userOption == 1) {
				tools.AnimalsList();
			} else if (userOption == 2) {
				System.out.println("\n\n\n\n\n\n\n\n\n");
				animalByType();
				back = true;
			} else if (userOption == 3) {
				String userInput = Tools.getStringInput("Type the name of the animal:");
				System.out.println("\n\n==============================\n");
				tools.search("animal", userInput);
			} else if (userOption == 4) {
				System.out.println("\n\n\n\n\n\n\n\n\n");
				orderPetByStaff();
				back = true;
				
			} else if (userOption == 0) {
				System.out.println("\n\n\n\n\n\n\n\n\n");
				back = true;
				MainMenu();
			} else {
				System.out.println("That is not an option.\n"); // in case user type an option that doesnt exist
			}

		} while (!back);

	}

	public void staffByCategory() {

		int userOption = 0;
		boolean back = false;

		System.out.println("=============================\n" 
						 + "       Veterinary Clinic     \n"
						 + "=============================\n" 
						 + "      STAFF CATEGORIES       \n");
		do {
			userOption = Tools.getInput("1>   Veterinarians.\n" 
								+ "2>   Nurses.\n"
								+ "3>   Trainee Veterinarians.\n"
								+ "4>   Receptionists\n" 
								+ "5>   Human Resource\n\n" 
								+ "0>   Back.\n");

			if (userOption == 1) {
				tools.EmployeesListByCategory("Veterinarian");
			} else if (userOption == 2) {
				tools.EmployeesListByCategory("Nurse");
			} else if (userOption == 3) {
				tools.EmployeesListByCategory("Trainee_Vet");
			} else if (userOption == 4) {
				tools.EmployeesListByCategory("Receptionist");
			} else if (userOption == 5) {
				tools.EmployeesListByCategory("HR_Staff");
			} else if (userOption == 0) {
				System.out.println("\n\n\n\n\n\n\n\n\n");
				back = true;
				staffMenu();
			} else {
				System.out.println("That is not an option.\n"); // in case user type an option that doesnt exist
			}

		} while (!back);

	}
	
	public void animalByType() {

		int userOption = 0;
		boolean back = false;

		System.out.println("=============================\n" 
						 + "       Veterinary Clinic     \n"
						 + "=============================\n" 
						 + "         ANIMAL TYPES        \n");
		do {
			userOption = Tools.getInput("1>   Dogs.\n" 
								+ "2>   Cats.\n"
								+ "3>   Birds.\n"
								+ "4>   Rabbits\n" 
								+ "5>   Hamsters\n\n" 
								+ "0>   Back.\n");

			if (userOption == 1) {
				tools.AnimalsListByType("Dog");
			} else if (userOption == 2) {
				tools.AnimalsListByType("Cat");
			} else if (userOption == 3) {
				tools.AnimalsListByType("Bird");
			} else if (userOption == 4) {
				tools.AnimalsListByType("Rabbit");
			} else if (userOption == 5) {
				tools.AnimalsListByType("Hamster");
			} else if (userOption == 0) {
				System.out.println("\n\n\n\n\n\n\n\n\n");
				back = true;
				animalMenu();
			} else {
				System.out.println("That is not an option.\n"); // in case user type an option that doesnt exist
			}

		} while (!back);

	}
	
	
	public void orderPetByStaff() {
		int userOption = 0;
		boolean back = false;
		
		

		System.out.println("=============================\n" 
						 + "       Veterinary Clinic     \n"
						 + "=============================\n" 
						 + "         CHOOSE STAFF        \n");
		do {
			userOption = Tools.getInput(tools.printVetMenu() + "\n0>   Back.\n");

			for (int i = 0; i < tools.vetList().size(); i++) {
				if (userOption == i + 1) {
										
					tools.listAnimalsAssiged(tools.vetList().get(i));
					back = true;
					checkAnimalOut(tools.vetList().get(i));
					
				} else if (userOption == 0) {
					System.out.println("\n\n\n\n\n\n\n\n\n");
					back = true;
					animalMenu();
				}
			}
			if (userOption > tools.vetList().size()) {
				System.out.println("That is not an option.\n"); // in case user type an option that doesnt exist
			}

		} while (!back);

	}

	
	public void checkAnimalOut(String vetName) {

		int userOption = 0;
		boolean back = false;

		System.out.println("=============================\n" 
						 + "       Veterinary Clinic     \n"
						 + "=============================\n" 
						 + "         PET CHECKOUT        \n");
		do {
			userOption = Tools.getInput("1>   Checkout next pet in line.\n\n"  
									  + "0>   Back.\n");

			if (userOption == 1) {
				tools.checkoutAnimal(vetName);
			} else if (userOption == 0) {
				System.out.println("\n\n\n\n\n\n\n\n\n");
				back = true;
				orderPetByStaff();
			} else {
				System.out.println("That is not an option.\n"); // in case user type an option that doesnt exist
			}

		} while (!back);

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new mainVetClinic();
	}

}
