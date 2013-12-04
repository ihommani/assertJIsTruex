package mycustomassertions;

import ihommani.Person;
import ihommani.RelationType;

import org.assertj.core.api.AbstractAssert;

public class FriendshipAssert extends AbstractAssert<FriendshipAssert, Person> {

	public FriendshipAssert(Person friend) {
		super(friend, FriendshipAssert.class);
	}

	public static FriendshipAssert assertThat(Person actual) {
		return new FriendshipAssert(actual);
	}
	
	public FriendshipAssert isFriendWith(Person friend) {
	    // check that actual TolkienCharacter we want to make assertions on is not null.
	    isNotNull();

	    // check condition
	    if (!(friend.getRelations().containsKey(actual) && friend.getRelations().get(actual) == RelationType.FRIEND)) {
	      failWithMessage("Expected <%s> to be friend with <%s> but wasn't :(", actual.getFirstName(), friend.getFirstName());
	    }

	    // return the current assertion for method chaining
	    return this;
	  }
}
