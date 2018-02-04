package virtualpetshelter;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

public class VirtualPetTest {

	private static final String NAME = "Zoey";
	private static final String DESCRIPTION = "Description";
	private static final int HUNGER = 60;
	private static final int THIRST = 60;
	private static final int BOREDOM = 60;
	private static final int SLEEPINESS = 60;
	private static final int POTTY = 60;
	private VirtualPet underTest;

	@Before
	public void setup() {
		underTest = new VirtualPet(NAME, DESCRIPTION, HUNGER, THIRST, BOREDOM, SLEEPINESS, POTTY);
	}

	@Test
	public void eattingLevelsRaiseAndLower() {
		underTest.eat();
		assertThat(underTest.getHungerLvl(), is(20));
		assertThat(underTest.getThirstLvl(), is(70));
		assertThat(underTest.getSleepinessLvl(), is(70));
		assertThat(underTest.getPottyLvl(), is(80));
	}

	public void drinkingLevelsRiseAndFall() {
		underTest.drink();
		assertThat(underTest.getThirstLvl(), is(20));
		assertThat(underTest.getPottyLvl(), is(80));

	}

	@Test
	public void playLevelsGoUpAndDown() {
		underTest.play();

		assertThat(underTest.getHungerLvl(), is(70));
		assertThat(underTest.getThirstLvl(), is(70));
		assertThat(underTest.getBoredomLvl(), is(20));
		assertThat(underTest.getSleepinessLvl(), is(90));
	}

	@Test
	public void makeSureSleepIsWorking() {
		underTest.sleep();

		assertThat(underTest.getHungerLvl(), is(80));
		assertThat(underTest.getThirstLvl(), is(80));
		assertThat(underTest.getSleepinessLvl(), is(0));

	}

	@Test
	public void makeSurePottyFeatureWorks() {
		underTest.usePotty();
		assertThat(underTest.getPottyLvl(), is(0));
	}

	@Test
	public void tickWillRaiseStuffBy10() {
		underTest.tick();

		assertThat(underTest.getHungerLvl(), is(70));
		assertThat(underTest.getThirstLvl(), is(70));
		assertThat(underTest.getBoredomLvl(), is(70));
		assertThat(underTest.getSleepinessLvl(), is(70));
		assertThat(underTest.getPottyLvl(), is(70));

	}

	@Test
	public void makeSureTheValuesDoNotExceed100() {
		underTest = new VirtualPet(NAME, DESCRIPTION, 100, 100, 100, 100, 100);
		underTest.checkForValuesOver100();

		assertThat(underTest.getHungerLvl(), is(100));
		assertThat(underTest.getThirstLvl(), is(100));
		assertThat(underTest.getBoredomLvl(), is(100));
		assertThat(underTest.getSleepinessLvl(), is(100));
		assertThat(underTest.getPottyLvl(), is(100));
	}
}
