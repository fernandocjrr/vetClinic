package user;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
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

	ArrayList<Queue<Animal>> queueArray = new ArrayList<Queue<Animal>>();

	HashMap<Staff, Queue> map = new LinkedHashMap<Staff, Queue>();

	String[] firstNames = { "Jack", "James", "Daniel", "Conor", "Sean", "Adam", "Ryan", "Michael", "Harry", "Noah",
			"Thomas", "Alex", "Luke", "Oisin", "Charlie", "Patrick", "Cian", "Liam", "Darragh", "Dylan", "Jamie",
			"Matthew", "Cillian", "Aaron", "Fionn", "Jake", "John", "David", "Ben", "Finn", "Emily", "Emma", "Sophie",
			"Ella", "Amelia", "Aoife", "Ava", "Lucy", "Grace", "Sarah", "Mia", "Anna", "Chloe", "Hannah", "Kate",
			"Ruby", "Lily", "Katie", "Caoimhe", "Sophia", "Lauren", "Saoirse", "Ellie", "Holly", "Leah", "Amy",
			"Olivia", "Jessica", "Ciara", "Zoe" };

	String[] surnames = { "Byrne", "Doherty", "Doyle", "Gallagher", "Kelly", "Kennedy", "Lynch", "McCarthy", "Moore",
			"Murphy", "Murray", "Quinn", "O'Brien", "O'Connor", "O'Neill", "O'Reilly", "O'Sullivan", "Ryan", "Smith",
			"Walsh" };

	String[] petnames = { "Abbey", "Abbie", "Abby", "Abel", "Abigail", "Ace", "Adam", "Addie", "Admiral", "Aggie",
			"Aires", "Aj", "Ajax", "Aldo", "Alex", "Alexus", "Alf", "Alfie", "Allie", "Ally", "Amber", "Amie", "Amigo",
			"Amos", "Amy", "Andy", "Angel", "Angus", "Annie", "Apollo", "April", "Archie", "Argus", "Aries", "Armanti",
			"Arnie", "Arrow", "Ashes", "Ashley", "Astro", "Athena", "Atlas", "Audi", "Augie", "Aussie", "Austin",
			"Autumn", "Axel", "Axle", "Babbles", "Babe", "Baby", "Baby-doll", "Babykins", "Bacchus", "Bailey",
			"Bam-bam", "Bambi", "Bandit", "Banjo", "Barbie", "Barclay", "Barker", "Barkley", "Barley", "Barnaby",
			"Barney", "Baron", "Bart", "Basil", "Baxter", "Bb", "Beamer", "Beanie", "Beans", "Bear", "Beau", "Beauty",
			"Beaux", "Bebe", "Beetle", "Bella", "Belle", "Ben", "Benji", "Benny", "Benson", "Bentley", "Bernie",
			"Bessie", "Biablo", "Bibbles", "Big boy", "Big foot", "Biggie", "Billie", "Billy", "Bingo", "Binky",
			"Birdie", "Birdy", "Biscuit", "Bishop", "Bits", "Bitsy", "Bizzy", "Bj", "Blackie", "Black-jack", "Blanche",
			"Blast", "Blaze", "Blondie", "Blossom", "Blue", "Bo", "Bo", "Bob", "Bobbie", "Bobby", "Bobo", "Bodie",
			"Bogey", "Bones", "Bongo", "Bonnie", "Boo", "Boo-boo", "Booker", "Boomer", "Boone", "Booster", "Bootie",
			"Boots", "Boozer", "Boris", "Bosco", "Bosley", "Boss", "Boy", "Bozley", "Bradley", "Brady", "Braggs",
			"Brandi", "Brando", "Brandy", "Bridgett", "Bridgette", "Brie", "Brindle", "Brit", "Brittany", "Brodie",
			"Brook", "Brooke", "Brownie", "Bruiser", "Bruno", "Brutus", "Bubba", "Bubbles", "Buck", "Buckeye", "Bucko",
			"Bucky", "Bud", "Budda", "Buddie", "Buddy", "Buddy boy", "Buffie", "Buffy", "Bug", "Bugsey", "Bugsy",
			"Bullet", "Bullwinkle", "Bully", "Bumper", "Bunky", "Buster", "Buster-brown", "Butch", "Butchy", "Butter",
			"Butterball", "Buttercup", "Butterscotch", "Buttons", "Buzzy", "Caesar", "Cali", "Callie", "Calvin",
			"Cameo", "Camille", "Candy", "Capone", "Captain", "Carley", "Casey", "Casper", "Cassie", "Cassis",
			"Cha cha", "Chad", "Chamberlain", "Champ", "Chance", "Chanel", "Chaos", "Charisma", "Charles", "Charlie",
			"Charlie brown", "Charmer", "Chase", "Chauncey", "Chaz", "Checkers", "Chelsea", "Cherokee", "Chessie",
			"Chester", "Chevy", "Chewie", "Chewy", "Cheyenne", "Chi chi", "Chic", "Chico", "Chief", "Chili", "China",
			"Chip", "Chipper", "Chippy", "Chips", "Chiquita", "Chivas", "Chloe", "Chocolate", "Chrissy", "Chubbs",
			"Chucky", "Chyna", "Cinder", "Cindy", "Cinnamon", "Cisco", "Claire", "Clancy", "Cleo", "Cleopatra",
			"Clicker", "Clifford", "Clover", "Clyde", "Coal", "Cobweb", "Coco", "Cocoa", "Coconut", "Codi", "Cody",
			"Cole", "Comet", "Commando", "Conan", "Connor", "Cookie", "Cooper", "Copper", "Corky", "Cosmo", "Cotton",
			"Cozmo", "Crackers", "Cricket", "Crystal", "Cubby", "Cubs", "Cujo", "Cupcake", "Curly", "Curry", "Cutie",
			"Cutie-pie", "Cyrus", "Daffy", "Daisey-mae", "Daisy", "Dakota", "Dallas", "Dandy", "Dante", "Daphne",
			"Darby", "Darcy", "Darwin", "Dash", "Dave", "Deacon", "Dee", "Dee dee", "Dempsey", "Destini", "Dewey",
			"Dexter", "Dharma", "Diamond", "Dickens", "Diego", "Diesel", "Digger", "Dillon", "Dinky", "Dino", "Diva",
			"Dixie", "Dobie", "Doc", "Dodger", "Doggon’", "Dolly", "Domino", "Doodles", "Doogie", "Dots", "Dottie",
			"Dozer", "Dragster", "Dreamer", "Duchess", "Dude", "Dudley", "Duffy", "Duke", "Duncan", "Dunn", "Dusty",
			"Dutches", "Dutchess", "Dylan", "Earl", "Ebony", "Echo", "Eddie", "Eddy", "Edgar", "Edsel", "Eifel",
			"Einstein", "Ellie", "Elliot", "Elmo", "Elvis", "Elwood", "Ember", "Emily", "Emma", "Emmy", "Erin", "Ernie",
			"Eva", "Faith", "Fancy", "Felix", "Fergie", "Ferris", "Fido", "Fifi", "Figaro", "Finnegan", "Fiona",
			"Flake", "Flakey", "Flash", "Flint", "Flopsy", "Flower", "Floyd", "Fluffy", "Fonzie", "Foxy", "Francais",
			"Frankie", "Franky", "Freckles", "Fred", "Freddie", "Freddy", "Freedom", "Freeway", "Fresier", "Friday",
			"Frisco", "Frisky", "Fritz", "Frodo", "Frosty", "Furball", "Fuzzy", "Gabby", "Gabriella", "Garfield",
			"Gasby", "Gator", "Gavin", "Genie", "George", "Georgia", "Georgie", "Giant", "Gibson", "Gidget", "Gigi",
			"Gilbert", "Gilda", "Ginger", "Ginny", "Girl", "Gizmo", "Godiva", "Goldie", "Goober", "Goose", "Gordon",
			"Grace", "Grace", "Gracie", "Gracie", "Grady", "Greenie", "Greta", "Gretchen", "Gretel", "Gretta",
			"Griffen", "Gringo", "Grizzly", "Gromit", "Grover", "Gucci", "Guido", "Guinness", "Gunner", "Gunther",
			"Gus", "Guy", "Gypsy", "Hailey", "Haley", "Hallie", "Hamlet", "Hammer", "Hank", "Hanna", "Hannah", "Hans",
			"Happyt", "Hardy", "Harley", "Harpo", "Harrison", "Harry", "Harvey", "Heather", "Heidi", "Henry",
			"Hercules", "Hershey", "Higgins", "Hobbes", "Holly", "Homer", "Honey", "Honey-bear", "Hooch", "Hoover",
			"Hope", "Houdini", "Howie", "Hudson", "Huey", "Hugh", "Hugo", "Humphrey", "Hunter", "India", "Indy", "Iris",
			"Isabella", "Isabelle", "Itsy", "Itsy-bitsy", "Ivory", "Ivy", "Izzy", "Jack", "Jackie", "Jackpot",
			"Jackson", "Jade", "Jagger", "Jags", "Jaguar", "Jake", "Jamie", "Jasmine", "Jasper", "Jaxson", "Jazmie",
			"Jazz", "Jelly", "Jelly-bean", "Jenna", "Jenny", "Jerry", "Jersey", "Jess", "Jesse", "Jesse james",
			"Jessie", "Jester", "Jet", "Jethro", "Jett", "Jetta", "Jewel", "Jewels", "Jimmuy", "Jingles", "Jj", "Joe",
			"Joey", "Johnny", "Jojo", "Joker", "Jolie", "Jolly", "Jordan", "Josie", "Joy", "Jr", "Judy", "Julius",
			"June", "Junior", "Justice", "Kali", "Kallie", "Kane", "Karma", "Kasey", "Katie", "Kato", "Katz", "Kayla",
			"Kc", "Keesha", "Kellie", "Kelly", "Kelsey", "Kenya", "Kerry", "Kibbles", "Kid", "Kiki", "Killian", "King",
			"Kipper", "Kira", "Kirby", "Kismet", "Kissy", "Kitty", "Kiwi", "Klaus", "Koba", "Kobe", "Koda", "Koko",
			"Kona", "Kosmo", "Koty", "Kramer", "Kujo", "Kurly", "Kyra", "Lacey", "Laddie", "Lady", "Ladybug", "Laney",
			"Lassie", "Latte", "Layla", "Lazarus", "Lefty", "Leo", "Levi", "Lexi", "Lexie", "Lexus", "Libby",
			"Lightning", "Lili", "Lilly", "Lily", "Lincoln", "Linus", "Little bit", "Little-guy", "Little-one",
			"Little-rascal", "Lizzy", "Logan", "Loki", "Lola", "Lou", "Louie", "Louis", "Lovey", "Lucas", "Luci",
			"Lucifer", "Lucky", "Lucy", "Luke", "Lulu", "Luna", "Lynx", "Mac", "Macho", "Macintosh", "Mack",
			"Mackenzie", "Macy", "Maddie", "Maddy", "Madison", "Maggie", "Maggie-mae", "Maggie-moo", "Maggy", "Magic",
			"Magnolia", "Major", "Mandi", "Mandy", "Mango", "Marble", "Mariah", "Marley", "Mary", "Mary jane", "Mason",
			"Mattie", "Maverick", "Max", "Maximus", "Maxine", "Maxwell", "May", "Maya", "Mcduff", "Mckenzie", "Meadow",
			"Megan", "Meggie", "Mercedes", "Mercle", "Merlin", "Mia", "Miasy", "Michael", "Mickey", "Midnight", "Mikey",
			"Miko", "Miles", "Miller", "Millie", "Milo", "Mimi", "Mindy", "Ming", "Mini", "Minnie", "Mischief", "Misha",
			"Miss kitty", "Miss priss", "Missie", "Missy", "Mister", "Misty", "Mitch", "Mittens", "Mitzi", "Mitzy",
			"Mo", "Mocha", "Mojo", "Mollie", "Molly", "Mona", "Monkey", "Monster", "Montana", "Montgomery", "Monty",
			"Moocher", "Moochie", "Mookie", "Moonshine", "Moose", "Morgan", "Moses", "Mouse", "Mr kitty", "Muffin",
			"Muffy", "Mugsy", "Mulligan", "Munchkin", "Murphy", "Nakita", "Nala", "Nana", "Napoleon", "Natasha",
			"Nathan", "Nellie", "Nemo", "Nena", "Nero", "Nestle", "Newt", "Newton", "Nibbles", "Nibby", "Nibby-nose",
			"Nick", "Nickers", "Nickie", "Nicky", "Nico", "Nike", "Niki", "Nikita", "Nikki", "Niko", "Nina", "Nitro",
			"Nobel", "Noel", "Nona", "Noodles", "Norton", "Nosey", "Nugget", "Nutmeg", "Oakley", "Obie", "Odie",
			"Old glory", "Olive", "Oliver", "Olivia", "Ollie", "Onie", "Onyx", "Opie", "Oreo", "Oscar", "Otis", "Otto",
			"Oz", "Ozzie", "Ozzy", "Pablo", "Paco", "Paddington", "Paddy", "Panda", "Pandora", "Panther", "Papa",
			"Paris", "Parker", "Pasha", "Patch", "Patches", "Patricky", "Patsy", "Patty", "Peaches", "Peanut",
			"Peanuts", "Pearl", "Pebbles", "Pedro", "Penny", "Pepe", "Pepper", "Peppy", "Pepsi", "Persy", "Pete",
			"Peter", "Petey", "Petie", "Phantom", "Phoebe", "Phoenix", "Picasso", "Pickles", "Pierre", "Piggy",
			"Piglet", "Pink panther", "Pinky", "Pinto", "Piper", "Pippin", "Pippy", "Pip-squeek", "Pirate", "Pixie",
			"Plato", "Pluto", "Pockets", "Pogo", "Pokey", "Polly", "Poncho", "Pongo", "Pooch", "Poochie", "Pooh",
			"Pooh-bear", "Pookie", "Pooky", "Popcorn", "Poppy", "Porche", "Porkchop", "Porky", "Porter", "Powder",
			"Prancer", "Precious", "Presley", "Pretty", "Pretty-girl", "Prince", "Princess", "Prissy", "Puck",
			"Puddles", "Pudge", "Puffy", "Pugsley", "Pumpkin", "Punkin", "Puppy", "Purdy", "Queen", "Queenie", "Quincy",
			"Quinn", "Rags", "Raison", "Ralph", "Ralphie", "Rambler", "Rambo", "Ranger", "Rascal", "Raven", "Rebel",
			"Red", "Reggie", "Reilly", "Remy", "Rex", "Rexy", "Rhett", "Ricky", "Rico", "Riggs", "Riley", "Rin tin tin",
			"Ringo", "Ripley", "Rocco", "Rock", "Rocket", "Rocko", "Rocky", "Roland", "Rolex", "Rollie", "Roman",
			"Romeo", "Rosa", "Roscoe", "Rosebud", "Rosie", "Rosy", "Rover", "Rowdy", "Roxanne", "Roxie", "Roxy", "Ruby",
			"Ruchus", "Rudy", "Ruffe", "Ruffer", "Ruffles", "Rufus", "Ruger", "Rusty", "Ruthie", "Ryder", "Sabine",
			"Sable", "Sabrina", "Sadie", "Sage", "Sailor", "Salem", "Sally", "Salty", "Sam", "Samantha", "Sammy",
			"Sampson", "Samson", "Sandy", "Sara", "Sarah", "Sarge", "Sasha", "Sassie", "Sassy", "Savannah", "Sawyer",
			"Scarlett", "Schotzie", "Schultz", "Scoobie", "Scooby", "Scooby-doo", "Scooter", "Scottie", "Scout",
			"Scrappy", "Scruffy", "Sebastian", "Shadow", "Shady", "Shaggy", "Shasta", "Sheba", "Sheena", "Shelby",
			"Shelly", "Sherman", "Shiloh", "Shiner", "Shorty", "Sienna", "Sierra", "Silky", "Silver", "Silvester",
			"Simba", "Simon", "Simone", "Sissy", "Skeeter", "Skinny", "Skip", "Skipper", "Skippy", "Skittles", "Sky",
			"Skye", "Skyler", "Slick", "Slinky", "Sly", "Smarty", "Smoke", "Smokey", "Smudge", "Sneakers", "Snickers",
			"Snoop", "Snoopy", "Snowball", "Snowflake", "Snowy", "Snuffles", "Snuggles", "Solomon", "Sonny", "Sophia",
			"Sophie", "Sox", "Spanky", "Sparkle", "Sparky", "Speed", "Speedo", "Speedy", "Spencer", "Spike", "Spirit",
			"Spookey", "Spot", "Spotty", "Spud", "Spunky", "Squeeky", "Squirt", "Stanley", "Star", "Starr", "Stella",
			"Sterling", "Stich", "Stinky", "Stormy", "Stuart", "Sugar", "Sugar-baby", "Summer", "Sumo", "Sundance",
			"Sunday", "Sunny", "Sunshine", "Susie", "Susie-q", "Suzy", "Sweetie", "Sweetie-pie", "Sweet-pea", "Sydney",
			"Tabby", "Tabetha", "Taco", "Taffy", "Tally", "Tammy", "Tangles", "Tango", "Tank", "Tanner", "Tara",
			"Tasha", "Taylor", "Taz", "T-bird", "T-bone", "Teddy", "Teddy-bear", "Tequila", "Tess", "Tessa", "Tessie",
			"Tex", "Thelma", "Thor", "Thumper", "Thunder", "Thyme", "Tiffany", "Tiger", "Tigger", "Tiggy", "Tiki",
			"Tilly", "Timber", "Timmy", "Tinker", "Tinker-bell", "Tinky", "Tiny", "Tippy", "Tipr", "Titan", "Tito",
			"Titus", "Tobie", "Toby", "Toffee", "Tom", "Tommy", "Tommy-boy", "Toni", "Tony", "Toots", "Tootsie",
			"Topaz", "Tori", "Toto", "Tracker", "Tramp", "Trapper", "Travis", "Trigger", "Trinity", "Tripod", "Tristan",
			"Trixie", "Trooper", "Trouble", "Troy", "Truffles", "Tuck", "Tucker", "Tuesday", "Tuffy", "Turbo", "Turner",
			"Tux", "Twiggy", "Twinkle", "Ty", "Tyler", "Tyson", "Valinto", "Vava", "Vegas", "Velvet", "Vinnie", "Vinny",
			"Violet", "Vito", "Volvo", "Waddles", "Wags", "Waldo", "Wallace", "Wally", "Walter", "Wayne", "Weaver",
			"Webster", "Wesley", "Westie", "Whiskers", "Whiskey", "Whispy", "Whitie", "Whiz", "Wiggles", "Wilber",
			"Willie", "Willow", "Willy", "Wilson", "Winnie", "Winston", "Winter", "Wiz", "Wizard", "Wolfgang", "Wolfie",
			"Woody", "Woofie", "Wrigley", "Wrinkles", "Wyatt", "Xena", "Yaka", "Yang", "Yeller", "Yellow", "Yin",
			"Yoda", "Yogi", "Yogi-bear", "Yukon", "Zack", "Zeke", "Zena", "Zeus", "Ziggy", "Zippy", "Zoe", "Zoey",
			"Zoie" };
	String[] conditions = { "Allergies - Flea", "Allergies - Food", "Allergies - Skin", "Anal Gland Disease",
			"Arthritis", "Bladder Stones", "Bloat", "Bone Cancer", "Breast Cancer", "Bronchitis", "Cancer",
			"Canine Influenza Virus", "Cherry Eye", "Cysts", "Deafness", "Demodectic Mange", "Dental Disease",
			"Depression", "Diabetes Mellitus (Sugar Diabetes)", "Diarrhea", "Distemper", "Dry Eye", "Ear Conditions",
			"Ear Hematoma", "Ear Infection - External", "Ear Infection - Middle", "Ear Mites", "Ehrlichiosis",
			"Elbow Dysplasia", "Enteritis", "Entropion", "Epiphora", "Esophagus - Enlarged", "Eye Infection",
			"Eyelid Conditions", "Fecal impaction", "Flea Allergy", "Folliculitis", "Foreign Body (Intestinal)",
			"Foreign Body (Nasal and Oral)", "Fractures", "Frostbite", "Gastritis", "Glaucoma", "Head Injuries",
			"Heartworm Infestation", "Heat Stroke", "Herpes Virus", "Hip Dysplasia", "Histoplasmosis",
			"Hookworm Infestation", "Hot Spots (Acute Moist Dermatitis)", "Hypoglycemia", "Hypothyroidism",
			"Incontinence (Urinary)", "Inflammatory Bowel Disease", "Insect Bites", "Intestinal Obstruction",
			"Kennel Cough", "Kidney Disease", "Laryngeal Paralysis", "Laryngitis", "Leukemia", "Lick Granuloma",
			"Lipoma", "Liver Disease", "Lyme Disease", "Lymphoma", "Mange", "Mast Cell Tumors",
			"Megaesophagus (Enlarged Esophagus)", "Motion Sickness", "Mouth Tumors", "Nasal Pigmentation", "Obesity",
			"Osteoarthritis", "Pancreatitis", "Parvovirus", "Periodontal Disease", "Pregnancy", "Prostate Diseases",
			"Pyoderma", "Rabies", "Rhinitis", "Ringworm", "Rocky Mountain Spotted Fever", "Roundworms", "Ruptured Disc",
			"Salmonella", "Scabies (Sarcoptic Mange)", "Seborrhea", "Sinusitis", "Skin Abscess", "Skin Cancer",
			"Skin Diseases", "Skin Tumors", "Soft Tissue Sarcoma", "Stomatitis", "Strains and Sprains", "Tapeworms",
			"Testicular Tumors", "Torn Ligament", "Tracheal Collapse", "Tumors (Skin)", "Ulcers (Stomach)",
			"Urinary Tract Infection", "Uveitis", "Whipworms", "Worms", "Wounds", "Yeast Infection" };

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
			Staff Nur = new Nurse(getRandomName("staff"), 700);
			Employees.add(Nur);
		}
		for (int i = 0; i < 10; i++) {
			Staff Tra = new Trainee_Vet(getRandomName("staff"), 500);
			Employees.add(Tra);
		}

		// ===================ADMIN STAFF===================

		for (int i = 0; i < 5; i++) {
			Staff Rec = new Receptionist(getRandomName("staff"), 400);
			Employees.add(Rec);
		}
		for (int i = 0; i < 5; i++) {
			Staff HRs = new HR_Staff(getRandomName("staff"), 600);
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

	public void printList(String type, int index) {
		if (type.equals("staff")) {
			String cla = null;
			if (Employees.get(index).getClass().getSimpleName().equals("HR_Staff")) {
				cla = "Human Resource";
			} else if (Employees.get(index).getClass().getSimpleName().equals("Trainee_Vet")) {
				cla = "Trainee Veterinarian";
			} else {
				cla = Employees.get(index).getClass().getSimpleName();
			}
			System.out.println("Employee Name: " + Employees.get(index).getName() 
							 + "\nEmployee ID: " + Employees.get(index).getId() 
							 + "\nJob Position: " + cla 
							 + "\nSalary Level: " + Employees.get(index).getSalaryLevel() 
							 + "\n\n==============================\n");
		}

		if (type.equals("animal")) {
			System.out.println("Pet Name: " + Animals.get(index).getName() 
							 + "\nType: " + Animals.get(index).getClass().getSimpleName() 
							 + "\nAge: " + Animals.get(index).getAge()
							 + "\nMedical Condition: " + Animals.get(index).getMedCondition()
							 + "\n\n==============================\n");
		}
	}

	public void EmployeesList() {
		int position = 0;

		for (Staff staff : Employees) {
			printList("staff", position);
			position++;
		}
	}

	public void EmployeesListByCategory(String category) {
		int position = 0;
		for (Staff staff : Employees) {
			if (staff.getClass().getSimpleName().equals(category)) {
				printList("staff", position);
			}
			position++;
		}

	}

	public void AnimalsList() {
		int position = 0;
		for (Animal animal : Animals) {
			printList("animal", position);
			position++;
		}
	}

	public void AnimalsListByType(String type) {
		int position = 0;
		for (Animal animal : Animals) {
			if (animal.getClass().getSimpleName().equals(type)) {
				printList("animal", position);
			}
			position++;
		}
	}

	public void search(String type, String name) {
		boolean found = false;
		if (type == "employee") {
			int position = 0;
			for (Staff staff : Employees) {
				if (staff.getName().equals(name)) {
					found = true;
					printList("staff", position);
				}
				position++;
			}
			if (found == false) {
				System.out.println("Not Found!\n");
			}
		}

		if (type == "animal") {
			int position = 0;
			for (Animal animal : Animals) {
				if (animal.getName().equals(name)) {
					found = true;
					printList("animal", position);
				}
				position++;
			}
			if (found == false) {
				System.out.println("Not Found!\n");
			}
		}

	}

	public void animalQueue() {

		int queueSize = Animals.size() / countVet();

		for (int i = 0; i < countVet(); i++) { // loop 10x (countVet)
			Queue<Animal> queue = new LinkedList<Animal>(); // cria uma queue 10x
			for (int n = 0; n < queueSize; n++) { // Loop 100x (queueSize)
				queue.add(Animals.get((i * queueSize) + n));
			}
			queueArray.add(queue);
		}
	}

	public void assignMedical() {

		int mapCount = 0;

		for (int i = 0; i < Employees.size(); i++) { // Loop 30x (employees)
			if (Employees.get(i).getClass().getSimpleName().equals("Veterinarian")) { // If employee is a veterinarian
				map.put(Employees.get(i), queueArray.get(mapCount));
				mapCount++;
			}
		}
	}

	public int countVet() {
		int count = 0;
		for (Staff staff : Employees) {
			if (staff.getClass().getSimpleName().equals("Veterinarian")) {
				count++;
			}
		}
		return count;
	}

	public ArrayList<String> vetList() {
		ArrayList<String> names = new ArrayList<String>();

		for (Staff staff : Employees) {
			if (staff.getClass().getSimpleName().equals("Veterinarian")) {
				names.add(staff.getName());
			}
		}
		return names;
	}

	public void listAnimalsAssiged(String vetName) {

		for (Map.Entry<Staff, Queue> pet : map.entrySet()){
			Staff key = pet.getKey();						
			Queue values = pet.getValue();
			ArrayList<Animal> petValues = new ArrayList <Animal> (values);
			
			if (key.getName().equals(vetName)) {
				
				for (int i = 0 ; i < petValues.size() ; i ++) {
					System.out.println("Pet Name: " + petValues.get(i).getName() 
							 + "\nType: " + petValues.get(i).getClass().getSimpleName() 
							 + "\nAge: " + petValues.get(i).getAge()
							 + "\nMedical Condition: " + petValues.get(i).getMedCondition()
							 + "\n\n==============================\n");
				}
			}
		}
		
	}

	public static int getInput(String prompt) {

		int input = 0; // variable to store user input
		boolean valid; // variable to check if input is a number
		BufferedReader myReader = new BufferedReader(new InputStreamReader(System.in)); // bufferedreader declaration

		do {
			System.out.println(prompt); // print message in prompt variable

			try {
				input = Integer.parseInt(myReader.readLine()); // Parses the string argument as a signed decimal integer
																// and store the inserted value in input variable
				valid = true; // if valid true leaves the loop

			} catch (Exception e) {
				System.out.println("That is not a number!"); // if not an number display error message
				valid = false; // keep user in the loop to ask for a valid input
			}
		} while (!valid); // finish loop when valid = true

		return input; // return user input
	}

	public static String getStringInput(String prompt) {

		String input = null; // variable to store user input
		boolean valid; // variable to check if input is a number
		BufferedReader myReader = new BufferedReader(new InputStreamReader(System.in)); // bufferedreader declaration

		do {
			System.out.println(prompt); // print message in prompt variable

			try {
				input = myReader.readLine(); // Parses the string argument as a signed decimal integer
												// and store the inserted value in input variable
				valid = true; // if valid true leaves the loop

			} catch (Exception e) {
				System.out.println("Somethig went wrong, try again!");
				valid = false; // keep user in the loop to ask for a valid input
			}
		} while (!valid); // finish loop when valid = true

		return input; // return user input
	}

	public String printVetMenu() {
		String op = null;
		for (int i = 0; i < vetList().size(); i++) {
			if (op == null) {
				op = i + 1 + ">   " + vetList().get(i) + "\n";
			} else {
				op = op + (i + 1) + ">   " + vetList().get(i) + "\n";
			}
		}
		return op;
	}

}
