package virtualpetshelter;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class VirtualPetShelterTest {

	@Test
	public void testIfDogWasAdded() {
		VirtualPetShelter underTest = new VirtualPetShelter();
		underTest.admitNewDog(new VirtualPet(null, null, 23, 0, 0, 0));
		int check = underTest.getSize();
		assertEquals(1, check);
	}

	@Test
	public void testIfTwoGotAdded() {
		VirtualPetShelter underTest = new VirtualPetShelter();
		underTest.admitNewDog(new VirtualPet(null, null, 23, 0, 0, 0));
		underTest.admitNewDog(new VirtualPet("1", null, 43, 0, 0, 0));
		int check = underTest.getSize();
		assertEquals(2, check);
	}

	@Test
	public void testIfPetWasRescued() {
		VirtualPetShelter underTest = new VirtualPetShelter();
		underTest.admitNewDog(new VirtualPet(null, null, 23, 0, 0, 0));
		underTest.admitNewDog(new VirtualPet("1", null, 43, 0, 0, 0));
		underTest.adoptOutDog("1");
		int check = underTest.getSize();
		assertEquals(1, check);
	}

	@Test
	public void testForFeedingWorkingOnOne() {
		VirtualPetShelter underTest = new VirtualPetShelter();
		underTest.admitNewDog(new VirtualPet(null, null, 23, 0, 0, 0));
		underTest.feedTheDogs();
		VirtualPet check = underTest.getDog(null);
		assertEquals(check.getHungerLvl(), 73);
	}

	@Test
	public void testForFeedingWithTwo() {
		VirtualPetShelter underTest = new VirtualPetShelter();
		underTest.admitNewDog(new VirtualPet(null, null, 23, 0, 0, 0));
		underTest.admitNewDog(new VirtualPet("1", null, 43, 0, 0, 0));
		underTest.feedTheDogs();
		VirtualPet check = underTest.getDog(null);
		VirtualPet check2 = underTest.getDog("1");
	}

	@Test
	public void testforWateringWithTwo() {
		VirtualPetShelter underTest = new VirtualPetShelter();
		underTest.admitNewDog(new VirtualPet(null, null, 23, 0, 0, 0));
		underTest.admitNewDog(new VirtualPet("1", null, 43, 0, 0, 0));
		underTest.waterTheDogs();
		VirtualPet check = underTest.getDog(null);
		VirtualPet check2 = underTest.getDog("1");
		assertEquals(check.getThirstLvl(), 68);
		assertEquals(check2.getThirstLvl(), 88);
	}

	@Test
	public void testToSeeIfPlayingWorks() {
		VirtualPetShelter underTest = new VirtualPetShelter();
		underTest.admitNewDog(new VirtualPet(null, null, 10, 10, 23, 0));
		underTest.admitNewDog(new VirtualPet("1", null, 0, 0, 10, 35));
		underTest.admitNewDog(new VirtualPet("1", null, 0, 0, 45, 0));
		underTest.playWithSpecificDog("1");
		VirtualPet check = underTest.getDog("1");

		assertEquals(check.getBoredomLvl(), 45);
		assertEquals(check.getThirstLvl(), 0);
		assertEquals(check.getSleepinessLvl(), 0);
	}

}
