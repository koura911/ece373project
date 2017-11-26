package system.forms;

import system.people.Person;

public abstract class Form {
	private Person person;

	public Person getPerson() {
		return this.person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}
}
