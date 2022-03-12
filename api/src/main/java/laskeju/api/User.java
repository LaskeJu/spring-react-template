package laskeju.api;

public class User {

	private String firstName;

	private String lastName;

	private User(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public static User create(String firstName, String lastName) {
		if (firstName.length() < 2) {
			throw new IllegalArgumentException("The firstName must have a length of at least 2");
		}
		if (firstName.length() > 255) {
			throw new IllegalArgumentException("The firstName must have a length of maximum 255");
		}
		if (lastName.length() < 2) {
			throw new IllegalArgumentException("The lastName must have a length of at least 2");
		}
		if (lastName.length() > 255) {
			throw new IllegalArgumentException("The lastName must have a length of maximum 255");
		}

		return new User(firstName, lastName);
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

}
