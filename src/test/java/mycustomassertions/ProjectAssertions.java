package mycustomassertions;

import ihommani.Person;

import org.assertj.core.api.Assertions;

public class ProjectAssertions extends Assertions {

	public static FriendshipAssert assertThat(Person friend) {
		return new FriendshipAssert(friend);
	}

}
