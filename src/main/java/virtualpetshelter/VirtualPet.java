package virtualpetshelter;

import java.util.Random;

public class VirtualPet {

	private String name;
	private String description;
	private int hunger;
	private int thirst;
	private int boredom;
	private int sleepiness;
	// private int selfCare;
	Random random = new Random();

	public VirtualPet(String name, String description, int hunger, int thirst, int boredom, int sleepiness) {
		this.name = name;
		this.description = description;
		this.hunger = hunger;
		this.thirst = thirst;
		this.boredom = boredom;
		this.sleepiness = sleepiness;
	}

	public VirtualPet(String name, String description) {
		this.name = name;
		this.description = description;
		hunger = random.nextInt(100) + 1;
		thirst = random.nextInt(100) + 1;
		boredom = random.nextInt(100) + 1;
		sleepiness = random.nextInt(100) + 1;

	}

	public String getName() {
		return name;
	}

	public void tick() {
		// selfCare = random.nextInt(15) + 1;
		//
		// if (selfCare == 5) {
		// System.out.println("The dogs look at you with disdain as they take care of
		// themselves");
		// System.exit(0);
		// }
		if (hunger >= 10) {
			hunger -= 10;
		}
		if (boredom >= 10) {
			boredom -= 10;
		}
		if (thirst >= 10) {
			thirst -= 10;
		}
		if (sleepiness >= 10) {
			sleepiness -= 10;
		}

	}

	public int getHungerLvl() {
		return hunger;
	}

	public int getThirstLvl() {
		return thirst;
	}

	public int getBoredomLvl() {
		return boredom;
	}

	public int getSleepinessLvl() {
		return sleepiness;
	}

	public void eat() {
		if (hunger >= 50) {
			hunger -= 30;
		}

	}

	public void drink() {
		thirst -= 40;
	}

	public void play() {
		if (boredom <= 55) {
			boredom -= 50;
		}
		if (thirst >= 10) {
			thirst -= 10;
		}
		if (sleepiness >= 35) {
			sleepiness -= 35;
		}
	}

	public void sleep() {
		if (sleepiness <= 55) {
			sleepiness -= 20;
		}
		if (hunger >= 30) {
			hunger -= 20;
		}
	}

	public void playWithDogPicked() {
		System.out.println(name + "\t|" + description);
	}

	@Override
	public String toString() {
		return "" + this.name + "\t|" + this.hunger + "\t|" + this.boredom + "\t|" + this.thirst + "\t|"
				+ this.sleepiness;
	}

}
