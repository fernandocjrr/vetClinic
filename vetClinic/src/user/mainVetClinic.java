package user;

public class mainVetClinic {

	Tools tools = new Tools();

	public mainVetClinic() {

		/*	Name: FERNANDO FERNANDEZ CASTELLON JUNIOR
		 *  Student ID: 2019149
		 * 	Vet Clinic continuous assessment
		 * 
		 * 
		 * When program is initialized, the first thing before even showing the menu
		 * it will generate all employees and animals, 
		 * equally divide the animals into queues and insert them in a ArrayList,
		 * and it will create a HashMap, where the key will be all veterinarians and values the queues of animals,
		 * so every veterinarian will be assigned to a queue of animals to treat, in order.
		 * 
		 * Only veterinarians will be assigned to the queue of animals because even if nurses and trainee vets can be assigned, they
		 * should not be responsible for the pets, specially without the supervision of a veterinarian.
		 * 
		 * After this, main menu will be loaded.
		 */
		
		tools.GenerateEmployees();
		tools.GenerateAnimals();
		tools.animalQueue();
		tools.assignMedical();
		tools.assignTask();
		
		MainMenu();
		

	}
	
	// ==============================================================================================================================
	// ========================================================= MAIN MENU =========================================================
	// ==============================================================================================================================

	public void MainMenu() {

		int userOption = 0;
		boolean exit = false;

		String leftAlignFormat = "| %-75s |%n";
		
		System.out.format("+=============================================================================+%n");
		System.out.format("|============================= VETERINARY CLINIC =============================|%n");
		System.out.format("+=============================================================================+%n");
		System.out.format("|                                  MAIN MENU                                  |%n");
		System.out.format("+-----------------------------------------------------------------------------+%n");
		System.out.format(leftAlignFormat,"");
		System.out.format(leftAlignFormat,"          " + "[1]   Staff Menu.");
		System.out.format(leftAlignFormat,"          " + "[2]   Animal Menu.");
		System.out.format(leftAlignFormat,"");
		System.out.format(leftAlignFormat,"          " + "[0]   Exit.");
		System.out.format(leftAlignFormat,"");
		System.out.format("+=============================================================================+%n");
		
		do {
			userOption = Tools.getInput();

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
	
	// ==============================================================================================================================
	// ========================================================= STAFF MENU =========================================================
	// ==============================================================================================================================

	public void staffMenu() {

		int userOption = 0;
		boolean back = false;
		
		String leftAlignFormat = "| %-75s |%n";
		
		System.out.format("+=============================================================================+%n");
		System.out.format("|============================= VETERINARY CLINIC =============================|%n");
		System.out.format("+=============================================================================+%n");
		System.out.format("|                                 STAFF MENU                                  |%n");
		System.out.format("+-----------------------------------------------------------------------------+%n");
		System.out.format(leftAlignFormat,"");
		System.out.format(leftAlignFormat,"          " + "[1]   List all staff");
		System.out.format(leftAlignFormat,"          " + "[2]   List staff by categories.");
		System.out.format(leftAlignFormat,"          " + "[3]   List all Admin staff performing a certain task.");
		System.out.format(leftAlignFormat,"          " + "[4]   Search for a specific member of staff by name.");
		System.out.format(leftAlignFormat,"");
		System.out.format(leftAlignFormat,"          " + "[0]   Exit.");
		System.out.format(leftAlignFormat,"");
		System.out.format("+=============================================================================+%n");

		do {
			userOption = Tools.getInput();

			if (userOption == 1) {
				tools.EmployeesList();
				staffMenu();	
				back = true;			
			} else if (userOption == 2) {
				System.out.println("\n\n\n\n\n\n\n\n\n");
				staffByCategory();
				back = true;				
			} else if (userOption == 3) {
				System.out.println("\n\n\n\n\n\n\n\n\n");
				listTasks();
				back = true;
			} else if (userOption == 4) {
				String userInput = Tools.getStringInput("Type the name of the employee:");
				System.out.println("\n\n-------------------------------\n");
				tools.search("employee", userInput);
				staffMenu();
				back = true;				
			} else if (userOption == 0) {
				System.out.println("\n\n\n\n\n\n\n\n\n");
				MainMenu();
				back = true;
			} else {
				System.out.println("That is not an option.\n"); // in case user type an option that doesnt exist
			}

		} while (!back);

	}
	
	// ==============================================================================================================================
	// ======================================================== ANIMAL MENU =========================================================
	// ==============================================================================================================================

	public void animalMenu() {

		int userOption = 0;
		boolean back = false;

		String leftAlignFormat = "| %-75s |%n";
		
		System.out.format("+=============================================================================+%n");
		System.out.format("|============================= VETERINARY CLINIC =============================|%n");
		System.out.format("+=============================================================================+%n");
		System.out.format("|                                 ANIMAL MENU                                 |%n");
		System.out.format("+-----------------------------------------------------------------------------+%n");
		System.out.format(leftAlignFormat,"");
		System.out.format(leftAlignFormat,"          " + "[1]   List all animals.");
		System.out.format(leftAlignFormat,"          " + "[2]   List animals by various types.");
		System.out.format(leftAlignFormat,"          " + "[3]   Search for a specific animal by name.");
		System.out.format(leftAlignFormat,"          " + "[4]   List pets queue by veterinarian / Pet Check out.");
		System.out.format(leftAlignFormat,"");
		System.out.format(leftAlignFormat,"          " + "[0]   Exit.");
		System.out.format(leftAlignFormat,"");
		System.out.format("+=============================================================================+%n");
		do {
			userOption = Tools.getInput();

			if (userOption == 1) {
				tools.AnimalsList();
				animalMenu();
				back = true;
			} else if (userOption == 2) {
				System.out.println("\n\n\n\n\n\n\n\n\n");
				animalByType();
				back = true;
			} else if (userOption == 3) {
				String userInput = Tools.getStringInput("Type the name of the animal:");
				System.out.println("\n\n-------------------------------\n");
				tools.search("animal", userInput);
				animalMenu();
				back = true;
			} else if (userOption == 4) {
				System.out.println("\n\n\n\n\n\n\n\n\n");
				orderPetByStaff();
				back = true;
			} else if (userOption == 0) {
				System.out.println("\n\n\n\n\n\n\n\n\n");
				MainMenu();
				back = true;
			} else {
				System.out.println("That is not an option.\n"); // in case user type an option that doesnt exist
			}

		} while (!back);

	}
	
	// ==============================================================================================================================
	// ========================================================= TASK MENU ==========================================================
	// ==============================================================================================================================
	
	public void listTasks() {
		int userOption = 0;
		boolean back = false;
		
		String leftAlignFormat = "| %-93s |%n";

		System.out.format("+===============================================================================================+%n");
		System.out.format("|====================================== VETERINARY CLINIC ======================================|%n");
		System.out.format("+===============================================================================================+%n");
		System.out.format("+                                          TASK  MENU                                           +%n");
		System.out.format("+-----------------------------------------------------------------------------------------------+%n");
		System.out.format(leftAlignFormat,"");
		tools.printTaskMenu();
		System.out.format(leftAlignFormat,"");
		System.out.format(leftAlignFormat,"          " + "[0]   Exit.");
		System.out.format(leftAlignFormat,"");
		System.out.format("+===============================================================================================+%n");
		
		do {
			userOption = Tools.getInput();

			for (int i = 0; i < tools.tempTask.size(); i++) {
				if (userOption == i + 1) {
										
					tools.listStaffByTask(i);
					System.out.println("\n");
					listTasks();
					back = true;
					
				} else if (userOption == 0) {
					System.out.println("\n\n\n\n\n\n\n\n\n");
					staffMenu();
					back = true;
				}
			}
			if (userOption > tools.tempTask.size()) {
				System.out.println("That is not an option.\n"); // in case user type an option that doesnt exist
			}

		} while (!back);		
	}
	
	// ==============================================================================================================================
	// ====================================================== STAFF CATEGORIES ======================================================
	// ==============================================================================================================================

	public void staffByCategory() {

		int userOption = 0;
		boolean back = false;

		String leftAlignFormat = "| %-75s |%n";
		
		System.out.format("+=============================================================================+%n");
		System.out.format("|============================= VETERINARY CLINIC =============================|%n");
		System.out.format("+=============================================================================+%n");
		System.out.format("|                               STAFF CATEGORIES                              |%n");
		System.out.format("+-----------------------------------------------------------------------------+%n");
		System.out.format(leftAlignFormat,"");
		System.out.format(leftAlignFormat,"          " + "[1]   Veterinarians.");
		System.out.format(leftAlignFormat,"          " + "[2]   Nurses.");
		System.out.format(leftAlignFormat,"          " + "[3]   Trainee Veterinarians.");
		System.out.format(leftAlignFormat,"          " + "[4]   Receptionists");
		System.out.format(leftAlignFormat,"          " + "[5]   Human Resource");
		System.out.format(leftAlignFormat,"");
		System.out.format(leftAlignFormat,"          " + "[0]   Exit.");
		System.out.format(leftAlignFormat,"");
		System.out.format("+=============================================================================+%n");
		do {
			userOption = Tools.getInput();

			if (userOption == 1) {
				tools.EmployeesListByCategory("Veterinarian");
				staffByCategory();
				back = true;
			} else if (userOption == 2) {
				tools.EmployeesListByCategory("Nurse");
				staffByCategory();
				back = true;
			} else if (userOption == 3) {
				tools.EmployeesListByCategory("Trainee_Vet");
				staffByCategory();
				back = true;
			} else if (userOption == 4) {
				tools.EmployeesListByCategory("Receptionist");
				staffByCategory();
				back = true;
			} else if (userOption == 5) {
				tools.EmployeesListByCategory("HR_Staff");
				staffByCategory();
				back = true;
			} else if (userOption == 0) {
				System.out.println("\n\n\n\n\n\n\n\n\n");
				staffMenu();
				back = true;
			} else {
				System.out.println("That is not an option.\n"); // in case user type an option that doesnt exist
			}

		} while (!back);

	}
	
	// ==============================================================================================================================
	// ======================================================== ANIMAL TYPES ========================================================
	// ==============================================================================================================================
	
	public void animalByType() {

		int userOption = 0;
		boolean back = false;
		String leftAlignFormat = "| %-75s |%n";
		
		System.out.format("+=============================================================================+%n");
		System.out.format("|============================= VETERINARY CLINIC =============================|%n");
		System.out.format("+=============================================================================+%n");
		System.out.format("|                                 ANIMAL TYPES                                |%n");
		System.out.format("+-----------------------------------------------------------------------------+%n");
		System.out.format(leftAlignFormat,"");
		System.out.format(leftAlignFormat,"          " + "[1]   Dogs.");
		System.out.format(leftAlignFormat,"          " + "[2]   Cats");
		System.out.format(leftAlignFormat,"          " + "[3]   Birds.");
		System.out.format(leftAlignFormat,"          " + "[4]   Rabbit");
		System.out.format(leftAlignFormat,"          " + "[5]   Hamsters");
		System.out.format(leftAlignFormat,"");
		System.out.format(leftAlignFormat,"          " + "[0]   Exit.");
		System.out.format(leftAlignFormat,"");
		System.out.format("+=============================================================================+%n");
		
		do {
			userOption = Tools.getInput();

			if (userOption == 1) {
				tools.AnimalsListByType("Dog");
				animalByType();
				back = true;
			} else if (userOption == 2) {
				tools.AnimalsListByType("Cat");
				animalByType();
				back = true;
			} else if (userOption == 3) {
				tools.AnimalsListByType("Bird");
				animalByType();
				back = true;
			} else if (userOption == 4) {
				tools.AnimalsListByType("Rabbit");
				animalByType();
				back = true;
			} else if (userOption == 5) {
				tools.AnimalsListByType("Hamster");
				animalByType();
				back = true;
			} else if (userOption == 0) {
				System.out.println("\n\n\n\n\n\n\n\n\n");
				animalMenu();
				back = true;
			} else {
				System.out.println("That is not an option.\n"); // in case user type an option that doesnt exist
			}

		} while (!back);

	}
	
	// ==============================================================================================================================
	// ========================================================== PET QUEUE =========================================================
	// ==============================================================================================================================
	
	public void orderPetByStaff() {
		int userOption = 0;
		boolean back = false;

		String leftAlignFormat = "| %-75s |%n";
		
		System.out.format("+=============================================================================+%n");
		System.out.format("|============================= VETERINARY CLINIC =============================|%n");
		System.out.format("+=============================================================================+%n");
		System.out.format("|                                 CHOOSE STAFF                                |%n");
		System.out.format("+-----------------------------------------------------------------------------+%n");
		System.out.format(leftAlignFormat,"");
		tools.printVetMenu();
		System.out.format(leftAlignFormat,"");
		System.out.format(leftAlignFormat,"          " + "[0]   Exit.");
		System.out.format(leftAlignFormat,"");
		System.out.format("+=============================================================================+%n");
		
		do {
			userOption = Tools.getInput();

			for (int i = 0; i < tools.vetList().size(); i++) {
				if (userOption == i + 1) {
										
					tools.listAnimalsAssiged(tools.vetList().get(i));
					checkAnimalOut(tools.vetList().get(i));
					back = true;
					
				} else if (userOption == 0) {
					System.out.println("\n\n\n\n\n\n\n\n\n");
					animalMenu();
					back = true;
				}
			}
			if (userOption > tools.vetList().size()) {
				System.out.println("That is not an option.\n"); // in case user type an option that doesnt exist
			}

		} while (!back);

	}

	// ==============================================================================================================================
	// ======================================================== PET CHECKOOUT =======================================================
	// ==============================================================================================================================
	
	public void checkAnimalOut(String vetName) {

		int userOption = 0;
		boolean back = false;
		String leftAlignFormat = "| %-75s |%n";
		
		System.out.format("+=============================================================================+%n");
		System.out.format("|============================= VETERINARY CLINIC =============================|%n");
		System.out.format("+=============================================================================+%n");
		System.out.format("|                                PET CHECKOOUT                                |%n");
		System.out.format("+-----------------------------------------------------------------------------+%n");
		System.out.format(leftAlignFormat,"");
		System.out.format(leftAlignFormat,"          " + "[1]   Checkout next pet in line.");
		System.out.format(leftAlignFormat,"");
		System.out.format(leftAlignFormat,"          " + "[0]   Exit.");
		System.out.format(leftAlignFormat,"");
		System.out.format("+=============================================================================+%n");
		
		do {
			userOption = Tools.getInput();

			if (userOption == 1) {
				tools.checkoutAnimal(vetName);
				orderPetByStaff();
				back = true;
			} else if (userOption == 0) {
				System.out.println("\n\n\n\n\n\n\n\n\n");
				orderPetByStaff();
				back = true;
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
