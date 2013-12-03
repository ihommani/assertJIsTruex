<<<<<<< HEAD
package ihommani;

import java.util.Map;

import mycustomassertions.ProjectAssertions;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.failBecauseExceptionWasNotThrown;

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
        assertThat(bart.getSexe()).isEqualTo(Sexe.MASC);
        assertThat(bart.getFirstName()).isEqualTo("bart");
        assertThat(bart.getFirstName()).startsWith("bar");
        assertThat(bart.getLastName()).isEqualTo(homer.getLastName());

		/*
		 * Killer feature Custom assertions, check friendship links (could have been family links)
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

        // Map assertions
        Map<Person,RelationType> bartRelations = bart.getRelations();
        assertThat(bartRelations).isNotEmpty().doesNotContainKey(bart).containsEntry(milhouse, RelationType.FRIEND).containsEntry(jimbo, RelationType.FRIEND);

        /* Killer features */
        //Extracting field from list object
        assertThat(bartRelations.keySet()).extracting("firstName").contains("jimbo", "nelson", "dolph").doesNotContain("moe", "barney");
        // Same with tuple of fields
        assertThat(bartRelations.keySet()).extracting("firstName", "lastName").isNotEmpty().contains(Assertions.tuple("dolph", "Starbean"), Assertions.tuple("milhouse", "Van Houten"));
        // assertion on a filtered list
        assertThat(Assertions.filter(bartRelations.keySet()).with("lastName").equalsTo("Van Houten").get()).contains(milhouse).doesNotContain(jimbo);
    }

    @Test(expected = NullPointerException.class)
    public void should_fail_if_meeting_nobody() {
        Person homer = new Person("homer", "Simpson", Sexe.MASC);
        homer.meet(null);
    }

    // OR

    @Test
    public void should_fail_if_meeting_nobody_second_try() {
        try {
            homer.meet(null);
            failBecauseExceptionWasNotThrown(NullPointerException.class);
        } catch (Exception e) {
            assertThat(e).isInstanceOf(NullPointerException.class);
            assertThat(e).hasMessage("You cannot meet nobody!");
        }
    }
}
