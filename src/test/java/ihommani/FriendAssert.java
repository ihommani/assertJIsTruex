package ihommani;

import org.assertj.core.api.AbstractAssert;

public class FriendAssert <S extends FriendAssert<S, A>, A extends Person> extends AbstractAssert<S, A>{
	
	public FriendAssert(A actual, Class<S> selfType) {
	    super(actual, selfType);
	  }
	
	public S isFriendWith(Person person) {
	    isNotNull();

	    // we overrides the default error message with a more explicit one
	    String errorMessage = "\nExpected person <%s>\nto be:\n  friend with <%s>\n but was:\n  <%s>";

	    // check
	    if (!(actual.getRelations().containsKey(person) && actual.getRelations().get(person) == RelationType.FRIEND)) {
	      failWithMessage(errorMessage, actual.getFirstName(), person.getFirstName(), actual.getRelations().get(person));
	    }

	    return myself;
	  }

}
