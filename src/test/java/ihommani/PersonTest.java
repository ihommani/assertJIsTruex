package ihommani;

import mycustomassertions.ProjectAssertions;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;

public class PersonTest {

	Person homer;
	Person marge;
	Person lisa;
	Person bart;
	Person maggie;

	@Before
	public void setUpTheSimpson() {
		homer = new Person("homer", "Simpson", Sexe.MASC);
		marge = new Person("marge", "Simpson", Sexe.FEM);

		// At the begining...
		homer.meet(marge);

		// Then...
		bart = homer.createPerson(marge, "bart", Sexe.MASC);
		lisa = homer.createPerson(marge, "lisa", Sexe.FEM);
		maggie = homer.createPerson(marge, "maggie", Sexe.FEM);

		bart.meet(lisa);
		bart.meet(maggie);
		lisa.meet(maggie);
	}

	@Test
	public void should_give_birth_to_bart() {
		/*
		 * Basic assertions
		 */
		Assertions.assertThat(bart.getSexe()).isEqualTo(Sexe.MASC);
		Assertions.assertThat(bart.getFirstName()).isEqualTo("bart");
		Assertions.assertThat(bart.getFirstName()).startsWith("bar");
		Assertions.assertThat(bart.getLastName()).isEqualTo(homer.getLastName());

		/*
		 * Killer feature Custom assertions, check friendship links (could have
		 * been family links)
		 */
		ProjectAssertions.assertThat(bart).isFriendWith(lisa);

	}

	@Test
	public void should_be_friend() {
		Person bart = new Person("bart", "Simpson", Sexe.MASC);
		Person milhouse = new Person("milhouse", "Van Houten", Sexe.MASC);
		Person nelson = new Person("nelson", "Muntz", Sexe.MASC);
		Person jimbo = new Person("jimbo", "Jones", Sexe.MASC);
		Person dolph = new Person("dolph", "Starbean", Sexe.MASC);

		bart.meet(milhouse);
		bart.meet(nelson);
		bart.meet(jimbo);
		bart.meet(dolph);
		bart.meet(lisa);

		// Map assertions
		Assertions.assertThat(bart.getRelations()).isNotEmpty();
		Assertions.assertThat(bart.getRelations()).doesNotContainKey(bart);
		Assertions.assertThat(bart.getRelations()).containsEntry(milhouse, RelationType.FRIEND).containsEntry(lisa, RelationType.FRIEND);
		Assertions.assertThat(lisa.getRelations()).containsEntry(bart, RelationType.FRIEND);

		// Killer features
		Assertions.assertThat(bart.getRelations().keySet()).extracting("firstName").contains("jimbo", "nelson", "dolph", "lisa").doesNotContain("moe", "barney");

		Assertions.assertThat(bart.getRelations().keySet()).extracting("firstName", "lastName").contains(Assertions.tuple("lisa", "Simpson"), Assertions.tuple("dolph", "Starbean"));

		// Assertions.assertThat(Assertions.filter(bart.getRelations().keySet()).with("lastName").equalsTo("Simpson").get()).contains(marge,
		// homer, lisa, maggie);
	}

	@Test(expected = NullPointerException.class)
	public void should_fail_if_meeting_nobody() {
		Person homer = new Person("homer", "Simpson", Sexe.MASC);
		homer.meet(null);
	}

	// OR

	@Test
	public void should_fail_if_meeting_nobody_second_try() {
		Person homer = new Person("homer", "Simpson", Sexe.MASC);
		try {
			homer.meet(null);
		} catch (Exception e) {
			Assertions.assertThat(e).isInstanceOf(NullPointerException.class);
			Assertions.assertThat(e).hasMessage("You cannot meet nobody!");
		}

	}
}
