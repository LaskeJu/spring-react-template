package laskeju.api;

import com.github.javafaker.Faker;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class UserTest {

	@Test
	public void Should_Create_User() {
		Faker faker = new Faker();

		String firstName = faker.name().firstName();
		String lastName = faker.name().lastName();

		User user = User.create(firstName, lastName);

		Assertions.assertSame(firstName, user.getFirstName());
		Assertions.assertSame(lastName, user.getLastName());
	}

	@Test
	public void Should_Throw_Illegal_Argument_Exception_When_First_Name_Length_Is_To_Small() {
		Faker faker = new Faker();

		Throwable exception = Assertions.assertThrows(IllegalArgumentException.class,
				() -> User.create("a", faker.name().lastName()));
		Assertions.assertEquals("The firstName must have a length of at least 2", exception.getMessage());
	}

	@Test
	public void Should_Throw_Illegal_Argument_Exception_When_First_Name_Length_Is_To_Long() {
		Faker faker = new Faker();

		Throwable exception = Assertions.assertThrows(IllegalArgumentException.class,
				() -> User.create(StringUtils.repeat('a', 256), faker.name().lastName()));
		Assertions.assertEquals("The firstName must have a length of maximum 255", exception.getMessage());
	}

	@Test
	public void Should_Throw_Illegal_Argument_Exception_When_Last_Name_Length_Is_To_Small() {
		Faker faker = new Faker();

		Throwable exception = Assertions.assertThrows(IllegalArgumentException.class,
				() -> User.create(faker.name().firstName(), "a"));
		Assertions.assertEquals("The lastName must have a length of at least 2", exception.getMessage());
	}

	@Test
	public void Should_Throw_Illegal_Argument_Exception_When_Last_Name_Length_Is_To_Long() {
		Faker faker = new Faker();

		Throwable exception = Assertions.assertThrows(IllegalArgumentException.class,
				() -> User.create(faker.name().firstName(), StringUtils.repeat('a', 256)));
		Assertions.assertEquals("The lastName must have a length of maximum 255", exception.getMessage());
	}

}
