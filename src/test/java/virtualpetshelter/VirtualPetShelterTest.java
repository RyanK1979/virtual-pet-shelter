package virtualpetshelter;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

public class VirtualPetShelterTest {

	private static final String NAME = "Name";
	private static final String DESCRIPTION = "Description";
	private VirtualPetShelter underTest;

	@Before
	public void setup() {
		underTest = new VirtualPetShelter();
		underTest.admitNewDog(NAME, DESCRIPTION);
	}

	@Test
	public void shouldTakeInNewPet() {
		VirtualPet dog = underTest.getPet(NAME);
		assertThat(dog.getName(), is(NAME));
	}

	@Test
	public void canAdoptAPetOut() {
		underTest.adoptOutPet(NAME);
		assertThat(underTest.checkIfPetIsThere(NAME), is(false));
	}

	@Test
	public void shouldFeedThePetAndResetBowlLvl() {
		underTest.fillFoodBowls(1);
		assertThat(underTest.getFoodLvl(), is(2));
	}

	@Test
	public void shouldWaterThePetAndResetBowlLvl() {
		underTest.fillWaterBowls(1);
		assertThat(underTest.getWaterLvl(), is(2));
	}

	@Test
	public void dogWatcherFailedSoDoItOurselves() {
		underTest.admitNewDogWithSpecialValues("Extra", DESCRIPTION, 50, 50, 50, 50, 50);
		underTest.fillFoodBowls(1);
		underTest.fillWaterBowls(1);
		underTest.dogsDoThereOwnThing();

	}

}
