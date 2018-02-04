package virtualpetshelter;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class VirtualPetShelter {

	private Map<String, VirtualPet> dogs = new HashMap<>();

	public Collection<VirtualPet> getDogs() {
		return dogs.values();
	}

	public Collection<VirtualPet> getallDogs() {
		return dogs.values();
	}

	public VirtualPet getDog(String name) {
		return dogs.get(name);
	}

	public void adoptOutDog(String name) {
		dogs.remove(name);
	}

	public boolean checkIfPetIsThere(String name) {
		return dogs.containsKey(name);
	}

	public void feedTheDogs() {
		for (VirtualPet dogs : dogs.values()) {
			dogs.eat();
		}
	}

	public void waterTheDogs() {
		for (VirtualPet dogs : dogs.values()) {
			dogs.drink();
		}
	}

	public void putAllDogsToBed() {
		for (VirtualPet pet : dogs.values()) {
			pet.sleep();
		}
	}

	public void playWithSpecificDog(String name) {
		for (VirtualPet dog : dogs.values()) {
			if (dogs.containsKey(name)) {
				dog.playWithDogPicked();
			}
		}
	}

	public void showDogTitle() {
		System.out.println("These are the current status of the dogs:");
		System.out.println("Name\t|Hunger\t|Bored\t|Thirst\t|Sleepiness");
		System.out.println("-------\t------\t------\t-------\t----------");
		for (VirtualPet dog : dogs.values()) {
			System.out.println(dog);
		}
	}

	public void showNameAndDescriptions() {
		System.out.println("Name\t|Description");
		System.out.println("------\t|----------");
		for (VirtualPet dog : dogs.values()) {
			dog.playWithDogPicked();
		}
	}

	public void tick() {
		for (VirtualPet dog : dogs.values()) {
			dog.tick();
		}
	}

	public int getSize() {
		return dogs.size();
	}

	public void admitNewDog(VirtualPet pet) {
		dogs.put(pet.getName(), pet);
	}

}
