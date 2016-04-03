package ihommani;

import org.assertj.core.api.AbstractAssert;
// Assertions is needed if an assertion for Iterable is generated
import org.assertj.core.api.Assertions;
import java.util.Map;


/**
 * {@link Person} specific assertions - Generated by CustomAssertionGenerator.
 */
public class PersonAssert extends AbstractAssert<PersonAssert, Person> {

  /**
   * Creates a new </code>{@link PersonAssert}</code> to make assertions on actual Person.
   * @param actual the Person we want to make assertions on.
   */
  public PersonAssert(Person actual) {
    super(actual, PersonAssert.class);
  }

  /**
   * An entry point for PersonAssert to follow AssertJ standard <code>assertThat()</code> statements.<br>
   * With a static import, one's can write directly : <code>assertThat(myPerson)</code> and get specific assertion with code completion.
   * @param actual the Person we want to make assertions on.
   * @return a new </code>{@link PersonAssert}</code>
   */
  public static PersonAssert assertThat(Person actual) {
    return new PersonAssert(actual);
  }

  /**
   * Verifies that the actual Person's firstName is equal to the given one.
   * @param firstName the given firstName to compare the actual Person's firstName to.
   * @return this assertion object.
   * @throws AssertionError - if the actual Person's firstName is not equal to the given one.
   */
  public PersonAssert hasFirstName(String firstName) {
    // check that actual Person we want to make assertions on is not null.
    isNotNull();

    // overrides the default error message with a more explicit one
    String errorMessage = "\nExpected firstName of:\n  <%s>\nto be:\n  <%s>\nbut was:\n  <%s>";
    
    // null safe check
    String actualFirstName = actual.getFirstName();
    if (!org.assertj.core.util.Objects.areEqual(actualFirstName, firstName)) {
      failWithMessage(errorMessage, actual, firstName, actualFirstName);
    }

    // return the current assertion for method chaining
    return this;
  }

  /**
   * Verifies that the actual Person's lastName is equal to the given one.
   * @param lastName the given lastName to compare the actual Person's lastName to.
   * @return this assertion object.
   * @throws AssertionError - if the actual Person's lastName is not equal to the given one.
   */
  public PersonAssert hasLastName(String lastName) {
    // check that actual Person we want to make assertions on is not null.
    isNotNull();

    // overrides the default error message with a more explicit one
    String errorMessage = "\nExpected lastName of:\n  <%s>\nto be:\n  <%s>\nbut was:\n  <%s>";
    
    // null safe check
    String actualLastName = actual.getLastName();
    if (!org.assertj.core.util.Objects.areEqual(actualLastName, lastName)) {
      failWithMessage(errorMessage, actual, lastName, actualLastName);
    }

    // return the current assertion for method chaining
    return this;
  }

  /**
   * Verifies that the actual Person's relations is equal to the given one.
   * @param relations the given relations to compare the actual Person's relations to.
   * @return this assertion object.
   * @throws AssertionError - if the actual Person's relations is not equal to the given one.
   */
  public PersonAssert hasRelations(Map relations) {
    // check that actual Person we want to make assertions on is not null.
    isNotNull();

    // overrides the default error message with a more explicit one
    String errorMessage = "\nExpected relations of:\n  <%s>\nto be:\n  <%s>\nbut was:\n  <%s>";
    
    // null safe check
    Map actualRelations = actual.getRelations();
    if (!org.assertj.core.util.Objects.areEqual(actualRelations, relations)) {
      failWithMessage(errorMessage, actual, relations, actualRelations);
    }

    // return the current assertion for method chaining
    return this;
  }

  /**
   * Verifies that the actual Person's sexe is equal to the given one.
   * @param sexe the given sexe to compare the actual Person's sexe to.
   * @return this assertion object.
   * @throws AssertionError - if the actual Person's sexe is not equal to the given one.
   */
  public PersonAssert hasSexe(Sexe sexe) {
    // check that actual Person we want to make assertions on is not null.
    isNotNull();

    // overrides the default error message with a more explicit one
    String errorMessage = "\nExpected sexe of:\n  <%s>\nto be:\n  <%s>\nbut was:\n  <%s>";
    
    // null safe check
    Sexe actualSexe = actual.getSexe();
    if (!org.assertj.core.util.Objects.areEqual(actualSexe, sexe)) {
      failWithMessage(errorMessage, actual, sexe, actualSexe);
    }

    // return the current assertion for method chaining
    return this;
  }

}