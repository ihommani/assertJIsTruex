package ihommani;

import java.util.Map;

import com.beust.jcommander.internal.Maps;
import com.google.common.base.Preconditions;

/**
 * Base class representing a person
 * @author ismael
 *
 */
public class Person {

	private String firstName;
	private String lastName;
	private Sexe sexe;
	private Map<Person, RelationType> relations = Maps.newHashMap();

	/*
	 * public constructor. Allow to seed the genealogic tree
	 */
	public Person(String firstName, String lastName, Sexe sexe) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.sexe = sexe;
	}

	/**
	 * When two person meet, they become friend.
	 * @param person
	 */
	public void meet(Person otherPerson) {
		Preconditions.checkNotNull(otherPerson, "You cannot meet nobody!");
		this.relations.put(otherPerson, RelationType.FRIEND);
		// Friendship is reflexive
		Map<Person, RelationType> otherPersonRelations = otherPerson.getRelations();
		otherPersonRelations.put(this, RelationType.FRIEND);
	}	

	/**
	 * To create a person, we need a mother and a father
	 * @param mother
	 * @param father
	 * @param firstName
	 * @param sexe
	 * @return
	 */
	public Person createPerson(Person lover, String firstName, Sexe sexe) {
		Preconditions.checkArgument(lover.getSexe() != this.getSexe(), "To create a person we need two different sexes.");
		Preconditions.checkState(this.getRelations().containsKey(lover) && (this.getRelations().get(lover) == RelationType.FRIEND), "You cannot make a baby with an unknown or worse...");
			
		Person father;
		Person mother;
		
		if(this.getSexe() == Sexe.MASC){
			father = this;
			mother = lover;
		}
		else{
			father = lover;
			mother = this;
		}
					
		Person son = new Person(firstName, father.getLastName(), sexe);
		
		mother.addRelation(son, RelationType.SON);
		father.addRelation(son, RelationType.SON);
		son.addRelation(father, RelationType.FATHER);
		son.addRelation(mother, RelationType.MOTHER);

		return son;
	}
	
	private void addRelation(Person person, RelationType relationType){
		Map<Person, RelationType> myRelations = this.getRelations();
		myRelations.put(person, relationType);		
	}
	

	public Sexe getSexe() {
		return sexe;
	}

	public void setSexe(Sexe sexe) {
		this.sexe = sexe;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public Map<Person, RelationType> getRelations() {
		return relations;
	}

	public void setRelations(Map<Person, RelationType> relations) {
		this.relations = relations;
	}

	@Override
	public String toString() {
		return String.format("Person [firstName=%s, lastName=%s, sexe=%s, relations=%s]", firstName, lastName, sexe, relations);
	}
}
