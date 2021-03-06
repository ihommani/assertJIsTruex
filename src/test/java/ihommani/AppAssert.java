package ihommani;

import org.assertj.core.api.AbstractAssert;
// Assertions is needed if an assertion for Iterable is generated
import org.assertj.core.api.Assertions;


/**
 * {@link App} specific assertions - Generated by CustomAssertionGenerator.
 */
public class AppAssert extends AbstractAssert<AppAssert, App> {

  /**
   * Creates a new </code>{@link AppAssert}</code> to make assertions on actual App.
   * @param actual the App we want to make assertions on.
   */
  public AppAssert(App actual) {
    super(actual, AppAssert.class);
  }

  /**
   * An entry point for AppAssert to follow AssertJ standard <code>assertThat()</code> statements.<br>
   * With a static import, one's can write directly : <code>assertThat(myApp)</code> and get specific assertion with code completion.
   * @param actual the App we want to make assertions on.
   * @return a new </code>{@link AppAssert}</code>
   */
  public static AppAssert assertThat(App actual) {
    return new AppAssert(actual);
  }

}
