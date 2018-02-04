package virtualpetshelter;

import java.util.Random;
import java.util.Scanner;

public class VirtualPetShelterApp {

	public static void main(String[] args) {

		VirtualPetShelter homelessDogs = new VirtualPetShelter();
		Random random = new Random();
		String menuInput = null;
		String continueAdmit = null;
		String removePet = null;
		Scanner input = new Scanner(System.in);

		VirtualPet pet1 = new VirtualPet("Zoey", "Great Pyrenees, she is super lovey, very lazy",
				random.nextInt(100) + 1, random.nextInt(100) + 1, random.nextInt(100) + 1, random.nextInt(100) + 1);
		VirtualPet pet2 = new VirtualPet("Gus", "Bernese Mountain Dog, super clumsy, gives the biggest kisses",
				random.nextInt(100) + 1, random.nextInt(100) + 1, random.nextInt(100) + 1, random.nextInt(100) + 1);
		VirtualPet pet3 = new VirtualPet("Brutus", "English Bull Dog, he got lost, but he thinks he is a giant breed",
				random.nextInt(100) + 1, random.nextInt(100) + 1, random.nextInt(100) + 1, random.nextInt(100) + 1);
		VirtualPet pet4 = new VirtualPet("Maggie", "Newfie, loves to swim, then sleep", random.nextInt(100) + 1,
				random.nextInt(100) + 1, random.nextInt(100) + 1, random.nextInt(100) + 1);

		homelessDogs.admitNewDog(pet1);
		homelessDogs.admitNewDog(pet2);
		homelessDogs.admitNewDog(pet3);
		homelessDogs.admitNewDog(pet4);

		System.out.println("Welcome to Ryan's Giant Breed rescue!");
		homelessDogs.showDogTitle();

		do {
			System.out.println();
			System.out.println("What would you like to do?:");
			System.out.println(
					"1.\tFeed the pets\n2.\tPlay with a pet\n3.\tWater the pets\n4.\tPut the pets to sleep\n5.\tAdmit a pet\n6.\tAdopt a pet\n7.\tDisplay the Pet Status\n8.\tQuit");
			menuInput = input.nextLine();

			if (menuInput.equals("1")) {
				homelessDogs.feedTheDogs();
				homelessDogs.showDogTitle();
				homelessDogs.tick();
			} else if (menuInput.equals("2")) {
				homelessDogs.showNameAndDescriptions();
				System.out.println("Enter the name of the pet you would like to play with.");
				String playWithDog = input.nextLine();
				while (homelessDogs.checkIfPetIsThere(playWithDog)) {
					System.out.println("I'm sorry that pet does not exist. Re enter the pet name: ");
					playWithDog = input.nextLine();
				}
				homelessDogs.playWithSpecificDog(playWithDog);
				homelessDogs.tick();
				System.out.println("You are playing with " + playWithDog);
			} else if (menuInput.equals("3")) {
				homelessDogs.waterTheDogs();
				homelessDogs.showDogTitle();
				homelessDogs.tick();
			} else if (menuInput.equals("4")) {
				homelessDogs.putAllDogsToBed();
				System.out.println("Zzzzzzzzzzz");
				homelessDogs.showDogTitle();
				homelessDogs.tick();
			} else if (menuInput.equals("5")) {
				do {
					System.out.println("Enter the name of the pet you would like to admit:(7 Characters or less)");
					String newPetName = input.nextLine().trim();
					while (newPetName.length() > 7) {
						System.out.println("Name is too long. Please enter a shorter name.");
						newPetName = input.nextLine();
					}
					System.out.println("Enter a description for the pet.");
					String petDescription = input.nextLine();
					homelessDogs.admitNewDog(new VirtualPet(newPetName, petDescription));
					System.out.println("Would you like to admit another animal? (y/n)");
					continueAdmit = input.nextLine();
				} while (continueAdmit.equals("y"));
				homelessDogs.showDogTitle();
				homelessDogs.tick();
			} else if (menuInput.equals("6")) {
				homelessDogs.showNameAndDescriptions();
				do {
					System.out.println("Enter the name of the pet you would like to adopt?");
					removePet = input.nextLine();
					while (!homelessDogs.checkIfPetIsThere(removePet)) {
						System.out.println("I'm sorry that pet does not exist. Re enter the pet name: ");
						removePet = input.nextLine();
					}
					homelessDogs.adoptOutDog(removePet);
					System.out.println("Would you like to adopt another pet? (y/n)");
					removePet = input.nextLine();
					homelessDogs.showDogTitle();
				} while (removePet.equals("y"));
				System.out.println("Thank you for adopting a pet.");
				homelessDogs.tick();
			} else if (menuInput.equals("7")) {
				homelessDogs.showDogTitle();
				homelessDogs.tick();
			}
		} while (!menuInput.equals("8"));
		input.close();
		System.exit(0);

	}

}
